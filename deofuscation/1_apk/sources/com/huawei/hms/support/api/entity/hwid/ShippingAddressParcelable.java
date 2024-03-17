package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ShippingAddressParcelable implements Parcelable {
    public static final Parcelable.Creator<ShippingAddressParcelable> CREATOR = new Parcelable.Creator<ShippingAddressParcelable>() { // from class: com.huawei.hms.support.api.entity.hwid.ShippingAddressParcelable.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShippingAddressParcelable createFromParcel(Parcel parcel) {
            return new ShippingAddressParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShippingAddressParcelable[] newArray(int i) {
            return new ShippingAddressParcelable[i];
        }
    };
    private ArrayList<ShippingAddressInfo> a;

    public ShippingAddressParcelable() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<ShippingAddressInfo> getShippingAddressInfoList() {
        return this.a;
    }

    public void setShippingAddressInfoList(ArrayList<ShippingAddressInfo> arrayList) {
        this.a = arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
    }

    public ShippingAddressParcelable(Parcel parcel) {
        this.a = parcel.createTypedArrayList(ShippingAddressInfo.CREATOR);
    }
}
