package com.hunantv.media.p2p;

import com.mgtv.easydatasource.p2p.ImgoP2pTask;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class P2pTask implements IP2pTask {
    private ImgoP2pTask task;

    public P2pTask(ImgoP2pTask imgoP2pTask) {
        this.task = imgoP2pTask;
    }

    public static P2pTask build(Object obj) {
        return new P2pTask((ImgoP2pTask) obj);
    }

    @Override // com.hunantv.media.p2p.IP2pTask
    public ImgoP2pTask getImgoTask() {
        return this.task;
    }

    @Override // com.hunantv.media.p2p.IP2pTask
    public int getStatus() {
        ImgoP2pTask imgoP2pTask = this.task;
        if (imgoP2pTask != null) {
            return imgoP2pTask.getStatus();
        }
        return -1;
    }

    @Override // com.hunantv.media.p2p.IP2pTask
    public String getStrHash() {
        ImgoP2pTask imgoP2pTask = this.task;
        if (imgoP2pTask != null) {
            return imgoP2pTask.getStrHash();
        }
        return null;
    }
}
