package com.bumptech.glide;

import android.os.Trace;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class k implements k3.g<j> {

    /* renamed from: a */
    public boolean f2656a;

    /* renamed from: b */
    public final /* synthetic */ b f2657b;

    /* renamed from: c */
    public final /* synthetic */ List f2658c;

    public k(b bVar, ArrayList arrayList, e3.a aVar) {
        this.f2657b = bVar;
        this.f2658c = arrayList;
    }

    @Override // k3.g
    public final j get() {
        if (this.f2656a) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        this.f2656a = true;
        Trace.beginSection("Glide registry");
        try {
            return l.a(this.f2657b, this.f2658c);
        } finally {
            Trace.endSection();
        }
    }
}
