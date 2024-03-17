package com.huawei.hms.hwid;

import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: HuaweiIdAuthMemCache.java */
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class y {
    private static final y a = new y();
    private Map<String, String> b = new ConcurrentHashMap();

    private y() {
    }

    public static y a() {
        return a;
    }

    public final AuthHuaweiId b() {
        try {
            String str = this.b.get("HuaweiIdAccount");
            if (str != null) {
                return AuthHuaweiId.fromJson(str);
            }
            return null;
        } catch (Throwable th) {
            as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "getHuaweiSignInAccount faild, exception:" + th.getClass().getSimpleName(), true);
            return null;
        }
    }

    public void c() {
        this.b.clear();
    }

    public void a(AuthHuaweiId authHuaweiId, HuaweiIdAuthParams huaweiIdAuthParams) {
        String json;
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        if (authHuaweiId != null) {
            try {
                json = authHuaweiId.toJson();
            } catch (Throwable th) {
                as.d("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "store faild, exception:" + th.getClass().getSimpleName(), true);
                return;
            }
        } else {
            json = null;
        }
        a(json, huaweiIdAuthParams != null ? huaweiIdAuthParams.toJson() : null);
    }

    private void a(String str, String str2) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthMemCache", "saveDefaultHuaweiIdSignInAccount start.", true);
        this.b.remove("HuaweiIdAccount");
        this.b.remove("HuaweiIdAuthParams");
        if (str != null) {
            this.b.put("HuaweiIdAccount", str);
        }
        if (str2 != null) {
            this.b.put("HuaweiIdAuthParams", str2);
        }
    }
}
