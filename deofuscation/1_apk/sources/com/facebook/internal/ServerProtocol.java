package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.huawei.hms.api.FailedBinderCallBack;
import java.util.Arrays;
import java.util.Collection;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.s0;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: ServerProtocol.kt */
@b0(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0010\u001e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020\u0004H\u0007J\b\u0010?\u001a\u00020\u0004H\u0007J\b\u0010@\u001a\u00020\u0004H\u0007J\b\u0010A\u001a\u00020\u0004H\u0007J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004H\u0007J\b\u0010D\u001a\u00020\u0004H\u0007J\b\u0010E\u001a\u00020\u0004H\u0007J$\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010GH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u0002\u001a\u0004\b4\u00105R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u0002\u001a\u0004\b9\u0010:R\"\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010:¨\u0006L"}, d2 = {"Lcom/facebook/internal/ServerProtocol;", "", "()V", "DIALOG_AUTHORITY_FORMAT", "", "DIALOG_CANCEL_URI", "DIALOG_PARAM_ACCESS_TOKEN", "DIALOG_PARAM_APP_ID", "DIALOG_PARAM_AUTH_TYPE", "DIALOG_PARAM_CBT", "DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH", "DIALOG_PARAM_CLIENT_ID", "DIALOG_PARAM_CUSTOM_TABS_PREFETCHING", "DIALOG_PARAM_DEFAULT_AUDIENCE", "DIALOG_PARAM_DISPLAY", "DIALOG_PARAM_DISPLAY_TOUCH", "DIALOG_PARAM_E2E", "DIALOG_PARAM_FAIL_ON_LOGGED_OUT", "DIALOG_PARAM_FX_APP", "DIALOG_PARAM_IES", "DIALOG_PARAM_LEGACY_OVERRIDE", "DIALOG_PARAM_LOGIN_BEHAVIOR", "DIALOG_PARAM_MESSENGER_PAGE_ID", "DIALOG_PARAM_REDIRECT_URI", "DIALOG_PARAM_RESET_MESSENGER_STATE", "DIALOG_PARAM_RESPONSE_TYPE", "DIALOG_PARAM_RETURN_SCOPES", "DIALOG_PARAM_SCOPE", "DIALOG_PARAM_SDK_VERSION", "DIALOG_PARAM_SKIP_DEDUPE", "DIALOG_PARAM_SSO_DEVICE", "DIALOG_PARAM_STATE", "DIALOG_PATH", "DIALOG_REDIRECT_CHROME_OS_URI", "DIALOG_REDIRECT_URI", "DIALOG_REREQUEST_AUTH_TYPE", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST", "DIALOG_RETURN_SCOPES_TRUE", "FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH", "FALLBACK_DIALOG_PARAM_APP_ID", "FALLBACK_DIALOG_PARAM_BRIDGE_ARGS", "FALLBACK_DIALOG_PARAM_KEY_HASH", "FALLBACK_DIALOG_PARAM_METHOD_ARGS", "FALLBACK_DIALOG_PARAM_METHOD_RESULTS", "FALLBACK_DIALOG_PARAM_VERSION", "GRAPH_URL_FORMAT", "GRAPH_VIDEO_URL_FORMAT", "INSTAGRAM_OAUTH_PATH", "TAG", "errorConnectionFailure", "getErrorConnectionFailure$annotations", "getErrorConnectionFailure", "()Ljava/lang/String;", "errorsProxyAuthDisabled", "", "getErrorsProxyAuthDisabled$annotations", "getErrorsProxyAuthDisabled", "()Ljava/util/Collection;", "errorsUserCanceled", "getErrorsUserCanceled$annotations", "getErrorsUserCanceled", "getDefaultAPIVersion", "getDialogAuthority", "getFacebookGraphUrlBase", "getGraphUrlBase", "getGraphUrlBaseForSubdomain", "subdomain", "getGraphVideoUrlBase", "getInstagramDialogAuthority", "getQueryParamsForPlatformActivityIntentWebFallback", "Landroid/os/Bundle;", FailedBinderCallBack.CALLER_ID, "version", "", "methodArgs", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class ServerProtocol {
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    @d
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    @d
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    @d
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    @d
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    @d
    public static final String DIALOG_PARAM_CBT = "cbt";
    @d
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";
    @d
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    @d
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";
    @d
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    @d
    public static final String DIALOG_PARAM_DISPLAY = "display";
    @d
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    @d
    public static final String DIALOG_PARAM_E2E = "e2e";
    @d
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";
    @d
    public static final String DIALOG_PARAM_FX_APP = "fx_app";
    @d
    public static final String DIALOG_PARAM_IES = "ies";
    @d
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    @d
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";
    @d
    public static final String DIALOG_PARAM_MESSENGER_PAGE_ID = "messenger_page_id";
    @d
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    @d
    public static final String DIALOG_PARAM_RESET_MESSENGER_STATE = "reset_messenger_state";
    @d
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    @d
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    @d
    public static final String DIALOG_PARAM_SCOPE = "scope";
    @d
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    @d
    public static final String DIALOG_PARAM_SKIP_DEDUPE = "skip_dedupe";
    @d
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    @d
    public static final String DIALOG_PARAM_STATE = "state";
    @d
    public static final String DIALOG_PATH = "dialog/";
    @d
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    @d
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    @d
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    @d
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES = "token,signed_request,graph_domain,granted_scopes";
    @d
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";
    @d
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    @d
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    @d
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    @d
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    @d
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    @d
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    @d
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    @d
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    @d
    public static final String INSTAGRAM_OAUTH_PATH = "oauth/authorize";
    @d
    public static final ServerProtocol INSTANCE = new ServerProtocol();
    private static final String TAG;
    @d
    private static final String errorConnectionFailure;
    @d
    private static final Collection<String> errorsProxyAuthDisabled;
    @d
    private static final Collection<String> errorsUserCanceled;

    static {
        String name = ServerProtocol.class.getName();
        f0.o(name, "ServerProtocol::class.java.name");
        TAG = name;
        errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
        errorsUserCanceled = Utility.unmodifiableCollection("access_denied", "OAuthAccessDeniedException");
        errorConnectionFailure = "CONNECTION_FAILURE";
    }

    private ServerProtocol() {
    }

    @d
    @k
    public static final String getDefaultAPIVersion() {
        return "v11.0";
    }

    @d
    @k
    public static final String getDialogAuthority() {
        s0 s0Var = s0.a;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @d
    public static final String getErrorConnectionFailure() {
        return errorConnectionFailure;
    }

    @k
    public static /* synthetic */ void getErrorConnectionFailure$annotations() {
    }

    @d
    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return errorsProxyAuthDisabled;
    }

    @k
    public static /* synthetic */ void getErrorsProxyAuthDisabled$annotations() {
    }

    @d
    public static final Collection<String> getErrorsUserCanceled() {
        return errorsUserCanceled;
    }

    @k
    public static /* synthetic */ void getErrorsUserCanceled$annotations() {
    }

    @d
    @k
    public static final String getFacebookGraphUrlBase() {
        s0 s0Var = s0.a;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @d
    @k
    public static final String getGraphUrlBase() {
        s0 s0Var = s0.a;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @d
    @k
    public static final String getGraphUrlBaseForSubdomain(@d String str) {
        f0.p(str, "subdomain");
        s0 s0Var = s0.a;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{str}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @d
    @k
    public static final String getGraphVideoUrlBase() {
        s0 s0Var = s0.a;
        String format = String.format(GRAPH_VIDEO_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @d
    @k
    public static final String getInstagramDialogAuthority() {
        s0 s0Var = s0.a;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getInstagramDomain()}, 1));
        f0.o(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @k
    @e
    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(@d String str, int i, @e Bundle bundle) {
        f0.p(str, FailedBinderCallBack.CALLER_ID);
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(FALLBACK_DIALOG_PARAM_KEY_HASH, applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt("version", i);
        bundle2.putString("display", "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        try {
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null && convertToJSON2 != null) {
                bundle2.putString(FALLBACK_DIALOG_PARAM_BRIDGE_ARGS, convertToJSON.toString());
                bundle2.putString(FALLBACK_DIALOG_PARAM_METHOD_ARGS, convertToJSON2.toString());
                return bundle2;
            }
            return null;
        } catch (IllegalArgumentException e) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str2 = TAG;
            companion.log(loggingBehavior, 6, str2, "Error creating Url -- " + e);
            return null;
        } catch (JSONException e2) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.DEVELOPER_ERRORS;
            String str3 = TAG;
            companion2.log(loggingBehavior2, 6, str3, "Error creating Url -- " + e2);
            return null;
        }
    }
}
