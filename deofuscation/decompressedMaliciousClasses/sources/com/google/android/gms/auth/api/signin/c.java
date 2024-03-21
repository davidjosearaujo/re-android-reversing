package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import java.util.ArrayList;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        String str = null;
        int i = 0;
        long j2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = b.k(parcel, readInt);
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 2 */:
                    str = b.m(parcel, readInt);
                    break;
                case 3:
                    str2 = b.m(parcel, readInt);
                    break;
                case 4:
                    str3 = b.m(parcel, readInt);
                    break;
                case 5:
                    str4 = b.m(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) b.d(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = b.m(parcel, readInt);
                    break;
                case 8:
                    j2 = b.l(parcel, readInt);
                    break;
                case 9:
                    str6 = b.m(parcel, readInt);
                    break;
                case 10:
                    arrayList = b.h(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = b.m(parcel, readInt);
                    break;
                case 12:
                    str8 = b.m(parcel, readInt);
                    break;
                default:
                    b.f(parcel, readInt);
                    break;
            }
        }
        b.b(parcel, j);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
