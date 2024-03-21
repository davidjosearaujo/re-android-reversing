package b.a.a.a.e;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class k1 extends a implements j {
    public static final Parcelable.Creator<k1> CREATOR = new l1();

    /* renamed from: a */
    private int f162a;

    /* renamed from: b */
    private int f163b;
    private Intent c;

    public k1(int i, int i2, Intent intent) {
        this.f162a = i;
        this.f163b = i2;
        this.c = intent;
    }

    @Override // com.google.android.gms.common.api.j
    public final Status b() {
        return this.f163b == 0 ? Status.e : Status.i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.o(parcel, 1, this.f162a);
        d.o(parcel, 2, this.f163b);
        d.g(parcel, 3, this.c, i, false);
        d.c(parcel, q);
    }
}
