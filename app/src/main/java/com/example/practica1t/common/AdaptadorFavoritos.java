package com.example.practica1t.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practica1t.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorFavoritos extends BaseAdapter {
    private String nombre;
    private Context mContext;
    private List<Piscinas> mPiscina;
    private List<Location> listaLocation;
    private Location location;

    public AdaptadorFavoritos() {

    }

    public AdaptadorFavoritos(Context mContext, List<Piscinas> mPiscina) {
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
            v = layoutInflater.inflate(R.layout.adapter_favoritos, null);
        }

        return v;
    }
}
