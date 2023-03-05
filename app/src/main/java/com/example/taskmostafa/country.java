package com.example.taskmostafa;

import com.google.android.gms.maps.model.LatLng;

public class country {
    String name;
    LatLng latLng;

    public country(String name, LatLng latLng) {
        this.name = name;
        this.latLng = latLng;
    }

    public country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
