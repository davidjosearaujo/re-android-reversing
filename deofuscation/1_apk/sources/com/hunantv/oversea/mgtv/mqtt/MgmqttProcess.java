package com.hunantv.oversea.mgtv.mqtt;

import com.hunantv.imgo.base.RootActivity;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgmqttProcess {
    private static AbstractMqttProcess a;

    public static void a(AbstractMqttProcess abstractMqttProcess) {
        if (abstractMqttProcess != null) {
            AbstractMqttProcess abstractMqttProcess2 = a;
            if (abstractMqttProcess2 != null) {
                abstractMqttProcess.c(abstractMqttProcess2);
            }
            a = abstractMqttProcess;
        }
    }

    public static void b(AbstractMqttProcess abstractMqttProcess) {
        AbstractMqttProcess abstractMqttProcess2;
        if (abstractMqttProcess == null || (abstractMqttProcess2 = a) == null) {
            return;
        }
        if (abstractMqttProcess == abstractMqttProcess2) {
            a = abstractMqttProcess2.a();
            return;
        }
        AbstractMqttProcess a2 = abstractMqttProcess2.a();
        while (a2 != null) {
            if (abstractMqttProcess == a2) {
                abstractMqttProcess2.c(a2.a());
                return;
            } else {
                abstractMqttProcess2 = abstractMqttProcess2.a();
                a2 = abstractMqttProcess2.a();
            }
        }
    }

    @WithTryCatchRuntime
    public static void process(String str, Object obj, RootActivity rootActivity) {
        AbstractMqttProcess abstractMqttProcess = a;
        if (abstractMqttProcess != null) {
            abstractMqttProcess.process(str, obj, rootActivity);
        }
    }
}
