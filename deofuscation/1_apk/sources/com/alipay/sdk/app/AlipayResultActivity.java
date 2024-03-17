package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.j;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AlipayResultActivity extends Activity {
    public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(int i, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = a.remove(str);
        if (remove == null) {
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(j.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra("session");
            Bundle bundleExtra = intent.getBundleExtra("result");
            String stringExtra2 = intent.getStringExtra("scene");
            com.alipay.sdk.sys.a a2 = a.C0030a.a(stringExtra);
            if (a2 == null) {
                finish();
                return;
            }
            com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, "BSPSession", stringExtra + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + SystemClock.elapsedRealtime());
            if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                a(stringExtra, bundleExtra);
                return;
            }
            if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                    jSONObject = jSONObject2.getJSONObject("result");
                    stringExtra = jSONObject2.getString("session");
                    com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, "BSPUriSession", stringExtra);
                    bundle2 = new Bundle();
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle2.putString(next, jSONObject.getString(next));
                    }
                    bundleExtra = bundle2;
                } catch (Throwable th3) {
                    th = th3;
                    bundleExtra = bundle2;
                    com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, "BSPResEx", th);
                    com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.y0, th);
                    if (TextUtils.isEmpty(stringExtra)) {
                    }
                    com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.d);
                    finish();
                }
            }
            if (TextUtils.isEmpty(stringExtra) && bundleExtra != null) {
                com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.Z, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.a(a2, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.a0, bundleExtra.getInt("endCode", -1) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + bundleExtra.getString(j.b, "-"));
                OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
                com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.d);
                finish();
                return;
            }
            com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.d);
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }
}
