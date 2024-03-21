package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = b.m(parcel, readInt);
            } else if (i2 == 3) {
                bArr = b.p(parcel, readInt);
            } else if (i2 != 4) {
                b.f(parcel, readInt);
            } else {
                i = b.k(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new a(str, bArr, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
