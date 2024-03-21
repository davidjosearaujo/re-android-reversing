package b.a.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h extends a {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: a */
    private String f122a;

    /* renamed from: b */
    private int f123b;

    public h(String str, int i) {
        this.f122a = str;
        this.f123b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.h(parcel, 1, this.f122a, false);
        d.o(parcel, 2, this.f123b);
        d.c(parcel, q);
    }
}
