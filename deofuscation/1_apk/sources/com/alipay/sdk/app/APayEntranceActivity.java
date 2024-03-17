package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class APayEntranceActivity extends Activity {
    public static final String c = "ap_order_info";
    public static final String d = "ap_target_packagename";
    public static final String e = "ap_session";
    public static final String f = "ap_local_info";
    public static final ConcurrentHashMap<String, a> g = new ConcurrentHashMap<>();
    public String a;
    public String b;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        a remove;
        String str = this.b;
        if (TextUtils.isEmpty(this.a)) {
            this.a = b.a();
        }
        if (str != null && (remove = g.remove(str)) != null) {
            remove.a(this.a);
        }
        try {
            super.finish();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            try {
                if (intent != null) {
                    this.a = intent.getStringExtra("result");
                } else {
                    this.a = b.a();
                }
            } catch (Throwable unused) {
                this.a = b.a();
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString(c);
            String string2 = extras.getString(d);
            this.b = extras.getString(e);
            String string3 = extras.getString(f, "{}");
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable unused) {
                finish();
            }
        } catch (Throwable unused2) {
            finish();
        }
    }
}
