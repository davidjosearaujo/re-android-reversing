package com.bumptech.glide;

import a6.a0;
import android.content.Context;
import android.content.ContextWrapper;
import com.bumptech.glide.b;
import java.util.List;
import java.util.Map;
import k3.f;
import r2.m;
import s2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends ContextWrapper {

    /* renamed from: k */
    public static final a f2630k = new a();

    /* renamed from: a */
    public final b f2631a;

    /* renamed from: b */
    public final f f2632b;

    /* renamed from: c */
    public final a0 f2633c;

    /* renamed from: d */
    public final b.a f2634d;
    public final List<g3.f<Object>> e;

    /* renamed from: f */
    public final Map<Class<?>, o<?, ?>> f2635f;

    /* renamed from: g */
    public final m f2636g;

    /* renamed from: h */
    public final h f2637h;

    /* renamed from: i */
    public final int f2638i;

    /* renamed from: j */
    public g3.g f2639j;

    public g(Context context, s2.b bVar, k kVar, a0 a0Var, c cVar, o.b bVar2, List list, m mVar, h hVar, int i7) {
        super(context.getApplicationContext());
        this.f2631a = bVar;
        this.f2633c = a0Var;
        this.f2634d = cVar;
        this.e = list;
        this.f2635f = bVar2;
        this.f2636g = mVar;
        this.f2637h = hVar;
        this.f2638i = i7;
        this.f2632b = new f(kVar);
    }

    public final j a() {
        return (j) this.f2632b.get();
    }
}
