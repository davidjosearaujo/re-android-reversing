package cn.jiguang.at;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ar.c;
import cn.jiguang.ax.g;
import cn.jiguang.ax.h;
import cn.jiguang.internal.JConstants;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    private static boolean a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    private static synchronized void a(Context context) {
        synchronized (a.class) {
            if (a) {
                return;
            }
            if (context == null) {
                return;
            }
            c.c("JCoreActionImpl", "init jcore impl ,version:" + cn.jiguang.a.a.b + ",local version:" + JConstants.SDK_VERSION_INT);
            a = true;
            c.c("JCoreActionImpl", "hb:" + h.a().f() + ",google:true,internal:" + JConstants.INTERNAL_USE);
            ?? r2 = cn.jiguang.a.a.a();
            if (cn.jiguang.a.a.c != JConstants.SDK_VERSION_INT) {
                r2 = 2;
            }
            c.c("JCoreActionImpl", "custom:1,dynamic:" + r2);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, "core", 1, Integer.valueOf((int) r2), Integer.valueOf(cn.jiguang.a.a.c));
            cn.jiguang.ax.c.b(context);
            cn.jiguang.ax.c.a(context);
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        String string;
        a(context);
        if (TextUtils.isEmpty(str)) {
            c.h("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        c.c("JCoreActionImpl", "handleAction action:" + str);
        String string2 = bundle != null ? bundle.getString(HianalyticsBaseData.SDK_TYPE) : "";
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    string = bundle.getString("report_data");
                } catch (Throwable th) {
                    c.g("JCoreActionImpl", "report failed:" + th.getMessage());
                    return;
                }
            } else {
                string = null;
            }
            b.a(context, (Object) string);
        } else if (str.startsWith("tcp_")) {
            h.a().a(context, str, bundle);
        } else if (str.equals("a2")) {
            g.a().a(context, true);
        } else if (str.equals("a3")) {
            cn.jiguang.ax.b.a().a(context, string2, bundle);
        } else if (str.equals("a4")) {
            b.a(context, bundle);
        }
    }
}
