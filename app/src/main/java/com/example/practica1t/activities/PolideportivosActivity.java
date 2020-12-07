package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.practica1t.common.Constantes.URL_MADRID;

public class PolideportivosActivity extends AppCompatActivity {
    Marker marker;
    ArrayList<Marker> listaMarkers;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    GeoPoint center;
    private MapController mMapController;
    ArrayList<Polideportivos> localizaciones;
    ListView listView;
    AdaptadorPolideportivos mCentroAdapter;
    String auxiliar;
    ArrayList<Location> locations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_polideportivos);
        //listView= findViewById(R.id.centros);
        listaMarkers= new ArrayList<Marker>();
        localizaciones= new ArrayList();
        // ESTO GENERA EL MAPA
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        geoPointMyPosition= new GeoPoint(40.4167,-3.70325);

        mapView= (MapView) findViewById(R.id.mapa);


        generateOpenStreetMapViewAndMapController();


        getPiscinas();

    }


    public void getPiscinas() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_MADRID)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonService apiPiscinas = retrofit.create(JsonService.class);

            apiPiscinas.getPolideportivoLocation(40.4167, -3.70325, 4000).enqueue(new Callback<JsonPolideportivos>() {

                @Override
                public void onResponse(Call<JsonPolideportivos> call, Response<JsonPolideportivos> response) {
                    if (response != null && response.body() != null) {
                        localizaciones = (ArrayList<Polideportivos>) response.body().results;


                        mCentroAdapter = new AdaptadorPolideportivos(PolideportivosActivity.this, localizaciones);
                        //listView.setAdapter(mCentroAdapter);
                        mCentroAdapter.notifyDataSetChanged();

                        for(Polideportivos p: localizaciones){
                            center= new GeoPoint(p.getLocation().getLatitude(),p.getLocation().getAltitude());

                            marker= new Marker(mapView);
                            marker.setPosition(center);
                            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                            marker.setTitle(p.getName());
                            //mapView.getOverlays().clear();
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

    public void addMarker (GeoPoint center){

    }

    public void generateOpenStreetMapViewAndMapController(){
        // ESTO ESTA COPIADO Y PEGADO PERO HE VISTO POR INTERNET QUE HAY MIL MOVIDAS PARA PERSONALIZAR ESTO CUANDO TERMINEMOS ME MOLARIA ECHARLE UN OJO
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mMapController = (MapController) mapView.getController();
        mMapController.setZoom(18);
        mMapController.setCenter(geoPointMyPosition);
    }
}