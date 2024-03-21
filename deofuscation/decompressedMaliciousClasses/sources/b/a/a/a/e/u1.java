package b.a.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.h0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class u1 extends a {
    public static final Parcelable.Creator<u1> CREATOR = new v1();

    /* renamed from: a */
    private int f180a;

    /* renamed from: b */
    private final b.a.a.a.c.a f181b;
    private final h0 c;

    public u1(int i) {
        this(new b.a.a.a.c.a(8, null), null);
    }

    public u1(int i, b.a.a.a.c.a aVar, h0 h0Var) {
        this.f180a = i;
        this.f181b = aVar;
        this.c = h0Var;
    }

    private u1(b.a.a.a.c.a aVar, h0 h0Var) {
        this(1, aVar, null);
    }

    public final h0 c() {
        return this.c;
    }

    public final b.a.a.a.c.a d() {
        return this.f181b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f180a);
        d.g(parcel, 2, this.f181b, i, false);
        d.g(parcel, 3, this.c, i, false);
        d.c(parcel, q);
    }
}
