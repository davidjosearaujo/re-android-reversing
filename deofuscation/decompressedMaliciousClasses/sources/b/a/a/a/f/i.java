package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class i extends a {
    public static final Parcelable.Creator<i> CREATOR = new j();

    /* renamed from: a */
    public final long f199a;

    /* renamed from: b */
    public final a[] f200b;

    public i(long j, a[] aVarArr) {
        this.f199a = j;
        this.f200b = aVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.d(parcel, 2, this.f199a);
        d.k(parcel, 3, this.f200b, i, false);
        d.c(parcel, q);
    }
}
