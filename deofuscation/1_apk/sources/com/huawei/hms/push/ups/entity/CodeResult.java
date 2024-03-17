package com.huawei.hms.push.ups.entity;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CodeResult {
    public int a;
    public String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.a = i;
    }

    public CodeResult(int i) {
        this.a = i;
    }

    public CodeResult(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
