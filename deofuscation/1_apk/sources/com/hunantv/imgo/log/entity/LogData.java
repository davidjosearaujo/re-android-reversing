package com.hunantv.imgo.log.entity;

import android.os.Parcel;
import android.os.Parcelable;
import j.l.a.n.k.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LogData implements Parcelable {
    public static Parcelable.Creator<LogData> CREATOR = new a();
    private static final String TIME_PATTERN = "MM-dd HH:mm:ss.SSS";
    private boolean isNewFormat;
    private byte level;
    private String moduleid;
    private String msg;
    private String tag;
    private long time;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Parcelable.Creator<LogData> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LogData createFromParcel(Parcel parcel) {
            return new LogData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LogData[] newArray(int i) {
            return new LogData[i];
        }
    }

    public /* synthetic */ LogData(Parcel parcel, a aVar) {
        this(parcel);
    }

    private String getLevel() {
        byte b = this.level;
        return b != 1 ? b != 2 ? b != 3 ? "D" : "E" : "I" : "D";
    }

    private CharSequence getTime() {
        return new SimpleDateFormat(TIME_PATTERN, Locale.getDefault()).format(new Date(this.time));
    }

    public static LogData unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        LogData createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getModuleid() {
        return this.moduleid;
    }

    public b getProtocolStruct() {
        return new b((byte) 11, toByteArray().length);
    }

    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 1);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public String toString() {
        if (this.isNewFormat) {
            return this.tag + " " + this.msg;
        }
        return "[" + ((Object) getTime()) + ": " + getLevel() + this.tag + "]  " + this.msg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.level);
        parcel.writeLong(this.time);
        parcel.writeString(this.moduleid);
        parcel.writeString(this.tag);
        parcel.writeString(this.msg);
        parcel.writeByte(this.isNewFormat ? (byte) 1 : (byte) 0);
    }

    public LogData(byte b, String str, String str2, String str3) {
        this.level = b;
        this.moduleid = str;
        this.tag = str2;
        this.msg = str3;
        this.time = System.currentTimeMillis();
    }

    public LogData(j.l.a.n.m.b bVar) {
        this.level = bVar.d;
        this.tag = bVar.b();
        this.msg = bVar.a();
        this.isNewFormat = true;
    }

    private LogData(Parcel parcel) {
        this.level = parcel.readByte();
        this.time = parcel.readLong();
        this.moduleid = parcel.readString();
        this.tag = parcel.readString();
        this.msg = parcel.readString();
        this.isNewFormat = parcel.readByte() != 0;
    }
}
