package a.a.a.a;

import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class p implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    q[] f48a;

    /* renamed from: b  reason: collision with root package name */
    int[] f49b;
    c[] c;

    /* loaded from: /home/remnux/decompressedMalicious.dex */
    static class a implements Parcelable.Creator<p> {
        a() {
        }

        /* renamed from: a */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        /* renamed from: b */
        public p[] newArray(int i) {
            return new p[i];
        }
    }

    public p() {
    }

    public p(Parcel parcel) {
        this.f48a = (q[]) parcel.createTypedArray(q.CREATOR);
        this.f49b = parcel.createIntArray();
        this.c = (c[]) parcel.createTypedArray(c.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f48a, i);
        parcel.writeIntArray(this.f49b);
        parcel.writeTypedArray(this.c, i);
    }
}
