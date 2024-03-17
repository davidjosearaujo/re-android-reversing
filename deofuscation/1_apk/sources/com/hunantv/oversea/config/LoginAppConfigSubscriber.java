package com.hunantv.oversea.config;

import com.google.auto.service.AutoService;
import com.hunantv.oversea.login.compat.ImgoLoginDataProvider;
import com.mgtv.oversea.setting.appconfig.AppConfigManager;
import com.mgtv.oversea.setting.appconfig.AppConfigSubscriber;
import j.v.o.a.c.a;
import java.util.HashMap;
import java.util.Map;

@AutoService({AppConfigSubscriber.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LoginAppConfigSubscriber implements AppConfigSubscriber {
    public /* synthetic */ int getTag() {
        return a.$default$getTag(this);
    }

    public void onError(Throwable th) {
    }

    public void onSubscribe(AppConfigManager appConfigManager) {
        ImgoLoginDataProvider.p((appConfigManager == null || appConfigManager.j() == null || appConfigManager.j().userSign == null) ? false : appConfigManager.j().userSign.isCertification());
    }

    public Map<String, String> params() {
        return new HashMap();
    }
}
