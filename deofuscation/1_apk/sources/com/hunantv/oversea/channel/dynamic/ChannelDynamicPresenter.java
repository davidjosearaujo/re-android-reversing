package com.hunantv.oversea.channel.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.hunantv.imgo.entity.JsonEntity;
import com.hunantv.imgo.net.ImgoHttpCallBack;
import com.hunantv.imgo.net.ImgoHttpParams;
import com.hunantv.imgo.util.ThreadManager;
import com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger;
import com.hunantv.oversea.channel.dynamic.data.ChannelFeedbackEntity;
import com.hunantv.oversea.channel.dynamic.data.DynamicData;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.hunantv.oversea.channel.dynamic.data.ParamParser;
import com.hunantv.oversea.channel.dynamic.render.ad.BaseAdsListener;
import com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdEntity;
import com.hunantv.oversea.channel.dynamic.render.ad.DynamicAdPresenter;
import com.hunantv.oversea.channel.dynamic.render.collect.CollectReportHelper;
import com.hunantv.oversea.channel.dynamic.render.collect.VideoCollectPresenter;
import com.hunantv.oversea.channel.dynamic.report.DynamicReportExecutor;
import com.hunantv.oversea.channel.net.entity.ChannelIndexEntity;
import com.mgmi.ads.api.AdWidgetInfoImp;
import com.mgmi.ads.api.AdsListener;
import com.mgmi.ads.api.AwayAppType;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import com.mgtv.task.http.HttpParams;
import com.mgtv.task.http.HttpResponseObject;
import j.l.a.b0.c0;
import j.l.a.b0.j;
import j.l.a.b0.j0;
import j.l.a.b0.n0;
import j.l.a.b0.o0;
import j.l.a.b0.v;
import j.l.b.d.o;
import j.l.c.c.b;
import j.l.c.c.c.a1;
import j.l.c.c.c.b1;
import j.l.c.c.c.c1;
import j.l.c.c.c.d1;
import j.l.c.c.c.e1;
import j.l.c.c.c.f1;
import j.l.c.c.c.g1;
import j.l.c.c.c.h1;
import j.l.c.c.c.i1;
import j.l.c.c.c.l1.a.a;
import j.l.c.c.c.m1.g;
import j.l.c.c.c.r0;
import j.l.c.c.c.s0;
import j.l.c.c.c.t0;
import j.l.c.c.c.u0;
import j.l.c.c.c.v0;
import j.l.c.c.c.w0;
import j.l.c.c.c.x0;
import j.l.c.c.c.z0;
import j.s.j.y0;
import j.v.r.m;
import j.v.r.p;
import j.v.r.r;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelDynamicPresenter {
    private static final /* synthetic */ c.b A = null;
    private static final /* synthetic */ c.b B = null;
    private static final /* synthetic */ c.b C = null;
    private static final /* synthetic */ c.b D = null;
    private static final /* synthetic */ c.b E = null;
    private static final /* synthetic */ c.b F = null;
    private static final /* synthetic */ c.b G = null;
    private static final String n = "ChannelDynamicPresenter";
    public static final String o = "ChannelDynamicEntity is null";
    public static final String p = "GetChannelDynamic failed";
    private static final /* synthetic */ c.b q = null;
    private static final /* synthetic */ c.b r = null;
    private static final /* synthetic */ c.b s = null;
    private static final /* synthetic */ c.b t = null;
    private static final /* synthetic */ c.b u = null;
    private static final /* synthetic */ c.b v = null;
    private static final /* synthetic */ c.b w = null;
    private static final /* synthetic */ c.b x = null;
    private static final /* synthetic */ c.b y = null;
    private static final /* synthetic */ c.b z = null;
    public String a;
    private String b;
    public g f;
    public j.l.c.c.d.e g;
    public r h;
    public DynamicData i;
    public DynamicReportExecutor j;
    private j.l.c.c.c.l1.a.a k;
    private DynamicAdPresenter m;
    public final AtomicInteger c = new AtomicInteger(0);
    public AtomicBoolean d = new AtomicBoolean(false);
    public AtomicBoolean e = new AtomicBoolean(false);
    private Map<String, Integer> l = new ConcurrentHashMap();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a extends j.l.c.c.c.q1.a<ModuleData> {
        public String f = "";
        public List<ModuleData.ModuleIDSBean> g = null;

        public a() {
        }

        /* renamed from: x */
        public void failed(@Nullable ModuleData moduleData, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.failed(moduleData, i, i2, str, th);
            ChannelDynamicPresenter channelDynamicPresenter = ChannelDynamicPresenter.this;
            channelDynamicPresenter.M(i, i2, channelDynamicPresenter.S(th), r().getFinalUrl(), ChannelDynamicPresenter.p);
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null && gVar.l0()) {
                ChannelDynamicPresenter channelDynamicPresenter2 = ChannelDynamicPresenter.this;
                channelDynamicPresenter2.L(i, i2, channelDynamicPresenter2.S(th), r().getFinalUrl(), ChannelDynamicPresenter.p);
            }
            g gVar2 = ChannelDynamicPresenter.this.f;
            if (gVar2 != null) {
                gVar2.j(2, false);
            }
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first data failed");
        }

        /* renamed from: y */
        public void previewCache(ModuleData moduleData) {
        }

        /* renamed from: z */
        public void success(ModuleData moduleData) {
            if (r() != null && !TextUtils.isEmpty(r().getFinalUrl())) {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first data success[Http]");
                j.l.c.c.c.o1.r.e(ChannelDynamicPresenter.this.a, moduleData);
            } else {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first data success[Memory]");
            }
            DynamicReportExecutor dynamicReportExecutor = ChannelDynamicPresenter.this.j;
            if (dynamicReportExecutor != null) {
                dynamicReportExecutor.t(r());
            }
            if (!j.a(moduleData.data)) {
                moduleData.parseTraceId(r());
                DynamicData dynamicData = ChannelDynamicPresenter.this.i;
                if (dynamicData != null) {
                    this.f = dynamicData.buildModuleIds(moduleData.data);
                    this.g = ChannelDynamicPresenter.this.i.setFirstData(moduleData);
                }
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first data, size=" + moduleData.data.size() + " ,dynamicAd=" + ChannelDynamicConfigMananger.isAdDynamicLoad() + " ,adInfo=" + j.v.j.b.d(moduleData.adInfo));
            } else {
                ChannelDynamicPresenter.this.M(200, 200, ChannelDynamicPresenter.o, r().getFinalUrl(), ChannelDynamicPresenter.o);
            }
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null && gVar.l0()) {
                ChannelDynamicPresenter.this.L(200, 200, ChannelDynamicPresenter.o, r().getFinalUrl(), ChannelDynamicPresenter.o);
            }
            g gVar2 = ChannelDynamicPresenter.this.f;
            if (gVar2 != null) {
                gVar2.j(0, false);
            }
        }

        public void onCancelled(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.onCancelled(httpResponseObject, obj, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first data canceled");
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null) {
                gVar.j(2, false);
            }
        }

        public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super.onPostExecute(httpResponseObject, obj, th);
            ChannelDynamicPresenter.this.d.set(false);
            DynamicReportExecutor dynamicReportExecutor = ChannelDynamicPresenter.this.j;
            if (dynamicReportExecutor != null) {
                dynamicReportExecutor.r(r(), this.f, w());
                ChannelDynamicPresenter.this.j.q(r(), ChannelDynamicPresenter.this.a);
            }
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load first cost=" + w());
            if (j.a(this.g)) {
                return;
            }
            ChannelDynamicPresenter.this.w(this.g);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends j.l.c.c.c.q1.a<ModuleData> {
        public String f = "";
        public List<ModuleData.ModuleIDSBean> g = null;
        public final /* synthetic */ List h;

        public b(List list) {
            this.h = list;
        }

        /* renamed from: x */
        public void failed(@Nullable ModuleData moduleData, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.failed(moduleData, i, i2, str, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more data failed");
            DynamicData dynamicData = ChannelDynamicPresenter.this.i;
            if (dynamicData != null) {
                dynamicData.setMoreError(this.h, i);
            }
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null) {
                gVar.H(false);
            }
        }

        /* renamed from: y */
        public void previewCache(ModuleData moduleData) {
        }

        /* renamed from: z */
        public void success(ModuleData moduleData) {
            if (r() != null && !TextUtils.isEmpty(r().getFinalUrl())) {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more data success[Http]");
            } else {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more data success[Memory]");
            }
            if (moduleData.data != null) {
                moduleData.parseTraceId(r());
                DynamicData dynamicData = ChannelDynamicPresenter.this.i;
                if (dynamicData != null) {
                    this.f = dynamicData.buildModuleIds(moduleData.data);
                    this.g = ChannelDynamicPresenter.this.i.setMoreData(moduleData);
                }
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more data, size=" + moduleData.data.size());
            }
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null) {
                gVar.H(true);
            }
        }

        public void onCancelled(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.onCancelled(httpResponseObject, obj, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more data canceled");
        }

        public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super.onPostExecute(httpResponseObject, obj, th);
            ChannelDynamicPresenter.this.e.set(false);
            DynamicReportExecutor dynamicReportExecutor = ChannelDynamicPresenter.this.j;
            if (dynamicReportExecutor != null) {
                dynamicReportExecutor.r(r(), this.f, w());
            }
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load more cost=" + w());
            if (j.a(this.g)) {
                return;
            }
            ChannelDynamicPresenter.this.w(this.g);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class c extends j.l.c.c.c.q1.a<ModuleData> {
        public final /* synthetic */ int f;

        public c(int i) {
            this.f = i;
        }

        /* renamed from: x */
        public void failed(@Nullable ModuleData moduleData, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.failed(moduleData, i, i2, str, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load modules retry failed");
        }

        /* renamed from: y */
        public void success(ModuleData moduleData) {
            g gVar;
            if (this.f != ChannelDynamicPresenter.this.c.get()) {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load modules retry abandon ,refreshIndex=" + this.f + " ,currentIndex=" + ChannelDynamicPresenter.this.c.get());
            } else if (j.a(moduleData.data)) {
            } else {
                moduleData.parseTraceId(r());
                DynamicData dynamicData = ChannelDynamicPresenter.this.i;
                if (dynamicData != null) {
                    int modulesRetry = dynamicData.setModulesRetry(moduleData);
                    if (modulesRetry > 0 && (gVar = ChannelDynamicPresenter.this.f) != null) {
                        gVar.H(true);
                    }
                    j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load modules retry success ,validCount=" + modulesRetry);
                }
            }
        }

        public void onCancelled(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super/*com.mgtv.task.http.HttpCallBack*/.onCancelled(httpResponseObject, obj, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load modules retry canceled");
        }

        public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super.onPostExecute(httpResponseObject, obj, th);
            j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "load modules retry cost=" + w());
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d extends j.l.c.c.c.q1.a<ModuleData.DataBean> {
        public final /* synthetic */ String f;

        public d(String str) {
            this.f = str;
        }

        /* renamed from: x */
        public void previewCache(ModuleData.DataBean dataBean) {
        }

        /* renamed from: y */
        public void success(ModuleData.DataBean dataBean) {
            dataBean.parseTraceId(r());
            if (ChannelDynamicPresenter.this.i == null || j.a(dataBean.DSLList)) {
                return;
            }
            int[] updateModuleData = ChannelDynamicPresenter.this.i.updateModuleData(dataBean);
            g gVar = ChannelDynamicPresenter.this.f;
            if (gVar != null) {
                gVar.L(updateModuleData[0], updateModuleData[1]);
            }
        }

        public void onPostExecute(HttpResponseObject httpResponseObject, Object obj, Throwable th) {
            super.onPostExecute(httpResponseObject, obj, th);
            DynamicReportExecutor dynamicReportExecutor = ChannelDynamicPresenter.this.j;
            if (dynamicReportExecutor != null) {
                dynamicReportExecutor.r(r(), this.f, w());
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class e implements a.d {
        public final /* synthetic */ j.v.g.d.d a;
        public final /* synthetic */ ModuleData.DataBean.DSLBean b;
        public final /* synthetic */ List c;
        public final /* synthetic */ View d;

        public e(j.v.g.d.d dVar, ModuleData.DataBean.DSLBean dSLBean, List list, View view) {
            this.a = dVar;
            this.b = dSLBean;
            this.c = list;
            this.d = view;
        }

        public void a(View view, ChannelFeedbackEntity channelFeedbackEntity) {
            o0.o(j.l.a.a.a().getString(b.r.reduce_recommend_svideo));
            ChannelDynamicPresenter.this.requestUserShowFeedback(new ParamParser(this.a.e, ChannelDynamicPresenter.this.getSafetyJsonElement(this.a, this.b)).g(), channelFeedbackEntity, ChannelDynamicPresenter.this.getOptionContents(this.c), ChannelDynamicPresenter.this.getOptionIds(this.c));
            if (this.b.getItems() != null && this.b.getItems().size() > 1) {
                j.v.g.l.c cVar = this.d;
                if (!(cVar instanceof j.v.g.l.c)) {
                    ChannelDynamicPresenter.this.findDslListRemoveItem(cVar.getParent(), ((j.v.g.d.b) this.a).b);
                } else {
                    cVar.removeItem(((j.v.g.d.b) this.a).b);
                }
            } else {
                DynamicData dynamicData = ChannelDynamicPresenter.this.i;
                if (dynamicData != null) {
                    int[] removeModuleData = dynamicData.removeModuleData(this.b.moduleEntityId);
                    g gVar = ChannelDynamicPresenter.this.f;
                    if (gVar != null) {
                        gVar.r(removeModuleData[0], removeModuleData[1]);
                    }
                }
            }
            DynamicReportExecutor dynamicReportExecutor = ChannelDynamicPresenter.this.j;
            if (dynamicReportExecutor != null) {
                dynamicReportExecutor.reportFeedBackClick(view, this.a, this.b, channelFeedbackEntity.type);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class f extends ImgoHttpCallBack<JsonEntity> {
        public f() {
        }

        /* renamed from: w */
        public void failed(@Nullable JsonEntity jsonEntity, int i, int i2, @Nullable String str, @Nullable Throwable th) {
            super.failed(jsonEntity, i, i2, str, th);
        }

        @Override // com.hunantv.imgo.net.ImgoHttpCallBack
        /* renamed from: x */
        public void previewCache(JsonEntity jsonEntity) {
        }

        /* renamed from: y */
        public void success(JsonEntity jsonEntity) {
        }
    }

    static {
        j();
    }

    public ChannelDynamicPresenter(g gVar, j.l.c.c.d.e eVar, String str, DynamicAdPresenter dynamicAdPresenter) {
        this.f = gVar;
        this.g = eVar;
        this.a = str;
        this.m = dynamicAdPresenter;
        this.j = new DynamicReportExecutor(str);
        this.i = j.l.c.c.c.o1.r.c().a(this.a);
    }

    public static final /* synthetic */ String A(ChannelDynamicPresenter channelDynamicPresenter, List list, r.a.b.c cVar) {
        if (j.a(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChannelFeedbackEntity channelFeedbackEntity = (ChannelFeedbackEntity) it.next();
            if (!"cancel".equals(channelFeedbackEntity.type)) {
                sb.append(channelFeedbackEntity.type);
                sb.append(",");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static final /* synthetic */ List B(ChannelDynamicPresenter channelDynamicPresenter, ModuleData.DataBean.DSLBean dSLBean, r.a.b.c cVar) {
        ChannelIndexEntity.FdNegativeFeedbackData fdNegativeFeedbackData;
        DynamicData dynamicData;
        ModuleData.DataBean moduleData;
        ArrayList arrayList = new ArrayList();
        if (dSLBean != null) {
            JsonElement jsonElement = dSLBean.feedbackData;
            if (jsonElement == null && (dynamicData = channelDynamicPresenter.i) != null && (moduleData = dynamicData.getModuleData(dSLBean.moduleEntityId)) != null) {
                jsonElement = moduleData.feedbackData;
            }
            if (jsonElement != null && (fdNegativeFeedbackData = (ChannelIndexEntity.FdNegativeFeedbackData) j.v.j.b.w(jsonElement, ChannelIndexEntity.FdNegativeFeedbackData.class)) != null) {
                List<ChannelIndexEntity.FdNegativeFeedbackOptionsData> list = fdNegativeFeedbackData.fdNegativeOptions;
                if (!j.a(list)) {
                    for (ChannelIndexEntity.FdNegativeFeedbackOptionsData fdNegativeFeedbackOptionsData : list) {
                        ChannelFeedbackEntity channelFeedbackEntity = new ChannelFeedbackEntity();
                        channelFeedbackEntity.type = fdNegativeFeedbackOptionsData.id;
                        channelFeedbackEntity.content = fdNegativeFeedbackOptionsData.content;
                        channelFeedbackEntity.url = fdNegativeFeedbackOptionsData.url;
                        arrayList.add(channelFeedbackEntity);
                    }
                }
            }
        }
        ChannelFeedbackEntity channelFeedbackEntity2 = new ChannelFeedbackEntity();
        channelFeedbackEntity2.type = "cancel";
        channelFeedbackEntity2.content = j.l.a.a.a().getString(b.r.cancel);
        arrayList.add(channelFeedbackEntity2);
        return arrayList;
    }

    public static final /* synthetic */ JsonElement C(ChannelDynamicPresenter channelDynamicPresenter, j.v.g.d.b bVar, ModuleData.DataBean.DSLBean dSLBean, r.a.b.c cVar) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
        if (r0.equals("CAPlayerLoadPlay") == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void F(com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter r7, android.view.View r8, android.view.View r9, j.v.g.d.d r10, r.a.b.c r11) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter.F(com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter, android.view.View, android.view.View, j.v.g.d.d, r.a.b.c):void");
    }

    public static final /* synthetic */ void G(ChannelDynamicPresenter channelDynamicPresenter, j.v.g.d.e eVar, r.a.b.c cVar) {
        DynamicData dynamicData;
        ModuleData.DataBean.DSLBean dSLBean;
        DynamicReportExecutor dynamicReportExecutor;
        if (eVar == null || (dynamicData = channelDynamicPresenter.i) == null) {
            return;
        }
        List<ModuleData.DataBean.DSLBean> a2 = dynamicData.a();
        if (j.a(a2) || ((j.v.g.d.b) eVar).a >= a2.size() || (dSLBean = a2.get(((j.v.g.d.b) eVar).a)) == null || !dSLBean.isValid() || (dynamicReportExecutor = channelDynamicPresenter.j) == null) {
            return;
        }
        dynamicReportExecutor.putContainerExposure(eVar, dSLBean);
    }

    public static final /* synthetic */ void H(ChannelDynamicPresenter channelDynamicPresenter, View view, j.v.g.d.d dVar, ModuleData.DataBean.DSLBean dSLBean, r.a.b.c cVar) {
        if (view == null || dVar == null || dSLBean == null) {
            return;
        }
        v.c(n, "pressUserShowFeedBack,param: " + dVar.e);
        if (channelDynamicPresenter.g.getCurrentActivity() == null) {
            return;
        }
        List<ChannelFeedbackEntity> safetyFeedback = channelDynamicPresenter.getSafetyFeedback(dSLBean);
        y0.a(channelDynamicPresenter.k);
        j.l.c.c.c.l1.a.a aVar = new j.l.c.c.c.l1.a.a(channelDynamicPresenter.g.getCurrentActivity(), safetyFeedback);
        channelDynamicPresenter.k = aVar;
        aVar.d(new e(dVar, dSLBean, safetyFeedback, view));
        channelDynamicPresenter.k.show();
    }

    public static final /* synthetic */ void I(ChannelDynamicPresenter channelDynamicPresenter, r.a.b.c cVar) {
        j.l.a.n.m.a.d("30", n, String.format("refreshDynamic refreshIndex=%1$s,isFirstRequesting=%2$s ,isMoreRequesting=%3$s", Integer.valueOf(channelDynamicPresenter.c.get()), Boolean.valueOf(channelDynamicPresenter.d.get()), Boolean.valueOf(channelDynamicPresenter.e.get())));
        if (channelDynamicPresenter.d.get()) {
            g gVar = channelDynamicPresenter.f;
            if (gVar != null) {
                gVar.e(true);
            }
        } else if (channelDynamicPresenter.e.get()) {
        } else {
            channelDynamicPresenter.c.getAndIncrement();
            channelDynamicPresenter.getFirstData();
        }
    }

    public static final /* synthetic */ void J(ChannelDynamicPresenter channelDynamicPresenter, r.a.b.c cVar) {
        DynamicReportExecutor dynamicReportExecutor = channelDynamicPresenter.j;
        if (dynamicReportExecutor != null) {
            dynamicReportExecutor.executeContainerExposure();
        }
    }

    public static final /* synthetic */ void K(ChannelDynamicPresenter channelDynamicPresenter, int[] iArr, ModuleData.DataBean.DSLBean dSLBean, r.a.b.c cVar) {
        if (channelDynamicPresenter.j == null || channelDynamicPresenter.E() == null) {
            return;
        }
        channelDynamicPresenter.j.reportModuleExposure(iArr, dSLBean, channelDynamicPresenter.E().M());
    }

    public static final /* synthetic */ void N(ChannelDynamicPresenter channelDynamicPresenter, int i, final ModuleData.DataBean.DSLBean dSLBean, r.a.b.c cVar) {
        if (channelDynamicPresenter.g == null || dSLBean == null || dSLBean.data == null || channelDynamicPresenter.m == null || j.a(channelDynamicPresenter.t())) {
            return;
        }
        j.l.a.n.m.a.d("30", n, "requestAd: aid=" + dSLBean.getAid() + " ,key=" + channelDynamicPresenter.m.f(i, dSLBean));
        dSLBean.adState = 1;
        JsonObject jsonObject = dSLBean.data;
        if (jsonObject != null && jsonObject.get(DynamicAdEntity.FIELD_AD_STATE) != null) {
            dSLBean.data.remove(DynamicAdEntity.FIELD_AD_STATE);
        }
        j.u.n.d.b.i().z(j.l.c.a.f.a.b.n().l() == null ? 0 : j.l.c.a.f.a.b.n().l().areaCode);
        j.u.s.g gVar = new j.u.s.g();
        j.u.e.c.i.e eVar = new j.u.e.c.i.e();
        gVar.c0(j.l.c.x.t0.a.a().d());
        gVar.b0(j.l.c.x.t0.a.a().c());
        gVar.L(dSLBean.getAidInfo());
        eVar.e(true);
        eVar.H(j0.b(j.l.a.a.a(), 6.0f));
        eVar.M(gVar.K(dSLBean.getAid()).Q(c0.f(channelDynamicPresenter.g.K())).N(j.l.a.k.b.a()));
        eVar.p("ADS_BANNER");
        eVar.E(new BaseAdsListener() { // from class: com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter.7
            private static final /* synthetic */ c.b d = null;

            /* renamed from: com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter$7$a */
            /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
            public class a implements Runnable {
                public final /* synthetic */ int a;

                public a(int i) {
                    this.a = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (ChannelDynamicPresenter.this.E() != null) {
                        g E = ChannelDynamicPresenter.this.E();
                        int i = this.a;
                        E.L(i, i);
                    }
                }
            }

            static {
                B();
            }

            private static /* synthetic */ void B() {
                r.a.c.c.e eVar2 = new r.a.c.c.e("ChannelDynamicPresenter.java", AnonymousClass7.class);
                d = eVar2.H("method-execution", eVar2.E("1", "onAdListener", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter$7", "com.mgmi.ads.api.AdsListener$AdsEventType:com.mgmi.ads.api.AdWidgetInfoImp", "type:infoImp", "", "void"), 915);
            }

            public static final /* synthetic */ void D(AnonymousClass7 anonymousClass7, AdsListener.AdsEventType adsEventType, AdWidgetInfoImp adWidgetInfoImp, r.a.b.c cVar2) {
                j.l.a.n.m.a.d("30", ChannelDynamicPresenter.n, "requestAd: aid=" + dSLBean.getAid() + " ,onAdListener=" + adsEventType);
                ChannelDynamicPresenter channelDynamicPresenter2 = ChannelDynamicPresenter.this;
                if (channelDynamicPresenter2.g == null || j.a(channelDynamicPresenter2.t())) {
                    return;
                }
                int indexOf = ChannelDynamicPresenter.this.t().indexOf(dSLBean);
                if (AdsListener.AdsEventType.AD_REQUEST_SUCCESS.equals(adsEventType)) {
                    dSLBean.adState = 2;
                    if (ChannelDynamicPresenter.this.E() != null) {
                        ChannelDynamicPresenter.this.E().L(indexOf, indexOf);
                    }
                } else if (AdsListener.AdsEventType.AD_REQUEST_FAIL.equals(adsEventType)) {
                    ModuleData.DataBean.DSLBean dSLBean2 = dSLBean;
                    dSLBean2.adState = 3;
                    JsonObject jsonObject2 = dSLBean2.data;
                    if (jsonObject2 != null) {
                        jsonObject2.addProperty(DynamicAdEntity.FIELD_AD_STATE, 3);
                    }
                    if (ChannelDynamicPresenter.this.E() != null) {
                        ChannelDynamicPresenter.this.E().L(indexOf, indexOf);
                    }
                } else if (AdsListener.AdsEventType.AD_RENDER_FAIL.equals(adsEventType)) {
                    ModuleData.DataBean.DSLBean dSLBean3 = dSLBean;
                    dSLBean3.adState = 3;
                    JsonObject jsonObject3 = dSLBean3.data;
                    if (jsonObject3 != null) {
                        jsonObject3.addProperty(DynamicAdEntity.FIELD_AD_STATE, 3);
                    }
                    if (ChannelDynamicPresenter.this.E() == null || ChannelDynamicPresenter.this.E().M() == null) {
                        return;
                    }
                    ChannelDynamicPresenter.this.E().M().post(new a(indexOf));
                } else {
                    if (AdsListener.AdsEventType.JUMP_SCHEMA.equals(adsEventType)) {
                        String clickUrl = adWidgetInfoImp == null ? "" : adWidgetInfoImp.getClickUrl();
                        String uuid = adWidgetInfoImp != null ? adWidgetInfoImp.getUuid() : "";
                        AwayAppType awayAppType = adWidgetInfoImp == null ? AwayAppType.AWAY_APP_TYPE_YES : adWidgetInfoImp.getAwayAppType();
                        if (n0.z(clickUrl)) {
                            j.l.c.z.c.d.e().a(ChannelDynamicPresenter.this.g.getCurrentActivity(), clickUrl, (Bundle) null);
                        } else if (n0.v(clickUrl)) {
                            if (ChannelDynamicPresenter.this.m != null) {
                                ChannelDynamicPresenter.this.m.showDownloadDialog(clickUrl, uuid);
                            }
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("url", clickUrl);
                            bundle.putString("adUUID", uuid);
                            bundle.putInt("away_app_type", awayAppType.ordinal());
                            bundle.putBoolean("isad", true);
                            j.l.c.j0.b.a(ChannelDynamicPresenter.this.g.getCurrentActivity(), bundle);
                        }
                    } else if (AdsListener.AdsEventType.CLOSE_AD.equals(adsEventType)) {
                        if (ChannelDynamicPresenter.this.t() != null) {
                            ChannelDynamicPresenter.this.t().remove(indexOf);
                        }
                        if (ChannelDynamicPresenter.this.E() != null) {
                            ChannelDynamicPresenter.this.E().r(indexOf, indexOf);
                        }
                    } else if (AdsListener.AdsEventType.JUMP_HARFSCREEN_SCHEMA.equals(adsEventType)) {
                        String clickUrl2 = adWidgetInfoImp == null ? null : adWidgetInfoImp.getClickUrl();
                        String uuid2 = adWidgetInfoImp != null ? adWidgetInfoImp.getUuid() : null;
                        if (TextUtils.isEmpty(clickUrl2)) {
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("url", clickUrl2);
                        bundle2.putString("adUUID", uuid2);
                        bundle2.putInt("screenOritention", 1);
                        bundle2.putBoolean("isad", true);
                        j.l.c.j0.b.a(ChannelDynamicPresenter.this.g.getCurrentActivity(), bundle2);
                    } else if (!AdsListener.AdsEventType.AD_COVER_FINISH.equals(adsEventType) || ChannelDynamicPresenter.this.m == null) {
                    } else {
                        ChannelDynamicPresenter.this.m.k();
                    }
                }
            }

            public ViewGroup c(AdsListener.AdsEventType adsEventType, j.u.e.c.i.d dVar) {
                try {
                    if (AdsListener.AdsEventType.AD_REQUEST_HALF_COVER.equals(adsEventType)) {
                        if (ChannelDynamicPresenter.this.m != null) {
                            ChannelDynamicPresenter.this.m.p(dVar);
                        }
                        if (ChannelDynamicPresenter.this.f.b() instanceof ChannelDynamicFragment) {
                            ChannelDynamicFragment channelDynamicFragment = (ChannelDynamicFragment) ChannelDynamicPresenter.this.f.b();
                            if (channelDynamicFragment.isDestroyed()) {
                                return null;
                            }
                            return channelDynamicFragment.H0();
                        }
                        return null;
                    }
                    return j.l.c.c.c.m1.b.b(ChannelDynamicPresenter.this.f.a()).a();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }

            public boolean o() {
                j.l.c.c.d.e eVar2 = ChannelDynamicPresenter.this.g;
                return (eVar2 == null || eVar2.isDestroyed()) ? false : true;
            }

            @WithTryCatchRuntime
            public void onAdListener(AdsListener.AdsEventType adsEventType, AdWidgetInfoImp adWidgetInfoImp) {
                LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new r0(new Object[]{this, adsEventType, adWidgetInfoImp, r.a.c.c.e.x(d, this, this, adsEventType, adWidgetInfoImp)}).e(69648));
            }
        });
        DynamicAdPresenter dynamicAdPresenter = channelDynamicPresenter.m;
        j.u.e.c.i.d g = dynamicAdPresenter.g(dynamicAdPresenter.f(i, dSLBean));
        if (g == null) {
            if (channelDynamicPresenter.g.getCurrentActivity() != null) {
                j.u.e.c.i.d c2 = j.u.n.d.b.i().c(channelDynamicPresenter.g.getCurrentActivity(), eVar);
                DynamicAdPresenter dynamicAdPresenter2 = channelDynamicPresenter.m;
                dynamicAdPresenter2.l(dynamicAdPresenter2.f(i, dSLBean), c2);
                if (c2 != null) {
                    c2.G(eVar);
                    return;
                }
                return;
            }
            return;
        }
        g.G(eVar);
    }

    public static final /* synthetic */ void O(ChannelDynamicPresenter channelDynamicPresenter, String str, r.a.b.c cVar) {
        int i = 1;
        if (channelDynamicPresenter.l.containsKey(str)) {
            Integer num = channelDynamicPresenter.l.get(str);
            if (num != null && num.intValue() > 0 && num.intValue() < Integer.MAX_VALUE) {
                int intValue = Integer.valueOf(num.intValue() + 1).intValue();
                channelDynamicPresenter.l.put(str, Integer.valueOf(intValue));
                i = intValue;
            }
        } else {
            channelDynamicPresenter.l.put(str, 1);
        }
        j.l.c.c.c.q1.b bVar = new j.l.c.c.c.q1.b("https://dc.bz.mgtv.com/dynamic/v1/module/exchange");
        bVar.a();
        bVar.b(String.valueOf(str));
        bVar.b(String.valueOf(i));
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put(RemoteMessageConst.Notification.CHANNEL_ID, channelDynamicPresenter.a);
        channelDynamicPresenter.D().u(bVar.toString(), imgoHttpParams, new d(str));
    }

    public static final /* synthetic */ void P(ChannelDynamicPresenter channelDynamicPresenter, Map map, ChannelFeedbackEntity channelFeedbackEntity, String str, String str2, r.a.b.c cVar) {
        if (channelFeedbackEntity == null) {
            return;
        }
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        if (map != null) {
            imgoHttpParams.putParams(map);
        }
        imgoHttpParams.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, str);
        imgoHttpParams.put("optionIds", str2);
        imgoHttpParams.put("hitids", channelFeedbackEntity.type);
        imgoHttpParams.put("hitoptions", channelFeedbackEntity.content);
        channelDynamicPresenter.D().n(true).u("https://tags.bz.mgtv.com/user_show_feedback", imgoHttpParams, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void findDslListRemoveItem(ViewParent viewParent, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new z0(new Object[]{this, viewParent, r.a.c.b.e.k(i), r.a.c.c.e.x(B, this, this, viewParent, r.a.c.b.e.k(i))}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public String getOptionContents(List<ChannelFeedbackEntity> list) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new w0(new Object[]{this, list, r.a.c.c.e.w(z, this, this, list)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public String getOptionIds(List<ChannelFeedbackEntity> list) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.y0(new Object[]{this, list, r.a.c.c.e.w(A, this, this, list)}).e(69648));
    }

    @NonNull
    @WithTryCatchRuntime
    private List<ChannelFeedbackEntity> getSafetyFeedback(ModuleData.DataBean.DSLBean dSLBean) {
        return (List) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new v0(new Object[]{this, dSLBean, r.a.c.c.e.w(y, this, this, dSLBean)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public JsonElement getSafetyJsonElement(j.v.g.d.b bVar, ModuleData.DataBean.DSLBean dSLBean) {
        return (JsonElement) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new u0(new Object[]{this, bVar, dSLBean, r.a.c.c.e.x(x, this, this, bVar, dSLBean)}).e(69648));
    }

    private static /* synthetic */ void j() {
        r.a.c.c.e eVar = new r.a.c.c.e("ChannelDynamicPresenter.java", ChannelDynamicPresenter.class);
        q = eVar.H("method-execution", eVar.E("1", com.alipay.sdk.widget.d.w, "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "", "", "", "void"), 180);
        r = eVar.H("method-execution", eVar.E("4", "getFirstData", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "", "", "", "void"), 222);
        A = eVar.H("method-execution", eVar.E("2", "getOptionIds", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "java.util.List", "list", "", "java.lang.String"), 794);
        B = eVar.H("method-execution", eVar.E("2", "findDslListRemoveItem", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "android.view.ViewParent:int", "parent:index", "", "void"), 814);
        C = eVar.H("method-execution", eVar.E("1", "reportModuleExposure", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "[I:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "location:data", "", "void"), 829);
        D = eVar.H("method-execution", eVar.E("1", "handleContainerExposure", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "com.mgtv.dynamicview.action.RendAction", "action", "", "void"), 836);
        E = eVar.H("method-execution", eVar.E("1", "reportContainerExposure", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "", "", "", "void"), 857);
        F = eVar.H("method-execution", eVar.E("1", "findRequestAd", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "int:int", "first:last", "", "void"), 865);
        G = eVar.H("method-execution", eVar.E("2", "requestAd", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "int:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "listIndex:dslBean", "", "void"), 890);
        s = eVar.H("method-execution", eVar.E("1", "getMore", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "", "", "", "void"), 346);
        t = eVar.H("method-execution", eVar.E("1", "handleClickAction", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "android.view.View:android.view.View:com.mgtv.dynamicview.action.ClickAction", "itemView:clickView:action", "", "void"), 518);
        u = eVar.H("method-execution", eVar.E("2", "requestModuleExchange", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "java.lang.String", "moduleId", "", "void"), 593);
        v = eVar.H("method-execution", eVar.E("2", "pressUserShowFeedBack", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "android.view.View:com.mgtv.dynamicview.action.ClickAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "clickView:action:dslBean", "", "void"), 641);
        w = eVar.H("method-execution", eVar.E("2", "requestUserShowFeedback", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "java.util.Map:com.hunantv.oversea.channel.dynamic.data.ChannelFeedbackEntity:java.lang.String:java.lang.String", "param:select:options:optionIds", "", "void"), 689);
        x = eVar.H("method-execution", eVar.E("2", "getSafetyJsonElement", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "com.mgtv.dynamicview.action.BaseAction:com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "action:dslBean", "", "com.google.gson.JsonElement"), 723);
        y = eVar.H("method-execution", eVar.E("2", "getSafetyFeedback", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean$DSLBean", "dslBean", "", "java.util.List"), 740);
        z = eVar.H("method-execution", eVar.E("2", "getOptionContents", "com.hunantv.oversea.channel.dynamic.ChannelDynamicPresenter", "java.util.List", "list", "", "java.lang.String"), 777);
    }

    public static final /* synthetic */ void n(ChannelDynamicPresenter channelDynamicPresenter, ViewParent viewParent, int i, r.a.b.c cVar) {
        if (viewParent == null) {
            return;
        }
        if (viewParent instanceof j.v.g.l.c) {
            ((j.v.g.l.c) viewParent).removeItem(i);
        } else {
            channelDynamicPresenter.findDslListRemoveItem(viewParent.getParent(), i);
        }
    }

    public static final /* synthetic */ void o(ChannelDynamicPresenter channelDynamicPresenter, int i, int i2, r.a.b.c cVar) {
        DynamicAdPresenter dynamicAdPresenter;
        if (i < 0 || i > i2 || j.a(channelDynamicPresenter.t())) {
            return;
        }
        if (i2 >= channelDynamicPresenter.t().size()) {
            i2 = channelDynamicPresenter.t().size() - 1;
        }
        while (i <= i2) {
            ModuleData.DataBean.DSLBean dSLBean = channelDynamicPresenter.t().get(i);
            if (dSLBean != null && dSLBean.data != null && dSLBean.getAid() > 0) {
                int i3 = dSLBean.adState;
                if (i3 == 0) {
                    channelDynamicPresenter.requestAd(i, dSLBean);
                } else if (i3 == 2 && (dynamicAdPresenter = channelDynamicPresenter.m) != null) {
                    dynamicAdPresenter.resumeAd(i, dSLBean);
                }
            }
            i++;
        }
    }

    @WithTryCatchRuntime
    private void pressUserShowFeedBack(View view, j.v.g.d.d dVar, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new s0(new Object[]{this, view, dVar, dSLBean, r.a.c.c.e.y(v, this, this, new Object[]{view, dVar, dSLBean})}).e(69648));
    }

    @WithTryCatchRuntime
    private void requestAd(int i, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e1(new Object[]{this, r.a.c.b.e.k(i), dSLBean, r.a.c.c.e.x(G, this, this, r.a.c.b.e.k(i), dSLBean)}).e(69648));
    }

    @WithTryCatchRuntime
    private void requestModuleExchange(String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i1(new Object[]{this, str, r.a.c.c.e.w(u, this, this, str)}).e(69648));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WithTryCatchRuntime
    public void requestUserShowFeedback(Map<String, String> map, ChannelFeedbackEntity channelFeedbackEntity, String str, String str2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new t0(new Object[]{this, map, channelFeedbackEntity, str, str2, r.a.c.c.e.y(w, this, this, new Object[]{map, channelFeedbackEntity, str, str2})}).e(69648));
    }

    public static final /* synthetic */ void u(ChannelDynamicPresenter channelDynamicPresenter, r.a.b.c cVar) {
        channelDynamicPresenter.reportContainerExposure();
        if (channelDynamicPresenter.d.get()) {
            return;
        }
        channelDynamicPresenter.d.set(true);
        j.l.c.c.c.q1.b bVar = new j.l.c.c.c.q1.b("https://dc.bz.mgtv.com/dynamic/v1/channel/index");
        bVar.a();
        bVar.b(channelDynamicPresenter.a);
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put(RemoteMessageConst.Notification.CHANNEL_ID, channelDynamicPresenter.a);
        channelDynamicPresenter.h(imgoHttpParams);
        channelDynamicPresenter.D().n(true).o().u(bVar.toString(), imgoHttpParams, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<ModuleData.ModuleIDSBean> list) {
        DynamicData dynamicData;
        if (j.a(list) || (dynamicData = this.i) == null) {
            return;
        }
        String buildNextIdsString = dynamicData.buildNextIdsString(list);
        j.l.a.n.m.a.d("30", n, "load modules retry ids:" + buildNextIdsString);
        j.l.c.c.c.q1.b bVar = new j.l.c.c.c.q1.b("https://dc.bz.mgtv.com/dynamic/v1/module/infos");
        bVar.a();
        bVar.b(this.a);
        bVar.b(buildNextIdsString);
        ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
        imgoHttpParams.put(RemoteMessageConst.Notification.CHANNEL_ID, this.a);
        h(imgoHttpParams);
        D().n(true).l(0).u(bVar.toString(), imgoHttpParams, new c(this.c.get()));
    }

    public static final /* synthetic */ void x(ChannelDynamicPresenter channelDynamicPresenter, r.a.b.c cVar) {
        List<ModuleData.ModuleIDSBean> list;
        channelDynamicPresenter.reportContainerExposure();
        if (channelDynamicPresenter.d.get()) {
            g gVar = channelDynamicPresenter.f;
            if (gVar != null) {
                gVar.c(true);
            }
            j.l.a.n.m.a.d("30", n, "load more shut down,isRefresh=" + channelDynamicPresenter.d.get());
        } else if (channelDynamicPresenter.e.get()) {
        } else {
            channelDynamicPresenter.e.set(true);
            DynamicData dynamicData = channelDynamicPresenter.i;
            String str = null;
            if (dynamicData != null) {
                List<ModuleData.ModuleIDSBean> q2 = dynamicData.q();
                str = channelDynamicPresenter.i.buildNextIdsString(q2);
                list = q2;
            } else {
                list = null;
            }
            j.l.a.n.m.a.d("30", n, "load more ids:" + str);
            if (j.a(list)) {
                g gVar2 = channelDynamicPresenter.f;
                if (gVar2 != null) {
                    gVar2.o0();
                }
                channelDynamicPresenter.e.set(false);
                return;
            }
            j.l.c.c.c.q1.b bVar = new j.l.c.c.c.q1.b("https://dc.bz.mgtv.com/dynamic/v1/module/infos");
            bVar.a();
            bVar.b(channelDynamicPresenter.a);
            bVar.b(str);
            ImgoHttpParams imgoHttpParams = new ImgoHttpParams();
            imgoHttpParams.put(RemoteMessageConst.Notification.CHANNEL_ID, channelDynamicPresenter.a);
            channelDynamicPresenter.h(imgoHttpParams);
            channelDynamicPresenter.D().n(true).o().u(bVar.toString(), imgoHttpParams, new b(list));
        }
    }

    public static final /* synthetic */ String z(ChannelDynamicPresenter channelDynamicPresenter, List list, r.a.b.c cVar) {
        if (j.a(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChannelFeedbackEntity channelFeedbackEntity = (ChannelFeedbackEntity) it.next();
            if (!"cancel".equals(channelFeedbackEntity.type)) {
                sb.append(channelFeedbackEntity.content);
                sb.append(",");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public r D() {
        if (this.h == null) {
            this.h = new r(j.l.a.a.a(), new m(ThreadManager.getNetWorkExecutorService(), false), (p) null);
        }
        return this.h;
    }

    public g E() {
        return this.f;
    }

    public void L(int i, int i2, String str, String str2, String str3) {
        j.l.b.g.d.m(i, str3, new o(i, i2, str, str2, this.a).c());
        j.l.a.n.m.a.d("30", n, "频道页面列表数据为空" + this.a);
    }

    public void M(int i, int i2, String str, String str2, String str3) {
        j.l.b.g.d.n(i, str3, new o(i, i2, str, str2, this.a).c());
        j.l.a.n.m.a.d("30", n, "频道页面列表数据为空" + this.a);
    }

    public void Q(String str) {
        this.b = str;
    }

    public void R(int i) {
        DynamicReportExecutor dynamicReportExecutor = this.j;
        if (dynamicReportExecutor != null) {
            dynamicReportExecutor.s(i);
        }
    }

    public String S(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @WithTryCatchRuntime
    public void findRequestAd(int i, int i2) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d1(new Object[]{this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2), r.a.c.c.e.x(F, this, this, r.a.c.b.e.k(i), r.a.c.b.e.k(i2))}).e(69648));
    }

    @WithTryCatchRuntime
    public void getFirstData() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f1(new Object[]{this, r.a.c.c.e.v(r, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void getMore() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g1(new Object[]{this, r.a.c.c.e.v(s, this, this)}).e(69648));
    }

    public void h(HttpParams httpParams) {
        if (httpParams == null) {
            return;
        }
        i(httpParams);
    }

    @WithTryCatchRuntime
    public void handleClickAction(View view, View view2, j.v.g.d.d dVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h1(new Object[]{this, view, view2, dVar, r.a.c.c.e.y(t, this, this, new Object[]{view, view2, dVar})}).e(69648));
    }

    @WithTryCatchRuntime
    public void handleContainerExposure(j.v.g.d.e eVar) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b1(new Object[]{this, eVar, r.a.c.c.e.w(D, this, this, eVar)}).e(69648));
    }

    public void i(HttpParams httpParams) {
    }

    public void k() {
        this.l.clear();
        DynamicReportExecutor dynamicReportExecutor = this.j;
        if (dynamicReportExecutor != null) {
            dynamicReportExecutor.h();
        }
        DynamicAdPresenter dynamicAdPresenter = this.m;
        if (dynamicAdPresenter != null) {
            dynamicAdPresenter.clearAd();
        }
        CollectReportHelper.clearExposure();
        VideoCollectPresenter.d();
        j.l.a.n.m.a.d("30", n, "clear");
    }

    public void l() {
        DynamicData dynamicData = this.i;
        if (dynamicData != null) {
            dynamicData.g();
        }
    }

    public void m() {
        k();
        this.f = null;
        this.g = null;
    }

    public String p() {
        return this.b;
    }

    public String q() {
        return this.a;
    }

    public ModuleData.ChannelBean r() {
        DynamicData dynamicData = this.i;
        if (dynamicData != null) {
            return dynamicData.n();
        }
        return null;
    }

    @WithTryCatchRuntime
    public void refresh() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new x0(new Object[]{this, r.a.c.c.e.v(q, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportContainerExposure() {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new c1(new Object[]{this, r.a.c.c.e.v(E, this, this)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportModuleExposure(int[] iArr, ModuleData.DataBean.DSLBean dSLBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new a1(new Object[]{this, iArr, dSLBean, r.a.c.c.e.x(C, this, this, iArr, dSLBean)}).e(69648));
    }

    public String s() {
        DynamicData dynamicData = this.i;
        if (dynamicData == null) {
            return null;
        }
        return dynamicData.o();
    }

    public List<ModuleData.DataBean.DSLBean> t() {
        DynamicData dynamicData = this.i;
        if (dynamicData == null) {
            return null;
        }
        return dynamicData.a();
    }

    public int v() {
        DynamicReportExecutor dynamicReportExecutor = this.j;
        if (dynamicReportExecutor == null) {
            return 0;
        }
        return dynamicReportExecutor.k();
    }

    public List<ModuleData.DataBean.DSLBean> y() {
        DynamicData dynamicData = this.i;
        if (dynamicData == null) {
            return null;
        }
        return dynamicData.r();
    }
}
