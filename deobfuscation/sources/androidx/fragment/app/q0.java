package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.n;
import androidx.fragment.app.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a */
    public final ViewGroup f1743a;

    /* renamed from: b */
    public final ArrayList<b> f1744b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<b> f1745c = new ArrayList<>();

    /* renamed from: d */
    public boolean f1746d = false;
    public boolean e = false;

    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: h */
        public final d0 f1747h;

        public a(int i7, int i8, d0 d0Var, l1.d dVar) {
            super(i7, i8, d0Var.f1613c, dVar);
            this.f1747h = d0Var;
        }

        @Override // androidx.fragment.app.q0.b
        public final void b() {
            super.b();
            this.f1747h.k();
        }

        @Override // androidx.fragment.app.q0.b
        public final void d() {
            if (this.f1749b == 2) {
                n nVar = this.f1747h.f1613c;
                View findFocus = nVar.J.findFocus();
                if (findFocus != null) {
                    nVar.g().m = findFocus;
                    if (x.K(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + nVar);
                    }
                }
                View M = this.f1750c.M();
                if (M.getParent() == null) {
                    this.f1747h.b();
                    M.setAlpha(0.0f);
                }
                if (M.getAlpha() == 0.0f && M.getVisibility() == 0) {
                    M.setVisibility(4);
                }
                n.b bVar = nVar.M;
                M.setAlpha(bVar == null ? 1.0f : bVar.f1730l);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public int f1748a;

        /* renamed from: b */
        public int f1749b;

        /* renamed from: c */
        public final n f1750c;

        /* renamed from: d */
        public final ArrayList f1751d = new ArrayList();
        public final HashSet<l1.d> e = new HashSet<>();

        /* renamed from: f */
        public boolean f1752f = false;

        /* renamed from: g */
        public boolean f1753g = false;

        public b(int i7, int i8, n nVar, l1.d dVar) {
            this.f1748a = i7;
            this.f1749b = i8;
            this.f1750c = nVar;
            dVar.b(new r0((a) this));
        }

        public final void a() {
            if (this.f1752f) {
                return;
            }
            this.f1752f = true;
            if (this.e.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((l1.d) it.next()).a();
            }
        }

        public void b() {
            if (this.f1753g) {
                return;
            }
            if (x.K(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1753g = true;
            Iterator it = this.f1751d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void c(int i7, int i8) {
            if (i8 == 0) {
                throw null;
            }
            int i9 = i8 - 1;
            if (i9 == 0) {
                if (this.f1748a != 1) {
                    if (x.K(2)) {
                        StringBuilder d7 = androidx.activity.h.d("SpecialEffectsController: For fragment ");
                        d7.append(this.f1750c);
                        d7.append(" mFinalState = ");
                        d7.append(s0.l(this.f1748a));
                        d7.append(" -> ");
                        d7.append(s0.l(i7));
                        d7.append(". ");
                        Log.v("FragmentManager", d7.toString());
                    }
                    this.f1748a = i7;
                }
            } else if (i9 == 1) {
                if (this.f1748a == 1) {
                    if (x.K(2)) {
                        StringBuilder d8 = androidx.activity.h.d("SpecialEffectsController: For fragment ");
                        d8.append(this.f1750c);
                        d8.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        d8.append(androidx.activity.h.e(this.f1749b));
                        d8.append(" to ADDING.");
                        Log.v("FragmentManager", d8.toString());
                    }
                    this.f1748a = 2;
                    this.f1749b = 2;
                }
            } else if (i9 != 2) {
            } else {
                if (x.K(2)) {
                    StringBuilder d9 = androidx.activity.h.d("SpecialEffectsController: For fragment ");
                    d9.append(this.f1750c);
                    d9.append(" mFinalState = ");
                    d9.append(s0.l(this.f1748a));
                    d9.append(" -> REMOVED. mLifecycleImpact  = ");
                    d9.append(androidx.activity.h.e(this.f1749b));
                    d9.append(" to REMOVING.");
                    Log.v("FragmentManager", d9.toString());
                }
                this.f1748a = 1;
                this.f1749b = 3;
            }
        }

        public void d() {
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + s0.l(this.f1748a) + "} {mLifecycleImpact = " + androidx.activity.h.e(this.f1749b) + "} {mFragment = " + this.f1750c + "}";
        }
    }

    public q0(ViewGroup viewGroup) {
        this.f1743a = viewGroup;
    }

    public static q0 f(ViewGroup viewGroup, t0 t0Var) {
        Object tag = viewGroup.getTag(2131296798);
        if (tag instanceof q0) {
            return (q0) tag;
        }
        ((x.f) t0Var).getClass();
        l lVar = new l(viewGroup);
        viewGroup.setTag(2131296798, lVar);
        return lVar;
    }

    public final void a(int i7, int i8, d0 d0Var) {
        synchronized (this.f1744b) {
            l1.d dVar = new l1.d();
            b d7 = d(d0Var.f1613c);
            if (d7 != null) {
                d7.c(i7, i8);
                return;
            }
            a aVar = new a(i7, i8, d0Var, dVar);
            this.f1744b.add(aVar);
            aVar.f1751d.add(new o0(this, aVar));
            aVar.f1751d.add(new p0(this, aVar));
        }
    }

    public abstract void b(ArrayList arrayList, boolean z6);

    public final void c() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.f1743a;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        if (!y.g.b(viewGroup)) {
            e();
            this.f1746d = false;
            return;
        }
        synchronized (this.f1744b) {
            if (!this.f1744b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f1745c);
                this.f1745c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (x.K(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + bVar);
                    }
                    bVar.a();
                    if (!bVar.f1753g) {
                        this.f1745c.add(bVar);
                    }
                }
                h();
                ArrayList arrayList2 = new ArrayList(this.f1744b);
                this.f1744b.clear();
                this.f1745c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).d();
                }
                b(arrayList2, this.f1746d);
                this.f1746d = false;
            }
        }
    }

    public final b d(n nVar) {
        Iterator<b> it = this.f1744b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1750c.equals(nVar) && !next.f1752f) {
                return next;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f1743a;
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        boolean b2 = y.g.b(viewGroup);
        synchronized (this.f1744b) {
            h();
            Iterator<b> it = this.f1744b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.f1745c).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (x.K(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (b2) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f1743a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(bVar);
                    Log.v("FragmentManager", sb.toString());
                }
                bVar.a();
            }
            Iterator it3 = new ArrayList(this.f1744b).iterator();
            while (it3.hasNext()) {
                b bVar2 = (b) it3.next();
                if (x.K(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (b2) {
                        str = "";
                    } else {
                        str = "Container " + this.f1743a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(bVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                bVar2.a();
            }
        }
    }

    public final void g() {
        synchronized (this.f1744b) {
            h();
            this.e = false;
            int size = this.f1744b.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                b bVar = this.f1744b.get(size);
                int d7 = s0.d(bVar.f1750c.J);
                if (bVar.f1748a == 2 && d7 != 2) {
                    bVar.f1750c.getClass();
                    this.e = false;
                    break;
                }
            }
        }
    }

    public final void h() {
        Iterator<b> it = this.f1744b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f1749b == 2) {
                next.c(s0.c(next.f1750c.M().getVisibility()), 1);
            }
        }
    }
}
