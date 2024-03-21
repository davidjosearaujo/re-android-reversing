package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class l implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        String str = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                b.f(parcel, readInt);
            } else {
                str = b.m(parcel, readInt);
            }
        }
        b.b(parcel, j);
        return new k(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i) {
        return new k[i];
    }
}
