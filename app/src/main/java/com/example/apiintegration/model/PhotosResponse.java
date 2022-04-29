package com.example.apiintegration.model;

import com.google.gson.annotations.SerializedName;

public class PhotosResponse {

    @SerializedName("albumId")
    String albumId;
    @SerializedName("id")
    String id;

    @SerializedName("url")
    String url;

    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    @SerializedName("title")
    String title;

    public String getTitle() {
        return title;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getId() {
        return id;
    }


    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
