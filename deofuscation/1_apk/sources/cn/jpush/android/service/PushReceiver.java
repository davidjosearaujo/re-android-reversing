package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aq.f;
import cn.jiguang.ar.c;
import cn.jiguang.internal.JConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PushReceiver extends BroadcastReceiver {
    private static final String TAG = "PushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (f.a()) {
                c.d(TAG, "sdk is banned, not handle push_receiver task");
                return;
            }
            c.c(TAG, "onReceive:" + intent.getAction());
            if (!JConstants.isCallInit.get()) {
                c.d(TAG, "please call init");
                return;
            }
            JCoreManager.onEvent(context.getApplicationContext(), intent.getStringExtra("sdktype"), 31, null, null, intent);
        } catch (Throwable unused) {
        }
    }
}
