package com.hunantv.oversea.channel.dynamic.report;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.huawei.hms.framework.common.ContainerUtils;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.mpdt.data.ExposureData;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import com.hunantv.oversea.report.MGDCManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpTraceObject;
import j.l.a.a;
import j.l.a.b0.j;
import j.l.a.b0.j0;
import j.l.a.b0.n0;
import j.l.a.b0.v;
import j.l.c.c.b;
import j.l.c.c.c.v1.f;
import j.l.c.c.c.v1.g;
import j.l.c.c.c.v1.h;
import j.v.g.d.b;
import j.v.g.d.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import q.b0;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicReportExecutor {
    private static final String j = "DynamicReportExecutor";
    private static final /* synthetic */ c.b k = null;
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
    private String a;
    private String b;
    private h c = new h();
    private AtomicBoolean d = new AtomicBoolean(false);
    private HashSet<String> e = new HashSet<>();
    private Set<String> f = Collections.synchronizedSet(new HashSet());
    private ConcurrentHashMap<String, JsonObject> g = new ConcurrentHashMap<>();
    private int h = 0;
    private String i;

    static {
        f();
    }

    public DynamicReportExecutor(String str) {
        this.a = str;
    }

    private static /* synthetic */ void f() {
        e eVar = new e("DynamicReportExecutor.java", DynamicReportExecutor.class);
        k = eVar.H("method-execution", eVar.E("1", "reportModuleExposure", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "[I:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean:androidx.recyclerview.widget.RecyclerView", "location:data:recyclerView", "", "void"), 125);
        l = eVar.H("method-execution", eVar.E("1", "reportClick", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "android.view.View:com.mgtv.dynamicview.action.ClickAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean:androidx.recyclerview.widget.RecyclerView", "clickView:action:dslBean:recyclerView", "", "void"), (int) EventClickData.u.C1);
        m = eVar.H("method-execution", eVar.E("1", "reportFeedBackClick", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "android.view.View:com.mgtv.dynamicview.action.ClickAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean:java.lang.String", "clickView:action:dslBean:type", "", "void"), (int) IDrmSession.ERROR_SESSION_DRM_PSSHS_NOT_SUPPORT);
        n = eVar.H("method-execution", eVar.E("1", "putContainerExposure", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "com.mgtv.dynamicview.action.RendAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "action:dslBean", "", "void"), 250);
        o = eVar.H("method-execution", eVar.E("1", "executeContainerExposure", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "", "", "", "void"), 322);
        p = eVar.H("method-execution", eVar.E("2", "getSafetyJsonElement", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor", "com.mgtv.dynamicview.action.BaseAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "action:dslBean", "", "com.google.gson.JsonElement"), 415);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<String, Map<String, Object>> g(String str, JsonObject jsonObject) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Map.Entry entry : jsonObject.entrySet()) {
            String str2 = (String) entry.getKey();
            String asString = ((JsonElement) entry.getValue()).getAsString();
            if (i > 0) {
                sb.append("&");
            }
            sb.append(str2);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (!TextUtils.isEmpty(asString)) {
                sb.append(URLEncoder.encode(asString));
            }
            i++;
            hashMap.put(str2, asString);
        }
        v.p(j, "handleContainerExposure , index = " + str + ", param = " + sb.toString());
        return new Pair<>(sb.toString(), hashMap);
    }

    @WithTryCatchRuntime
    private JsonElement getSafetyJsonElement(b bVar, ModuleData.DataBean.DSLBean dSLBean) {
        return (JsonElement) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v1.b(new Object[]{this, bVar, dSLBean, e.x(p, this, this, bVar, dSLBean)}).e(69648));
    }

    public static final /* synthetic */ void i(DynamicReportExecutor dynamicReportExecutor, c cVar) {
        if (j.b(dynamicReportExecutor.g) || dynamicReportExecutor.d.get()) {
            return;
        }
        dynamicReportExecutor.d.set(true);
        final HashMap hashMap = new HashMap(dynamicReportExecutor.g);
        final String p2 = n0.p(dynamicReportExecutor.b);
        dynamicReportExecutor.g.clear();
        ThreadManager.getCommonExecutorService().execute(new Runnable() { // from class: com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor.1
            private static final /* synthetic */ c.b d = null;

            static {
                a();
            }

            private static /* synthetic */ void a() {
                e eVar = new e("DynamicReportExecutor.java", AnonymousClass1.class);
                d = eVar.H("method-execution", eVar.E("1", "run", "com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor$1", "", "", "", "void"), 337);
            }

            public static final /* synthetic */ void b(AnonymousClass1 anonymousClass1, c cVar2) {
                if (hashMap.isEmpty()) {
                    return;
                }
                int i = -1;
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                Set<Map.Entry> entrySet = hashMap.entrySet();
                for (Map.Entry entry : entrySet) {
                    i++;
                    if (entry.getValue() != null) {
                        Pair g = DynamicReportExecutor.this.g((String) entry.getKey(), (JsonObject) entry.getValue());
                        if (!TextUtils.isEmpty((CharSequence) g.first)) {
                            sb.append((String) g.first);
                            if (i >= 0 && i < entrySet.size() - 1) {
                                sb.append(",");
                            } else if (i == entrySet.size() - 1) {
                                sb.append(String.format("&depth=%1$s", Integer.valueOf(j0.x(a.a(), DynamicReportExecutor.this.h))));
                            }
                        }
                        Object obj = g.second;
                        if (obj != null && !((Map) obj).isEmpty()) {
                            arrayList.add((Map) g.second);
                        }
                    }
                }
                if (DynamicReportExecutor.this.c != null) {
                    DynamicReportExecutor.this.c.b(DynamicReportExecutor.this.a, p2, sb.toString());
                }
                DynamicReportExecutor.this.d.set(false);
                v.p(DynamicReportExecutor.j, "executeContainerExposure: " + sb.toString());
                MGDCManager.n().postEvents(ExposureData.ACT_EXPOSURE, arrayList);
            }

            @Override // java.lang.Runnable
            @WithTryCatchRuntime
            public void run() {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v1.a(new Object[]{this, e.v(d, this, this)}).e(69648));
            }
        });
    }

    public static final /* synthetic */ JsonElement l(DynamicReportExecutor dynamicReportExecutor, b bVar, ModuleData.DataBean.DSLBean dSLBean, c cVar) {
        int i;
        JsonElement jsonElement = bVar == null ? null : bVar.c;
        if (jsonElement == null) {
            if (bVar != null && (i = bVar.b) >= 0) {
                return dSLBean.getItem(i);
            }
            return dSLBean.data;
        }
        return jsonElement;
    }

    public static final /* synthetic */ void m(DynamicReportExecutor dynamicReportExecutor, j.v.g.d.e eVar, ModuleData.DataBean.DSLBean dSLBean, c cVar) {
        if (TextUtils.isEmpty(dynamicReportExecutor.b) || eVar == null || dSLBean == null || ModuleData.DSL_ID_INSERT_AD.equals(dSLBean.DSLID)) {
            return;
        }
        String j2 = dynamicReportExecutor.j(eVar, dSLBean);
        if (dynamicReportExecutor.f.contains(j2)) {
            return;
        }
        JsonElement jsonElement = ((b) eVar).c;
        if (jsonElement instanceof JsonObject) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("isExposure");
            if ((jsonElement2 instanceof JsonPrimitive) && jsonElement2.getAsBoolean() && dynamicReportExecutor.f.contains(j2)) {
                return;
            }
            asJsonObject.addProperty("isExposure", Boolean.TRUE);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mdid", n0.n(dSLBean.moduleEntityId));
        hashMap.put("x-r-id", n0.n(dSLBean.traceId));
        hashMap.put("pos", String.valueOf(((b) eVar).a + 1));
        ParamParser paramParser = new ParamParser(eVar.d, dynamicReportExecutor.getSafetyJsonElement(eVar, dSLBean));
        hashMap.putAll(paramParser.g());
        v.p(j, "handleContainerExposure: dslParam=" + paramParser.f());
        if (!TextUtils.isEmpty(dSLBean.report)) {
            ParamParser paramParser2 = new ParamParser(dSLBean.report, null);
            hashMap.putAll(paramParser2.g());
            v.p(j, "handleContainerExposure: indexParam=" + paramParser2.f());
        }
        if (!TextUtils.isEmpty(dynamicReportExecutor.i)) {
            String str = (String) hashMap.get("sob");
            if (TextUtils.isEmpty(str)) {
                hashMap.put("sob", dynamicReportExecutor.i);
            } else {
                hashMap.put("sob", dynamicReportExecutor.i.concat("&").concat(str));
            }
        }
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        dynamicReportExecutor.f.add(j2);
        v.p(j, "handleContainerExposure , index=" + j2 + " ,param=" + jsonObject.toString());
        dynamicReportExecutor.g.put(j2, jsonObject);
    }

    public static final /* synthetic */ void n(DynamicReportExecutor dynamicReportExecutor, View view, d dVar, ModuleData.DataBean.DSLBean dSLBean, RecyclerView recyclerView, c cVar) {
        if (view == null || dVar == null || TextUtils.isEmpty(dVar.f) || dSLBean == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        String format = String.format("%1$s,%2$s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        int i = iArr[1];
        if (recyclerView != null) {
            i += recyclerView.computeVerticalScrollOffset();
        }
        String format2 = String.format("%1$s,%2$s", Integer.valueOf(iArr[0]), Integer.valueOf(i));
        ParamParser paramParser = new ParamParser(dVar.f, dynamicReportExecutor.getSafetyJsonElement(dVar, dSLBean));
        Map<String, String> g = paramParser.g();
        v.p(j, "reportClick: dslParam=" + paramParser.f());
        if (!TextUtils.isEmpty(dSLBean.report)) {
            ParamParser paramParser2 = new ParamParser(dSLBean.report, null);
            g.putAll(paramParser2.g());
            v.p(j, "reportClick: indexParam=" + paramParser2.f());
        }
        j.v.g.i.d dVar2 = (j.v.g.i.d) view.getTag(b.j.dsl_tag_style);
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.j)) {
            ParamParser paramParser3 = new ParamParser(dVar2.j, null);
            g.putAll(paramParser3.g());
            v.p(j, "reportClick: external=" + paramParser3.f());
        }
        if ("ONLY_REPORT".equals(dVar.d)) {
            dVar.d = "";
        }
        g.put("pos", String.valueOf(((j.v.g.d.b) dVar).a + 1));
        h hVar = dynamicReportExecutor.c;
        if (hVar != null) {
            hVar.a(dynamicReportExecutor.a, dSLBean.moduleEntityId, format2, format, dVar.d, dSLBean.traceId, g);
        }
        g.put("mdid", dSLBean.moduleEntityId);
        MGDCManager.n().postEvent(EventClickData.a.s, new HashMap(g));
    }

    public static final /* synthetic */ void o(DynamicReportExecutor dynamicReportExecutor, View view, d dVar, ModuleData.DataBean.DSLBean dSLBean, String str, c cVar) {
        if (view == null || dVar == null || dSLBean == null || TextUtils.isEmpty(str)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        String format = String.format("%1$s,%2$s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        int b = iArr[1] - j0.b(a.a(), 100.0f);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(iArr[0]);
        objArr[1] = Integer.valueOf(b >= 0 ? b : 0);
        String format2 = String.format("%1$s,%2$s", objArr);
        ParamParser paramParser = new ParamParser(dVar.f, dynamicReportExecutor.getSafetyJsonElement(dVar, dSLBean));
        Map<String, String> g = paramParser.g();
        v.p(j, "reportFeedBackClick: dslParam=" + paramParser.f());
        if (!TextUtils.isEmpty(dSLBean.report)) {
            ParamParser paramParser2 = new ParamParser(dSLBean.report, null);
            g.putAll(paramParser2.g());
            v.p(j, "reportFeedBackClick: indexParam=" + paramParser2.f());
        }
        j.v.g.i.d dVar2 = (j.v.g.i.d) view.getTag(b.j.dsl_tag_style);
        if (dVar2 != null && !TextUtils.isEmpty(dVar2.j)) {
            ParamParser paramParser3 = new ParamParser(dVar2.j, null);
            g.putAll(paramParser3.g());
            v.p(j, "reportFeedBackClick: external=" + paramParser3.f());
        }
        g.put("pos", String.valueOf(((j.v.g.d.b) dVar).a + 1));
        g.put("lob", "fbcont=" + URLEncoder.encode(str));
        h hVar = dynamicReportExecutor.c;
        if (hVar != null) {
            hVar.a(dynamicReportExecutor.a, dSLBean.moduleEntityId, format2, format, dVar.d, dSLBean.traceId, g);
        }
    }

    public static final /* synthetic */ void p(DynamicReportExecutor dynamicReportExecutor, int[] iArr, ModuleData.DataBean.DSLBean dSLBean, RecyclerView recyclerView, c cVar) {
        if (TextUtils.isEmpty(dynamicReportExecutor.b) || iArr == null || iArr.length != 2 || dSLBean == null || dynamicReportExecutor.e.contains(dSLBean.moduleEntityId)) {
            return;
        }
        dynamicReportExecutor.e.add(dSLBean.moduleEntityId);
        int i = iArr[1];
        if (recyclerView != null) {
            i += recyclerView.computeVerticalScrollOffset();
        }
        String format = String.format("%1$s,%2$s", Integer.valueOf(iArr[0]), Integer.valueOf(i));
        Map<String, String> g = new ParamParser(dSLBean.report, null).g();
        g.put("lob", String.format("depth=%1$s", Integer.valueOf(j0.x(a.a(), dynamicReportExecutor.h))));
        h hVar = dynamicReportExecutor.c;
        if (hVar != null) {
            hVar.c(dynamicReportExecutor.a, dSLBean.moduleEntityId, format, dSLBean.traceId, dynamicReportExecutor.b, g);
            v.p(j, "reportModuleExposure: moduleId=" + dSLBean.moduleEntityId + ", abscoor=" + format + " ,traceId=" + dSLBean.traceId + " ,external=" + g.toString());
        }
    }

    @WithTryCatchRuntime
    public void executeContainerExposure() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, e.v(o, this, this)}).e(69648));
    }

    public void h() {
        this.e.clear();
        this.f.clear();
    }

    public String j(j.v.g.d.e eVar, ModuleData.DataBean.DSLBean dSLBean) {
        StringBuilder sb = new StringBuilder();
        sb.append(((j.v.g.d.b) eVar).a);
        if (((j.v.g.d.b) eVar).b >= 0) {
            sb.append('-');
            sb.append(((j.v.g.d.b) eVar).b);
            if (eVar instanceof j.l.c.c.c.t1.c) {
                j.l.c.c.c.t1.c cVar = (j.l.c.c.c.t1.c) eVar;
                if (cVar.e >= 0) {
                    sb.append('-');
                    sb.append(cVar.e);
                }
            }
        }
        sb.append("-");
        sb.append(dSLBean.hashCode());
        if (!TextUtils.isEmpty(eVar.d)) {
            sb.append('-');
            sb.append(eVar.d.hashCode());
        }
        return sb.toString();
    }

    public int k() {
        return this.h;
    }

    @WithTryCatchRuntime
    public void putContainerExposure(j.v.g.d.e eVar, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, eVar, dSLBean, e.x(n, this, this, eVar, dSLBean)}).e(69648));
    }

    public void q(HttpTraceObject httpTraceObject, String str) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.d(httpTraceObject, str);
        }
    }

    public void r(HttpTraceObject httpTraceObject, String str, long j2) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.e(httpTraceObject, str, j2);
        }
    }

    @WithTryCatchRuntime
    public void reportClick(View view, d dVar, ModuleData.DataBean.DSLBean dSLBean, RecyclerView recyclerView) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v1.d(new Object[]{this, view, dVar, dSLBean, recyclerView, e.y(l, this, this, new Object[]{view, dVar, dSLBean, recyclerView})}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportFeedBackClick(View view, d dVar, ModuleData.DataBean.DSLBean dSLBean, String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v1.e(new Object[]{this, view, dVar, dSLBean, str, e.y(m, this, this, new Object[]{view, dVar, dSLBean, str})}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportModuleExposure(int[] iArr, ModuleData.DataBean.DSLBean dSLBean, RecyclerView recyclerView) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.v1.c(new Object[]{this, iArr, dSLBean, recyclerView, e.y(k, this, this, new Object[]{iArr, dSLBean, recyclerView})}).e(69648));
    }

    public void s(int i) {
        this.h = i;
    }

    public void t(HttpTraceObject httpTraceObject) {
        b0 b0Var;
        if (httpTraceObject == null || (b0Var = httpTraceObject.finalRequest) == null) {
            return;
        }
        this.b = b0Var.c("x-r-i");
    }

    public void u(String str) {
        this.i = str;
    }
}
