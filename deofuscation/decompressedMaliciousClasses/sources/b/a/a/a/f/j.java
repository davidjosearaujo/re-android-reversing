package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class j implements Parcelable.Creator<i> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        long j2 = 0;
        a[] aVarArr = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                j2 = b.l(parcel, readInt);
            } else if (i != 3) {
                b.f(parcel, readInt);
            } else {
                aVarArr = (a[]) b.g(parcel, readInt, a.CREATOR);
            }
        }
        b.b(parcel, j);
        return new i(j2, aVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i[] newArray(int i) {
        return new i[i];
    }
}
