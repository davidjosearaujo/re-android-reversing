package com.hunantv.media.utils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CharUtil {
    public static boolean isChar0To9(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isCharAToZ(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isCharaToz(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isIPChar(char c) {
        return isChar0To9(c) || isCharaToz(c) || isCharAToZ(c) || c == ':' || c == '.';
    }
}
