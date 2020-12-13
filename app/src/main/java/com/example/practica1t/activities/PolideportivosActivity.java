package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

import com.example.practica1t.R;
import com.example.practica1t.common.AdaptadorPolideportivos;
import com.example.practica1t.Jsons.JsonPolideportivos;
import com.example.practica1t.common.Location;
import com.example.practica1t.common.Polideportivos;
import com.example.practica1t.services.JsonService;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.practica1t.common.Constantes.DISTANCIA;
import static com.example.practica1t.common.Constantes.URL_MADRID;

public class PolideportivosActivity extends AppCompatActivity {
    Marker marker;
    ArrayList<Marker> listaMarkers;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    GeoPoint center;
    private MapController mMapController;
    ArrayList<Polideportivos> localizaciones;
    AdaptadorPolideportivos mCentroAdapter;
    private Double latitude;
    private Double longitude;
    private InputStreamReader flujo;
    private BufferedReader lector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polideportivos);

        leerFichero();
        listaMarkers = new ArrayList<>();
        localizaciones = new ArrayList();

        // ESTO GENERA EL MAPA
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        geoPointMyPosition = new GeoPoint(latitude, longitude);

        mapView = (MapView) findViewById(R.id.mapa);


        generateOpenStreetMapViewAndMapController();


        getPiscinas();

    }


    public void getPiscinas() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_MADRID)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonService apiPiscinas = retrofit.create(JsonService.class);

        apiPiscinas.getPolideportivoLocation(latitude, longitude, DISTANCIA).enqueue(new Callback<JsonPolideportivos>() {

            @Override
            public void onResponse(Call<JsonPolideportivos> call, Response<JsonPolideportivos> response) {
                if (response != null && response.body() != null) {
                    localizaciones = (ArrayList<Polideportivos>) response.body().results;


                    mCentroAdapter = new AdaptadorPolideportivos(PolideportivosActivity.this, localizaciones);
                    //listView.setAdapter(mCentroAdapter);
                    mCentroAdapter.notifyDataSetChanged();

                    for (Polideportivos p : localizaciones) {
                        center = new GeoPoint(p.getLocation().getLatitude(), p.getLocation().getAltitude());

                        marker = new Marker(mapView);
                        marker.setPosition(center);
                        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                        marker.setTitle(p.getName());
                        mapView.getOverlays().add(marker);
                        mapView.invalidate();
                    }

                }

            }

            @Override
            public void onFailure(Call<JsonPolideportivos> call, Throwable t) {
                System.out.println("failure");
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

    public void generateOpenStreetMapViewAndMapController() {
        // ESTO ESTA COPIADO Y PEGADO PERO HE VISTO POR INTERNET QUE HAY MIL MOVIDAS PARA PERSONALIZAR ESTO CUANDO TERMINEMOS ME MOLARIA ECHARLE UN OJO
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mMapController = (MapController) mapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}