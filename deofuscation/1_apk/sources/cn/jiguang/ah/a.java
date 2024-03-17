package cn.jiguang.ah;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends cn.jiguang.n.a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a b;
    private Context a;

    /* renamed from: cn.jiguang.ah.a$a  reason: collision with other inner class name */
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class CallableC0003a implements Callable<cn.jiguang.ai.a> {
        public CallableC0003a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public cn.jiguang.ai.a call() {
            try {
                cn.jiguang.ah.b bVar = new cn.jiguang.ah.b(a.this.a);
                bVar.b();
                for (int i = 0; i < 20; i++) {
                    cn.jiguang.ai.a a = bVar.a();
                    if (a != null) {
                        return a;
                    }
                    Thread.sleep(AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JLocation", "JLocationCellInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements Callable<cn.jiguang.ai.b> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public cn.jiguang.ai.b call() {
            try {
                c a = c.a(a.this.a);
                a.c();
                for (int i = 0; i < 30; i++) {
                    if (a.b()) {
                        return a.a();
                    }
                    Thread.sleep(1000L);
                }
                return null;
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JLocation", "JLocationGpsInfo call failed:" + th.getMessage());
                return null;
            }
        }
    }

    private Bundle a(long j, double d, double d2) {
        Bundle bundle = new Bundle();
        bundle.putLong(CrashHianalyticsData.TIME, j);
        bundle.putDouble("lot", d);
        bundle.putDouble("lat", d2);
        return bundle;
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a(java.util.List<cn.jiguang.ai.c> r19, cn.jiguang.ai.a r20, cn.jiguang.ai.b r21) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ah.a.a(java.util.List, cn.jiguang.ai.a, cn.jiguang.ai.b):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONArray jSONArray;
        cn.jiguang.ak.a.a("JLocation", "currentJson:" + jSONObject + ",cacheJson:" + jSONObject2);
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException e) {
                e = e;
            }
            try {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(jSONObject);
                jSONObject3.put("content", jSONArray2);
                return jSONObject3;
            } catch (JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject3;
                cn.jiguang.ak.a.d("JLocation", "mergeJson exception:" + e.getMessage());
                return jSONObject2;
            }
        }
        try {
            jSONArray = jSONObject2.getJSONArray("content");
        } catch (JSONException unused) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (cn.jiguang.i.a.a().d(1505)) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("wifi");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("wifi");
                if (optJSONArray != null && optJSONArray.equals(optJSONArray2)) {
                    jSONObject.remove("wifi");
                }
            }
            if (cn.jiguang.i.a.a().d(1501)) {
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("cell");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("cell");
                if (optJSONArray3 != null && optJSONArray3.equals(optJSONArray4)) {
                    jSONObject.remove("cell");
                }
            }
            if (cn.jiguang.i.a.a().d(1502)) {
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("gps");
                JSONArray optJSONArray6 = jSONObject.optJSONArray("gps");
                if (optJSONArray5 != null && optJSONArray5.equals(optJSONArray6)) {
                    jSONObject.remove("gps");
                }
            }
        }
        if (jSONObject.length() != 0) {
            try {
                if (cn.jiguang.i.a.a().d(1504)) {
                    jSONObject.put("network_type", cn.jiguang.n.d.k(this.a));
                }
                if (cn.jiguang.i.a.a().d(1503)) {
                    jSONObject.put("local_dns", cn.jiguang.n.d.f());
                }
                cn.jiguang.n.d.a(this.a, jSONObject, "loc_info");
                jSONArray.put(jSONObject);
            } catch (JSONException e3) {
                cn.jiguang.ak.a.d("JLocation", "package json exception:" + e3.getMessage());
            }
        }
        return jSONObject2;
    }

    private List<cn.jiguang.ai.c> c(Context context, int i) {
        String str;
        List<cn.jiguang.ai.c> list = null;
        try {
            if (cn.jiguang.i.a.a().d(1505)) {
                if (!cn.jiguang.n.d.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                    str = "collect wifi failed because has no android.permission.ACCESS_WIFI_STATE";
                } else if (cn.jiguang.n.d.j(context)) {
                    list = new d(context).a(i);
                    cn.jiguang.ak.a.a("JLocation", "collect wifi success:" + list);
                } else {
                    str = "collect wifi failed because not enable to collect wifi list";
                }
                cn.jiguang.ak.a.d("JLocation", str);
            }
        } catch (Exception e) {
            cn.jiguang.ak.a.a("JLocation", "collect wifi failed :" + e.getMessage());
        }
        return list;
    }

    private cn.jiguang.ai.b g(Context context) {
        StringBuilder sb;
        String message;
        String str;
        String str2;
        cn.jiguang.ai.b bVar = null;
        if (cn.jiguang.i.a.a().d(1502)) {
            try {
                cn.jiguang.ak.a.a("JLocation", "coares:" + cn.jiguang.n.d.a(context, "android.permission.ACCESS_COARSE_LOCATION"));
                cn.jiguang.ak.a.a("JLocation", "fine:" + cn.jiguang.n.d.a(context, "android.permission.ACCESS_FINE_LOCATION"));
                if (!cn.jiguang.n.d.a(context, "android.permission.ACCESS_COARSE_LOCATION") && !cn.jiguang.n.d.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                    cn.jiguang.ak.a.d("JLocation", "collect gps failed because has no Manifest.permission.LOCATION");
                }
                if (cn.jiguang.n.d.m(context) && c.a(context).e()) {
                    cn.jiguang.ai.b d = c.a(context).d();
                    try {
                        if (d == null) {
                            FutureTask futureTask = new FutureTask(new b());
                            cn.jiguang.n.d.b(futureTask);
                            cn.jiguang.ai.b bVar2 = (cn.jiguang.ai.b) futureTask.get(31000L, TimeUnit.MILLISECONDS);
                            if (bVar2 != null) {
                                try {
                                    str2 = "collect gps success:" + bVar2.toString();
                                } catch (InterruptedException e) {
                                    e = e;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps exception:");
                                    message = e.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ak.a.d("JLocation", str);
                                    return bVar;
                                } catch (ExecutionException e2) {
                                    e = e2;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps exception:");
                                    message = e.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ak.a.d("JLocation", str);
                                    return bVar;
                                } catch (TimeoutException unused) {
                                    bVar = bVar2;
                                    str = "collect gps time out";
                                    cn.jiguang.ak.a.d("JLocation", str);
                                    return bVar;
                                } catch (Throwable th) {
                                    th = th;
                                    bVar = bVar2;
                                    sb = new StringBuilder();
                                    sb.append("collect gps throwable:");
                                    message = th.getMessage();
                                    sb.append(message);
                                    str = sb.toString();
                                    cn.jiguang.ak.a.d("JLocation", str);
                                    return bVar;
                                }
                            } else {
                                str2 = "collect gps failed";
                            }
                            cn.jiguang.ak.a.a("JLocation", str2);
                            d = bVar2;
                        } else {
                            cn.jiguang.ak.a.a("JLocation", "load  last gps success:" + d.toString());
                        }
                        if (d != null) {
                            cn.jiguang.n.b.t(context, d.a + "," + d.d + "," + d.c);
                        }
                        bVar = d;
                    } catch (InterruptedException e3) {
                        e = e3;
                        bVar = d;
                    } catch (ExecutionException e4) {
                        e = e4;
                        bVar = d;
                    } catch (TimeoutException unused2) {
                        bVar = d;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = d;
                    }
                }
            } catch (InterruptedException e5) {
                e = e5;
            } catch (ExecutionException e6) {
                e = e6;
            } catch (TimeoutException unused3) {
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return bVar;
    }

    @Override // cn.jiguang.n.a
    public String a(Context context) {
        this.a = context;
        return "JLocation";
    }

    @Override // cn.jiguang.n.a
    public void a(String str, JSONObject jSONObject) {
        if (cn.jiguang.i.a.a().a(1500)) {
            int optInt = jSONObject.optInt("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optInt != 5) {
                if (optInt == 45) {
                    cn.jiguang.n.b.a(this.a, "JLocation", optJSONObject.optLong("interval", 0L) * 1000);
                    return;
                }
                return;
            }
            boolean z = !optJSONObject.optBoolean("disable", true);
            cn.jiguang.n.b.a(this.a, "JLocation", z);
            if (z) {
                cn.jiguang.n.b.b(this.a, "JLocation", optJSONObject.optLong("frequency", 0L) * 1000);
            }
        }
    }

    @Override // cn.jiguang.n.a
    public boolean a(Context context, String str) {
        return cn.jiguang.n.b.a(context, str);
    }

    public ArrayList<String> b(Context context, int i) {
        ArrayList<String> arrayList;
        List<cn.jiguang.ai.c> c = c(context, Integer.MAX_VALUE);
        if (c != null) {
            arrayList = new ArrayList<>();
            for (cn.jiguang.ai.c cVar : c) {
                String str = cVar.b;
                if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                    if (arrayList.size() == i) {
                        break;
                    }
                }
            }
        } else {
            arrayList = null;
        }
        cn.jiguang.ak.a.a("JLocation", "getWifiNameArray:" + arrayList);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    @Override // cn.jiguang.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ah.a.b(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.n.a
    public boolean b() {
        return cn.jiguang.n.b.k(this.a, "JLocation");
    }

    @Override // cn.jiguang.n.a
    public boolean c() {
        return cn.jiguang.n.b.l(this.a, "JLocation");
    }

    @Override // cn.jiguang.n.a
    public boolean c(Context context) {
        return true;
    }

    @Override // cn.jiguang.n.a
    public void d(Context context, String str) {
        if (cn.jiguang.i.a.a().a(1500)) {
            JSONObject a = cn.jiguang.r.c.a(context, "rl.catch");
            if (a == null) {
                cn.jiguang.ak.a.a("JLocation", "there are no data to report");
                return;
            }
            JSONArray optJSONArray = a.optJSONArray("content");
            if (optJSONArray == null) {
                cn.jiguang.ak.a.a("JLocation", "there are no content data to report");
                return;
            }
            cn.jiguang.n.d.a(context, optJSONArray);
            cn.jiguang.ak.a.a("JLocation", "clean cache json");
            cn.jiguang.r.c.b(context, "rl.catch");
            super.d(context, str);
        }
    }

    public Bundle e(Context context) {
        long j;
        double d;
        double d2;
        cn.jiguang.ai.b g = g(context);
        if (g != null) {
            j = g.a;
            d = g.d;
            d2 = g.c;
        } else {
            j = 0;
            d = 200.0d;
            d2 = 200.0d;
        }
        return a(j, d, d2);
    }

    @Override // cn.jiguang.n.a
    /* renamed from: f */
    public Bundle d(Context context) {
        long longValue;
        double doubleValue;
        double doubleValue2;
        String e = cn.jiguang.n.b.e(context);
        if (TextUtils.isEmpty(e)) {
            longValue = 0;
            doubleValue = 200.0d;
            doubleValue2 = 200.0d;
        } else {
            String[] split = e.split(",");
            longValue = Long.valueOf(split[0]).longValue();
            doubleValue = Double.valueOf(split[1]).doubleValue();
            doubleValue2 = Double.valueOf(split[2]).doubleValue();
        }
        return a(longValue, doubleValue, doubleValue2);
    }
}
