package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h0 extends a {
    private static short[] $ = {2357, 2361, 2363, 2424, 2353, 2361, 2361, 2353, 2362, 2355, 2424, 2359, 2360, 2354, 2340, 2361, 2367, 2354, 2424, 2353, 2363, 2341, 2424, 2357, 2361, 2363, 2363, 2361, 2360, 2424, 2367, 2360, 2338, 2355, 2340, 2360, 2359, 2362, 2424, 2335, 2327, 2357, 2357, 2361, 2339, 2360, 2338, 2327, 2357, 2357, 2355, 2341, 2341, 2361, 2340};
    public static final Parcelable.Creator<h0> CREATOR = new i0();

    /* renamed from: a */
    private int f262a;

    /* renamed from: b */
    private IBinder f263b;
    private b.a.a.a.c.a c;
    private boolean d;
    private boolean e;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public h0(int i, IBinder iBinder, b.a.a.a.c.a aVar, boolean z, boolean z2) {
        this.f262a = i;
        this.f263b = iBinder;
        this.c = aVar;
        this.d = z;
        this.e = z2;
    }

    public final b.a.a.a.c.a c() {
        return this.c;
    }

    public final k d() {
        IBinder iBinder = this.f263b;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface($(0, 55, 2390));
        return queryLocalInterface instanceof k ? (k) queryLocalInterface : new m(iBinder);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.c.equals(h0Var.c) && d().equals(h0Var.d());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f262a);
        d.f(parcel, 2, this.f263b, false);
        d.g(parcel, 3, this.c, i, false);
        d.i(parcel, 4, this.d);
        d.i(parcel, 5, this.e);
        d.c(parcel, q);
    }
}
