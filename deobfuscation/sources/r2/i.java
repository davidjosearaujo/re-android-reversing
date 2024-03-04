package r2;

import d3.c;
import f3.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p.n0;
import r2.j;
import v2.n;

/* loaded from: classes.dex */
public final class i<Transcode> {

    /* renamed from: a */
    public final ArrayList f5746a = new ArrayList();

    /* renamed from: b */
    public final ArrayList f5747b = new ArrayList();

    /* renamed from: c */
    public com.bumptech.glide.g f5748c;

    /* renamed from: d */
    public Object f5749d;
    public int e;

    /* renamed from: f */
    public int f5750f;

    /* renamed from: g */
    public Class<?> f5751g;

    /* renamed from: h */
    public j.d f5752h;

    /* renamed from: i */
    public p2.h f5753i;

    /* renamed from: j */
    public Map<Class<?>, p2.l<?>> f5754j;

    /* renamed from: k */
    public Class<Transcode> f5755k;

    /* renamed from: l */
    public boolean f5756l;
    public boolean m;

    /* renamed from: n */
    public p2.f f5757n;

    /* renamed from: o */
    public com.bumptech.glide.i f5758o;

    /* renamed from: p */
    public l f5759p;

    /* renamed from: q */
    public boolean f5760q;

    /* renamed from: r */
    public boolean f5761r;

    public final ArrayList a() {
        if (!this.m) {
            this.m = true;
            this.f5747b.clear();
            ArrayList b2 = b();
            int size = b2.size();
            for (int i7 = 0; i7 < size; i7++) {
                n.a aVar = (n.a) b2.get(i7);
                if (!this.f5747b.contains(aVar.f6223a)) {
                    this.f5747b.add(aVar.f6223a);
                }
                for (int i8 = 0; i8 < aVar.f6224b.size(); i8++) {
                    if (!this.f5747b.contains(aVar.f6224b.get(i8))) {
                        this.f5747b.add(aVar.f6224b.get(i8));
                    }
                }
            }
        }
        return this.f5747b;
    }

