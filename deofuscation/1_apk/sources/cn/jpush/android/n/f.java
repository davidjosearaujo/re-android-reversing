package cn.jpush.android.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.ac.i;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.g;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.mpdt.data.EventClickData;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class f {
    private final LocationManager a;
    private Context b;
    private Handler c;
    private volatile a e;
    private volatile b f;
    private HashMap<String, JSONObject> d = new HashMap<>();
    private boolean g = false;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a {
        public long a;
        public double b;
        public double c;

        public a() {
            f.this = r1;
        }

        public void a(Context context) {
            String m = cn.jpush.android.cache.a.m(context);
            if (TextUtils.isEmpty(m)) {
                return;
            }
            Logger.d("GeofencePullHelper", "last pull state:" + m);
            try {
                a(new JSONObject(m));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            Logger.d("GeofencePullHelper", "saveGeofenceLastPullState:" + jSONObject.toString());
            a(jSONObject);
            cn.jpush.android.cache.a.f(f.this.b, jSONObject.toString());
        }

        public void a(JSONObject jSONObject) {
            f.this.e.b = jSONObject.optDouble("lat", 200.0d);
            f.this.e.c = jSONObject.optDouble("lng", 200.0d);
            f.this.e.a = jSONObject.optLong(CrashHianalyticsData.TIME, 0L);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b {
        public int a = 1800;
        public int b = 10800;
        public int c = 900;
        public int d = 20;

        public b() {
            f.this = r1;
        }

        private void a(JSONObject jSONObject) {
            f.this.f.a = jSONObject.optInt("minInterval", f.this.f.a);
            f.this.f.b = jSONObject.optInt("nextInterval", f.this.f.b);
            f.this.f.c = jSONObject.optInt("minLBSInterval", f.this.f.c);
            f.this.f.d = jSONObject.optInt("minLBSKilo", f.this.f.d);
        }

        private void a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, i);
            }
        }

        public void a(Context context) {
            String l = cn.jpush.android.cache.a.l(context);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            Logger.d("GeofencePullHelper", "pull limit:" + l);
            try {
                a(new JSONObject(l));
            } catch (Throwable unused) {
            }
        }

        public void a(Context context, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject, jSONObject2, "minInterval", f.this.f.a);
                a(jSONObject, jSONObject2, "nextInterval", f.this.f.b);
                a(jSONObject, jSONObject2, "minLBSInterval", f.this.f.c);
                a(jSONObject, jSONObject2, "minLBSKilo", f.this.f.d);
                cn.jpush.android.cache.a.e(context, jSONObject2.toString());
            } catch (Throwable unused) {
                Logger.d("GeofencePullHelper", "save limit failed");
            }
        }
    }

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.a = (LocationManager) applicationContext.getSystemService("location");
        c();
        i();
        j();
    }

    private void a(double d, double d2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", d);
            jSONObject.put("lng", d2);
            jSONObject.put(CrashHianalyticsData.TIME, System.currentTimeMillis() / 1000);
            long a2 = g.a();
            Logger.dd("GeofencePullHelper", "will send report geo request:" + jSONObject + ",requestid:" + a2);
            HashMap<String, JSONObject> hashMap = this.d;
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("");
            hashMap.put(sb.toString(), jSONObject);
            JCoreHelper.sendRequest(this.b, JPushConstants.SDK_TYPE, 37, 1, a2, 0L, cn.jpush.android.z.c.c(jSONObject.toString()));
        } catch (Throwable th) {
            Logger.dd("GeofencePullHelper", "send report geo request failed:" + th.getMessage());
        }
    }

    public void a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("pull geofence after ");
        long j2 = j * 1000;
        sb.append(j2);
        sb.append(EventClickData.a.c);
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.c.removeMessages(1000);
        }
        this.c.sendEmptyMessageDelayed(1000, j2);
    }

    public void b(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("compile loc after ");
        long j2 = j * 1000;
        sb.append(j2);
        sb.append(EventClickData.a.c);
        Logger.dd("GeofencePullHelper", sb.toString());
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1002)) {
            this.c.removeMessages(1002);
        }
        this.c.sendEmptyMessageDelayed(1002, j2);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_gph_thread") { // from class: cn.jpush.android.n.f.1
                {
                    f.this = this;
                }

                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e) {
                        Logger.e("GeofencePullHelper", "handler thread run e:" + e + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.n.f.2
                {
                    f.this = this;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            f fVar = f.this;
                            fVar.a(fVar.f.b);
                            break;
                        case 1001:
                            break;
                        case 1002:
                            if (f.this.g()) {
                                f.this.a(0L);
                            }
                            f fVar2 = f.this;
                            fVar2.b(fVar2.f.c);
                            return;
                        default:
                            return;
                    }
                    f.this.f();
                }
            };
        } catch (Throwable th) {
            Logger.ww("GeofencePullHelper", "init geofence pull handler failed:" + th);
        }
    }

    private void d() {
        Logger.dd("GeofencePullHelper", "start schedule geofence pull");
        a((h() || g()) ? 0L : this.f.b);
        b(this.f.c);
    }

    private void e() {
        Logger.dd("GeofencePullHelper", "stop schedule geofence pull");
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.c.removeMessages(1000);
        }
        if (this.c.hasMessages(1001)) {
            this.c.removeMessages(1001);
        }
        if (this.c.hasMessages(1002)) {
            this.c.removeMessages(1002);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void f() {
        Logger.dd("GeofencePullHelper", "try pull...");
        Location a2 = c.a(this.b, this.a);
        if (a2 == null) {
            Logger.dd("GeofencePullHelper", "stop pull,get loction failed");
        } else {
            a(a2.getLatitude(), a2.getLongitude());
        }
    }

    public boolean g() {
        Location a2 = c.a(this.b, this.a);
        if (a2 != null) {
            double a3 = i.a(a2.getLongitude(), a2.getLatitude(), this.e.c, this.e.b);
            Logger.d("GeofencePullHelper", "check current distance to last pull distance:" + a3 + ",lbsKilo:" + (this.f.d * 1000));
            if (a3 > this.f.d * 1000) {
                return true;
            }
        }
        Logger.dd("GeofencePullHelper", "loc limit");
        return false;
    }

    private boolean h() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = this.e.a;
        Logger.dd("GeofencePullHelper", "lastPullTime:" + j + ",currentTime:" + currentTimeMillis + ",minInterval:" + this.f.a);
        if (currentTimeMillis - j < this.f.a) {
            Logger.dd("GeofencePullHelper", "time limit");
            return false;
        }
        return true;
    }

    private void i() {
        this.e = new a();
        this.e.a(this.b);
    }

    private void j() {
        this.f = new b();
        this.f.a(this.b);
        this.g = cn.jpush.android.cache.a.k(this.b);
    }

    public void a() {
        Logger.d("GeofencePullHelper", "onLogin");
        if (this.g) {
            d();
        } else {
            Logger.dd("GeofencePullHelper", "do not support pull");
        }
    }

    public void a(long j, int i, d dVar) {
        String str;
        StringBuilder sb;
        String str2;
        HashMap<String, JSONObject> hashMap = this.d;
        JSONObject remove = hashMap.remove(j + "");
        if (i == JPushInterface.ErrorCode.TIMEOUT) {
            sb = new StringBuilder();
            str2 = "pull geo is timeout,requestid:";
        } else if (remove != null) {
            JSONObject a2 = dVar.a();
            if (a2 == null) {
                str = "onPullResponse empty pull response";
                Logger.dd("GeofencePullHelper", str);
            }
            this.f.a(this.b, a2);
            JSONArray b2 = dVar.b();
            if (b2 == null) {
                b2 = new JSONArray();
            }
            Logger.dd("GeofencePullHelper", "onPullResponse:" + b2);
            if (b2.length() == 0) {
                this.g = false;
                cn.jpush.android.cache.a.c(this.b, false);
                e();
            }
            this.e.a(this.b, remove);
            e.a().a(b2);
            cn.jpush.android.n.a.a(this.b, b2 != null ? b2.toString() : "");
            return;
        } else {
            sb = new StringBuilder();
            str2 = "can not find request from requestid:";
        }
        sb.append(str2);
        sb.append(j);
        str = sb.toString();
        Logger.dd("GeofencePullHelper", str);
    }

    public void a(cn.jpush.android.n.b bVar) {
        if (bVar == null) {
            return;
        }
        int a2 = bVar.a();
        Logger.d("GeofencePullHelper", "control pull geo type:" + a2);
        if (this.g ^ (a2 == 1)) {
            boolean z = a2 == 1;
            this.g = z;
            cn.jpush.android.cache.a.c(this.b, z);
            if (this.g) {
                d();
            } else {
                e();
            }
        }
    }

    public void b() {
        Logger.d("GeofencePullHelper", "onTcpDisconnected");
        e();
    }
}
