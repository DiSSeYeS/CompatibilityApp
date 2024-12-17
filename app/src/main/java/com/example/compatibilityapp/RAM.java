package com.example.compatibilityapp;

import android.os.Parcelable;

public class RAM implements Parcelable {
    String name;
    String type;
    int size;

    RAM(String name, String type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    protected RAM(android.os.Parcel in) {
        name = in.readString();
        type = in.readString();
        size = in.readInt();
    }

    public static final Creator<RAM> CREATOR = new Creator<RAM>() {
        @Override
        public RAM createFromParcel(android.os.Parcel in) {
            return new RAM(in);
        }

        @Override
        public RAM[] newArray(int size) {
            return new RAM[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeInt(size);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
