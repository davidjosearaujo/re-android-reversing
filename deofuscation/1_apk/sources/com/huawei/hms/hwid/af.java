package com.huawei.hms.hwid;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReadSmsInputBean.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class af {
    private String a;

    public af() {
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, this.a);
            return jSONObject.toString();
        } catch (JSONException unused) {
            as.d("ReadSmsInputBean", "toJson failed", true);
            return null;
        }
    }

    public af(String str) {
        this.a = str;
    }
}
