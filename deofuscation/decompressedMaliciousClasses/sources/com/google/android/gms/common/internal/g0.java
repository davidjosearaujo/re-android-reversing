package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g0 implements Parcelable.Creator<f0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = b.k(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) b.d(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = b.k(parcel, readInt);
            } else if (i3 != 4) {
                b.f(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) b.d(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        b.b(parcel, j);
        return new f0(i, account, i2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0[] newArray(int i) {
        return new f0[i];
    }
}
