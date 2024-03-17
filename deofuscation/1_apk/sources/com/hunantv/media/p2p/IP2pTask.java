package com.hunantv.media.p2p;

import com.mgtv.easydatasource.p2p.ImgoP2pTask;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface IP2pTask {
    public static final int STATUS_NONE = -1;
    public static final int STATUS_PAUSE = 1;
    public static final int STATUS_RUNNING = 0;

    ImgoP2pTask getImgoTask();

    int getStatus();

    String getStrHash();
}
