package com.hunantv.mpdt.statistics.recommand;

import android.content.Context;
import androidx.annotation.Nullable;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.data.RecommendData;
import com.mgtv.json.JsonInterface;
import com.mgtv.task.http.HttpCallBack;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.e;
import j.l.a.b0.f0;
import j.v.r.r;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RecommendEvent extends j.l.b.e.a {
    private static final String e = "https://guids.api.mgtv.com/mobile/distribute.do";
    private static volatile RecommendEvent f;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class GUID implements JsonInterface {
        private static final long serialVersionUID = 8967225107410299807L;
        public String data;
        public int status;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends HttpCallBack<GUID> {
        public void l(int i, int i2, @Nullable String str, @Nullable Throwable th) {
        }

        /* renamed from: u */
        public void previewCache(GUID guid) {
        }

        /* renamed from: v */
        public void success(GUID guid) {
            if (guid != null) {
                f0.y("recommend_guid", guid.data);
            }
        }
    }

    private RecommendEvent(Context context) {
        super(context);
        ((j.l.b.e.a) this).c = context;
    }

    public static RecommendEvent c(Context context) {
        if (f == null) {
            synchronized (RecommendEvent.class) {
                if (f == null) {
                    f = new RecommendEvent(context.getApplicationContext());
                }
            }
        }
        return f;
    }

    public static void d(r rVar) {
        if (rVar == null) {
            return;
        }
        HttpParams httpParams = new HttpParams();
        httpParams.put("deviceid", e.x());
        rVar.n(true).u(e, httpParams, new a());
    }

    private void e(String str, String str2, String str3, String str4, int i, String str5, int i2, String str6, int i3, int i4, int i5, String str7, String str8) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", i);
        requestParams.put("rcdata", str4);
        requestParams.put("hitid", str5);
        requestParams.put("pos", i2);
        requestParams.put("videoid", str6);
        requestParams.put("cid", i4);
        requestParams.put("vidauto", i3);
        requestParams.put("rctype", i5);
        requestParams.put("mdname", str7);
        requestParams.put("zxdata", str8);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    private void f(String str, String str2, String str3, String str4, int i, String str5, int i2, String str6, String str7, String str8, String str9) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", i);
        requestParams.put("rcdata", str4);
        requestParams.put("hitid", str5);
        requestParams.put("pos", i2 + 1);
        requestParams.put("videoid", str6);
        requestParams.put("vidauto", str7);
        if (str8 == null) {
            str8 = "";
        }
        requestParams.put("cid", str8);
        requestParams.put("rctype", str9);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    private void g(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", i);
        requestParams.put("rcdata", str4);
        requestParams.put("videoid", str5);
        requestParams.put("vidauto", str6);
        if (str7 == null) {
            str7 = "0";
        }
        requestParams.put("cid", str7);
        requestParams.put("rctype", str8);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void h(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        g("bdrelatepv", str, str2, str3, 6, str4, str5, str6, str7);
    }

    public void i(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", "change");
        requestParams.put("uuid", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("ch", str4);
        requestParams.put("region", 1);
        requestParams.put("mdname", "interest");
        requestParams.put("zxdata", str5);
        requestParams.put("videoid", str6);
        requestParams.put("vidauto", str7);
        requestParams.put("cid", str8);
        requestParams.put("rctype", str9);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void j(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        f("recommended", str, str2, str3, 2, str4, i, str5, str6, str7, str8);
    }

    public void k(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, int i, String str8) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", "recommend_hot");
        requestParams.put("uuid", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", 7);
        requestParams.put("rcdata", str4);
        requestParams.put("hitid", str5);
        requestParams.put("ch", str6);
        requestParams.put("pos", str7);
        requestParams.put("videoid", "");
        requestParams.put("vidauto", "");
        requestParams.put("cid", i);
        requestParams.put("rctype", str8);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void l(String str, String str2, String str3, String str4, String str5, String str6, int i, boolean z, String str7, String str8) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", "recommend_hot");
        requestParams.put("uuid", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", 1);
        requestParams.put("rcdata", str4);
        requestParams.put("hitid", str5);
        requestParams.put("ch", str6);
        requestParams.put("pos", i);
        requestParams.put("videoid", "");
        requestParams.put("vidauto", "");
        if (str7 == null) {
            str7 = "";
        }
        requestParams.put("cid", str7);
        requestParams.put("rctype", str8);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void m(String str, String str2, String str3, String str4, boolean z, int i, String str5) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", "hotpv");
        requestParams.put("uuid", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("region", 7);
        requestParams.put("rcdata", str4);
        requestParams.put("videoid", "");
        requestParams.put("vidauto", "");
        requestParams.put("cid", i);
        requestParams.put("rctype", str5);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void n(String str, String str2, String str3, String str4, String str5) {
        g("hotpv", str, str2, str3, 1, "", "", str4, str5);
    }

    public void o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        g("interestpv", str, str2, str3, 1, str4, str5, str6, str7);
    }

    public void p(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, int i2, String str7, String str8) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("act", "more");
        requestParams.put("uuid", str);
        requestParams.put("ver", str2);
        requestParams.put("reqid", str3);
        requestParams.put("ch", str4);
        requestParams.put("region", 1);
        requestParams.put("mdname", str8);
        requestParams.put("zxdata", str5);
        requestParams.put("videoid", str6);
        requestParams.put("vidauto", i);
        requestParams.put("cid", i2);
        requestParams.put("rctype", str7);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void q(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        f("bdrecommend_rel", str, str2, str3, 6, str4, i, str5, str6, str7, str8);
    }

    public void r(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        g("relatepv", str, str2, str3, 2, str4, str5, str6, str7);
    }

    public void s(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        g("interestpv", str, str2, str3, 5, str4, str5, str6, str7);
    }

    public void t(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f("recommend_user", str, str2, str3, 5, str4, i, "", "", str5, str6);
    }

    public void u(boolean z, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("bid", "2.2.0");
        requestParams.put("act", "recommended_user");
        requestParams.put("hitid", str);
        requestParams.put("rcdata", str2);
        requestParams.put("region", 9);
        requestParams.put("reqid", str4);
        requestParams.put("ver", str3);
        requestParams.put("pos", str5);
        requestParams.put("videoid", "");
        requestParams.put("vidauto", "");
        requestParams.put("cid", i);
        requestParams.put("rctype", str6);
        requestParams.put("ctxt", str7);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void v(boolean z, String str, String str2, String str3, int i, String str4) {
        RequestParams requestParams = new RecommendData().getRequestParams();
        requestParams.put("bid", "2.2.0");
        requestParams.put("act", "interestpv");
        requestParams.put("ver", str);
        requestParams.put("reqid", str2);
        requestParams.put("region", 9);
        requestParams.put("rcdata", str3);
        requestParams.put("videoid", "");
        requestParams.put("vidauto", "");
        requestParams.put("cid", i);
        requestParams.put("rctype", str4);
        ((j.l.b.e.a) this).a.b("https://rc.log.mgtv.com/rpt", requestParams);
    }

    public void w(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        f("recommended_series", str, str2, str3, 2, str4, i, str5, str6, str7, str8);
    }

    public void x(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        g("seriespv", str, str2, str3, 2, str4, str5, str6, str7);
    }

    public void y(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        f("recommend_user", str, str2, str3, 1, str4, i, "", "", str5, str6);
    }
}
