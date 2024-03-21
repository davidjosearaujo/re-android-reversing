package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f0 extends a {
    public static final Parcelable.Creator<f0> CREATOR = new g0();

    /* renamed from: a */
    private int f258a;

    /* renamed from: b */
    private final Account f259b;
    private final int c;
    private final GoogleSignInAccount d;

    public f0(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f258a = i;
        this.f259b = account;
        this.c = i2;
        this.d = googleSignInAccount;
    }

    public f0(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f258a);
        d.g(parcel, 2, this.f259b, i, false);
        d.o(parcel, 3, this.c);
        d.g(parcel, 4, this.d, i, false);
        d.c(parcel, q);
    }
}
