package com.huawei.hms.activity.internal;

import android.content.Intent;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BusResponseResult {
    private int code;
    private Intent intent;

    public int getCode() {
        return this.code;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
