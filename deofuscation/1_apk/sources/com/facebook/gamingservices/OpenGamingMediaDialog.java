package com.facebook.gamingservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphRequest$OnProgressCallback;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import j.l.c.e0.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class OpenGamingMediaDialog implements GraphRequest$OnProgressCallback {
    private Context context;
    private GraphRequest$Callback nestedCallback;

    public OpenGamingMediaDialog(Context context) {
        this(context, null);
    }

    @Override // com.facebook.GraphRequest$Callback
    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest$Callback graphRequest$Callback = this.nestedCallback;
        if (graphRequest$Callback != null) {
            graphRequest$Callback.onCompleted(graphResponse);
        }
        if (graphResponse == null || graphResponse.getError() != null) {
            return;
        }
        String optString = graphResponse.getJSONObject().optString("id", null);
        String optString2 = graphResponse.getJSONObject().optString("video_id", null);
        if (optString == null && optString2 == null) {
            return;
        }
        if (optString == null) {
            optString = optString2;
        }
        if (CloudGameLoginHandler.isRunningInCloud()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", optString);
                jSONObject.put(SDKConstants.PARAM_DEEP_LINK, "MEDIA_ASSET");
                DaemonRequest.executeAsync(this.context, jSONObject, (DaemonRequest.Callback) null, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("https://fb.gg/me/media_asset/" + optString));
        Context context = this.context;
        a.h(intent);
        context.startActivity(intent);
    }

    @Override // com.facebook.GraphRequest$OnProgressCallback
    public void onProgress(long j, long j2) {
        GraphRequest$Callback graphRequest$Callback = this.nestedCallback;
        if (graphRequest$Callback == null || !(graphRequest$Callback instanceof GraphRequest$OnProgressCallback)) {
            return;
        }
        ((GraphRequest$OnProgressCallback) graphRequest$Callback).onProgress(j, j2);
    }

    public OpenGamingMediaDialog(Context context, GraphRequest$Callback graphRequest$Callback) {
        this.context = context;
        this.nestedCallback = graphRequest$Callback;
    }
}
