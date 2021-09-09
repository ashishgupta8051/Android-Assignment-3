package com.example.androidinternassignment.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.network.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {
    private MutableLiveData<List<CountryDetails>> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<CountryDetails>> getAllCountryOnline(){
        Call<List<CountryDetails>> call = APIClient.getApiClient().getData().getCountryName();

        call.enqueue(new Callback<List<CountryDetails>>() {
            @Override
            public void onResponse(Call<List<CountryDetails>> call, Response<List<CountryDetails>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryDetails>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });

        return mutableLiveData;
    }

}
