package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class x {
    public g a;
    public z b = new z(this);

    public x(g gVar) {
        this.a = gVar;
    }

    public final g a() {
        return this.a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.a, cls, this.b));
    }
}
