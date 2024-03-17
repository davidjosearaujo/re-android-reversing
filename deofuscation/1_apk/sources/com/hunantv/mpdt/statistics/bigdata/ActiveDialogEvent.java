package com.hunantv.mpdt.statistics.bigdata;

import com.hunantv.mpdt.data.ActiveDialogData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.e.e.a;
import j.v.e.a.d.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ActiveDialogEvent {
    private static volatile ActiveDialogEvent a;
    private static final /* synthetic */ c.b b = null;
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;

    static {
        a();
    }

    private ActiveDialogEvent() {
    }

    private static /* synthetic */ void a() {
        e eVar = new e("ActiveDialogEvent.java", ActiveDialogEvent.class);
        b = eVar.H("method-execution", eVar.E("1", "reportPv", "com.hunantv.mpdt.statistics.bigdata.ActiveDialogEvent", "java.lang.String", "bz", "", "void"), 36);
        c = eVar.H("method-execution", eVar.E("1", "reportClick", "com.hunantv.mpdt.statistics.bigdata.ActiveDialogEvent", "java.lang.String", "bz", "", "void"), 46);
        d = eVar.H("method-execution", eVar.E("1", "reportClose", "com.hunantv.mpdt.statistics.bigdata.ActiveDialogEvent", "java.lang.String", "bz", "", "void"), 57);
    }

    public static ActiveDialogEvent b() {
        if (a == null) {
            synchronized (ActiveDialogEvent.class) {
                if (a == null) {
                    a = new ActiveDialogEvent();
                }
            }
        }
        return a;
    }

    public static final /* synthetic */ void c(ActiveDialogEvent activeDialogEvent, String str, c cVar) {
        ActiveDialogData activeDialogData = new ActiveDialogData();
        activeDialogData.bz = str;
        b.f().v("event_follow", activeDialogData.getClickParams().getParamsMap(), (j.v.e.a.d.d.b) null);
    }

    public static final /* synthetic */ void d(ActiveDialogEvent activeDialogEvent, String str, c cVar) {
        ActiveDialogData activeDialogData = new ActiveDialogData();
        activeDialogData.bz = str;
        b.f().v("event_follow", activeDialogData.getCloseParams().getParamsMap(), (j.v.e.a.d.d.b) null);
    }

    public static final /* synthetic */ void e(ActiveDialogEvent activeDialogEvent, String str, c cVar) {
        ActiveDialogData activeDialogData = new ActiveDialogData();
        activeDialogData.bz = str;
        b.f().v("event_follow", activeDialogData.getPvParams().getParamsMap(), (j.v.e.a.d.d.b) null);
    }

    @WithTryCatchRuntime
    public void reportClick(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.e.b(new Object[]{this, str, e.w(c, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportClose(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.e.c(new Object[]{this, str, e.w(d, this, this, str)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportPv(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a(new Object[]{this, str, e.w(b, this, this, str)}).e(69648));
    }
}
