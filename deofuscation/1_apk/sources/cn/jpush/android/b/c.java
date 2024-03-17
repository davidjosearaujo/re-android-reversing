package cn.jpush.android.b;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.n.e;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class c {
    public Context a;

    public c(Context context) {
        this.a = context.getApplicationContext();
        e.a().a(new e.a() { // from class: cn.jpush.android.b.c.1
            {
                c.this = this;
            }

            @Override // cn.jpush.android.n.e.a
            public void a(b bVar) {
                c.this.a(bVar);
            }

            @Override // cn.jpush.android.n.e.a
            public void a(b bVar, b bVar2) {
                c.this.a(bVar, bVar2);
            }

            @Override // cn.jpush.android.n.e.a
            public void a(boolean z) {
                if (z) {
                    c.this.a();
                } else {
                    c.this.b();
                }
            }

            @Override // cn.jpush.android.n.e.a
            public void b(b bVar) {
                c.this.b(bVar);
            }
        });
    }

    private void a(Context context, b bVar) {
        try {
            Logger.d("GeofenceAction", "geofence report id=" + bVar.a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("geofence_id", bVar.a);
            if (JCoreManager.onEvent(null, null, 26, null, null, jSONObject, "geo_fence") instanceof JSONObject) {
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 15, null, null, jSONObject, new ReportCallBack() { // from class: cn.jpush.android.b.c.2
                    {
                        c.this = this;
                    }

                    @Override // cn.jiguang.api.ReportCallBack
                    public void onFinish(int i) {
                        Logger.d("GeofenceAction", "report with callback:" + i);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("GeofenceAction", "report geofence error:" + th);
        }
    }

    public void a() {
    }

    public void a(long j) {
    }

    public abstract void a(b bVar);

    public abstract void a(b bVar, b bVar2);

    public void b() {
    }

    public abstract void b(b bVar);

    public void c(b bVar) {
        if (bVar != null) {
            try {
                if (bVar.i == 2) {
                    a(this.a, bVar);
                } else {
                    cn.jpush.android.d.d dVar = bVar.t;
                    if (dVar != null) {
                        cn.jpush.android.d.b.a(this.a, dVar);
                    } else {
                        Logger.w("GeofenceAction", "there is no push entity, won't show notification");
                    }
                }
            } catch (Throwable th) {
                Logger.ww("GeofenceAction", "process geofence error:" + th);
            }
        }
    }
}
