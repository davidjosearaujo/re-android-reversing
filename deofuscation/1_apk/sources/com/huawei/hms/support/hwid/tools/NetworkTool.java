package com.huawei.hms.support.hwid.tools;

import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.hunantv.imgo.entity.JumpAction;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class NetworkTool {
    private static boolean a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static String buildNetworkCookie(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (a(bool)) {
            sb.append(";HttpOnly");
        }
        if (a(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l != null && l.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l);
        }
        return sb.toString();
    }

    public static String buildNetworkUrl(String str, Boolean bool) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = a(bool) ? "https" : UriUtil.HTTP_SCHEME;
            StringBuilder sb = new StringBuilder(str2.length() + 3 + String.valueOf(str).length());
            sb.append(str2);
            sb.append(JumpAction.STR_SCHEM_SPLIT);
            sb.append(str);
            return sb.toString();
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }
}
