package com.example.practica1t.common;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Polideportivos implements Parcelable {
    @SerializedName("title")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private Location location;

    public Polideportivos(){
        this.name = name;
        this.location = location;
    }

    public Polideportivos(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Polideportivos(Parcel in) {
        name = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(location, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Polideportivos> CREATOR = new Creator<Polideportivos>() {
        @Override
        public Polideportivos createFromParcel(Parcel in) {
            return new Polideportivos(in);
        }

        @Override
        public Polideportivos[] newArray(int size) {
            return new Polideportivos[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
