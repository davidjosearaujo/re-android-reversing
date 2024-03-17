package com.hunantv.media.utils;

import android.app.ActivityManager;
import android.content.Context;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MemoryUtil {
    public static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
