package com.hunantv.oversea.me.mqtt;

import androidx.annotation.Nullable;
import com.hunantv.imgo.base.RootActivity;
import com.hunantv.oversea.me.data.MeReddotEntity;
import com.hunantv.oversea.mgtv.mgmqtt.MgMqttUtils;
import com.hunantv.oversea.mgtv.mqtt.AbstractMqttProcess;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.k.i.a;
import j.l.c.k.i.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeReddotProcess extends AbstractMqttProcess<MeReddotEntity> {
    private static final /* synthetic */ c.b c = null;
    private b b;

    static {
        d();
    }

    public MeReddotProcess(AbstractMqttProcess abstractMqttProcess) {
        super(abstractMqttProcess);
    }

    private static /* synthetic */ void d() {
        e eVar = new e("MeReddotProcess.java", MeReddotProcess.class);
        c = eVar.H("method-execution", eVar.E("1", "handler", "com.hunantv.oversea.me.mqtt.MeReddotProcess", "com.hunantv.oversea.me.data.MeReddotEntity:com.hunantv.imgo.base.RootActivity", "entity:activity", "", "void"), 32);
    }

    public static final /* synthetic */ void e(MeReddotProcess meReddotProcess, MeReddotEntity meReddotEntity, RootActivity rootActivity, c cVar) {
        b bVar;
        if (meReddotEntity == null || meReddotEntity.data == null || (bVar = meReddotProcess.b) == null) {
            return;
        }
        bVar.a(meReddotEntity);
    }

    @Override // com.hunantv.oversea.mgtv.mqtt.AbstractMqttProcess
    public String b() {
        return MgMqttUtils.e;
    }

    public MeReddotProcess(AbstractMqttProcess abstractMqttProcess, b bVar) {
        super(abstractMqttProcess);
        this.b = bVar;
    }

    @Override // com.hunantv.oversea.mgtv.mqtt.AbstractMqttProcess
    @WithTryCatchRuntime
    public void handler(MeReddotEntity meReddotEntity, @Nullable RootActivity rootActivity) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{this, meReddotEntity, rootActivity, e.x(c, this, this, meReddotEntity, rootActivity)}).e(69648));
    }
}
