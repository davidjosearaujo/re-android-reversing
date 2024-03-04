package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b */
    public static final a f2670b = new a();

    /* renamed from: a */
    public final HashMap f2671a = new HashMap();

    /* loaded from: classes.dex */
    public class a implements e.a<Object> {
        @Override // com.bumptech.glide.load.data.e.a
        public final Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        public final e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements e<Object> {

        /* renamed from: a */
        public final Object f2672a;

        public b(Object obj) {
            this.f2672a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public final Object a() {
            return this.f2672a;
        }

        @Override // com.bumptech.glide.load.data.e
        public final void b() {
        }
    }
}
