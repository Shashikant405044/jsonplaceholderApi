package com.example.apiintegration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
  // public static final String BASE_URL = "https://api.unsplash.com";

    public static <S> S getInstance(Class<S> serviceClass){

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(serviceClass);

    }

}
