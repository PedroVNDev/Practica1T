package com.example.practica1t.Jsons;

import com.example.practica1t.common.Polideportivos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonPolideportivos {

    @SerializedName("@graph")
    @Expose
    public final ArrayList<Polideportivos> results = null;

}
