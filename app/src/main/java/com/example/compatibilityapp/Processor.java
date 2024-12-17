package com.example.compatibilityapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Processor implements Parcelable {
    String name;
    String socket;
    int cores;
    float frequency;
    int power;

    Processor(String name, String socket, int cores, float frequency, int power) {
        this.name = name;
        this.socket = socket;
        this.cores = cores;
        this.frequency = frequency;
        this.power = power;
    }

    protected Processor(android.os.Parcel in) {
        name = in.readString();
        socket = in.readString();
        cores = in.readInt();
        frequency = in.readFloat();
        power = in.readInt();
    }

    public static final Creator<Processor> CREATOR = new Creator<Processor>() {
        @Override
        public Processor createFromParcel(android.os.Parcel in) {
            return new Processor(in);
        }

        @Override
        public Processor[] newArray(int size) {
            return new Processor[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(socket);
        dest.writeInt(cores);
        dest.writeFloat(frequency);
        dest.writeInt(power);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

