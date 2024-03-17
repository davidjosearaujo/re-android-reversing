package com.facebook.gamingservices.cloudgaming;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* compiled from: AppToUserNotificationSender.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MediaUploadCallback implements GraphRequest$Callback {
    private String body;
    public GraphRequest$Callback callback;
    @Nullable
    private String payload;
    private int timeInterval;
    private String title;

    public MediaUploadCallback(String str, String str2, int i, @Nullable String str3, GraphRequest$Callback graphRequest$Callback) {
        this.title = str;
        this.body = str2;
        this.timeInterval = i;
        this.payload = str3;
        this.callback = graphRequest$Callback;
    }

    @Override // com.facebook.GraphRequest$Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (graphResponse.getError() == null) {
            String optString = graphResponse.getJSONObject().optString("id");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString("title", this.title);
            bundle.putString(SDKConstants.PARAM_A2U_BODY, this.body);
            bundle.putInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, this.timeInterval);
            String str = this.payload;
            if (str != null) {
                bundle.putString(SDKConstants.PARAM_A2U_PAYLOAD, str);
            }
            bundle.putString(SDKConstants.PARAM_A2U_MEDIA_ID, optString);
            new GraphRequest(currentAccessToken, SDKConstants.PARAM_A2U_GRAPH_PATH, bundle, HttpMethod.POST, this.callback).executeAsync();
            return;
        }
        throw new FacebookException(graphResponse.getError().getErrorMessage());
    }
}
