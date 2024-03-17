package com.hunantv.mpdt.statistics.vip;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.media.drm.IDrmSession;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpCallBack;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.j0;
import j.l.a.b0.l;
import j.l.b.e.s.d;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import java.util.List;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class VipEventHelper {
    private static int a;
    private static final /* synthetic */ c.b b = null;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends HttpCallBack<String> {
        public void success(String str) {
        }

        /* renamed from: u */
        public void previewCache(String str) {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends HttpCallBack<String> {
        public void success(String str) {
        }

        /* renamed from: u */
        public void previewCache(String str) {
        }
    }

    static {
        a();
        a = 0;
    }

    private static /* synthetic */ void a() {
        e eVar = new e("VipEventHelper.java", VipEventHelper.class);
        b = eVar.H("method-execution", eVar.E("9", "promotionViewReport", "com.hunantv.mpdt.statistics.vip.VipEventHelper", "android.content.Context:java.util.List", "ctx:url", "", "void"), (int) IDrmSession.ERROR_SESSION_KEY_REQUEST_NULL);
    }

    @NonNull
    public static final RequestParams b(@NonNull Context context) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("bid", "2.1.1");
        requestParams.put(CrashHianalyticsData.TIME, l.p(System.currentTimeMillis()));
        requestParams.put("did", j.l.a.b0.e.x());
        requestParams.put("oaid", j.l.a.b0.e.U());
        requestParams.put("uuid", j.l.a.b0.e.v0());
        requestParams.put("aver", j.l.a.b0.e.C0());
        requestParams.put("uip", j.l.a.b0.e.D());
        requestParams.put("pix", j0.n(context) + "*" + j0.k(context));
        int c = c();
        requestParams.put("mname", 1 == c ? "cmcc" : 2 == c ? "cucc" : 3 == c ? "ctcc" : "");
        requestParams.put("p2p", j.l.a.k.e.H ? 1 : 0);
        return requestParams;
    }

    private static int c() {
        String F = j.l.a.b0.e.F();
        if (!TextUtils.isEmpty(F)) {
            if (F.startsWith("46000") || F.startsWith("46002") || F.startsWith("46007")) {
                return 1;
            }
            if (F.startsWith("46001") || F.startsWith("46006")) {
                return 2;
            }
            if (F.startsWith("46003") || F.startsWith("46005") || F.startsWith("46011")) {
                return 3;
            }
        }
        return 0;
    }

    public static final /* synthetic */ void d(Context context, List list, c cVar) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            new r(context).n(true).u((String) list.get(i), (HttpParams) null, new b());
        }
    }

    public static void e(@NonNull Context context, String str, int i, String str2) {
        j.l.b.e.s.c.c(context).d(str, i, str2);
    }

    public static void f(@NonNull Context context) {
        if (j.l.b.e.s.b.i()) {
            j.l.b.e.s.c.c(context).e();
        }
    }

    public static void g(@NonNull Context context) {
        if (j.l.b.e.s.b.i()) {
            j.l.b.e.s.c.c(context).j(a);
        }
    }

    public static void h(@NonNull Context context, String str, int i, String str2) {
        j.l.b.e.s.c.c(context).h(str, i, str2);
    }

    public static void i(@NonNull Context context, String str, int i, String str2) {
        j.l.b.e.s.c.c(context).i(str, i, str2);
    }

    public static void j(Context context, String str) {
        m mVar = new m();
        p pVar = new p(context);
        pVar.setCancelable(true);
        pVar.setCanceledOnTouchOutside(false);
        new r(context, mVar, pVar).n(true).u(str, (HttpParams) null, new a());
    }

    public static void k() {
        a = 0;
        j.l.b.e.s.b.j();
    }

    public static void l(int i) {
        a = i;
    }

    @WithTryCatchRuntime
    public static void promotionViewReport(Context context, List<String> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{context, list, e.x(b, (Object) null, (Object) null, context, list)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }
}
