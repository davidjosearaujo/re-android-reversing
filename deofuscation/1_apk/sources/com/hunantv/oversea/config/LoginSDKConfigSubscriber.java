package com.hunantv.oversea.config;

import android.text.TextUtils;
import com.google.auto.service.AutoService;
import com.mgtv.oversea.setting.platform.SDKConfigSubscriber;
import com.mgtv.oversea.setting.platform.data.StartConfigData;
import j.l.a.b0.v;
import j.l.c.g.n.g;
import j.v.o.a.e.c;
import java.util.List;

@AutoService({SDKConfigSubscriber.class})
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LoginSDKConfigSubscriber implements SDKConfigSubscriber {
    private static final String SDK_NAME = "TwitterLogin";
    private static final String TAG = "LoginSDKConfigSubscriber";

    private void initTwitter(boolean z) {
        g.h = z;
    }

    public void onAdvanceParse(StartConfigData startConfigData, boolean z) {
        StartConfigData.StartConfigDataBean startConfigDataBean;
        List list;
        if (startConfigData == null || (startConfigDataBean = startConfigData.data) == null || (list = startConfigDataBean.sdk) == null || list.isEmpty()) {
            return;
        }
        while (true) {
            boolean z2 = true;
            for (StartConfigData.SDKDataBean sDKDataBean : startConfigData.data.sdk) {
                if (TextUtils.equals(SDK_NAME, sDKDataBean.sdkName)) {
                    v.l(TAG, "Twitter status = " + sDKDataBean.switchState);
                    if (sDKDataBean.switchState == 1) {
                        break;
                    }
                    z2 = false;
                }
            }
            initTwitter(z2);
            return;
        }
    }

    public /* synthetic */ void onParse(List list) {
        c.$default$onParse(this, list);
    }
}
