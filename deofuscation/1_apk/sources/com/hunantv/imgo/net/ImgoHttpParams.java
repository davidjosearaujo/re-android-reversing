package com.hunantv.imgo.net;

import com.alibaba.android.arouter.utils.Consts;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.hunantv.imgo.global.AgeDataModel;
import com.mgtv.task.http.HttpParams;
import j.l.a.b0.e;
import j.l.a.b0.x;
import j.l.a.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoHttpParams extends HttpParams {
    public static final String VALUE_INVOKER = "hunantvphone";
    public static final String VALUE_INVOKER_TEST = "phone_test";
    public static int VALUE_PRE = 0;
    private static final long serialVersionUID = -1810049085947010904L;

    public ImgoHttpParams() {
        put("device", e.Q());
        put("osVersion", e.Y());
        put("appVersion", e.B0());
        put("androidPatch", e.G0());
        put("ticket", e.t0());
        put("userId", String.valueOf(e.x0()));
        put("did", e.x());
        put("mac", e.x());
        put("osType", "android");
        put("channel", e.n());
        put("uuid", e.v0());
        put("endType", "mgtvapp");
        put("oaid", e.U());
        put("ageMode", Integer.valueOf(AgeDataModel.b().a().ordinal()));
        put("seqId", x.k(e.x() + Consts.DOT + System.currentTimeMillis()));
        put("version", e.B0());
        put("type", Integer.valueOf(b.d()));
        put("abroad", b.b());
        put("src", e.g0());
        put(CommonConstant.KEY_UID, e.v0());
        put("version", "5.2");
        put("phonetype", e.Q());
        put("testversion", e.i());
        int i = VALUE_PRE;
        if (i > 0) {
            put("pre", Integer.valueOf(i));
        }
    }
}
