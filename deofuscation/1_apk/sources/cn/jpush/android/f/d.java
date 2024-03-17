package cn.jpush.android.f;

import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class d implements Runnable {
    private String a;
    private long b;
    private JSONObject c;

    public d(String str, long j, JSONObject jSONObject) {
        this.a = str;
        this.b = j;
        this.c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.a, this.b, this.c);
    }
}
