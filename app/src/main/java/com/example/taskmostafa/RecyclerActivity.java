package com.example.taskmostafa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.taskmostafa.databinding.ActivityRecycelBinding;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    ActivityRecycelBinding binding;
    ArrayList<country> country;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityRecycelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        country = new ArrayList<>();
        country.add(new country("palestine",new LatLng(31.9474,35.2272)));
        country.add(new country("egypt",new LatLng(26.549999,31.700001)));
        country.add(new country("turkey",new LatLng(38.9573,35.2407)));
        country.add(new country("Jordan",new LatLng(31.963158,35.930359)));
        country.add(new country("Libya",new LatLng(32.885353,13.180161)));
        country.add(new country("Dubai",new LatLng(25.276987,55.296249)));

        myAdapter = new MyAdapter(country, new MyListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                double lat = country.get(position).latLng.latitude;
                double lng = country.get(position).latLng.longitude;
                intent.putExtra("lat",lat);
                intent.putExtra("lng",lng);
                startActivity(intent);
            }
        });
        binding.MainRecycler.setAdapter(myAdapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(RecyclerActivity.this,
                RecyclerView.VERTICAL, false);
        binding.MainRecycler.setLayoutManager(lm);
    }
}