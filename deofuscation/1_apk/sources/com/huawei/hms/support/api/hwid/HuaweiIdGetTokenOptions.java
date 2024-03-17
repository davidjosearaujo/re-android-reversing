package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HuaweiIdGetTokenOptions {
    private String a;
    private boolean b;

    public HuaweiIdGetTokenOptions(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static HuaweiIdGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new HuaweiIdGetTokenOptions(jSONObject.optString("accountName"), Boolean.getBoolean(jSONObject.optString("fromGetToken")));
    }

    public String getAccountName() {
        return this.a;
    }

    public boolean isFromGetToken() {
        return this.b;
    }

    public void setAccountName(String str) {
        this.a = str;
    }

    public void setFromGetToken(boolean z) {
        this.b = z;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.a)) {
            jSONObject.put("accountName", this.a);
        }
        jSONObject.put("fromGetToken", this.b);
        return jSONObject;
    }
}
