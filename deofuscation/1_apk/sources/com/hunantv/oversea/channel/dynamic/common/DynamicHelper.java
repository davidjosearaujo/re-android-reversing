package com.hunantv.oversea.channel.dynamic.common;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.c.c.c.m1.f;
import j.v.g.i.d;
import java.util.ArrayList;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicHelper {
    public static final String a = "1000";
    private static final /* synthetic */ c.b b = null;

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("DynamicHelper.java", DynamicHelper.class);
        b = eVar.H("method-execution", eVar.E("9", "isAdBanner", "com.hunantv.oversea.channel.dynamic.common.DynamicHelper", "com.mgtv.dynamicview.model.DynamicViewStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "boolean"), 29);
    }

    public static final /* synthetic */ boolean b(d dVar, c cVar) {
        if (dVar == null) {
            return false;
        }
        if (TextUtils.equals(dVar.d, "ADBanner")) {
            return true;
        }
        ArrayList<d> arrayList = dVar.g;
        if (arrayList != null) {
            for (d dVar2 : arrayList) {
                if (isAdBanner(dVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (TextUtils.equals(dVar.d, "AutoPlayView")) {
            return true;
        }
        ArrayList<d> arrayList = dVar.g;
        if (arrayList != null) {
            for (d dVar2 : arrayList) {
                if (c(dVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (TextUtils.equals(dVar.d, "SquareADBanner")) {
            return true;
        }
        ArrayList<d> arrayList = dVar.g;
        if (arrayList != null) {
            for (d dVar2 : arrayList) {
                if (d(dVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @WithTryCatchRuntime
    public static boolean isAdBanner(d dVar) {
        return r.a.c.b.e.b(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{dVar, e.w(b, (Object) null, (Object) null, dVar)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)));
    }
}
