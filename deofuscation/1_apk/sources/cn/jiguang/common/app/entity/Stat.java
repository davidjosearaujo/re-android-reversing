package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Stat extends ProcFile {
    public static final Parcelable.Creator<Stat> CREATOR = new Parcelable.Creator<Stat>() { // from class: cn.jiguang.common.app.entity.Stat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Stat createFromParcel(Parcel parcel) {
            return new Stat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Stat[] newArray(int i) {
            return new Stat[i];
        }
    };
    private final String[] a;

    private Stat(Parcel parcel) {
        super(parcel);
        this.a = parcel.createStringArray();
    }

    @Override // cn.jiguang.common.app.entity.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeStringArray(this.a);
    }
}
