package com.example.practica1t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_localizacion_actual:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Ubicacion_Actual_Fragmento()).commit();
                Toast.makeText(this, "Estas en Ubicación Actual", Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_guardar_ubicacion:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Guardar_Ubicacion_Fragmento()).commit();
                Toast.makeText(this, "Estas en Guardar Ubicación", Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_instalaciones_deportivas:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Instalaciones_Deportivas_Fragmento()).commit();
                Toast.makeText(this, "Estas en Instalaciones Deportivas", Toast.LENGTH_LONG).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}