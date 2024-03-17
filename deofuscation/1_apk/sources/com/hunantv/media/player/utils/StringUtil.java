package com.hunantv.media.player.utils;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StringUtil {
    public static boolean contains(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.contains(str2);
    }

    private static String getPadding(CharSequence charSequence, int i) {
        if (charSequence.length() < i) {
            return multiply(charSequence, Integer.valueOf((i / charSequence.length()) + 1)).substring(0, i);
        }
        return "" + ((Object) charSequence.subSequence(0, i));
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isHtml(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return str.contains("<!DOCTYPE html>") || str.contains("<html>");
    }

    public static String multiply(CharSequence charSequence, Number number) {
        int intValue = number.intValue();
        if (intValue == 0) {
            return "";
        }
        if (intValue < 0) {
            throw new IllegalArgumentException("multiply() should be called with a number of 0 or greater not: " + intValue);
        }
        StringBuilder sb = new StringBuilder(charSequence);
        for (int i = 1; i < intValue; i++) {
            sb.append(charSequence);
        }
        return sb.toString();
    }

    public static String padRight(CharSequence charSequence, Number number) {
        return padRight(charSequence, number, " ");
    }

    public static String padRight(CharSequence charSequence, Number number, CharSequence charSequence2) {
        int intValue = number.intValue();
        if (intValue <= charSequence.length()) {
            return charSequence.toString();
        }
        return ((Object) charSequence) + getPadding(charSequence2.toString(), intValue - charSequence.length());
    }

    public static String parseValue(String str, String str2) {
        String[] split;
        if (isEmpty(str)) {
            return str;
        }
        try {
            split = str.split(str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (split.length == 1) {
            return "";
        }
        if (split.length >= 2) {
            return split[1];
        }
        return str;
    }

    public static String removeSpace(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(" ", "");
    }

    public static String safeToLowerCase(String str) {
        return isEmpty(str) ? str : str.toLowerCase();
    }

    public static String trim(String str) {
        if (str == null) {
            return "";
        }
        try {
            return str.trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
