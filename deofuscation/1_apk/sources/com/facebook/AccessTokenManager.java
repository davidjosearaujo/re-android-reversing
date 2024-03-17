package com.facebook;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequestBatch;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import n.b0;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.u;
import org.json.JSONArray;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: AccessTokenManager.kt */
@b0(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AccessTokenCache;)V", SDKConstants.PARAM_VALUE, "Lcom/facebook/AccessToken;", "currentAccessToken", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "currentAccessTokenField", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentAccessTokenChanged", "", "extendAccessTokenIfNeeded", "loadCurrentAccessToken", "", "refreshCurrentAccessToken", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "refreshCurrentAccessTokenImpl", "sendCurrentAccessTokenChangedBroadcastIntent", "oldAccessToken", "saveToCache", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AccessTokenManager {
    @d
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    @d
    public static final Companion Companion = new Companion(null);
    @d
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    @d
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    @d
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    @d
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static AccessTokenManager instanceField;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessTokenField;
    private Date lastAttemptedTokenExtendDate;
    private final LocalBroadcastManager localBroadcastManager;
    private final AtomicBoolean tokenRefreshInProgress;

    /* compiled from: AccessTokenManager.kt */
    @b0(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest$Callback graphRequest$Callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            return new GraphRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), bundle, HttpMethod.GET, graphRequest$Callback, (String) null, 32, (u) null);
        }

        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest$Callback graphRequest$Callback) {
            return new GraphRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, graphRequest$Callback, (String) null, 32, (u) null);
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            return (graphDomain.hashCode() == 28903346 && graphDomain.equals(FacebookSdk.INSTAGRAM)) ? new InstagramRefreshTokenInfo() : new FacebookRefreshTokenInfo();
        }

        @d
        @k
        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 == null) {
                synchronized (this) {
                    accessTokenManager = AccessTokenManager.instanceField;
                    if (accessTokenManager == null) {
                        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                        f0.o(localBroadcastManager, "LocalBroadcastManager.ge…tance(applicationContext)");
                        AccessTokenManager accessTokenManager3 = new AccessTokenManager(localBroadcastManager, new AccessTokenCache());
                        AccessTokenManager.instanceField = accessTokenManager3;
                        accessTokenManager = accessTokenManager3;
                    }
                }
                return accessTokenManager;
            }
            return accessTokenManager2;
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        @d
        private final String graphPath = "oauth/access_token";
        @d
        private final String grantType = "fb_extend_sso_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @d
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @d
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @b0(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        @d
        private final String graphPath = "refresh_access_token";
        @d
        private final String grantType = "ig_refresh_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @d
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        @d
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @b0(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME, "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", SDKConstants.PARAM_GRAPH_DOMAIN, "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class RefreshResult {
        @e
        private String accessToken;
        @e
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;
        @e
        private String graphDomain;

        @e
        public final String getAccessToken() {
            return this.accessToken;
        }

        @e
        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        @e
        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(@e String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(@e Long l) {
            this.dataAccessExpirationTime = l;
        }

        public final void setExpiresAt(int i) {
            this.expiresAt = i;
        }

        public final void setExpiresIn(int i) {
            this.expiresIn = i;
        }

        public final void setGraphDomain(@e String str) {
            this.graphDomain = str;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @b0(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public interface RefreshTokenInfo {
        @d
        String getGrantType();

        @d
        String getGraphPath();
    }

    public AccessTokenManager(@d LocalBroadcastManager localBroadcastManager, @d AccessTokenCache accessTokenCache) {
        f0.p(localBroadcastManager, "localBroadcastManager");
        f0.p(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
    }

    @d
    @k
    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    public final void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
            }
        } else {
            this.lastAttemptedTokenExtendDate = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final HashSet hashSet3 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            Companion companion = Companion;
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(companion.createGrantedPermissionsRequest(currentAccessToken, new GraphRequest$Callback() { // from class: com.facebook.AccessTokenManager$refreshCurrentAccessTokenImpl$batch$1
                @Override // com.facebook.GraphRequest$Callback
                public final void onCompleted(@d GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    f0.p(graphResponse, "response");
                    JSONObject jsonObject = graphResponse.getJsonObject();
                    if (jsonObject == null || (optJSONArray = jsonObject.optJSONArray("data")) == null) {
                        return;
                    }
                    atomicBoolean.set(true);
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("permission");
                            String optString2 = optJSONObject.optString("status");
                            if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                                f0.o(optString2, "status");
                                Locale locale = Locale.US;
                                f0.o(locale, "Locale.US");
                                Objects.requireNonNull(optString2, "null cannot be cast to non-null type java.lang.String");
                                String lowerCase = optString2.toLowerCase(locale);
                                f0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                if (lowerCase != null) {
                                    int hashCode = lowerCase.hashCode();
                                    if (hashCode != -1309235419) {
                                        if (hashCode != 280295099) {
                                            if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                                hashSet2.add(optString);
                                            }
                                        } else if (lowerCase.equals("granted")) {
                                            hashSet.add(optString);
                                        }
                                    } else if (lowerCase.equals("expired")) {
                                        hashSet3.add(optString);
                                    }
                                }
                                Log.w(AccessTokenManager.TAG, "Unexpected status: " + lowerCase);
                            }
                        }
                    }
                }
            }), companion.createExtendAccessTokenRequest(currentAccessToken, new GraphRequest$Callback() { // from class: com.facebook.AccessTokenManager$refreshCurrentAccessTokenImpl$batch$2
                @Override // com.facebook.GraphRequest$Callback
                public final void onCompleted(@d GraphResponse graphResponse) {
                    f0.p(graphResponse, "response");
                    JSONObject jsonObject = graphResponse.getJsonObject();
                    if (jsonObject != null) {
                        refreshResult.setAccessToken(jsonObject.optString("access_token"));
                        refreshResult.setExpiresAt(jsonObject.optInt("expires_at"));
                        refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
                        refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                        refreshResult.setGraphDomain(jsonObject.optString("graph_domain", null));
                    }
                }
            }));
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() { // from class: com.facebook.AccessTokenManager$refreshCurrentAccessTokenImpl$1
                {
                    AccessTokenManager.this = this;
                }

                @Override // com.facebook.GraphRequestBatch.Callback
                public final void onBatchCompleted(@d GraphRequestBatch graphRequestBatch2) {
                    AtomicBoolean atomicBoolean2;
                    AtomicBoolean atomicBoolean3;
                    Date dataAccessExpirationTime;
                    AtomicBoolean atomicBoolean4;
                    AtomicBoolean atomicBoolean5;
                    f0.p(graphRequestBatch2, "it");
                    String accessToken = refreshResult.getAccessToken();
                    int expiresAt = refreshResult.getExpiresAt();
                    Long dataAccessExpirationTime2 = refreshResult.getDataAccessExpirationTime();
                    String graphDomain = refreshResult.getGraphDomain();
                    AccessToken accessToken2 = null;
                    try {
                        AccessTokenManager.Companion companion2 = AccessTokenManager.Companion;
                        if (companion2.getInstance().getCurrentAccessToken() != null) {
                            AccessToken currentAccessToken2 = companion2.getInstance().getCurrentAccessToken();
                            if ((currentAccessToken2 != null ? currentAccessToken2.getUserId() : null) == currentAccessToken.getUserId()) {
                                if (!atomicBoolean.get() && accessToken == null && expiresAt == 0) {
                                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
                                    if (accessTokenRefreshCallback2 != null) {
                                        accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                                    }
                                    atomicBoolean5 = AccessTokenManager.this.tokenRefreshInProgress;
                                    atomicBoolean5.set(false);
                                    return;
                                }
                                Date expires = currentAccessToken.getExpires();
                                if (refreshResult.getExpiresAt() != 0) {
                                    expires = new Date(refreshResult.getExpiresAt() * 1000);
                                } else if (refreshResult.getExpiresIn() != 0) {
                                    expires = new Date((refreshResult.getExpiresIn() * 1000) + new Date().getTime());
                                }
                                Date date = expires;
                                if (accessToken == null) {
                                    accessToken = currentAccessToken.getToken();
                                }
                                String str = accessToken;
                                String applicationId = currentAccessToken.getApplicationId();
                                String userId = currentAccessToken.getUserId();
                                Set<String> permissions = atomicBoolean.get() ? hashSet : currentAccessToken.getPermissions();
                                Set<String> declinedPermissions = atomicBoolean.get() ? hashSet2 : currentAccessToken.getDeclinedPermissions();
                                Set<String> expiredPermissions = atomicBoolean.get() ? hashSet3 : currentAccessToken.getExpiredPermissions();
                                AccessTokenSource source = currentAccessToken.getSource();
                                Date date2 = new Date();
                                if (dataAccessExpirationTime2 != null) {
                                    dataAccessExpirationTime = new Date(dataAccessExpirationTime2.longValue() * 1000);
                                } else {
                                    dataAccessExpirationTime = currentAccessToken.getDataAccessExpirationTime();
                                }
                                Date date3 = dataAccessExpirationTime;
                                if (graphDomain == null) {
                                    graphDomain = currentAccessToken.getGraphDomain();
                                }
                                AccessToken accessToken3 = new AccessToken(str, applicationId, userId, permissions, declinedPermissions, expiredPermissions, source, date, date2, date3, graphDomain);
                                try {
                                    companion2.getInstance().setCurrentAccessToken(accessToken3);
                                    atomicBoolean4 = AccessTokenManager.this.tokenRefreshInProgress;
                                    atomicBoolean4.set(false);
                                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback3 = accessTokenRefreshCallback;
                                    if (accessTokenRefreshCallback3 != null) {
                                        accessTokenRefreshCallback3.OnTokenRefreshed(accessToken3);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    accessToken2 = accessToken3;
                                    atomicBoolean2 = AccessTokenManager.this.tokenRefreshInProgress;
                                    atomicBoolean2.set(false);
                                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback4 = accessTokenRefreshCallback;
                                    if (accessTokenRefreshCallback4 != null && accessToken2 != null) {
                                        accessTokenRefreshCallback4.OnTokenRefreshed(accessToken2);
                                    }
                                    throw th;
                                }
                            }
                        }
                        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback5 = accessTokenRefreshCallback;
                        if (accessTokenRefreshCallback5 != null) {
                            accessTokenRefreshCallback5.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                        }
                        atomicBoolean3 = AccessTokenManager.this.tokenRefreshInProgress;
                        atomicBoolean3.set(false);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            });
            graphRequestBatch.executeAsync();
        }
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (companion.isCurrentAccessTokenActive()) {
            if ((currentAccessToken != null ? currentAccessToken.getExpires() : null) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
            try {
                alarmManager.set(1, currentAccessToken.getExpires().getTime(), j.l.c.e0.a.a.d.b(applicationContext, 0, intent, 0));
            } catch (Exception unused) {
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken != null) {
            long time = new Date().getTime();
            return currentAccessToken.getSource().canExtendToken() && time - this.lastAttemptedTokenExtendDate.getTime() > ((long) 3600000) && time - currentAccessToken.getLastRefresh().getTime() > ((long) 86400000);
        }
        return false;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
        }
    }

    @e
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load != null) {
            setCurrentAccessToken(load, false);
            return true;
        }
        return false;
    }

    public final void refreshCurrentAccessToken(@e final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (f0.g(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.AccessTokenManager$refreshCurrentAccessToken$1
                {
                    AccessTokenManager.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        AccessTokenManager.this.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        }
    }

    public final void setCurrentAccessToken(@e AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Context applicationContext = FacebookSdk.getApplicationContext();
                f0.o(applicationContext, "FacebookSdk.getApplicationContext()");
                Utility.clearFacebookCookies(applicationContext);
            }
        }
        if (Utility.areObjectsEqual(accessToken2, accessToken)) {
            return;
        }
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
        setTokenExpirationBroadcastAlarm();
    }
}
