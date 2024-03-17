package com.alipay.security.mobile.module.c;

import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class b {
    public static String a(String str) {
        String str2;
        try {
            str2 = f.a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (com.alipay.security.mobile.module.a.a.a(str2)) {
            return c.a(".SystemConfig" + File.separator + str);
        }
        return str2;
    }
}
