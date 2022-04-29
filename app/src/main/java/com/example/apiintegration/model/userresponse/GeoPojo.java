package com.example.apiintegration.model.userresponse;

import com.google.gson.annotations.SerializedName;

public class GeoPojo {


    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;


    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
