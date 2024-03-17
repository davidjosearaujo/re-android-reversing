package com.hunantv.media.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class NumericUtil {
    public static String getDataNoByPageIndex(int i) {
        return i == 0 ? "" : String.format("%02d", Integer.valueOf(i));
    }

    public static boolean isNumeric(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isOdd(int i) {
        return (i & 1) == 1;
    }

    public static float parseFloat(@Nullable String str) {
        return parseFloat(str, 0.0f);
    }

    public static float parseFloat(@Nullable String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f;
        }
    }

    public static int parseInt(@Nullable String str) {
        return parseInt(str, 0);
    }

    public static int parseInt(@Nullable String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long parseLong(@Nullable String str) {
        return parseLong(str, 0L);
    }

    public static long parseLong(@Nullable String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
