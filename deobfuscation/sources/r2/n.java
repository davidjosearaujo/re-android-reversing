package r2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import l3.a;
import l3.d;
import r2.j;
import r2.q;

/* loaded from: classes.dex */
public final class n<R> implements j.a<R>, a.d {
    public static final c E = new c();
    public q<?> A;
    public j<R> B;
    public volatile boolean C;
    public boolean D;

    /* renamed from: f */
    public final e f5819f;

    /* renamed from: g */
    public final d.a f5820g;

    /* renamed from: h */
    public final q.a f5821h;

    /* renamed from: i */
    public final o1.d<n<?>> f5822i;

    /* renamed from: j */
    public final c f5823j;

    /* renamed from: k */
    public final o f5824k;

    /* renamed from: l */
    public final u2.a f5825l;
    public final u2.a m;

    /* renamed from: n */
    public final u2.a f5826n;

    /* renamed from: o */
    public final u2.a f5827o;

    /* renamed from: p */
    public final AtomicInteger f5828p;

    /* renamed from: q */
    public p2.f f5829q;

    /* renamed from: r */
    public boolean f5830r;
    public boolean s;

    /* renamed from: t */
    public boolean f5831t;

    /* renamed from: u */
    public boolean f5832u;

    /* renamed from: v */
    public v<?> f5833v;

    /* renamed from: w */
    public p2.a f5834w;

    /* renamed from: x */
    public boolean f5835x;

    /* renamed from: y */
    public r f5836y;

    /* renamed from: z */
    public boolean f5837z;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final g3.h f5838f;

        public a(g3.h hVar) {
            n.this = r1;
            this.f5838f = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g3.i iVar = (g3.i) this.f5838f;
            iVar.f4218b.a();
            synchronized (iVar.f4219c) {
                synchronized (n.this) {
                    if (n.this.f5819f.f5844f.contains(new d(this.f5838f, k3.e.f4698b))) {
                        n nVar = n.this;
                        g3.h hVar = this.f5838f;
                        nVar.getClass();
                        ((g3.i) hVar).l(nVar.f5836y, 5);
                    }
                    n.this.c();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f */
        public final g3.h f5840f;

        public b(g3.h hVar) {
            n.this = r1;
            this.f5840f = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g3.i iVar = (g3.i) this.f5840f;
            iVar.f4218b.a();
            synchronized (iVar.f4219c) {
                synchronized (n.this) {
                    if (n.this.f5819f.f5844f.contains(new d(this.f5840f, k3.e.f4698b))) {
                        n.this.A.a();
                        n nVar = n.this;
                        g3.h hVar = this.f5840f;
                        nVar.getClass();
                        ((g3.i) hVar).n(nVar.A, nVar.f5834w, nVar.D);
                        n.this.h(this.f5840f);
                    }
                    n.this.c();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a */
        public final g3.h f5842a;

        /* renamed from: b */
        public final Executor f5843b;

        public d(g3.h hVar, Executor executor) {
            this.f5842a = hVar;
            this.f5843b = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f5842a.equals(((d) obj).f5842a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f5842a.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: f */
        public final List<d> f5844f;

        public e(ArrayList arrayList) {
            this.f5844f = arrayList;
        }

        @Override // java.lang.Iterable
        public final Iterator<d> iterator() {
            return this.f5844f.iterator();
        }
    }

    public n() {
        throw null;
    }

    public n(u2.a aVar, u2.a aVar2, u2.a aVar3, u2.a aVar4, o oVar, q.a aVar5, a.c cVar) {
        c cVar2 = E;
        this.f5819f = new e(new ArrayList(2));
        this.f5820g = new d.a();
        this.f5828p = new AtomicInteger();
        this.f5825l = aVar;
        this.m = aVar2;
        this.f5826n = aVar3;
        this.f5827o = aVar4;
        this.f5824k = oVar;
        this.f5821h = aVar5;
        this.f5822i = cVar;
        this.f5823j = cVar2;
    }

    public final synchronized void a(g3.h hVar, Executor executor) {
        Runnable aVar;
        this.f5820g.a();
        this.f5819f.f5844f.add(new d(hVar, executor));
        boolean z6 = true;
        if (this.f5835x) {
            e(1);
            aVar = new b(hVar);
        } else if (this.f5837z) {
            e(1);
            aVar = new a(hVar);
        } else {
            if (this.C) {
                z6 = false;
            }
            q2.a.h("Cannot add callbacks to a cancelled EngineJob", z6);
        }
        executor.execute(aVar);
    }

    public final void b() {
        if (f()) {
            return;
        }
        this.C = true;
        j<R> jVar = this.B;
        jVar.J = true;
        h hVar = jVar.H;
        if (hVar != null) {
            hVar.cancel();
        }
        o oVar = this.f5824k;
        p2.f fVar = this.f5829q;
        m mVar = (m) oVar;
        synchronized (mVar) {
            androidx.appcompat.widget.l lVar = mVar.f5797a;
            lVar.getClass();
            Map map = (Map) (this.f5832u ? lVar.f964g : lVar.f963f);
            if (equals(map.get(fVar))) {
                map.remove(fVar);
            }
        }
    }

    public final void c() {
        q<?> qVar;
        synchronized (this) {
            this.f5820g.a();
            q2.a.h("Not yet complete!", f());
            int decrementAndGet = this.f5828p.decrementAndGet();
            q2.a.h("Can't decrement below 0", decrementAndGet >= 0);
            if (decrementAndGet == 0) {
                qVar = this.A;
                g();
            } else {
                qVar = null;
            }
        }
        if (qVar != null) {
            qVar.d();
        }
    }

    @Override // l3.a.d
    public final d.a d() {
        return this.f5820g;
    }

    public final synchronized void e(int i7) {
        q<?> qVar;
        q2.a.h("Not yet complete!", f());
        if (this.f5828p.getAndAdd(i7) == 0 && (qVar = this.A) != null) {
            qVar.a();
        }
    }

    public final boolean f() {
        return this.f5837z || this.f5835x || this.C;
    }

    public final synchronized void g() {
        boolean a7;
        if (this.f5829q == null) {
            throw new IllegalArgumentException();
        }
        this.f5819f.f5844f.clear();
        this.f5829q = null;
        this.A = null;
        this.f5833v = null;
        this.f5837z = false;
        this.C = false;
        this.f5835x = false;
        this.D = false;
        j<R> jVar = this.B;
        j.e eVar = jVar.f5768l;
        synchronized (eVar) {
            eVar.f5786a = true;
            a7 = eVar.a();
        }
        if (a7) {
            jVar.m();
        }
        this.B = null;
        this.f5836y = null;
        this.f5834w = null;
        this.f5822i.a(this);
    }

    public final synchronized void h(g3.h hVar) {
        boolean z6;
        this.f5820g.a();
        this.f5819f.f5844f.remove(new d(hVar, k3.e.f4698b));
        if (this.f5819f.f5844f.isEmpty()) {
            b();
            if (!this.f5835x && !this.f5837z) {
                z6 = false;
                if (z6 && this.f5828p.get() == 0) {
                    g();
                }
            }
            z6 = true;
            if (z6) {
                g();
            }
        }
    }
}
