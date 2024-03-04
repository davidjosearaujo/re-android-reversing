package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import y2.t;

/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* renamed from: a */
    public final t f2683a;

    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {

        /* renamed from: a */
        public final s2.b f2684a;

        public a(s2.b bVar) {
            this.f2684a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public final Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public final e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f2684a);
        }
    }

    public k(InputStream inputStream, s2.b bVar) {
        t tVar = new t(inputStream, bVar);
        this.f2683a = tVar;
        tVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public final InputStream a() {
        this.f2683a.reset();
        return this.f2683a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        this.f2683a.d();
    }
}
