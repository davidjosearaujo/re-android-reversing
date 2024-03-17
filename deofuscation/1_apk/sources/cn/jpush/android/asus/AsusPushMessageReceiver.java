package cn.jpush.android.asus;

import android.content.Context;
import cn.jiguang.push.asus.PushMessageReceiver;
import cn.jpush.android.ab.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AsusPushMessageReceiver extends PushMessageReceiver {
    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, cn.jpush.android.c.a aVar) {
    }

    @Override // cn.jiguang.push.asus.PushMessageReceiver
    public void a(Context context, String str) {
        c.a().a(context, (byte) 6, str);
    }
}
