package com.example.practica1t.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practica1t.R;

import java.util.List;

public class AdaptadorPiscinas extends BaseAdapter {
    private Double latitudes;
    private Double longitudes;
    private Context mContext;
    private List<Piscinas> mPiscina;
    private Location location;
    private int lastposition = -1;

    static class ViewHolder {
        TextView name;
    }

    public AdaptadorPiscinas(Context mContext, List<Piscinas> mPiscina) {
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

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.adaptador_deportivos, null);
        }
        longitudes = mPiscina.get(i).getLocation().getAltitude();
        latitudes = mPiscina.get(i).getLocation().getLatitude();

        //Para cargar la lista de manera eficiente y fluida
        final View result;
        AdaptadorPiscinas.ViewHolder holder;

        holder = new AdaptadorPiscinas.ViewHolder();
        holder.name = v.findViewById(R.id.centroslista);

        result = v;
        v.setTag(holder);

        Animation animation = AnimationUtils.loadAnimation(mContext, (i > lastposition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastposition = i;

        holder.name.setText(mPiscina.get(i).getName() + "\n");

        return v;

    }
}

