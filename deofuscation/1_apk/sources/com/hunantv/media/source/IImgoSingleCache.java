package com.hunantv.media.source;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IImgoSingleCache extends IImgoCache {
    void cancel();

    CacheTask getRunningTask();
}
