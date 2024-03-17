package com.hunantv.media.drm;

import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgtvDrmHelper {
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID WISEPLAY_DRM_UUID = new UUID(4422091961135677928L, -5169044695670406100L);
    private static String sWpSupportMsg;
    private static String sWvSupportMsg;

    public static synchronized String getWidevineSupportMsg() {
        String str;
        synchronized (MgtvDrmHelper.class) {
            str = sWvSupportMsg;
        }
        return str;
    }

    public static synchronized String getWisePlaySupportMsg() {
        synchronized (MgtvDrmHelper.class) {
        }
        return "ng";
    }

    public static void updateWidevineSupportMsg() {
        sWvSupportMsg = "n";
    }
}
