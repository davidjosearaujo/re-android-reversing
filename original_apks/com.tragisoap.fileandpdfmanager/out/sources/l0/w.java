package l0;

import b0.k;
import q5.l;
import r5.i;
import x.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class w extends t implements d0, l<b0.d, f5.g> {

    /* renamed from: l */
    public static final a f4887l = new a();
    public static final b m = new b();

    /* renamed from: h */
    public final o f4888h;

    /* renamed from: i */
    public t0.c f4889i;

    /* renamed from: j */
    public float f4890j = 0.8f;

    /* renamed from: k */
    public long f4891k = t0.f.f6007a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements d {
        @Override // l0.w.d
        public final void a(o oVar, long j7, g gVar, boolean z6, boolean z7) {
            r5.h.f(gVar, "hitTestResult");
            oVar.g(j7, gVar, z6, z7);
        }

        @Override // l0.w.d
        public final int b() {
            return 16;
        }

        @Override // l0.w.d
        public final boolean c(o oVar) {
            r5.h.f(oVar, "parentLayoutNode");
            return true;
        }

        @Override // l0.w.d
        public final boolean d(a.b bVar) {
            r5.h.f(bVar, "node");
            while (true) {
                boolean z6 = false;
                if (bVar == null) {
                    return false;
                }
                if (!(bVar instanceof g0)) {
                    bVar.getClass();
                    if (false && true) {
                        z6 = true;
                    }
                    if (z6 && (bVar instanceof d)) {
                        d dVar = (d) bVar;
                    }
                } else if (((g0) bVar).d()) {
                    return true;
                }
                bVar = null;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b implements d {
        @Override // l0.w.d
        public final void a(o oVar, long j7, g gVar, boolean z6, boolean z7) {
            r5.h.f(gVar, "hitTestResult");
            oVar.s.f4884b.v(w.m, oVar.s.f4884b.o(j7), gVar, true, z7);
        }

        @Override // l0.w.d
        public final int b() {
            return 8;
        }

        @Override // l0.w.d
        public final boolean c(o oVar) {
            r5.h.f(oVar, "parentLayoutNode");
            o0.f b2 = oVar.b();
            boolean z6 = false;
            if (b2 != null && b2.f5233h) {
                z6 = true;
            }
            return !z6;
        }

        @Override // l0.w.d
        public final boolean d(a.b bVar) {
            r5.h.f(bVar, "node");
            return false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends i implements l<w, f5.g> {

        /* renamed from: g */
        public static final c f4892g = new c();

        public c() {
            super(1);
        }

        @Override // q5.l
        public final f5.g k(w wVar) {
            w wVar2 = wVar;
            r5.h.f(wVar2, "coordinator");
            wVar2.getClass();
            return f5.g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d {
        void a(o oVar, long j7, g gVar, boolean z6, boolean z7);

        int b();

        boolean c(o oVar);

        boolean d(a.b bVar);
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class e extends i implements q5.a<f5.g> {

        /* renamed from: h */
        public final /* synthetic */ a.b f4894h;

        /* renamed from: i */
        public final /* synthetic */ d f4895i;

        /* renamed from: j */
        public final /* synthetic */ long f4896j;

        /* renamed from: k */
        public final /* synthetic */ g f4897k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4898l;
        public final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7) {
            super(0);
            w.this = r1;
            this.f4894h = bVar;
            this.f4895i = dVar;
            this.f4896j = j7;
            this.f4897k = gVar;
            this.f4898l = z6;
            this.m = z7;
        }

        @Override // q5.a
        public final f5.g d() {
            w.this.t(y.a(this.f4894h, this.f4895i.b()), this.f4895i, this.f4896j, this.f4897k, this.f4898l, this.m);
            return f5.g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class f extends i implements q5.a<f5.g> {

        /* renamed from: h */
        public final /* synthetic */ a.b f4900h;

        /* renamed from: i */
        public final /* synthetic */ d f4901i;

        /* renamed from: j */
        public final /* synthetic */ long f4902j;

        /* renamed from: k */
        public final /* synthetic */ g f4903k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4904l;
        public final /* synthetic */ boolean m;

        /* renamed from: n */
        public final /* synthetic */ float f4905n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7, float f7) {
            super(0);
            w.this = r1;
            this.f4900h = bVar;
            this.f4901i = dVar;
            this.f4902j = j7;
            this.f4903k = gVar;
            this.f4904l = z6;
            this.m = z7;
            this.f4905n = f7;
        }

        @Override // q5.a
        public final f5.g d() {
            w.this.u(y.a(this.f4900h, this.f4901i.b()), this.f4901i, this.f4902j, this.f4903k, this.f4904l, this.m, this.f4905n);
            return f5.g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class g extends i implements q5.a<f5.g> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g() {
            super(0);
            w.this = r1;
        }

        @Override // q5.a
        public final f5.g d() {
            w.this.getClass();
            return f5.g.f4141a;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class h extends i implements q5.a<f5.g> {

        /* renamed from: h */
        public final /* synthetic */ a.b f4908h;

        /* renamed from: i */
        public final /* synthetic */ d f4909i;

        /* renamed from: j */
        public final /* synthetic */ long f4910j;

        /* renamed from: k */
        public final /* synthetic */ g f4911k;

        /* renamed from: l */
        public final /* synthetic */ boolean f4912l;
        public final /* synthetic */ boolean m;

        /* renamed from: n */
        public final /* synthetic */ float f4913n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7, float f7) {
            super(0);
            w.this = r1;
            this.f4908h = bVar;
            this.f4909i = dVar;
            this.f4910j = j7;
            this.f4911k = gVar;
            this.f4912l = z6;
            this.m = z7;
            this.f4913n = f7;
        }

        @Override // q5.a
        public final f5.g d() {
            w.this.A(y.a(this.f4908h, this.f4909i.b()), this.f4909i, this.f4910j, this.f4911k, this.f4912l, this.m, this.f4913n);
            return f5.g.f4141a;
        }
    }

    static {
        new k();
        new j();
        a0.b.j();
    }

    public w(o oVar) {
        r5.h.f(oVar, "layoutNode");
        this.f4888h = oVar;
        this.f4889i = oVar.f4868o;
        t0.g gVar = oVar.f4869p;
        new g();
    }

    public final void A(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7, float f7) {
        if (bVar == null) {
            w(dVar, j7, gVar, z6, z7);
        } else if (dVar.d(bVar)) {
            h hVar = new h(bVar, dVar, j7, gVar, z6, z7, f7);
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
        } else {
            A(y.a(bVar, dVar.b()), dVar, j7, gVar, z6, z7, f7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(long r4) {
        /*
            r3 = this;
            float r3 = a0.a.b(r4)
            boolean r0 = java.lang.Float.isInfinite(r3)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0014
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x0014
            r3 = r1
            goto L_0x0015
        L_0x0014:
            r3 = r2
        L_0x0015:
            if (r3 == 0) goto L_0x002e
            float r3 = a0.a.c(r4)
            boolean r4 = java.lang.Float.isInfinite(r3)
            if (r4 != 0) goto L_0x0029
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x0029
            r3 = r1
            goto L_0x002a
        L_0x0029:
            r3 = r2
        L_0x002a:
            if (r3 == 0) goto L_0x002e
            r3 = r1
            goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            if (r3 != 0) goto L_0x0032
            return r2
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.w.B(long):boolean");
    }

    public final long g(long j7) {
        return a0.e.d(Math.max(0.0f, (a0.d.b(j7) - ((float) c())) / 2.0f), Math.max(0.0f, (a0.d.a(j7) - ((float) q2.a.w(this.f4570f))) / 2.0f));
    }

    @Override // t0.c
    public final float getDensity() {
        return this.f4888h.f4868o.getDensity();
    }

    public final float h(long j7, long j8) {
        if (((float) c()) >= a0.d.b(j8) && ((float) q2.a.w(this.f4570f)) >= a0.d.a(j8)) {
            return Float.POSITIVE_INFINITY;
        }
        long g2 = g(j8);
        float b2 = a0.d.b(g2);
        float a7 = a0.d.a(g2);
        float b7 = a0.a.b(j7);
        float max = Math.max(0.0f, b7 < 0.0f ? -b7 : b7 - ((float) c()));
        float c7 = a0.a.c(j7);
        long a8 = a0.b.a(max, Math.max(0.0f, c7 < 0.0f ? -c7 : c7 - ((float) q2.a.w(this.f4570f))));
        if ((b2 <= 0.0f && a7 <= 0.0f) || a0.a.b(a8) > b2 || a0.a.c(a8) > a7) {
            return Float.POSITIVE_INFINITY;
        }
        return (a0.a.c(a8) * a0.a.c(a8)) + (a0.a.b(a8) * a0.a.b(a8));
    }

    @Override // q5.l
    public final f5.g k(b0.d dVar) {
        b0.d dVar2 = dVar;
        r5.h.f(dVar2, "canvas");
        if (this.f4888h.j()) {
            a0.e.B(this.f4888h).getSnapshotObserver().a(this, c.f4892g, new x(this, dVar2));
        }
        return f5.g.f4141a;
    }

    public final void l(b0.d dVar) {
        r5.h.f(dVar, "canvas");
        long j7 = this.f4891k;
        float f7 = (float) ((int) (j7 >> 32));
        float a7 = (float) t0.f.a(j7);
        dVar.b(f7, a7);
        n(dVar);
        dVar.b(-f7, -a7);
    }

    public final void m(b0.d dVar, b0.c cVar) {
        r5.h.f(dVar, "canvas");
        r5.h.f(cVar, "paint");
        long j7 = this.f4570f;
        dVar.a(new a0.c(0.5f, 0.5f, ((float) ((int) (j7 >> 32))) - 0.5f, ((float) q2.a.w(j7)) - 0.5f), cVar);
    }

    public final void n(b0.d dVar) {
        a.b r6 = r(4);
        if (r6 == null) {
            z(dVar);
            return;
        }
        o oVar = this.f4888h;
        oVar.getClass();
        r sharedDrawScope = a0.e.B(oVar).getSharedDrawScope();
        long j7 = this.f4570f;
        a0.e.d((float) ((int) (j7 >> 32)), (float) q2.a.w(j7));
        sharedDrawScope.getClass();
        r5.h.f(dVar, "canvas");
        while (r6 != null) {
            if (!(r6 instanceof e)) {
                r6.getClass();
                if ((false & true) && (r6 instanceof d)) {
                    d dVar2 = (d) r6;
                }
                r6 = null;
            } else {
                e eVar = sharedDrawScope.f4876f;
                sharedDrawScope.f4876f = (e) r6;
                sharedDrawScope.getClass();
                t0.g gVar = this.f4888h.f4869p;
                throw null;
            }
        }
    }

    public final long o(long j7) {
        long j8 = this.f4891k;
        float b2 = a0.a.b(j7);
        int i7 = t0.f.f6008b;
        return a0.b.a(b2 - ((float) ((int) (j8 >> 32))), a0.a.c(j7) - ((float) t0.f.a(j8)));
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
        if (b2) {
            a.b s = s(b2);
            while (s != null && (s.f6421b & i7) != 0) {
                s.getClass();
                if ((0 & i7) != 0) {
                    return s;
                }
                if (s == q6) {
                    return null;
                }
                s = null;
                s.getClass();
            }
            return null;
        }
        q6.getClass();
        return null;
    }

    public final a.b s(boolean z6) {
        v vVar = this.f4888h.s;
        if (vVar.f4884b == this) {
            return vVar.f4886d;
        }
        return null;
    }

    public final void t(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7) {
        if (bVar == null) {
            w(dVar, j7, gVar, z6, z7);
            return;
        }
        e eVar = new e(bVar, dVar, j7, gVar, z6, z7);
        gVar.getClass();
        gVar.b(bVar, -1.0f, z7, eVar);
    }

    public final void u(a.b bVar, d dVar, long j7, g gVar, boolean z6, boolean z7, float f7) {
        if (bVar == null) {
            w(dVar, j7, gVar, z6, z7);
        } else {
            gVar.b(bVar, f7, z7, new f(bVar, dVar, j7, gVar, z6, z7, f7));
        }
    }

    public final void v(d dVar, long j7, g gVar, boolean z6, boolean z7) {
        float f7;
        boolean z8;
        r5.h.f(dVar, "hitTestSource");
        r5.h.f(gVar, "hitTestResult");
        a.b r6 = r(dVar.b());
        boolean z9 = true;
        if (!B(j7)) {
            if (z6) {
                float h7 = h(j7, p());
                if (!Float.isInfinite(h7) && !Float.isNaN(h7)) {
                    if (gVar.f4845h != q2.a.x(gVar)) {
                        if (a0.b.i(gVar.a(), a0.b.b(h7, false)) <= 0) {
                            z9 = false;
                        }
                    }
                    if (z9) {
                        z8 = false;
                        f7 = h7;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (r6 == null) {
            w(dVar, j7, gVar, z6, z7);
            return;
        } else {
            float b2 = a0.a.b(j7);
            float c7 = a0.a.c(j7);
            if (b2 >= 0.0f && c7 >= 0.0f && b2 < ((float) c()) && c7 < ((float) q2.a.w(this.f4570f))) {
                t(r6, dVar, j7, gVar, z6, z7);
                return;
            }
            float h8 = !z6 ? Float.POSITIVE_INFINITY : h(j7, p());
            if (!Float.isInfinite(h8) && !Float.isNaN(h8)) {
                if (gVar.f4845h == q2.a.x(gVar)) {
                    z8 = z7;
                } else {
                    z8 = z7;
                    if (a0.b.i(gVar.a(), a0.b.b(h8, z8)) <= 0) {
                        z9 = false;
                    }
                }
                if (z9) {
                    f7 = h8;
                }
            }
            A(r6, dVar, j7, gVar, z6, z7, h8);
            return;
        }
        u(r6, dVar, j7, gVar, z6, z8, f7);
    }

    public void w(d dVar, long j7, g gVar, boolean z6, boolean z7) {
        r5.h.f(dVar, "hitTestSource");
        r5.h.f(gVar, "hitTestResult");
    }

    public final void x() {
    }

    public final boolean y() {
        return false;
    }

    public void z(b0.d dVar) {
        r5.h.f(dVar, "canvas");
    }
}
