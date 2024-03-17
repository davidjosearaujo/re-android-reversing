package com.huawei.hms.support.feature.service;

import android.content.Intent;
import com.huawei.hms.common.HuaweiApiInterface;
import j.k.b.a.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface AuthService extends HuaweiApiInterface {
    l<Void> cancelAuthorization();

    Intent getSignInIntent();

    l<Void> signOut();
}
