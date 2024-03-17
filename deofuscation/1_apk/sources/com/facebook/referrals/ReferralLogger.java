package com.facebook.referrals;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReferralLogger {
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    public static final String EVENT_NAME_REFERRAL_CANCEL = "fb_mobile_referral_cancel";
    public static final String EVENT_NAME_REFERRAL_ERROR = "fb_mobile_referral_error";
    public static final String EVENT_NAME_REFERRAL_START = "fb_mobile_referral_start";
    public static final String EVENT_NAME_REFERRAL_SUCCESS = "fb_mobile_referral_success";
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    public static final String EVENT_PARAM_ERROR_MESSAGE = "2_error_message";
    public static final String EVENT_PARAM_EXTRAS = "3_extras";
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    public static final String EVENT_PARAM_VALUE_EMPTY = "";
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private String facebookVersion;
    private final InternalAppEventsLogger logger;
    private String loggerID = UUID.randomUUID().toString();

    public ReferralLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) == null) {
                return;
            }
            this.facebookVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private Bundle getReferralLoggingBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("0_auth_logger_id", this.loggerID);
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
        bundle.putString(EVENT_PARAM_EXTRAS, "");
        return bundle;
    }

    public void logCancel() {
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_CANCEL, getReferralLoggingBundle());
    }

    public void logError(Exception exc) {
        Bundle referralLoggingBundle = getReferralLoggingBundle();
        if (exc != null && exc.getMessage() != null) {
            referralLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
        }
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_ERROR, referralLoggingBundle);
    }

    public void logStartReferral() {
        Bundle referralLoggingBundle = getReferralLoggingBundle();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request_code", ReferralClient.getReferralRequestCode());
            String str = this.facebookVersion;
            if (str != null) {
                jSONObject.put("facebookVersion", str);
            }
            referralLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_START, referralLoggingBundle);
    }

    public void logSuccess() {
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_SUCCESS, getReferralLoggingBundle());
    }
}
