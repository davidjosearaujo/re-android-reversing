package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class InAppAdLibrary {
    public static final String PLACEMENT_ID = "placementID";

    public static void loadInterstitialAd(Context context, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
    }

    public static void loadRewardedVideo(Context context, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
    }

    public static void showInterstitialAd(Context context, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
    }

    public static void showRewardedVideo(Context context, @Nullable JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
    }
}
