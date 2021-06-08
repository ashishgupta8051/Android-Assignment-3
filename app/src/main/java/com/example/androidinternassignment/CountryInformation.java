package com.example.androidinternassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class CountryInformation extends AppCompatActivity {
    private TextView name,capital,region,subregion,population,border,languageName,nativeLangName,one,two;
    private String borders;
    private List<String> nameList;
    private List<String> nativeNameList;
    private List<String> get1List;
    private List<String> get2List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);

        name = findViewById(R.id.countryName);
        capital = findViewById(R.id.capital);
        region = findViewById(R.id.region);
        subregion = findViewById(R.id.subregion);
        population = findViewById(R.id.population);
        border = findViewById(R.id.border);
        languageName = findViewById(R.id.languageName);
        nativeLangName = findViewById(R.id.nativelanguageName);
        one = findViewById(R.id.iso639_1);
        two = findViewById(R.id.iso639_2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null){
            name.setText(extras.getString("name"));
            capital.setText(extras.getString("capital"));
            region.setText(extras.getString("region"));
            subregion.setText(extras.getString("subregion"));
            population.setText(extras.getString("population"));
            border.setText(extras.getString("borders"));
            nameList = Collections.singletonList(extras.getString("lname"));
            nativeNameList = Collections.singletonList(extras.getString("nativeName"));
            get1List = Collections.singletonList(extras.getString("get1"));
            get2List = Collections.singletonList(extras.getString("get2"));
            for (String d : nameList){
//                Log.e("D",d);
                languageName.setText(d);
            }
            for (String d : nativeNameList){
//                Log.e("D",d);
                nativeLangName.setText(d);
            }
            for (String d : get1List){
//                Log.e("D",d);
                one.setText(d);
            }
            for (String d : get2List){
//                Log.e("D",d);
                two.setText(d);
            }
        }else {
            Log.d("Details","Empty Details");
        }
    }
}