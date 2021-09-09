package com.example.androidinternassignment.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidinternassignment.R;
import com.example.androidinternassignment.databinding.CountryListBinding;
import com.example.androidinternassignment.model.CountryDetails;
import com.example.androidinternassignment.utils.CountryListener;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.Holder> {
    private Activity activity;
    private CountryListener countryListener;
    private ArrayList<CountryDetails> countryDetailsList = new ArrayList<>();

    public CountryAdapter(Activity activity,CountryListener countryListener) {
        this.activity = activity;
        this.countryListener = countryListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ListBinding binding = ListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        CountryListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.country_list,parent,false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.Holder holder, int position) {
        CountryDetails countryDetails = countryDetailsList.get(position);

        holder.binding.tvCountryName.setText(countryDetails.getName());
        holder.bindData(countryDetailsList.get(position));
        GlideToVectorYou.init().with(activity).withListener(new GlideToVectorYouListener() {
            @Override
            public void onLoadFailed() {
                holder.binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onResourceReady() {
                holder.binding.progressBar.setVisibility(View.GONE);
            }
        }).load(Uri.parse(countryDetails.getFlag()), holder.binding.imageFlag);


    }

    @SuppressLint("NotifyDataSetChanged")
    public void getCountryDetails(List<CountryDetails> list){
        countryDetailsList.clear();
        countryDetailsList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return countryDetailsList.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        CountryListBinding binding;
        public Holder(CountryListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(CountryDetails countryDetails){
            binding.setCountryDetails(countryDetails);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(view -> countryListener.onClick(countryDetails));
        }
    }
}
