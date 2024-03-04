package androidx.lifecycle;

import d2.a;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a */
    public final e0 f1856a;

    /* renamed from: b */
    public final a f1857b;

    /* renamed from: c */
    public final d2.a f1858c;

    /* loaded from: classes.dex */
    public interface a {
        default c0 a(Class cls, d2.c cVar) {
            return b(cls);
        }

        default <T extends c0> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public void a(c0 c0Var) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(e0 e0Var, a aVar) {
        this(e0Var, aVar, a.C0044a.f3556b);
        r5.h.f(e0Var, "store");
        r5.h.f(aVar, "factory");
    }

    public d0(e0 e0Var, a aVar, d2.a aVar2) {
        r5.h.f(e0Var, "store");
        r5.h.f(aVar, "factory");
        r5.h.f(aVar2, "defaultCreationExtras");
        this.f1856a = e0Var;
        this.f1857b = aVar;
        this.f1858c = aVar2;
    }

    public final <T extends c0> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final c0 b(Class cls, String str) {
        c0 b2;
        r5.h.f(str, "key");
        e0 e0Var = this.f1856a;
        e0Var.getClass();
        c0 c0Var = (c0) e0Var.f1859a.get(str);
        if (cls.isInstance(c0Var)) {
            a aVar = this.f1857b;
            b bVar = aVar instanceof b ? (b) aVar : null;
            if (bVar != null) {
                r5.h.c(c0Var);
                bVar.a(c0Var);
            }
            r5.h.d(c0Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return c0Var;
        }
        d2.c cVar = new d2.c(this.f1858c);
        cVar.f3555a.put(a0.e.f48n, str);
        try {
            b2 = this.f1857b.a(cls, cVar);
        } catch (AbstractMethodError unused) {
            b2 = this.f1857b.b(cls);
        }
        e0 e0Var2 = this.f1856a;
        e0Var2.getClass();
        r5.h.f(b2, "viewModel");
        c0 c0Var2 = (c0) e0Var2.f1859a.put(str, b2);
        if (c0Var2 != null) {
            c0Var2.b();
        }
        return b2;
    }
}
