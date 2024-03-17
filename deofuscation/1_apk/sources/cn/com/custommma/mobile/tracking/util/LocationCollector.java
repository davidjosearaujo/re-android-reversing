package cn.com.custommma.mobile.tracking.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LocationCollector {
    private static final boolean ENABLE_LOCATION_UPDATELISTENER = true;
    private static final float LOCATION_UPDATE_MINDISTANCE = 0.0f;
    private static final long LOCATION_UPDATE_MINTIME = 300000;
    private static final long REMOVE_INTERVAL = 20000;
    private static final long UPDATES_INTERVAL = 120000;
    private static Handler mHandler;
    private static LocationCollector mInstance;
    private LocationManager locationManager;
    private Context mContext;
    private long lastLocationTime = 0;
    private final Runnable stopListener = new Runnable() { // from class: cn.com.custommma.mobile.tracking.util.LocationCollector.2
        {
            LocationCollector.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LocationCollector.this.locationManager.removeUpdates(LocationCollector.this.locationListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            LocationCollector.this.isSynced = false;
            LocationCollector.mHandler.removeCallbacks(LocationCollector.this.stopListener);
        }
    };
    private LocationListener locationListener = new LocationListener() { // from class: cn.com.custommma.mobile.tracking.util.LocationCollector.3
        {
            LocationCollector.this = this;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            LocationCollector.this.lastLocationTime = System.currentTimeMillis();
            LocationCollector.this.currentLocation = location;
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
    private boolean isSynced = false;
    private Location currentLocation = null;

    private LocationCollector(Context context) {
        this.mContext = context;
        this.locationManager = (LocationManager) context.getSystemService("location");
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static LocationCollector getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LocationCollector.class) {
                if (mInstance == null) {
                    mInstance = new LocationCollector(context);
                }
            }
        }
        return mInstance;
    }

    public String getLocation() {
        if (this.currentLocation == null) {
            syncLocation();
            return "";
        }
        if (System.currentTimeMillis() - this.lastLocationTime > UPDATES_INTERVAL) {
            syncLocation();
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(this.currentLocation.getLatitude());
            stringBuffer.append("x");
            stringBuffer.append(this.currentLocation.getLongitude());
            stringBuffer.append("x");
            stringBuffer.append(this.currentLocation.getAccuracy());
        } catch (Exception unused) {
        }
        return stringBuffer.toString();
    }

    public void stopSyncLocation() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this.locationListener);
            mHandler.removeCallbacks(this.stopListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0032 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void syncLocation() {
        /*
            r6 = this;
            java.lang.String r0 = "gps"
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            r3 = 0
            android.content.Context r4 = r6.mContext     // Catch: java.lang.Exception -> L85
            boolean r4 = cn.com.custommma.mobile.tracking.util.Reflection.checkPermission(r4, r2)     // Catch: java.lang.Exception -> L85
            r5 = 1
            if (r4 != 0) goto L1b
            android.content.Context r4 = r6.mContext     // Catch: java.lang.Exception -> L85
            boolean r2 = cn.com.custommma.mobile.tracking.util.Reflection.checkPermissionX(r4, r2)     // Catch: java.lang.Exception -> L85
            if (r2 == 0) goto L19
            goto L1b
        L19:
            r2 = 0
            goto L1c
        L1b:
            r2 = 1
        L1c:
            android.content.Context r4 = r6.mContext     // Catch: java.lang.Exception -> L85
            boolean r4 = cn.com.custommma.mobile.tracking.util.Reflection.checkPermission(r4, r1)     // Catch: java.lang.Exception -> L85
            if (r4 != 0) goto L2f
            android.content.Context r4 = r6.mContext     // Catch: java.lang.Exception -> L85
            boolean r1 = cn.com.custommma.mobile.tracking.util.Reflection.checkPermissionX(r4, r1)     // Catch: java.lang.Exception -> L85
            if (r1 == 0) goto L2d
            goto L2f
        L2d:
            r1 = 0
            goto L30
        L2f:
            r1 = 1
        L30:
            if (r2 == 0) goto L87
            if (r1 == 0) goto L87
            android.location.LocationManager r1 = r6.locationManager     // Catch: java.lang.Exception -> L85
            java.util.List r1 = r1.getProviders(r5)     // Catch: java.lang.Exception -> L85
            boolean r2 = r1.contains(r0)     // Catch: java.lang.Exception -> L85
            r4 = 0
            if (r2 == 0) goto L48
            android.location.LocationManager r2 = r6.locationManager     // Catch: java.lang.Exception -> L85
            android.location.Location r4 = r2.getLastKnownLocation(r0)     // Catch: java.lang.Exception -> L85
            goto L49
        L48:
            r0 = r4
        L49:
            java.lang.String r2 = "network"
            if (r4 != 0) goto L5a
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Exception -> L85
            if (r1 == 0) goto L5a
            android.location.LocationManager r0 = r6.locationManager     // Catch: java.lang.Exception -> L85
            android.location.Location r4 = r0.getLastKnownLocation(r2)     // Catch: java.lang.Exception -> L85
            r0 = r2
        L5a:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L85
            if (r1 == 0) goto L61
            return
        L61:
            if (r4 == 0) goto L6b
            r6.currentLocation = r4     // Catch: java.lang.Exception -> L85
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L85
            r6.lastLocationTime = r1     // Catch: java.lang.Exception -> L85
        L6b:
            boolean r1 = r6.isSynced     // Catch: java.lang.Exception -> L85
            if (r1 != 0) goto L87
            android.os.Handler r1 = cn.com.custommma.mobile.tracking.util.LocationCollector.mHandler     // Catch: java.lang.Exception -> L85
            cn.com.custommma.mobile.tracking.util.LocationCollector$1 r2 = new cn.com.custommma.mobile.tracking.util.LocationCollector$1     // Catch: java.lang.Exception -> L85
            r2.<init>()     // Catch: java.lang.Exception -> L85
            r1.post(r2)     // Catch: java.lang.Exception -> L85
            r6.isSynced = r5     // Catch: java.lang.Exception -> L85
            android.os.Handler r0 = cn.com.custommma.mobile.tracking.util.LocationCollector.mHandler     // Catch: java.lang.Exception -> L85
            java.lang.Runnable r1 = r6.stopListener     // Catch: java.lang.Exception -> L85
            r4 = 20000(0x4e20, double:9.8813E-320)
            r0.postDelayed(r1, r4)     // Catch: java.lang.Exception -> L85
            goto L87
        L85:
            r6.isSynced = r3
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.custommma.mobile.tracking.util.LocationCollector.syncLocation():void");
    }
}
