package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c0 implements Parcelable {
    public static final Parcelable.Creator<c0> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public final String f1595f;

    /* renamed from: g  reason: collision with root package name */
    public final String f1596g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1597h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1598i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1599j;

    /* renamed from: k  reason: collision with root package name */
    public final String f1600k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f1601l;
    public final boolean m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1602n;

    /* renamed from: o  reason: collision with root package name */
    public final Bundle f1603o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f1604p;

    /* renamed from: q  reason: collision with root package name */
    public final int f1605q;

    /* renamed from: r  reason: collision with root package name */
    public Bundle f1606r;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Parcelable.Creator<c0> {
        @Override // android.os.Parcelable.Creator
        public final c0 createFromParcel(Parcel parcel) {
            return new c0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final c0[] newArray(int i7) {
            return new c0[i7];
        }
    }

    public c0(Parcel parcel) {
        this.f1595f = parcel.readString();
        this.f1596g = parcel.readString();
        boolean z6 = true;
        this.f1597h = parcel.readInt() != 0;
        this.f1598i = parcel.readInt();
        this.f1599j = parcel.readInt();
        this.f1600k = parcel.readString();
        this.f1601l = parcel.readInt() != 0;
        this.m = parcel.readInt() != 0;
        this.f1602n = parcel.readInt() != 0;
        this.f1603o = parcel.readBundle();
        this.f1604p = parcel.readInt() == 0 ? false : z6;
        this.f1606r = parcel.readBundle();
        this.f1605q = parcel.readInt();
    }

    public c0(n nVar) {
        this.f1595f = nVar.getClass().getName();
        this.f1596g = nVar.f1704j;
        this.f1597h = nVar.f1711r;
        this.f1598i = nVar.A;
        this.f1599j = nVar.B;
        this.f1600k = nVar.C;
        this.f1601l = nVar.F;
        this.m = nVar.f1710q;
        this.f1602n = nVar.E;
        this.f1603o = nVar.f1705k;
        this.f1604p = nVar.D;
        this.f1605q = nVar.P.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1595f);
        sb.append(" (");
        sb.append(this.f1596g);
        sb.append(")}:");
        if (this.f1597h) {
            sb.append(" fromLayout");
        }
        if (this.f1599j != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1599j));
        }
        String str = this.f1600k;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1600k);
        }
        if (this.f1601l) {
            sb.append(" retainInstance");
        }
        if (this.m) {
            sb.append(" removing");
        }
        if (this.f1602n) {
            sb.append(" detached");
        }
        if (this.f1604p) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeString(this.f1595f);
        parcel.writeString(this.f1596g);
        parcel.writeInt(this.f1597h ? 1 : 0);
        parcel.writeInt(this.f1598i);
        parcel.writeInt(this.f1599j);
        parcel.writeString(this.f1600k);
        parcel.writeInt(this.f1601l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.f1602n ? 1 : 0);
        parcel.writeBundle(this.f1603o);
        parcel.writeInt(this.f1604p ? 1 : 0);
        parcel.writeBundle(this.f1606r);
        parcel.writeInt(this.f1605q);
    }
}
