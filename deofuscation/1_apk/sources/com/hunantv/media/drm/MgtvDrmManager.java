package com.hunantv.media.drm;

import c.a.a.b.c.a;
import com.hunantv.media.drm.strategy.StrategyDrmManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MgtvDrmManager {
    private static IDrmManager sInstance;

    public static synchronized IDrmManager getInstance() {
        IDrmManager iDrmManager;
        synchronized (MgtvDrmManager.class) {
            if (sInstance == null) {
                sInstance = StrategyDrmManager.getInstance();
            }
            iDrmManager = sInstance;
        }
        return iDrmManager;
    }

    public static synchronized void setDebugHttpsTrust(boolean z) {
        synchronized (MgtvDrmManager.class) {
            a.k(z);
        }
    }
}
