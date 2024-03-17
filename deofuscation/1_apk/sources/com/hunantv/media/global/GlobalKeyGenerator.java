package com.hunantv.media.global;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GlobalKeyGenerator {
    private static AtomicInteger sKey = new AtomicInteger(1);

    public static synchronized int genKey() {
        int incrementAndGet;
        synchronized (GlobalKeyGenerator.class) {
            incrementAndGet = sKey.incrementAndGet();
        }
        return incrementAndGet;
    }
}
