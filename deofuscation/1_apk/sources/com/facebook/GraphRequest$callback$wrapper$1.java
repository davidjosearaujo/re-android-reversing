package com.facebook;

import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import n.b0;
import n.l2.v.f0;
import org.json.JSONArray;
import org.json.JSONObject;
import r.e.a.d;

/* compiled from: GraphRequest.kt */
@b0(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class GraphRequest$callback$wrapper$1 implements GraphRequest$Callback {
    public final /* synthetic */ GraphRequest$Callback $callback;

    public GraphRequest$callback$wrapper$1(GraphRequest$Callback graphRequest$Callback) {
        this.$callback = graphRequest$Callback;
    }

    @Override // com.facebook.GraphRequest$Callback
    public final void onCompleted(@d GraphResponse graphResponse) {
        f0.p(graphResponse, "response");
        JSONObject jSONObject = graphResponse.getJSONObject();
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
        JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                String optString = optJSONObject2 != null ? optJSONObject2.optString("message") : null;
                String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                String optString3 = optJSONObject2 != null ? optJSONObject2.optString("link") : null;
                if (optString != null && optString2 != null) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if (f0.g(optString2, "warning")) {
                        loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!Utility.isNullOrEmpty(optString3)) {
                        optString = optString + " Link: " + optString3;
                    }
                    Logger.Companion.log(loggingBehavior, GraphRequest.TAG, optString);
                }
            }
        }
        GraphRequest$Callback graphRequest$Callback = this.$callback;
        if (graphRequest$Callback != null) {
            graphRequest$Callback.onCompleted(graphResponse);
        }
    }
}
