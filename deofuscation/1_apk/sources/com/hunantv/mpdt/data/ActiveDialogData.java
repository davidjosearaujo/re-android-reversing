package com.hunantv.mpdt.data;

import com.alibaba.fastjson.JSONObject;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.hunantv.imgo.net.RequestParams;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ActiveDialogData extends CommonData {
    private static final String CLICK = "3";
    private static final String CLOSE = "4";
    private static final String PV = "2";
    private static final long serialVersionUID = -1558910783801634384L;
    public String bz = "";

    public RequestParams getClickParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("cpn", a.a().i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cpn", (Object) a.a().i);
        jSONObject.put("evt", (Object) "3");
        jSONObject.put("bz", (Object) this.bz);
        createBaseRequestParams.put(SDKConstants.PARAM_VALUE, jSONObject.toJSONString());
        return createBaseRequestParams;
    }

    public RequestParams getCloseParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("cpn", a.a().i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cpn", (Object) a.a().i);
        jSONObject.put("evt", (Object) "4");
        jSONObject.put("bz", (Object) this.bz);
        createBaseRequestParams.put(SDKConstants.PARAM_VALUE, jSONObject.toJSONString());
        return createBaseRequestParams;
    }

    public RequestParams getPvParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("cpn", a.a().i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cpn", (Object) a.a().i);
        jSONObject.put("evt", (Object) "2");
        jSONObject.put("bz", (Object) this.bz);
        createBaseRequestParams.put(SDKConstants.PARAM_VALUE, jSONObject.toJSONString());
        return createBaseRequestParams;
    }
}
