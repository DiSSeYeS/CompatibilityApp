package com.example.compatibilityapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Motherboard implements Parcelable {
    String name;
    String socket;
    String chipset;
    String formFactor;
    String ram;

    public Motherboard(String name, String socket, String chipset, String formFactor, String ram) {
        this.name = name;
        this.socket = socket;
        this.chipset = chipset;
        this.formFactor = formFactor;
        this.ram = ram;
    }

    protected Motherboard(Parcel in) {
        name = in.readString();
        socket = in.readString();
        chipset = in.readString();
        formFactor = in.readString();
        ram = in.readString();
    }

    public static final Creator<Motherboard> CREATOR = new Creator<Motherboard>() {
        @Override
        public Motherboard createFromParcel(Parcel in) {
            return new Motherboard(in);
        }

        @Override
        public Motherboard[] newArray(int size) {
            return new Motherboard[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(socket);
        dest.writeString(chipset);
        dest.writeString(formFactor);
        dest.writeString(ram);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
