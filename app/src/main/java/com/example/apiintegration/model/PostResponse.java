package com.example.apiintegration.model;

import com.google.gson.annotations.SerializedName;

public class PostResponse {
    @SerializedName("userId")
    String userId;
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
