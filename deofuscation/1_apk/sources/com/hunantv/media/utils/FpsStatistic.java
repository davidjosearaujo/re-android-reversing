package com.hunantv.media.utils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FpsStatistic {
    private static final int FPS_CALCULATE_TIME_S = 3;
    private volatile boolean mFpsStar;
    private volatile long mFpsStartTimeMs;
    private volatile int mFpsCounter = 0;
    private volatile int mFps = -1;

    private void resetFpsTimeAndCounter() {
        this.mFpsStartTimeMs = 0L;
        this.mFpsCounter = 0;
    }

    public int getFps() {
        return this.mFps;
    }

    public void onFrame() {
        if (this.mFpsStar) {
            if (this.mFpsStartTimeMs <= 0) {
                this.mFpsStartTimeMs = System.currentTimeMillis();
            }
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.mFpsStartTimeMs) / 1000);
            if (this.mFpsStartTimeMs <= 0 || currentTimeMillis <= 0) {
                return;
            }
            this.mFpsCounter++;
            if (currentTimeMillis <= 3) {
                return;
            }
            this.mFps = this.mFpsCounter / currentTimeMillis;
        }
        resetFpsTimeAndCounter();
    }

    public void resetFps() {
        this.mFps = -1;
        resetFpsTimeAndCounter();
    }

    public void startFps() {
        this.mFpsStar = true;
    }

    public void stopFps() {
        this.mFpsStar = false;
        resetFpsTimeAndCounter();
    }
}
