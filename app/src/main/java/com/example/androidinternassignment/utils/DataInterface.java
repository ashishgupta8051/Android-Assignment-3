package com.example.androidinternassignment.utils;

import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.model.Language;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInterface {

    @GET("region/asia")
    Call<List<CountryDetails>> getCountryName();

}
