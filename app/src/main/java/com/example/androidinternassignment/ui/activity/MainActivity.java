package com.example.androidinternassignment.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.androidinternassignment.adapter.CountryAdapter;
import com.example.androidinternassignment.databinding.ActivityMainBinding;
import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.model.Language;
import com.example.androidinternassignment.network.ConnectionLiveData;
import com.example.androidinternassignment.network.ConnectionModel;
import com.example.androidinternassignment.utils.CountryListener;
import com.example.androidinternassignment.viewmodel.CountryViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryListener {
    private ActivityMainBinding binding;
    private CountryViewModel countryViewModel;
    private ConnectionLiveData connectionLiveData;
    private List<String> name = new ArrayList<>();
    private List<String> nativeName = new ArrayList<>();
    private List<String> get1 = new ArrayList<>();
    private List<String> get2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        countryViewModel = new ViewModelProvider(this).get(CountryViewModel.class);
        connectionLiveData = new ConnectionLiveData(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkInternetConnection();
    }

    private void checkInternetConnection() {
        connectionLiveData.observe(this, new Observer<ConnectionModel>() {
            @Override
            public void onChanged(ConnectionModel connectionModel) {
                if (connectionModel.isConnected()){
                    getAllCountryOnline();
                }else {
                    Toast.makeText(getApplicationContext(), "Not Connected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getAllCountryOnline() {
        countryViewModel.getAllCountryOnline().observe(this,response ->{
            binding.recyclerview.setHasFixedSize(true);
            binding.progress.setVisibility(View.GONE);
            CountryAdapter countryAdapter = new CountryAdapter(this,this);
            countryAdapter.getCountryDetails(response);
            binding.recyclerview.setAdapter(countryAdapter);
        });
    }

    @Override
    public void onClick(CountryDetails countryDetails) {
        Intent intent = new Intent(getApplicationContext(), CountryInformation.class);
        intent.putExtra("name",countryDetails.getName());
        intent.putExtra("capital",countryDetails.getCapital());
        intent.putExtra("region",countryDetails.getRegion());
        intent.putExtra("subregion",countryDetails.getSubregion());
        intent.putExtra("population",String.valueOf(countryDetails.getPopulation()));
        intent.putExtra("borders",String.valueOf(countryDetails.getBorders()));

        for (int i = 0; i < countryDetails.getLanguages().size(); i++){
            Language language = countryDetails.getLanguages().get(i);
            name.add(language.getName());
            nativeName.add(language.getNativeName());
            get1.add(language.getIso639_1());
            get2.add(language.getIso639_2());
            intent.putExtra("lname", String.valueOf(name));
            intent.putExtra("nativeName", String.valueOf(nativeName));
            intent.putExtra("get1", String.valueOf(get1));
            intent.putExtra("get2", String.valueOf(get2));
        }
        startActivity(intent);
    }
}