package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.practica1t.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    //Clase que muestra el logo de la aplicación antes de cargar la aplicacion
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentSplash = new Intent(this, MainActivity.class);
        startActivity(intentSplash);
        finish();
    }
}