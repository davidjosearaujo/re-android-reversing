package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.facebook.internal.ServerProtocol;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    public static final Map<String, Callback> e = new ConcurrentHashMap();
    public static long f = -1;
    public static final int g = 122;
    public final Activity b;
    public Callback c;
    public volatile boolean a = false;
    public final Handler d = new Handler(Looper.getMainLooper());

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BizType.values().length];
            a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public final class b implements Runnable {
        public final int a;
        public final String b;
        public final Bundle c;

        public /* synthetic */ b(OpenAuthTask openAuthTask, int i, String str, Bundle bundle, a aVar) {
            this(i, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.c != null) {
                OpenAuthTask.this.c.onResult(this.a, this.b, this.c);
            }
        }

        public b(int i, String str, Bundle bundle) {
            OpenAuthTask.this = r1;
            this.a = i;
            this.b = str;
            this.c = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.sys.b.d().a(activity);
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        Activity activity = this.b;
        String valueOf = String.valueOf(map);
        com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(activity, valueOf, "oa-" + bizType);
        this.c = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.app.statistic.a.b(this.b, aVar, "", aVar.d);
        }
    }

    private boolean a(com.alipay.sdk.sys.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        PackageInfo packageInfo;
        if (this.a) {
            this.d.post(new b(this, SYS_ERR, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.a = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f <= PayTask.j) {
            this.d.post(new b(this, Duplex, "3s 内重复支付", null, null));
            return true;
        }
        f = elapsedRealtime;
        com.alipay.sdk.app.a.a("");
        String a2 = l.a(32);
        HashMap hashMap = new HashMap(map);
        hashMap.put("mqpPkgName", this.b.getPackageName());
        hashMap.put("mqpScene", ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        List<a.b> k = com.alipay.sdk.data.a.v().k();
        if (!com.alipay.sdk.data.a.v().g || k == null) {
            k = com.alipay.sdk.app.a.d;
        }
        l.c a3 = l.a(aVar, this.b, k);
        if (a3 == null || a3.a(aVar) || a3.a() || (packageInfo = a3.a) == null || packageInfo.versionCode < 122) {
            if (z) {
                hashMap.put("mqpScheme", String.valueOf(str));
                hashMap.put("mqpNotifyName", a2);
                hashMap.put("mqpScene", "landing");
                String a4 = a(bizType, hashMap);
                Intent intent = new Intent(this.b, H5OpenAuthActivity.class);
                intent.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(a4)));
                a.C0030a.a(aVar, intent);
                Activity activity = this.b;
                j.l.c.e0.a.a.a.h(intent);
                activity.startActivity(intent);
                return false;
            }
            this.d.post(new b(this, NOT_INSTALLED, "支付宝未安装或签名错误", null, null));
            return true;
        }
        try {
            HashMap<String, String> a5 = com.alipay.sdk.sys.a.a(aVar);
            a5.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
            hashMap.put("mqpLoc", new JSONObject(a5).toString());
            String a6 = a(bizType, hashMap);
            e.put(a2, this.c);
            String str2 = null;
            try {
                str2 = a(elapsedRealtime, a2, bizType, a6);
            } catch (JSONException e2) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.w0, e2);
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                this.d.post(new b(this, SYS_ERR, "参数错误", null, null));
                return true;
            }
            Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter("payload", str3).build());
            intent2.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent2.setPackage(a3.a.packageName);
            try {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.c0, "" + elapsedRealtime);
                a.C0030a.a(aVar, a2);
                Activity activity2 = this.b;
                j.l.c.e0.a.a.a.h(intent2);
                activity2.startActivity(intent2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "StartWalletEx", th);
            }
            return false;
        }
    }

    private String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", bizType.appId);
            if (a.a[bizType.ordinal()] == 1) {
                appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return appendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    private String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put("package", this.b.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.8.02");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public static void a(String str, int i, String str2, Bundle bundle) {
        Callback remove = e.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
        }
    }
}
