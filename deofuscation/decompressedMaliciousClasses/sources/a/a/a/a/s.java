package a.a.a.a;

import a.a.a.e.f;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/remnux/decompressedMalicious.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f52a = {0, 3, 0, 1, 5, 4, 7, 6};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f53a;

        a(ArrayList arrayList) {
            this.f53a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.D(this.f53a, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f54a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f55b;
        final /* synthetic */ h c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ ArrayList e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ Object g;

        b(Object obj, View view, h hVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f54a = obj;
            this.f55b = view;
            this.c = hVar;
            this.d = arrayList;
            this.e = arrayList2;
            this.f = arrayList3;
            this.g = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f54a;
            if (obj != null) {
                t.q(obj, this.f55b);
                this.e.addAll(s.n(this.f54a, this.c, this.d, this.f55b));
            }
            if (this.f != null) {
                if (this.g != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f55b);
                    t.r(this.g, this.f, arrayList);
                }
                this.f.clear();
                this.f.add(this.f55b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f56a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h f57b;
        final /* synthetic */ boolean c;
        final /* synthetic */ a.a.a.d.a d;
        final /* synthetic */ View e;
        final /* synthetic */ Rect f;

        c(h hVar, h hVar2, boolean z, a.a.a.d.a aVar, View view, Rect rect) {
            this.f56a = hVar;
            this.f57b = hVar2;
            this.c = z;
            this.d = aVar;
            this.e = view;
            this.f = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            s.k(this.f56a, this.f57b, this.c, this.d, false);
            View view = this.e;
            if (view != null) {
                t.k(view, this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.a.d.a f58a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f59b;
        final /* synthetic */ e c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ View e;
        final /* synthetic */ h f;
        final /* synthetic */ h g;
        final /* synthetic */ boolean h;
        final /* synthetic */ ArrayList i;
        final /* synthetic */ Object j;
        final /* synthetic */ Rect k;

        d(a.a.a.d.a aVar, Object obj, e eVar, ArrayList arrayList, View view, h hVar, h hVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f58a = aVar;
            this.f59b = obj;
            this.c = eVar;
            this.d = arrayList;
            this.e = view;
            this.f = hVar;
            this.g = hVar2;
            this.h = z;
            this.i = arrayList2;
            this.j = obj2;
            this.k = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a.a.d.a l = s.l(this.f58a, this.f59b, this.c);
            if (l != null) {
                this.d.addAll(l.values());
                this.d.add(this.e);
            }
            s.k(this.f, this.g, this.h, l, false);
            Object obj = this.f59b;
            if (obj != null) {
                t.A(obj, this.i, this.d);
                View w = s.w(l, this.c, this.j, this.h);
                if (w != null) {
                    t.k(w, this.k);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /home/remnux/decompressedMalicious.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public h f60a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f61b;
        public b c;
        public h d;
        public boolean e;
        public b f;

        e() {
        }
    }

    private static void A(a.a.a.d.a<String, String> aVar, a.a.a.d.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.l(size))) {
                aVar.j(size);
            }
        }
    }

    private static void B(ViewGroup viewGroup, h hVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        i0.a(viewGroup, new b(obj, view, hVar, arrayList, arrayList2, arrayList3, obj2));
    }

    private static void C(Object obj, Object obj2, a.a.a.d.a<String, View> aVar, boolean z, b bVar) {
        ArrayList<String> arrayList = bVar.q;
        if (arrayList != null && !arrayList.isEmpty()) {
            View view = aVar.get((z ? bVar.r : bVar.q).get(0));
            t.w(obj, view);
            if (obj2 != null) {
                t.w(obj2, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(n nVar, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (nVar.l >= 1 && Build.VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                b bVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    j(bVar, sparseArray, z);
                } else {
                    h(bVar, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(nVar.m.h());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    a.a.a.d.a<String, String> i5 = i(keyAt, arrayList, arrayList2, i, i2);
                    e eVar = (e) sparseArray.valueAt(i4);
                    if (z) {
                        q(nVar, keyAt, eVar, view, i5);
                    } else {
                        r(nVar, keyAt, eVar, view, i5);
                    }
                }
            }
        }
    }

    private static void f(ArrayList<View> arrayList, a.a.a.d.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View l = aVar.l(size);
            if (collection.contains(f.b(l))) {
                arrayList.add(l);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
        if (r10.j != false) goto L_0x008f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0073, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008d, code lost:
        if (r10.x == false) goto L_0x008f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008f, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g(a.a.a.a.b r16, a.a.a.a.b.a r17, android.util.SparseArray<a.a.a.a.s.e> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.s.g(a.a.a.a.b, a.a.a.a.b$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void h(b bVar, SparseArray<e> sparseArray, boolean z) {
        int size = bVar.f3b.size();
        for (int i = 0; i < size; i++) {
            g(bVar, bVar.f3b.get(i), sparseArray, false, z);
        }
    }

    private static a.a.a.d.a<String, String> i(int i, ArrayList<b> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        a.a.a.d.a<String, String> aVar = new a.a.a.d.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            b bVar = arrayList.get(i4);
            if (bVar.p(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = bVar.q;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = bVar.q;
                        arrayList4 = bVar.r;
                    } else {
                        arrayList4 = bVar.q;
                        arrayList3 = bVar.r;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void j(b bVar, SparseArray<e> sparseArray, boolean z) {
        if (bVar.f2a.n.b()) {
            for (int size = bVar.f3b.size() - 1; size >= 0; size--) {
                g(bVar, bVar.f3b.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(h hVar, h hVar2, boolean z, a.a.a.d.a<String, View> aVar, boolean z2) {
        n0 l = z ? hVar2.l() : hVar.l();
        if (l != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.h(i));
                arrayList.add(aVar.l(i));
            }
            if (z2) {
                l.c(arrayList2, arrayList, null);
            } else {
                l.b(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static a.a.a.d.a<String, View> l(a.a.a.d.a<String, String> aVar, Object obj, e eVar) {
        n0 n0Var;
        ArrayList<String> arrayList;
        String t;
        h hVar = eVar.f60a;
        View z = hVar.z();
        if (aVar.isEmpty() || obj == null || z == null) {
            aVar.clear();
            return null;
        }
        a.a.a.d.a<String, View> aVar2 = new a.a.a.d.a<>();
        t.j(aVar2, z);
        b bVar = eVar.c;
        if (eVar.f61b) {
            n0Var = hVar.n();
            arrayList = bVar.q;
        } else {
            n0Var = hVar.l();
            arrayList = bVar.r;
        }
        aVar2.n(arrayList);
        if (n0Var != null) {
            n0Var.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    String t2 = t(aVar, str);
                    if (t2 != null) {
                        aVar.remove(t2);
                    }
                } else if (!str.equals(f.b(view)) && (t = t(aVar, str)) != null) {
                    aVar.put(t, f.b(view));
                }
            }
        } else {
            A(aVar, aVar2);
        }
        return aVar2;
    }

    private static a.a.a.d.a<String, View> m(a.a.a.d.a<String, String> aVar, Object obj, e eVar) {
        ArrayList<String> arrayList;
        n0 n0Var;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        h hVar = eVar.d;
        a.a.a.d.a<String, View> aVar2 = new a.a.a.d.a<>();
        t.j(aVar2, hVar.z());
        b bVar = eVar.f;
        if (eVar.e) {
            n0Var = hVar.l();
            arrayList = bVar.r;
        } else {
            n0Var = hVar.n();
            arrayList = bVar.q;
        }
        aVar2.n(arrayList);
        if (n0Var != null) {
            n0Var.a(arrayList, aVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar2.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(f.b(view))) {
                    aVar.put(f.b(view), aVar.remove(str));
                }
            }
        } else {
            aVar.n(aVar2.keySet());
        }
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<View> n(Object obj, h hVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        t.f(arrayList2, hVar.z());
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        t.c(obj, arrayList2);
        return arrayList2;
    }

    private static Object o(ViewGroup viewGroup, View view, a.a.a.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Rect rect;
        View view2;
        h hVar = eVar.f60a;
        h hVar2 = eVar.d;
        if (hVar != null) {
            hVar.z().setVisibility(0);
        }
        if (hVar == null || hVar2 == null) {
            return null;
        }
        boolean z = eVar.f61b;
        Object x = aVar.isEmpty() ? null : x(hVar, hVar2, z);
        a.a.a.d.a<String, View> m = m(aVar, x, eVar);
        a.a.a.d.a<String, View> l = l(aVar, x, eVar);
        if (aVar.isEmpty()) {
            if (m != null) {
                m.clear();
            }
            if (l != null) {
                l.clear();
            }
            x = null;
        } else {
            f(arrayList, m, aVar.keySet());
            f(arrayList2, l, aVar.values());
        }
        if (obj == null && obj2 == null && x == null) {
            return null;
        }
        k(hVar, hVar2, z, m, true);
        if (x != null) {
            arrayList2.add(view);
            t.z(x, view, arrayList);
            C(x, obj2, m, eVar.e, eVar.f);
            Rect rect2 = new Rect();
            View w = w(l, eVar, obj, z);
            if (w != null) {
                t.v(obj, rect2);
            }
            rect = rect2;
            view2 = w;
        } else {
            view2 = null;
            rect = null;
        }
        i0.a(viewGroup, new c(hVar, hVar2, z, l, view2, rect));
        return x;
    }

    private static Object p(ViewGroup viewGroup, View view, a.a.a.d.a<String, String> aVar, e eVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        a.a.a.d.a<String, String> aVar2;
        Object obj3;
        Object obj4;
        h hVar = eVar.f60a;
        h hVar2 = eVar.d;
        Rect rect = null;
        if (hVar == null || hVar2 == null) {
            return null;
        }
        boolean z = eVar.f61b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            obj3 = null;
        } else {
            obj3 = x(hVar, hVar2, z);
            aVar2 = aVar;
        }
        a.a.a.d.a<String, View> m = m(aVar2, obj3, eVar);
        if (aVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList.addAll(m.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        k(hVar, hVar2, z, m, true);
        if (obj4 != null) {
            rect = new Rect();
            t.z(obj4, view, arrayList);
            C(obj4, obj2, m, eVar.e, eVar.f);
            if (obj != null) {
                t.v(obj, rect);
            }
        }
        i0.a(viewGroup, new d(aVar, obj4, eVar, arrayList2, view, hVar, hVar2, z, arrayList, obj, rect));
        return obj4;
    }

    private static void q(n nVar, int i, e eVar, View view, a.a.a.d.a<String, String> aVar) {
        Object obj;
        ViewGroup viewGroup = nVar.n.b() ? (ViewGroup) nVar.n.a(i) : null;
        if (viewGroup != null) {
            h hVar = eVar.f60a;
            h hVar2 = eVar.d;
            boolean z = eVar.f61b;
            boolean z2 = eVar.e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object u = u(hVar, z);
            Object v = v(hVar2, z2);
            Object o = o(viewGroup, view, aVar, eVar, arrayList2, arrayList, u, v);
            if (u == null && o == null) {
                obj = v;
                if (obj == null) {
                    return;
                }
            } else {
                obj = v;
            }
            ArrayList<View> n = n(obj, hVar2, arrayList2, view);
            ArrayList<View> n2 = n(u, hVar, arrayList, view);
            D(n2, 4);
            Object y = y(u, obj, o, hVar, z);
            if (y != null) {
                z(obj, hVar2, n);
                ArrayList<String> p = t.p(arrayList);
                t.u(y, u, n2, obj, n, o, arrayList);
                t.d(viewGroup, y);
                t.x(viewGroup, arrayList2, arrayList, p, aVar);
                D(n2, 0);
                t.A(o, arrayList2, arrayList);
            }
        }
    }

    private static void r(n nVar, int i, e eVar, View view, a.a.a.d.a<String, String> aVar) {
        Object obj;
        ViewGroup viewGroup = nVar.n.b() ? (ViewGroup) nVar.n.a(i) : null;
        if (viewGroup != null) {
            h hVar = eVar.f60a;
            h hVar2 = eVar.d;
            boolean z = eVar.f61b;
            boolean z2 = eVar.e;
            Object u = u(hVar, z);
            Object v = v(hVar2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object p = p(viewGroup, view, aVar, eVar, arrayList, arrayList2, u, v);
            if (u == null && p == null) {
                obj = v;
                if (obj == null) {
                    return;
                }
            } else {
                obj = v;
            }
            ArrayList<View> n = n(obj, hVar2, arrayList, view);
            Object obj2 = (n == null || n.isEmpty()) ? null : obj;
            t.b(u, view);
            Object y = y(u, obj2, p, hVar, eVar.f61b);
            if (y != null) {
                ArrayList arrayList3 = new ArrayList();
                t.u(y, u, arrayList3, obj2, n, p, arrayList2);
                B(viewGroup, hVar, view, arrayList2, u, arrayList3, obj2, n);
                t.y(viewGroup, arrayList2, aVar);
                t.d(viewGroup, y);
                t.t(viewGroup, arrayList2, aVar);
            }
        }
    }

    private static e s(e eVar, SparseArray<e> sparseArray, int i) {
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        sparseArray.put(i, eVar2);
        return eVar2;
    }

    private static String t(a.a.a.d.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.l(i))) {
                return aVar.h(i);
            }
        }
        return null;
    }

    private static Object u(h hVar, boolean z) {
        if (hVar == null) {
            return null;
        }
        return t.g(z ? hVar.t() : hVar.k());
    }

    private static Object v(h hVar, boolean z) {
        if (hVar == null) {
            return null;
        }
        return t.g(z ? hVar.v() : hVar.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View w(a.a.a.d.a<String, View> aVar, e eVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        b bVar = eVar.c;
        if (obj == null || (arrayList = bVar.q) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? bVar.q : bVar.r).get(0));
    }

    private static Object x(h hVar, h hVar2, boolean z) {
        if (hVar == null || hVar2 == null) {
            return null;
        }
        return t.B(t.g(z ? hVar2.x() : hVar.w()));
    }

    private static Object y(Object obj, Object obj2, Object obj3, h hVar, boolean z) {
        return (obj == null || obj2 == null || hVar == null) ? true : z ? hVar.h() : hVar.g() ? t.o(obj2, obj, obj3) : t.n(obj2, obj, obj3);
    }

    private static void z(Object obj, h hVar, ArrayList<View> arrayList) {
        if (hVar != null && obj != null && hVar.j && hVar.x && hVar.O) {
            hVar.K0(true);
            t.s(obj, hVar.z(), arrayList);
            i0.a(hVar.E, new a(arrayList));
        }
    }
}
