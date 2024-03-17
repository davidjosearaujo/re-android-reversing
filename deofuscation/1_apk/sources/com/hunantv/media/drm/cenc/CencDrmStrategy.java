package com.hunantv.media.drm.cenc;

import c.a.a.b.d.g;
import cn.jiguang.internal.JConstants;
import com.hunantv.media.drm.MgtvDrmConstans;
import com.hunantv.media.drm.utils.MgtvDrmUtils;
import com.hunantv.media.player.pragma.DebugLog;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CencDrmStrategy {
    public static final int MAX_ERROR_COUNTER = 3;
    public static final int RESUME_INTERVAL = 3600000;
    public static final String TAG = "CencDrmStrategy";
    public static int sErrorCounter;
    public static boolean sErrorZone;
    public static long sErrorZoneTimestamp;
    public static Object sLocker = new Object();

    public static boolean isCencSupported() {
        synchronized (sLocker) {
            boolean z = false;
            if (sErrorZone) {
                if (sErrorZoneTimestamp > 0 && System.currentTimeMillis() - sErrorZoneTimestamp < JConstants.HOUR) {
                    DebugLog.i(TAG, "not support because in error zone");
                    return false;
                }
                DebugLog.i(TAG, "jump error zone cause beyond time");
                sErrorCounter = 0;
                sErrorZone = false;
                sErrorZoneTimestamp = 0L;
            }
            if ("HUAWEI".equalsIgnoreCase(g.i()) && MgtvDrmUtils.isCryptoSchemeSupported(MgtvDrmConstans.CHINADRM_UUID)) {
                z = true;
            }
            return z;
        }
    }

    public static void notifyError() {
        synchronized (sLocker) {
            sErrorCounter++;
            DebugLog.i(TAG, "notifyError sErrorCounter:" + sErrorCounter);
            if (sErrorCounter >= 3) {
                DebugLog.i(TAG, "goto Error Zone");
                sErrorZone = true;
                sErrorZoneTimestamp = System.currentTimeMillis();
            }
        }
    }

    public static void notifySuccess() {
        synchronized (sLocker) {
            DebugLog.i(TAG, "notifySuccess");
            sErrorCounter = 0;
            sErrorZone = false;
            sErrorZoneTimestamp = 0L;
        }
    }
}
