package cn.jiguang.ao;

import android.content.Intent;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class c {
    public String a;
    public String b;
    public int c;
    public String d;
    public Intent e;
    public Intent f;
    public int g = 0;
    public String h;
    public int i;

    public c() {
    }

    public c(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((c) obj).a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String toString() {
        return "JWakeTargetInfo{packageName='" + this.a + "', serviceName='" + this.b + "', targetVersion=" + this.c + ", providerAuthority='" + this.d + "', activityIntent=" + this.e + ", activityIntentBackup=" + this.f + ", wakeType=" + this.g + ", authenType=" + this.h + ", cmd=" + this.i + '}';
    }
}
