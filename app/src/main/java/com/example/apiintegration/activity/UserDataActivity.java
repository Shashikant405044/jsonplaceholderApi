package com.example.apiintegration.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import com.example.apiintegration.RetrofitApi;
import com.example.apiintegration.adapter.UsersAdapter;
import com.example.apiintegration.databinding.ActivityUserDataBinding;
import com.example.apiintegration.intrafac.ApiName;
import com.example.apiintegration.model.userresponse.UsersResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class UserDataActivity extends AppCompatActivity {
    ActivityUserDataBinding binding;
    ProgressDialog progressDialog;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        UserDataActivity.this.setTitle("UserData");
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Page Lading");
        progressDialog.setCancelable(false);
        progressDialog.show();
        usersDataFatch();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerViewLayout.setLayoutManager(layoutManager);
    }
    private void usersDataFatch() {
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<UsersResponse>> call = apiName.getUsersData();

        call.enqueue(new Callback<List<UsersResponse>>() {
          @Override
          public void onResponse(Call<List<UsersResponse>> call, Response<List<UsersResponse>> response) {
              progressDialog.hide();
              if (response.isSuccessful() && response.code() == 200)
              {
                 List<UsersResponse> usersResponse = response.body();
                 for ( UsersResponse usersData : usersResponse)
                     progressDialog.hide();

                 usersAdapter = new UsersAdapter(UserDataActivity.this,usersResponse);
                 binding.recyclerViewLayout.setAdapter(usersAdapter);
                //  Log.d("DATA:", "\n"+usersData.getWebsite()+"\n"+usersData.getEmail());


              }
          }

          @Override
          public void onFailure(Call<List<UsersResponse>> call, Throwable t) {
              Toast.makeText(UserDataActivity.this, "Somthing wwrong", Toast.LENGTH_SHORT).show();

          }
      });
    }
}