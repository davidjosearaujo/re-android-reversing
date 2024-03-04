package androidx.lifecycle;

import androidx.lifecycle.g;
import androidx.savedstate.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f {

    /* loaded from: classes.dex */
    public static final class a implements a.InterfaceC0024a {
        @Override // androidx.savedstate.a.InterfaceC0024a
        public final void a(h2.c cVar) {
            r5.h.f(cVar, "owner");
            if (!(cVar instanceof f0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            e0 i7 = ((f0) cVar).i();
            androidx.savedstate.a b2 = cVar.b();
            i7.getClass();
            Iterator it = new HashSet(i7.f1859a.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                r5.h.f(str, "key");
                c0 c0Var = (c0) i7.f1859a.get(str);
                r5.h.c(c0Var);
                f.a(c0Var, b2, cVar.k());
            }
            if (!new HashSet(i7.f1859a.keySet()).isEmpty()) {
                b2.d();
            }
        }
    }

    public static final void a(c0 c0Var, androidx.savedstate.a aVar, g gVar) {
        Object obj;
        r5.h.f(aVar, "registry");
        r5.h.f(gVar, "lifecycle");
        HashMap hashMap = c0Var.f1854a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = c0Var.f1854a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f1839f) {
            return;
        }
        savedStateHandleController.a(gVar, aVar);
        b(gVar, aVar);
    }

    public static void b(final g gVar, final androidx.savedstate.a aVar) {
        g.b b2 = gVar.b();
        if (b2 != g.b.INITIALIZED) {
            if (!(b2.compareTo(g.b.STARTED) >= 0)) {
                gVar.a(new l() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                    @Override // androidx.lifecycle.l
                    public final void c(n nVar, g.a aVar2) {
                        if (aVar2 == g.a.ON_START) {
                            g.this.c(this);
                            aVar.d();
                        }
                    }
                });
                return;
            }
        }
        aVar.d();
    }
}
