package com.hunantv.oversea.channel.dynamic.render.collect;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.u1.v.b;
import j.l.c.c.c.u1.v.d;
import java.util.HashMap;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CollectReportHelper {
    public static Map<String, Boolean> a;
    private static final /* synthetic */ c.b b = null;
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;

    static {
        a();
        a = new HashMap();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("CollectReportHelper.java", CollectReportHelper.class);
        b = eVar.H("method-execution", eVar.E("9", "putExposure", "com.hunantv.oversea.channel.dynamic.render.collect.CollectReportHelper", "java.lang.String:boolean", "key:isExposure", "", "void"), 22);
        c = eVar.H("method-execution", eVar.E("9", "getExposure", "com.hunantv.oversea.channel.dynamic.render.collect.CollectReportHelper", "java.lang.String", SDKConstants.PARAM_KEY, "", "boolean"), 30);
        d = eVar.H("method-execution", eVar.E("9", "clearExposure", "com.hunantv.oversea.channel.dynamic.render.collect.CollectReportHelper", "", "", "", "void"), 42);
    }

    public static final /* synthetic */ boolean c(String str, c cVar) {
        Boolean bool = a.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WithTryCatchRuntime
    public static void clearExposure() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{e.v(d, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    @WithTryCatchRuntime
    public static boolean getExposure(String str) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.u1.v.c(new Object[]{str, e.w(c, (Object) null, (Object) null, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }

    @WithTryCatchRuntime
    public static void putExposure(String str, boolean z) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{str, r.a.c.b.e.a(z), e.x(b, (Object) null, (Object) null, str, r.a.c.b.e.a(z))}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
