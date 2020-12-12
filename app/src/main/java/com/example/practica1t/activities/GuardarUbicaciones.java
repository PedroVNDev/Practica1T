package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.practica1t.R;
import com.example.practica1t.common.Location;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.practica1t.common.Constantes.LATITUDE;
import static com.example.practica1t.common.Constantes.LONGITUDE;

public class GuardarUbicaciones extends AppCompatActivity {
    InputStreamReader flujo;
    BufferedReader lector;
    MapView mapView;
    Marker marker;
    GeoPoint geoPointMyPosition;
    Double latitude;
    Double longitude;
    private MapController mMapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_ubicaciones);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        leerFichero();

        mapView = (MapView) findViewById(R.id.mapa);
        marker = new Marker(mapView);


        geoPointMyPosition = new GeoPoint(latitude, longitude);

        generateOpenStreetMapViewAndMapController();

        addMarker(geoPointMyPosition);
    }

    public void leerFichero() {
        try {
            flujo = new InputStreamReader(openFileInput("pruebaFichero.txt"));
            lector = new BufferedReader(flujo);
            String texto = lector.readLine();
            lector.close();
            flujo.close();
            String[] coords = texto.split(";");
            String latitud = coords[0];
            String altitud = coords[1];
            latitude = Double.parseDouble(latitud);
            longitude = Double.parseDouble(altitud);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addMarker(GeoPoint center) {
        Marker marker = new Marker(mapView);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle("Esta es la ultima ubicacion que guardaste");
        mapView.getOverlays().clear();
        mapView.getOverlays().add(marker);
        mapView.invalidate();
    }

    public void generateOpenStreetMapViewAndMapController() {
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mMapController = (MapController) mapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}