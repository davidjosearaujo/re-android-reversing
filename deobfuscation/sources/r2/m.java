package r2;

import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;
import k3.i;
import l3.a;
import r2.c;
import r2.j;
import r2.q;
import t2.a;
import t2.h;

/* loaded from: classes.dex */
public final class m implements o, h.a, q.a {

    /* renamed from: h */
    public static final boolean f5796h = Log.isLoggable("Engine", 2);

    /* renamed from: a */
    public final androidx.appcompat.widget.l f5797a;

    /* renamed from: b */
    public final g6.i f5798b;

    /* renamed from: c */
    public final t2.h f5799c;

    /* renamed from: d */
    public final b f5800d;
    public final y e;

    /* renamed from: f */
    public final a f5801f;

    /* renamed from: g */
    public final r2.c f5802g;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public final j.d f5803a;

        /* renamed from: b */
        public final a.c f5804b = l3.a.a(150, new C0102a());

        /* renamed from: c */
        public int f5805c;

        /* renamed from: r2.m$a$a */
        /* loaded from: classes.dex */
        public class C0102a implements a.b<j<?>> {
            public C0102a() {
                a.this = r1;
            }

            @Override // l3.a.b
            public final j<?> a() {
                a aVar = a.this;
                return new j<>(aVar.f5803a, aVar.f5804b);
            }
        }

