package l0;

import Graphics_1.CanvasOperations;
import java.util.Arrays;
import java.util.Comparator;
import p.h;
import p.n0;
import q.e;

/* loaded from: classes.dex */
public final class o implements d0 {

    /* renamed from: u */
    public static final b f4857u = new b();

    /* renamed from: v */
    public static final a f4858v = new a();

    /* renamed from: w */
    public static final n f4859w = new Comparator() { // from class: l0.n
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            o oVar = (o) obj;
            o oVar2 = (o) obj2;
            oVar.f4872t.f4878b.getClass();
            oVar2.f4872t.f4878b.getClass();
            return (0.0f > 0.0f ? 1 : (0.0f == 0.0f ? 0 : -1)) == 0 ? r5.h.h(oVar.d(), oVar2.d()) : Float.compare(0.0f, 0.0f);
        }
    };

    /* renamed from: f */
    public final boolean f4860f;

    /* renamed from: g */
    public int f4861g;

    /* renamed from: h */
    public final n0 f4862h;

    /* renamed from: i */
    public q.e f4863i;

    /* renamed from: j */
    public boolean f4864j;

    /* renamed from: k */
    public o0.f f4865k;

    /* renamed from: l */
    public final q.e f4866l;
    public boolean m;

    /* renamed from: n */
    public j0.b f4867n;

    /* renamed from: o */
    public t0.c f4868o;

    /* renamed from: p */
    public t0.g f4869p;

    /* renamed from: q */
    public a f4870q;

    /* renamed from: r */
    public int f4871r;
    public final v s;

    /* renamed from: t */
    public final s f4872t;

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.ui.platform.c0 {
    }

    /* loaded from: classes.dex */
    public static final class b extends c {
    }

    /* loaded from: classes.dex */
    public static abstract class c implements j0.b {
    }

    /* loaded from: classes.dex */
    public static final class d extends r5.i implements q5.a {

        /* renamed from: h */
        public final /* synthetic */ r5.s f4874h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r5.s sVar) {
            super(0);
            o.this = r1;
            this.f4874h = sVar;
        }

        public final Object d() {
            v vVar = o.this.s;
            r5.s sVar = this.f4874h;
            if ((vVar.f4886d.f6421b & 8) != 0) {
                for (j0 j0Var = vVar.f4885c; j0Var != null; j0Var = null) {
                    j0Var.getClass();
                    if (false & true) {
                        for (j0 j0Var2 = j0Var; j0Var2 != null; j0Var2 = null) {
                            if (j0Var2 instanceof i0) {
                                ((i0) j0Var2).b((o0.f) sVar.f5927f);
                            } else {
                                j0Var2.getClass();
                                if ((false && true) && (j0Var2 instanceof l0.d)) {
                                    l0.d dVar = (l0.d) j0Var2;
                                }
                            }
                        }
                    }
                    j0Var.getClass();
                }
            }
            return f5.g.f4141a;
        }
    }

    public o() {
        this(0);
    }

    public o(int i7) {
        this(o0.g.f5234a.addAndGet(1), false);
    }

    public static void l(o oVar, boolean z6, int i7) {
        oVar.getClass();
        if (oVar.f4860f) {
            return;
        }
        oVar.getClass();
    }

    public final void a(CanvasOperations canvasOperations) {
        r5.h.f(canvasOperations, "canvas");
        this.s.f4884b.l(canvasOperations);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, o0.f] */
    public final o0.f b() {
        if (this.s.a(8) && this.f4865k == null) {
            r5.s sVar = new r5.s();
            sVar.f5927f = new o0.f();
            e0 snapshotObserver = a0.e.B(this).getSnapshotObserver();
            d dVar = new d(sVar);
            snapshotObserver.getClass();
            snapshotObserver.getClass();
            snapshotObserver.a(this, null, dVar);
            o0.f fVar = (o0.f) sVar.f5927f;
            this.f4865k = fVar;
            return fVar;
        }
        return this.f4865k;
    }

    public final o c() {
        return null;
    }

    public final int d() {
        return this.f4872t.f4878b.f4879h;
    }

    public final q.e e() {
        if (this.m) {
            this.f4866l.e();
            q.e eVar = this.f4866l;
            eVar.c(eVar.f5605h, f());
            q.e eVar2 = this.f4866l;
            n nVar = f4859w;
            eVar2.getClass();
            r5.h.f(nVar, "comparator");
            T[] tArr = eVar2.f5603f;
            int i7 = eVar2.f5605h;
            r5.h.f(tArr, "<this>");
            Arrays.sort(tArr, 0, i7, nVar);
            this.m = false;
        }
        return this.f4866l;
    }

    public final q.e f() {
        m();
        return (q.e) this.f4862h.f5443f;
    }

    public final void g(long j5, g gVar, boolean z6, boolean z7) {
        r5.h.f(gVar, "hitTestResult");
        this.s.f4884b.v(w.f4887l, this.s.f4884b.o(j5), gVar, z6, z7);
    }

    public final void h() {
        v vVar = this.s;
        h hVar = vVar.f4883a;
        for (w wVar = vVar.f4884b; wVar != hVar; wVar = null) {
            r5.h.d(wVar, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            m mVar = (m) wVar;
            mVar.getClass();
            mVar.getClass();
        }
        this.s.f4883a.getClass();
    }

    public final boolean i() {
        return false;
    }

    public final boolean j() {
        this.f4872t.f4878b.getClass();
        return false;
    }

    public final void k(boolean z6) {
    }

    public final void m() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(z.p(this));
        sb.append(" children: ");
        q.e f7 = f();
        e.a aVar = f7.f5604g;
        if (aVar == null) {
            aVar = new e.a(f7);
            f7.f5604g = aVar;
        }
        sb.append(aVar.f5606f.f5605h);
        sb.append(" measurePolicy: ");
        sb.append(this.f4867n);
        return sb.toString();
    }

    public o(int i7, boolean z6) {
        this.f4860f = z6;
        this.f4861g = i7;
        this.f4862h = new n0(new q.e(new o[16]), new p(this));
        this.f4866l = new q.e(new o[16]);
        this.m = true;
        this.f4867n = f4857u;
        new i(this);
        this.f4868o = a0.e.f42h0;
        this.f4869p = t0.g.Ltr;
        this.f4870q = f4858v;
        p.h.e.getClass();
        t.c cVar = h.a.f5432b;
        this.f4871r = 3;
        this.s = new v(this);
        this.f4872t = new s(this);
    }
}
