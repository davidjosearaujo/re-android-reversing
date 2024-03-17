package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator<ProcFile>() { // from class: cn.jiguang.common.app.entity.ProcFile.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ProcFile[] newArray(int i) {
            return new ProcFile[i];
        }
    };
    public final String b;

    public ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return this.b.length();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.b);
    }
}
