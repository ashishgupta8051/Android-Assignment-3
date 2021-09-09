package com.example.androidinternassignment.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private final CountryRepository countryRepository;

    public CountryViewModel(Application application){
        super(application);
        countryRepository = new CountryRepository();
    }

    public LiveData<List<CountryDetails>> getAllCountryOnline(){
        return countryRepository.getAllCountryOnline();
    }

}