package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practica1t.R;

public class BotonGuardarUbicaciones extends AppCompatActivity {
    Button botoncete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_guardar_ubicaciones);
        botoncete= findViewById(R.id.botoncete);
        botoncete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(BotonGuardarUbicaciones.this, GuardarUbicaciones.class);
                startActivity(i);
            }
        });
    }
}