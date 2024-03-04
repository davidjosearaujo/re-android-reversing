package h2;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.savedstate.Recreator;
import androidx.savedstate.a;
import java.util.Map;
import l.b;
import r5.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public final c f4375a;

    /* renamed from: b */
    public final androidx.savedstate.a f4376b = new androidx.savedstate.a();

    /* renamed from: c */
    public boolean f4377c;

    public b(c cVar) {
        this.f4375a = cVar;
    }

    public final void a() {
        o k6 = this.f4375a.k();
        if (!(k6.f1876d == g.b.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        k6.a(new Recreator(this.f4375a));
        final androidx.savedstate.a aVar = this.f4376b;
        aVar.getClass();
        if (!(!aVar.f2293b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        k6.a(new l() { // from class: h2.a
            @Override // androidx.lifecycle.l
            public final void c(n nVar, g.a aVar2) {
                boolean z6;
                androidx.savedstate.a aVar3 = androidx.savedstate.a.this;
                h.f(aVar3, "this$0");
                if (aVar2 == g.a.ON_START) {
                    z6 = true;
                } else if (aVar2 != g.a.ON_STOP) {
                    return;
                } else {
                    z6 = false;
                }
                aVar3.f2296f = z6;
            }
        });
        aVar.f2293b = true;
        this.f4377c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f4377c) {
            a();
        }
        o k6 = this.f4375a.k();
        if (!(!(k6.f1876d.compareTo(g.b.STARTED) >= 0))) {
            StringBuilder d7 = androidx.activity.h.d("performRestore cannot be called when owner is ");
            d7.append(k6.f1876d);
            throw new IllegalStateException(d7.toString().toString());
        }
        androidx.savedstate.a aVar = this.f4376b;
        if (!aVar.f2293b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!aVar.f2295d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        aVar.f2294c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        aVar.f2295d = true;
    }

    public final void c(Bundle bundle) {
        h.f(bundle, "outBundle");
        androidx.savedstate.a aVar = this.f4376b;
        aVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aVar.f2294c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        l.b<String, a.b> bVar = aVar.f2292a;
        bVar.getClass();
        b.d dVar = new b.d();
        bVar.f4831h.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
