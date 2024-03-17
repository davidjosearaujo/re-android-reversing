package com.alibaba.android.arouter.utils;

import android.net.Uri;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TextUtils {
    public static String formatStackTrace(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ");
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getLeft(String str) {
        return (!str.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || str.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) ? str : str.substring(0, str.indexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
    }

    public static String getRight(String str) {
        return (!str.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || str.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) ? str : str.substring(str.indexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) + 1);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Map<String, String> splitQueryParameters(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            String substring = encodedQuery.substring(i, indexOf2);
            if (!android.text.TextUtils.isEmpty(substring)) {
                linkedHashMap.put(Uri.decode(substring), Uri.decode(indexOf2 == indexOf ? "" : encodedQuery.substring(indexOf2 + 1, indexOf)));
            }
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
