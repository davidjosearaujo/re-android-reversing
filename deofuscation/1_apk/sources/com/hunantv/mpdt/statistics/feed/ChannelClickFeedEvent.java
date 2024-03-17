package com.hunantv.mpdt.statistics.feed;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.alipay.sdk.app.statistic.b;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.l;
import j.l.b.d.f;
import j.l.b.e.a;
import j.l.b.e.e.g;
import j.l.b.e.i.d;
import j.l.b.e.i.h;
import j.l.b.e.i.i;
import j.l.b.e.i.j;
import j.l.b.e.i.k;
import java.util.HashMap;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelClickFeedEvent extends a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;

    static {
        c();
    }

    public ChannelClickFeedEvent(Context context) {
        super(context);
    }

    private static /* synthetic */ void c() {
        e eVar = new e("ChannelClickFeedEvent.java", ChannelClickFeedEvent.class);
        e = eVar.H("method-execution", eVar.E("1", "reportFeedVideo", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 39);
        f = eVar.H("method-execution", eVar.E("1", "reportNewsFeedVideo", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 53);
        o = eVar.H("method-execution", eVar.E("1", "report", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "java.util.HashMap", "paramValues", "", "void"), (int) IDrmSession.ERROR_SESSION_PROVISION_NO_SELECT_DRM);
        g = eVar.H("method-execution", eVar.E("1", "reportZFeedVideo", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 68);
        h = eVar.H("method-execution", eVar.E("1", "reportZFFeedBack", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 83);
        i = eVar.H("method-execution", eVar.E("1", "reportUserFeed", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 102);
        j = eVar.H("method-execution", eVar.E("1", "reportFeedBack", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), 118);
        k = eVar.H("method-execution", eVar.E("1", "reportFeedVod", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), (int) EventClickData.u.t1);
        l = eVar.H("method-execution", eVar.E("1", "reportFeedUserLogin", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), (int) Opcodes.DCMPL);
        m = eVar.H("method-execution", eVar.E("1", "reportTopicClick", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "com.hunantv.mpdt.data.ChannelClickFeedEventData", "data", "", "void"), (int) Opcodes.IF_ACMPEQ);
        n = eVar.H("method-execution", eVar.E("a", "createCommonParams", "com.hunantv.mpdt.statistics.feed.ChannelClickFeedEvent", "", "", "", "com.hunantv.imgo.net.RequestParams"), (int) Opcodes.GETSTATIC);
    }

    @WithTryCatchRuntime
    private static RequestParams createCommonParams() {
        return (RequestParams) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.e(new Object[]{e.v(n, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ RequestParams d(c cVar) {
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
        requestParams.put("act", "chfeedclick");
        requestParams.put("rdc", j.l.c.x.t0.a.a().d());
        requestParams.put("rch", j.l.c.x.t0.a.a().c());
        return requestParams;
    }

    public static final /* synthetic */ void e(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("hitoptions", fVar.h);
        createCommonParams.put("hitoptionIds", fVar.i);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("fdmoduletype", fVar.f);
        createCommonParams.put("fdvalue", fVar.g);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void f(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("fdmoduletype", fVar.f);
        createCommonParams.put("fdvalue", fVar.g);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void g(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("hitpreview", fVar.b);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void h(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        createCommonParams.put("hitpreview", fVar.b);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void i(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("hitpreview", fVar.b);
        createCommonParams.put("act", "newsfeedclick");
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c("https://crd.api.mgtv.com/report/user_news_rec", createCommonParams, (g) null);
    }

    public static final /* synthetic */ void j(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("fdmoduleid", fVar.l);
        createCommonParams.put("act", "chtopicclick");
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("fdmoduletype", fVar.f);
        ((a) channelClickFeedEvent).a.c("https://crd.api.mgtv.com/report/topic_rec", createCommonParams, (g) null);
    }

    public static final /* synthetic */ void k(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hittagIds", fVar.e);
        createCommonParams.put("hittags", fVar.d);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("fdmoduletype", fVar.f);
        createCommonParams.put("fdvalue", fVar.g);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void l(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("hitoptions", fVar.h);
        createCommonParams.put("hitoptionIds", fVar.i);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("fdmoduletype", fVar.f);
        createCommonParams.put("fdvalue", fVar.g);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        createCommonParams.put("act", "chfwatchclick");
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void m(ChannelClickFeedEvent channelClickFeedEvent, f fVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("act", "chfwatchclick");
        createCommonParams.put("hitid", fVar.a);
        createCommonParams.put("hitpreview", fVar.b);
        createCommonParams.put("clicktype", fVar.c);
        createCommonParams.put("cid", fVar.j);
        createCommonParams.put("fdparam", TextUtils.isEmpty(fVar.k) ? "" : fVar.k);
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public static final /* synthetic */ void n(ChannelClickFeedEvent channelClickFeedEvent, HashMap hashMap, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            createCommonParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        ((a) channelClickFeedEvent).a.c(channelClickFeedEvent.a(), createCommonParams, (g) null);
    }

    public String a() {
        return "https://crd.api.mgtv.com/report/user_rec";
    }

    @WithTryCatchRuntime
    public void report(HashMap<String, String> hashMap) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.g(new Object[]{this, hashMap, e.w(o, this, this, hashMap)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportFeedBack(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.a(new Object[]{this, fVar, e.w(j, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportFeedUserLogin(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.c(new Object[]{this, fVar, e.w(l, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportFeedVideo(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.f(new Object[]{this, fVar, e.w(e, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportFeedVod(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.i.b(new Object[]{this, fVar, e.w(k, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportNewsFeedVideo(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, fVar, e.w(f, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportTopicClick(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, fVar, e.w(m, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportUserFeed(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, fVar, e.w(i, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportZFFeedBack(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j(new Object[]{this, fVar, e.w(h, this, this, fVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportZFeedVideo(f fVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, fVar, e.w(g, this, this, fVar)}).e(69648));
    }
}
