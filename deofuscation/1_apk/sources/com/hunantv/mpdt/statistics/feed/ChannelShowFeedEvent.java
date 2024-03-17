package com.hunantv.mpdt.statistics.feed;

import android.content.Context;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alipay.sdk.app.statistic.b;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.l;
import j.l.b.d.g;
import j.l.b.e.a;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelShowFeedEvent extends a {
    private static final /* synthetic */ c.b e = null;

    static {
        c();
    }

    public ChannelShowFeedEvent(Context context) {
        super(context);
    }

    private static /* synthetic */ void c() {
        e eVar = new e("ChannelShowFeedEvent.java", ChannelShowFeedEvent.class);
        e = eVar.H("method-execution", eVar.E("1", "reportBannerShow", "com.hunantv.mpdt.statistics.feed.ChannelShowFeedEvent", "java.lang.String:java.lang.String", "rcdata:channelId", "", "void"), 61);
    }

    private static RequestParams createCommonParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("did", j.l.a.b0.e.x());
        requestParams.put("oaid", j.l.a.b0.e.U());
        requestParams.put(CommonConstant.KEY_UID, j.l.a.b0.e.v0());
        requestParams.put("uuid", j.l.a.b0.e.v0());
        requestParams.put(CrashHianalyticsData.TIME, l.p(System.currentTimeMillis()));
        requestParams.put(JThirdPlatFormInterface.KEY_PLATFORM, "android");
        requestParams.put("sver", j.l.a.b0.e.Z());
        requestParams.put("aver", j.l.a.b0.e.D0());
        requestParams.put("mod", j.l.a.b0.e.Q());
        requestParams.put("mf", j.l.a.b0.e.P());
        requestParams.put(b.k, j.l.a.s.a.h());
        requestParams.put("ch", j.l.a.b0.e.n());
        requestParams.put("isdebug", 0);
        requestParams.put("patver", j.l.a.b0.e.G0());
        return requestParams;
    }

    private void d(g gVar, String str) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("rcdata", gVar.a);
        createCommonParams.put("act", str);
        createCommonParams.put("cid", gVar.b);
        createCommonParams.put("fdparam", gVar.c);
        ((a) this).a.c(a(), createCommonParams, (j.l.b.e.e.g) null);
    }

    public static final /* synthetic */ void e(ChannelShowFeedEvent channelShowFeedEvent, String str, String str2, c cVar) {
        g gVar = new g();
        gVar.a = str;
        gVar.b = str2;
        channelShowFeedEvent.d(gVar, "chbannershow");
    }

    public String a() {
        return "https://crd.api.mgtv.com/report/user_rec";
    }

    public void f(String str, String str2) {
        g gVar = new g();
        gVar.a = str;
        gVar.b = str2;
        d(gVar, "chfeedshow");
    }

    public void g(String str, String str2) {
        g gVar = new g();
        gVar.a = str;
        gVar.b = str2;
        d(gVar, "chhotshow");
    }

    public void h(String str, String str2) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("act", "newsfeedshow");
        createCommonParams.put("cid", str2);
        createCommonParams.put("rcdata", str);
        ((a) this).a.c("https://crd.api.mgtv.com/report/user_news_rec", createCommonParams, (j.l.b.e.e.g) null);
    }

    public void i(String str, String str2) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("act", "chtopicshow");
        createCommonParams.put("cid", str);
        createCommonParams.put("rcdata", str2);
        ((a) this).a.c("https://crd.api.mgtv.com/report/topic_rec", createCommonParams, (j.l.b.e.e.g) null);
    }

    public void j(String str, String str2, String str3) {
        g gVar = new g();
        gVar.a = str;
        gVar.b = str2;
        gVar.c = str3;
        d(gVar, "chfwatchshow");
    }

    @WithTryCatchRuntime
    public void reportBannerShow(String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.l(new Object[]{this, str, str2, e.x(e, this, this, str, str2)}).e(69648));
    }
}
