package com.example.androidinternassignment.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidinternassignment.R;
import com.example.androidinternassignment.databinding.ActivityCountryInformationBinding;
import com.example.androidinternassignment.model.CountryDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryInformation extends AppCompatActivity {
    private ActivityCountryInformationBinding binding;
    private String border;
    private List<String> borderList = new ArrayList<>();
    private List<String> nameList;
    private List<String> nativeNameList;
    private List<String> get1List;
    private List<String> get2List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

         if (extras != null){
            binding.countryName.setText(extras.getString("name"));
            binding.capital.setText(extras.getString("capital"));
            binding.region.setText(extras.getString("region"));
            binding.subregion.setText(extras.getString("subregion"));
            binding.population.setText(extras.getString("population"));
            borderList = Collections.singletonList(extras.getString("borders"));
            binding.border.setText(borderList.toString()
                    .replace("[","")
                    .replace("]",""));

             nameList = Collections.singletonList(extras.getString("lname"));
             nativeNameList = Collections.singletonList(extras.getString("nativeName"));
             get1List = Collections.singletonList(extras.getString("get1"));
             get2List = Collections.singletonList(extras.getString("get2"));
             for (String d : nameList){
                 binding.languageName.setText(d
                         .replace("[","")
                         .replace("]",""));
             }
             for (String d : nativeNameList){
                 binding.nativelanguageName.setText(d
                         .replace("[","")
                         .replace("]",""));
             }
             for (String d : get1List){
                 binding.iso1.setText(d
                         .replace("[","")
                         .replace("]",""));
             }
             for (String d : get2List){
                 binding.iso2.setText(d
                         .replace("[","")
                         .replace("]",""));
             }
        }else {
            Log.d("Details","Empty Details");
        }
    }
}