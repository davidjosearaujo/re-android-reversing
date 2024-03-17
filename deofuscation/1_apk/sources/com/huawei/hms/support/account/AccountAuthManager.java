package com.huawei.hms.support.account;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.f;
import com.huawei.hms.support.account.common.AccountAuthException;
import com.huawei.hms.support.account.request.AccountAuthExtendedParams;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;
import com.huawei.hms.support.account.service.AccountAuthServiceImpl;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import j.k.b.a.l;
import j.k.b.a.m;
import java.util.List;
import java.util.Objects;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class AccountAuthManager {
    private static Intent a(Activity activity, List<Scope> list) {
        return getService(activity, f.a(list)).getSignInIntent();
    }

    public static void addAuthScopes(Activity activity, int i, AccountAuthExtendedParams accountAuthExtendedParams) {
        Objects.requireNonNull(accountAuthExtendedParams, "AccountAuthExtendedParams should not be null");
        addAuthScopes(activity, i, accountAuthExtendedParams.getExtendedScopes());
    }

    public static boolean containScopes(AuthAccount authAccount, AccountAuthExtendedParams accountAuthExtendedParams) {
        if (accountAuthExtendedParams == null) {
            return false;
        }
        return containScopes(authAccount, accountAuthExtendedParams.getExtendedScopes());
    }

    public static AuthAccount getAuthResult() {
        return f.b();
    }

    public static AuthAccount getAuthResultWithScopes(List<Scope> list) throws AccountAuthException {
        if (!ap.a(list).booleanValue()) {
            AuthAccount b = f.b();
            if (b == null) {
                b = new AuthAccount();
            }
            b.requestExtraScopes(list);
            return b;
        }
        throw new AccountAuthException("ScopeList should not be empty");
    }

    public static AuthAccount getExtendedAuthResult(AccountAuthExtendedParams accountAuthExtendedParams) {
        Objects.requireNonNull(accountAuthExtendedParams, "AccountAuthExtendedParams should not be null");
        List<Scope> extendedScopes = accountAuthExtendedParams.getExtendedScopes();
        AuthAccount b = f.b();
        if (b == null) {
            b = new AuthAccount();
        }
        return b.requestExtraScopes(extendedScopes);
    }

    public static AccountAuthService getService(Context context, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(context, accountAuthParams, 60400300);
    }

    public static l<AuthAccount> parseAuthResultFromIntent(Intent intent) {
        m mVar = new m();
        AccountAuthResult a = f.a(intent);
        if (a == null) {
            mVar.c(new ApiException(new Status(8)));
        } else if (a.isSuccess() && a.getAccount() != null) {
            mVar.d(a.getAccount());
        } else {
            mVar.c(new ApiException(a.getStatus()));
        }
        return mVar.b();
    }

    public static AccountAuthService getService(Activity activity, AccountAuthParams accountAuthParams) {
        return new AccountAuthServiceImpl(activity, accountAuthParams, 60400300);
    }

    public static boolean containScopes(AuthAccount authAccount, List<Scope> list) {
        if (authAccount == null) {
            return false;
        }
        if (ap.a(list).booleanValue()) {
            return true;
        }
        return authAccount.getAuthorizedScopes().containsAll(list);
    }

    public static void addAuthScopes(Fragment fragment, int i, AccountAuthExtendedParams accountAuthExtendedParams) {
        Objects.requireNonNull(accountAuthExtendedParams, "AccountAuthExtendedParams should not be null");
        addAuthScopes(fragment, i, accountAuthExtendedParams.getExtendedScopes());
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
