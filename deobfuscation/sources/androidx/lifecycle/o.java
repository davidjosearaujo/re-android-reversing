package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.lifecycle.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l.b;

/* loaded from: classes.dex */
public final class o extends g {

    /* renamed from: b */
    public final boolean f1874b;

    /* renamed from: c */
    public l.a<m, a> f1875c;

    /* renamed from: d */
    public g.b f1876d;
    public final WeakReference<n> e;

    /* renamed from: f */
    public int f1877f;

    /* renamed from: g */
    public boolean f1878g;

    /* renamed from: h */
    public boolean f1879h;

    /* renamed from: i */
    public ArrayList<g.b> f1880i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public g.b f1881a;

        /* renamed from: b */
        public l f1882b;

        public a(m mVar, g.b bVar) {
            l reflectiveGenericLifecycleObserver;
            r5.h.c(mVar);
            HashMap hashMap = q.f1883a;
            boolean z6 = mVar instanceof l;
            boolean z7 = mVar instanceof b;
            if (z6 && z7) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((b) mVar, (l) mVar);
            } else if (z7) {
                reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((b) mVar, null);
            } else if (z6) {
                reflectiveGenericLifecycleObserver = (l) mVar;
            } else {
                Class<?> cls = mVar.getClass();
                if (q.c(cls) == 2) {
                    Object obj = q.f1884b.get(cls);
                    r5.h.c(obj);
                    List list = (List) obj;
                    if (list.size() == 1) {
                        reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(q.a((Constructor) list.get(0), mVar));
                    } else {
                        int size = list.size();
                        d[] dVarArr = new d[size];
                        for (int i7 = 0; i7 < size; i7++) {
                            HashMap hashMap2 = q.f1883a;
                            dVarArr[i7] = q.a((Constructor) list.get(i7), mVar);
                        }
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(dVarArr);
                    }
                } else {
                    reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(mVar);
                }
            }
            this.f1882b = reflectiveGenericLifecycleObserver;
            this.f1881a = bVar;
        }

        public final void a(n nVar, g.a aVar) {
            g.b a7 = aVar.a();
            g.b bVar = this.f1881a;
            r5.h.f(bVar, "state1");
            if (a7.compareTo(bVar) < 0) {
                bVar = a7;
            }
            this.f1881a = bVar;
            this.f1882b.c(nVar, aVar);
            this.f1881a = a7;
        }
    }

    public o(n nVar) {
        r5.h.f(nVar, "provider");
        this.f1874b = true;
        this.f1875c = new l.a<>();
        this.f1876d = g.b.INITIALIZED;
        this.f1880i = new ArrayList<>();
        this.e = new WeakReference<>(nVar);
    }

    @Override // androidx.lifecycle.g
    public final void a(m mVar) {
        n nVar;
        ArrayList<g.b> arrayList;
        r5.h.f(mVar, "observer");
        e("addObserver");
        g.b bVar = this.f1876d;
        g.b bVar2 = g.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = g.b.INITIALIZED;
        }
        a aVar = new a(mVar, bVar2);
        if (this.f1875c.c(mVar, aVar) == null && (nVar = this.e.get()) != null) {
            boolean z6 = this.f1877f != 0 || this.f1878g;
            g.b d7 = d(mVar);
            this.f1877f++;
            while (aVar.f1881a.compareTo(d7) < 0 && this.f1875c.f4828j.containsKey(mVar)) {
                this.f1880i.add(aVar.f1881a);
                g.a.C0018a c0018a = g.a.Companion;
                g.b bVar3 = aVar.f1881a;
                c0018a.getClass();
                g.a a7 = g.a.C0018a.a(bVar3);
                if (a7 == null) {
                    StringBuilder d8 = androidx.activity.h.d("no event up from ");
                    d8.append(aVar.f1881a);
                    throw new IllegalStateException(d8.toString());
                }
                aVar.a(nVar, a7);
                this.f1880i.remove(arrayList.size() - 1);
                d7 = d(mVar);
            }
            if (!z6) {
                i();
            }
            this.f1877f--;
        }
    }

    @Override // androidx.lifecycle.g
    public final g.b b() {
        return this.f1876d;
    }

    @Override // androidx.lifecycle.g
    public final void c(m mVar) {
        r5.h.f(mVar, "observer");
        e("removeObserver");
        this.f1875c.b(mVar);
    }

    public final g.b d(m mVar) {
        a aVar;
        l.a<m, a> aVar2 = this.f1875c;
        g.b bVar = null;
        b.c<m, a> cVar = aVar2.f4828j.containsKey(mVar) ? aVar2.f4828j.get(mVar).f4836i : null;
        g.b bVar2 = (cVar == null || (aVar = cVar.f4834g) == null) ? null : aVar.f1881a;
        if (!this.f1880i.isEmpty()) {
            ArrayList<g.b> arrayList = this.f1880i;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        g.b bVar3 = this.f1876d;
        r5.h.f(bVar3, "state1");
        if (bVar2 == null || bVar2.compareTo(bVar3) >= 0) {
            bVar2 = bVar3;
        }
        return (bVar == null || bVar.compareTo(bVar2) >= 0) ? bVar2 : bVar;
    }

    @SuppressLint({"RestrictedApi"})
    public final void e(String str) {
        if (this.f1874b) {
            k.b.p().f4608f.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return;
            }
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    public final void f(g.a aVar) {
        r5.h.f(aVar, "event");
        e("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(g.b bVar) {
        g.b bVar2 = g.b.DESTROYED;
        g.b bVar3 = this.f1876d;
        if (bVar3 == bVar) {
            return;
        }
        if (!((bVar3 == g.b.INITIALIZED && bVar == bVar2) ? false : true)) {
            StringBuilder d7 = androidx.activity.h.d("no event down from ");
            d7.append(this.f1876d);
            d7.append(" in component ");
            d7.append(this.e.get());
            throw new IllegalStateException(d7.toString().toString());
        }
        this.f1876d = bVar;
        if (this.f1878g || this.f1877f != 0) {
            this.f1879h = true;
            return;
        }
        this.f1878g = true;
        i();
        this.f1878g = false;
        if (this.f1876d == bVar2) {
            this.f1875c = new l.a<>();
        }
    }

    public final void h() {
        g.b bVar = g.b.CREATED;
        e("setCurrentState");
        g(bVar);
    }

    public final void i() {
        ArrayList<g.b> arrayList;
        ArrayList<g.b> arrayList2;
        n nVar = this.e.get();
        if (nVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            l.a<m, a> aVar = this.f1875c;
            boolean z6 = true;
            if (aVar.f4832i != 0) {
                b.c<m, a> cVar = aVar.f4829f;
                r5.h.c(cVar);
                g.b bVar = cVar.f4834g.f1881a;
                b.c<m, a> cVar2 = this.f1875c.f4830g;
                r5.h.c(cVar2);
                g.b bVar2 = cVar2.f4834g.f1881a;
                if (bVar != bVar2 || this.f1876d != bVar2) {
                    z6 = false;
                }
            }
            this.f1879h = false;
            if (z6) {
                return;
            }
            g.b bVar3 = this.f1876d;
            b.c<m, a> cVar3 = this.f1875c.f4829f;
            r5.h.c(cVar3);
            if (bVar3.compareTo(cVar3.f4834g.f1881a) < 0) {
                l.a<m, a> aVar2 = this.f1875c;
                b.C0075b c0075b = new b.C0075b(aVar2.f4830g, aVar2.f4829f);
                aVar2.f4831h.put(c0075b, Boolean.FALSE);
                while (c0075b.hasNext() && !this.f1879h) {
                    Map.Entry entry = (Map.Entry) c0075b.next();
                    r5.h.e(entry, "next()");
                    m mVar = (m) entry.getKey();
                    a aVar3 = (a) entry.getValue();
                    while (aVar3.f1881a.compareTo(this.f1876d) > 0 && !this.f1879h && this.f1875c.f4828j.containsKey(mVar)) {
                        g.a.C0018a c0018a = g.a.Companion;
                        g.b bVar4 = aVar3.f1881a;
                        c0018a.getClass();
                        r5.h.f(bVar4, "state");
                        int ordinal = bVar4.ordinal();
                        g.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : g.a.ON_PAUSE : g.a.ON_STOP : g.a.ON_DESTROY;
                        if (aVar4 == null) {
                            StringBuilder d7 = androidx.activity.h.d("no event down from ");
                            d7.append(aVar3.f1881a);
                            throw new IllegalStateException(d7.toString());
                        }
                        this.f1880i.add(aVar4.a());
                        aVar3.a(nVar, aVar4);
                        this.f1880i.remove(arrayList2.size() - 1);
                    }
                }
            }
            b.c<m, a> cVar4 = this.f1875c.f4830g;
            if (!this.f1879h && cVar4 != null && this.f1876d.compareTo(cVar4.f4834g.f1881a) > 0) {
                l.a<m, a> aVar5 = this.f1875c;
                aVar5.getClass();
                b.d dVar = new b.d();
                aVar5.f4831h.put(dVar, Boolean.FALSE);
                while (dVar.hasNext() && !this.f1879h) {
                    Map.Entry entry2 = (Map.Entry) dVar.next();
                    m mVar2 = (m) entry2.getKey();
                    a aVar6 = (a) entry2.getValue();
                    while (aVar6.f1881a.compareTo(this.f1876d) < 0 && !this.f1879h && this.f1875c.f4828j.containsKey(mVar2)) {
                        this.f1880i.add(aVar6.f1881a);
                        g.a.C0018a c0018a2 = g.a.Companion;
                        g.b bVar5 = aVar6.f1881a;
                        c0018a2.getClass();
                        g.a a7 = g.a.C0018a.a(bVar5);
                        if (a7 == null) {
                            StringBuilder d8 = androidx.activity.h.d("no event up from ");
                            d8.append(aVar6.f1881a);
                            throw new IllegalStateException(d8.toString());
                        }
                        aVar6.a(nVar, a7);
                        this.f1880i.remove(arrayList.size() - 1);
                    }
                }
            }
        }
    }
}
