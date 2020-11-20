package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.practica1t.R;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import static com.example.practica1t.common.Constantes.LATITUDE;
import static com.example.practica1t.common.Constantes.LONGITUDE;

public class MapaPruebaActivity extends AppCompatActivity {
    Marker marker;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    private MapController mMapController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_prueba);

        mapView= (MapView) findViewById(R.id.mapa);
        marker= new Marker(mapView);

        Intent getDataIntent = getIntent();
        geoPointMyPosition = new GeoPoint(getDataIntent.getDoubleExtra(LATITUDE,40.4167),getDataIntent.getDoubleExtra(LONGITUDE,-3.70325));

        generateOpenStreetMapViewAndMapController();

        marker.setPosition(geoPointMyPosition);
    }

    public void generateOpenStreetMapViewAndMapController(){
        mapView = (MapView) findViewById(R.id.mapa);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mMapController = (MapController) mapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}