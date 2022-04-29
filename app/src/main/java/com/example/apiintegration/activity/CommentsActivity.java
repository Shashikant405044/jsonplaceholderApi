package com.example.apiintegration.activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.example.apiintegration.RetrofitApi;
import com.example.apiintegration.adapter.CommentAdapter;
import com.example.apiintegration.databinding.ActivityCommentsBinding;
import com.example.apiintegration.intrafac.ApiName;
import com.example.apiintegration.model.CommentsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {
    ActivityCommentsBinding binding;
     CommentAdapter commentAdapter;

     ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CommentsActivity.this.setTitle("Comment Api ");
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Page Loading ");
        progressDialog.setCancelable(false);
        progressDialog.show();

        FatchCommentData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.commentRecycler.setLayoutManager(layoutManager);



    }

    private void FatchCommentData() {


        ApiName apiName  = RetrofitApi.getInstance(ApiName.class);
        Call<List<CommentsResponse>> call = apiName.getAllComment();

        call.enqueue(new Callback<List<CommentsResponse>>() {
            @Override
            public void onResponse(Call<List<CommentsResponse>> call, Response<List<CommentsResponse>> response) {
                 progressDialog.hide();
                if (response.isSuccessful() && response.code() == 200)
                {

                    List<CommentsResponse> commentsResponses = response.body();


                    for (CommentsResponse commentData: commentsResponses)
                    {
                        commentAdapter = new CommentAdapter(CommentsActivity.this,commentsResponses);
                        binding.commentRecycler.setAdapter(commentAdapter);
                    }
                }


            }

            @Override
            public void onFailure(Call<List<CommentsResponse>> call, Throwable t) {

            }
        });

    }


}