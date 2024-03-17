package com.hunantv.oversea.mgtv.mgmqtt;

import com.hunantv.imgo.log.MLog;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.b0;
import j.l.a.n.m.a;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttService$5 implements IMqttActionListener {
    public final /* synthetic */ MgMqttService a;

    public MgMqttService$5(MgMqttService mgMqttService) {
        this.a = mgMqttService;
    }

    public void onFailure(IMqttToken iMqttToken, Throwable th) {
        a.d(MLog.a.y, MgMqttService.p, "主动断开连接失败");
        MgMqttService.d(false);
    }

    @WithTryCatchRuntime
    public void onSuccess(IMqttToken iMqttToken) {
        String str = MgMqttService.p;
        a.d(MLog.a.y, str, "主动断开连接成功");
        if (MgMqttService.a() != null && !MgMqttService.a().isConnected() && b0.f()) {
            MgMqttService.e().setUserName(MgMqttService.c());
            MgMqttService.m();
            if (MgMqttService.k() <= 3) {
                a.d(MLog.a.y, str, "重新连接: " + MgMqttService.k());
                MgMqttService.g();
                return;
            }
            return;
        }
        MgMqttService.d(false);
    }
}
