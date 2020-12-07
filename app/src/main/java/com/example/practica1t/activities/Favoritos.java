package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.practica1t.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Favoritos extends AppCompatActivity {
    ListView listView;
    OutputStreamWriter escritor;
    InputStreamReader flujo;
    BufferedReader lector;
    String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        listView= findViewById(R.id.listView);
        leerFichero();
    }
    public void escribirFichero(Double latitude, Double longitude, String nombre){
        try {
            escritor=new OutputStreamWriter(openFileOutput("favoritos.txt", Context.MODE_PRIVATE));
            if(texto!=null){

            }
            escritor.write(nombre+" ; "+latitude+" ; "+longitude+" . ");
            escritor.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerFichero(){
        try {
            flujo= new InputStreamReader(openFileInput("favoritos.txt"));
            lector= new BufferedReader(flujo);
            texto = lector.readLine();
            lector.close();
            flujo.close();
            System.out.println(texto);
            String[] nombres= texto.split(" . ");
            for(String nombres1: nombres){
                System.out.println(nombres1+"    ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}