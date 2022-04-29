package com.example.apiintegration.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.apiintegration.RetrofitApi;
import com.example.apiintegration.adapter.PhotosAdapter;
import com.example.apiintegration.databinding.ActivityPhotosBinding;
import com.example.apiintegration.intrafac.ApiName;
import com.example.apiintegration.model.PhotosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
   ProgressDialog progressDialog;

    ActivityPhotosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
         progressDialog = new ProgressDialog(this);
         progressDialog.setCancelable(false);
         progressDialog.setTitle("Page Loading");
         progressDialog.show();
        getPhotosData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    private void getPhotosData() {

        ApiName apiName =  RetrofitApi.getInstance(ApiName.class);
           Call<List<PhotosResponse>> call = apiName.getPhotosData();
           call.enqueue(new Callback<List<PhotosResponse>>() {
               @Override
               public void onResponse(Call<List<PhotosResponse>> call, Response<List<PhotosResponse>> response) {
                 progressDialog.hide();
                   if (response.isSuccessful() && response.code() == 200)
                   {

                       List<PhotosResponse> photosResponses  =   response.body();
                       for (PhotosResponse photoData :photosResponses)
                       {

                           PhotosAdapter photosAdapter = new PhotosAdapter(PhotosActivity.this,photosResponses);
                           binding.recyclerView.setAdapter(photosAdapter);

                       }
                   }

               }

               @Override
               public void onFailure(Call<List<PhotosResponse>> call, Throwable t) {

                 progressDialog.hide();
                   Toast.makeText(PhotosActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
               }
           });

    }
}