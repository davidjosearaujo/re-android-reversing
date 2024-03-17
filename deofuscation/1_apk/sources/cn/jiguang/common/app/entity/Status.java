package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class Status extends ProcFile {
    public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator<Status>() { // from class: cn.jiguang.common.app.entity.Status.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Status[] newArray(int i) {
            return new Status[i];
        }
    };

    private Status(Parcel parcel) {
        super(parcel);
    }
}
