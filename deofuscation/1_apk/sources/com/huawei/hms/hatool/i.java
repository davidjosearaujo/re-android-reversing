package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class i {
    public static Map<String, m> b = new HashMap();
    public static i c;
    public l a = new l();

    public static i c() {
        if (c == null) {
            d();
        }
        return c;
    }

    public static synchronized void d() {
        synchronized (i.class) {
            if (c == null) {
                c = new i();
            }
        }
    }

    public m a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, m mVar) {
        b.put(str, mVar);
    }

    public l b() {
        return this.a;
    }
}
