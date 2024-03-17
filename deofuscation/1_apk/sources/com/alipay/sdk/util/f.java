package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.fastjson.asm.Label;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.facebook.login.LoginLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    public static final String j = "failed";
    public static final String k = "scheme_failed";
    public Activity a;
    public volatile IAlixPay b;
    public boolean d;
    public e e;
    public final com.alipay.sdk.sys.a f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;
    public String i = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements AlipayResultActivity.a {
        public final /* synthetic */ CountDownLatch a;

        public a(CountDownLatch countDownLatch) {
            f.this = r1;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, String str, String str2) {
            f.this.h = com.alipay.sdk.app.b.a(i, str, str2);
            this.a.countDown();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements APayEntranceActivity.a {
        public final /* synthetic */ CountDownLatch a;

        public b(CountDownLatch countDownLatch) {
            f.this = r1;
            this.a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            f.this.i = str;
            this.a.countDown();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends IRemoteServiceCallback.Stub {
        public c() {
            f.this = r1;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 3;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.app.statistic.a.a(f.this.f, com.alipay.sdk.app.statistic.b.q, str, str2);
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                com.alipay.sdk.app.statistic.a.a(f.this.f, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.d0, e);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    com.alipay.sdk.sys.a aVar = f.this.f;
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "isFg", runningAppProcessInfo.processName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + runningAppProcessInfo.importance + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
            } catch (Throwable unused) {
            }
            try {
                if (f.this.a == null) {
                    com.alipay.sdk.app.statistic.a.b(f.this.f, com.alipay.sdk.app.statistic.b.l, "ErrActNull", "");
                    Context a = f.this.f.a();
                    if (a != null) {
                        j.l.c.e0.a.a.a.h(intent);
                        a.startActivity(intent);
                    }
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Activity activity = f.this.a;
                    j.l.c.e0.a.a.a.h(intent);
                    activity.startActivity(intent);
                    com.alipay.sdk.sys.a aVar2 = f.this.f;
                    com.alipay.sdk.app.statistic.a.a(aVar2, com.alipay.sdk.app.statistic.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                f.this.e.a();
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(f.this.f, com.alipay.sdk.app.statistic.b.l, "ErrActNull", th);
                throw th;
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements ServiceConnection {
        public d() {
            f.this = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.app.statistic.a.a(f.this.f, com.alipay.sdk.app.statistic.b.l, "srvCon");
            synchronized (f.this.c) {
                f.this.b = IAlixPay.Stub.asInterface(iBinder);
                f.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.app.statistic.a.a(f.this.f, com.alipay.sdk.app.statistic.b.l, "srvDis");
            f.this.b = null;
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface e {
        void a();

        void b();
    }

    public f(Activity activity, com.alipay.sdk.sys.a aVar, e eVar) {
        this.a = activity;
        this.f = aVar;
        this.e = eVar;
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, com.alipay.sdk.a.e);
    }

    private String b(String str, String str2) {
        JSONObject jSONObject;
        String str3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = l.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.sys.a aVar = this.f;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "BSAStart", a2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + elapsedRealtime);
        a.C0030a.a(this.f, a2);
        APayEntranceActivity.g.put(a2, new b(countDownLatch));
        try {
            HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f);
            a3.put("ts_intent", String.valueOf(elapsedRealtime));
            jSONObject = new JSONObject(a3);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e2) {
                com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSAWaiting", e2);
                com.alipay.sdk.app.c cVar = com.alipay.sdk.app.c.PAY_WAITTING;
                return com.alipay.sdk.app.b.a(cVar.b(), cVar.a(), "");
            } catch (Throwable th2) {
                com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSAEx", th2);
                return k;
            }
        }
        Intent intent = new Intent(this.a, APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.c, str);
        intent.putExtra(APayEntranceActivity.d, str2);
        intent.putExtra(APayEntranceActivity.e, a2);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.f, jSONObject.toString());
        }
        Activity activity = this.a;
        com.alipay.sdk.sys.a aVar2 = this.f;
        com.alipay.sdk.app.statistic.a.a(activity, aVar2, str, aVar2.d);
        Activity activity2 = this.a;
        j.l.c.e0.a.a.a.h(intent);
        activity2.startActivity(intent);
        com.alipay.sdk.data.a.v().a(this.f, this.a.getApplicationContext(), false);
        countDownLatch.await();
        String str4 = this.i;
        try {
            str3 = j.a(this.f, str4).get(j.a);
            if (str3 == null) {
                str3 = "null";
            }
        } catch (Throwable th3) {
            com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSAStatEx", th3);
            str3 = "unknown";
        }
        com.alipay.sdk.sys.a aVar3 = this.f;
        com.alipay.sdk.app.statistic.a.a(aVar3, com.alipay.sdk.app.statistic.b.l, "BSADone-" + str3);
        if (TextUtils.isEmpty(str4)) {
            com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSAEmpty");
            return k;
        }
        return str4;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0063 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #3 {all -> 0x00ad, blocks: (B:87:0x0023, B:89:0x002b, B:92:0x0033, B:95:0x003c, B:98:0x0042, B:101:0x004b, B:103:0x0054, B:106:0x0059, B:108:0x0063, B:102:0x0050), top: B:144:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            com.alipay.sdk.data.a r2 = com.alipay.sdk.data.a.v()     // Catch: java.lang.Throwable -> Lb0
            java.util.List r2 = r2.k()     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.data.a r3 = com.alipay.sdk.data.a.v()     // Catch: java.lang.Throwable -> Lb0
            boolean r3 = r3.g     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L15
            if (r2 != 0) goto L17
        L15:
            java.util.List<com.alipay.sdk.data.a$b> r2 = com.alipay.sdk.app.a.d     // Catch: java.lang.Throwable -> Lb0
        L17:
            com.alipay.sdk.sys.a r3 = r8.f     // Catch: java.lang.Throwable -> Lb0
            android.app.Activity r4 = r8.a     // Catch: java.lang.Throwable -> Lb0
            com.alipay.sdk.util.l$c r2 = com.alipay.sdk.util.l.a(r3, r4, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r3 = "failed"
            if (r2 == 0) goto Laf
            com.alipay.sdk.sys.a r4 = r8.f     // Catch: java.lang.Throwable -> Lad
            boolean r4 = r2.a(r4)     // Catch: java.lang.Throwable -> Lad
            if (r4 != 0) goto Laf
            boolean r4 = r2.a()     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto L33
            goto Laf
        L33:
            android.content.pm.PackageInfo r4 = r2.a     // Catch: java.lang.Throwable -> Lad
            boolean r4 = com.alipay.sdk.util.l.a(r4)     // Catch: java.lang.Throwable -> Lad
            if (r4 == 0) goto L3c
            return r3
        L3c:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L50
            java.lang.String r4 = "com.eg.android.AlipayGphone"
            java.lang.String r3 = r3.packageName     // Catch: java.lang.Throwable -> Lad
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L4b
            goto L50
        L4b:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            java.lang.String r0 = r3.packageName     // Catch: java.lang.Throwable -> Lad
            goto L54
        L50:
            java.lang.String r0 = com.alipay.sdk.util.l.a()     // Catch: java.lang.Throwable -> Lad
        L54:
            android.content.pm.PackageInfo r3 = r2.a     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto L59
            r1 = r3
        L59:
            com.alipay.sdk.data.a r3 = com.alipay.sdk.data.a.v()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r3 = r3.b()     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Lad
            if (r4 <= 0) goto Lbb
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lab
            r4.<init>(r3)     // Catch: java.lang.Throwable -> Lab
            org.json.JSONObject r3 = r4.optJSONObject(r0)     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Lab
            if (r4 <= 0) goto Lbb
            java.util.Iterator r4 = r3.keys()     // Catch: java.lang.Throwable -> Lab
        L7e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lab
            if (r5 == 0) goto Lbb
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lab
            int r6 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto L7e
            int r7 = r1.versionCode     // Catch: java.lang.Throwable -> Lab
            if (r7 < r6) goto L7e
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            com.alipay.sdk.data.a r6 = com.alipay.sdk.data.a.v()     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            android.app.Activity r7 = r8.a     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            boolean r5 = r6.a(r7, r5)     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            r8.g = r5     // Catch: java.lang.Exception -> L7e java.lang.Throwable -> Lab
            if (r5 == 0) goto L7e
            goto Lbb
        Lab:
            goto Lbb
        Lad:
            r3 = move-exception
            goto Lb2
        Laf:
            return r3
        Lb0:
            r3 = move-exception
            r2 = r1
        Lb2:
            com.alipay.sdk.sys.a r4 = r8.f
            java.lang.String r5 = "biz"
            java.lang.String r6 = "CheckClientSignEx"
            com.alipay.sdk.app.statistic.a.a(r4, r5, r6, r3)
        Lbb:
            boolean r3 = r8.g
            if (r3 == 0) goto Lc4
            java.lang.String r9 = r8.a(r9, r0, r1)
            return r9
        Lc4:
            java.lang.String r9 = r8.a(r9, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.f.a(java.lang.String):java.lang.String");
    }

    private void a(l.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            Activity activity = this.a;
            j.l.c.e0.a.a.a.h(intent);
            activity.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.h0, th);
        }
        Thread.sleep(200L);
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        if (packageInfo != null) {
            int i = packageInfo.versionCode;
        }
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay bind or scheme");
        com.alipay.sdk.sys.a aVar = this.f;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.b0, str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3);
        Activity activity = this.a;
        com.alipay.sdk.sys.a aVar2 = this.f;
        com.alipay.sdk.app.statistic.a.a(activity, aVar2, str, aVar2.d);
        return b(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r9, java.lang.String r10, android.content.pm.PackageInfo r11, com.alipay.sdk.util.l.c r12) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.f.a(java.lang.String, java.lang.String, android.content.pm.PackageInfo, com.alipay.sdk.util.l$c):java.lang.String");
    }

    private String a(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = l.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPStart", a2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + elapsedRealtime);
        a.C0030a.a(this.f, a2);
        AlipayResultActivity.a.put(a2, new a(countDownLatch));
        try {
            try {
                String[] split = str7.split("&", -1);
                int length = split.length;
                int i = 0;
                while (true) {
                    jSONObject = null;
                    if (i >= length) {
                        str4 = "";
                        str5 = str4;
                        str6 = null;
                        break;
                    }
                    str6 = split[i];
                    if (str6.startsWith(com.alipay.sdk.sys.a.m)) {
                        String substring = str6.substring(str6.indexOf("{"), str6.lastIndexOf(g.d) + 1);
                        int indexOf = str6.indexOf(substring);
                        str5 = str6.substring(0, indexOf);
                        str4 = str6.substring(indexOf + substring.length());
                        JSONObject jSONObject2 = new JSONObject(substring);
                        if (jSONObject2.optString("sc").equals("h5tonative")) {
                            jSONObject2.put("sc", "h5tonative_scheme");
                        } else {
                            jSONObject2.put("sc", "h5tonative_sdkscheme");
                        }
                        jSONObject = jSONObject2;
                    } else {
                        i++;
                    }
                }
            } catch (Exception e2) {
                try {
                    com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPSCReplaceEx", e2, Base64.encodeToString(str.getBytes(), 2));
                } catch (InterruptedException e3) {
                    com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPWaiting", e3);
                    com.alipay.sdk.app.c cVar = com.alipay.sdk.app.c.PAY_WAITTING;
                    return com.alipay.sdk.app.b.a(cVar.b(), cVar.a(), "");
                }
            }
            if (!TextUtils.isEmpty(str6)) {
                if (str7.indexOf(str6) == str7.lastIndexOf(str6)) {
                    str7 = str7.replace(str6, str5 + jSONObject.toString() + str4);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("sourcePid", Binder.getCallingPid());
                    jSONObject3.put(com.alipay.sdk.cons.b.d, str7);
                    jSONObject3.put("pkgName", this.a.getPackageName());
                    jSONObject3.put("session", a2);
                    String encodeToString = Base64.encodeToString(jSONObject3.toString().getBytes("UTF-8"), 2);
                    Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20000125");
                    appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
                    try {
                        HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.f);
                        a3.put("ts_scheme", String.valueOf(elapsedRealtime));
                        appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(a3).toString());
                    } catch (Throwable th) {
                        com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPLocEx", th);
                    }
                    String uri = appendQueryParameter.build().toString();
                    Intent intent = new Intent();
                    intent.setPackage(str2);
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent.setData(Uri.parse(uri));
                    Activity activity = this.a;
                    com.alipay.sdk.sys.a aVar = this.f;
                    com.alipay.sdk.app.statistic.a.a(activity, aVar, str7, aVar.d);
                    Activity activity2 = this.a;
                    j.l.c.e0.a.a.a.h(intent);
                    activity2.startActivity(intent);
                    com.alipay.sdk.data.a.v().a(this.f, this.a.getApplicationContext(), false);
                    com.alipay.sdk.util.c.d(com.alipay.sdk.cons.a.x, "pay scheme waiting " + uri);
                    countDownLatch.await();
                    String str8 = this.h;
                    try {
                        str3 = j.a(this.f, str8).get(j.a);
                        if (str3 == null) {
                            str3 = "null";
                        }
                    } catch (Throwable th2) {
                        com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPStatEx", th2);
                        str3 = "unknown";
                    }
                    com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPDone-" + str3);
                    if (TextUtils.isEmpty(str8)) {
                        com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPEmpty");
                        return k;
                    }
                    return str8;
                }
                throw new RuntimeException("multi ctx_args");
            }
            throw new RuntimeException("empty ctx_args");
        } catch (Throwable th3) {
            com.alipay.sdk.app.statistic.a.a(this.f, com.alipay.sdk.app.statistic.b.l, "BSPEx", th3);
            return k;
        }
    }

    public static boolean a(String str, Context context, com.alipay.sdk.sys.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) == null) {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "BSPDetectFail");
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "BSPDetectFail", th);
            return false;
        }
    }

    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.sys.a aVar) {
        int i;
        d dVar;
        c cVar;
        Activity activity;
        Activity activity2;
        long elapsedRealtime;
        StringBuilder sb;
        String Pay;
        Activity activity3;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(l.b(str2));
        String a2 = l.a(this.a, str2);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(elapsedRealtime2);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(str != null ? str.length() : 0);
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.V, sb2.toString());
        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
        try {
            if (!com.alipay.sdk.data.a.v().e()) {
                ComponentName startService = this.a.getApplication().startService(intent);
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "stSrv", startService != null ? startService.getPackageName() : "null");
            } else {
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "stSrv", LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
            }
            if (com.alipay.sdk.data.a.v().a()) {
                i = 65;
                com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, "bindFlg", "imp");
            } else {
                i = 1;
            }
            d dVar2 = new d(this, null);
            if (this.a.getApplicationContext().bindService(intent, dVar2, i)) {
                synchronized (this.c) {
                    if (this.b == null) {
                        try {
                            this.c.wait(com.alipay.sdk.data.a.v().j());
                        } catch (InterruptedException e2) {
                            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.P, e2);
                        }
                    }
                }
                IAlixPay iAlixPay = this.b;
                try {
                    if (iAlixPay == null) {
                        String a3 = l.a(this.a, str2);
                        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.I, a2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a3);
                        Pair<String, Boolean> pair = new Pair<>(j, Boolean.TRUE);
                        try {
                            this.a.getApplicationContext().unbindService(dVar2);
                        } catch (Throwable th) {
                            com.alipay.sdk.util.c.a(th);
                        }
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        if (this.d && (activity4 = this.a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return pair;
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.W, "" + elapsedRealtime3);
                    e eVar = this.e;
                    if (eVar != null) {
                        eVar.b();
                    }
                    if (this.a.getRequestedOrientation() == 0) {
                        this.a.setRequestedOrientation(1);
                        this.d = true;
                    }
                    int version = iAlixPay.getVersion();
                    cVar = new c(this, null);
                    try {
                        if (version >= 3) {
                            iAlixPay.registerCallback03(cVar, str, null);
                        } else {
                            iAlixPay.registerCallback(cVar);
                        }
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        th = th2;
                        dVar = dVar2;
                    }
                    try {
                        sb.append("");
                        sb.append(elapsedRealtime);
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.Y, sb.toString());
                        if (version >= 3) {
                            iAlixPay.r03(com.alipay.sdk.app.statistic.b.l, "bind_pay", null);
                        }
                        if (version >= 2) {
                            HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(aVar);
                            a4.put("ts_bind", String.valueOf(elapsedRealtime2));
                            a4.put("ts_bend", String.valueOf(elapsedRealtime3));
                            a4.put("ts_pay", String.valueOf(elapsedRealtime));
                            Pay = iAlixPay.pay02(str, a4);
                        } else {
                            Pay = iAlixPay.Pay(str);
                        }
                        String str3 = Pay;
                        try {
                            iAlixPay.unregisterCallback(cVar);
                        } catch (Throwable th3) {
                            com.alipay.sdk.util.c.a(th3);
                        }
                        try {
                            this.a.getApplicationContext().unbindService(dVar2);
                        } catch (Throwable th4) {
                            com.alipay.sdk.util.c.a(th4);
                        }
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                        this.b = null;
                        if (this.d && (activity3 = this.a) != null) {
                            activity3.setRequestedOrientation(0);
                            this.d = false;
                        }
                        return new Pair<>(str3, Boolean.FALSE);
                    } catch (Throwable th5) {
                        th = th5;
                        dVar = dVar2;
                        try {
                            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.I, th, "in_bind");
                            Pair<String, Boolean> pair2 = new Pair<>(j, Boolean.TRUE);
                            if (cVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(cVar);
                                } catch (Throwable th6) {
                                    com.alipay.sdk.util.c.a(th6);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(dVar);
                            } catch (Throwable th7) {
                                com.alipay.sdk.util.c.a(th7);
                            }
                            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                            this.b = null;
                            if (this.d && (activity2 = this.a) != null) {
                                activity2.setRequestedOrientation(0);
                                this.d = false;
                            }
                            return pair2;
                        } catch (Throwable th8) {
                            if (cVar != null) {
                                try {
                                    iAlixPay.unregisterCallback(cVar);
                                } catch (Throwable th9) {
                                    com.alipay.sdk.util.c.a(th9);
                                }
                            }
                            try {
                                this.a.getApplicationContext().unbindService(dVar);
                            } catch (Throwable th10) {
                                com.alipay.sdk.util.c.a(th10);
                            }
                            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.X, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.app.statistic.a.a(this.a, aVar, str, aVar.d);
                            this.b = null;
                            if (this.d && (activity = this.a) != null) {
                                activity.setRequestedOrientation(0);
                                this.d = false;
                            }
                            throw th8;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    dVar = dVar2;
                    cVar = null;
                }
            } else {
                throw new Throwable("bindService fail");
            }
        }
    }

    public void a() {
        this.a = null;
        this.e = null;
    }
}
