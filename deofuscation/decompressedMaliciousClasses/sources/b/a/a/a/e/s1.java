package b.a.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.f0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class s1 extends a {
    public static final Parcelable.Creator<s1> CREATOR = new t1();

    /* renamed from: a */
    private int f175a;

    /* renamed from: b */
    private f0 f176b;

    public s1(int i, f0 f0Var) {
        this.f175a = i;
        this.f176b = f0Var;
    }

    public s1(f0 f0Var) {
        this(1, f0Var);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f175a);
        d.g(parcel, 2, this.f176b, i, false);
        d.c(parcel, q);
    }
}
