package com.hunantv.mpdt.statistics.flow;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.e.j.d;
import j.l.b.e.j.f;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FlowReportManager {
    private static FlowReportManager g = null;
    private static final int h = 1;
    private static final long i = 300000;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private long a;
    private long b;
    private long c;
    private FlowEvent d;
    private FlowReportConfig e;
    private Handler f = new b();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                FlowReportManager.d().report();
                sendMessageDelayed(obtainMessage(1), FlowReportManager.i);
            }
        }
    }

    static {
        b();
    }

    private FlowReportManager(Context context) {
        this.d = FlowEvent.d(context);
    }

    private static /* synthetic */ void b() {
        e eVar = new e("FlowReportManager.java", FlowReportManager.class);
        j = eVar.H("method-execution", eVar.E("1", "startCount", "com.hunantv.mpdt.statistics.flow.FlowReportManager", "", "", "", "void"), 70);
        k = eVar.H("method-execution", eVar.E("1", "reportYFFlowError", "com.hunantv.mpdt.statistics.flow.FlowReportManager", "int:java.lang.String", "error:est", "", "void"), 94);
        l = eVar.H("method-execution", eVar.E("2", "report", "com.hunantv.mpdt.statistics.flow.FlowReportManager", "", "", "", "void"), 115);
        m = eVar.H("method-execution", eVar.E("2", "reportFlowConsume", "com.hunantv.mpdt.statistics.flow.FlowReportManager", "long:long:long:java.lang.String:java.lang.String", "cflow:pflow:eflow:provider:sdkver", "", "void"), 128);
    }

    private void c() {
        this.b = 0L;
        this.a = 0L;
        this.c = 0L;
    }

    public static FlowReportManager d() {
        if (g == null) {
            synchronized (FlowReportManager.class) {
                if (g == null) {
                    g = new FlowReportManager(j.l.a.a.a());
                }
            }
        }
        return g;
    }

    private void h(long j2, long j3, long j4) {
        this.b += j2;
        this.a += j3;
        this.c += j4;
    }

    public static final /* synthetic */ void j(FlowReportManager flowReportManager, long j2, long j3, long j4, String str, String str2, c cVar) {
        flowReportManager.d.sendConsumeData(j2, j3, j4, str, str2);
        flowReportManager.c();
    }

    public static final /* synthetic */ void k(FlowReportManager flowReportManager, int i2, String str, c cVar) {
        FlowReportConfig flowReportConfig = flowReportManager.e;
        if (flowReportConfig != null) {
            flowReportManager.d.sendErrorData(i2, str, flowReportConfig.provider, flowReportConfig.sdkver);
        }
    }

    public static final /* synthetic */ void l(FlowReportManager flowReportManager, c cVar) {
        FlowReportConfig flowReportConfig = flowReportManager.e;
        if (flowReportConfig != null) {
            flowReportManager.reportFlowConsume(flowReportManager.b, flowReportManager.a, flowReportManager.c, flowReportConfig.provider, flowReportConfig.sdkver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void report() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.j.e(new Object[]{this, e.v(l, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    private void reportFlowConsume(long j2, long j3, long j4, String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, r.a.c.b.e.m(j2), r.a.c.b.e.m(j3), r.a.c.b.e.m(j4), str, str2, e.y(m, this, this, new Object[]{r.a.c.b.e.m(j2), r.a.c.b.e.m(j3), r.a.c.b.e.m(j4), str, str2})}).e(69648));
    }

    public void e(FlowReportConfig flowReportConfig) {
        this.e = flowReportConfig;
        startCount();
    }

    public void f() {
        report();
    }

    public void g() {
        report();
    }

    public void i(long j2, long j3, long j4) {
        h(j2, j3, j4);
    }

    @WithTryCatchRuntime
    public void reportYFFlowError(int i2, String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, r.a.c.b.e.k(i2), str, e.x(k, this, this, r.a.c.b.e.k(i2), str)}).e(69648));
    }

    @WithTryCatchRuntime
    public void startCount() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.j.c(new Object[]{this, e.v(j, this, this)}).e(69648));
    }
}
