package cn.jiguang.net;

import android.text.TextUtils;
import cn.jiguang.ar.c;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DefaultHostVerifier implements HostnameVerifier {
    public String a;

    public DefaultHostVerifier(String str) {
        this.a = null;
        this.a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        c.c("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }
}
