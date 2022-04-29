package com.example.apiintegration.model.userresponse;

import com.google.gson.annotations.SerializedName;

public class CompanyPojo {
    @SerializedName("name")
    String name;
    @SerializedName("catchPhrase")
    String catchPhrase;
    @SerializedName("bs")
    String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}

