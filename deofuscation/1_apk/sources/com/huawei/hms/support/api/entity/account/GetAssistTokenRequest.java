package com.huawei.hms.support.api.entity.account;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GetAssistTokenRequest {
    private String a;
    private String b;
    private String c;

    public GetAssistTokenRequest(String str) {
        this.a = str;
    }

    public String getSessionId() {
        return this.c;
    }

    public String getUserIdentify() {
        return this.b;
    }

    public void setSessionId(String str) {
        this.c = str;
    }

    public void setUserIdentify(String str) {
        this.b = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.a)) {
            jSONObject.putOpt("accessToken", this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            jSONObject.putOpt(CommonConstant.KEY_USER_IDENTIFY, this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            jSONObject.putOpt("sessionId", this.c);
        }
        return jSONObject.toString();
    }
}
