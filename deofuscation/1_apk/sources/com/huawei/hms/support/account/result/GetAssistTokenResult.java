package com.huawei.hms.support.account.result;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.AbstractAuthResult;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GetAssistTokenResult extends AbstractAuthResult {
    private String assistToken;

    public GetAssistTokenResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        JSONObject jSONObject = new JSONObject(str);
        this.assistToken = jSONObject.getString(CommonConstant.KEY_ASSIST_TOKEN);
        jsonToSuper(jSONObject);
        return this;
    }

    public String getAssistToken() {
        return this.assistToken;
    }
}
