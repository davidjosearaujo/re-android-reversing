package a.a.a.a;

import a.a.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class c implements Parcelable {
    private static short[] $ = {4910, 4879, 4884, 4928, 4879, 4878, 4928, 4866, 4865, 4867, 4875, 4928, 4883, 4884, 4865, 4867, 4875, 7852, 7819, 7830, 7825, 7812, 7819, 7825, 7820, 7812, 7825, 7808, 7877, 4291, 4236, 4243, 4291, 4288, 9244, 9310, 9309, 9295, 9305, 9244, 9306, 9294, 9309, 9307, 9297, 9305, 9298, 9288, 9244, 9247, 6151, 6195, 6176, 6182, 6188, 6180, 6191, 6197, 6156, 6176, 6191, 6176, 6182, 6180, 6195};
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f8a;

    /* renamed from: b  reason: collision with root package name */
    final int f9b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class a implements Parcelable.Creator<c> {
        a() {
        }

        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: b */
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public c(b bVar) {
        int size = bVar.f3b.size();
        this.f8a = new int[size * 6];
        if (bVar.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                b.a aVar = bVar.f3b.get(i2);
                int[] iArr = this.f8a;
                int i3 = i + 1;
                iArr[i] = aVar.f4a;
                int i4 = i3 + 1;
                h hVar = aVar.f5b;
                iArr[i3] = hVar != null ? hVar.d : -1;
                int[] iArr2 = this.f8a;
                int i5 = i4 + 1;
                iArr2[i4] = aVar.c;
                int i6 = i5 + 1;
                iArr2[i5] = aVar.d;
                int i7 = i6 + 1;
                iArr2[i6] = aVar.e;
                i = i7 + 1;
                iArr2[i7] = aVar.f;
            }
            this.f9b = bVar.g;
            this.c = bVar.h;
            this.d = bVar.j;
            this.e = bVar.l;
            this.f = bVar.m;
            this.g = bVar.n;
            this.h = bVar.o;
            this.i = bVar.p;
            this.j = bVar.q;
            this.k = bVar.r;
            this.l = bVar.s;
            return;
        }
        throw new IllegalStateException($(0, 17, 4960));
    }

    public c(Parcel parcel) {
        this.f8a = parcel.createIntArray();
        this.f9b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public b a(n nVar) {
        b bVar = new b(nVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f8a.length) {
            b.a aVar = new b.a();
            int i3 = i + 1;
            aVar.f4a = this.f8a[i];
            if (n.B) {
                Log.v($(50, 65, 6209), $(17, 29, 7909) + bVar + $(29, 34, 4323) + i2 + $(34, 50, 9276) + this.f8a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f8a[i3];
            aVar.f5b = i5 >= 0 ? nVar.c.get(i5) : null;
            int[] iArr = this.f8a;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            aVar.c = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar.d = i9;
            int i10 = i8 + 1;
            int i11 = iArr[i8];
            aVar.e = i11;
            i = i10 + 1;
            int i12 = iArr[i10];
            aVar.f = i12;
            bVar.c = i7;
            bVar.d = i9;
            bVar.e = i11;
            bVar.f = i12;
            bVar.f(aVar);
            i2++;
        }
        bVar.g = this.f9b;
        bVar.h = this.c;
        bVar.j = this.d;
        bVar.l = this.e;
        bVar.i = true;
        bVar.m = this.f;
        bVar.n = this.g;
        bVar.o = this.h;
        bVar.p = this.i;
        bVar.q = this.j;
        bVar.r = this.k;
        bVar.s = this.l;
        bVar.g(1);
        return bVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f8a);
        parcel.writeInt(this.f9b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }
}
