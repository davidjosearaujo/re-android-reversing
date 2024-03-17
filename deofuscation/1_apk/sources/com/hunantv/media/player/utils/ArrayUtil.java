package com.hunantv.media.player.utils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ArrayUtil {
    public static boolean inArrayIgnoreCase(String[] strArr, String str) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!StringUtil.isEmpty(str) && strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (str.toUpperCase().contains(str2.toUpperCase())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
