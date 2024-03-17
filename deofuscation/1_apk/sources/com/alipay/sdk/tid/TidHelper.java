package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.packet.impl.c;
import com.alipay.sdk.sys.b;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TidHelper {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        b.d().a(context);
    }

    public static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.packet.b a = new c().a(com.alipay.sdk.sys.a.e(), context);
            if (a != null) {
                JSONObject jSONObject = new JSONObject(a.a());
                a a2 = a.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(a.j);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a2.a(optString, string);
                }
                return a(context, a2);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void clearTID(Context context) {
        a.a(context).a();
    }

    public static String getIMEI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.b(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return com.alipay.sdk.util.a.b(context).c();
    }

    public static synchronized String getTIDValue(Context context) {
        String tid;
        synchronized (TidHelper.class) {
            Tid loadOrCreateTID = loadOrCreateTID(context);
            tid = Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
        }
        return tid;
    }

    public static String getVirtualImei(Context context) {
        a(context);
        com.alipay.sdk.data.b.b();
        return com.alipay.sdk.data.b.f();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        com.alipay.sdk.data.b.b();
        return com.alipay.sdk.data.b.g();
    }

    public static Tid loadLocalTid(Context context) {
        a a = a.a(context);
        if (a.h()) {
            return null;
        }
        return new Tid(a.d(), a.c(), a.e().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        synchronized (TidHelper.class) {
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "load_create_tid");
            a(context);
            Tid loadTID = loadTID(context);
            if (Tid.isEmpty(loadTID)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return null;
                }
                try {
                    loadTID = b(context);
                } catch (Throwable unused) {
                }
            }
            return loadTID;
        }
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid a = a(context, a.a(context));
        if (a == null) {
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "load_tid null");
        }
        return a;
    }

    public static boolean resetTID(Context context) throws Exception {
        com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "reset_tid");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            a(context);
            clearTID(context);
            Tid tid = null;
            try {
                tid = b(context);
            } catch (Throwable unused) {
            }
            return !Tid.isEmpty(tid);
        }
        throw new Exception("Must be called on worker thread");
    }

    public static Tid a(Context context, a aVar) {
        if (aVar == null || aVar.i()) {
            return null;
        }
        return new Tid(aVar.d(), aVar.c(), aVar.e().longValue());
    }
}
