package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class g implements Parcelable.Creator<f> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f createFromParcel(Parcel parcel) {
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
        return new f(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i) {
        return new f[i];
    }
}
