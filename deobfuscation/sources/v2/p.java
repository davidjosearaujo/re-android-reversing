package v2;

import java.util.HashMap;
import java.util.List;
import l3.a;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a */
    public final r f6226a;

    /* renamed from: b */
    public final a f6227b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final HashMap f6228a = new HashMap();

        /* renamed from: v2.p$a$a */
        /* loaded from: classes.dex */
        public static class C0121a<Model> {

            /* renamed from: a */
            public final List<n<Model, ?>> f6229a;

            public C0121a(List<n<Model, ?>> list) {
                this.f6229a = list;
            }
        }

        public final <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (((C0121a) this.f6228a.put(cls, new C0121a(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(a.c cVar) {
        r rVar = new r(cVar);
        this.f6227b = new a();
        this.f6226a = rVar;
    }
}