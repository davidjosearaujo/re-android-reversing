package androidx.fragment.app;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class e0 implements d3.b {

    /* renamed from: f */
    public final Object f1617f;

    /* renamed from: g */
    public final Object f1618g;

    /* renamed from: h */
    public Object f1619h;

    public /* synthetic */ e0() {
        this.f1617f = new ArrayList();
        this.f1618g = new HashMap();
    }

    public /* synthetic */ e0(s2.d dVar, d3.a aVar, a6.a0 a0Var) {
        this.f1617f = dVar;
        this.f1618g = aVar;
        this.f1619h = a0Var;
    }

    public final void a(n nVar) {
        if (((ArrayList) this.f1617f).contains(nVar)) {
            throw new IllegalStateException("Fragment already added: " + nVar);
        }
        synchronized (((ArrayList) this.f1617f)) {
            ((ArrayList) this.f1617f).add(nVar);
        }
        nVar.f1709p = true;
    }

    @Override // d3.b
    public final r2.v b(r2.v vVar, p2.h hVar) {
        Drawable drawable = (Drawable) vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return ((d3.b) this.f1618g).b(y2.d.d(((BitmapDrawable) drawable).getBitmap(), (s2.d) this.f1617f), hVar);
        }
        if (drawable instanceof c3.c) {
            return ((d3.b) this.f1619h).b(vVar, hVar);
        }
        return null;
    }

    public final void c() {
        ((HashMap) this.f1618g).values().removeAll(Collections.singleton(null));
    }

    public final n d(String str) {
        d0 d0Var = (d0) ((HashMap) this.f1618g).get(str);
        if (d0Var != null) {
            return d0Var.f1613c;
        }
        return null;
    }

    public final n e(String str) {
        for (d0 d0Var : ((HashMap) this.f1618g).values()) {
            if (d0Var != null) {
                n nVar = d0Var.f1613c;
                if (!str.equals(nVar.f1704j)) {
                    nVar = nVar.f1717y.f1775c.e(str);
                }
                if (nVar != null) {
                    return nVar;
                }
            }
        }
        return null;
    }

    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : ((HashMap) this.f1618g).values()) {
            if (d0Var != null) {
                arrayList.add(d0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : ((HashMap) this.f1618g).values()) {
            arrayList.add(d0Var != null ? d0Var.f1613c : null);
        }
        return arrayList;
    }

    public final List h() {
        ArrayList arrayList;
        if (((ArrayList) this.f1617f).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f1617f)) {
            arrayList = new ArrayList((ArrayList) this.f1617f);
        }
        return arrayList;
    }

    public final void i(d0 d0Var) {
        n nVar = d0Var.f1613c;
        if (((HashMap) this.f1618g).get(nVar.f1704j) != null) {
            return;
        }
        ((HashMap) this.f1618g).put(nVar.f1704j, d0Var);
        if (x.K(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + nVar);
        }
    }

    public final void j(d0 d0Var) {
        n nVar = d0Var.f1613c;
        if (nVar.F) {
            ((a0) this.f1619h).c(nVar);
        }
        if (((d0) ((HashMap) this.f1618g).put(nVar.f1704j, null)) != null && x.K(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + nVar);
        }
    }
}
