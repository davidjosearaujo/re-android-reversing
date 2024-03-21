package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.c.a;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class i0 implements Parcelable.Creator<h0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h0 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        IBinder iBinder = null;
        int i = 0;
        a aVar = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.k(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = b.n(parcel, readInt);
            } else if (i2 == 3) {
                aVar = (a) b.d(parcel, readInt, a.CREATOR);
            } else if (i2 == 4) {
                z = b.i(parcel, readInt);
            } else if (i2 != 5) {
                b.f(parcel, readInt);
            } else {
                z2 = b.i(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new h0(i, iBinder, aVar, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h0[] newArray(int i) {
        return new h0[i];
    }
}
