package com.hunantv.media.utils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StringUtil {
    public static String formatArrayString(String[] strArr) {
        String str = "";
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                str = str + str2 + ",";
            }
        }
        return str;
    }

    public static boolean isSpace(String str) {
        return str == null || "".equals(str.trim());
    }
}
