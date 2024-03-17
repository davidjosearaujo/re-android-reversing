package com.huawei.hms.hwid;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HuaweiIdCpClientInfo.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class s extends am {
    public static s a(String str) throws JSONException {
        return new s().a(new JSONObject(str));
    }

    public s a(JSONObject jSONObject) {
        this.a = jSONObject.optString("appId", null);
        this.b = jSONObject.optString(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, null);
        this.c = jSONObject.optLong("hmsSdkVersion");
        this.d = jSONObject.optString("subAppId", null);
        return this;
    }
}
