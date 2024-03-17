package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RevokeAccessResult extends Result {
    private static final String TAG = "[HUAWEIIDSDK]RevokeAccessResult";
    @Packed
    private Integer errorCode;
    @Packed
    private String errorMsg;

    public RevokeAccessResult() {
    }

    private void jsonToSuper(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("status");
        if (optJSONObject != null) {
            setStatus(new Status(optJSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT), optJSONObject.optString("statusMessage", null)));
        }
    }

    public RevokeAccessResult fromJson(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        jsonToSuper(new JSONObject(str));
        return this;
    }

    public RevokeAccessResult getBeanFromJsonStr(String str) {
        as.b(TAG, "getBeanFromJsonStr begin.", true);
        boolean isEmpty = TextUtils.isEmpty(str);
        Integer valueOf = Integer.valueOf((int) CommonConstant.RETCODE.SIGN_IN_PARAMS_ERROR);
        if (isEmpty) {
            return new RevokeAccessResult(valueOf, "body is empty");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Integer valueOf2 = jSONObject.has("errorCode") ? Integer.valueOf(jSONObject.getInt("errorCode")) : null;
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                return new RevokeAccessResult();
            }
            return new RevokeAccessResult(valueOf2, jSONObject.optString("errorMsg"));
        } catch (JSONException unused) {
            as.d(TAG, "JSONException", true);
            return new RevokeAccessResult(valueOf, "JSONException");
        }
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    public void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public RevokeAccessResult(Integer num, String str) {
        this.errorCode = num;
        this.errorMsg = str;
    }

    public RevokeAccessResult(Status status) {
        setStatus(status);
    }
}
