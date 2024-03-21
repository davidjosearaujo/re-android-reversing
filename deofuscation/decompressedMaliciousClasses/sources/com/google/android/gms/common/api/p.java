package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class p implements Parcelable.Creator<Scope> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.k(parcel, readInt);
            } else if (i2 != 2) {
                b.f(parcel, readInt);
            } else {
                str = b.m(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new Scope(i, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Scope[] newArray(int i) {
        return new Scope[i];
    }
}
