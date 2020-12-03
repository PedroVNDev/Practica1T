package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.practica1t.R;
import com.example.practica1t.common.Location;

import java.util.ArrayList;

public class GuardarUbicaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_ubicaciones);
        ArrayList<Location> arrayLocation= new ArrayList();
        arrayLocation= getIntent().getExtras().getParcelableArrayList("array");
        Log.d("MyActivity", String.valueOf(arrayLocation.get(0).getAltitude()));
    }
}