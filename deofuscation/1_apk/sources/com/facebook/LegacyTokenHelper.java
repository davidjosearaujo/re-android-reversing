package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import n.b0;
import n.l2.h;
import n.l2.k;
import n.l2.v.f0;
import n.l2.v.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.e.a.d;
import r.e.a.e;

/* compiled from: LegacyTokenHelper.kt */
@b0(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "context", "Landroid/content/Context;", "cacheKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cache", "Landroid/content/SharedPreferences;", "clear", "", "deserializeKey", SDKConstants.PARAM_KEY, "bundle", "Landroid/os/Bundle;", "load", "save", "serializeKey", "editor", "Landroid/content/SharedPreferences$Editor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class LegacyTokenHelper {
    @d
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    @d
    public static final Companion Companion = new Companion(null);
    @d
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    @d
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    @d
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    @d
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    @d
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    @d
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG;
    @d
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    @d
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private final SharedPreferences cache;
    private final String cacheKey;

    /* compiled from: LegacyTokenHelper.kt */
    @b0(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0007J\u001e\u0010*\u001a\u0004\u0018\u00010+2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010.\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u00100\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001022\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0007J\u0012\u00106\u001a\u0002072\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u001a\u00108\u001a\u0002092\u0006\u0010(\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010;\u001a\u0002092\u0006\u0010(\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020+H\u0002J\u001e\u0010=\u001a\u0002092\u0006\u0010(\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010?\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020+H\u0007J\u0018\u0010@\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\nH\u0007J\u001e\u0010A\u001a\u0002092\u0006\u0010(\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010B\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020+H\u0007J\u0018\u0010C\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\nH\u0007J\u001e\u0010D\u001a\u0002092\u0006\u0010(\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040>H\u0007J\u0018\u0010E\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u000204H\u0007J\u0018\u0010F\u001a\u0002092\u0006\u0010(\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "()V", "APPLICATION_ID_KEY", "", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "TAG", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "getApplicationId", "bundle", "Landroid/os/Bundle;", "getDate", "Ljava/util/Date;", SDKConstants.PARAM_KEY, "getExpirationDate", "getExpirationMilliseconds", "getLastRefreshDate", "getLastRefreshMilliseconds", "getPermissions", "", "getSource", "Lcom/facebook/AccessTokenSource;", "getToken", "hasTokenInformation", "", "putApplicationId", "", "value", "putDate", "date", "putDeclinedPermissions", "", "putExpirationDate", "putExpirationMilliseconds", "putExpiredPermissions", "putLastRefreshDate", "putLastRefreshMilliseconds", "putPermissions", "putSource", "putToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class Companion {
        private Companion() {
        }

        private final Date getDate(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j = bundle.getLong(str, LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS);
            if (j == LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS) {
                return null;
            }
            return new Date(j);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        @k
        @e
        public final String getApplicationId(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @k
        @e
        public final Date getExpirationDate(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @k
        public final long getExpirationMilliseconds(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @k
        @e
        public final Date getLastRefreshDate(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @k
        public final long getLastRefreshMilliseconds(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @k
        @e
        public final Set<String> getPermissions(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList != null) {
                f0.o(stringArrayList, "bundle.getStringArrayLis…SIONS_KEY) ?: return null");
                return new HashSet(stringArrayList);
            }
            return null;
        }

        @k
        @e
        public final AccessTokenSource getSource(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            if (bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY)) {
                return (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY);
            }
            return bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
        }

        @k
        @e
        public final String getToken(@d Bundle bundle) {
            f0.p(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @k
        public final boolean hasTokenInformation(@e Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null) {
                return false;
            }
            return ((string.length() == 0) || bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0L) == 0) ? false : true;
        }

        @k
        public final void putApplicationId(@d Bundle bundle, @e String str) {
            f0.p(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        @k
        public final void putDeclinedPermissions(@d Bundle bundle, @d Collection<String> collection) {
            f0.p(bundle, "bundle");
            f0.p(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList<>(collection));
        }

        @k
        public final void putExpirationDate(@d Bundle bundle, @d Date date) {
            f0.p(bundle, "bundle");
            f0.p(date, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, date);
        }

        @k
        public final void putExpirationMilliseconds(@d Bundle bundle, long j) {
            f0.p(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j);
        }

        @k
        public final void putExpiredPermissions(@d Bundle bundle, @d Collection<String> collection) {
            f0.p(bundle, "bundle");
            f0.p(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList<>(collection));
        }

        @k
        public final void putLastRefreshDate(@d Bundle bundle, @d Date date) {
            f0.p(bundle, "bundle");
            f0.p(date, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, date);
        }

        @k
        public final void putLastRefreshMilliseconds(@d Bundle bundle, long j) {
            f0.p(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j);
        }

        @k
        public final void putPermissions(@d Bundle bundle, @d Collection<String> collection) {
            f0.p(bundle, "bundle");
            f0.p(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList<>(collection));
        }

        @k
        public final void putSource(@d Bundle bundle, @d AccessTokenSource accessTokenSource) {
            f0.p(bundle, "bundle");
            f0.p(accessTokenSource, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, accessTokenSource);
        }

        @k
        public final void putToken(@d Bundle bundle, @d String str) {
            f0.p(bundle, "bundle");
            f0.p(str, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, str);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    static {
        String simpleName = LegacyTokenHelper.class.getSimpleName();
        f0.o(simpleName, "LegacyTokenHelper::class.java.simpleName");
        TAG = simpleName;
    }

    @h
    public LegacyTokenHelper(@d Context context) {
        this(context, null, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0014, code lost:
        if ((r4.length() == 0) != false) goto L14;
     */
    @n.l2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LegacyTokenHelper(@r.e.a.d android.content.Context r3, @r.e.a.e java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            n.l2.v.f0.p(r3, r0)
            r2.<init>()
            r0 = 0
            if (r4 == 0) goto L16
            int r1 = r4.length()
            if (r1 != 0) goto L13
            r1 = 1
            goto L14
        L13:
            r1 = 0
        L14:
            if (r1 == 0) goto L18
        L16:
            java.lang.String r4 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY"
        L18:
            r2.cacheKey = r4
            android.content.Context r1 = r3.getApplicationContext()
            if (r1 == 0) goto L21
            r3 = r1
        L21:
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)
            java.lang.String r4 = "context.getSharedPrefere…ey, Context.MODE_PRIVATE)"
            n.l2.v.f0.o(r3, r4)
            r2.cache = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.<init>(android.content.Context, java.lang.String):void");
    }

    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string = this.cache.getString(str, "{}");
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getString(JSON_VALUE_TYPE);
            if (f0.g(string2, TYPE_BOOLEAN)) {
                bundle.putBoolean(str, jSONObject.getBoolean("value"));
                return;
            }
            int i = 0;
            if (f0.g(string2, TYPE_BOOLEAN_ARRAY)) {
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                int length = jSONArray.length();
                boolean[] zArr = new boolean[length];
                while (i < length) {
                    zArr[i] = jSONArray.getBoolean(i);
                    i++;
                }
                bundle.putBooleanArray(str, zArr);
                return;
            } else if (f0.g(string2, TYPE_BYTE)) {
                bundle.putByte(str, (byte) jSONObject.getInt("value"));
                return;
            } else if (f0.g(string2, TYPE_BYTE_ARRAY)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                int length2 = jSONArray2.length();
                byte[] bArr = new byte[length2];
                while (i < length2) {
                    bArr[i] = (byte) jSONArray2.getInt(i);
                    i++;
                }
                bundle.putByteArray(str, bArr);
                return;
            } else if (f0.g(string2, TYPE_SHORT)) {
                bundle.putShort(str, (short) jSONObject.getInt("value"));
                return;
            } else if (f0.g(string2, TYPE_SHORT_ARRAY)) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                int length3 = jSONArray3.length();
                short[] sArr = new short[length3];
                while (i < length3) {
                    sArr[i] = (short) jSONArray3.getInt(i);
                    i++;
                }
                bundle.putShortArray(str, sArr);
                return;
            } else if (f0.g(string2, TYPE_INTEGER)) {
                bundle.putInt(str, jSONObject.getInt("value"));
                return;
            } else if (f0.g(string2, TYPE_INTEGER_ARRAY)) {
                JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                int length4 = jSONArray4.length();
                int[] iArr = new int[length4];
                while (i < length4) {
                    iArr[i] = jSONArray4.getInt(i);
                    i++;
                }
                bundle.putIntArray(str, iArr);
                return;
            } else if (f0.g(string2, TYPE_LONG)) {
                bundle.putLong(str, jSONObject.getLong("value"));
                return;
            } else if (f0.g(string2, TYPE_LONG_ARRAY)) {
                JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                int length5 = jSONArray5.length();
                long[] jArr = new long[length5];
                while (i < length5) {
                    jArr[i] = jSONArray5.getLong(i);
                    i++;
                }
                bundle.putLongArray(str, jArr);
                return;
            } else if (f0.g(string2, TYPE_FLOAT)) {
                bundle.putFloat(str, (float) jSONObject.getDouble("value"));
                return;
            } else if (f0.g(string2, TYPE_FLOAT_ARRAY)) {
                JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                int length6 = jSONArray6.length();
                float[] fArr = new float[length6];
                while (i < length6) {
                    fArr[i] = (float) jSONArray6.getDouble(i);
                    i++;
                }
                bundle.putFloatArray(str, fArr);
                return;
            } else if (f0.g(string2, TYPE_DOUBLE)) {
                bundle.putDouble(str, jSONObject.getDouble("value"));
                return;
            } else if (f0.g(string2, TYPE_DOUBLE_ARRAY)) {
                JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                int length7 = jSONArray7.length();
                double[] dArr = new double[length7];
                while (i < length7) {
                    dArr[i] = jSONArray7.getDouble(i);
                    i++;
                }
                bundle.putDoubleArray(str, dArr);
                return;
            } else if (f0.g(string2, TYPE_CHAR)) {
                String string3 = jSONObject.getString("value");
                if (string3 == null || string3.length() != 1) {
                    return;
                }
                bundle.putChar(str, string3.charAt(0));
                return;
            } else if (f0.g(string2, TYPE_CHAR_ARRAY)) {
                JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                int length8 = jSONArray8.length();
                char[] cArr = new char[length8];
                for (int i2 = 0; i2 < length8; i2++) {
                    String string4 = jSONArray8.getString(i2);
                    if (string4 != null && string4.length() == 1) {
                        cArr[i2] = string4.charAt(0);
                    }
                }
                bundle.putCharArray(str, cArr);
                return;
            } else if (f0.g(string2, TYPE_STRING)) {
                bundle.putString(str, jSONObject.getString("value"));
                return;
            } else if (f0.g(string2, TYPE_STRING_LIST)) {
                JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                int length9 = jSONArray9.length();
                ArrayList<String> arrayList = new ArrayList<>(length9);
                while (i < length9) {
                    Object obj = jSONArray9.get(i);
                    if (obj == JSONObject.NULL) {
                        str2 = null;
                    } else {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                        str2 = (String) obj;
                    }
                    arrayList.add(i, str2);
                    i++;
                }
                bundle.putStringArrayList(str, arrayList);
                return;
            } else if (f0.g(string2, TYPE_ENUM)) {
                try {
                    Class<?> cls = Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE));
                    if (cls != null) {
                        bundle.putSerializable(str, Enum.valueOf(cls, jSONObject.getString("value")));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                } catch (ClassNotFoundException | IllegalArgumentException unused) {
                    return;
                }
            } else {
                return;
            }
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @k
    @e
    public static final String getApplicationId(@d Bundle bundle) {
        return Companion.getApplicationId(bundle);
    }

    @k
    @e
    public static final Date getExpirationDate(@d Bundle bundle) {
        return Companion.getExpirationDate(bundle);
    }

    @k
    public static final long getExpirationMilliseconds(@d Bundle bundle) {
        return Companion.getExpirationMilliseconds(bundle);
    }

    @k
    @e
    public static final Date getLastRefreshDate(@d Bundle bundle) {
        return Companion.getLastRefreshDate(bundle);
    }

    @k
    public static final long getLastRefreshMilliseconds(@d Bundle bundle) {
        return Companion.getLastRefreshMilliseconds(bundle);
    }

    @k
    @e
    public static final Set<String> getPermissions(@d Bundle bundle) {
        return Companion.getPermissions(bundle);
    }

    @k
    @e
    public static final AccessTokenSource getSource(@d Bundle bundle) {
        return Companion.getSource(bundle);
    }

    @k
    @e
    public static final String getToken(@d Bundle bundle) {
        return Companion.getToken(bundle);
    }

    @k
    public static final boolean hasTokenInformation(@e Bundle bundle) {
        return Companion.hasTokenInformation(bundle);
    }

    @k
    public static final void putApplicationId(@d Bundle bundle, @e String str) {
        Companion.putApplicationId(bundle, str);
    }

    @k
    public static final void putDeclinedPermissions(@d Bundle bundle, @d Collection<String> collection) {
        Companion.putDeclinedPermissions(bundle, collection);
    }

    @k
    public static final void putExpirationDate(@d Bundle bundle, @d Date date) {
        Companion.putExpirationDate(bundle, date);
    }

    @k
    public static final void putExpirationMilliseconds(@d Bundle bundle, long j) {
        Companion.putExpirationMilliseconds(bundle, j);
    }

    @k
    public static final void putExpiredPermissions(@d Bundle bundle, @d Collection<String> collection) {
        Companion.putExpiredPermissions(bundle, collection);
    }

    @k
    public static final void putLastRefreshDate(@d Bundle bundle, @d Date date) {
        Companion.putLastRefreshDate(bundle, date);
    }

    @k
    public static final void putLastRefreshMilliseconds(@d Bundle bundle, long j) {
        Companion.putLastRefreshMilliseconds(bundle, j);
    }

    @k
    public static final void putPermissions(@d Bundle bundle, @d Collection<String> collection) {
        Companion.putPermissions(bundle, collection);
    }

    @k
    public static final void putSource(@d Bundle bundle, @d AccessTokenSource accessTokenSource) {
        Companion.putSource(bundle, accessTokenSource);
    }

    @k
    public static final void putToken(@d Bundle bundle, @d String str) {
        Companion.putToken(bundle, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:210:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    @e
    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                f0.o(str, SDKConstants.PARAM_KEY);
                deserializeKey(str, bundle);
            } catch (JSONException e) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = TAG;
                companion.log(loggingBehavior, 5, str2, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public final void save(@d Bundle bundle) {
        f0.p(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                f0.o(str, SDKConstants.PARAM_KEY);
                f0.o(edit, "editor");
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str2 = TAG;
                companion.log(loggingBehavior, 5, str2, "Error processing value for key: '" + str + "' -- " + e);
                return;
            }
        }
        edit.apply();
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i, u uVar) {
        this(context, (i & 2) != 0 ? null : str);
    }
}
