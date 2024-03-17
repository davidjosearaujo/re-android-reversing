package cn.asus.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import i.a.a.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new h();
    public Bundle bundle;
    public String cmd;

    public DataBuffer(Parcel parcel) {
        this.cmd = parcel.readString();
        this.bundle = parcel.readBundle();
    }

    public DataBuffer(String str, Bundle bundle) {
        this.cmd = str;
        this.bundle = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cmd);
        parcel.writeBundle(this.bundle);
    }
}
