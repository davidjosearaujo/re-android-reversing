package com.huawei.hms.support.api.client;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SubAppInfo {
    private String a;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.a = subAppInfo.getSubAppID();
        }
    }

    public String getSubAppID() {
        return this.a;
    }

    public void setSubAppInfoID(String str) {
        this.a = str;
    }

    public SubAppInfo(String str) {
        this.a = str;
    }
}
