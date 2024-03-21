package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.c.h;
import b.a.a.a.c.j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b1 extends a {
    private static short[] $ = {321, 333, 335, 268, 325, 333, 333, 325, 334, 327, 268, 323, 332, 326, 336, 333, 331, 326, 268, 325, 335, 337, 1004, 992, 994, 929, 1000, 992, 992, 1000, 995, 1002, 929, 1006, 993, 1003, 1021, 992, 998, 1003, 929, 1000, 994, 1020, 929, 1004, 992, 994, 994, 992, 993, 929, 998, 993, 1019, 1002, 1021, 993, 1006, 995, 929, 966, 974, 1004, 1004, 992, 1018, 993, 1019, 974, 1004, 1004, 1002, 1020, 1020, 992, 1021};
    public static final Parcelable.Creator<b1> CREATOR = new c1();

    /* renamed from: a */
    private int f250a;

    /* renamed from: b */
    private int f251b;
    private int c;
    String d;
    IBinder e;
    Scope[] f;
    Bundle g;
    Account h;
    h[] i;

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public b1(int i) {
        this.f250a = 3;
        this.c = j.f124a;
        this.f251b = i;
    }

    public b1(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, h[] hVarArr) {
        this.f250a = i;
        this.f251b = i2;
        this.c = i3;
        String $2 = $(0, 22, 290);
        if ($2.equals(str)) {
            this.d = $2;
        } else {
            this.d = str;
        }
        if (i < 2) {
            Account account2 = null;
            k kVar = null;
            if (iBinder != null) {
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface($(22, 77, 911));
                    kVar = queryLocalInterface instanceof k ? (k) queryLocalInterface : new m(iBinder);
                }
                account2 = a.x(kVar);
            }
            this.h = account2;
        } else {
            this.e = iBinder;
            this.h = account;
        }
        this.f = scopeArr;
        this.g = bundle;
        this.i = hVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f250a);
        d.o(parcel, 2, this.f251b);
        d.o(parcel, 3, this.c);
        d.h(parcel, 4, this.d, false);
        d.f(parcel, 5, this.e, false);
        d.k(parcel, 6, this.f, i, false);
        d.e(parcel, 7, this.g, false);
        d.g(parcel, 8, this.h, i, false);
        d.k(parcel, 10, this.i, i, false);
        d.c(parcel, q);
    }
}
