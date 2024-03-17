package com.hunantv.media.drm.cbcs;

import cn.jiguang.internal.JConstants;
import com.hunantv.media.player.loader.ImgoLibLoader;
import com.hunantv.media.player.pragma.DebugLog;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CbcsDrmStrategy {
    public static final int MAX_ERROR_COUNTER = 3;
    public static final int RESUME_INTERVAL = 3600000;
    public static final String TAG = "CbcsDrmStrategy";
    public static int sErrorCounter;
    public static boolean sErrorZone;
    public static long sErrorZoneTimestamp;
    public static Object sLocker = new Object();

    public static boolean isCbcsSupported() {
        synchronized (sLocker) {
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
            return ImgoLibLoader.getInstance().isPlayerLibLoaded();
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
