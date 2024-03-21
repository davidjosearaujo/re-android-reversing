package b.a.a.a.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.d;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class b extends a {
    public static final Parcelable.Creator<b> CREATOR = new m();

    /* renamed from: a */
    private String f194a;

    /* renamed from: b */
    private DataHolder f195b;

    public b(String str, DataHolder dataHolder) {
        this.f194a = str;
        this.f195b = dataHolder;
    }

    public DataHolder c() {
        return this.f195b;
    }

    public String d() {
        return this.f194a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int q = d.q(parcel);
        d.h(parcel, 2, d(), false);
        d.g(parcel, 3, c(), i, false);
        d.c(parcel, q);
    }
}
