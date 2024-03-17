package com.hunantv.media.player.libnative;

import com.hunantv.media.player.MgtvPlayerLogger;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoReportLog {
    public static void ImgoLogReport(int i, String str, String str2, String str3) {
        if (MgtvPlayerLogger.getLogCallback() != null) {
            if (MgtvPlayerLogger.isDebugMode() || i != 0) {
                MgtvPlayerLogger.OnLogCallback logCallback = MgtvPlayerLogger.getLogCallback();
                logCallback.onLogCb(i, str, "[MgtvCore-" + Thread.currentThread().getId() + "]" + str2, str3);
            }
        }
    }
}
