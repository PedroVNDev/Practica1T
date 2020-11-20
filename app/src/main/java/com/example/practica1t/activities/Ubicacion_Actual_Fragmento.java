package com.example.practica1t.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica1t.R;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class Ubicacion_Actual_Fragmento extends Fragment{
    Marker marker;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView= (MapView) view.findViewById(R.id.mapa);
        marker= new Marker(mapView);

        //Intent getDataIntent = getIntent();
       // geoPointMyPosition = new GeoPoint(getDataIntent.getDoubleExtra("latitud",0),getDataIntent.getDoubleExtra("longitud",0));

        marker.setPosition(geoPointMyPosition);
    }
}
