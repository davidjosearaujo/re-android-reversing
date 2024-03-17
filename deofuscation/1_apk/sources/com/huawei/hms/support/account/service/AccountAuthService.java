package com.huawei.hms.support.account.service;

import android.content.Intent;
import com.huawei.hms.support.account.result.AccountIcon;
import com.huawei.hms.support.account.result.AssistTokenResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.entity.account.GetAssistTokenRequest;
import com.huawei.hms.support.feature.service.AuthService;
import j.k.b.a.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AccountAuthService extends AuthService {
    l<AssistTokenResult> getAssistToken(GetAssistTokenRequest getAssistTokenRequest);

    l<AccountIcon> getChannel();

    Intent getIndependentSignInIntent(String str);

    l<Void> logout();

    l<AuthAccount> silentSignIn();

    l<Void> startAssistLogin(String str);
}
