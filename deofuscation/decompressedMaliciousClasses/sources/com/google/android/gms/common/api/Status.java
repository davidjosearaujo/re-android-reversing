package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.x;
import java.util.Arrays;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class Status extends a implements j, ReflectedParcelable {

    /* renamed from: a */
    private int f228a;

    /* renamed from: b */
    private final int f229b;
    private final String c;
    private final PendingIntent d;
    private static short[] $ = {19003, 19004, 18985, 19004, 19005, 19003, 18955, 18983, 18988, 18989, 23326, 23305, 23327, 23299, 23296, 23321, 23320, 23301, 23299, 23298};
    public static final Status e = new Status(0);
    public static final Status f = new Status(14);
    public static final Status g = new Status(8);
    public static final Status h = new Status(15);
    public static final Status i = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new q();

    private static String $(int i2, int i3, int i4) {
        char[] cArr = new char[i3 - i2];
        for (int i5 = 0; i5 < i3 - i2; i5++) {
            cArr[i5] = (char) ($[i2 + i5] ^ i4);
        }
        return new String(cArr);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f228a = i2;
        this.f229b = i3;
        this.c = str;
        this.d = pendingIntent;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }

    @Override // com.google.android.gms.common.api.j
    public final Status b() {
        return this;
    }

    public final int c() {
        return this.f229b;
    }

    public final String d() {
        return this.c;
    }

    public final boolean e() {
        return this.d != null;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f228a == status.f228a && this.f229b == status.f229b && v.a(this.c, status.c) && v.a(this.d, status.d);
    }

    public final boolean f() {
        return this.f229b <= 0;
    }

    public final String g() {
        String str = this.c;
        return str != null ? str : c.a(this.f229b);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f228a), Integer.valueOf(this.f229b), this.c, this.d});
    }

    @Override // java.lang.Object
    public final String toString() {
        x b2 = v.b(this);
        b2.a($(0, 10, 19016), g());
        b2.a($(10, 20, 23404), this.d);
        return b2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int q = d.q(parcel);
        d.o(parcel, 1, c());
        d.h(parcel, 2, d(), false);
        d.g(parcel, 3, this.d, i2, false);
        d.o(parcel, 1000, this.f228a);
        d.c(parcel, q);
    }
}
