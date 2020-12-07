package com.example.practica1t.Jsons;

import com.example.practica1t.common.Piscinas;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonPiscinas {

    @SerializedName("@graph")
    @Expose
    public final ArrayList<Piscinas> results = null;

}
