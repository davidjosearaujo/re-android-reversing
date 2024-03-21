package com.google.android.gms.auth.api.signin.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = b.k(parcel, readInt);
            } else if (i3 == 2) {
                i2 = b.k(parcel, readInt);
            } else if (i3 != 3) {
                b.f(parcel, readInt);
            } else {
                bundle = b.o(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new b(i, i2, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i) {
        return new b[i];
    }
}
