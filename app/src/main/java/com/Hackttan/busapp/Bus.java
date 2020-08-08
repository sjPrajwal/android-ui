package com.Hackttan.busapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Bus implements Parcelable {
    private int BusId;
    private String BusName;
    private String Capacity;
    private String Fuel;
    private String Lat;
    private String Long;
    private String Occupied;
    private String AvailableSeat;

    protected Bus(Parcel in) {
        BusId = in.readInt();
        BusName = in.readString();
        Capacity = in.readString();
        Fuel = in.readString();
        Lat = in.readString();
        Long = in.readString();
        Occupied = in.readString();
        AvailableSeat = in.readString();
    }

    public static final Creator<Bus> CREATOR = new Creator<Bus>() {
        @Override
        public Bus createFromParcel(Parcel in) {
            return new Bus(in);
        }

        @Override
        public Bus[] newArray(int size) {
            return new Bus[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(BusId);
        dest.writeString(BusName);
        dest.writeString(Capacity);
        dest.writeString(Fuel);
        dest.writeString(Lat);
        dest.writeString(Long);
        dest.writeString(Occupied);
        dest.writeString(AvailableSeat);
    }

    public int getBusId() {
        return BusId;
    }

    public void setBusId(int busId) {
        BusId = busId;
    }

    public String getBusName() {
        return BusName;
    }

    public void setBusName(String busName) {
        BusName = busName;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getFuel() {
        return Fuel;
    }

    public void setFuel(String fuel) {
        Fuel = fuel;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String aLong) {
        Long = aLong;
    }

    public String getOccupied() {
        return Occupied;
    }

    public void setOccupied(String occupied) {
        Occupied = occupied;
    }

    public String getAvailableSeat() {
        return AvailableSeat;
    }

    public void setAvailableSeat(String availableSeat) {
        AvailableSeat = availableSeat;
    }

    public static Creator<Bus> getCREATOR() {
        return CREATOR;
    }
}
