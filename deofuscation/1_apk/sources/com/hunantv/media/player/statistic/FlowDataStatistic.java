package com.hunantv.media.player.statistic;

import com.hunantv.media.player.utils.StringUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FlowDataStatistic {
    private static final String tag = "FlowDataStatistic";
    private volatile long mLastDataBytes;
    private volatile long mStaticIntervalBytes;
    private volatile long mTotalDataBytes;
    private Object mLocker = new Object();
    private volatile boolean mBindPlayerLifecycle = true;
    private volatile String mLogTag = tag;

    public void addBytes(long j) {
        synchronized (this.mLocker) {
            this.mTotalDataBytes += j;
        }
    }

    public void bindPlayerLifecycle(boolean z) {
        this.mBindPlayerLifecycle = z;
    }

    public long getDynamicIntervalBytes() {
        long j;
        synchronized (this.mLocker) {
            this.mStaticIntervalBytes = this.mTotalDataBytes - this.mLastDataBytes;
            this.mLastDataBytes = this.mTotalDataBytes;
            j = this.mStaticIntervalBytes;
        }
        return j;
    }

    public long getLastStaticIntervalBytes() {
        long j;
        synchronized (this.mLocker) {
            j = this.mStaticIntervalBytes;
        }
        return j;
    }

    public long getTotalBytes() {
        long j;
        synchronized (this.mLocker) {
            j = this.mTotalDataBytes;
        }
        return j;
    }

    public boolean isBindPlayerLifecycle() {
        return this.mBindPlayerLifecycle;
    }

    public void reset() {
        synchronized (this.mLocker) {
            this.mTotalDataBytes = 0L;
            this.mLastDataBytes = 0L;
            this.mStaticIntervalBytes = 0L;
        }
    }

    public void setLogTag(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.mLogTag = str;
    }

    public void setTotalDataBytes(long j) {
        this.mTotalDataBytes = j;
    }
}
