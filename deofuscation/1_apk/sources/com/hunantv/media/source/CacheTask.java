package com.hunantv.media.source;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CacheTask {
    public static final int TYPE_FLV = 2;
    public static final int TYPE_M3U8 = 0;
    public static final int TYPE_MP4 = 1;
    public static final int TYPE_UNKNOW = -1;
    private volatile Status mCurrentStatus;
    private int mDetailCode;
    private int mErrorCode;
    private String mFileName;
    private String mFullPath;
    private int mStartTimeMs;
    public int mStreamId;
    private String mTaskID;
    private String mTempPath;
    private String[] mTsNames;
    private int mTsNum;
    private int mType;
    public String mUrl;
    public String mVid;
    private int mWriteM3u8;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Status {
        NONE,
        START,
        PAUSE,
        SUCCESS,
        FAILED
    }

    public CacheTask(String str, String str2, int i) {
        this.mCurrentStatus = Status.NONE;
        this.mWriteM3u8 = 1;
        this.mType = -1;
        this.mTsNames = new String[0];
        this.mUrl = str;
        this.mVid = str2;
        this.mStreamId = i;
    }

    public CacheTask(String str, String str2, int i, int i2) {
        this.mCurrentStatus = Status.NONE;
        this.mWriteM3u8 = 1;
        this.mType = -1;
        this.mTsNames = new String[0];
        this.mUrl = str;
        this.mVid = str2;
        this.mStreamId = i;
        this.mWriteM3u8 = i2;
    }

    public Status getCurrentStatus() {
        return this.mCurrentStatus;
    }

    public int getDetailCode() {
        return this.mDetailCode;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFullPath() {
        return this.mFullPath;
    }

    public int getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public int getStreamId() {
        return this.mStreamId;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public String getTempPath() {
        return this.mTempPath;
    }

    public String[] getTsNames() {
        return this.mTsNames;
    }

    public int getTsNum() {
        return this.mTsNum;
    }

    public int getType() {
        return this.mType;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getVid() {
        return this.mVid;
    }

    public int getWriteM3u8() {
        return this.mWriteM3u8;
    }

    public boolean isFailed() {
        return this.mCurrentStatus == Status.FAILED;
    }

    public boolean isStart() {
        return this.mCurrentStatus != Status.NONE;
    }

    public boolean isSuccess() {
        return this.mCurrentStatus == Status.SUCCESS;
    }

    public void reset() {
        this.mCurrentStatus = Status.NONE;
        this.mTempPath = null;
        this.mTsNum = 0;
        this.mErrorCode = 0;
        this.mDetailCode = 0;
        this.mFullPath = null;
        this.mFileName = null;
        this.mType = -1;
        this.mTsNames = new String[0];
        this.mTaskID = null;
    }

    public synchronized CacheTask setCurrentStatus(Status status) {
        this.mCurrentStatus = status;
        return this;
    }

    public CacheTask setDetailCode(int i) {
        this.mDetailCode = i;
        return this;
    }

    public CacheTask setErrorCode(int i) {
        this.mErrorCode = i;
        return this;
    }

    public CacheTask setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    public CacheTask setFullPath(String str) {
        this.mFullPath = str;
        return this;
    }

    public void setStartTimeMs(int i) {
        this.mStartTimeMs = i;
    }

    public CacheTask setStreamId(int i) {
        this.mStreamId = i;
        return this;
    }

    public void setTaskID(String str) {
        this.mTaskID = str;
    }

    public CacheTask setTempPath(String str) {
        this.mTempPath = str;
        return this;
    }

    public CacheTask setTsNames(String[] strArr) {
        this.mTsNames = strArr;
        return this;
    }

    public CacheTask setTsNum(int i) {
        this.mTsNum = i;
        return this;
    }

    public CacheTask setType(int i) {
        this.mType = i;
        return this;
    }

    public CacheTask setUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public CacheTask setVid(String str) {
        this.mVid = str;
        return this;
    }

    public CacheTask setWriteM3u8(int i) {
        this.mWriteM3u8 = i;
        return this;
    }
}
