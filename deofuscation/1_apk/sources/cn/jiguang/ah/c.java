package cn.jiguang.ah;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.fastjson.JSONStreamContext;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;

@SuppressLint({"MissingPermission"})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    private static final Object e = new Object();
    private static c h;
    public Handler a;
    private Context b;
    private LocationManager c;
    private cn.jiguang.ai.b d;
    private boolean f;
    private String g;
    private LocationListener i = new LocationListener() { // from class: cn.jiguang.ah.c.1
        {
            c.this = this;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                cn.jiguang.ak.a.a("JLocationGps", "onLocationChanged:" + location + ",provider:" + c.this.g);
                c.this.a(location);
                c.this.h();
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("JLocationGps", "onLocationChanged failed:" + th.getMessage());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            cn.jiguang.ak.a.a("JLocationGps", "onProviderDisabled:" + str);
            c.this.h();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            cn.jiguang.ak.a.a("JLocationGps", "onProviderEnabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            cn.jiguang.ak.a.a("JLocationGps", "onStatusChanged status:" + i);
            if (i == 0) {
                c.this.h();
            }
        }
    };

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            c.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i = 1001;
            switch (message.what) {
                case 1001:
                    try {
                        if (c.this.g == null || !c.this.g.equals("network")) {
                            cn.jiguang.ak.a.d("JLocationGps", "get " + c.this.g + " time out ");
                            c.this.h();
                        } else {
                            cn.jiguang.ak.a.d("JLocationGps", "get gps with network time out ");
                            c.this.g = "gps";
                            c.this.g();
                            c.this.c.requestLocationUpdates(c.this.g, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, 0.0f, c.this.i);
                            cn.jiguang.ak.a.a("JLocationGps", "request " + c.this.g + " location");
                            c.this.a.sendEmptyMessageDelayed(1001, 10000L);
                        }
                        return;
                    } catch (Throwable th) {
                        str = "when location time out " + th.getMessage();
                        break;
                    }
                    break;
                case 1002:
                default:
                    return;
                case JSONStreamContext.PropertyValue /* 1003 */:
                    try {
                        c.this.c.requestLocationUpdates(c.this.g, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, 0.0f, c.this.i);
                        cn.jiguang.ak.a.a("JLocationGps", "request " + c.this.g + " location");
                        c.this.a.sendEmptyMessageDelayed(i, 20000L);
                        return;
                    } catch (SecurityException unused) {
                        str = "No suitable permission when get last known location!";
                        break;
                    } catch (Throwable unused2) {
                        str = "The provider is illegal argument!";
                        break;
                    }
                case JSONStreamContext.StartArray /* 1004 */:
                    cn.jiguang.ak.a.a("JLocationGps", "LOAD_GPS_ACTION_REQUEST_ONLY_NETWORK");
                    i = JSONStreamContext.ArrayValue;
                    c.this.c.requestLocationUpdates(c.this.g, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, 0.0f, c.this.i);
                    cn.jiguang.ak.a.a("JLocationGps", "request " + c.this.g + " location");
                    c.this.a.sendEmptyMessageDelayed(i, 20000L);
                    return;
                case JSONStreamContext.ArrayValue /* 1005 */:
                    str = "get only network " + c.this.g + " time out ";
                    cn.jiguang.ak.a.d("JLocationGps", str);
                    c.this.h();
                    return;
            }
        }
    }

    private c(Context context) {
        this.b = context;
        this.c = (LocationManager) context.getSystemService("location");
    }

    public static c a(Context context) {
        if (h == null) {
            synchronized (e) {
                if (h == null) {
                    h = new c(context);
                }
            }
        }
        return h;
    }

    public void a(Location location) {
        if (location == null) {
            this.d = null;
            return;
        }
        cn.jiguang.ak.a.a("JLocationGps", "updateGpsInfo location time:" + location.getTime());
        if (this.d == null) {
            this.d = new cn.jiguang.ai.b();
        }
        this.d.a = cn.jiguang.n.d.a(this.b, location.getTime());
        this.d.b = location.getProvider();
        this.d.c = location.getLatitude();
        this.d.d = location.getLongitude();
        this.d.f = location.getBearing();
        this.d.g = location.getAccuracy();
    }

    private boolean a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a2;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private void f() {
        try {
            if (this.a == null) {
                HandlerThread handlerThread = new HandlerThread("jg_lcn_thread");
                handlerThread.start();
                this.a = new a(handlerThread.getLooper());
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.f("JLocationGps", "start load loc-info failed - error:" + th);
        }
    }

    public void g() {
        String str;
        try {
            LocationListener locationListener = this.i;
            if (locationListener != null) {
                LocationManager locationManager = this.c;
                if (locationManager != null) {
                    locationManager.removeUpdates(locationListener);
                }
                str = "locationManager is null , do nothing!";
            } else {
                str = "Location listener is null , do nothing!";
            }
            cn.jiguang.ak.a.d("JLocationGps", str);
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("JLocationGps", "remove location listener failed  e:" + th.getMessage());
        }
    }

    public void h() {
        cn.jiguang.ak.a.a("JLocationGps", "gps will done");
        this.f = true;
        g();
        Handler handler = this.a;
        if (handler == null) {
            cn.jiguang.ak.a.e("JLocationGps", "cellLocationManager is null,please check it");
            return;
        }
        if (handler.hasMessages(JSONStreamContext.StartArray)) {
            this.a.removeMessages(JSONStreamContext.StartArray);
        }
        if (this.a.hasMessages(JSONStreamContext.PropertyValue)) {
            this.a.removeMessages(JSONStreamContext.PropertyValue);
        }
        if (this.a.hasMessages(1001)) {
            this.a.removeMessages(1001);
        }
        if (this.a.hasMessages(JSONStreamContext.ArrayValue)) {
            this.a.removeMessages(JSONStreamContext.ArrayValue);
        }
        try {
            this.a.getLooper().quit();
        } finally {
            try {
            } finally {
            }
        }
    }

    public cn.jiguang.ai.b a() {
        return this.d;
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        String str;
        this.f = false;
        this.d = null;
        if (this.c == null) {
            str = "get locationManager failed";
        } else {
            f();
            if (this.a != null) {
                if (this.c.isProviderEnabled("network")) {
                    this.g = "network";
                } else if (!this.c.isProviderEnabled("gps")) {
                    this.g = "network";
                    this.a.sendEmptyMessage(JSONStreamContext.StartArray);
                    return;
                } else {
                    this.g = "gps";
                }
                this.a.sendEmptyMessage(JSONStreamContext.PropertyValue);
                return;
            }
            str = " mAsyncHandler is empty";
        }
        cn.jiguang.ak.a.d("JLocationGps", str);
        this.f = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0032 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:28:0x0002, B:30:0x0020, B:38:0x0032, B:40:0x0041, B:33:0x0027), top: B:46:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.jiguang.ai.b d() {
        /*
            r7 = this;
            java.lang.String r0 = "JLocationGps"
            android.location.LocationManager r1 = r7.c     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "gps"
            android.location.Location r1 = r1.getLastKnownLocation(r2)     // Catch: java.lang.Throwable -> L69
            android.location.LocationManager r2 = r7.c     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.getLastKnownLocation(r3)     // Catch: java.lang.Throwable -> L69
            android.location.LocationManager r3 = r7.c     // Catch: java.lang.Throwable -> L69
            java.lang.String r4 = "passive"
            android.location.Location r3 = r3.getLastKnownLocation(r4)     // Catch: java.lang.Throwable -> L69
            boolean r4 = r7.a(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L27
            boolean r2 = r7.a(r1, r3)     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L2f
            goto L30
        L27:
            boolean r1 = r7.a(r2, r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L2f
            r1 = r2
            goto L30
        L2f:
            r1 = r3
        L30:
            if (r1 == 0) goto L82
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69
            long r4 = r1.getTime()     // Catch: java.lang.Throwable -> L69
            long r2 = r2 - r4
            r4 = 30000(0x7530, double:1.4822E-319)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L82
            r7.a(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "bestLocation:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ai.b r2 = r7.d     // Catch: java.lang.Throwable -> L69
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = ",curTime:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L69
            r1.append(r2)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ak.a.a(r0, r1)     // Catch: java.lang.Throwable -> L69
            cn.jiguang.ai.b r0 = r7.d     // Catch: java.lang.Throwable -> L69
            return r0
        L69:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "loadLastGpsInfo failed: "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            cn.jiguang.ak.a.d(r0, r1)
        L82:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ah.c.d():cn.jiguang.ai.b");
    }

    public boolean e() {
        String str;
        try {
            LocationManager locationManager = this.c;
            if (locationManager != null) {
                if (!locationManager.isProviderEnabled("gps") && !this.c.isProviderEnabled("network")) {
                    if (!this.c.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            cn.jiguang.ak.a.d("JLocationGps", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            cn.jiguang.ak.a.d("JLocationGps", str);
            return false;
        } catch (Exception unused3) {
            str = "The ILocationManager is null!";
            cn.jiguang.ak.a.d("JLocationGps", str);
            return false;
        }
    }
}
