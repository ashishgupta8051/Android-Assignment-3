package com.example.androidinternassignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidinternassignment.adapter.CustomAdapter;
import com.example.androidinternassignment.client.APIClient;
import com.example.androidinternassignment.model.CountryDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<CountryDetails> arrayList;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();

        Call<List<CountryDetails>> call = APIClient.getApiClient().getData().getCountryName();

        call.enqueue(new Callback<List<CountryDetails>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<List<CountryDetails>> call, Response<List<CountryDetails>> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    arrayList = response.body();
                    customAdapter = new CustomAdapter(MainActivity.this,arrayList);
                    recyclerView.setAdapter(customAdapter);
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Something is wrong !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CountryDetails>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Failed !!!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}