package com.hunantv.mpdt.statistics.dataverify;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.data.VodAPlayData;
import com.hunantv.oversea.report.ReportManager;
import com.mgtv.crashhandler.aop.LibTryCatchRuntimeAspect;
import com.mgtv.crashhandler.aop.WithTryCatchRuntime;
import j.l.b.e.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import r.a.b.c;
import r.a.c.c.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommonDataVerifyReporter {
    private static final /* synthetic */ c.b b = null;
    private static final /* synthetic */ c.b c = null;
    private static final /* synthetic */ c.b d = null;
    private final j.l.b.g.c a;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b {
        private static final CommonDataVerifyReporter a = new CommonDataVerifyReporter();

        private b() {
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class c extends g {
        private c() {
        }

        public void e(int i, int i2, String str, Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put(JThirdPlatFormInterface.KEY_CODE, String.valueOf(i));
            j.l.b.e.h.d.c(hashMap);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class d extends g {
        private d() {
        }

        public void e(int i, int i2, String str, Throwable th) {
            HashMap hashMap = new HashMap();
            hashMap.put(JThirdPlatFormInterface.KEY_CODE, String.valueOf(i));
            j.l.b.e.h.d.e(hashMap);
        }
    }

    static {
        a();
    }

    private static /* synthetic */ void a() {
        e eVar = new e("CommonDataVerifyReporter.java", CommonDataVerifyReporter.class);
        b = eVar.H("method-execution", eVar.E("1", "reportPvEvent", "com.hunantv.mpdt.statistics.dataverify.CommonDataVerifyReporter", "java.lang.String:com.hunantv.imgo.net.RequestParams", "cpn:sourceParams", "", "void"), 85);
        c = eVar.H("method-execution", eVar.E("1", "reportVvEvent", "com.hunantv.mpdt.statistics.dataverify.CommonDataVerifyReporter", "java.util.Map", "paramsMap", "", "void"), (int) Opcodes.IF_ACMPEQ);
        d = eVar.H("method-execution", eVar.E("1", "reportVvEvent", "com.hunantv.mpdt.statistics.dataverify.CommonDataVerifyReporter", "com.hunantv.mpdt.data.VodAPlayData", "data", "", "void"), (int) Opcodes.INSTANCEOF);
    }

    private VerifyDataExtend b(Map<String, String> map) {
        VerifyDataExtend verifyDataExtend = new VerifyDataExtend();
        verifyDataExtend.setEvent_name("vv");
        verifyDataExtend.setProject("mgtv-media");
        String str = map.get("ap");
        if (TextUtils.isDigitsOnly(str)) {
            verifyDataExtend.setAuto_play(Integer.parseInt(str));
        }
        verifyDataExtend.setSuuid(map.get("suuid"));
        verifyDataExtend.setVid(map.get("vid"));
        verifyDataExtend.setPlid(map.get("plid"));
        verifyDataExtend.setPt(map.get("pt"));
        verifyDataExtend.setCpt(map.get("cpn"));
        verifyDataExtend.setFpt(map.get("fpa"));
        verifyDataExtend.setBdid(map.get("bdid"));
        verifyDataExtend.setBsid("");
        verifyDataExtend.setIsad(map.get("isad"));
        verifyDataExtend.setDefinition("");
        verifyDataExtend.setPay_play(map.get("pay"));
        verifyDataExtend.setIsdrm("");
        verifyDataExtend.setAcp(map.get("acp"));
        verifyDataExtend.setIstry(map.get("istry"));
        verifyDataExtend.setCntp(ReportManager.b().a);
        verifyDataExtend.setLastp(ReportManager.b().b);
        verifyDataExtend.setCpid(j.l.c.x.t0.a.a().m);
        verifyDataExtend.setFpid(j.l.c.x.t0.a.a().A);
        return verifyDataExtend;
    }

    private VerifyDataExtend c(VodAPlayData vodAPlayData) {
        VerifyDataExtend verifyDataExtend = new VerifyDataExtend();
        verifyDataExtend.setEvent_name("vv");
        verifyDataExtend.setProject("mgtv-media");
        verifyDataExtend.setAuto_play(vodAPlayData.getAp());
        verifyDataExtend.setSuuid(vodAPlayData.getSuuid());
        verifyDataExtend.setVid(vodAPlayData.getVid());
        verifyDataExtend.setPlid(vodAPlayData.getPlid());
        verifyDataExtend.setPt(String.valueOf(vodAPlayData.getPt()));
        verifyDataExtend.setCpt(vodAPlayData.getCpn());
        verifyDataExtend.setFpt(vodAPlayData.getFpa());
        verifyDataExtend.setBdid(vodAPlayData.getBdid());
        verifyDataExtend.setBsid(vodAPlayData.getBsid());
        verifyDataExtend.setIsad(String.valueOf(vodAPlayData.getIsad()));
        verifyDataExtend.setDefinition(String.valueOf(vodAPlayData.getDef()));
        verifyDataExtend.setPay_play(String.valueOf(vodAPlayData.getPay()));
        verifyDataExtend.setIsdrm(String.valueOf(vodAPlayData.getIsdrm()));
        verifyDataExtend.setAcp(String.valueOf(vodAPlayData.getAcp()));
        verifyDataExtend.setIstry(String.valueOf(vodAPlayData.getIstry()));
        verifyDataExtend.setCntp(ReportManager.b().a);
        verifyDataExtend.setLastp(ReportManager.b().b);
        verifyDataExtend.setCpid(j.l.c.x.t0.a.a().m);
        verifyDataExtend.setFpid(j.l.c.x.t0.a.a().A);
        return verifyDataExtend;
    }

    public static CommonDataVerifyReporter d() {
        return b.a;
    }

    private g e() {
        return new c();
    }

    private g g() {
        return new d();
    }

    private boolean h(String str) {
        return TextUtils.equals(str, "1") || TextUtils.equals(str, "40") || TextUtils.equals(str, "19");
    }

    private void i(String str, String str2, boolean z, boolean z2, g gVar) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("bid", "31.1.1");
        requestParams.put(z2 ? "show_content" : "data", str2);
        this.a.A(str, requestParams, z, gVar);
    }

    public static final /* synthetic */ void k(CommonDataVerifyReporter commonDataVerifyReporter, String str, RequestParams requestParams, r.a.b.c cVar) {
        HashMap<String, String> paramsMap;
        if (!commonDataVerifyReporter.h(str) || requestParams == null || (paramsMap = requestParams.getParamsMap()) == null) {
            return;
        }
        VerifyDataExtend verifyDataExtend = new VerifyDataExtend();
        verifyDataExtend.setEvent_name("page");
        verifyDataExtend.setProject("mgtv-media");
        String str2 = paramsMap.get("cpid");
        if (TextUtils.equals(str, "1")) {
            verifyDataExtend.setCntp("ch_channel");
        } else if (TextUtils.equals(str, "40")) {
            verifyDataExtend.setVid(str2);
            verifyDataExtend.setCntp("v_play");
        } else if (TextUtils.equals(str, "19")) {
            verifyDataExtend.setCntp("so_result");
        }
        verifyDataExtend.setPlid(paramsMap.get("plid"));
        verifyDataExtend.setBdid(paramsMap.get("bdid"));
        verifyDataExtend.setBsid(paramsMap.get("bsid"));
        verifyDataExtend.setFtl(paramsMap.get("ftl"));
        verifyDataExtend.setCtl(paramsMap.get("ctl"));
        verifyDataExtend.setIsfull(paramsMap.get("isfull"));
        verifyDataExtend.setLastp(ReportManager.b().a);
        verifyDataExtend.setCpid(str2);
        verifyDataExtend.setFpid(paramsMap.get("fpid"));
        if (j.l.b.e.h.d.a()) {
            verifyDataExtend.setIs_third(1);
        }
        String d2 = j.v.j.b.d(verifyDataExtend.generatePvRequestParams().getParamsMap());
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        j.l.b.e.h.d.b();
        commonDataVerifyReporter.i(commonDataVerifyReporter.f(), d2, false, false, commonDataVerifyReporter.e());
    }

    public static final /* synthetic */ void l(CommonDataVerifyReporter commonDataVerifyReporter, Map map, r.a.b.c cVar) {
        if (map == null || map.size() == 0 || !TextUtils.equals("0", (CharSequence) map.get("pt"))) {
            return;
        }
        VerifyDataExtend b2 = commonDataVerifyReporter.b(map);
        if (j.l.b.e.h.d.a()) {
            b2.setIs_third(1);
        }
        String d2 = j.v.j.b.d(b2.generateRequestParams().getParamsMap());
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        j.l.b.e.h.d.d();
        commonDataVerifyReporter.i(commonDataVerifyReporter.f(), d2, true, false, commonDataVerifyReporter.g());
    }

    public static final /* synthetic */ void m(CommonDataVerifyReporter commonDataVerifyReporter, VodAPlayData vodAPlayData, r.a.b.c cVar) {
        if (vodAPlayData == null || vodAPlayData.getPt() != 0) {
            return;
        }
        VerifyDataExtend c2 = commonDataVerifyReporter.c(vodAPlayData);
        if (j.l.b.e.h.d.a()) {
            c2.setIs_third(1);
        }
        String d2 = j.v.j.b.d(c2.generateRequestParams().getParamsMap());
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        j.l.b.e.h.d.d();
        commonDataVerifyReporter.i(commonDataVerifyReporter.f(), d2, true, false, commonDataVerifyReporter.g());
    }

    public String f() {
        return "https://mm.log.mgtv.com/s.gif";
    }

    public void j(String str) {
        if (str == null || str.trim().equals("")) {
            return;
        }
        try {
            List<VodAPlayData> t = j.v.j.b.t(str, VodAPlayData.class);
            ArrayList arrayList = new ArrayList();
            if (t == null || t.size() <= 0) {
                return;
            }
            for (VodAPlayData vodAPlayData : t) {
                if (vodAPlayData != null) {
                    arrayList.add(c(vodAPlayData).generateRequestParams().getParamsMap());
                }
            }
            if (arrayList.size() > 0) {
                i(f(), j.v.j.b.d(arrayList), true, true, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @WithTryCatchRuntime
    public void reportPvEvent(String str, RequestParams requestParams) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.h.a(new Object[]{this, str, requestParams, e.x(b, this, this, str, requestParams)}).e(69648));
    }

    @WithTryCatchRuntime
    public void reportVvEvent(Map<String, String> map) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.h.b(new Object[]{this, map, e.w(c, this, this, map)}).e(69648));
    }

    private CommonDataVerifyReporter() {
        this.a = j.l.b.g.c.f();
    }

    @WithTryCatchRuntime
    public void reportVvEvent(VodAPlayData vodAPlayData) {
        LibTryCatchRuntimeAspect.aspectOf().excuteWithTryCatch(new j.l.b.e.h.c(new Object[]{this, vodAPlayData, e.w(d, this, this, vodAPlayData)}).e(69648));
    }
}
