package b.a.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a.a.c.a;
import com.google.android.gms.common.internal.h0;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class v1 implements Parcelable.Creator<u1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u1 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        a aVar = null;
        int i = 0;
        h0 h0Var = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.k(parcel, readInt);
            } else if (i2 == 2) {
                aVar = (a) b.d(parcel, readInt, a.CREATOR);
            } else if (i2 != 3) {
                b.f(parcel, readInt);
            } else {
                h0Var = (h0) b.d(parcel, readInt, h0.CREATOR);
            }
        }
        b.b(parcel, j);
        return new u1(i, aVar, h0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u1[] newArray(int i) {
        return new u1[i];
    }
}
