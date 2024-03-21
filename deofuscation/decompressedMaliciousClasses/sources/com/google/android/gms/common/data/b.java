package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int j = com.google.android.gms.common.internal.safeparcel.b.j(parcel);
        int i = 0;
        String[] strArr = null;
        int i2 = 0;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                strArr = com.google.android.gms.common.internal.safeparcel.b.a(parcel, readInt);
            } else if (i3 == 2) {
                cursorWindowArr = (CursorWindow[]) com.google.android.gms.common.internal.safeparcel.b.g(parcel, readInt, CursorWindow.CREATOR);
            } else if (i3 == 3) {
                i2 = com.google.android.gms.common.internal.safeparcel.b.k(parcel, readInt);
            } else if (i3 == 4) {
                bundle = com.google.android.gms.common.internal.safeparcel.b.o(parcel, readInt);
            } else if (i3 != 1000) {
                com.google.android.gms.common.internal.safeparcel.b.f(parcel, readInt);
            } else {
                i = com.google.android.gms.common.internal.safeparcel.b.k(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, j);
        DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
        dataHolder.d();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
