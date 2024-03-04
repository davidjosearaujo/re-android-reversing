package l0;

import Graphics_1.CanvasOperations;
import Graphics_1.PaintBase;
import x.a;

/* loaded from: classes.dex */
public abstract class w extends t implements d0, q5.l {

    /* renamed from: l */
    public static final a f4887l;
    public static final b m;

    /* renamed from: h */
    public final o f4888h;

    /* renamed from: i */
    public t0.c f4889i;

    /* renamed from: j */
    public float f4890j;

    /* renamed from: k */
    public long f4891k;

    /* loaded from: classes.dex */
    public static final class a implements d {
        public final void a(o oVar, long j5, l0.g gVar, boolean z6, boolean z7) {
            r5.h.f(gVar, "hitTestResult");
            oVar.g(j5, gVar, z6, z7);
        }

        public final int b() {
            return 16;
        }

        public final boolean c(o oVar) {
            r5.h.f(oVar, "parentLayoutNode");
            return true;
        }

        public final boolean d(a.b bVar) {
            r5.h.f(bVar, "node");
            while (true) {
                if (bVar == null) {
                    return false;
                }
                if (!(bVar instanceof g0)) {
                    bVar.getClass();
                    if ((false && true) && (bVar instanceof l0.d)) {
                        l0.d dVar = (l0.d) bVar;
                    }
                } else if (((g0) bVar).d()) {
                    return true;
                }
                bVar = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements d {
        public final void a(o oVar, long j5, l0.g gVar, boolean z6, boolean z7) {
            r5.h.f(gVar, "hitTestResult");
            oVar.s.f4884b.v(w.m, oVar.s.f4884b.o(j5), gVar, true, z7);
        }

        public final int b() {
            return 8;
        }

        public final boolean c(o oVar) {
            r5.h.f(oVar, "parentLayoutNode");
            o0.f b2 = oVar.b();
            boolean z6 = false;
            if (b2 != null && b2.f5233h) {
                z6 = true;
            }
            return !z6;
        }

        public final boolean d(a.b bVar) {
            r5.h.f(bVar, "node");
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends r5.i implements q5.l {

        /* renamed from: g */
        public static final c f4892g = new c();

        public c() {
            super(1);
        }

        public final Object k(Object obj) {
            w wVar = (w) obj;
            r5.h.f(wVar, "coordinator");
            wVar.getClass();
            return f5.g.f4141a;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(o oVar, long j5, l0.g gVar, boolean z6, boolean z7);

        int b();

        boolean c(o oVar);

        boolean d(a.b bVar);
    }

    /* loaded from: classes.dex */
    public static final class e extends r5.i implements q5.a {

        /* renamed from: h */
        public final /* synthetic */ a.b f4894h;

        /* renamed from: i */
        public final /* synthetic */ d f4895i;

        /* renamed from: j */
        public final /* synthetic */ long f4896j;

        /* renamed from: k */
        public final /* synthetic */ l0.g f4897k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4898l;
        public final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7) {
            super(0);
            w.this = r1;
            this.f4894h = bVar;
            this.f4895i = dVar;
            this.f4896j = j5;
            this.f4897k = gVar;
            this.f4898l = z6;
            this.m = z7;
        }

        public final Object d() {
            w.this.t(y.a(this.f4894h, this.f4895i.b()), this.f4895i, this.f4896j, this.f4897k, this.f4898l, this.m);
            return f5.g.f4141a;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends r5.i implements q5.a {

        /* renamed from: h */
        public final /* synthetic */ a.b f4900h;

        /* renamed from: i */
        public final /* synthetic */ d f4901i;

        /* renamed from: j */
        public final /* synthetic */ long f4902j;

        /* renamed from: k */
        public final /* synthetic */ l0.g f4903k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4904l;
        public final /* synthetic */ boolean m;

        /* renamed from: n */
        public final /* synthetic */ float f4905n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7, float f7) {
            super(0);
            w.this = r1;
            this.f4900h = bVar;
            this.f4901i = dVar;
            this.f4902j = j5;
            this.f4903k = gVar;
            this.f4904l = z6;
            this.m = z7;
            this.f4905n = f7;
        }

        public final Object d() {
            w.this.u(y.a(this.f4900h, this.f4901i.b()), this.f4901i, this.f4902j, this.f4903k, this.f4904l, this.m, this.f4905n);
            return f5.g.f4141a;
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends r5.i implements q5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g() {
            super(0);
            w.this = r1;
        }

        public final Object d() {
            w.this.getClass();
            return f5.g.f4141a;
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends r5.i implements q5.a {

        /* renamed from: h */
        public final /* synthetic */ a.b f4908h;

        /* renamed from: i */
        public final /* synthetic */ d f4909i;

        /* renamed from: j */
        public final /* synthetic */ long f4910j;

        /* renamed from: k */
        public final /* synthetic */ l0.g f4911k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4912l;
        public final /* synthetic */ boolean m;

        /* renamed from: n */
        public final /* synthetic */ float f4913n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7, float f7) {
            super(0);
            w.this = r1;
            this.f4908h = bVar;
            this.f4909i = dVar;
            this.f4910j = j5;
            this.f4911k = gVar;
            this.f4912l = z6;
            this.m = z7;
            this.f4913n = f7;
        }

        public final Object d() {
            w.this.A(y.a(this.f4908h, this.f4909i.b()), this.f4909i, this.f4910j, this.f4911k, this.f4912l, this.m, this.f4913n);
            return f5.g.f4141a;
        }
    }

    static {
        new Graphics_1.k();
        new j();
        a0.b.j();
        f4887l = new a();
        m = new b();
    }

    public w(o oVar) {
        r5.h.f(oVar, "layoutNode");
        this.f4888h = oVar;
        this.f4889i = oVar.f4868o;
        t0.g gVar = oVar.f4869p;
        this.f4890j = 0.8f;
        this.f4891k = t0.f.f6007a;
        new g();
    }

    public final void A(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7, float f7) {
        if (bVar == null) {
            w(dVar, j5, gVar, z6, z7);
        } else if (!dVar.d(bVar)) {
            A(y.a(bVar, dVar.b()), dVar, j5, gVar, z6, z7, f7);
        } else {
            h hVar = new h(bVar, dVar, j5, gVar, z6, z7, f7);
            gVar.getClass();
            if (gVar.f4845h == q2.a.x(gVar)) {
                gVar.b(bVar, f7, z7, hVar);
                if (gVar.f4845h + 1 == q2.a.x(gVar)) {
                    gVar.c();
                    return;
                }
                return;
            }
            long a7 = gVar.a();
            int i7 = gVar.f4845h;
            gVar.f4845h = q2.a.x(gVar);
            gVar.b(bVar, f7, z7, hVar);
            if (gVar.f4845h + 1 < q2.a.x(gVar) && a0.b.i(a7, gVar.a()) > 0) {
                int i8 = gVar.f4845h + 1;
                int i9 = i7 + 1;
                Object[] objArr = gVar.f4843f;
                g5.i.W(objArr, objArr, i9, i8, gVar.f4846i);
                long[] jArr = gVar.f4844g;
                int i10 = gVar.f4846i;
                r5.h.f(jArr, "<this>");
                System.arraycopy(jArr, i8, jArr, i9, i10 - i8);
                gVar.f4845h = ((gVar.f4846i + i7) - gVar.f4845h) - 1;
            }
            gVar.c();
            gVar.f4845h = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean B(long r4) {
        /*
            r3 = this;
            float r3 = a0.a.b(r4)
            boolean r0 = java.lang.Float.isInfinite(r3)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L14
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L14
            r3 = r1
            goto L15
        L14:
            r3 = r2
        L15:
            if (r3 == 0) goto L2e
            float r3 = a0.a.c(r4)
            boolean r4 = java.lang.Float.isInfinite(r3)
            if (r4 != 0) goto L29
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L29
            r3 = r1
            goto L2a
        L29:
            r3 = r2
        L2a:
            if (r3 == 0) goto L2e
            r3 = r1
            goto L2f
        L2e:
            r3 = r2
        L2f:
            if (r3 != 0) goto L32
            return r2
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.w.B(long):boolean");
    }

    public final long g(long j5) {
        return a0.e.d(Math.max(0.0f, (a0.d.b(j5) - c()) / 2.0f), Math.max(0.0f, (a0.d.a(j5) - q2.a.w(this.f4570f)) / 2.0f));
    }

    public final float getDensity() {
        return this.f4888h.f4868o.getDensity();
    }

    public final float h(long j5, long j7) {
        if (c() < a0.d.b(j7) || q2.a.w(this.f4570f) < a0.d.a(j7)) {
            long g2 = g(j7);
            float b2 = a0.d.b(g2);
            float a7 = a0.d.a(g2);
            float b7 = a0.a.b(j5);
            float max = Math.max(0.0f, b7 < 0.0f ? -b7 : b7 - c());
            float c7 = a0.a.c(j5);
            long a8 = a0.b.a(max, Math.max(0.0f, c7 < 0.0f ? -c7 : c7 - q2.a.w(this.f4570f)));
            if ((b2 > 0.0f || a7 > 0.0f) && a0.a.b(a8) <= b2 && a0.a.c(a8) <= a7) {
                return (a0.a.c(a8) * a0.a.c(a8)) + (a0.a.b(a8) * a0.a.b(a8));
            }
            return Float.POSITIVE_INFINITY;
        }
        return Float.POSITIVE_INFINITY;
    }

    public final Object k(Object obj) {
        CanvasOperations canvasOperations = (CanvasOperations) obj;
        r5.h.f(canvasOperations, "canvas");
        if (this.f4888h.j()) {
            a0.e.B(this.f4888h).getSnapshotObserver().a(this, c.f4892g, new x(this, canvasOperations));
        }
        return f5.g.f4141a;
    }

    public final void l(CanvasOperations canvasOperations) {
        r5.h.f(canvasOperations, "canvas");
        long j5 = this.f4891k;
        float f7 = (int) (j5 >> 32);
        float a7 = t0.f.a(j5);
        canvasOperations.translate(f7, a7);
        n(canvasOperations);
        canvasOperations.translate(-f7, -a7);
    }

    public final void m(CanvasOperations canvasOperations, PaintBase paintBase) {
        r5.h.f(canvasOperations, "canvas");
        r5.h.f(paintBase, "paint");
        long j5 = this.f4570f;
        canvasOperations.a(new a0.c(0.5f, 0.5f, ((int) (j5 >> 32)) - 0.5f, q2.a.w(j5) - 0.5f), paintBase);
    }

    public final void n(CanvasOperations canvasOperations) {
        a.b r6 = r(4);
        if (r6 == null) {
            z(canvasOperations);
            return;
        }
        o oVar = this.f4888h;
        oVar.getClass();
        r sharedDrawScope = a0.e.B(oVar).getSharedDrawScope();
        long j5 = this.f4570f;
        a0.e.d((int) (j5 >> 32), q2.a.w(j5));
        sharedDrawScope.getClass();
        r5.h.f(canvasOperations, "canvas");
        while (r6 != null) {
            if (r6 instanceof l0.e) {
                l0.e eVar = sharedDrawScope.f4876f;
                sharedDrawScope.f4876f = (l0.e) r6;
                sharedDrawScope.getClass();
                t0.g gVar = this.f4888h.f4869p;
                throw null;
            }
            r6.getClass();
            if ((false & true) && (r6 instanceof l0.d)) {
                l0.d dVar = (l0.d) r6;
            }
            r6 = null;
        }
    }

    public final long o(long j5) {
        long j7 = this.f4891k;
        float b2 = a0.a.b(j5);
        int i7 = t0.f.f6008b;
        return a0.b.a(b2 - ((int) (j7 >> 32)), a0.a.c(j5) - t0.f.a(j7));
    }

    public final long p() {
        t0.c cVar = this.f4889i;
        this.f4888h.f4870q.getClass();
        return cVar.b(t0.e.f6004a);
    }

    public abstract a.b q();

    public final a.b r(int i7) {
        boolean b2 = a0.b(i7);
        a.b q6 = q();
        if (!b2) {
            q6.getClass();
            return null;
        }
        for (a.b s = s(b2); s != null && (s.f6421b & i7) != 0; s = null) {
            s.getClass();
            if ((0 & i7) != 0) {
                return s;
            }
            if (s == q6) {
                return null;
            }
            s.getClass();
        }
        return null;
    }

    public final a.b s(boolean z6) {
        v vVar = this.f4888h.s;
        if (vVar.f4884b == this) {
            return vVar.f4886d;
        }
        return null;
    }

    public final void t(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7) {
        if (bVar == null) {
            w(dVar, j5, gVar, z6, z7);
            return;
        }
        e eVar = new e(bVar, dVar, j5, gVar, z6, z7);
        gVar.getClass();
        gVar.b(bVar, -1.0f, z7, eVar);
    }

    public final void u(a.b bVar, d dVar, long j5, l0.g gVar, boolean z6, boolean z7, float f7) {
        if (bVar == null) {
            w(dVar, j5, gVar, z6, z7);
        } else {
            gVar.b(bVar, f7, z7, new f(bVar, dVar, j5, gVar, z6, z7, f7));
        }
    }

    public final void v(d dVar, long j5, l0.g gVar, boolean z6, boolean z7) {
        boolean z8;
        float f7;
        boolean z9;
        r5.h.f(dVar, "hitTestSource");
        r5.h.f(gVar, "hitTestResult");
        a.b r6 = r(dVar.b());
        boolean z10 = true;
        if (B(j5)) {
            if (r6 == null) {
                w(dVar, j5, gVar, z6, z7);
                return;
            }
            float b2 = a0.a.b(j5);
            float c7 = a0.a.c(j5);
            if (b2 >= 0.0f && c7 >= 0.0f && b2 < ((float) c()) && c7 < ((float) q2.a.w(this.f4570f))) {
                t(r6, dVar, j5, gVar, z6, z7);
                return;
            }
            float h7 = !z6 ? Float.POSITIVE_INFINITY : h(j5, p());
            if ((Float.isInfinite(h7) || Float.isNaN(h7)) ? false : true) {
                if (gVar.f4845h == q2.a.x(gVar)) {
                    z8 = z7;
                } else {
                    z8 = z7;
                    if (a0.b.i(gVar.a(), a0.b.b(h7, z8)) <= 0) {
                        z10 = false;
                    }
                }
                if (z10) {
                    f7 = h7;
                    z9 = z8;
                }
            }
            A(r6, dVar, j5, gVar, z6, z7, h7);
            return;
        } else if (!z6) {
            return;
        } else {
            float h8 = h(j5, p());
            if (!((Float.isInfinite(h8) || Float.isNaN(h8)) ? false : true)) {
                return;
            }
            if (gVar.f4845h != q2.a.x(gVar)) {
                if (a0.b.i(gVar.a(), a0.b.b(h8, false)) <= 0) {
                    z10 = false;
                }
            }
            if (!z10) {
                return;
            }
            z9 = false;
            f7 = h8;
        }
        u(r6, dVar, j5, gVar, z6, z9, f7);
    }

    public void w(d dVar, long j5, l0.g gVar, boolean z6, boolean z7) {
        r5.h.f(dVar, "hitTestSource");
        r5.h.f(gVar, "hitTestResult");
    }

    public final void x() {
    }

    public final boolean y() {
        return false;
    }

    public void z(CanvasOperations canvasOperations) {
        r5.h.f(canvasOperations, "canvas");
    }
}
