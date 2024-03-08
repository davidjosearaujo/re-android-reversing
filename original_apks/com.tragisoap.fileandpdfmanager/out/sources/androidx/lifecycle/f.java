package androidx.lifecycle;

import androidx.lifecycle.g;
import androidx.savedstate.a;
import h2.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements a.AbstractC0024a {
        @Override // androidx.savedstate.a.AbstractC0024a
        public final void a(c cVar) {
            h.f(cVar, "owner");
            if (cVar instanceof f0) {
                e0 i7 = ((f0) cVar).i();
                androidx.savedstate.a b2 = cVar.b();
                i7.getClass();
                Iterator it = new HashSet(i7.f1859a.keySet()).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    h.f(str, "key");
                    c0 c0Var = (c0) i7.f1859a.get(str);
                    h.c(c0Var);
                    f.a(c0Var, b2, cVar.k());
                }
                if (!new HashSet(i7.f1859a.keySet()).isEmpty()) {
                    b2.d();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final void a(c0 c0Var, androidx.savedstate.a aVar, g gVar) {
        Object obj;
        h.f(aVar, "registry");
        h.f(gVar, "lifecycle");
        HashMap hashMap = c0Var.f1854a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = c0Var.f1854a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController != null && !savedStateHandleController.f1839f) {
            savedStateHandleController.a(gVar, aVar);
            b(gVar, aVar);
        }
    }

    public static void b(g gVar, androidx.savedstate.a aVar) {
        g.b b2 = gVar.b();
        if (b2 != g.b.INITIALIZED) {
            if (!(b2.compareTo(g.b.STARTED) >= 0)) {
                gVar.a(new l(aVar) { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ a f1820g;

                    {
                        this.f1820g = r2;
                    }

                    @Override // androidx.lifecycle.l
                    public final void c(n nVar, g.a aVar2) {
                        if (aVar2 == g.a.ON_START) {
                            g.this.c(this);
                            this.f1820g.d();
                        }
                    }
                });
                return;
            }
        }
        aVar.d();
    }
}
