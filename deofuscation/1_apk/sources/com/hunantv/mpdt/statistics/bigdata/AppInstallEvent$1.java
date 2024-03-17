package com.hunantv.mpdt.statistics.bigdata;

import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.f0;
import j.l.b.e.e.g;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AppInstallEvent$1 implements Runnable {
    private static final /* synthetic */ c.b b = null;
    public final /* synthetic */ AppInstallEvent a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends g {
        public a() {
        }

        public void e(int i, int i2, String str, Throwable th) {
        }

        public void f() {
            super.f();
        }

        public void h(String str) {
            f0.o("pref_key_install", true);
            super.h(str);
        }
    }

    static {
        a();
    }

    public AppInstallEvent$1(AppInstallEvent appInstallEvent) {
        this.a = appInstallEvent;
    }

    private static /* synthetic */ void a() {
        e eVar = new e("AppInstallEvent.java", AppInstallEvent$1.class);
        b = eVar.H("method-execution", eVar.E("1", "run", "com.hunantv.mpdt.statistics.bigdata.AppInstallEvent$1", "", "", "", "void"), 53);
    }

    @Override // java.lang.Runnable
    @WithTryCatchRuntime
    public void run() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.e.e(new Object[]{this, e.v(b, this, this)}).e(69648));
    }
}
