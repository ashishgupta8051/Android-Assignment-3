package com.example.androidinternassignment.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidinternassignment.CountryInformation;
import com.example.androidinternassignment.MainActivity;
import com.example.androidinternassignment.R;
import com.example.androidinternassignment.client.APIClient;
import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.model.Language;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder>{
    private Activity activity;
    private List<CountryDetails> countryDetailsList;
    private List<String> name = new ArrayList<>();
    private List<String> nativeName = new ArrayList<>();
    private List<String> get1 = new ArrayList<>();
    private List<String> get2 = new ArrayList<>();

    public CustomAdapter(Activity activity, List<CountryDetails> countryDetailsList) {
        this.activity = activity;
        this.countryDetailsList = countryDetailsList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.Holder holder, int position) {
        CountryDetails countryDetails = countryDetailsList.get(position);
        holder.textView.setText(countryDetails.getmName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CountryInformation.class);
                intent.putExtra("name",countryDetails.getmName());
                intent.putExtra("capital",countryDetails.getmCapital());
                intent.putExtra("region",countryDetails.getmRegion());
                intent.putExtra("subregion",countryDetails.getmSubregion());
                intent.putExtra("population",String.valueOf(countryDetails.getmPopulation()));
                intent.putExtra("borders",countryDetails.getBorders().toString());

                for (int i = 0; i < countryDetails.getLanguages().size(); i++){
                    Language language = countryDetails.getLanguages().get(i);
                    name.add(language.getName());
                    nativeName.add(language.getNativeName());
                    get1.add(language.getIso6391());
                    get2.add(language.getIso6392());
                    intent.putExtra("lname", String.valueOf(name));
                    intent.putExtra("nativeName", String.valueOf(nativeName));
                    intent.putExtra("get1", String.valueOf(get1));
                    intent.putExtra("get2", String.valueOf(get2));
                }
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryDetailsList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageFlag);
            textView = itemView.findViewById(R.id.tvCountryName);
        }
    }
}
