package com.huawei.hms.hwid;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AbstractCpClientInfo.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public abstract class am {
    public String a;
    public String b;
    public long c;
    public String d;

    public String a() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appId", this.a);
        jSONObject.putOpt(CommonConstant.ReqAccessTokenParam.PACKAGE_NAME, this.b);
        jSONObject.put("hmsSdkVersion", this.c);
        jSONObject.putOpt("subAppId", this.d);
        return jSONObject;
    }

    public String toString() {
        return "HuaweiIdCpClientInfo{appId='" + this.a + "', packageName='" + this.b + "', hmsSdkVersion=" + this.c + "', subAppId=" + this.d + '}';
    }

    public void a(long j) {
        this.c = j;
    }

    public long b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() throws JSONException {
        return e().toString();
    }
}
