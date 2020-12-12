package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.practica1t.R;
import com.example.practica1t.common.FavoritosObjeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ListView listView;
    InputStreamReader flujo;
    BufferedReader lector;
    String texto;
    ArrayList<String> nombres;
    ArrayList<String> fichero;
    int auxiliar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        listView = findViewById(R.id.listView);
        nombres = new ArrayList<>();
        fichero = new ArrayList<>();
        leerFichero();

        listView = findViewById(R.id.favoritos);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.adapter_favoritos, R.id.favoritosTextView, nombres);
        listView.setAdapter(adapter);

    }

    public void leerFichero() {
        try {

            flujo = new InputStreamReader(openFileInput("favoritos.txt"));
            lector = new BufferedReader(flujo);
            texto = lector.readLine();
            lector.close();
            flujo.close();
            String[] nombres2 = texto.split(" . ");
            for (String nombres1 : nombres2) {
                if (auxiliar == 0) {
                    nombres.add(nombres1);
                }
                auxiliar++;
                if (auxiliar == 3) {
                    auxiliar = 0;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

