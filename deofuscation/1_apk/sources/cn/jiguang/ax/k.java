package cn.jiguang.ax;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class k {
    private static volatile k a;
    private static final Object b = new Object();
    private Map<Long, String> c = new HashMap();

    public static k a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    private String a(Context context, String str, String str2) {
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(str));
        if (TextUtils.isEmpty(str2) || str2.equals(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("need not ");
            sb.append(str);
            sb.append(" userctrl,newest version:");
            if (TextUtils.isEmpty(str2)) {
                str2 = "null";
            }
            sb.append(str2);
            cn.jiguang.ar.c.a("UserCtrlHelper", sb.toString());
            return "";
        }
        return str2;
    }

    private void a(Context context, short s, String str, String str2) {
        cn.jiguang.ar.c.c("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + str2 + ",property:" + ((int) s) + ",verInfo:" + str);
        long b2 = j.b();
        cn.jiguang.at.b.a(context, JConstants.SDK_TYPE, 26, 0, b2, 10000L, cn.jiguang.az.b.a(s, (short) 1, str));
        this.c.put(Long.valueOf(b2), str2);
    }

    public void a(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.g("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        HashMap<String, JDispatchAction> hashMap = b.a;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                String a2 = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                if (!TextUtils.isEmpty(a2)) {
                    a(context, value.getUserCtrlProperty(entry.getKey()), a2, entry.getKey());
                }
            }
        }
    }

    public void a(Context context, long j) {
        String str;
        Map<Long, String> map;
        String remove = this.c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            str = "userCtrlSuccess but not found rid:" + j;
        } else {
            cn.jiguang.ar.c.c("UserCtrlHelper", "userCtrlSuccess rid:" + j + ",sdkType:" + remove);
            String b2 = b.a().b(remove, "");
            if (!TextUtils.isEmpty(b2)) {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(remove).a((cn.jiguang.g.a<String>) b2));
                map = this.c;
                if (map == null && map.isEmpty() && !cn.jiguang.aq.c.a().a(context)) {
                    h.a().a(context, "tcp_a21", null);
                    return;
                }
                return;
            }
            str = "userCtrlSuccess but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.ar.c.c("UserCtrlHelper", str);
        map = this.c;
        if (map == null) {
        }
    }

    public void a(Context context, long j, int i) {
        String str;
        String remove = this.c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            str = "onUserCtrlFailed but not found rid:" + j;
        } else {
            cn.jiguang.ar.c.c("UserCtrlHelper", "onUserCtrlFailed rid:" + j + ",sdkType:" + remove + ",errorCode:" + i);
            if (!TextUtils.isEmpty(b.a().b(remove, ""))) {
                return;
            }
            str = "onUserCtrlFailed but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.ar.c.c("UserCtrlHelper", str);
    }

    public void b(Context context, long j) {
        cn.jiguang.ar.c.c("UserCtrlHelper", "onUserCtrlTimeout rid:" + j);
        this.c.remove(Long.valueOf(j));
    }

    public boolean b(Context context) {
        if (context == null) {
            cn.jiguang.ar.c.h("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        HashMap<String, JDispatchAction> hashMap = b.a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }
}
