package com.example.apiintegration.model.userresponse;

import com.google.gson.annotations.SerializedName;

public class AddressPojo {

    @SerializedName("street")
    String street;

    @SerializedName("suite")
    String suite;


    @SerializedName("city")
    String city;
    @SerializedName("zipcode")
    String zipcode;

    @SerializedName("geo")
    GeoPojo geoPojoData;


    public GeoPojo getGeoPojoData() {
        return geoPojoData;
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
