package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReadSmsService.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class aj extends HuaweiApi<Api.ApiOptions.NoOptions> {
    public aj(Activity activity, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(activity, api, noOptions, abstractClientBuilder);
    }

    private af b() {
        return new af(getContext().getPackageName());
    }

    public j.k.b.a.l<Void> a() {
        String a = b().a();
        if (TextUtils.isEmpty(a)) {
            j.k.b.a.m mVar = new j.k.b.a.m();
            mVar.c(new ApiException(new Status(CommonConstant.RETCODE.SMS_RETRIEVER_PARAM_FAILED, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return mVar.b();
        }
        return doWrite(new ak(CommonNaming.startSmsRetriever, a, HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startSmsRetriever, 60400300)));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 1;
    }

    public aj(Context context, Api<Api.ApiOptions.NoOptions> api, Api.ApiOptions.NoOptions noOptions, AbstractClientBuilder abstractClientBuilder) {
        super(context, api, noOptions, abstractClientBuilder);
    }

    public j.k.b.a.l<Void> a(String str) {
        as.b("ReadSmsService", "startConsent enter", true);
        if (str != null && str.length() > 120) {
            j.k.b.a.m mVar = new j.k.b.a.m();
            mVar.c(new ApiException(new Status(CommonConstant.RETCODE.SMS_RETRIEVER_PARAM_FAILED, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return mVar.b();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, getContext().getPackageName());
            jSONObject.put("phoneNumber", str);
        } catch (JSONException unused) {
            as.d("ReadSmsService", "toJson failed", true);
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            j.k.b.a.m mVar2 = new j.k.b.a.m();
            mVar2.c(new ApiException(new Status(CommonConstant.RETCODE.SMS_RETRIEVER_PARAM_FAILED, CommonConstant.RETCODE.SMS_PARAM_ERROR)));
            return mVar2.b();
        }
        return doWrite(new al(CommonNaming.startConsent, jSONObject.toString(), HiAnalyticsClient.reportEntry(getContext(), CommonNaming.startConsent, 60400300)));
    }
}
