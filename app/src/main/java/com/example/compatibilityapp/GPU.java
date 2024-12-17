package com.example.compatibilityapp;

import android.os.Parcel;
import android.os.Parcelable;

public class GPU implements Parcelable {
    String name;
    String memoryType;
    int memorySize;
    int power;

    GPU(String name, String memoryType, int memorySize, int power) {
        this.name = name;
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.power = power;
    }

    protected GPU(android.os.Parcel in) {
        name = in.readString();
        memoryType = in.readString();
        memorySize = in.readInt();
        power = in.readInt();
    }

    public static final Creator<GPU> CREATOR = new Creator<GPU>() {
        @Override
        public GPU createFromParcel(android.os.Parcel in) {
            return new GPU(in);
        }

        @Override
        public GPU[] newArray(int size) {
            return new GPU[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(memoryType);
        dest.writeInt(memorySize);
        dest.writeInt(power);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
