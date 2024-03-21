package b.a.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.f0;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class t1 implements Parcelable.Creator<s1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s1 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        f0 f0Var = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.k(parcel, readInt);
            } else if (i2 != 2) {
                b.f(parcel, readInt);
            } else {
                f0Var = (f0) b.d(parcel, readInt, f0.CREATOR);
            }
        }
        b.b(parcel, j);
        return new s1(i, f0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s1[] newArray(int i) {
        return new s1[i];
    }
}
