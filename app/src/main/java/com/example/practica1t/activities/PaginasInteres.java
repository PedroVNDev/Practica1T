package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practica1t.R;

import static com.example.practica1t.common.Constantes.PAGINA_INTERES_1;
import static com.example.practica1t.common.Constantes.PAGINA_INTERES_2;
import static com.example.practica1t.common.Constantes.PAGINA_INTERES_3;
import static com.example.practica1t.common.Constantes.PAGINA_INTERES_4;
import static com.example.practica1t.common.Constantes.PAGINA_INTERES_5;

public class PaginasInteres extends AppCompatActivity {

    private Boolean focus = true;
    private ListView listView;
    private WebView mWebView;
    private String linkAuxiliar;
    private String[] nombres = {"Información Piscinas Madrid", "Preguntas frecuentes Piscinas Madrid", "Deportes temas de interes", "Información a usuarios de centros deportivos", "Informacion deporte COVID"};
    private String[] links = {PAGINA_INTERES_1, PAGINA_INTERES_2, PAGINA_INTERES_3, PAGINA_INTERES_4, PAGINA_INTERES_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginas_interes);


        listView = findViewById(R.id.listInteres);


        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.adaptador_paginas_interes, R.id.paginasInteres, nombres);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                focus = false;
                System.out.println("boleano en:" + focus);
                setContentView(R.layout.webview_interes);
                mWebView = findViewById(R.id.webview);
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.getSettings().setJavaScriptEnabled(true);
                mWebView.getSettings().setAppCacheEnabled(true);
                mWebView.loadUrl((String) links[position]);


            }


        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (focus == false) {
            Intent intentInteres = new Intent(PaginasInteres.this, PaginasInteres.class);
            startActivity(intentInteres);
            Toast.makeText(this, "Estas en Paginas de interes", Toast.LENGTH_LONG).show();
            focus = true;
        } else {

        }

    }
}