        public a(c cVar) {
            this.f5803a = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final u2.a f5807a;

        /* renamed from: b */
        public final u2.a f5808b;

        /* renamed from: c */
        public final u2.a f5809c;

        /* renamed from: d */
        public final u2.a f5810d;
        public final o e;

        /* renamed from: f */
        public final q.a f5811f;

        /* renamed from: g */
        public final a.c f5812g = l3.a.a(150, new a());

        /* loaded from: classes.dex */
        public class a implements a.b<n<?>> {
            public a() {
                b.this = r1;
            }

            @Override // l3.a.b
            public final n<?> a() {
                b bVar = b.this;
                return new n<>(bVar.f5807a, bVar.f5808b, bVar.f5809c, bVar.f5810d, bVar.e, bVar.f5811f, bVar.f5812g);
            }
        }

        public b(u2.a aVar, u2.a aVar2, u2.a aVar3, u2.a aVar4, o oVar, q.a aVar5) {
            this.f5807a = aVar;
            this.f5808b = aVar2;
            this.f5809c = aVar3;
            this.f5810d = aVar4;
            this.e = oVar;
            this.f5811f = aVar5;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements j.d {

        /* renamed from: a */
        public final a.InterfaceC0106a f5814a;

        /* renamed from: b */
        public volatile t2.a f5815b;

        public c(a.InterfaceC0106a interfaceC0106a) {
            this.f5814a = interfaceC0106a;
        }

        public final t2.a a() {
            if (this.f5815b == null) {
                synchronized (this) {
                    if (this.f5815b == null) {
                        t2.c cVar = (t2.c) this.f5814a;
                        t2.e eVar = (t2.e) cVar.f6043b;
                        File cacheDir = eVar.f6048a.getCacheDir();
                        t2.d dVar = null;
                        if (cacheDir == null) {
                            cacheDir = null;
                        } else if (eVar.f6049b != null) {
                            cacheDir = new File(cacheDir, eVar.f6049b);
                        }
                        if (cacheDir != null && (cacheDir.isDirectory() || cacheDir.mkdirs())) {
                            dVar = new t2.d(cacheDir, cVar.f6042a);
                        }
                        this.f5815b = dVar;
                    }
                    if (this.f5815b == null) {
                        this.f5815b = new q2.a();
                    }
                }
            }
            return this.f5815b;
        }
    }

    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a */
        public final n<?> f5816a;

        /* renamed from: b */
        public final g3.h f5817b;

        public d(g3.h hVar, n<?> nVar) {
            m.this = r1;
            this.f5817b = hVar;
            this.f5816a = nVar;
        }
    }

    public m(t2.h hVar, a.InterfaceC0106a interfaceC0106a, u2.a aVar, u2.a aVar2, u2.a aVar3, u2.a aVar4) {
        this.f5799c = hVar;
        c cVar = new c(interfaceC0106a);
        r2.c cVar2 = new r2.c();
        this.f5802g = cVar2;
        synchronized (this) {
            synchronized (cVar2) {
                cVar2.f5729d = this;
            }
        }
        this.f5798b = new g6.i(2);
        this.f5797a = new androidx.appcompat.widget.l();
        this.f5800d = new b(aVar, aVar2, aVar3, aVar4, this, this);
        this.f5801f = new a(cVar);
        this.e = new y();
        ((t2.g) hVar).f6050d = this;
    }

    public static void d(String str, long j5, p2.f fVar) {
        Log.v("Engine", str + " in " + k3.h.a(j5) + "ms, key: " + fVar);
    }

    public static void e(v vVar) {
        if (!(vVar instanceof q)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((q) vVar).d();
    }

    @Override // r2.q.a
    public final void a(p2.f fVar, q<?> qVar) {
        r2.c cVar = this.f5802g;
        synchronized (cVar) {
            c.a aVar = (c.a) cVar.f5727b.remove(fVar);
            if (aVar != null) {
                aVar.f5732c = null;
                aVar.clear();
            }
        }
        if (qVar.f5853f) {
            ((t2.g) this.f5799c).d(fVar, qVar);
        } else {
            this.e.a(qVar, false);
        }
    }

    public final d b(com.bumptech.glide.g gVar, Object obj, p2.f fVar, int i7, int i8, Class cls, Class cls2, com.bumptech.glide.i iVar, l lVar, k3.b bVar, boolean z6, boolean z7, p2.h hVar, boolean z8, boolean z9, boolean z10, boolean z11, g3.h hVar2, Executor executor) {
        long j5;
        if (f5796h) {
            int i9 = k3.h.f4702b;
            j5 = SystemClock.elapsedRealtimeNanos();
        } else {
            j5 = 0;
        }
        long j7 = j5;
        this.f5798b.getClass();
        p pVar = new p(obj, fVar, i7, i8, bVar, cls, cls2, hVar);
        synchronized (this) {
            try {
                q<?> c7 = c(pVar, z8, j7);
                if (c7 == null) {
                    return f(gVar, obj, fVar, i7, i8, cls, cls2, iVar, lVar, bVar, z6, z7, hVar, z8, z9, z10, z11, hVar2, executor, pVar, j7);
                }
                ((g3.i) hVar2).n(c7, p2.a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<?> c(p pVar, boolean z6, long j5) {
        q<?> qVar;
        v vVar;
        if (z6) {
            r2.c cVar = this.f5802g;
            synchronized (cVar) {
                c.a aVar = (c.a) cVar.f5727b.get(pVar);
                if (aVar == null) {
                    qVar = null;
                } else {
                    qVar = aVar.get();
                    if (qVar == null) {
                        cVar.b(aVar);
                    }
                }
            }
            if (qVar != null) {
                qVar.a();
            }
            if (qVar != null) {
                if (f5796h) {
                    d("Loaded resource from active resources", j5, pVar);
                }
                return qVar;
            }
            t2.g gVar = (t2.g) this.f5799c;
            synchronized (gVar) {
                i.a aVar2 = (i.a) gVar.f4703a.remove(pVar);
                if (aVar2 == null) {
                    vVar = null;
                } else {
                    gVar.f4705c -= aVar2.f4707b;
                    vVar = aVar2.f4706a;
                }
            }
            v vVar2 = vVar;
            q<?> qVar2 = vVar2 == null ? null : vVar2 instanceof q ? (q) vVar2 : new q<>(vVar2, true, true, pVar, this);
            if (qVar2 != null) {
                qVar2.a();
                this.f5802g.a(pVar, qVar2);
            }
            if (qVar2 != null) {
                if (f5796h) {
                    d("Loaded resource from cache", j5, pVar);
                }
                return qVar2;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:195:0x00e5, code lost:
        r0 = r15.f5825l;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [u2.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final r2.m.d f(com.bumptech.glide.g r17, java.lang.Object r18, p2.f r19, int r20, int r21, java.lang.Class r22, java.lang.Class r23, com.bumptech.glide.i r24, r2.l r25, k3.b r26, boolean r27, boolean r28, p2.h r29, boolean r30, boolean r31, boolean r32, boolean r33, g3.h r34, java.util.concurrent.Executor r35, r2.p r36, long r37) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.m.f(com.bumptech.glide.g, java.lang.Object, p2.f, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.i, r2.l, k3.b, boolean, boolean, p2.h, boolean, boolean, boolean, boolean, g3.h, java.util.concurrent.Executor, r2.p, long):r2.m$d");
    }
}
