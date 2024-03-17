package com.hunantv.media.global;

import com.hunantv.media.player.pragma.DebugLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayerReferenceObserver {
    private static final String TAG = "PlayerReferenceObserver";
    private static Map<String, String> sSyncReferenceMap = Collections.synchronizedMap(new HashMap());

    public static synchronized void add(String str, String str2, String str3) {
        synchronized (PlayerReferenceObserver.class) {
            try {
                DebugLog.i(TAG, "add new player:" + str + " ,detail:" + str3 + " ,already exist " + sSyncReferenceMap.size() + " player");
                sSyncReferenceMap.put(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void remove(String str) {
        synchronized (PlayerReferenceObserver.class) {
            try {
                if (sSyncReferenceMap.containsKey(str)) {
                    DebugLog.i(TAG, "remove player :" + str);
                    sSyncReferenceMap.remove(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int size() {
        try {
            return sSyncReferenceMap.size();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
