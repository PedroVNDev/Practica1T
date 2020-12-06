package com.example.practica1t.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;

import com.example.practica1t.R;
import com.example.practica1t.common.AdaptadorPolideportivos;
import com.example.practica1t.common.JsonPolideportivos;
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

import static com.example.practica1t.common.Constantes.LATITUDE;
import static com.example.practica1t.common.Constantes.LONGITUDE;
import static com.example.practica1t.common.Constantes.URL_MADRID;

public class InstalacionesDeportivas extends AppCompatActivity {
    Marker marker;
    MapView mapView;
    GeoPoint geoPointMyPosition;
    private MapController mMapController;
    ArrayList<Polideportivos> localizaciones;
    ListView listView;
    AdaptadorPolideportivos mCentroAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_instalaciones_deportivas);
        listView= findViewById(R.id.centrosLista);

        localizaciones= new ArrayList();
        /*
        // ESTO GENERA EL MAPA
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));


        mapView= (MapView) findViewById(R.id.mapa);
        marker= new Marker(mapView);

        // ESTE INTENT LO USE PARA PASAR DEL MAIN A ESTA ACTIVITY LA LOCALIZACION, TU TENDRAS QUE RECIBIR ESTO DE LA API (YO HARIA OTRO METODO)
        Intent getDataIntent = getIntent();
        // LE HE PUESTO DEFAULT LATITUD Y ALTITUD DE MADRID PARA VER QUE CARGABA EL MAPA
        geoPointMyPosition = new GeoPoint(getDataIntent.getDoubleExtra(LATITUDE,40.4167),getDataIntent.getDoubleExtra(LONGITUDE,-3.70325));

        generateOpenStreetMapViewAndMapController();

        //ESTO ES LO QUE GENERA EL PUNTO DE LA LOCALIZACION (PUEDES HACER VARIOS YO DIRIA QUE CON UN FOR DE ARRAY.LENGTH SI CARGAS ARRAY DE LA API NO DARA FALLO
        addMarker(geoPointMyPosition);*/

        getPiscinas();

    }
    // ESTE METODO AGREGA EL MARKER (SE LE PUEDE PONER UNA BREVE DESCIPCION SI EN LA API HAY PUEDE QUEDAR GUAPO)
    public void addMarker (GeoPoint center){
        Marker marker= new Marker(mapView);
        marker.setPosition(center);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().clear();
        mapView.getOverlays().add(marker);
        mapView.invalidate();
    }


    public void getPiscinas() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_MADRID)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonService apiPiscinas = retrofit.create(JsonService.class);

            apiPiscinas.getPolideportivoLocation(40.4167, -3.70325, 8000).enqueue(new Callback<JsonPolideportivos>() {

                @Override
                public void onResponse(Call<JsonPolideportivos> call, Response<JsonPolideportivos> response) {
                    if (response != null && response.body() != null) {
                        localizaciones = (ArrayList<Polideportivos>) response.body().results;

                        /*


                        mCentroAdapter = new AdaptadorPolideportivos(InstalacionesDeportivas.this, localizaciones);
                        listView.setAdapter(mCentroAdapter);
                        mCentroAdapter.notifyDataSetChanged();
 */
                        for (Polideportivos g: localizaciones){
                            System.out.println(g.getName());
                        }
                        //geoPointMyPosition = new GeoPoint(40.4167,-3.70325);
                        //addMarker(geoPointMyPosition);
                    }

                }

                @Override
                public void onFailure(Call<JsonPolideportivos> call, Throwable t) {
                    System.out.println("failure");
                }
            });
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