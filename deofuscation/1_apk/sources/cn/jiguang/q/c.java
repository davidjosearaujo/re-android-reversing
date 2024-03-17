package cn.jiguang.q;

import android.content.Context;
import android.os.Build;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static boolean a(Context context) {
        if (context == null) {
            cn.jiguang.ak.a.d("JDeviceIdsMapHelper", "[hasExternalStoragePermission] context is null");
            return false;
        }
        try {
            if (cn.jiguang.n.d.a(context, "android.permission.READ_EXTERNAL_STORAGE") && cn.jiguang.n.d.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                cn.jiguang.ak.a.a("JDeviceIdsMapHelper", "current sdk code: " + Build.VERSION.SDK_INT + ", has permission: WRITE_EXTERNAL_STORAGE and READ_EXTERNAL_STORAGE");
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean b(Context context) {
        if (context == null) {
            cn.jiguang.ak.a.d("JDeviceIdsMapHelper", "[isTargetApi29] context is null");
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return context.getApplicationInfo().targetSdkVersion >= 29;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
