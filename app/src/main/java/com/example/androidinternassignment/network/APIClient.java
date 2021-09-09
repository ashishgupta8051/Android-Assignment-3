package com.example.androidinternassignment.network;

import com.example.androidinternassignment.utils.Credentials;
import com.example.androidinternassignment.utils.DataInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static APIClient apiClient;
    private static Retrofit retrofit;

    private APIClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized APIClient getApiClient(){
        if (apiClient == null){
            apiClient = new APIClient();
        }
        return apiClient;
    }

    public DataInterface getData(){
        return retrofit.create(DataInterface.class);
    }

}
