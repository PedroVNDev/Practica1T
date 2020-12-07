package com.example.practica1t.common;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Piscinas implements Parcelable{
    @SerializedName("title")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private Location location;

    public Piscinas() {
        this.name = name;
        this.location = location;
    }

    public Piscinas(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Piscinas(Parcel in) {
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

    public static final Parcelable.Creator<Piscinas> CREATOR = new Parcelable.Creator<Piscinas>() {
        @Override
        public Piscinas createFromParcel(Parcel in) {
            return new Piscinas(in);
        }

        @Override
        public Piscinas[] newArray(int size) {
            return new Piscinas[size];
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
