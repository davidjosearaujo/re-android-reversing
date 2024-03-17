package com.hunantv.oversea.channel.dynamic.style;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.hunantv.oversea.channel.dynamic.style.xml.MixedDynamicStyleResponse;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.a.r.a;
import j.l.c.c.c.w1.b;
import j.v.g.i.d;
import j.v.g.i.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StyleMap implements b {
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;
    private Map<String, d> a = new HashMap();
    private Map<String, h> b = new HashMap();

    static {
        d();
    }

    private static /* synthetic */ void d() {
        e eVar = new e("StyleMap.java", StyleMap.class);
        c = eVar.H("method-execution", eVar.E("9", "putDiskCache", "com.hunantv.oversea.channel.dynamic.style.StyleMap", "java.lang.String:com.hunantv.oversea.channel.dynamic.style.xml.MixedDynamicStyleResponse", "key:data", "", "void"), 100);
        d = eVar.H("method-execution", eVar.E("9", "getDiskCache", "com.hunantv.oversea.channel.dynamic.style.StyleMap", "java.lang.String", SDKConstants.PARAM_KEY, "", "com.hunantv.oversea.channel.dynamic.style.xml.MixedDynamicStyleResponse"), 112);
    }

    @WithTryCatchRuntime
    public static MixedDynamicStyleResponse getDiskCache(String str) {
        return (MixedDynamicStyleResponse) LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.w1.d(new Object[]{str, e.w(d, (Object) null, (Object) null, str)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public static final /* synthetic */ MixedDynamicStyleResponse j(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c2 = a.d().c(str);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        return (MixedDynamicStyleResponse) j.v.j.b.u(c2, MixedDynamicStyleResponse.class);
    }

    public static final /* synthetic */ void l(String str, MixedDynamicStyleResponse mixedDynamicStyleResponse, c cVar) {
        if (TextUtils.isEmpty(str) || mixedDynamicStyleResponse == null || TextUtils.isEmpty(j.v.j.b.E(mixedDynamicStyleResponse))) {
            return;
        }
        a.d().g(str, j.v.j.b.E(mixedDynamicStyleResponse));
    }

    @WithTryCatchRuntime
    public static void putDiskCache(String str, MixedDynamicStyleResponse mixedDynamicStyleResponse) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.c.c.c.w1.c(new Object[]{str, mixedDynamicStyleResponse, e.x(c, (Object) null, (Object) null, str, mixedDynamicStyleResponse)}).e((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
    }

    public d a(String str) {
        return this.a.get(str);
    }

    public List<Integer> c(String str) {
        d dVar = this.a.get(str);
        if (dVar == null) {
            return null;
        }
        return dVar.n;
    }

    public void e(List<MixedDynamicStyleResponse.DSLEntity> list, j.l.c.c.c.w1.a aVar) {
        d b;
        String str;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (MixedDynamicStyleResponse.DSLEntity dSLEntity : list) {
                if (dSLEntity.dslXml != null && !TextUtils.isEmpty(dSLEntity.layoutID) && (b = j.v.g.m.e.b(dSLEntity.dslXml)) != null) {
                    if (b instanceof h) {
                        h hVar = (h) b;
                        this.b.put(hVar.a, hVar);
                    } else if (b instanceof d) {
                        d dVar = b;
                        dVar.a = dSLEntity.layoutID;
                        String str2 = dSLEntity.ver;
                        dVar.c = str2;
                        if (TextUtils.isEmpty(str2)) {
                            dVar.c = String.valueOf(System.currentTimeMillis());
                        }
                        d dVar2 = this.a.get(dSLEntity.layoutID);
                        if (dVar2 != null && (str = dVar2.c) != null) {
                            if (!str.equals(dVar.c)) {
                                this.a.put(dSLEntity.layoutID, dVar);
                                arrayList.add(dVar.a);
                            }
                        } else {
                            this.a.put(dSLEntity.layoutID, dVar);
                            arrayList.add(dVar.a);
                        }
                    }
                }
            }
        }
        if (aVar != null) {
            if (arrayList.isEmpty()) {
                aVar.onComplete();
                return;
            }
            aVar.a(arrayList);
            aVar.onComplete();
        }
    }

    public Map<String, d> getMap() {
        return this.a;
    }

    public boolean isEmpty() {
        Map<String, d> map = this.a;
        return map == null || map.isEmpty();
    }

    /* renamed from: k */
    public h f(String str) {
        return this.b.get(str);
    }

    public int size() {
        Map<String, d> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
