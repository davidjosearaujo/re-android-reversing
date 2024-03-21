package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.c.h;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c1 implements Parcelable.Creator<b1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b1 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        h[] hVarArr = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = b.k(parcel, readInt);
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 2 */:
                    i2 = b.k(parcel, readInt);
                    break;
                case 3:
                    i3 = b.k(parcel, readInt);
                    break;
                case 4:
                    str = b.m(parcel, readInt);
                    break;
                case 5:
                    iBinder = b.n(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) b.g(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = b.o(parcel, readInt);
                    break;
                case 8:
                    account = (Account) b.d(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    b.f(parcel, readInt);
                    break;
                case 10:
                    hVarArr = (h[]) b.g(parcel, readInt, h.CREATOR);
                    break;
            }
        }
        b.b(parcel, j);
        return new b1(i, i2, i3, str, iBinder, scopeArr, bundle, account, hVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b1[] newArray(int i) {
        return new b1[i];
    }
}
