package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0034a();

    /* renamed from: f */
    public final v f3036f;

    /* renamed from: g */
    public final v f3037g;

    /* renamed from: h */
    public final c f3038h;

    /* renamed from: i */
    public v f3039i;

    /* renamed from: j */
    public final int f3040j;

    /* renamed from: k */
    public final int f3041k;

    /* renamed from: l */
    public final int f3042l;

    /* renamed from: com.google.android.material.datepicker.a$a */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class C0034a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public final a createFromParcel(Parcel parcel) {
            return new a((v) parcel.readParcelable(v.class.getClassLoader()), (v) parcel.readParcelable(v.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (v) parcel.readParcelable(v.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final a[] newArray(int i7) {
            return new a[i7];
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b {

        /* renamed from: f */
        public static final long f3043f = e0.a(v.b(1900, 0).f3127k);

        /* renamed from: g */
        public static final long f3044g = e0.a(v.b(2100, 11).f3127k);

        /* renamed from: a */
        public long f3045a;

        /* renamed from: b */
        public long f3046b;

        /* renamed from: c */
        public Long f3047c;

        /* renamed from: d */
        public int f3048d;
        public c e;

        public b(a aVar) {
            this.f3045a = f3043f;
            this.f3046b = f3044g;
            this.e = new e(Long.MIN_VALUE);
            this.f3045a = aVar.f3036f.f3127k;
            this.f3046b = aVar.f3037g.f3127k;
            this.f3047c = Long.valueOf(aVar.f3039i.f3127k);
            this.f3048d = aVar.f3040j;
            this.e = aVar.f3038h;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c extends Parcelable {
        boolean g(long j7);
    }

    public a(v vVar, v vVar2, c cVar, v vVar3, int i7) {
        Objects.requireNonNull(vVar, "start cannot be null");
        Objects.requireNonNull(vVar2, "end cannot be null");
        Objects.requireNonNull(cVar, "validator cannot be null");
        this.f3036f = vVar;
        this.f3037g = vVar2;
        this.f3039i = vVar3;
        this.f3040j = i7;
        this.f3038h = cVar;
        if (vVar3 != null && vVar.f3122f.compareTo(vVar3.f3122f) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (vVar3 != null && vVar3.f3122f.compareTo(vVar2.f3122f) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (i7 < 0 || i7 > e0.e(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else if (vVar.f3122f instanceof GregorianCalendar) {
            int i8 = vVar2.f3124h;
            int i9 = vVar.f3124h;
            this.f3042l = (vVar2.f3123g - vVar.f3123g) + ((i8 - i9) * 12) + 1;
            this.f3041k = (i8 - i9) + 1;
        } else {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
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
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3036f.equals(aVar.f3036f) && this.f3037g.equals(aVar.f3037g) && o1.b.a(this.f3039i, aVar.f3039i) && this.f3040j == aVar.f3040j && this.f3038h.equals(aVar.f3038h);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3036f, this.f3037g, this.f3039i, Integer.valueOf(this.f3040j), this.f3038h});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        parcel.writeParcelable(this.f3036f, 0);
        parcel.writeParcelable(this.f3037g, 0);
        parcel.writeParcelable(this.f3039i, 0);
        parcel.writeParcelable(this.f3038h, 0);
        parcel.writeInt(this.f3040j);
    }
}
