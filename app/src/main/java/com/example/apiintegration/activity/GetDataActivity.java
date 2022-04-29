package com.example.apiintegration.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.apiintegration.R;
import com.example.apiintegration.RetrofitApi;
import com.example.apiintegration.adapter.GetDataAdapter;
import com.example.apiintegration.databinding.ActivityGetDataBinding;
import com.example.apiintegration.intrafac.ApiName;
import com.example.apiintegration.model.PostResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataActivity extends AppCompatActivity {
     private ProgressDialog progressDialog;
      ActivityGetDataBinding binding;
      GetDataAdapter getDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        GetDataActivity.this.setTitle("Post Api ");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Page Loading ");
        progressDialog.setCancelable(false);
        progressDialog.show();

        FetchDataFormServer();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }



    private void FetchDataFormServer() {

       ApiName apiName = RetrofitApi.getInstance(ApiName.class);
       Call<List<PostResponse>> call = apiName.getPostData();
       call.enqueue(new Callback<List<PostResponse>>() {
           @Override
           public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
             progressDialog.hide();

             if (response.isSuccessful() && response.code() == 200)
             {

                 List<PostResponse> postResponses = response.body();

                 for ( PostResponse postData : postResponses ){

                 //   binding.recyclerView.(postResponses)

                     getDataAdapter = new GetDataAdapter(postResponses, GetDataActivity.this);
                     binding.recyclerView.setAdapter(getDataAdapter);


                    // Log.d("DATA:", postData.getUserId()+"\n"+postData.getId()+"\n"+postData.getTitle()+"\n"+postData.getBody());


                 }
             }



           }

           @Override
           public void onFailure(Call<List<PostResponse>> call, Throwable t) {
               Toast.makeText(GetDataActivity.this, "Something Went Wrong ", Toast.LENGTH_SHORT).show();

           }
       });
    }
}