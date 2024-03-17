package com.hunantv.media.player.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.Window;
import com.hunantv.media.player.helper.BuildHelper;
import com.hunantv.media.player.pragma.DebugLog;
import com.hunantv.media.utils.NumericUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SystemUtil {
    private static final int ROOT_ERR = 2;
    private static final int ROOT_NO = 0;
    private static final int ROOT_NULL = -1;
    private static final int ROOT_YES = 1;
    private static final String TAG = "SystemUtil";
    private static final int VALUE_NOT_GET = -1;
    public static int sHwEmuiAPILevel = -1;
    private static String sPrimaryCpuAbi = null;
    private static int sRoot1 = -1;

    private static boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
        } catch (Throwable unused) {
            process = null;
        }
        try {
            boolean z = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null;
            process.destroy();
            return z;
        } catch (Throwable unused2) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static int getHwEmuiAPILevel() {
        if (sHwEmuiAPILevel == -1) {
            String systemProperty = getSystemProperty("ro.build.magic_api_level");
            if (StringUtil.isEmpty(systemProperty)) {
                systemProperty = getSystemProperty("ro.build.hw_emui_api_level");
            }
            DebugLog.e(TAG, "getHwEmuiAPILevel str" + systemProperty);
            sHwEmuiAPILevel = NumericUtil.parseInt(systemProperty, 0);
            DebugLog.e(TAG, "getHwEmuiAPILevel int" + sHwEmuiAPILevel);
        }
        return sHwEmuiAPILevel;
    }

    public static String getPrimaryCpuAbi(Context context) {
        String str = sPrimaryCpuAbi;
        if (str == null) {
            try {
                if (BuildHelper.isApi21_LollipopOrLater()) {
                    if (context == null) {
                        String str2 = Build.CPU_ABI;
                        sPrimaryCpuAbi = str2;
                        return str2;
                    }
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    Field declaredField = applicationInfo.getClass().getDeclaredField("primaryCpuAbi");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(applicationInfo);
                    if ((obj instanceof String) && !"".equals(((String) obj).trim())) {
                        String str3 = (String) obj;
                        sPrimaryCpuAbi = str3;
                        return str3;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str4 = Build.CPU_ABI;
            sPrimaryCpuAbi = str4;
            return str4;
        }
        return str;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0087: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:35:0x0087 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSystemProperty(java.lang.String r7) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "SystemUtil"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            r4.append(r7)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44 java.io.IOException -> L65
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Exception -> L3e java.io.IOException -> L40 java.lang.Throwable -> L86
            r4.close()     // Catch: java.lang.Exception -> L3e java.io.IOException -> L40 java.lang.Throwable -> L86
            r4.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r7 = move-exception
            com.hunantv.media.player.pragma.DebugLog.e(r1, r0, r7)
        L3d:
            return r3
        L3e:
            r3 = move-exception
            goto L46
        L40:
            r3 = move-exception
            goto L67
        L42:
            r7 = move-exception
            goto L88
        L44:
            r3 = move-exception
            r4 = r2
        L46:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r6 = "Exception Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L86
            r5.append(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L86
            com.hunantv.media.player.pragma.DebugLog.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r7 = move-exception
            com.hunantv.media.player.pragma.DebugLog.e(r1, r0, r7)
        L64:
            return r2
        L65:
            r3 = move-exception
            r4 = r2
        L67:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r5.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r6 = "IOException Unable to read sysprop"
            r5.append(r6)     // Catch: java.lang.Throwable -> L86
            r5.append(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L86
            com.hunantv.media.player.pragma.DebugLog.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L85
            r4.close()     // Catch: java.io.IOException -> L81
            goto L85
        L81:
            r7 = move-exception
            com.hunantv.media.player.pragma.DebugLog.e(r1, r0, r7)
        L85:
            return r2
        L86:
            r7 = move-exception
            r2 = r4
        L88:
            if (r2 == 0) goto L92
            r2.close()     // Catch: java.io.IOException -> L8e
            goto L92
        L8e:
            r2 = move-exception
            com.hunantv.media.player.pragma.DebugLog.e(r1, r0, r2)
        L92:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.media.player.utils.SystemUtil.getSystemProperty(java.lang.String):java.lang.String");
    }

    public static synchronized int isRoot1() {
        int i;
        synchronized (SystemUtil.class) {
            try {
                if (sRoot1 == -1) {
                    sRoot1 = isRoot1Impl() ? 1 : 0;
                }
            } catch (Exception unused) {
                sRoot1 = 2;
            }
            i = sRoot1;
        }
        return i;
    }

    private static boolean isRoot1Impl() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    public static boolean isWindowScreenOn(Activity activity) {
        Window window;
        return (activity == null || (window = activity.getWindow()) == null || (window.getAttributes().flags & 128) == 0) ? false : true;
    }
}
