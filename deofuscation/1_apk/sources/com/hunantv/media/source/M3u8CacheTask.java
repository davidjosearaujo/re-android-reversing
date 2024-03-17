package com.hunantv.media.source;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class M3u8CacheTask {
    private String mFullPath;
    private String mM3u8Name;
    private int mStreamId;
    public String mTaskID;
    private int mTsNum;
    private String mUrl;
    private String mVid;
    private boolean mWriteM3u8;
    private Status mCurrentStatus = Status.NONE;
    private String[] mTsNames = new String[0];

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Status {
        NONE,
        SUCCESS,
        FAILED
    }

    public M3u8CacheTask(String str, String str2, int i, int i2, boolean z) {
        this.mUrl = str;
        this.mVid = str2;
        this.mStreamId = i;
        this.mTsNum = i2;
        this.mWriteM3u8 = z;
    }

    public Status getCurrentStatus() {
        return this.mCurrentStatus;
    }

    public String getFullPath() {
        return this.mFullPath;
    }

    public String getM3u8Name() {
        return this.mM3u8Name;
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public String[] getTsNames() {
        return this.mTsNames;
    }

    public int getTsNum() {
        return this.mTsNum;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVid() {
        return this.mVid;
    }

    public boolean isFailed() {
        return this.mCurrentStatus == Status.FAILED;
    }

    public boolean isSuccess() {
        return this.mCurrentStatus == Status.SUCCESS;
    }

    public boolean isWriteM3u8() {
        return this.mWriteM3u8;
    }

    public M3u8CacheTask setCurrentStatus(Status status) {
        this.mCurrentStatus = status;
        return this;
    }

    public M3u8CacheTask setFullPath(String str) {
        this.mFullPath = str;
        return this;
    }

    public M3u8CacheTask setM3u8Name(String str) {
        this.mM3u8Name = str;
        return this;
    }

    public M3u8CacheTask setStreamId(int i) {
        this.mStreamId = i;
        return this;
    }

    public M3u8CacheTask setTsNames(String[] strArr) {
        this.mTsNames = strArr;
        return this;
    }

    public M3u8CacheTask setTsNum(int i) {
        this.mTsNum = i;
        return this;
    }

    public M3u8CacheTask setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public M3u8CacheTask setVid(String str) {
        this.mVid = str;
        return this;
    }

    public M3u8CacheTask setWriteM3u8(boolean z) {
        this.mWriteM3u8 = z;
        return this;
    }
}
