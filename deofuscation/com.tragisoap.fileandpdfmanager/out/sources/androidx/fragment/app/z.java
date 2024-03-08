package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.x;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c0> f1808f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f1809g;

    /* renamed from: h  reason: collision with root package name */
    public b[] f1810h;

    /* renamed from: i  reason: collision with root package name */
    public int f1811i;

    /* renamed from: j  reason: collision with root package name */
    public String f1812j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<String> f1813k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<Bundle> f1814l;
    public ArrayList<x.k> m;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Parcelable.Creator<z> {
        @Override // android.os.Parcelable.Creator
        public final z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final z[] newArray(int i7) {
            return new z[i7];
        }
    }

    public z() {
        this.f1812j = null;
        this.f1813k = new ArrayList<>();
        this.f1814l = new ArrayList<>();
    }

    public z(Parcel parcel) {
        this.f1812j = null;
        this.f1813k = new ArrayList<>();
        this.f1814l = new ArrayList<>();
        this.f1808f = parcel.createTypedArrayList(c0.CREATOR);
        this.f1809g = parcel.createStringArrayList();
        this.f1810h = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1811i = parcel.readInt();
        this.f1812j = parcel.readString();
        this.f1813k = parcel.createStringArrayList();
        this.f1814l = parcel.createTypedArrayList(Bundle.CREATOR);
        this.m = parcel.createTypedArrayList(x.k.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeTypedList(this.f1808f);
        parcel.writeStringList(this.f1809g);
        parcel.writeTypedArray(this.f1810h, i7);
        parcel.writeInt(this.f1811i);
        parcel.writeString(this.f1812j);
        parcel.writeStringList(this.f1813k);
        parcel.writeTypedList(this.f1814l);
        parcel.writeTypedList(this.m);
    }
}
