package a.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class q implements Parcelable {
    private static short[] $ = {6080, 6119, 6138, 6141, 6120, 6119, 6141, 6112, 6120, 6141, 6124, 6125, 6057, 6127, 6139, 6120, 6126, 6116, 6124, 6119, 6141, 6057, 6618, 6638, 6653, 6651, 6641, 6649, 6642, 6632, 6609, 6653, 6642, 6653, 6651, 6649, 6638};
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final String f50a;

    /* renamed from: b  reason: collision with root package name */
    final int f51b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    h l;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class a implements Parcelable.Creator<q> {
        a() {
        }

        /* renamed from: a */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        /* renamed from: b */
        public q[] newArray(int i) {
            return new q[i];
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public q(h hVar) {
        this.f50a = hVar.getClass().getName();
        this.f51b = hVar.d;
        this.c = hVar.l;
        this.d = hVar.u;
        this.e = hVar.v;
        this.f = hVar.w;
        this.g = hVar.z;
        this.h = hVar.y;
        this.i = hVar.f;
        this.j = hVar.x;
    }

    public q(Parcel parcel) {
        this.f50a = parcel.readString();
        this.f51b = parcel.readInt();
        boolean z = true;
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() == 0 ? false : z;
        this.k = parcel.readBundle();
    }

    public h a(l lVar, h hVar, o oVar) {
        if (this.l == null) {
            Context h = lVar.h();
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(h.getClassLoader());
            }
            this.l = h.C(h, this.f50a, this.i);
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(h.getClassLoader());
                this.l.f20b = this.k;
            }
            this.l.L0(this.f51b, hVar);
            h hVar2 = this.l;
            hVar2.l = this.c;
            hVar2.n = true;
            hVar2.u = this.d;
            hVar2.v = this.e;
            hVar2.w = this.f;
            hVar2.z = this.g;
            hVar2.y = this.h;
            hVar2.x = this.j;
            hVar2.p = lVar.d;
            if (n.B) {
                Log.v($(22, 37, 6556), $(0, 22, 6025) + this.l);
            }
        }
        h hVar3 = this.l;
        hVar3.s = oVar;
        return hVar3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f50a);
        parcel.writeInt(this.f51b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }
}
