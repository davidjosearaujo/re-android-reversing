package com.hunantv.oversea.mgtv.mgmqtt;

import android.text.TextUtils;
import com.hunantv.imgo.log.MLog;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.n.m.a;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttService$3 implements MqttCallback {
    public final /* synthetic */ MgMqttService a;

    public MgMqttService$3(MgMqttService mgMqttService) {
        this.a = mgMqttService;
    }

    public void connectionLost(Throwable th) {
        a.d(MLog.a.y, MgMqttService.p, "连接中断 ");
        if (MgMqttService.b()) {
            return;
        }
        MgMqttService.f(this.a);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    @WithTryCatchRuntime
    public void messageArrived(String str, MqttMessage mqttMessage) {
        if (TextUtils.isEmpty(str) || mqttMessage == null) {
            return;
        }
        String[] split = MgMqttService.h().split(str);
        if (split.length == 0) {
            return;
        }
        String str2 = mqttMessage.getPayload() != null ? new String(mqttMessage.getPayload()) : null;
        String str3 = MgMqttService.p;
        a.d(MLog.a.y, str3, "messageArrived topic =" + str + " data=" + str2);
        MgMqttService.i(this.a, str, mqttMessage);
        String str4 = split[0];
        j.l.c.m.b.a aVar = (j.l.c.m.b.a) MgMqttService.j().get(str4);
        if (aVar != null) {
            a.d(MLog.a.y, str3, "回调到应用层业务 收到应用层级topic " + str4 + " " + str2);
            aVar.onReceive(str4, str2);
        }
    }
}
