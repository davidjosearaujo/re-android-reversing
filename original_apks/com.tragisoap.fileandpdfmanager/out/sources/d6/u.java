package d6;

import a0.e;
import a6.h;
import a6.i0;
import a6.j0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import e6.b;
import e6.c;
import e6.i;
import e6.l;
import f5.g;
import i5.d;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class u<T> extends b<w> implements p<T>, c, l<T> {

    /* renamed from: j */
    public final int f3733j = 1;

    /* renamed from: k */
    public final int f3734k = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: l */
    public final c6.a f3735l;
    public Object[] m;

    /* renamed from: n */
    public long f3736n;

    /* renamed from: o */
    public long f3737o;

    /* renamed from: p */
    public int f3738p;

    /* renamed from: q */
    public int f3739q;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a implements i0 {

        /* renamed from: f */
        public final u<?> f3740f;

        /* renamed from: g */
        public long f3741g;

        /* renamed from: h */
        public final Object f3742h;

        /* renamed from: i */
        public final d<g> f3743i;

        public a(u uVar, long j7, Object obj, h hVar) {
            this.f3740f = uVar;
            this.f3741g = j7;
            this.f3742h = obj;
            this.f3743i = hVar;
        }

        @Override // a6.i0
        public final void a() {
            u<?> uVar = this.f3740f;
            synchronized (uVar) {
                if (this.f3741g >= uVar.q()) {
                    Object[] objArr = uVar.m;
                    r5.h.c(objArr);
                    int i7 = (int) this.f3741g;
                    if (objArr[(objArr.length - 1) & i7] == this) {
                        objArr[i7 & (objArr.length - 1)] = a0.b.f18r;
                        uVar.i();
                        g gVar = g.f4141a;
                    }
                }
            }
        }
    }

    public u() {
        c6.a aVar = c6.a.DROP_OLDEST;
        this.f3735l = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        throw r8.G();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j5.a j(d6.u r8, d6.d r9, i5.d r10) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.u.j(d6.u, d6.d, i5.d):j5.a");
    }

    @Override // d6.t, d6.c
    public final Object a(d<? super T> dVar, d<?> dVar2) {
        j(this, dVar, dVar2);
        return j5.a.f4591f;
    }

    @Override // d6.p
    public final void b() {
        synchronized (this) {
            v(q() + ((long) this.f3738p), this.f3737o, q() + ((long) this.f3738p), q() + ((long) this.f3738p) + ((long) this.f3739q));
            g gVar = g.f4141a;
        }
    }

    @Override // e6.l
    public final c<T> c(f fVar, int i7, c6.a aVar) {
        return ((i7 == 0 || i7 == -3) && aVar == c6.a.SUSPEND) ? this : new i(i7, fVar, aVar, this);
    }

    @Override // e6.b
    public final w e() {
        return new w();
    }

    @Override // e6.b
    public final c[] f() {
        return new w[2];
    }

    public final Object h(w wVar, v vVar) {
        h hVar = new h(1, q2.a.A(vVar));
        hVar.u();
        synchronized (this) {
            if (t(wVar) < 0) {
                wVar.f3751b = hVar;
            } else {
                hVar.o(g.f4141a);
            }
            g gVar = g.f4141a;
        }
        Object t5 = hVar.t();
        return t5 == j5.a.f4591f ? t5 : g.f4141a;
    }

    public final void i() {
        if (this.f3734k != 0 || this.f3739q > 1) {
            Object[] objArr = this.m;
            r5.h.c(objArr);
            while (this.f3739q > 0) {
                long q6 = q();
                int i7 = this.f3738p;
                int i8 = this.f3739q;
                if (objArr[((int) ((q6 + ((long) (i7 + i8))) - 1)) & (objArr.length - 1)] == a0.b.f18r) {
                    this.f3739q = i8 - 1;
                    objArr[((int) (q() + ((long) (this.f3738p + this.f3739q)))) & (objArr.length - 1)] = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void k() {
        Object[] objArr;
        Object[] objArr2 = this.m;
        r5.h.c(objArr2);
        objArr2[((int) q()) & (objArr2.length - 1)] = null;
        this.f3738p--;
        long q6 = q() + 1;
        if (this.f3736n < q6) {
            this.f3736n = q6;
        }
        if (this.f3737o < q6) {
            if (!(this.f3871g == 0 || (objArr = this.f3870f) == null)) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        w wVar = (w) obj;
                        long j7 = wVar.f3750a;
                        if (j7 >= 0 && j7 < q6) {
                            wVar.f3750a = q6;
                        }
                    }
                }
            }
            this.f3737o = q6;
        }
    }

    @Override // d6.p
    public final boolean l(T t5) {
        int i7;
        boolean z6;
        d<g>[] dVarArr = e.X;
        synchronized (this) {
            if (s(t5)) {
                dVarArr = p(dVarArr);
                z6 = true;
            } else {
                z6 = false;
            }
        }
        for (d<g> dVar : dVarArr) {
            if (dVar != null) {
                dVar.o(g.f4141a);
            }
        }
        return z6;
    }

    @Override // d6.d
    public final Object m(T t5, d<? super g> dVar) {
        a aVar;
        if (!l(t5)) {
            h hVar = new h(1, q2.a.A(dVar));
            hVar.u();
            d<g>[] dVarArr = e.X;
            synchronized (this) {
                if (s(t5)) {
                    hVar.o(g.f4141a);
                    dVarArr = p(dVarArr);
                    aVar = null;
                } else {
                    a aVar2 = new a(this, ((long) (this.f3738p + this.f3739q)) + q(), t5, hVar);
                    o(aVar2);
                    this.f3739q++;
                    if (this.f3734k == 0) {
                        dVarArr = p(dVarArr);
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                hVar.w(new j0(0, aVar));
            }
            for (d<g> dVar2 : dVarArr) {
                if (dVar2 != null) {
                    dVar2.o(g.f4141a);
                }
            }
            Object t6 = hVar.t();
            j5.a aVar3 = j5.a.f4591f;
            if (t6 != aVar3) {
                t6 = g.f4141a;
            }
            if (t6 == aVar3) {
                return t6;
            }
        }
        return g.f4141a;
    }

    public final void o(Object obj) {
        int i7 = this.f3738p + this.f3739q;
        Object[] objArr = this.m;
        if (objArr == null) {
            objArr = r(0, 2, null);
        } else if (i7 >= objArr.length) {
            objArr = r(i7, objArr.length * 2, objArr);
        }
        objArr[((int) (q() + ((long) i7))) & (objArr.length - 1)] = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i5.d<f5.g>[] p(i5.d<f5.g>[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.f3871g
            if (r1 == 0) goto L_0x0043
            S extends e6.c<?>[] r1 = r10.f3870f
            if (r1 == 0) goto L_0x0043
            r2 = 0
            int r3 = r1.length
        L_0x000b:
            if (r2 >= r3) goto L_0x0043
            r4 = r1[r2]
            if (r4 == 0) goto L_0x0040
            d6.w r4 = (d6.w) r4
            a6.h r5 = r4.f3751b
            if (r5 != 0) goto L_0x0018
            goto L_0x0040
        L_0x0018:
            long r6 = r10.t(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0040
            int r6 = r11.length
            if (r0 < r6) goto L_0x0035
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            r5.h.e(r11, r6)
        L_0x0035:
            r6 = r11
            i5.d[] r6 = (i5.d[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f3751b = r0
            r0 = r7
        L_0x0040:
            int r2 = r2 + 1
            goto L_0x000b
        L_0x0043:
            i5.d[] r11 = (i5.d[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.u.p(i5.d[]):i5.d[]");
    }

    public final long q() {
        return Math.min(this.f3737o, this.f3736n);
    }

    public final Object[] r(int i7, int i8, Object[] objArr) {
        if (i8 > 0) {
            Object[] objArr2 = new Object[i8];
            this.m = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long q6 = q();
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = (int) (((long) i9) + q6);
                objArr2[i10 & (i8 - 1)] = objArr[(objArr.length - 1) & i10];
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean s(T t5) {
        if (this.f3871g == 0) {
            if (this.f3733j != 0) {
                o(t5);
                int i7 = this.f3738p + 1;
                this.f3738p = i7;
                if (i7 > this.f3733j) {
                    k();
                }
                this.f3737o = q() + ((long) this.f3738p);
            }
            return true;
        }
        if (this.f3738p >= this.f3734k && this.f3737o <= this.f3736n) {
            int ordinal = this.f3735l.ordinal();
            if (ordinal == 0) {
                return false;
            }
            if (ordinal == 2) {
                return true;
            }
        }
        o(t5);
        int i8 = this.f3738p + 1;
        this.f3738p = i8;
        if (i8 > this.f3734k) {
            k();
        }
        long q6 = q() + ((long) this.f3738p);
        long j7 = this.f3736n;
        if (((int) (q6 - j7)) > this.f3733j) {
            v(1 + j7, this.f3737o, q() + ((long) this.f3738p), q() + ((long) this.f3738p) + ((long) this.f3739q));
        }
        return true;
    }

    public final long t(w wVar) {
        long j7 = wVar.f3750a;
        if (j7 < q() + ((long) this.f3738p)) {
            return j7;
        }
        if (this.f3734k <= 0 && j7 <= q() && this.f3739q != 0) {
            return j7;
        }
        return -1;
    }

    public final Object u(w wVar) {
        Object obj;
        d<g>[] dVarArr = e.X;
        synchronized (this) {
            long t5 = t(wVar);
            if (t5 < 0) {
                obj = a0.b.f18r;
            } else {
                long j7 = wVar.f3750a;
                Object[] objArr = this.m;
                r5.h.c(objArr);
                obj = objArr[((int) t5) & (objArr.length - 1)];
                if (obj instanceof a) {
                    obj = ((a) obj).f3742h;
                }
                wVar.f3750a = t5 + 1;
                dVarArr = w(j7);
            }
        }
        for (d<g> dVar : dVarArr) {
            if (dVar != null) {
                dVar.o(g.f4141a);
            }
        }
        return obj;
    }

    public final void v(long j7, long j8, long j9, long j10) {
        long min = Math.min(j8, j7);
        for (long q6 = q(); q6 < min; q6++) {
            Object[] objArr = this.m;
            r5.h.c(objArr);
            objArr[((int) q6) & (objArr.length - 1)] = null;
        }
        this.f3736n = j7;
        this.f3737o = j8;
        this.f3738p = (int) (j9 - min);
        this.f3739q = (int) (j10 - j9);
    }

    public final d<g>[] w(long j7) {
        long j8;
        long j9;
        Object[] objArr;
        if (j7 > this.f3737o) {
            return e.X;
        }
        long q6 = q();
        long j10 = ((long) this.f3738p) + q6;
        if (this.f3734k == 0 && this.f3739q > 0) {
            j10++;
        }
        if (!(this.f3871g == 0 || (objArr = this.f3870f) == null)) {
            for (Object obj : objArr) {
                if (obj != null) {
                    long j11 = ((w) obj).f3750a;
                    if (j11 >= 0 && j11 < j10) {
                        j10 = j11;
                    }
                }
            }
        }
        if (j10 <= this.f3737o) {
            return e.X;
        }
        long q7 = q() + ((long) this.f3738p);
        int min = this.f3871g > 0 ? Math.min(this.f3739q, this.f3734k - ((int) (q7 - j10))) : this.f3739q;
        d<g>[] dVarArr = e.X;
        long j12 = ((long) this.f3739q) + q7;
        if (min > 0) {
            dVarArr = new d[min];
            Object[] objArr2 = this.m;
            r5.h.c(objArr2);
            q7 = q7;
            int i7 = 0;
            while (true) {
                if (q7 >= j12) {
                    j8 = j10;
                    j12 = j12;
                    break;
                }
                int i8 = (int) q7;
                j8 = j10;
                Object obj2 = objArr2[(objArr2.length - 1) & i8];
                q.d dVar = a0.b.f18r;
                if (obj2 != dVar) {
                    j12 = j12;
                    r5.h.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) obj2;
                    int i9 = i7 + 1;
                    dVarArr[i7] = aVar.f3743i;
                    objArr2[i8 & (objArr2.length - 1)] = dVar;
                    objArr2[((int) q7) & (objArr2.length - 1)] = aVar.f3742h;
                    j9 = 1;
                    q7++;
                    if (i9 >= min) {
                        break;
                    }
                    i7 = i9;
                } else {
                    j12 = j12;
                    j9 = 1;
                }
                q7 += j9;
                j10 = j8;
            }
        } else {
            j8 = j10;
            j12 = j12;
        }
        int i10 = (int) (q7 - q6);
        if (this.f3871g == 0) {
            j8 = q7;
        }
        long max = Math.max(this.f3736n, q7 - ((long) Math.min(this.f3733j, i10)));
        if (this.f3734k == 0 && max < j12) {
            Object[] objArr3 = this.m;
            r5.h.c(objArr3);
            if (r5.h.a(objArr3[((int) max) & (objArr3.length - 1)], a0.b.f18r)) {
                q7++;
                max++;
            }
        }
        v(max, j8, q7, j12);
        i();
        boolean z6 = true;
        if (dVarArr.length != 0) {
            z6 = false;
        }
        return z6 ^ true ? p(dVarArr) : dVarArr;
    }
}
