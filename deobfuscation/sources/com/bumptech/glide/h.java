package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    public final Map<Class<?>, Object> f2640a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final HashMap f2641a = new HashMap();
    }

    public h(a aVar) {
        this.f2640a = Collections.unmodifiableMap(new HashMap(aVar.f2641a));
    }
}
