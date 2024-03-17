package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AAIDResult implements IMessageEntity {
    public String id;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
