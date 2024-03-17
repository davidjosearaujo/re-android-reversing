package com.huawei.hms.support.sms;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.hwid.ah;
import com.huawei.hms.hwid.aj;
import j.k.b.a.l;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ReadSmsManager {
    private static final Api<Api.ApiOptions.NoOptions> a = new Api<>(HuaweiApiAvailability.HMS_API_NAME_ID);
    private static final ah b = new ah();

    public static l<Void> start(Activity activity) {
        return new aj(activity, a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) b).a();
    }

    public static l<Void> startConsent(Activity activity, String str) {
        return new aj(activity, a, (Api.ApiOptions.NoOptions) null, (AbstractClientBuilder) b).a(str);
    }

    public static l<Void> start(Context context) {
        return new aj(context, a, (Api.ApiOptions.NoOptions) null, b).a();
    }
}
