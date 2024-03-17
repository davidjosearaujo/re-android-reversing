package com.hunantv.media.source;

import java.util.List;
import java.util.Queue;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IImgoQueueCache extends IImgoCache {
    Queue<CacheTask> getPrepareQueue();

    List<CacheTask> getRunningList();
}
