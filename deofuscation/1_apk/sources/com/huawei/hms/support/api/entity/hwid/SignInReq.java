package com.huawei.hms.support.api.entity.hwid;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.hwid.as;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SignInReq implements IMessageEntity {
    private static final String KEY_DYNAMIC_PERMISSIONS = "dynamicpermissions";
    private static final String KEY_SCOPES = "scopes";
    private static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String TAG = "[SignInReq]SignInReq";
    @Packed
    public String mLocalJsonObject;

    public SignInReq() {
    }

    private JSONObject getJsonObj() {
        if (this.mLocalJsonObject == null) {
            return null;
        }
        try {
            return new JSONObject(this.mLocalJsonObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    public List<String> getPermissionInfos() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj == null) {
            return new ArrayList(0);
        }
        try {
            JSONArray jSONArray = jsonObj.getJSONArray(KEY_DYNAMIC_PERMISSIONS);
            if (jSONArray != null && jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                return arrayList;
            }
            return new ArrayList(0);
        } catch (JSONException unused) {
            return new ArrayList(0);
        }
    }

    public List<String> getScopes() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj == null) {
            return new ArrayList(0);
        }
        try {
            JSONArray jSONArray = jsonObj.getJSONArray(KEY_SCOPES);
            if (jSONArray != null && jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                return arrayList;
            }
            return new ArrayList(0);
        } catch (JSONException unused) {
            return new ArrayList(0);
        }
    }

    public String getSignInParams() {
        JSONObject jsonObj = getJsonObj();
        return jsonObj == null ? "" : jsonObj.optString(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS);
    }

    public SignInReq(Set<String> set, Set<String> set2) {
        this(set, set2, "");
    }

    public SignInReq(Set<String> set, Set<String> set2, String str) {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : set) {
            jSONArray.put(str2);
        }
        JSONArray jSONArray2 = new JSONArray();
        for (String str3 : set2) {
            jSONArray2.put(str3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_SCOPES, jSONArray);
            jSONObject.put(KEY_DYNAMIC_PERMISSIONS, jSONArray2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(CommonConstant.RequestParams.KEY_SIGN_IN_PARAMS, str);
            }
            jSONObject.put(KEY_SDK_VERSION, 60400300);
            this.mLocalJsonObject = jSONObject.toString();
        } catch (JSONException unused) {
            as.d(TAG, "SignInReq JSONException", true);
            this.mLocalJsonObject = new JSONObject().toString();
        }
    }
}
