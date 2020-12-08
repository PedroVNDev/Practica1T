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

public class AdaptadorPolideportivos extends BaseAdapter {

    private Double latitudes;
    private Double longitudes;
    private Context mContext;
    private List<Polideportivos> mCentro;
    private List<Location> listaLocation;
    private Location location;

    public AdaptadorPolideportivos() {

    }

    public AdaptadorPolideportivos(Context mContext, List<Polideportivos> mCentro) {
        this.mContext = mContext;
        this.mCentro = mCentro;
    }

    @Override
    public int getCount() {
        return mCentro.size();
    }

    @Override
    public Object getItem(int i) {
        return mCentro.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public ArrayList<Location> getArray(){
        return (ArrayList<Location>) listaLocation;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.adaptador_deportivos, null);
        }
        TextView mTextView = v.findViewById(R.id.centroslista);
        longitudes = mCentro.get(i).getLocation().getAltitude();
        latitudes = mCentro.get(i).getLocation().getLatitude();
        String latitudesStr = String.valueOf(latitudes);
        String longitudesStr = String.valueOf(longitudes);
        mTextView.setText(mCentro.get(i).getName() + "\n");
        return v;
    }
}
