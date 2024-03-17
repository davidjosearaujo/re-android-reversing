package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Cgroup extends ProcFile {
    public static final Parcelable.Creator<Cgroup> CREATOR = new Parcelable.Creator<Cgroup>() { // from class: cn.jiguang.common.app.entity.Cgroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Cgroup createFromParcel(Parcel parcel) {
            return new Cgroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Cgroup[] newArray(int i) {
            return new Cgroup[i];
        }
    };
    public final ArrayList<ControlGroup> a;

    private Cgroup(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }

    @Override // cn.jiguang.common.app.entity.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }
}
