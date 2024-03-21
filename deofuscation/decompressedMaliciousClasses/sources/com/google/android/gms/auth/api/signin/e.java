package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class e implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        ArrayList arrayList = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = b.k(parcel, readInt);
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 2 */:
                    arrayList = b.h(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) b.d(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = b.i(parcel, readInt);
                    break;
                case 5:
                    z2 = b.i(parcel, readInt);
                    break;
                case 6:
                    z3 = b.i(parcel, readInt);
                    break;
                case 7:
                    str = b.m(parcel, readInt);
                    break;
                case 8:
                    str2 = b.m(parcel, readInt);
                    break;
                case 9:
                    arrayList2 = b.h(parcel, readInt, com.google.android.gms.auth.api.signin.a.b.CREATOR);
                    break;
                default:
                    b.f(parcel, readInt);
                    break;
            }
        }
        b.b(parcel, j);
        return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
