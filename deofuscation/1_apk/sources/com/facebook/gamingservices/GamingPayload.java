package com.facebook.gamingservices;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class GamingPayload {
    private static final String KEY_APPLINK_DATA = "al_applink_data";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_GAME_REQUEST_ID = "game_request_id";
    private static final String KEY_PAYLOAD = "payload";
    private static final String TAG = "GamingPayload";
    private static Map<String, String> payloadData;

    private GamingPayload() {
    }

    @Nullable
    public static String getGameRequestID() {
        Map<String, String> map = payloadData;
        if (map == null) {
            return null;
        }
        return map.getOrDefault(KEY_GAME_REQUEST_ID, null);
    }

    @Nullable
    public static String getPayload() {
        Map<String, String> map = payloadData;
        if (map == null) {
            return null;
        }
        return map.getOrDefault("payload", null);
    }

    public static void loadPayloadFromCloudGame(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hashMap.put(KEY_GAME_REQUEST_ID, jSONObject.optString(KEY_GAME_REQUEST_ID));
            hashMap.put("payload", jSONObject.getString("payload"));
            payloadData = hashMap;
        } catch (JSONException e) {
            Log.e(TAG, e.toString(), e);
        }
    }

    public static void loadPayloadFromIntent(Intent intent) {
        Bundle extras;
        Bundle bundle;
        HashMap hashMap = new HashMap();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("al_applink_data") || (bundle = extras.getBundle("al_applink_data").getBundle("extras")) == null) {
            return;
        }
        String string = bundle.getString(KEY_GAME_REQUEST_ID);
        String string2 = bundle.getString("payload");
        hashMap.put(KEY_GAME_REQUEST_ID, string);
        hashMap.put("payload", string2);
        payloadData = hashMap;
    }
}
