package com.huawei.hms.hatool;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class m0 implements n0 {
    public String a;
    public String b;

    public m0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.a(this.a, this.b);
    }
}
