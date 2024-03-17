package com.hunantv.oversea.mgtv.mgmqtt;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.imgo.log.MLog;
import com.hunantv.oversea.mgtv.mqtt.MgmqttProcess;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.o.a;
import j.l.c.j.c;
import j.l.c.o.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MgMqttUtils {
    public static final String a = "MgMqttUtils";
    public static final String b = "manguozai";
    public static final String c = "rprain";
    public static final String d = "rprainv2";
    public static final String e = "courier_new";
    public static final String f = "ad_push";
    public static final String g = "layer-v2";
    public static final String h = "im_push";
    public static final String i = "im_message";
    public static final String j = "friend";
    public static final String k = "online";
    public static final String l = "linkIm";
    public static final String m = "tab_pop";
    private static final Map<String, Class<?>> n = new HashMap();
    private static d<Object> o = new d<Object>() { // from class: com.hunantv.oversea.mgtv.mgmqtt.MgMqttUtils.2
        public void a(String str) {
        }

        @WithTryCatchRuntime
        public void onSuccess(@Nullable String str, @Nullable Object obj) {
            Activity K;
            c cVar = (c) ARouter.getInstance().build("/starter/provider").navigation();
            if (cVar == null || (K = cVar.K()) == null || !(K instanceof RootActivity) || TextUtils.isEmpty(str) || obj == null) {
                return;
            }
            a.a(0, MgMqttUtils.a, "mqtt onSuccess topic=" + str + ",msgObj=" + obj + ",activity=" + K);
            RootActivity rootActivity = (RootActivity) K;
            if (rootActivity.shouldProcess(str, obj)) {
                a.a(0, MgMqttUtils.a, "Thread=" + Thread.currentThread().getName() + ",onMqttProcess topic=" + str + " msgObj = " + obj + ",rootActivity=" + rootActivity);
                MgmqttProcess.process(str, obj, rootActivity);
            }
        }
    };

    public static String a(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "mgact@android/" + str;
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, "0")) {
            return str3;
        }
        return str3 + "/" + str2;
    }

    public static Class b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.get(str);
    }

    public static void c(String str) {
        Map<String, Class<?>> map;
        if (TextUtils.isEmpty(str) || (map = n) == null || !map.containsKey(str)) {
            return;
        }
        map.remove(str);
    }

    public static void d(@Nullable String str) {
        MgMqttService.unSubscribe(str);
    }

    @WithTryCatchRuntime
    public static void registerModules(String str, Class<?> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        n.put(str, cls);
        registerMqttListener(str, o);
    }

    @WithTryCatchRuntime
    private static void registerMqttListener(final String str, final d<Object> dVar) {
        j.l.a.n.m.a.d(MLog.a.y, a, "registerMqttListener mqttTopic = " + str);
        if (!TextUtils.isEmpty(str)) {
            MgMqttService.registerMqttListener(str, new j.l.c.m.b.c(new j.l.c.m.b.a() { // from class: com.hunantv.oversea.mgtv.mgmqtt.MgMqttUtils.1
                public void a(String str2) {
                    j.l.a.n.m.a.d(MLog.a.y, MgMqttUtils.a, "mqtt onSubscribeSuccess: gobalMqttListener");
                }

                @WithTryCatchRuntime
                public void onReceive(String str2, Object obj) {
                    if (obj != null) {
                        d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.onSuccess(str, obj);
                            return;
                        }
                        return;
                    }
                    d dVar3 = dVar;
                    if (dVar3 != null) {
                        dVar3.a(str);
                    }
                }

                @WithTryCatchRuntime
                public void onSubscribeFailure(String str2, String str3) {
                    j.l.a.n.m.a.d(MLog.a.y, MgMqttUtils.a, "mqtt onSubscribeFailure: gobalMqttListener,message=" + str3);
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.a(str);
                    }
                }
            }));
        } else if (dVar != null) {
            dVar.a(str);
        }
    }

    @WithTryCatchRuntime
    public static boolean subscribeToMqtt(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return MgMqttService.subscribe(str, 0);
    }

    @WithTryCatchRuntime
    @Deprecated
    public static void registerModules(String str, Class<?> cls, d<Object> dVar) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        n.put(str, cls);
        registerMqttListener(str, o);
    }
}
