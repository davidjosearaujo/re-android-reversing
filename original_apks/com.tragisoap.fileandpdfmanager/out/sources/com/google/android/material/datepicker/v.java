package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v implements Comparable<v>, Parcelable {
    public static final Parcelable.Creator<v> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public final Calendar f3122f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3123g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3124h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3125i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3126j;

    /* renamed from: k  reason: collision with root package name */
    public final long f3127k;

    /* renamed from: l  reason: collision with root package name */
    public String f3128l;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Parcelable.Creator<v> {
        @Override // android.os.Parcelable.Creator
        public final v createFromParcel(Parcel parcel) {
            return v.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final v[] newArray(int i7) {
            return new v[i7];
        }
    }

    public v(Calendar calendar) {
        calendar.set(5, 1);
        Calendar c7 = e0.c(calendar);
        this.f3122f = c7;
        this.f3123g = c7.get(2);
        this.f3124h = c7.get(1);
        this.f3125i = c7.getMaximum(7);
        this.f3126j = c7.getActualMaximum(5);
        this.f3127k = c7.getTimeInMillis();
    }

    public static v b(int i7, int i8) {
        Calendar e = e0.e(null);
        e.set(1, i7);
        e.set(2, i8);
        return new v(e);
    }

    public static v f(long j7) {
        Calendar e = e0.e(null);
        e.setTimeInMillis(j7);
        return new v(e);
    }

    @Override // java.lang.Comparable
    public final int compareTo(v vVar) {
        return this.f3122f.compareTo(vVar.f3122f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f3123g == vVar.f3123g && this.f3124h == vVar.f3124h;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3123g), Integer.valueOf(this.f3124h)});
    }

    public final String j() {
        if (this.f3128l == null) {
            this.f3128l = e0.b("yMMMM", Locale.getDefault()).format(new Date(this.f3122f.getTimeInMillis()));
        }
        return this.f3128l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f3124h);
        parcel.writeInt(this.f3123g);
    }
}
