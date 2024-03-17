package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.aq.f;
import cn.jiguang.ar.c;
import cn.jiguang.ax.a;
import cn.jiguang.internal.JConstants;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.c(TAG, "onReceive");
        if (f.a()) {
            c.d(TAG, "sdk is banned, not handle hb receiver task");
        } else if (!JConstants.isCallInit.get()) {
            c.d(TAG, "please call init");
        } else {
            a.b(context);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 10, "a2", null, new Object[0]);
        }
    }
}
