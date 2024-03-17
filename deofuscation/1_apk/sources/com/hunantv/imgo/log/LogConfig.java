package com.hunantv.imgo.log;

import android.os.Parcel;
import android.os.Parcelable;
import j.l.a.n.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LogConfig implements Parcelable {
    public static Parcelable.Creator<LogConfig> CREATOR = new a();
    public static int netDiagoUpload;
    public long feedbackRetryTimes;
    public long maxLogFileSize;
    public long minFeedbackRetryInteval;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a implements Parcelable.Creator<LogConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LogConfig createFromParcel(Parcel parcel) {
            return new LogConfig(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LogConfig[] newArray(int i) {
            return new LogConfig[i];
        }
    }

    public /* synthetic */ LogConfig(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static LogConfig unmarshall(byte[] bArr, int i) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, i);
        obtain.setDataPosition(0);
        LogConfig createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getFeedbackRetryTimes() {
        return this.feedbackRetryTimes;
    }

    public long getMaxLogFileSize() {
        return this.maxLogFileSize;
    }

    public long getMinFeedbackRetryInteval() {
        return this.minFeedbackRetryInteval;
    }

    public b getProtocolStruct() {
        return new b((byte) 12, toByteArray().length);
    }

    public boolean isValid() {
        return this.maxLogFileSize > 0 && this.feedbackRetryTimes >= 0 && this.minFeedbackRetryInteval > 0;
    }

    public void setFeedbackRetryTimes(long j) {
        this.feedbackRetryTimes = j;
    }

    public void setMaxLogFileSize(long j) {
        this.maxLogFileSize = j;
    }

    public void setMinFeedbackRetryInteval(long j) {
        this.minFeedbackRetryInteval = j;
    }

    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 1);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.maxLogFileSize);
        parcel.writeLong(this.feedbackRetryTimes);
        parcel.writeLong(this.minFeedbackRetryInteval);
    }

    public LogConfig() {
        this.maxLogFileSize = -1L;
        this.feedbackRetryTimes = -1L;
        this.minFeedbackRetryInteval = -1L;
    }

    private LogConfig(Parcel parcel) {
        this.maxLogFileSize = parcel.readLong();
        this.feedbackRetryTimes = parcel.readLong();
        this.minFeedbackRetryInteval = parcel.readLong();
    }
}