    public final ArrayList b() {
        if (!this.f5756l) {
            this.f5756l = true;
            this.f5746a.clear();
            List e = this.f5748c.a().e(this.f5749d);
            int size = e.size();
            for (int i7 = 0; i7 < size; i7++) {
                n.a a7 = ((v2.n) e.get(i7)).a(this.f5749d, this.e, this.f5750f, this.f5753i);
                if (a7 != null) {
                    this.f5746a.add(a7);
                }
            }
        }
        return this.f5746a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Data> t<Data, ?, Transcode> c(Class<Data> cls) {
        t<Data, ?, Transcode> tVar;
        ArrayList arrayList;
        boolean z6;
        d3.b bVar;
        d3.b bVar2;
        com.bumptech.glide.j a7 = this.f5748c.a();
        Class<?> cls2 = this.f5751g;
        Class cls3 = (Class<Transcode>) this.f5755k;
        f3.b bVar3 = a7.f2654i;
        k3.k andSet = bVar3.f4123b.getAndSet(null);
        if (andSet == null) {
            andSet = new k3.k();
        }
        andSet.f4709a = cls;
        andSet.f4710b = cls2;
        andSet.f4711c = cls3;
        synchronized (bVar3.f4122a) {
            tVar = (t<Data, ?, Transcode>) bVar3.f4122a.getOrDefault(andSet, null);
        }
        bVar3.f4123b.set(andSet);
        a7.f2654i.getClass();
        if (f3.b.f4121c.equals(tVar)) {
            return null;
        }
        if (tVar == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = a7.f2649c.b(cls, cls2).iterator();
            while (it.hasNext()) {
                Class<?> cls4 = (Class) it.next();
                Iterator it2 = a7.f2651f.a(cls4, cls3).iterator();
                while (it2.hasNext()) {
                    Class cls5 = (Class) it2.next();
                    f3.c cVar = a7.f2649c;
                    synchronized (cVar) {
                        arrayList = new ArrayList();
                        Iterator it3 = cVar.f4124a.iterator();
                        while (it3.hasNext()) {
                            List<c.a> list = (List) cVar.f4125b.get((String) it3.next());
                            if (list != null) {
                                for (c.a aVar : list) {
                                    if (aVar.f4126a.isAssignableFrom(cls) && cls4.isAssignableFrom(aVar.f4127b)) {
                                        arrayList.add(aVar.f4128c);
                                    }
                                }
                            }
                        }
                    }
                    d3.c cVar2 = a7.f2651f;
                    synchronized (cVar2) {
                        if (!cls5.isAssignableFrom(cls4)) {
                            Iterator it4 = cVar2.f3562a.iterator();
                            while (it4.hasNext()) {
                                c.a aVar2 = (c.a) it4.next();
                                if (aVar2.f3563a.isAssignableFrom(cls4) && cls5.isAssignableFrom(aVar2.f3564b)) {
                                    z6 = true;
                                    continue;
                                } else {
                                    z6 = false;
                                    continue;
                                }
                                if (z6) {
                                    bVar = aVar2.f3565c;
                                }
                            }
                            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                        }
                        bVar = a0.e.f55v;
                        bVar2 = bVar;
                    }
                    arrayList2.add(new k(cls, cls4, cls5, arrayList, bVar2, a7.f2655j));
                }
            }
            t<Data, ?, Transcode> tVar2 = arrayList2.isEmpty() ? null : new t<>(cls, cls2, cls3, arrayList2, a7.f2655j);
            f3.b bVar4 = a7.f2654i;
            synchronized (bVar4.f4122a) {
                bVar4.f4122a.put(new k3.k(cls, cls2, cls3), tVar2 != null ? tVar2 : f3.b.f4121c);
            }
            return tVar2;
        }
        return tVar;
    }

    public final List<Class<?>> d() {
        List<Class<?>> list;
        ArrayList d7;
        com.bumptech.glide.j a7 = this.f5748c.a();
        Class<?> cls = this.f5749d.getClass();
        Class<?> cls2 = this.f5751g;
        Class cls3 = this.f5755k;
        n0 n0Var = a7.f2653h;
        k3.k kVar = (k3.k) ((AtomicReference) n0Var.f5443f).getAndSet(null);
        if (kVar == null) {
            kVar = new k3.k(cls, cls2, cls3);
        } else {
            kVar.f4709a = cls;
            kVar.f4710b = cls2;
            kVar.f4711c = cls3;
        }
        synchronized (((o.b) n0Var.f5444g)) {
            list = (List) ((o.b) n0Var.f5444g).getOrDefault(kVar, null);
        }
        ((AtomicReference) n0Var.f5443f).set(kVar);
        ArrayList arrayList = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            v2.p pVar = a7.f2647a;
            synchronized (pVar) {
                d7 = pVar.f6226a.d(cls);
            }
            Iterator it = d7.iterator();
            while (it.hasNext()) {
                Iterator it2 = a7.f2649c.b((Class) it.next(), cls2).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!a7.f2651f.a(cls4, cls3).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            n0 n0Var2 = a7.f2653h;
            List unmodifiableList = Collections.unmodifiableList(arrayList2);
            synchronized (((o.b) n0Var2.f5444g)) {
                ((o.b) n0Var2.f5444g).put(new k3.k(cls, cls2, cls3), unmodifiableList);
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0027, code lost:
        r0 = (p2.d<X>) r2.f4120b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <X> p2.d<X> e(X r5) {
        /*
            r4 = this;
            com.bumptech.glide.g r4 = r4.f5748c
            com.bumptech.glide.j r4 = r4.a()
            f3.a r4 = r4.f2648b
            java.lang.Class r0 = r5.getClass()
            monitor-enter(r4)
            java.util.ArrayList r1 = r4.f4118a     // Catch: java.lang.Throwable -> L39
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L39
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L2a
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L39
            f3.a$a r2 = (f3.a.C0057a) r2     // Catch: java.lang.Throwable -> L39
            java.lang.Class<T> r3 = r2.f4119a     // Catch: java.lang.Throwable -> L39
            boolean r3 = r3.isAssignableFrom(r0)     // Catch: java.lang.Throwable -> L39
            if (r3 == 0) goto L13
            p2.d<T> r0 = r2.f4120b     // Catch: java.lang.Throwable -> L39
            goto L2b
        L2a:
            r0 = 0
        L2b:
            monitor-exit(r4)
            if (r0 == 0) goto L2f
            return r0
        L2f:
            com.bumptech.glide.j$e r4 = new com.bumptech.glide.j$e
            java.lang.Class r5 = r5.getClass()
            r4.<init>(r5)
            throw r4
        L39:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.i.e(java.lang.Object):p2.d");
    }

    public final <Z> p2.l<Z> f(Class<Z> cls) {
        p2.l<Z> lVar = (p2.l<Z>) this.f5754j.get(cls);
        if (lVar == null) {
            Iterator<Map.Entry<Class<?>, p2.l<?>>> it = this.f5754j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, p2.l<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    lVar = (p2.l<Z>) next.getValue();
                    break;
                }
            }
        }
        if (lVar == null) {
            if (this.f5754j.isEmpty() && this.f5760q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return x2.b.f6468b;
        }
        return lVar;
    }
}
