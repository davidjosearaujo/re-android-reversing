package com.facebook.imagepipeline.core;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PriorityThreadFactory implements ThreadFactory {
    private final boolean mAddThreadNumber;
    private final String mPrefix;
    private final AtomicInteger mThreadNumber;
    private final int mThreadPriority;

    public PriorityThreadFactory(int i) {
        this(i, "PriorityThreadFactory", true);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        String str;
        Runnable runnable2 = new Runnable() { // from class: com.facebook.imagepipeline.core.PriorityThreadFactory.1
            {
                PriorityThreadFactory.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(PriorityThreadFactory.this.mThreadPriority);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        };
        if (this.mAddThreadNumber) {
            str = this.mPrefix + "-" + this.mThreadNumber.getAndIncrement();
        } else {
            str = this.mPrefix;
        }
        return new Thread(runnable2, str);
    }

    public PriorityThreadFactory(int i, String str, boolean z) {
        this.mThreadNumber = new AtomicInteger(1);
        this.mThreadPriority = i;
        this.mPrefix = str;
        this.mAddThreadNumber = z;
    }
}
