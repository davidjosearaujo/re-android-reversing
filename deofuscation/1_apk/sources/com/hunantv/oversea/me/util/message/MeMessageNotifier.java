package com.hunantv.oversea.me.util.message;

import com.hunantv.oversea.me.data.MeReddotEntity;
import com.hunantv.oversea.me.mqtt.MeReddotProcess;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.j;
import j.l.c.k.i.b;
import j.l.c.k.m.p.d;
import j.l.c.k.m.p.f;
import java.util.HashSet;
import java.util.Set;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MeMessageNotifier implements f.e, b {
    private static final MeMessageNotifier e;
    private static final /* synthetic */ c.b f = null;
    private int b;
    private int c;
    private Set<j.l.c.l.f.b> d = new HashSet();
    private final MeReddotProcess a = new MeReddotProcess(null, this);

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface a {
        void a(int i);
    }

    static {
        d();
        e = new MeMessageNotifier();
    }

    private MeMessageNotifier() {
    }

    private static /* synthetic */ void d() {
        e eVar = new e("MeMessageNotifier.java", MeMessageNotifier.class);
        f = eVar.H("method-execution", eVar.E("22", "notifyUnReadMessage", "com.hunantv.oversea.me.util.message.MeMessageNotifier", "", "", "", "void"), 58);
    }

    public static MeMessageNotifier e() {
        return e;
    }

    public static final /* synthetic */ void g(MeMessageNotifier meMessageNotifier, c cVar) {
        if (j.a(meMessageNotifier.d)) {
            return;
        }
        for (j.l.c.l.f.b bVar : meMessageNotifier.d) {
            j.l.c.l.f.a aVar = new j.l.c.l.f.a();
            aVar.a = meMessageNotifier.f();
            bVar.a(aVar);
        }
    }

    @WithTryCatchRuntime
    private synchronized void notifyUnReadMessage() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, e.v(f, this, this)}).e(69648));
    }

    public void a(MeReddotEntity meReddotEntity) {
        MeReddotEntity.Data data;
        if (meReddotEntity == null || (data = meReddotEntity.data) == null) {
            return;
        }
        this.b = data.total;
        notifyUnReadMessage();
    }

    public void b(int i) {
        this.c = i;
        notifyUnReadMessage();
    }

    public synchronized void c(j.l.c.l.f.b bVar) {
        this.d.add(bVar);
    }

    public int f() {
        return this.b + this.c;
    }

    public synchronized void h(j.l.c.l.f.b bVar) {
        this.d.remove(bVar);
    }
}
