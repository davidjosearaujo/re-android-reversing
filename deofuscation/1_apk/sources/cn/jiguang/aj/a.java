package cn.jiguang.aj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.api.JCoreManager;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class a {
    public Location a;
    public Context b;
    public f c;
    private LocationManager g;
    private boolean h;
    public long d = 0;
    public long e = 0;
    public int f = 0;
    private GpsStatus.Listener i = new i(this);

    @SuppressLint({"MissingPermission"})
    public a(Context context) {
        this.b = JCoreManager.getAppContext(context);
        this.g = (LocationManager) context.getSystemService("location");
    }

    private boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean a(Location location) {
        if (location == null) {
            return false;
        }
        return (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d && location.getTime() == 0 && !location.hasAccuracy()) ? false : true;
    }

    @SuppressLint({"MissingPermission"})
    private boolean c() {
        if (d()) {
            if (cn.jiguang.f.a.h(this.b, "com.huawei.android.hwouc")) {
                return true;
            }
            LocationManager locationManager = this.g;
            if (locationManager != null) {
                if (a(locationManager.getLastKnownLocation("network"))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean d() {
        return cn.jiguang.n.d.a(this.b, "android.permission.ACCESS_FINE_LOCATION") && cn.jiguang.n.d.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") && a(this.b, "android.permission.ACCESS_FINE_LOCATION") && a(this.b, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:7|(1:40)(1:11)|(3:12|13|14)|(2:16|17)(2:31|(2:33|34)(6:35|19|20|21|22|23))|18|19|20|21|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        cn.jiguang.ak.a.a("CellHelper", "getNeighborCell error:" + r3.getMessage());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.telephony.TelephonyManager] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v6 */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private cn.jiguang.aj.b e() {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.aj.a.e():cn.jiguang.aj.b");
    }

    @SuppressLint({"MissingPermission"})
    public Location a(boolean z) {
        try {
            if (this.g != null && c()) {
                return z ? this.g.getLastKnownLocation("gps") : this.g.getLastKnownLocation("network");
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.ak.a.a("CellHelper", "getLocation error:" + th);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public void a() {
        try {
            if (this.h) {
                cn.jiguang.ak.a.a("CellHelper", "g is on listening");
                return;
            }
            boolean b = d.a().b();
            boolean c = c();
            cn.jiguang.ak.a.a("CellHelper", " init checkSafeStatus = " + b + " , deviceEnv=" + c);
            if (b && this.g != null && c) {
                new Handler(Looper.getMainLooper()).post(new cn.jiguang.n.e() { // from class: cn.jiguang.aj.a.1
                    @Override // cn.jiguang.n.e
                    public void a() {
                        try {
                            a.this.g.addGpsStatusListener(a.this.i);
                        } catch (Throwable th) {
                            cn.jiguang.ak.a.d("CellHelper", "addGpsStatusListener error:" + th);
                        }
                    }
                });
                this.h = true;
                cn.jiguang.ak.a.a("CellHelper", "g is start listening");
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.a("CellHelper", "init error:" + th);
            this.h = false;
        }
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    public void b() {
        try {
            b e = e();
            if (e != null) {
                this.c.a(e);
            }
        } catch (Throwable th) {
            cn.jiguang.ak.a.d("CellHelper", "startScanCell error:" + th);
        }
    }
}
