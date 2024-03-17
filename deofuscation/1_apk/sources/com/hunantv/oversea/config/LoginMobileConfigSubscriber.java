package com.hunantv.oversea.config;

import android.text.TextUtils;
import com.google.auto.service.AutoService;
import com.mgtv.oversea.setting.mobile.MobileConfigManager;
import com.mgtv.oversea.setting.mobile.MobileConfigSubscriber;
import j.l.a.b0.e;
import j.l.a.b0.f0;
import j.l.a.b0.v;
import java.util.Collections;
import java.util.List;

@AutoService({MobileConfigSubscriber.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LoginMobileConfigSubscriber implements MobileConfigSubscriber {
    private static final String HUAWEI = "huawei_login_icon";
    private static final String OPEN = "1";
    private static final String TAG = "LoginMobileConfigSubscriber";

    public List<String> codeList() {
        if (e.P().equalsIgnoreCase("huawei")) {
            return Collections.singletonList(HUAWEI);
        }
        return Collections.emptyList();
    }

    public void onError(Throwable th) {
    }

    public void onSubscribe(MobileConfigManager mobileConfigManager) {
        String j = mobileConfigManager.j(HUAWEI);
        String str = TAG;
        v.l(str, "华为开关 = " + j);
        f0.p(HUAWEI, TextUtils.equals(j, "1"));
    }
}
