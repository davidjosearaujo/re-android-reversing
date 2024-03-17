package com.huawei.hms.support.hwid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import j.k.b.a.l;
import j.k.b.a.m;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class HuaweiIdAuthManager {
    private static Intent a(Activity activity, List<Scope> list) {
        return getService(activity, x.a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        Objects.requireNonNull(huaweiIdAuthExtendedParams, "HuaweiIdAuthExtendedParams should not be null");
        addAuthScopes(activity, i, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        if (huaweiIdAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authHuaweiId, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static AuthHuaweiId getAuthResult() {
        return x.b();
    }

    public static AuthHuaweiId getAuthResultWithScopes(List<Scope> list) throws HuaweiIdAuthException {
        if (!ap.a(list).booleanValue()) {
            AuthHuaweiId b = x.b();
            if (b == null) {
                b = new AuthHuaweiId();
            }
            b.requestExtraScopes(list);
            return b;
        }
        throw new HuaweiIdAuthException("ScopeList should not be empty");
    }

    public static AuthHuaweiId getExtendedAuthResult(HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        Objects.requireNonNull(huaweiIdAuthExtendedParams, "HuaweiIdAuthExtendedParams should not be null");
        List<Scope> extendedScopes = huaweiIdAuthExtendedParams.getExtendedScopes();
        AuthHuaweiId b = x.b();
        if (b == null) {
            b = new AuthHuaweiId();
        }
        return b.requestExtraScopes(extendedScopes);
    }

    public static HuaweiIdAuthService getService(Context context, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(context, huaweiIdAuthParams, 60400300);
    }

    public static l<AuthHuaweiId> parseAuthResultFromIntent(Intent intent) {
        m mVar = new m();
        HuaweiIdAuthResult a = x.a(intent);
        if (a == null) {
            mVar.c(new ApiException(new Status(8)));
        } else if (a.isSuccess() && a.getHuaweiId() != null) {
            mVar.d(a.getHuaweiId());
        } else {
            mVar.c(new ApiException(a.getStatus()));
        }
        return mVar.b();
    }

    public static HuaweiIdAuthService getService(Activity activity, HuaweiIdAuthParams huaweiIdAuthParams) {
        return new HuaweiIdAuthServiceImpl(activity, huaweiIdAuthParams, 60400300);
    }

    public static boolean containScopes(AuthHuaweiId authHuaweiId, List<Scope> list) {
        if (authHuaweiId == null) {
            return false;
        }
        if (ap.a(list).booleanValue()) {
            return true;
        }
        return authHuaweiId.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i, HuaweiIdAuthExtendedParams huaweiIdAuthExtendedParams) {
        Objects.requireNonNull(huaweiIdAuthExtendedParams, "HuaweiIdAuthExtendedParams should not be null");
        addAuthScopes(fragment, i, huaweiIdAuthExtendedParams.getExtendedScopes());
    }

    public static void addAuthScopes(Activity activity, int i, List<Scope> list) {
        Objects.requireNonNull(activity, "Activity should not be null");
        Objects.requireNonNull(list, "ScopeList should not be null");
        activity.startActivityForResult(a(activity, list), i);
    }

    public static void addAuthScopes(Fragment fragment, int i, List<Scope> list) {
        Objects.requireNonNull(fragment, "Fragment should not be null");
        Objects.requireNonNull(list, "ScopeList should not be null");
        fragment.startActivityForResult(a(fragment.getActivity(), list), i);
    }
}
