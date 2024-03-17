package cn.jiguang.push.asus;

import android.content.Context;
import android.content.Intent;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ PushMessageReceiver c;

    public a(PushMessageReceiver pushMessageReceiver, Context context, Intent intent) {
        this.c = pushMessageReceiver;
        this.a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a, this.b);
    }
}
