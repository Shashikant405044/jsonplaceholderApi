package com.example.apiintegration.intrafac;

import com.example.apiintegration.model.CommentsResponse;
import com.example.apiintegration.model.PhotosResponse;
import com.example.apiintegration.model.PostResponse;
import com.example.apiintegration.model.userresponse.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiName {

@GET("/posts")
    Call<List<PostResponse>> getPostData();

@GET("/comments")
    Call<List<CommentsResponse>> getAllComment();

@GET("/users")
    Call<List<UsersResponse>> getUsersData();

@GET("/photos")
    Call<List<PhotosResponse>> getPhotosData();


}
