package b.a.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class i implements Parcelable.Creator<h> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = b.m(parcel, readInt);
            } else if (i2 != 2) {
                b.f(parcel, readInt);
            } else {
                i = b.k(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new h(str, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h[] newArray(int i) {
        return new h[i];
    }
}
