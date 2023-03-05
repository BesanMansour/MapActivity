package com.example.taskmostafa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.taskmostafa.databinding.ItemBinding;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.countryViewHolder> {
    ArrayList<country> countries;
    MyListener myListener;

    public MyAdapter(ArrayList<country> countries, MyListener myListener) {
        this.countries = countries;
        this.myListener = myListener;
    }

    @NonNull
    @Override
    public countryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new countryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull countryViewHolder holder, int position) {

        country country = countries.get(holder.getAdapterPosition());
        holder.name.setText(country.getName());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class countryViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        Button btn;

        public countryViewHolder(ItemBinding binding) {
            super(binding.getRoot());

            name = binding.country;
            btn= binding.btn;

        }
    }
}
