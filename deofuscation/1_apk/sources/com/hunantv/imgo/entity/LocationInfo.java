package com.hunantv.imgo.entity;

import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LocationInfo implements JsonInterface {
    private double mAccuracy;
    private double mAltitude;
    private String mCity;
    private String mCountry;
    private String mFullAddress;
    private double mLatitude;
    private double mLongitude;
    private String mProvince;
    private double mSpeed;
    private double mVerticalAccuracyMeters;

    public double getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getCountry() {
        return this.mCountry;
    }

    public String getFullAddress() {
        return this.mFullAddress;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getProvince() {
        return this.mProvince;
    }

    public double getSpeed() {
        return this.mSpeed;
    }

    public double getVerticalAccuracyMeters() {
        return this.mVerticalAccuracyMeters;
    }

    public void setAccuracy(double d) {
        this.mAccuracy = d;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public void setCountry(String str) {
        this.mCountry = str;
    }

    public void setFullAddress(String str) {
        this.mFullAddress = str;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setProvince(String str) {
        this.mProvince = str;
    }

    public void setSpeed(double d) {
        this.mSpeed = d;
    }

    public void setVerticalAccuracyMeters(double d) {
        this.mVerticalAccuracyMeters = d;
    }
}
