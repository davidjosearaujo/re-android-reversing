package cn.jpush.android.p;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.r.b;
import cn.jpush.android.r.g;
import cn.jpush.android.r.h;
import cn.jpush.android.r.k;
import cn.jpush.android.r.n;
import cn.jpush.android.r.r;
import cn.jpush.android.u.e;
import cn.jpush.android.x.c;
import com.facebook.login.LoginStatusClient;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends b {
    private static volatile a a;
    private n f;
    private AtomicInteger d = new AtomicInteger(0);
    private int e = 0;
    private ConcurrentHashMap<Integer, k> b = new ConcurrentHashMap<>();
    private g c = new g();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private k a(int i) {
        k kVar = this.b.get(Integer.valueOf(i));
        if (kVar == null) {
            synchronized (a.class) {
                if (i == 200) {
                    kVar = new cn.jpush.android.r.a(this.c, this);
                } else if (i == 201) {
                    kVar = new r(this.c, this);
                }
                if (kVar != null) {
                    this.b.put(Integer.valueOf(i), kVar);
                }
            }
            Logger.d("InAppMessagingManager", "init in app message, type: " + i);
        }
        return kVar;
    }

    public void a(Context context, String str, Bundle bundle) {
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, str, bundle);
    }

    public static void a(Context context, String str, d dVar, boolean z) {
        if (context != null && dVar != null) {
            if (dVar.aL == 1 || z) {
                c.a(context, str, dVar, (Intent) null);
                return;
            }
            return;
        }
        Logger.w("InAppMessagingManager", "[sendInAppMsgToUserReceiver] unexpected error, context: " + context + ", message: " + dVar);
    }

    private void b(int i) {
        this.d = new AtomicInteger(i);
    }

    private void b(Context context, int i, int i2) {
        b(i);
        this.e = i2;
        Bundle bundle = new Bundle();
        bundle.putInt("display_state", i);
        bundle.putInt("in_app_type", i2);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "in_app_display_state", bundle);
    }

    private void b(Context context, String str, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("activity_name", str);
        bundle.putInt("state", i);
        bundle.putBoolean("type", z);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "handle_life_resume", bundle);
    }

    private void c(Context context) {
        for (Integer num : this.b.keySet()) {
            k kVar = this.b.get(Integer.valueOf(num.intValue()));
            if (kVar != null) {
                kVar.d(context);
            }
        }
    }

    private void d(final Context context) {
        try {
            Logger.d("InAppMessagingManager", "change to foreground, start delay to deal cache message, delay time: 5000");
            e(context);
            n nVar = new n();
            this.f = nVar;
            nVar.a(new n.a() { // from class: cn.jpush.android.p.a.1
                {
                    a.this = this;
                }

                @Override // cn.jpush.android.r.n.a
                public void a() {
                    Logger.d("InAppMessagingManager", "timer time-up to process cache message");
                    a.this.a(context, "in_app_msg_handle", (Bundle) null);
                }
            }, LoginStatusClient.DEFAULT_TOAST_DURATION_MS, 1000L);
        } catch (Throwable th) {
            Logger.w("InAppMessagingManager", "start delay timer failed: " + th.getMessage());
        }
    }

    private void e(Context context) {
        n nVar = this.f;
        if (nVar != null) {
            nVar.a();
        }
    }

    private void e(Context context, d dVar) {
        if (dVar == null) {
            Logger.d("InAppMessagingManager", "message is null, no message to deal");
            return;
        }
        k a2 = a(dVar.bn);
        if (a2 == null) {
            Logger.w("InAppMessagingManager", "[processMessage] unexpected error infs is null");
            return;
        }
        if (!dVar.bp) {
            if (!a2.a(context, dVar.bn == this.e, dVar) && this.d.get() != 0) {
                Logger.d("InAppMessagingManager", "message not display, cache recv message, type: " + dVar.bn + ", status: " + this.d.get());
                a2.b(context, dVar);
                return;
            }
        }
        this.e = dVar.bn;
        b(1);
        a2.a(context, dVar);
    }

    private synchronized d f(Context context, d dVar) {
        k a2;
        int a3;
        try {
            int i = 0;
            int i2 = 0;
            for (Integer num : this.b.keySet()) {
                int intValue = num.intValue();
                k kVar = this.b.get(Integer.valueOf(intValue));
                if (kVar != null && i2 <= (a3 = kVar.a(context)) && kVar.c(context)) {
                    if (i2 != a3 || i == 0) {
                        i = intValue;
                        i2 = a3;
                    } else if (intValue == 200) {
                        i = intValue;
                    }
                }
            }
            if (this.b.size() > 0) {
                a2 = this.b.get(Integer.valueOf(i));
            } else {
                Logger.d("InAppMessagingManager", "first start create notify to check file cache");
                a2 = a(201);
            }
            if (a2 == null) {
                Logger.d("InAppMessagingManager", "no other in app message to deal, type: " + i);
                return dVar;
            }
            d b = a2.b(context);
            if (dVar != null) {
                if (b == null) {
                    return dVar;
                }
                b.au = dVar.au;
                if (a2.a(context) <= dVar.bo) {
                    a2.b(context, b);
                    return dVar;
                }
                k a4 = a(dVar.bn);
                if (a4 != null) {
                    a4.b(context, dVar);
                }
            }
            Logger.d("InAppMessagingManager", "deal cache message, type: " + i + ", priority: " + i2);
            return b;
        } catch (Throwable th) {
            Logger.w("InAppMessagingManager", "get message for priority failed, " + th.getMessage());
            return null;
        }
    }

    public void a(Context context) {
        Logger.d("InAppMessagingManager", "back to background for service");
        c(context);
    }

    public void a(Context context, int i) {
        for (Integer num : this.b.keySet()) {
            k a2 = a(num.intValue());
            if (a2 != null) {
                a2.a(context, i);
            }
        }
    }

    @Override // cn.jpush.android.r.b
    public void a(Context context, int i, int i2) {
        String str;
        Logger.dd("InAppMessagingManager", "message status changed, type: " + i + ", status: " + i2);
        b(context, i2, i);
        if (i2 == 0) {
            if (!cn.jpush.android.ac.a.k(context)) {
                str = "not in foreground, handle next in app stop";
            } else if (!h.d(context)) {
                a(context, "in_app_msg_handle", (Bundle) null);
                return;
            } else {
                str = "current black list not handle inapp msg";
            }
            Logger.d("InAppMessagingManager", str);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (this.d.get() != 0) {
            Logger.dd("InAppMessagingManager", "not handle message in no-idle status, status: " + this.d.get());
        } else if (cn.jpush.android.cache.a.d(context)) {
            Logger.i("InAppMessagingManager", "Service is stopped, give up all the cache message");
        } else if (JPushConstants.isTcpConnected()) {
            e(context, f(context, null));
        } else {
            Logger.i("InAppMessagingManager", "tcp is disconnected, give up to deal cache message");
        }
    }

    public void a(Context context, d dVar) {
        e(context, f(context, dVar));
    }

    public void a(Context context, e eVar, int i) {
        if (eVar == null) {
            Logger.w("InAppMessagingManager", "[onJsLoadedCallback] message is null");
            return;
        }
        try {
            k a2 = a(eVar.u().bn);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(context, eVar, i);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, e eVar, String str) {
        if (eVar == null) {
            Logger.w("InAppMessagingManager", "[onJsDataReport] message is null");
            return;
        }
        try {
            k a2 = a(eVar.u().bn);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(context, eVar, str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, String str) {
        for (Integer num : this.b.keySet()) {
            k kVar = this.b.get(Integer.valueOf(num.intValue()));
            if (kVar != null) {
                kVar.b(context.getApplicationContext(), str);
            }
        }
        a(context.getApplicationContext(), str, 0, true);
    }

    @Override // cn.jpush.android.r.b
    public void a(Context context, String str, int i) {
        d dVar = new d();
        dVar.c = str;
        dVar.bn = i;
        a(context, "cn.jpush.android.intent.NOTIFY_INAPP_CANCEL", dVar, true);
    }

    public void a(Context context, String str, int i, boolean z) {
        h.a(str, i, z);
        b(context, str, i, z);
    }

    public void a(Context context, String str, boolean z) {
        a(context, str, z ? 1 : 0, false);
        if (z) {
            if (!h.a(context, str)) {
                return;
            }
        } else if (h.e(context)) {
            return;
        }
        a(context, 1);
    }

    public void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.getJSONObject("content").optString("ids");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Logger.d("InAppMessagingManager", "dealCancelInAppMessage ids=" + optString);
            k a2 = a(201);
            if (a2 == null) {
                Logger.ww("InAppMessagingManager", "unexpected error, infs is null");
            } else {
                a2.d(context, optString);
            }
        } catch (Throwable th) {
            Logger.w("InAppMessagingManager", "[cancelInAppMessage] parse ids json failed, " + th.getMessage());
        }
    }

    public void a(e eVar, int i, String str) {
        if (eVar == null) {
            Logger.w("InAppMessagingManager", "[onWebInAppClick] message is null");
            return;
        }
        try {
            k a2 = a(eVar.u().bn);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "unexpected error of infs is null");
            } else {
                a2.a(eVar, i, str);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Context context) {
        k a2 = a(200);
        if (a2 != null) {
            a2.f(context);
        }
    }

    public void b(Context context, int i) {
        if (i == 0) {
            c(context);
        } else if (i == 1 || i == 2) {
            if (this.d.get() == 0) {
                d(context);
                return;
            }
            Logger.d("InAppMessagingManager", "to foreground message channel not idle. status: " + this.d.get());
        }
    }

    public void b(Context context, Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("display_state");
            this.e = bundle.getInt("in_app_type");
            b(i);
        }
    }

    public void b(Context context, d dVar) {
        if (dVar == null) {
            Logger.w("InAppMessagingManager", "[handleInAppMessage] message is null");
            return;
        }
        try {
            k a2 = a(dVar.bn);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "[handleInAppMessage] unexpected error of infs is null");
            } else {
                a2.c(context, dVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Context context, String str) {
        for (Integer num : this.b.keySet()) {
            k kVar = this.b.get(Integer.valueOf(num.intValue()));
            if (kVar != null) {
                kVar.a(context.getApplicationContext(), str);
            }
        }
        a(context.getApplicationContext(), str, 1, true);
    }

    public void c(Context context, d dVar) {
        if (dVar == null) {
            Logger.w("InAppMessagingManager", "[dismissInAppMessage] message is null");
            return;
        }
        try {
            k a2 = a(dVar.bn);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "[dismissInAppMessage] unexpected error of infs is null");
            } else {
                a2.d(context, dVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, String str) {
        for (Integer num : this.b.keySet()) {
            k kVar = this.b.get(Integer.valueOf(num.intValue()));
            if (kVar != null) {
                kVar.c(context, str);
            }
        }
    }

    public boolean c(Context context, int i) {
        try {
            k a2 = a(i);
            if (a2 == null) {
                Logger.w("InAppMessagingManager", "unexpected error of infs is null");
                return false;
            }
            return a2.e(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public void d(Context context, d dVar) {
        if (context == null || dVar == null) {
            return;
        }
        cn.jpush.android.d.b.a(context, dVar);
    }
}
