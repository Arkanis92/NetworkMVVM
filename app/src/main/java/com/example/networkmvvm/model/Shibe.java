package com.example.networkmvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Shibe implements Parcelable {

    private String shibeURL;

    protected Shibe(Parcel in) {
        shibeURL = in.readString();
    }

    public static final Creator<Shibe> CREATOR = new Creator<Shibe>() {
        @Override
        public Shibe createFromParcel(Parcel in) {
            return new Shibe(in);
        }

        @Override
        public Shibe[] newArray(int size) {
            return new Shibe[size];
        }
    };

    public String getShibeURL() {
        return shibeURL;
    }

    public void setShibeURL(String shibeURL) {
        this.shibeURL = shibeURL;
    }

    public Shibe(String shibeURL) {
        this.shibeURL = shibeURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shibeURL);
    }
}
