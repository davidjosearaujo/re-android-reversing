package cn.jiguang.aq;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    private static final Object a = new Object();
    private static volatile d b;
    private static String c;
    private static String d;

    public static d a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public static String a(Context context) {
        String str = d;
        if (str != null) {
            return str;
        }
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            d = "";
            return "";
        }
        d = cn.jiguang.f.a.a(context, b2);
        cn.jiguang.ar.c.c("JCommonServiceHelper", "user serviceProcess is:" + d);
        return d;
    }

    public static String b(Context context) {
        ComponentInfo a2;
        String str;
        try {
            str = c;
        } catch (Throwable th) {
            cn.jiguang.ar.c.c("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (str != null) {
            return str;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        List<String> a3 = cn.jiguang.f.a.a(context, intent, "");
        if (a3 != null && a3.size() >= 1 && JCommonService.class.isAssignableFrom(Class.forName(a3.get(0)))) {
            c = a3.get(0);
            cn.jiguang.ar.c.f("JCommonServiceHelper", "found userServiceClass :" + c + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(c) && (a2 = cn.jiguang.f.a.a(context, context.getPackageName(), JCommonService.class)) != null) {
            c = a2.name;
            cn.jiguang.ar.c.f("JCommonServiceHelper", "found userServiceClass :" + c + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        return c;
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.ar.c.c("JCommonServiceHelper", sb.toString());
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                cn.jiguang.a.a.b(context, str, bundle);
            } else {
                e.a().a(context, b2, str, bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.ar.c.e("JCommonServiceHelper", "onAction failed", th);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.ar.c.e("JCommonServiceHelper", sb.toString());
            cn.jiguang.at.a.a(JConstants.getAppContext(context), str, bundle);
        } catch (Throwable th) {
            cn.jiguang.ar.c.e("JCommonServiceHelper", "callAction failed", th);
        }
    }
}
