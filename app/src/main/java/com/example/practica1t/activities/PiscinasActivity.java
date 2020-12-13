package com.example.practica1t.activities;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practica1t.Jsons.JsonPiscinas;
import com.example.practica1t.R;
import com.example.practica1t.common.AdaptadorPiscinas;
import com.example.practica1t.common.Location;
import com.example.practica1t.common.Piscinas;
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

public class PiscinasActivity extends AppCompatActivity {
    Marker marker;
    ArrayList<Marker> listaMarkers;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    GeoPoint center;
    private MapController mMapController;
    ArrayList<Piscinas> localizaciones;
    AdaptadorPiscinas mPiscinaAdapter;
    private Double latitude;
    private Double longitude;
    private InputStreamReader flujo;
    private BufferedReader lector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscinas);

        leerFichero();
        listaMarkers = new ArrayList<Marker>();
        localizaciones = new ArrayList();

        // ESTO GENERA EL MAPA
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        geoPointMyPosition = new GeoPoint(latitude, longitude);

        mapView = (MapView) findViewById(R.id.mapaPiscinas);


        generateOpenStreetMapViewAndMapController();


        getPiscinas();

    }


    public void getPiscinas() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_MADRID)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonService apiPiscinas = retrofit.create(JsonService.class);

        apiPiscinas.getPiscinaLocation(latitude, longitude, DISTANCIA).enqueue(new Callback<JsonPiscinas>() {

            @Override
            public void onResponse(Call<JsonPiscinas> call, Response<JsonPiscinas> response) {
                if (response != null && response.body() != null) {
                    localizaciones = (ArrayList<Piscinas>) response.body().results;

                    mPiscinaAdapter = new AdaptadorPiscinas(PiscinasActivity.this, localizaciones);
                    mPiscinaAdapter.notifyDataSetChanged();

                    for (Piscinas p : localizaciones) {
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
            public void onFailure(Call<JsonPiscinas> call, Throwable t) {
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

        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mMapController = (MapController) mapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}
