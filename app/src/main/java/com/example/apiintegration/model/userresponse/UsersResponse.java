package com.example.apiintegration.model.userresponse;

import com.google.gson.annotations.SerializedName;

public class UsersResponse {

    @SerializedName("id")
    String idData;


    @SerializedName("name")
    String name;

    @SerializedName("username")
    String username;

    @SerializedName("email")
    String email;

    @SerializedName("address")
    AddressPojo addressPojoData;


    @SerializedName("phone")
    String phone;

    @SerializedName("website")
    String website;

   @SerializedName("company")
    CompanyPojo companyPojoData;




    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddressPojo getAddressPojoData() {
        return addressPojoData;
    }



    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public CompanyPojo getCompanyPojoData() {
        return companyPojoData;
    }

    public String getIdData() {
        return idData;
    }
}
