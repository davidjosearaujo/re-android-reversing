package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BundleResult {
    private int a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
