package com.hunantv.oversea.mgtv.mgmqtt;

import com.hunantv.imgo.log.MLog;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.m.c.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttService$2 implements a.c {
    public final /* synthetic */ MgMqttService d;

    public MgMqttService$2(MgMqttService mgMqttService) {
        this.d = mgMqttService;
    }

    @WithTryCatchRuntime
    public void onChange(int i) {
        if (2 != i) {
            String str = MgMqttService.p;
            j.l.a.n.m.a.d(MLog.a.y, str, "网络状态改变，重新连接");
            if (MgMqttService.a() != null) {
                j.l.a.n.m.a.d(MLog.a.y, str, "onChange() mMqttAndroidClient.isConnected() = " + MgMqttService.a().isConnected());
            } else {
                j.l.a.n.m.a.e(MLog.a.y, str, "onChange() mMqttAndroidClient == null");
            }
            if (MgMqttService.b()) {
                return;
            }
            if (MgMqttService.a() != null && MgMqttService.a().isConnected()) {
                MgMqttService.f(this.d);
            } else {
                MgMqttService.g();
            }
        }
    }
}
