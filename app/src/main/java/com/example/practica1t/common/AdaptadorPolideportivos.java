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

public class AdaptadorPolideportivos extends BaseAdapter {

    private Double latitudes;
    private Double longitudes;
    private Context mContext;
    private List<Polideportivos> mCentro;
    private Location location;
    private int lastposition = -1;

    static class ViewHolder {
        TextView name;
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

    @Override
    public View getView(int i, View v, ViewGroup parent) {

        if (v == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.adaptador_deportivos, null);
        }
        longitudes = mCentro.get(i).getLocation().getAltitude();
        latitudes = mCentro.get(i).getLocation().getLatitude();

        final View result;
        AdaptadorPolideportivos.ViewHolder holder;

        holder = new AdaptadorPolideportivos.ViewHolder();
        holder.name = v.findViewById(R.id.centroslista);

        result = v;
        v.setTag(holder);

        Animation animation = AnimationUtils.loadAnimation(mContext, (i > lastposition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastposition = i;

        holder.name.setText(mCentro.get(i).getName() + "\n");

        return v;
    }
}

