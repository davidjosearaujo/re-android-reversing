package com.huawei.hms.api;

import android.content.Intent;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int b;

    public HuaweiServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.b = i;
    }

    public int getConnectionStatusCode() {
        return this.b;
    }
}
