package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.data.a;
import com.alipay.sdk.util.l;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class d {
    public static final int a = 1010;
    public static a b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, Context context) {
        return l.b(aVar, context, Collections.singletonList(new a.b("com.taobao.taobao", 0, "")));
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, Activity activity, int i, String str, String str2, a aVar2) {
        try {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.A0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
            b = aVar2;
            return true;
        } catch (Throwable th) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.E0, th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.sys.a aVar, int i, int i2, Intent intent) {
        if (i == 1010 && intent != null) {
            a aVar2 = b;
            if (aVar2 == null) {
                return true;
            }
            b = null;
            if (i2 != -1) {
                if (i2 != 0) {
                    com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.C0, "" + i2);
                } else {
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.B0, intent != null ? intent.toUri(1) : "");
                    aVar2.a(false, null, "CANCELED");
                }
            } else {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.D0, intent.toUri(1));
                aVar2.a(true, l.a(intent), "OK");
            }
            return true;
        }
        return false;
    }
}
