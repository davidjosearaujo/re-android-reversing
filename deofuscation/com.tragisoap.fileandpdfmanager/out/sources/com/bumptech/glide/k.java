package com.bumptech.glide;

import android.os.Trace;
import e3.a;
import java.util.ArrayList;
import java.util.List;
import k3.g;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k implements g<j> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2656a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f2657b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f2658c;

    public k(b bVar, ArrayList arrayList, a aVar) {
        this.f2657b = bVar;
        this.f2658c = arrayList;
    }

    @Override // k3.g
    public final j get() {
        if (!this.f2656a) {
            this.f2656a = true;
            Trace.beginSection("Glide registry");
            try {
                return l.a(this.f2657b, this.f2658c);
            } finally {
                Trace.endSection();
            }
        } else {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
    }
}
