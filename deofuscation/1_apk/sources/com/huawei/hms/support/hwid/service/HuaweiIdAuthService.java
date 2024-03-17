package com.huawei.hms.support.hwid.service;

import android.content.Intent;
import com.huawei.hms.support.feature.service.AuthService;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import j.k.b.a.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface HuaweiIdAuthService extends AuthService {
    Intent getSignInIntent(String str);

    l<AuthHuaweiId> silentSignIn();

    l<AuthHuaweiId> silentSignIn(String str);
}
