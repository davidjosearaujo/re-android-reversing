package d6;

import a6.i0;
import a6.j0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class u<T> extends e6.b implements p, c, e6.l {

    /* renamed from: j */
    public final int f3733j;

    /* renamed from: k */
    public final int f3734k;

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

    /* loaded from: classes.dex */
    public static final class a implements i0 {

        /* renamed from: f */
        public final u f3740f;

        /* renamed from: g */
        public long f3741g;

        /* renamed from: h */
        public final Object f3742h;

        /* renamed from: i */
        public final i5.d f3743i;

        public a(u uVar, long j5, Object obj, a6.h hVar) {
            this.f3740f = uVar;
            this.f3741g = j5;
            this.f3742h = obj;
            this.f3743i = hVar;
        }

        public final void a() {
            u uVar = this.f3740f;
            synchronized (uVar) {
                if (this.f3741g >= uVar.q()) {
                    Object[] objArr = uVar.m;
                    r5.h.c(objArr);
                    int i7 = (int) this.f3741g;
                    if (objArr[(objArr.length - 1) & i7] == this) {
                        objArr[i7 & (objArr.length - 1)] = a0.b.f18r;
                        uVar.i();
                        f5.g gVar = f5.g.f4141a;
                    }
                }
            }
        }
    }

    public u() {
        c6.a aVar = c6.a.DROP_OLDEST;
        this.f3733j = 1;
        this.f3734k = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f3735l = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x00b0, code lost:
        throw r8.G();
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static Kotlin_1.a j(d6.u r8, d6.d r9, i5.d r10) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.u.j(d6.u, d6.d, i5.d):j5.a");
    }

    public final Object a(d dVar, i5.d dVar2) {
        j(this, dVar, dVar2);
        return Kotlin_1.a.f4591f;
    }

    public final void b() {
        synchronized (this) {
            v(q() + this.f3738p, this.f3737o, q() + this.f3738p, q() + this.f3738p + this.f3739q);
            f5.g gVar = f5.g.f4141a;
        }
    }

    public final c c(i5.f fVar, int i7, c6.a aVar) {
        return ((i7 == 0 || i7 == -3) && aVar == c6.a.SUSPEND) ? this : new e6.i(i7, fVar, aVar, this);
    }

    public final e6.c e() {
        return new w();
    }

    public final e6.c[] f() {
        return new w[2];
    }

    public final Object h(w wVar, v vVar) {
        a6.h hVar = new a6.h(1, q2.a.A(vVar));
        hVar.u();
        synchronized (this) {
            if (t(wVar) < 0) {
                wVar.f3751b = hVar;
            } else {
                hVar.o(f5.g.f4141a);
            }
            f5.g gVar = f5.g.f4141a;
        }
        Object t5 = hVar.t();
        return t5 == Kotlin_1.a.f4591f ? t5 : f5.g.f4141a;
    }

    public final void i() {
        if (this.f3734k != 0 || this.f3739q > 1) {
            Object[] objArr = this.m;
            r5.h.c(objArr);
            while (this.f3739q > 0) {
                long q6 = q();
                int i7 = this.f3738p;
                int i8 = this.f3739q;
                if (objArr[((int) ((q6 + (i7 + i8)) - 1)) & (objArr.length - 1)] != a0.b.f18r) {
                    return;
                }
                this.f3739q = i8 - 1;
                objArr[((int) (q() + this.f3738p + this.f3739q)) & (objArr.length - 1)] = null;
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
            if (this.f3871g != 0 && (objArr = this.f3870f) != null) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        w wVar = (w) obj;
                        long j5 = wVar.f3750a;
                        if (j5 >= 0 && j5 < q6) {
                            wVar.f3750a = q6;
                        }
                    }
                }
            }
            this.f3737o = q6;
        }
    }

    public final boolean l(Object obj) {
        int i7;
        boolean z6;
        i5.d[] dVarArr = a0.e.X;
        synchronized (this) {
            if (s(obj)) {
                dVarArr = p(dVarArr);
                z6 = true;
            } else {
                z6 = false;
            }
        }
        for (i5.d dVar : dVarArr) {
            if (dVar != null) {
                dVar.o(f5.g.f4141a);
            }
        }
        return z6;
    }

    public final Object m(Object obj, i5.d dVar) {
        i5.d[] dVarArr;
        a aVar;
        if (!l(obj)) {
            a6.h hVar = new a6.h(1, q2.a.A(dVar));
            hVar.u();
            i5.d[] dVarArr2 = a0.e.X;
            synchronized (this) {
                if (s(obj)) {
                    hVar.o(f5.g.f4141a);
                    dVarArr = p(dVarArr2);
                    aVar = null;
                } else {
                    a aVar2 = new a(this, this.f3738p + this.f3739q + q(), obj, hVar);
                    o(aVar2);
                    this.f3739q++;
                    if (this.f3734k == 0) {
                        dVarArr2 = p(dVarArr2);
                    }
                    dVarArr = dVarArr2;
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                hVar.w(new j0(0, aVar));
            }
            for (i5.d dVar2 : dVarArr) {
                if (dVar2 != null) {
                    dVar2.o(f5.g.f4141a);
                }
            }
            Object t5 = hVar.t();
            Kotlin_1.a aVar3 = Kotlin_1.a.f4591f;
            if (t5 != aVar3) {
                t5 = f5.g.f4141a;
            }
            if (t5 == aVar3) {
                return t5;
            }
        }
        return f5.g.f4141a;
    }

    public final void o(Object obj) {
        int i7 = this.f3738p + this.f3739q;
        Object[] objArr = this.m;
        if (objArr == null) {
            objArr = r(0, 2, null);
        } else if (i7 >= objArr.length) {
            objArr = r(i7, objArr.length * 2, objArr);
        }
        objArr[((int) (q() + i7)) & (objArr.length - 1)] = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    public final i5.d[] p(i5.d[] dVarArr) {
        Object[] objArr;
        w wVar;
        a6.h hVar;
        int length = dVarArr.length;
        if (this.f3871g != 0 && (objArr = this.f3870f) != null) {
            int i7 = 0;
            int length2 = objArr.length;
            dVarArr = dVarArr;
            while (i7 < length2) {
                Object obj = objArr[i7];
                if (obj != null && (hVar = (wVar = (w) obj).f3751b) != null && t(wVar) >= 0) {
                    int length3 = dVarArr.length;
                    dVarArr = dVarArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(dVarArr, Math.max(2, dVarArr.length * 2));
                        r5.h.e(copyOf, "copyOf(this, newSize)");
                        dVarArr = copyOf;
                    }
                    dVarArr[length] = hVar;
                    wVar.f3751b = null;
                    length++;
                }
                i7++;
                dVarArr = dVarArr;
            }
        }
        return dVarArr;
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
                int i10 = (int) (i9 + q6);
                objArr2[i10 & (i8 - 1)] = objArr[(objArr.length - 1) & i10];
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean s(Object obj) {
        if (this.f3871g == 0) {
            if (this.f3733j != 0) {
                o(obj);
                int i7 = this.f3738p + 1;
                this.f3738p = i7;
                if (i7 > this.f3733j) {
                    k();
                }
                this.f3737o = q() + this.f3738p;
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
        o(obj);
        int i8 = this.f3738p + 1;
        this.f3738p = i8;
        if (i8 > this.f3734k) {
            k();
        }
        long q6 = q() + this.f3738p;
        long j5 = this.f3736n;
        if (((int) (q6 - j5)) > this.f3733j) {
            v(1 + j5, this.f3737o, q() + this.f3738p, q() + this.f3738p + this.f3739q);
        }
        return true;
    }

    public final long t(w wVar) {
        long j5 = wVar.f3750a;
        if (j5 < q() + this.f3738p) {
            return j5;
        }
        if (this.f3734k <= 0 && j5 <= q() && this.f3739q != 0) {
            return j5;
        }
        return -1L;
    }

    public final Object u(w wVar) {
        Object obj;
        i5.d[] dVarArr = a0.e.X;
        synchronized (this) {
            long t5 = t(wVar);
            if (t5 < 0) {
                obj = a0.b.f18r;
            } else {
                long j5 = wVar.f3750a;
                Object[] objArr = this.m;
                r5.h.c(objArr);
                Object obj2 = objArr[((int) t5) & (objArr.length - 1)];
                if (obj2 instanceof a) {
                    obj2 = ((a) obj2).f3742h;
                }
                wVar.f3750a = t5 + 1;
                Object obj3 = obj2;
                dVarArr = w(j5);
                obj = obj3;
            }
        }
        for (i5.d dVar : dVarArr) {
            if (dVar != null) {
                dVar.o(f5.g.f4141a);
            }
        }
        return obj;
    }

    public final void v(long j5, long j7, long j8, long j9) {
        long min = Math.min(j7, j5);
        for (long q6 = q(); q6 < min; q6++) {
            Object[] objArr = this.m;
            r5.h.c(objArr);
            objArr[((int) q6) & (objArr.length - 1)] = null;
        }
        this.f3736n = j5;
        this.f3737o = j7;
        this.f3738p = (int) (j8 - min);
        this.f3739q = (int) (j9 - j8);
    }

    public final i5.d[] w(long j5) {
        long j7;
        long j8;
        long j9;
        Object[] objArr;
        if (j5 > this.f3737o) {
            return a0.e.X;
        }
        long q6 = q();
        long j10 = this.f3738p + q6;
        if (this.f3734k == 0 && this.f3739q > 0) {
            j10++;
        }
        if (this.f3871g != 0 && (objArr = this.f3870f) != null) {
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
            return a0.e.X;
        }
        long q7 = q() + this.f3738p;
        int min = this.f3871g > 0 ? Math.min(this.f3739q, this.f3734k - ((int) (q7 - j10))) : this.f3739q;
        i5.d[] dVarArr = a0.e.X;
        long j12 = this.f3739q + q7;
        if (min > 0) {
            dVarArr = new i5.d[min];
            Object[] objArr2 = this.m;
            r5.h.c(objArr2);
            long j13 = q7;
            int i7 = 0;
            while (true) {
                if (q7 >= j12) {
                    j7 = j10;
                    j8 = j12;
                    break;
                }
                int i8 = (int) q7;
                j7 = j10;
                Object obj2 = objArr2[(objArr2.length - 1) & i8];
                q.d dVar = a0.b.f18r;
                if (obj2 != dVar) {
                    j8 = j12;
                    r5.h.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) obj2;
                    int i9 = i7 + 1;
                    dVarArr[i7] = aVar.f3743i;
                    objArr2[i8 & (objArr2.length - 1)] = dVar;
                    objArr2[((int) j13) & (objArr2.length - 1)] = aVar.f3742h;
                    j9 = 1;
                    j13++;
                    if (i9 >= min) {
                        break;
                    }
                    i7 = i9;
                } else {
                    j8 = j12;
                    j9 = 1;
                }
                q7 += j9;
                j10 = j7;
                j12 = j8;
            }
            q7 = j13;
        } else {
            j7 = j10;
            j8 = j12;
        }
        int i10 = (int) (q7 - q6);
        long j14 = this.f3871g == 0 ? q7 : j7;
        long max = Math.max(this.f3736n, q7 - Math.min(this.f3733j, i10));
        if (this.f3734k == 0 && max < j8) {
            Object[] objArr3 = this.m;
            r5.h.c(objArr3);
            if (r5.h.a(objArr3[((int) max) & (objArr3.length - 1)], a0.b.f18r)) {
                q7++;
                max++;
            }
        }
        v(max, j14, q7, j8);
        i();
        return (dVarArr.length == 0) ^ true ? p(dVarArr) : dVarArr;
    }
}
