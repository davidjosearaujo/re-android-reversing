package com.hunantv.oversea.mgtv.mgmqtt;

import com.hunantv.imgo.log.MLog;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.n.m.a;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttService$4 implements IMqttActionListener {
    @WithTryCatchRuntime
    public void onFailure(IMqttToken iMqttToken, Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
        MgMqttService.d(false);
        String str = MgMqttService.p;
        a.d(MLog.a.y, str, "连接失败 " + MgMqttService.o(th));
    }

    @WithTryCatchRuntime
    public void onSuccess(IMqttToken iMqttToken) {
        String str = MgMqttService.p;
        a.d(MLog.a.y, str, "连接成功 ");
        MgMqttService.l(0);
        MgMqttService.d(false);
        if (MgMqttService.n() != null) {
            try {
                a.d(MLog.a.y, str, "重新订阅: " + MgMqttService.n());
                MgMqttService.a().subscribe(MgMqttService.n(), 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
