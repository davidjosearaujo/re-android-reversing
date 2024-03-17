package com.huawei.hms.push.ups.entity;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class TokenResult extends CodeResult {
    public String c;

    public TokenResult() {
    }

    public String getToken() {
        return this.c;
    }

    public void setToken(String str) {
        this.c = str;
    }

    public TokenResult(int i) {
        super(i);
    }

    public TokenResult(int i, String str) {
        super(i, str);
    }

    public TokenResult(String str) {
        this.c = str;
    }
}
