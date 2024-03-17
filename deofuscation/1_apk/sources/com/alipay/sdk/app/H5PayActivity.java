package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import java.lang.ref.WeakReference;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class H5PayActivity extends Activity {
    public com.alipay.sdk.widget.c a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public WeakReference<com.alipay.sdk.sys.a> h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a() {
        Object obj = PayTask.h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            d.a((com.alipay.sdk.sys.a) l.a(this.h), i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.alipay.sdk.widget.c cVar = this.a;
        if (cVar == null) {
            finish();
        } else if (cVar.a()) {
            cVar.b();
        } else {
            if (!cVar.b()) {
                super.onBackPressed();
            }
            b.a(b.a());
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.alipay.sdk.widget.c, com.alipay.sdk.widget.d, android.view.View] */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            com.alipay.sdk.sys.a a = a.C0030a.a(getIntent());
            if (a == null) {
                finish();
                return;
            }
            this.h = new WeakReference<>(a);
            if (!com.alipay.sdk.data.a.v().s()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.b = string;
                if (!l.d(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", null);
                this.c = extras.getString(e.s, null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", com.alipay.sdk.widget.c.c);
                this.f = extras.getBoolean("backisexit", false);
                try {
                    ?? dVar = new com.alipay.sdk.widget.d(this, a, this.g);
                    setContentView((View) dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.a = dVar;
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(a, com.alipay.sdk.app.statistic.b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.alipay.sdk.widget.c cVar = this.a;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) l.a(this.h), com.alipay.sdk.app.statistic.b.l, com.alipay.sdk.app.statistic.b.F, th);
            } catch (Throwable unused) {
            }
        }
    }
}
