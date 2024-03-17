package cn.jiguang.aj;

import android.location.GpsStatus;
import android.location.Location;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class i implements GpsStatus.Listener {
    private a a;

    public i(a aVar) {
        this.a = aVar;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        final Location a;
        if (i == 1) {
            cn.jiguang.ak.a.a("GpsStatuListener", "onGpsStatus start");
            this.a.d = System.currentTimeMillis() - (c.m * 1000);
        } else if (i != 4) {
        } else {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a aVar = this.a;
                if (currentTimeMillis - aVar.d > c.m * 1000) {
                    aVar.d = currentTimeMillis;
                    aVar.f = 0;
                }
                int i2 = aVar.f;
                if (i2 >= 3 || currentTimeMillis - aVar.e < AnimationBackendDelegateWithInactivityCheck.INACTIVITY_THRESHOLD_MS) {
                    return;
                }
                aVar.f = i2 + 1;
                aVar.e = currentTimeMillis;
                if (d.a().b() && (a = this.a.a(true)) != null && "gps".equals(a.getProvider())) {
                    Location location = this.a.a;
                    if (location == null || a.distanceTo(location) >= c.n) {
                        cn.jiguang.at.b.d(new Runnable() { // from class: cn.jiguang.aj.i.1
                            {
                                i.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.a.c.a(a);
                            }
                        }, new int[0]);
                        this.a.a = new Location(a);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ak.a.d("GpsStatuListener", "onGpsStatus error:" + th);
            }
        }
    }
}
