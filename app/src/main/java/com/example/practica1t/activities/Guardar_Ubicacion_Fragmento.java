package com.example.practica1t.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica1t.R;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class Guardar_Ubicacion_Fragmento extends Fragment {

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragmento_guardar_ubicacion, container, false);

    }

}
