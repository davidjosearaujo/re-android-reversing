package r2;

import androidx.appcompat.widget.l;
import g3.h;
import g3.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import l3.a;
import l3.d;
import p2.f;
import r2.j;
import r2.q;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n<R> implements j.a<R>, a.d {
    public static final c E = new c();
    public q<?> A;
    public j<R> B;
    public volatile boolean C;
    public boolean D;

    /* renamed from: f  reason: collision with root package name */
    public final e f5819f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a f5820g;

    /* renamed from: h  reason: collision with root package name */
    public final q.a f5821h;

    /* renamed from: i  reason: collision with root package name */
    public final o1.d<n<?>> f5822i;

    /* renamed from: j  reason: collision with root package name */
    public final c f5823j;

    /* renamed from: k  reason: collision with root package name */
    public final o f5824k;

    /* renamed from: l  reason: collision with root package name */
    public final u2.a f5825l;
    public final u2.a m;

    /* renamed from: n  reason: collision with root package name */
    public final u2.a f5826n;

    /* renamed from: o  reason: collision with root package name */
    public final u2.a f5827o;

    /* renamed from: p  reason: collision with root package name */
    public final AtomicInteger f5828p;

    /* renamed from: q  reason: collision with root package name */
    public f f5829q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5830r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5831t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f5832u;

    /* renamed from: v  reason: collision with root package name */
    public v<?> f5833v;

    /* renamed from: w  reason: collision with root package name */
    public p2.a f5834w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f5835x;

    /* renamed from: y  reason: collision with root package name */
    public r f5836y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f5837z;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final h f5838f;

        public a(h hVar) {
            this.f5838f = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = (i) this.f5838f;
            iVar.f4218b.a();
            synchronized (iVar.f4219c) {
                synchronized (n.this) {
                    if (n.this.f5819f.f5844f.contains(new d(this.f5838f, k3.e.f4698b))) {
                        n nVar = n.this;
                        h hVar = this.f5838f;
                        nVar.getClass();
                        ((i) hVar).l(nVar.f5836y, 5);
                    }
                    n.this.c();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final h f5840f;

        public b(h hVar) {
            this.f5840f = hVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i iVar = (i) this.f5840f;
            iVar.f4218b.a();
            synchronized (iVar.f4219c) {
                synchronized (n.this) {
                    if (n.this.f5819f.f5844f.contains(new d(this.f5840f, k3.e.f4698b))) {
                        n.this.A.a();
                        n nVar = n.this;
                        h hVar = this.f5840f;
                        nVar.getClass();
                        ((i) hVar).n(nVar.A, nVar.f5834w, nVar.D);
                        n.this.h(this.f5840f);
                    }
                    n.this.c();
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final h f5842a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f5843b;

        public d(h hVar, Executor executor) {
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

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: f  reason: collision with root package name */
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

    public final synchronized void a(h hVar, Executor executor) {
        Runnable runnable;
        this.f5820g.a();
        this.f5819f.f5844f.add(new d(hVar, executor));
        boolean z6 = true;
        if (this.f5835x) {
            e(1);
            runnable = new b(hVar);
        } else if (this.f5837z) {
            e(1);
            runnable = new a(hVar);
        } else {
            if (this.C) {
                z6 = false;
            }
            q2.a.h("Cannot add callbacks to a cancelled EngineJob", z6);
        }
        executor.execute(runnable);
    }

    public final void b() {
        if (!f()) {
            this.C = true;
            j<R> jVar = this.B;
            jVar.J = true;
            h hVar = jVar.H;
            if (hVar != null) {
                hVar.cancel();
            }
            o oVar = this.f5824k;
            f fVar = this.f5829q;
            m mVar = (m) oVar;
            synchronized (mVar) {
                l lVar = mVar.f5797a;
                lVar.getClass();
                Map map = (Map) (this.f5832u ? lVar.f964g : lVar.f963f);
                if (equals(map.get(fVar))) {
                    map.remove(fVar);
                }
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
        if (this.f5829q != null) {
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
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void h(h hVar) {
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
