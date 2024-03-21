package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new g();

    /* renamed from: a */
    private final String f198a;

    public f(String str) {
        this.f198a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.h(parcel, 2, this.f198a, false);
        d.c(parcel, q);
    }
}
