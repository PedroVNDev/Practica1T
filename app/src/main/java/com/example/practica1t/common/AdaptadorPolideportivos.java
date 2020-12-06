package com.example.practica1t.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.practica1t.R;

import java.util.List;

public class AdaptadorPolideportivos extends BaseAdapter {
    private Context mContext;
    private List<Polideportivos> mCentro;

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
            v = layoutInflater.inflate(R.layout.activity_instalaciones_deportivas, null);
        }
        TextView mTextView = v.findViewById(R.id.centrosLista);
        mTextView.setText(mCentro.get(i).getName());
        return v;
    }
}
