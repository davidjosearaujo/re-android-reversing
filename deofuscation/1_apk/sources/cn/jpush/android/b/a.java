package cn.jpush.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.ac.i;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.n.e;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.hunantv.mpdt.data.EventClickData;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a extends c {
    private long b;
    private LocationManager c;
    private Handler d;
    private long e;
    private long f;
    private String g;
    private boolean h;
    @SuppressLint({"MissingPermission"})
    private LocationListener i;
    private final AtomicBoolean j;

    public a(Context context) {
        super(context);
        this.e = 900000L;
        this.f = 20000L;
        this.h = false;
        this.i = new LocationListener() { // from class: cn.jpush.android.b.a.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                a.this.c.removeUpdates(this);
                a.this.j.set(false);
                a.this.a(location);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        this.j = new AtomicBoolean();
        this.c = (LocationManager) context.getSystemService("location");
        this.e = cn.jpush.android.cache.a.c(context, 900000L);
        this.b = cn.jpush.android.cache.a.c(context, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Logger.dd("CustomGeofenAction", "current location:" + location);
        Handler handler = this.d;
        if (handler != null && handler.hasMessages(1001)) {
            this.d.removeMessages(1001);
        }
        if (location != null && e.a().c() > 0) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            LinkedHashMap<String, b> b = e.a().b();
            Iterator<Map.Entry<String, b>> it = b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.e * 1000 <= System.currentTimeMillis()) {
                    Logger.dd("CustomGeofenAction", "Out of date geofence " + value.a);
                    it.remove();
                    e.a().a(value);
                } else {
                    Iterator<Map.Entry<String, b>> it2 = it;
                    double a = i.a(longitude, latitude, value.f, value.g);
                    Logger.dd("CustomGeofenAction", value.a + " distance to center:" + a);
                    long j = value.b;
                    String str = a <= ((double) j) ? "in" : "out";
                    double d = j;
                    Double.isNaN(d);
                    if (Math.abs(a - d) < 1000.0d) {
                        z = true;
                    }
                    Logger.d("CustomGeofenAction", "lastStatus:" + value.h + ",currentStatus:" + str);
                    Logger.d("CustomGeofenAction", "geofence status :" + value.h + ",currentStatus:" + str + ",geoStatus:" + str);
                    if ((value.c.equals("inside") || !str.equals(value.h)) && (!value.c.equals("inside") || str != "out")) {
                        if ((value.c.equals("inside") || (value.h != null && str.equals(value.c))) && e(value)) {
                            d(value);
                            c(value);
                            cn.jpush.android.n.a.a(this.a, value.a().toString(), latitude, longitude);
                            if (!value.d) {
                                Logger.dd("CustomGeofenAction", "No repeat geofence " + value.a);
                                b.remove(value.a);
                                e.a().a(value);
                            }
                        }
                        value.h = str;
                        e.a().a(value.a, value.a(), false);
                    }
                    it = it2;
                }
            }
            if (this.b == -1) {
                long j2 = z ? 180000 : 900000;
                if (this.e != j2) {
                    this.e = j2;
                    Logger.dd("CustomGeofenAction", "need update scan peroid to:" + this.e);
                    b(j2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Logger.dd("CustomGeofenAction", "Scan geofence after " + j + EventClickData.a.c);
        Handler handler = this.d;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.d.removeMessages(1000);
        }
        this.d.sendEmptyMessageDelayed(1000, j);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_cgf_thread") { // from class: cn.jpush.android.b.a.2
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e) {
                        Logger.e("CustomGeofenAction", "handler thread run e:" + e + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.d = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.b.a.3
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    String str;
                    switch (message.what) {
                        case 1000:
                            Logger.d("CustomGeofenAction", "period task tid " + Thread.currentThread().getId());
                            a aVar = a.this;
                            aVar.b(aVar.e);
                            break;
                        case 1001:
                            a.this.d();
                            try {
                                if (a.this.g == null || !a.this.g.equals("gps")) {
                                    str = "Network provider time out!";
                                } else {
                                    Logger.dd("CustomGeofenAction", "GPS provider time out!");
                                    a.this.g = "network";
                                    if (a.this.c.isProviderEnabled(a.this.g)) {
                                        a.this.c.requestLocationUpdates(a.this.g, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, 0.0f, a.this.i);
                                        a.this.d.sendEmptyMessageDelayed(1001, a.this.f / 2);
                                        return;
                                    }
                                    str = "Network provider is disabled";
                                }
                                Logger.dd("CustomGeofenAction", str);
                            } catch (Throwable th) {
                                Logger.dd("CustomGeofenAction", "request location error#" + th);
                            }
                            a.this.j.set(false);
                            return;
                        case 1002:
                            break;
                        default:
                            return;
                    }
                    a.this.e();
                }
            };
        } catch (Throwable th) {
            Logger.ww("CustomGeofenAction", "init geofence handler failed:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void d() {
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
            Logger.w("CustomGeofenAction", str);
        } catch (Throwable th) {
            Logger.w("CustomGeofenAction", "remove location listener failed  e:" + th.getMessage());
        }
    }

    private void d(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        bVar.o = currentTimeMillis;
        Date date = new Date(currentTimeMillis);
        String format = i.a("yyyy-DDD").format(date);
        if (format.equals(bVar.r)) {
            bVar.s++;
        } else {
            bVar.r = format;
            bVar.s = 1;
        }
        String format2 = i.a("yyyy-ww").format(date);
        if (format2.equals(bVar.p)) {
            bVar.q++;
            return;
        }
        bVar.p = format2;
        bVar.q = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Logger.d("CustomGeofenAction", "try locate...");
        if (!cn.jpush.android.n.c.b(this.a, this.c)) {
            Logger.dd("CustomGeofenAction", "No enabled provider");
            return;
        }
        Logger.d("CustomGeofenAction", "sdk int:" + Build.VERSION.SDK_INT + ",targetSdkVersion:" + this.a.getApplicationInfo().targetSdkVersion);
        if (e.a().c() <= 0) {
            a();
        } else if (this.j.get()) {
            Logger.d("CustomGeofenAction", "isLocating...");
        } else {
            f();
        }
    }

    private boolean e(b bVar) {
        StringBuilder sb;
        int i;
        String sb2;
        if (bVar.o <= 0) {
            return true;
        }
        if (bVar.d) {
            if (bVar.n <= 0 && bVar.c.equals("inside")) {
                bVar.n = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = bVar.n;
            if (i2 > 0) {
                long j = bVar.o;
                if (j > 0 && currentTimeMillis < j + (i2 * 1000)) {
                    sb = new StringBuilder();
                    sb.append("in ");
                    sb.append(bVar.n);
                    sb.append("s, can't repeat geofence");
                    sb2 = sb.toString();
                }
            }
            if (bVar.m > 0 && !TextUtils.isEmpty(bVar.r)) {
                if (bVar.r.equals(i.a("yyyy-DDD").format(new Date(currentTimeMillis))) && bVar.s >= bVar.m) {
                    sb = new StringBuilder();
                    sb.append("today already repeat enough:");
                    sb.append(bVar.s);
                    sb.append("/");
                    i = bVar.m;
                    sb.append(i);
                    sb2 = sb.toString();
                }
            }
            if (bVar.l > 0 && !TextUtils.isEmpty(bVar.p)) {
                if (bVar.p.equals(i.a("yyyy-ww").format(new Date(currentTimeMillis))) && bVar.q >= bVar.l) {
                    sb = new StringBuilder();
                    sb.append("this week already repeat enough:");
                    sb.append(bVar.q);
                    sb.append("/");
                    i = bVar.l;
                    sb.append(i);
                    sb2 = sb.toString();
                }
            }
            return true;
        }
        sb2 = "can't repeat geofence";
        Logger.dd("CustomGeofenAction", sb2);
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private void f() {
        String str;
        try {
            LocationManager locationManager = this.c;
            if (locationManager == null) {
                Logger.ww("CustomGeofenAction", "locationManager is null");
                return;
            }
            Location a = cn.jpush.android.n.c.a(this.a, locationManager);
            if (System.currentTimeMillis() - (a != null ? a.getTime() : 0L) < 30000) {
                StringBuilder sb = new StringBuilder();
                sb.append("need not restart gpslocation,the time with last:");
                sb.append(System.currentTimeMillis() - (a != null ? a.getTime() : 0L));
                Logger.dd("CustomGeofenAction", sb.toString());
                a(a);
                return;
            }
            this.g = null;
            if (this.c.isProviderEnabled("gps")) {
                this.g = "gps";
            } else if (this.c.isProviderEnabled("network")) {
                this.g = "network";
            }
            Logger.d("CustomGeofenAction", "provider " + this.g);
            if (TextUtils.isEmpty(this.g)) {
                Logger.dd("CustomGeofenAction", "not gps nor network provider,stop scan geofence");
                return;
            }
            this.j.set(true);
            this.c.requestLocationUpdates(this.g, AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS, 0.0f, this.i);
            this.d.sendEmptyMessageDelayed(1001, this.f);
        } catch (SecurityException unused) {
            str = "No suitable permission when get last known location!";
            Logger.ww("CustomGeofenAction", str);
        } catch (Throwable th) {
            str = "The provider is illegal argument!" + th;
            Logger.ww("CustomGeofenAction", str);
        }
    }

    @Override // cn.jpush.android.b.c
    public synchronized void a() {
        Logger.dd("CustomGeofenAction", "geofence size:" + e.a().c());
        Logger.dd("CustomGeofenAction", "stop listen geofence");
        if (this.h) {
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1000);
            }
            this.h = false;
        }
    }

    @Override // cn.jpush.android.b.c
    public void a(long j) {
        Logger.dd("CustomGeofenAction", "Set geofence interval " + j);
        this.e = j;
        this.b = j;
        cn.jpush.android.cache.a.b(this.a, j);
    }

    @Override // cn.jpush.android.b.c
    public void a(b bVar) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence create success, id=" + bVar.a);
        if (!this.h || (handler = this.d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public void a(b bVar, b bVar2) {
        Handler handler;
        if (bVar != null) {
            Logger.dd("CustomGeofenAction", "Geofence update success, id=" + bVar.a);
        }
        if (!this.h || (handler = this.d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public synchronized void b() {
        Logger.dd("CustomGeofenAction", "start listen geofence");
        if (!cn.jpush.android.cache.a.n(this.a)) {
            Logger.ww("CustomGeofenAction", "lbs is disable!");
        } else if (this.h) {
            Logger.ii("CustomGeofenAction", "geofence is running!");
        } else if (e.a().c() == 0) {
            Logger.dd("CustomGeofenAction", "No geofence,not need listen");
        } else {
            if (this.d == null) {
                c();
            }
            b(0L);
            this.h = true;
        }
    }

    @Override // cn.jpush.android.b.c
    public void b(b bVar) {
        Logger.dd("CustomGeofenAction", "Geofence delete success, id=" + bVar.a);
    }
}
