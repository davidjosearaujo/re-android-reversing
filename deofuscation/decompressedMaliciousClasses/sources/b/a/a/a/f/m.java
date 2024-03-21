package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.b;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class m implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b createFromParcel(Parcel parcel) {
        int j = b.j(parcel);
        String str = null;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < j) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                str = b.m(parcel, readInt);
            } else if (i != 3) {
                b.f(parcel, readInt);
            } else {
                dataHolder = (DataHolder) b.d(parcel, readInt, DataHolder.CREATOR);
            }
        }
        b.b(parcel, j);
        return new b(str, dataHolder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ b[] newArray(int i) {
        return new b[i];
    }
}
