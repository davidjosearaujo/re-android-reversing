package com.alipay.security.mobile.module.c;

import android.os.Environment;
import java.io.File;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class c {
    public static String a(String str) {
        try {
            if (a()) {
                j.l.c.e0.a.a.b.a();
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str);
                if (file.exists()) {
                    file.delete();
                    return "";
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        j.l.c.e0.a.a.b.c();
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || externalStorageState.length() <= 0) {
            return false;
        }
        if (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) {
            j.l.c.e0.a.a.b.a();
            return Environment.getExternalStorageDirectory() != null;
        }
        return false;
    }
}
