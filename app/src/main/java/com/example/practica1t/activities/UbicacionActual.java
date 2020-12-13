package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practica1t.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.example.practica1t.common.Constantes.LATITUDE;
import static com.example.practica1t.common.Constantes.LONGITUDE;

public class UbicacionActual extends AppCompatActivity {
    private Marker marker;
    private MapView mapView;
    private GeoPoint geoPointMyPosition;
    private MapController mMapController;
    private Button boton;
    private OutputStreamWriter escritor;
    private Double latitude;
    private Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_prueba);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        boton = findViewById(R.id.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    escritor = new OutputStreamWriter(openFileOutput("UbicacionGuardada.txt", Context.MODE_PRIVATE));
                    escritor.write(latitude + ";" + longitude);
                    escritor.close();
                    Toast.makeText(getApplicationContext(), "Ubicación guardada", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mapView = (MapView) findViewById(R.id.mapa);
        marker = new Marker(mapView);

        Intent getDataIntent = getIntent();
        latitude = getDataIntent.getDoubleExtra(LATITUDE, 0);
        longitude = getDataIntent.getDoubleExtra(LONGITUDE, 0);

        geoPointMyPosition = new GeoPoint(latitude, longitude);

        generateOpenStreetMapViewAndMapController();

        addMarker(geoPointMyPosition);
    }

    public void addMarker(GeoPoint center) {
        Marker marker = new Marker(mapView);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle("Tu ubicación actual");
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