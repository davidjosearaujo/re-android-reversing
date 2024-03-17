package com.hunantv.oversea.mgtv.mgmqtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.hunantv.imgo.log.MLog;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.n.m.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttService$1 extends BroadcastReceiver {
    public final /* synthetic */ MgMqttService a;

    public MgMqttService$1(MgMqttService mgMqttService) {
        this.a = mgMqttService;
    }

    @Override // android.content.BroadcastReceiver
    @WithTryCatchRuntime
    public void onReceive(Context context, Intent intent) {
        String str = MgMqttService.p;
        a.d(MLog.a.y, str, "登录状态改变，重新连接");
        if (MgMqttService.a() != null) {
            a.d(MLog.a.y, str, "onReceive() mMqttAndroidClient.isConnected() = " + MgMqttService.a().isConnected());
        } else {
            a.e(MLog.a.y, str, "onReceive() mMqttAndroidClient == null");
        }
        if (MgMqttService.b()) {
            return;
        }
        if (MgMqttService.a() != null && MgMqttService.a().isConnected()) {
            MgMqttService.f(this.a);
        } else {
            MgMqttService.g();
        }
    }
}
