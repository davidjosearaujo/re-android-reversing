package com.hunantv.oversea.mgtv.mqtt;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.oversea.mgtv.mgmqtt.MgMqttUtils;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class AbstractMqttProcess<T> {
    private AbstractMqttProcess a;

    public AbstractMqttProcess(AbstractMqttProcess abstractMqttProcess) {
        this.a = abstractMqttProcess;
    }

    public AbstractMqttProcess a() {
        return this.a;
    }

    public abstract String b();

    public void c(AbstractMqttProcess abstractMqttProcess) {
        this.a = abstractMqttProcess;
    }

    public abstract void handler(T t, @Nullable RootActivity rootActivity);

    /* JADX WARN: Multi-variable type inference failed */
    @WithTryCatchRuntime
    public void process(String str, Object obj, RootActivity rootActivity) {
        if (obj == 0 || rootActivity == 0 || rootActivity.isDestroyed() || rootActivity.isFinishing()) {
            return;
        }
        Class<?> b = MgMqttUtils.b(str);
        if (TextUtils.equals(str, b()) && obj.getClass() == b) {
            handler(obj, rootActivity);
            return;
        }
        AbstractMqttProcess abstractMqttProcess = this.a;
        if (abstractMqttProcess != null) {
            abstractMqttProcess.process(str, obj, rootActivity);
        }
    }
}
