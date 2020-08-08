package com.Hackttan.busapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BusInfo implements Parcelable {
    ArrayList<Bus> bus;

    public BusInfo(ArrayList<Bus> bus) {
        this.bus = bus;
    }

    protected BusInfo(Parcel in) {
        bus = in.createTypedArrayList(Bus.CREATOR);
    }

    public static final Creator<BusInfo> CREATOR = new Creator<BusInfo>() {
        @Override
        public BusInfo createFromParcel(Parcel in) {
            return new BusInfo(in);
        }

        @Override
        public BusInfo[] newArray(int size) {
            return new BusInfo[size];
        }
    };

    public ArrayList<Bus> getBus() {
        return bus;
    }

    public void setBus(ArrayList<Bus> bus) {
        this.bus = bus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(bus);
    }

}
