package b.a.a.a.e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class l1 implements Parcelable.Creator<k1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1 createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = b.k(parcel, readInt);
            } else if (i3 == 2) {
                i2 = b.k(parcel, readInt);
            } else if (i3 != 3) {
                b.f(parcel, readInt);
            } else {
                intent = (Intent) b.d(parcel, readInt, Intent.CREATOR);
            }
        }
        b.b(parcel, j);
        return new k1(i, i2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1[] newArray(int i) {
        return new k1[i];
    }
}
