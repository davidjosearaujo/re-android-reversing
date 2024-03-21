package com.google.android.gms.auth.api.signin.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a */
    private int f219a;

    /* renamed from: b */
    private int f220b;
    private Bundle c;

    public b(int i, int i2, Bundle bundle) {
        this.f219a = i;
        this.f220b = i2;
        this.c = bundle;
    }

    public final int c() {
        return this.f220b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f219a);
        d.o(parcel, 2, this.f220b);
        d.e(parcel, 3, this.c, false);
        d.c(parcel, q);
    }
}
