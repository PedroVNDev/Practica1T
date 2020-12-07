package com.example.practica1t.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practica1t.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPaginasInteres extends BaseAdapter {
    private Double latitudes;
    private Double longitudes;
    private Context mContext;
    private List<Piscinas> mPiscina;
    private List<Location> listaLocation;
    private Location location;

    public AdaptadorPaginasInteres() {

    }

    public AdaptadorPaginasInteres(Context mContext, List<Piscinas> mPiscina) {
        this.mContext = mContext;
        this.mPiscina = mPiscina;
    }

    @Override
    public int getCount() {
        return mPiscina.size();
    }

    @Override
    public Object getItem(int i) {
        return mPiscina.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public ArrayList<Location> getArray() {
        return (ArrayList<Location>) listaLocation;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.adaptador_paginas_interes, null);
        }
        TextView mTextView = v.findViewById(R.id.paginasInteres);
        longitudes = mPiscina.get(i).getLocation().getAltitude();
        latitudes = mPiscina.get(i).getLocation().getLatitude();
        String latitudesStr = String.valueOf(latitudes);
        String longitudesStr = String.valueOf(longitudes);
        mTextView.setText(mPiscina.get(i).getName() + "\n");
        return v;
    }
}

