package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class a extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<a> CREATOR = new h();

    /* renamed from: a */
    public final String f192a;

    /* renamed from: b */
    public final byte[] f193b;
    public final int c;

    public a(String str, byte[] bArr, int i) {
        this.f192a = str;
        this.f193b = bArr;
        this.c = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.h(parcel, 2, this.f192a, false);
        d.j(parcel, 3, this.f193b, false);
        d.o(parcel, 4, this.c);
        d.c(parcel, q);
    }
}
