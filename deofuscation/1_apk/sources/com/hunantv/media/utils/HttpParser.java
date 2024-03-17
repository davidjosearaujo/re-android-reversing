package com.hunantv.media.utils;

import com.facebook.internal.security.CertificateUtil;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HttpParser {
    public static int parseContentLength(String str) {
        int min;
        if (StringUtil.isSpace(str)) {
            return -1;
        }
        try {
            String substring = str.substring(str.indexOf("Content-Length"));
            if (!StringUtil.isSpace(substring) && (min = Math.min(substring.indexOf("\r"), substring.indexOf("\n"))) >= 0) {
                String trim = substring.substring(14, min).replace(CertificateUtil.DELIMITER, "").trim();
                if (!StringUtil.isSpace(trim)) {
                    return NumericUtil.parseInt(trim, -1);
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }
}
