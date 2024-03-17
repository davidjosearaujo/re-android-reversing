package com.hunantv.mpdt.statistics.channel;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.gson.JsonObject;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.d.h;
import j.l.b.e.a;
import j.l.b.e.e.g;
import j.l.b.e.g.b;
import j.l.b.e.g.d;
import j.l.b.e.g.f;
import java.net.URLEncoder;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicEvent extends a {
    private static final /* synthetic */ c.b e = null;
    private static final /* synthetic */ c.b f = null;
    private static final /* synthetic */ c.b g = null;
    private static final /* synthetic */ c.b h = null;
    private static final /* synthetic */ c.b i = null;
    private static final /* synthetic */ c.b j = null;

    static {
        c();
    }

    public DynamicEvent(Context context) {
        super(context);
    }

    private static /* synthetic */ void c() {
        e eVar = new e("DynamicEvent.java", DynamicEvent.class);
        e = eVar.H("method-execution", eVar.E("a", "createCommonParams", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "", "", "", "com.hunantv.imgo.net.RequestParams"), 38);
        f = eVar.H("method-execution", eVar.E("1", "reportRequest", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "com.hunantv.mpdt.data.DynamicEventData", "data", "", "void"), 55);
        g = eVar.H("method-execution", eVar.E("1", "reportPageExposure", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "com.hunantv.mpdt.data.DynamicEventData", "data", "", "void"), 76);
        h = eVar.H("method-execution", eVar.E("1", "reportModuleExposure", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "com.hunantv.mpdt.data.DynamicEventData:java.util.Map", "data:external", "", "void"), 112);
        i = eVar.H("method-execution", eVar.E("1", "reportContainerExposure", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "com.hunantv.mpdt.data.DynamicEventData", "data", "", "void"), (int) EventClickData.u.u1);
        j = eVar.H("method-execution", eVar.E("1", "reportClick", "com.hunantv.mpdt.statistics.channel.DynamicEvent", "com.hunantv.mpdt.data.DynamicEventData:java.util.Map", "data:external", "", "void"), (int) Opcodes.IF_ACMPNE);
    }

    @WithTryCatchRuntime
    private static RequestParams createCommonParams() {
        return (RequestParams) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.g.c(new Object[]{e.v(e, (Object) null, (Object) null)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ RequestParams d(c cVar) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("did", j.l.a.b0.e.x());
        requestParams.put("sid", PVSourceEvent.i());
        requestParams.put("uuid", j.l.a.b0.e.v0());
        requestParams.put("termid", "9");
        requestParams.put("src", j.l.a.b0.e.g0());
        requestParams.put("paid", j.l.c.x.t0.a.a().E);
        return requestParams;
    }

    public static final /* synthetic */ void e(DynamicEvent dynamicEvent, h hVar, Map map, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("event", EventClickData.a.s);
        createCommonParams.put("pn", hVar.f);
        createCommonParams.put("mdid", hVar.b);
        createCommonParams.put("pos", hVar.k);
        createCommonParams.put("solt", hVar.l);
        createCommonParams.put("coor", hVar.m);
        createCommonParams.put("abscoor", hVar.n);
        createCommonParams.put("sob", hVar.g);
        createCommonParams.put("action", hVar.o);
        createCommonParams.put("lob", hVar.h);
        createCommonParams.put("spm", hVar.i);
        createCommonParams.put("x-r-id", hVar.e);
        createCommonParams.put("bid", "2.3.21");
        if (map != null) {
            createCommonParams.putAll(map);
        }
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : createCommonParams.getParamsMap().entrySet()) {
            if (("label".equals(entry.getKey()) || "sob".equals(entry.getKey()) || "lob".equals(entry.getKey())) && !TextUtils.isEmpty(entry.getValue())) {
                jsonObject.addProperty(entry.getKey(), URLEncoder.encode(entry.getValue()));
            } else {
                jsonObject.addProperty(entry.getKey(), entry.getValue());
            }
        }
        ((a) dynamicEvent).a.l(dynamicEvent.a(), jsonObject.toString(), (g) null);
    }

    public static final /* synthetic */ void f(DynamicEvent dynamicEvent, h hVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("event", ViewHierarchyConstants.VIEW_KEY);
        createCommonParams.put("pn", hVar.f);
        createCommonParams.put("pullsid", hVar.q);
        createCommonParams.put("lob", hVar.h);
        createCommonParams.put("spm", hVar.i);
        createCommonParams.put("bid", "2.3.20");
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : createCommonParams.getParamsMap().entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        ((a) dynamicEvent).a.l(dynamicEvent.a(), jsonObject.toString(), (g) null);
    }

    public static final /* synthetic */ void g(DynamicEvent dynamicEvent, h hVar, Map map, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("event", ViewHierarchyConstants.VIEW_KEY);
        createCommonParams.put("pn", hVar.f);
        createCommonParams.put("mdid", hVar.b);
        createCommonParams.put("sob", hVar.g);
        createCommonParams.put("lob", hVar.h);
        createCommonParams.put("spm", hVar.i);
        createCommonParams.put("pullsid", hVar.q);
        createCommonParams.put("abscoor", hVar.n);
        createCommonParams.put("x-r-id", hVar.e);
        createCommonParams.put("bid", "2.3.20");
        if (map != null) {
            createCommonParams.putAll(map);
        }
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : createCommonParams.getParamsMap().entrySet()) {
            if (("sob".equals(entry.getKey()) || "lob".equals(entry.getKey())) && !TextUtils.isEmpty(entry.getValue())) {
                jsonObject.addProperty(entry.getKey(), URLEncoder.encode(entry.getValue()));
            } else {
                jsonObject.addProperty(entry.getKey(), entry.getValue());
            }
        }
        ((a) dynamicEvent).a.l(dynamicEvent.a(), jsonObject.toString(), (g) null);
    }

    public static final /* synthetic */ void h(DynamicEvent dynamicEvent, h hVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("event", "page");
        createCommonParams.put("pn", hVar.f);
        createCommonParams.put("fpn", j.l.c.x.t0.a.a().B);
        String str = j.l.c.x.t0.a.a().A;
        if (TextUtils.isEmpty(str) && PVSourceEvent.f1.equals(j.l.c.x.t0.a.a().B)) {
            str = "1";
        }
        createCommonParams.put("fpid", str);
        createCommonParams.put("sob", hVar.g);
        createCommonParams.put("lob", hVar.h);
        createCommonParams.put("spm", hVar.i);
        createCommonParams.put("x-r-id", hVar.e);
        createCommonParams.put("status", hVar.d);
        createCommonParams.put("bid", "2.3.19");
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : createCommonParams.getParamsMap().entrySet()) {
            if (("sob".equals(entry.getKey()) || "lob".equals(entry.getKey())) && !TextUtils.isEmpty(entry.getValue())) {
                jsonObject.addProperty(entry.getKey(), URLEncoder.encode(entry.getValue()));
            } else {
                jsonObject.addProperty(entry.getKey(), entry.getValue());
            }
        }
        ((a) dynamicEvent).a.l(dynamicEvent.a(), jsonObject.toString(), (g) null);
    }

    public static final /* synthetic */ void i(DynamicEvent dynamicEvent, h hVar, c cVar) {
        RequestParams createCommonParams = createCommonParams();
        createCommonParams.put("event", "request");
        createCommonParams.put("url", hVar.a);
        createCommonParams.put("mdid", hVar.b);
        createCommonParams.put("atime", hVar.c);
        createCommonParams.put("status", hVar.d);
        createCommonParams.put("x-r-id", hVar.e);
        createCommonParams.put("bid", "2.3.18");
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, String> entry : createCommonParams.getParamsMap().entrySet()) {
            jsonObject.addProperty(entry.getKey(), entry.getValue());
        }
        ((a) dynamicEvent).a.l(dynamicEvent.a(), jsonObject.toString(), (g) null);
    }

    public String a() {
        return "https://aphone.v1.mgtv.com/dispatcher.do";
    }

    @WithTryCatchRuntime
    public void reportClick(h hVar, Map<String, String> map) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, hVar, map, e.x(j, this, this, hVar, map)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportContainerExposure(h hVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.g.g(new Object[]{this, hVar, e.w(i, this, this, hVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportModuleExposure(h hVar, Map<String, String> map) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, hVar, map, e.x(h, this, this, hVar, map)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportPageExposure(h hVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.g.e(new Object[]{this, hVar, e.w(g, this, this, hVar)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportRequest(h hVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, hVar, e.w(f, this, this, hVar)}).e(69648));
    }
}
