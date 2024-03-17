package com.facebook.referrals;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabPrefetchHelper;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReferralClient {
    private static final int CHALLENGE_LENGTH = 20;
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    public static final String ERROR_MESSAGE_KEY = "error_message";
    public static final String REFERRAL_CODES_KEY = "fb_referral_codes";
    private static final String REFERRAL_DIALOG = "share_referral";
    private String currentPackage;
    public String expectedChallenge;
    private Fragment fragment;

    public ReferralClient(Fragment fragment) {
        this.fragment = fragment;
    }

    private void finishReferral(int i, Intent intent) {
        FragmentActivity activity;
        if (!this.fragment.isAdded() || (activity = this.fragment.getActivity()) == null) {
            return;
        }
        activity.setResult(i, intent);
        activity.finish();
    }

    private String getChromePackage() {
        if (this.currentPackage == null) {
            this.currentPackage = CustomTabUtils.getChromePackage();
        }
        return this.currentPackage;
    }

    public static String getDeveloperDefinedRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize";
    }

    private Bundle getParameters() {
        Bundle bundle = new Bundle();
        this.expectedChallenge = Utility.generateRandomString(20);
        bundle.putString("redirect_uri", CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectUrl()));
        bundle.putString("app_id", FacebookSdk.getApplicationId());
        bundle.putString("state", this.expectedChallenge);
        return bundle;
    }

    public static int getReferralRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode();
    }

    private boolean isCustomTabsAllowed() {
        return getChromePackage() != null;
    }

    private boolean tryStartReferral() {
        if (this.fragment.getActivity() != null && this.fragment.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") == 0 && isCustomTabsAllowed()) {
            Bundle parameters = getParameters();
            if (FacebookSdk.hasCustomTabsPrefetching) {
                CustomTabPrefetchHelper.mayLaunchUrl(CustomTab.getURIForAction(REFERRAL_DIALOG, parameters));
            }
            Intent intent = new Intent((Context) this.fragment.getActivity(), (Class<?>) CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, REFERRAL_DIALOG);
            intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
            intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
            this.fragment.startActivityForResult(intent, 1);
            return true;
        }
        return false;
    }

    private boolean validateChallenge(Bundle bundle) {
        if (this.expectedChallenge != null) {
            boolean equals = this.expectedChallenge.equals(bundle.getString("state"));
            this.expectedChallenge = null;
            return equals;
        }
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (i != 1) {
            return;
        }
        if (intent != null && (stringExtra = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL)) != null && stringExtra.startsWith(CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectUrl()))) {
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(stringExtra).getQuery());
            if (validateChallenge(parseUrlQueryString)) {
                intent.putExtras(parseUrlQueryString);
            } else {
                i2 = 0;
                intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
            }
        }
        finishReferral(i2, intent);
    }

    public void startReferral() {
        if (tryStartReferral()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
        finishReferral(0, intent);
    }
}
