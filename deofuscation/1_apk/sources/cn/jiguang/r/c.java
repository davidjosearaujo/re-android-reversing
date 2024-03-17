package cn.jiguang.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import java.io.File;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public static JSONObject a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 42, null, null, str);
                    if (onEvent instanceof JSONObject) {
                        return (JSONObject) onEvent;
                    }
                    return null;
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommonFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File d = cn.jiguang.n.d.d(context, str);
                    if (d == null) {
                        return false;
                    }
                    return cn.jiguang.n.d.a(d, str2);
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        boolean booleanValue;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 41, null, null, str, jSONObject);
                    booleanValue = onEvent instanceof Boolean ? ((Boolean) onEvent).booleanValue() : false;
                }
                return booleanValue;
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommonFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(context, str, (JSONObject) null)) {
                return;
            }
            synchronized (str) {
                context.deleteFile(str);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JCommonFileHelper", "cleanJson throwable:" + th.getMessage());
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    if (cn.jiguang.n.d.d(context, str) == null) {
                        return false;
                    }
                    return ((Boolean) JCoreManager.onEvent(context, "JCOMMON", 79, null, null, str, str2)).booleanValue();
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File d = cn.jiguang.n.d.d(context, str);
                    if (d == null) {
                        return null;
                    }
                    return cn.jiguang.n.d.a(d);
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JCommonFileHelper", "readString throwable:" + th.getMessage());
            }
        }
        return null;
    }

    public static void d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (str) {
                File d = cn.jiguang.n.d.d(context, str);
                if (d == null) {
                    return;
                }
                cn.jiguang.n.d.a(d, "");
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JCommonFileHelper", "cleanString throwable:" + th.getMessage());
        }
    }
}
