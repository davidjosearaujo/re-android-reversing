package androidx.fragment.app;

import android.content.Context;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.q0;
import androidx.fragment.app.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;
import l1.d;
import o.g;
import p1.e0;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends q0 {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends b {

        /* renamed from: c */
        public boolean f1673c;

        /* renamed from: d */
        public boolean f1674d = false;
        public r.a e;

        public a(q0.b bVar, d dVar, boolean z6) {
            super(bVar, dVar);
            this.f1673c = z6;
        }

        public final r.a c(Context context) {
            if (this.f1674d) {
                return this.e;
            }
            q0.b bVar = this.f1675a;
            r.a a7 = r.a(context, bVar.f1750c, bVar.f1748a == 2, this.f1673c);
            this.e = a7;
            this.f1674d = true;
            return a7;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {

        /* renamed from: a */
        public final q0.b f1675a;

        /* renamed from: b */
        public final d f1676b;

        public b(q0.b bVar, d dVar) {
            this.f1675a = bVar;
            this.f1676b = dVar;
        }

        public final void a() {
            q0.b bVar = this.f1675a;
            if (bVar.e.remove(this.f1676b) && bVar.e.isEmpty()) {
                bVar.b();
            }
        }

        public final boolean b() {
            int d7 = s0.d(this.f1675a.f1750c.J);
            int i7 = this.f1675a.f1748a;
            return d7 == i7 || !(d7 == 2 || i7 == 2);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends b {

        /* renamed from: c */
        public final Object f1677c;

        /* renamed from: d */
        public final boolean f1678d;
        public final Object e;

        public c(q0.b bVar, d dVar, boolean z6, boolean z7) {
            super(bVar, dVar);
            Object obj;
            Object obj2;
            if (bVar.f1748a == 2) {
                if (z6) {
                    obj2 = bVar.f1750c.n();
                } else {
                    bVar.f1750c.getClass();
                    obj2 = null;
                }
                this.f1677c = obj2;
                bVar.f1750c.getClass();
            } else {
                if (z6) {
                    obj = bVar.f1750c.o();
                } else {
                    bVar.f1750c.getClass();
                    obj = null;
                }
                this.f1677c = obj;
            }
            this.f1678d = true;
            if (z7) {
                if (z6) {
                    this.e = bVar.f1750c.p();
                    return;
                }
                bVar.f1750c.getClass();
            }
            this.e = null;
        }

        public final l0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            i0 i0Var = g0.f1647a;
            if (i0Var != null && (obj instanceof Transition)) {
                return i0Var;
            }
            l0 l0Var = g0.f1648b;
            if (l0Var != null && l0Var.e(obj)) {
                return l0Var;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f1675a.f1750c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public l(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static void i(ArrayList arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!e0.b(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = viewGroup.getChildAt(i7);
                    if (childAt.getVisibility() == 0) {
                        i(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public static void j(o.b bVar, View view) {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        String k6 = y.i.k(view);
        if (k6 != null) {
            bVar.put(k6, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = viewGroup.getChildAt(i7);
                if (childAt.getVisibility() == 0) {
                    j(bVar, childAt);
                }
            }
        }
    }

    public static void k(o.b bVar, Collection collection) {
        Iterator it = ((g.b) bVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (!collection.contains(y.i.k((View) dVar.getValue()))) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x047e  */
    @Override // androidx.fragment.app.q0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.ArrayList r37, boolean r38) {
        /*
            Method dump skipped, instructions count: 1687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.b(java.util.ArrayList, boolean):void");
    }
}
