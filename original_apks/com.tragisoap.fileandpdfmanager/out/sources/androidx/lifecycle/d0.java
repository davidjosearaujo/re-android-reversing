package androidx.lifecycle;

import a0.e;
import d2.a;
import d2.c;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f1856a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1857b;

    /* renamed from: c  reason: collision with root package name */
    public final d2.a f1858c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        default c0 a(Class cls, c cVar) {
            return b(cls);
        }

        default <T extends c0> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public void a(c0 c0Var) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d0(e0 e0Var, a aVar) {
        this(e0Var, aVar, a.C0044a.f3556b);
        h.f(e0Var, "store");
        h.f(aVar, "factory");
    }

    public d0(e0 e0Var, a aVar, d2.a aVar2) {
        h.f(e0Var, "store");
        h.f(aVar, "factory");
        h.f(aVar2, "defaultCreationExtras");
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
        c0 c0Var;
        h.f(str, "key");
        e0 e0Var = this.f1856a;
        e0Var.getClass();
        c0 c0Var2 = (c0) e0Var.f1859a.get(str);
        if (cls.isInstance(c0Var2)) {
            a aVar = this.f1857b;
            b bVar = aVar instanceof b ? (b) aVar : null;
            if (bVar != null) {
                h.c(c0Var2);
                bVar.a(c0Var2);
            }
            h.d(c0Var2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return c0Var2;
        }
        c cVar = new c(this.f1858c);
        cVar.f3555a.put(e.f48n, str);
        try {
            c0Var = this.f1857b.a(cls, cVar);
        } catch (AbstractMethodError unused) {
            c0Var = this.f1857b.b(cls);
        }
        e0 e0Var2 = this.f1856a;
        e0Var2.getClass();
        h.f(c0Var, "viewModel");
        c0 c0Var3 = (c0) e0Var2.f1859a.put(str, c0Var);
        if (c0Var3 != null) {
            c0Var3.b();
        }
        return c0Var;
    }
}
