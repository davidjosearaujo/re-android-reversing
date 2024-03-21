package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.e0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class Scope extends a implements ReflectedParcelable {
    private static short[] $ = {3891, 3875, 3887, 3888, 3877, 3861, 3890, 3881, 3936, 3885, 3893, 3891, 3892, 3936, 3886, 3887, 3892, 3936, 3874, 3877, 3936, 3886, 3893, 3884, 3884, 3936, 3887, 3890, 3936, 3877, 3885, 3888, 3892, 3897};
    public static final Parcelable.Creator<Scope> CREATOR = new p();

    /* renamed from: a */
    private int f226a;

    /* renamed from: b */
    private final String f227b;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public Scope(int i, String str) {
        e0.h(str, $(0, 34, 3904));
        this.f226a = i;
        this.f227b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final String c() {
        return this.f227b;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f227b.equals(((Scope) obj).f227b);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f227b.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.f227b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f226a);
        d.h(parcel, 2, this.f227b, false);
        d.c(parcel, q);
    }
}
