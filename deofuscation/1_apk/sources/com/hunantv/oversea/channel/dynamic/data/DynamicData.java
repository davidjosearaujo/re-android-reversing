package com.hunantv.oversea.channel.dynamic.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.asm.Opcodes;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.gson.JsonObject;
import com.hunantv.media.drm.IDrmSession;
import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.oversea.channel.dynamic.config.ChannelDynamicConfigMananger;
import com.hunantv.oversea.channel.dynamic.data.ModuleData;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.b0.c0;
import j.l.a.b0.j;
import j.l.a.b0.v;
import j.l.a.n.m.a;
import j.l.c.c.c.o1.b;
import j.l.c.c.c.o1.d;
import j.l.c.c.c.o1.e;
import j.l.c.c.c.o1.f;
import j.l.c.c.c.o1.g;
import j.l.c.c.c.o1.h;
import j.l.c.c.c.o1.i;
import j.l.c.c.c.o1.k;
import j.l.c.c.c.o1.l;
import j.l.c.c.c.o1.m;
import j.l.c.c.c.o1.n;
import j.l.c.c.c.o1.o;
import j.l.c.c.c.o1.p;
import j.l.c.c.c.o1.q;
import j.l.c.c.c.o1.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import r.a.b.c;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicData implements s {
    private static final /* synthetic */ c.b A = null;
    private static final String k = "DynamicData";
    private static final /* synthetic */ c.b l = null;
    private static final /* synthetic */ c.b m = null;
    private static final /* synthetic */ c.b n = null;
    private static final /* synthetic */ c.b o = null;
    private static final /* synthetic */ c.b p = null;
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
    private String a;
    private ModuleData.ModuleIDSBean b;
    private ModuleData.AdInfoBean c;
    private List<ModuleData.ModuleIDSBean> d = new CopyOnWriteArrayList();
    private Map<String, ModuleData.ModuleIDSBean> e = new HashMap();
    private List<ModuleData.DataBean.DSLBean> f = Collections.synchronizedList(new ArrayList());
    private List<ModuleData.DataBean.DSLBean> g = null;
    private Map<String, ModuleData.DataBean> h = new HashMap();
    private String i;
    private ModuleData.ChannelBean j;

    static {
        c();
    }

    public DynamicData(String str) {
        this.a = str;
    }

    @WithTryCatchRuntime
    private void addDataList(ModuleData.DataBean dataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new e(new Object[]{this, dataBean, r.a.c.c.e.w(t, this, this, dataBean)}).e(69648));
    }

    public static final /* synthetic */ void b(DynamicData dynamicData, ModuleData.DataBean dataBean, c cVar) {
        if (dataBean == null || TextUtils.isEmpty(dataBean.moduleEntityId)) {
            return;
        }
        if (dataBean.isValid()) {
            if (dataBean.card == 1) {
                dynamicData.fillCardFlag(dataBean.DSLList);
            }
            for (ModuleData.DataBean.DSLBean dSLBean : dataBean.DSLList) {
                dSLBean.copyTransient(dataBean);
                if (dSLBean.isValid()) {
                    dynamicData.f.add(dSLBean);
                }
            }
        }
        ModuleData.ModuleIDSBean moduleIDSBean = dynamicData.e.get(dataBean.moduleEntityId);
        if (moduleIDSBean == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(moduleIDSBean.moduleEntityId);
        if (moduleIDSBean.isColumnInfinite()) {
            sb.append("-");
            sb.append(moduleIDSBean.getPageNum());
            if (!dataBean.hasMore) {
                moduleIDSBean.setNoMore();
            } else {
                moduleIDSBean.inCrease();
            }
        }
        dynamicData.h.put(sb.toString(), dataBean);
    }

    private static /* synthetic */ void c() {
        r.a.c.c.e eVar = new r.a.c.c.e("DynamicData.java", DynamicData.class);
        l = eVar.H("method-execution", eVar.E("1", "setFirstData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData", "moduleData", "", "java.util.List"), 64);
        m = eVar.H("method-execution", eVar.E("1", "setMoreData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData", "moduleData", "", "java.util.List"), 98);
        v = eVar.H("method-execution", eVar.E("2", "findInsertCmsAd", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean", "dataBean", "", "void"), 487);
        w = eVar.H("method-execution", eVar.E("2", "insertAdData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "long:java.lang.String", "aid:aidInfo", "", "void"), 513);
        x = eVar.H("method-execution", eVar.E("2", "fillCardFlag", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List", "list", "", "void"), 532);
        y = eVar.H("method-execution", eVar.E("1", "buildNextIdsString", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List", "list", "", "java.lang.String"), 560);
        z = eVar.H("method-execution", eVar.E("1", "buildModuleIds", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List", "list", "", "java.lang.String"), 588);
        A = eVar.H("method-execution", eVar.E("1", "getModuleData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.lang.String", "moduleId", "", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean"), 608);
        n = eVar.H("method-execution", eVar.E("1", "setMoreError", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List:int", "idsList:httpCode", "", "void"), 121);
        o = eVar.H("method-execution", eVar.E("1", "setModulesRetry", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData", "moduleData", "", "int"), (int) EventClickData.u.C1);
        p = eVar.H("method-execution", eVar.E("2", "findRetryModules", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List", "list", "", "java.util.List"), (int) Opcodes.NEWARRAY);
        q = eVar.H("method-execution", eVar.E("2", "findLastModuleID", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.util.List", "list", "", "void"), (int) IDrmSession.ERROR_SESSION_NO_PROVISION);
        r = eVar.H("method-execution", eVar.E("1", "updateModuleData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean", "data", "", "[I"), 236);
        s = eVar.H("method-execution", eVar.E("1", "removeModuleData", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "java.lang.String", "moduleId", "", "[I"), 287);
        t = eVar.H("method-execution", eVar.E("2", "addDataList", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean", "data", "", "void"), (int) BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        u = eVar.H("method-execution", eVar.E("2", "findInsertDynamicAd", "com.hunantv.oversea.channel.dynamic.data.DynamicData", "com.hunantv.oversea.channel.dynamic.data.ModuleData$DataBean", "dataBean", "", "void"), 451);
    }

    public static final /* synthetic */ String d(DynamicData dynamicData, List list, c cVar) {
        if (j.a(list)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ModuleData.DataBean dataBean = (ModuleData.DataBean) list.get(i);
            if (!TextUtils.isEmpty(dataBean.moduleEntityId)) {
                sb.append(dataBean.moduleEntityId);
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public static final /* synthetic */ String e(DynamicData dynamicData, List list, c cVar) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ModuleData.ModuleIDSBean moduleIDSBean = (ModuleData.ModuleIDSBean) list.get(i);
            if (!TextUtils.isEmpty(moduleIDSBean.moduleEntityId)) {
                sb.append(moduleIDSBean.moduleEntityId);
                if (moduleIDSBean.hasMore()) {
                    sb.append('-');
                    sb.append(moduleIDSBean.getPageNum());
                    return sb.toString();
                } else if (i < list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    @WithTryCatchRuntime
    private void fillCardFlag(List<ModuleData.DataBean.DSLBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.o1.j(new Object[]{this, list, r.a.c.c.e.w(x, this, this, list)}).e(69648));
    }

    @WithTryCatchRuntime
    private void findInsertCmsAd(ModuleData.DataBean dataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new h(new Object[]{this, dataBean, r.a.c.c.e.w(v, this, this, dataBean)}).e(69648));
    }

    @WithTryCatchRuntime
    private void findInsertDynamicAd(ModuleData.DataBean dataBean) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new f(new Object[]{this, dataBean, r.a.c.c.e.w(u, this, this, dataBean)}).e(69648));
    }

    @WithTryCatchRuntime
    private void findLastModuleID(List<ModuleData.DataBean> list) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new b(new Object[]{this, list, r.a.c.c.e.w(q, this, this, list)}).e(69648));
    }

    @Nullable
    @WithTryCatchRuntime
    private List<ModuleData.ModuleIDSBean> findRetryModules(List<ModuleData.DataBean> list) {
        return (List) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new q(new Object[]{this, list, r.a.c.c.e.w(p, this, this, list)}).e(69648));
    }

    public static final /* synthetic */ void h(DynamicData dynamicData, List list, c cVar) {
        if (j.a(list)) {
            return;
        }
        if (list.size() == 1) {
            ((ModuleData.DataBean.DSLBean) list.get(0)).cardFlag = 1;
        } else if (list.size() == 2) {
            ((ModuleData.DataBean.DSLBean) list.get(0)).cardFlag = 2;
            ((ModuleData.DataBean.DSLBean) list.get(1)).cardFlag = 4;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    ((ModuleData.DataBean.DSLBean) list.get(i)).cardFlag = 2;
                } else if (i == list.size() - 1) {
                    ((ModuleData.DataBean.DSLBean) list.get(i)).cardFlag = 4;
                } else {
                    ((ModuleData.DataBean.DSLBean) list.get(i)).cardFlag = 3;
                }
            }
        }
    }

    private void i(ModuleData.DataBean dataBean) {
        ModuleData.ModuleIDSBean moduleIDSBean;
        ModuleData.AdInfoBean adInfoBean;
        if (dataBean == null || TextUtils.isEmpty(dataBean.moduleEntityId) || (moduleIDSBean = this.e.get(dataBean.moduleEntityId)) == null || moduleIDSBean.isColumnInfinite() || dataBean.isCache) {
            return;
        }
        if (ChannelDynamicConfigMananger.isAdDynamicLoad() && (adInfoBean = this.c) != null && !adInfoBean.isEmpty()) {
            findInsertDynamicAd(dataBean);
        } else {
            findInsertCmsAd(dataBean);
        }
    }

    @WithTryCatchRuntime
    private void insertAdData(long j, String str) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new i(new Object[]{this, r.a.c.b.e.m(j), str, r.a.c.c.e.x(w, this, this, r.a.c.b.e.m(j), str)}).e(69648));
    }

    public static final /* synthetic */ void j(DynamicData dynamicData, ModuleData.DataBean dataBean, c cVar) {
        if (dataBean == null) {
            return;
        }
        ModuleData.ModuleIDSBean moduleIDSBean = null;
        int i = 0;
        while (true) {
            if (i >= dynamicData.d.size() - 1) {
                break;
            }
            ModuleData.ModuleIDSBean moduleIDSBean2 = dynamicData.d.get(i);
            if (!TextUtils.equals(moduleIDSBean2.moduleEntityId, dataBean.moduleEntityId)) {
                i++;
            } else if (!moduleIDSBean2.isColumnInfinite() || moduleIDSBean2.getPageNum() <= 2) {
                moduleIDSBean = dynamicData.d.get(i + 1);
            }
        }
        if (moduleIDSBean == null || !moduleIDSBean.isAd()) {
            return;
        }
        dynamicData.insertAdData(c0.h(moduleIDSBean.adID), "");
    }

    public static final /* synthetic */ void k(DynamicData dynamicData, ModuleData.DataBean dataBean, c cVar) {
        ModuleData.AdInfoBean adInfoBean;
        int interval;
        if (dataBean == null || (adInfoBean = dynamicData.c) == null || adInfoBean.isEmpty() || j.a(dynamicData.d)) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < dynamicData.d.size() - 1; i2++) {
            ModuleData.ModuleIDSBean moduleIDSBean = dynamicData.d.get(i2);
            if (!moduleIDSBean.isAd()) {
                i++;
                if (TextUtils.equals(moduleIDSBean.moduleEntityId, dataBean.moduleEntityId)) {
                    if (i < dynamicData.c.getInterval() || i % dynamicData.c.getInterval() != 0 || (i / dynamicData.c.getInterval()) - 1 < 0 || j.a(dynamicData.c.ids)) {
                        return;
                    }
                    dynamicData.insertAdData(c0.h(dynamicData.c.ids.get(interval % dynamicData.c.ids.size())), "");
                    return;
                }
            }
        }
    }

    public static final /* synthetic */ void l(DynamicData dynamicData, List list, c cVar) {
        ModuleData.ModuleIDSBean moduleIDSBean;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            ModuleData.DataBean dataBean = (ModuleData.DataBean) list.get(size);
            if (dataBean != null && !TextUtils.isEmpty(dataBean.moduleEntityId) && (moduleIDSBean = dynamicData.e.get(dataBean.moduleEntityId)) != null) {
                dynamicData.b = moduleIDSBean;
                return;
            }
        }
    }

    public static final /* synthetic */ List m(DynamicData dynamicData, List list, c cVar) {
        ModuleData.ModuleIDSBean moduleIDSBean;
        if (j.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModuleData.DataBean dataBean = (ModuleData.DataBean) it.next();
            if (dataBean.retryItem == 1 && j.a(dataBean.DSLList) && (moduleIDSBean = dynamicData.e.get(dataBean.moduleEntityId)) != null && !moduleIDSBean.isColumnInfinite()) {
                arrayList.add(moduleIDSBean);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ ModuleData.DataBean p(DynamicData dynamicData, String str, c cVar) {
        ModuleData.ModuleIDSBean moduleIDSBean;
        if (TextUtils.isEmpty(str) || dynamicData.h == null || j.b(dynamicData.e) || (moduleIDSBean = dynamicData.e.get(str)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(moduleIDSBean.moduleEntityId);
        if (moduleIDSBean.isColumnInfinite()) {
            sb.append("-");
            sb.append(moduleIDSBean.getPageNum());
        }
        return dynamicData.h.get(sb.toString());
    }

    public static final /* synthetic */ void s(DynamicData dynamicData, long j, String str, c cVar) {
        if (j <= 0) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("aid", Long.valueOf(j));
        jsonObject.addProperty("aidInfo", str);
        ModuleData.DataBean.DSLBean dSLBean = new ModuleData.DataBean.DSLBean();
        dSLBean.DSLID = ModuleData.DSL_ID_INSERT_AD;
        dSLBean.data = jsonObject;
        dynamicData.f.add(dSLBean);
        a.d("30", k, String.format("insertAd, isDynamic=%1$s, position=%2$s, data=%3$s", Boolean.valueOf(ChannelDynamicConfigMananger.isAdDynamicLoad()), Integer.valueOf(dynamicData.f.size()), jsonObject.toString()));
    }

    public static final /* synthetic */ int[] t(DynamicData dynamicData, String str, c cVar) {
        int i;
        int i2 = -1;
        if (j.a(dynamicData.f)) {
            i = -1;
        } else {
            ArrayList arrayList = new ArrayList();
            i = -1;
            for (int i3 = 0; i3 < dynamicData.f.size(); i3++) {
                ModuleData.DataBean.DSLBean dSLBean = dynamicData.f.get(i3);
                if (TextUtils.equals(dSLBean.moduleEntityId, str)) {
                    if (i2 < 0) {
                        i2 = i3;
                    }
                    arrayList.add(dSLBean);
                    i = i3;
                }
            }
            if (!j.a(arrayList)) {
                dynamicData.f.removeAll(arrayList);
            }
        }
        return new int[]{i2, i};
    }

    public static final /* synthetic */ List u(DynamicData dynamicData, ModuleData moduleData, c cVar) {
        if (moduleData == null || j.a(moduleData.moduleIDS) || j.a(moduleData.data)) {
            return null;
        }
        dynamicData.g = new ArrayList(dynamicData.f);
        dynamicData.f();
        dynamicData.c = moduleData.adInfo;
        dynamicData.i = moduleData.title;
        dynamicData.j = moduleData.channel;
        CopyOnWriteArrayList<ModuleData.ModuleIDSBean> copyOnWriteArrayList = new CopyOnWriteArrayList(moduleData.moduleIDS);
        dynamicData.d = copyOnWriteArrayList;
        for (ModuleData.ModuleIDSBean moduleIDSBean : copyOnWriteArrayList) {
            if (moduleIDSBean != null && !TextUtils.isEmpty(moduleIDSBean.moduleEntityId)) {
                dynamicData.e.put(moduleIDSBean.moduleEntityId, moduleIDSBean);
            }
        }
        for (ModuleData.DataBean dataBean : moduleData.data) {
            dynamicData.addDataList(dataBean);
            dynamicData.i(dataBean);
        }
        List<ModuleData.ModuleIDSBean> findRetryModules = dynamicData.findRetryModules(moduleData.data);
        dynamicData.findLastModuleID(moduleData.data);
        return findRetryModules;
    }

    public static final /* synthetic */ int v(DynamicData dynamicData, ModuleData moduleData, c cVar) {
        ModuleData.ModuleIDSBean moduleIDSBean;
        if (dynamicData.f.size() > 0) {
            List<ModuleData.DataBean.DSLBean> list = dynamicData.f;
            ModuleData.DataBean.DSLBean dSLBean = list.get(list.size() - 1);
            if (dSLBean != null && (moduleIDSBean = dynamicData.e.get(dSLBean.moduleEntityId)) != null && moduleIDSBean.isColumnInfinite()) {
                return -1;
            }
        }
        if (moduleData == null || j.a(moduleData.data)) {
            return 0;
        }
        dynamicData.g = new ArrayList(dynamicData.f);
        int i = 0;
        for (int i2 = 0; i2 < moduleData.data.size(); i2++) {
            ModuleData.DataBean dataBean = moduleData.data.get(i2);
            dynamicData.addDataList(dataBean);
            if (dataBean.isValid()) {
                i++;
            }
        }
        return i;
    }

    public static final /* synthetic */ List w(DynamicData dynamicData, ModuleData moduleData, c cVar) {
        if (moduleData == null || j.a(moduleData.data)) {
            return null;
        }
        dynamicData.g = new ArrayList(dynamicData.f);
        for (int i = 0; i < moduleData.data.size(); i++) {
            ModuleData.DataBean dataBean = moduleData.data.get(i);
            dynamicData.addDataList(dataBean);
            dynamicData.i(dataBean);
        }
        List<ModuleData.ModuleIDSBean> findRetryModules = dynamicData.findRetryModules(moduleData.data);
        dynamicData.findLastModuleID(moduleData.data);
        return findRetryModules;
    }

    public static final /* synthetic */ void x(DynamicData dynamicData, List list, int i, c cVar) {
        if (j.a(list)) {
            return;
        }
        if (list.size() == 1) {
            boolean z2 = false;
            ModuleData.ModuleIDSBean moduleIDSBean = (ModuleData.ModuleIDSBean) list.get(0);
            if (moduleIDSBean != null && moduleIDSBean.isColumnInfinite()) {
                int indexOf = dynamicData.d.indexOf(moduleIDSBean);
                if (indexOf < dynamicData.d.size() - 1) {
                    int i2 = indexOf + 1;
                    while (true) {
                        if (i2 < dynamicData.d.size()) {
                            ModuleData.ModuleIDSBean moduleIDSBean2 = dynamicData.d.get(i2);
                            if (moduleIDSBean2 != null && !TextUtils.isEmpty(moduleIDSBean2.moduleEntityId)) {
                                z2 = true;
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                if (z2 || i == 466) {
                    moduleIDSBean.setNoMore();
                }
            }
        }
        dynamicData.b = (ModuleData.ModuleIDSBean) list.get(list.size() - 1);
    }

    public static final /* synthetic */ int[] y(DynamicData dynamicData, ModuleData.DataBean dataBean, c cVar) {
        int i;
        if (dataBean == null || j.a(dataBean.DSLList)) {
            return new int[]{-1, -1};
        }
        if (dataBean.card == 1) {
            dynamicData.fillCardFlag(dataBean.DSLList);
        }
        ArrayList arrayList = new ArrayList();
        for (ModuleData.DataBean.DSLBean dSLBean : dataBean.DSLList) {
            if (dSLBean.isValid()) {
                dSLBean.copyTransient(dataBean);
                arrayList.add(dSLBean);
            }
        }
        if (arrayList.isEmpty()) {
            return new int[]{-1, -1};
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = -1;
        if (j.a(dynamicData.f)) {
            i = -1;
        } else {
            i = -1;
            for (int i3 = 0; i3 < dynamicData.f.size(); i3++) {
                ModuleData.DataBean.DSLBean dSLBean2 = dynamicData.f.get(i3);
                if (TextUtils.equals(dSLBean2.moduleEntityId, dataBean.moduleEntityId)) {
                    if (i < 0) {
                        i = i3;
                    }
                    arrayList2.add(dSLBean2);
                }
            }
            if (arrayList2.size() > 0) {
                dynamicData.f.removeAll(arrayList2);
            }
        }
        if (i >= 0) {
            dynamicData.f.addAll(i, arrayList);
            if (arrayList.size() == arrayList2.size()) {
                i2 = (arrayList.size() + i) - 1;
            }
        }
        return new int[]{i, i2};
    }

    @NonNull
    public List<ModuleData.DataBean.DSLBean> a() {
        return this.f;
    }

    @Nullable
    @WithTryCatchRuntime
    public String buildModuleIds(List<ModuleData.DataBean> list) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new l(new Object[]{this, list, r.a.c.c.e.w(z, this, this, list)}).e(69648));
    }

    @Nullable
    @WithTryCatchRuntime
    public String buildNextIdsString(List<ModuleData.ModuleIDSBean> list) {
        return (String) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new k(new Object[]{this, list, r.a.c.c.e.w(y, this, this, list)}).e(69648));
    }

    public void f() {
        this.b = null;
        this.c = null;
        this.f.clear();
        this.d.clear();
        this.e.clear();
        this.h.clear();
    }

    public void g() {
        this.g = null;
    }

    @Nullable
    @WithTryCatchRuntime
    public ModuleData.DataBean getModuleData(String str) {
        return (ModuleData.DataBean) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new m(new Object[]{this, str, r.a.c.c.e.w(A, this, this, str)}).e(69648));
    }

    public ModuleData.ChannelBean n() {
        return this.j;
    }

    public String o() {
        return this.i;
    }

    @Nullable
    public List<ModuleData.ModuleIDSBean> q() {
        List<ModuleData.ModuleIDSBean> list;
        if (this.b != null && (list = this.d) != null && !list.isEmpty()) {
            v.c(k, "mLastModuleID: " + j.v.j.b.E(this.b));
            ArrayList arrayList = new ArrayList();
            int dynamicLoadMoudelCount = ChannelDynamicConfigMananger.getDynamicLoadMoudelCount();
            if (this.b.hasMore()) {
                arrayList.add(this.b);
                return arrayList;
            }
            int indexOf = this.d.indexOf(this.b);
            if (indexOf >= 0 && indexOf != this.d.size()) {
                while (true) {
                    indexOf++;
                    if (indexOf >= this.d.size()) {
                        break;
                    }
                    ModuleData.ModuleIDSBean moduleIDSBean = this.d.get(indexOf);
                    if (!moduleIDSBean.isAd()) {
                        dynamicLoadMoudelCount--;
                        if (dynamicLoadMoudelCount < 0) {
                            break;
                        } else if (moduleIDSBean.hasMore()) {
                            arrayList.add(moduleIDSBean);
                            v.c(k, "find infinite: moduleId=" + moduleIDSBean.moduleEntityId + ",infinite=" + moduleIDSBean.infinite + ",pageNum=" + moduleIDSBean.getPageNum());
                            break;
                        } else {
                            arrayList.add(moduleIDSBean);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
        }
        return null;
    }

    @Nullable
    public List<ModuleData.DataBean.DSLBean> r() {
        return this.g;
    }

    @NonNull
    @WithTryCatchRuntime
    public int[] removeModuleData(String str) {
        return (int[]) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new d(new Object[]{this, str, r.a.c.c.e.w(s, this, this, str)}).e(69648));
    }

    @Nullable
    @WithTryCatchRuntime
    public List<ModuleData.ModuleIDSBean> setFirstData(ModuleData moduleData) {
        return (List) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new g(new Object[]{this, moduleData, r.a.c.c.e.w(l, this, this, moduleData)}).e(69648));
    }

    @WithTryCatchRuntime
    public int setModulesRetry(ModuleData moduleData) {
        return r.a.c.b.e.l(LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new p(new Object[]{this, moduleData, r.a.c.c.e.w(o, this, this, moduleData)}).e(69648)));
    }

    @Nullable
    @WithTryCatchRuntime
    public List<ModuleData.ModuleIDSBean> setMoreData(ModuleData moduleData) {
        return (List) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new n(new Object[]{this, moduleData, r.a.c.c.e.w(m, this, this, moduleData)}).e(69648));
    }

    @WithTryCatchRuntime
    public void setMoreError(List<ModuleData.ModuleIDSBean> list, int i) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new o(new Object[]{this, list, r.a.c.b.e.k(i), r.a.c.c.e.x(n, this, this, list, r.a.c.b.e.k(i))}).e(69648));
    }

    @NonNull
    @WithTryCatchRuntime
    public int[] updateModuleData(ModuleData.DataBean dataBean) {
        return (int[]) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.o1.c(new Object[]{this, dataBean, r.a.c.c.e.w(r, this, this, dataBean)}).e(69648));
    }
}
