package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practica1t.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BotonGuardarUbicaciones extends AppCompatActivity {
    private Button botoncete;
    private double latitude;
    private double longitude;
    private InputStreamReader flujo;
    private BufferedReader lector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boton_guardar_ubicaciones);

        leerFichero();

        botoncete = findViewById(R.id.botoncete);
        botoncete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (latitude == 0 && longitude == 0) {
                    Toast.makeText(getApplicationContext(), "No guardaste la ubicacion", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(BotonGuardarUbicaciones.this, GuardarUbicaciones.class);
                    startActivity(i);
                }
            }
        });
    }

    public void leerFichero() {
        try {
            flujo = new InputStreamReader(openFileInput("UbicacionGuardada.txt"));
            lector = new BufferedReader(flujo);
            String texto = lector.readLine();
            lector.close();
            flujo.close();
            String[] coords = texto.split(";");
            String latitud = coords[0];
            String longitud = coords[1];
            latitude = Double.parseDouble(latitud);
            longitude = Double.parseDouble(longitud);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}