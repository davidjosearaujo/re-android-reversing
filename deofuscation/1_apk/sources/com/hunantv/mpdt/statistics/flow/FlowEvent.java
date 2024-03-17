package com.hunantv.mpdt.statistics.flow;

import android.content.Context;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.e.a;
import j.l.b.e.j.b;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FlowEvent extends a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;

    static {
        c();
    }

    private FlowEvent(Context context) {
        super(context);
    }

    private static /* synthetic */ void c() {
        e eVar = new e("FlowEvent.java", FlowEvent.class);
        e = eVar.H("method-execution", eVar.E("1", "sendConsumeData", "com.hunantv.mpdt.statistics.flow.FlowEvent", "long:long:long:java.lang.String:java.lang.String", "cflow:pflow:eflow:provider:sdkver", "", "void"), 36);
        f = eVar.H("method-execution", eVar.E("1", "sendErrorData", "com.hunantv.mpdt.statistics.flow.FlowEvent", "int:java.lang.String:java.lang.String:java.lang.String", "error:est:provider:sdkver", "", "void"), 58);
    }

    public static FlowEvent d(Context context) {
        return new FlowEvent(context);
    }

    public static final /* synthetic */ void e(FlowEvent flowEvent, long j, long j2, long j3, String str, String str2, c cVar) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("logType", "hb");
        requestParams.put("bid", "2.7.1");
        requestParams.put("tflow", String.valueOf(j + j2 + j3));
        requestParams.put("cflow", String.valueOf(j));
        requestParams.put("eflow", String.valueOf(j3));
        requestParams.put("pflow", String.valueOf(j2));
        requestParams.put("sdkver", str2);
        requestParams.put("provider", str);
        ((a) flowEvent).a.b("https://moblie-ex.log.mgtv.com/edge.php", requestParams);
    }

    public static final /* synthetic */ void f(FlowEvent flowEvent, int i, String str, String str2, String str3, c cVar) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("logType", "error");
        requestParams.put("bid", "2.7.2");
        requestParams.put(JThirdPlatFormInterface.KEY_CODE, String.valueOf(i));
        requestParams.put("est", str);
        requestParams.put("sdkver", str3);
        requestParams.put("provider", str2);
        requestParams.put("patver", j.l.a.b0.e.G0());
        ((a) flowEvent).a.b("https://moblie-ex.log.mgtv.com/edge.php", requestParams);
    }

    public String a() {
        return "https://moblie-ex.log.mgtv.com/edge.php";
    }

    @WithTryCatchRuntime
    public void sendConsumeData(long j, long j2, long j3, String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.j.a(new Object[]{this, r.a.c.b.e.m(j), r.a.c.b.e.m(j2), r.a.c.b.e.m(j3), str, str2, e.y(e, this, this, new Object[]{r.a.c.b.e.m(j), r.a.c.b.e.m(j2), r.a.c.b.e.m(j3), str, str2})}).e(69648));
    }

    @WithTryCatchRuntime
    public void sendErrorData(int i, String str, String str2, String str3) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, r.a.c.b.e.k(i), str, str2, str3, e.y(f, this, this, new Object[]{r.a.c.b.e.k(i), str, str2, str3})}).e(69648));
    }
}
