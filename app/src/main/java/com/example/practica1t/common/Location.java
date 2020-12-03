package com.example.practica1t.common;

import android.os.Parcel;

public class Location {
    private double latitude;
    private double altitude;

    public Location(Parcel in) {
        latitude = in.readDouble();
        altitude = in.readDouble();
    }

    public Location() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

}
