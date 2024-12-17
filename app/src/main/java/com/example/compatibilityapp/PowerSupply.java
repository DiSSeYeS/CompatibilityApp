package com.example.compatibilityapp;

import android.os.Parcel;
import android.os.Parcelable;

public class PowerSupply implements Parcelable {
    String name;
    int wattage;

    public PowerSupply(String name, int wattage) {
        this.name = name;
        this.wattage = wattage;
    }

    protected PowerSupply(Parcel in){
        name = in.readString();
        wattage = in.readInt();
    }

    public static final Parcelable.Creator<PowerSupply> CREATOR = new Parcelable.Creator<PowerSupply>() {
        @Override
        public PowerSupply createFromParcel(android.os.Parcel in) {
            return new PowerSupply(in);
        }

        @Override
        public PowerSupply[] newArray(int size) {
            return new PowerSupply[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(wattage);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}