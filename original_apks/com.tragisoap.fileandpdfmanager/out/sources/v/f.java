package v;

import f.t;
import f5.g;
import g5.n;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p.n0;
import p.q0;
import q.b;
import q5.l;
import q5.p;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f {

    /* renamed from: c */
    public static e f6145c;

    /* renamed from: d */
    public static int f6146d;

    /* renamed from: i */
    public static final AtomicReference<a> f6150i;

    /* renamed from: j */
    public static final c f6151j;

    /* renamed from: a */
    public static final n0 f6143a = new n0(0);

    /* renamed from: b */
    public static final Object f6144b = new Object();
    public static final d e = new d(0);

    /* renamed from: f */
    public static final j<k> f6147f = new j<>();

    /* renamed from: g */
    public static final ArrayList f6148g = new ArrayList();

    /* renamed from: h */
    public static final ArrayList f6149h = new ArrayList();

    /* renamed from: k */
    public static t f6152k = new t();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements l<e, g> {

        /* renamed from: g */
        public static final a f6153g = new a();

        public a() {
            super(1);
        }

        @Override // q5.l
        public final g k(e eVar) {
            h.f(eVar, "it");
            return g.f4141a;
        }
    }

    static {
        e eVar = e.f6133j;
        f6145c = eVar;
        f6146d = 1;
        int i7 = f6146d;
        f6146d = i7 + 1;
        a aVar = new a(i7, eVar);
        f6145c = f6145c.c(aVar.f6127b);
        AtomicReference<a> atomicReference = new AtomicReference<>(aVar);
        f6150i = atomicReference;
        a aVar2 = atomicReference.get();
        h.e(aVar2, "currentGlobalSnapshot.get()");
        f6151j = aVar2;
    }

    public static final <T> T a(l<? super e, ? extends T> lVar) {
        a aVar;
        b<k> bVar;
        T t5;
        ArrayList c02;
        c cVar = f6151j;
        h.d(cVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        a aVar2 = (a) cVar;
        Object obj = f6144b;
        synchronized (obj) {
            aVar = f6150i.get();
            h.e(aVar, "currentGlobalSnapshot.get()");
            bVar = aVar.f6125g;
            if (bVar != null) {
                ((AtomicInteger) f6152k.f4019f).addAndGet(1);
            }
            t5 = (T) n(aVar, lVar);
        }
        if (bVar != null) {
            try {
                synchronized (obj) {
                    c02 = n.c0(f6148g);
                }
                int size = c02.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((p) c02.get(i7)).i(bVar, aVar);
                }
            } finally {
                ((AtomicInteger) f6152k.f4019f).addAndGet(-1);
            }
        }
        synchronized (f6144b) {
            b();
            if (bVar != null) {
                Object[] objArr = bVar.f5594g;
                int i8 = bVar.f5593f;
                for (int i9 = 0; i9 < i8; i9++) {
                    Object obj2 = objArr[i9];
                    h.d(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    i((k) obj2);
                }
                g gVar = g.f4141a;
            }
        }
        return t5;
    }

    public static final void b() {
        j<k> jVar = f6147f;
        int i7 = jVar.f6155a;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            k kVar = null;
            if (i8 >= i7) {
                break;
            }
            q0<k> q0Var = jVar.f6157c[i8];
            if (q0Var != null) {
                kVar = q0Var.get();
            }
            if (kVar != null && !(!h(kVar))) {
                if (i9 != i8) {
                    jVar.f6157c[i9] = q0Var;
                    int[] iArr = jVar.f6156b;
                    iArr[i9] = iArr[i8];
                }
                i9++;
            }
            i8++;
        }
        for (int i10 = i9; i10 < i7; i10++) {
            jVar.f6157c[i10] = null;
            jVar.f6156b[i10] = 0;
        }
        if (i9 != i7) {
            jVar.f6155a = i9;
        }
    }

    public static final <T extends l> T c(T t5) {
        T t6;
        h.f(t5, "r");
        c d7 = d();
        T t7 = (T) k(t5, d7.b(), d7.c());
        if (t7 != null) {
            return t7;
        }
        synchronized (f6144b) {
            c d8 = d();
            t6 = (T) k(t5, d8.b(), d8.c());
        }
        if (t6 != null) {
            return t6;
        }
        j();
        throw null;
    }

    public static final c d() {
        c cVar = (c) f6143a.b();
        if (cVar != null) {
            return cVar;
        }
        a aVar = f6150i.get();
        h.e(aVar, "currentGlobalSnapshot.get()");
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
        if (r5 == false) goto L_0x0056;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends v.l> T e(T r12, v.k r13) {
        /*
            java.lang.String r0 = "<this>"
            r5.h.f(r12, r0)
            java.lang.String r0 = "state"
            r5.h.f(r13, r0)
            v.l r0 = r13.b()
            v.d r1 = v.f.e
            int r2 = v.f.f6146d
            int r3 = r1.f6129a
            r4 = 0
            if (r3 <= 0) goto L_0x001d
            java.lang.Object r1 = r1.f6131c
            int[] r1 = (int[]) r1
            r2 = r1[r4]
        L_0x001d:
            int r2 = r2 + -1
            r1 = 0
            r3 = r1
        L_0x0021:
            if (r0 == 0) goto L_0x0069
            int r5 = r0.f6158a
            if (r5 != 0) goto L_0x0028
            goto L_0x0062
        L_0x0028:
            r6 = 1
            if (r5 == 0) goto L_0x0055
            if (r5 > r2) goto L_0x0055
            int r5 = r5 + 0
            r7 = 1
            r9 = 64
            r10 = 0
            if (r5 < 0) goto L_0x0043
            if (r5 >= r9) goto L_0x0043
            long r7 = r7 << r5
            long r7 = r7 & r10
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0041
        L_0x003f:
            r5 = r6
            goto L_0x0052
        L_0x0041:
            r5 = r4
            goto L_0x0052
        L_0x0043:
            if (r5 < r9) goto L_0x0041
            r9 = 128(0x80, float:1.794E-43)
            if (r5 >= r9) goto L_0x0041
            int r5 = r5 + -64
            long r7 = r7 << r5
            long r7 = r7 & r10
            int r5 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0041
            goto L_0x003f
        L_0x0052:
            if (r5 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r6 = r4
        L_0x0056:
            if (r6 == 0) goto L_0x0066
            if (r3 != 0) goto L_0x005c
            r3 = r0
            goto L_0x0066
        L_0x005c:
            int r1 = r0.f6158a
            int r2 = r3.f6158a
            if (r1 >= r2) goto L_0x0064
        L_0x0062:
            r1 = r0
            goto L_0x0069
        L_0x0064:
            r1 = r3
            goto L_0x0069
        L_0x0066:
            v.l r0 = r0.f6159b
            goto L_0x0021
        L_0x0069:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == 0) goto L_0x0071
            r1.f6158a = r0
            goto L_0x0080
        L_0x0071:
            v.l r1 = r12.b()
            r1.f6158a = r0
            v.l r12 = r13.b()
            r1.f6159b = r12
            r13.m(r1)
        L_0x0080:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v.f.e(v.l, v.k):v.l");
    }

    public static final void f(c cVar, k kVar) {
        h.f(kVar, "state");
        cVar.i(cVar.f() + 1);
        l<Object, g> g2 = cVar.g();
        if (g2 != null) {
            g2.k(kVar);
        }
    }

    public static final <T extends l> T g(T t5, k kVar, c cVar, T t6) {
        T t7;
        h.f(t5, "<this>");
        h.f(kVar, "state");
        if (cVar.e()) {
            cVar.h(kVar);
        }
        int b2 = cVar.b();
        if (t6.f6158a == b2) {
            return t6;
        }
        synchronized (f6144b) {
            t7 = (T) e(t5, kVar);
        }
        t7.f6158a = b2;
        cVar.h(kVar);
        return t7;
    }

    public static final boolean h(k kVar) {
        d dVar = e;
        int i7 = f6146d;
        if (dVar.f6129a > 0) {
            i7 = ((int[]) dVar.f6131c)[0];
        }
        l lVar = null;
        l lVar2 = null;
        int i8 = 0;
        for (l b2 = kVar.b(); b2 != null; b2 = b2.f6159b) {
            int i9 = b2.f6158a;
            if (i9 != 0) {
                if (i9 >= i7) {
                    i8++;
                } else if (lVar == null) {
                    i8++;
                    lVar = b2;
                } else {
                    if (i9 < lVar.f6158a) {
                        lVar = lVar;
                        lVar = b2;
                    } else {
                        lVar = b2;
                    }
                    if (lVar2 == null) {
                        lVar2 = kVar.b();
                        l lVar3 = lVar2;
                        while (true) {
                            if (lVar2 == null) {
                                lVar2 = lVar3;
                                break;
                            }
                            int i10 = lVar2.f6158a;
                            if (i10 >= i7) {
                                break;
                            }
                            if (lVar3.f6158a < i10) {
                                lVar3 = lVar2;
                            }
                            lVar2 = lVar2.f6159b;
                        }
                    }
                    lVar.f6158a = 0;
                    lVar.a(lVar2);
                }
            }
        }
        return i8 > 1;
    }

    public static final void i(k kVar) {
        if (h(kVar)) {
            j<k> jVar = f6147f;
            jVar.getClass();
            int i7 = jVar.f6155a;
            int identityHashCode = System.identityHashCode(kVar);
            int i8 = -1;
            if (i7 > 0) {
                int i9 = jVar.f6155a - 1;
                int i10 = 0;
                while (true) {
                    if (i10 <= i9) {
                        int i11 = (i10 + i9) >>> 1;
                        int i12 = jVar.f6156b[i11];
                        if (i12 >= identityHashCode) {
                            if (i12 <= identityHashCode) {
                                q0<k> q0Var = jVar.f6157c[i11];
                                if (kVar != (q0Var != null ? q0Var.get() : null)) {
                                    i8 = i11 - 1;
                                    while (-1 < i8 && jVar.f6156b[i8] == identityHashCode) {
                                        q0<k> q0Var2 = jVar.f6157c[i8];
                                        if ((q0Var2 != null ? q0Var2.get() : null) == kVar) {
                                            break;
                                        }
                                        i8--;
                                    }
                                    i8 = i11 + 1;
                                    int i13 = jVar.f6155a;
                                    while (true) {
                                        if (i8 >= i13) {
                                            i8 = -(jVar.f6155a + 1);
                                            break;
                                        } else if (jVar.f6156b[i8] != identityHashCode) {
                                            i8 = -(i8 + 1);
                                            break;
                                        } else {
                                            q0<k> q0Var3 = jVar.f6157c[i8];
                                            if ((q0Var3 != null ? q0Var3.get() : null) == kVar) {
                                                break;
                                            }
                                            i8++;
                                        }
                                    }
                                } else {
                                    i8 = i11;
                                }
                            } else {
                                i9 = i11 - 1;
                            }
                        } else {
                            i10 = i11 + 1;
                        }
                    } else {
                        i8 = -(i10 + 1);
                        break;
                    }
                }
                if (i8 >= 0) {
                    return;
                }
            }
            int i14 = -(i8 + 1);
            q0<k>[] q0VarArr = jVar.f6157c;
            int length = q0VarArr.length;
            if (i7 == length) {
                int i15 = length * 2;
                q0<T>[] q0VarArr2 = new q0[i15];
                int[] iArr = new int[i15];
                int i16 = i14 + 1;
                g5.i.W(q0VarArr, q0VarArr2, i16, i14, i7);
                g5.i.Y(jVar.f6157c, q0VarArr2, 0, i14, 6);
                g5.i.V(i16, i14, i7, jVar.f6156b, iArr);
                g5.i.X(jVar.f6156b, iArr, i14, 6);
                jVar.f6157c = q0VarArr2;
                jVar.f6156b = iArr;
            } else {
                int i17 = i14 + 1;
                g5.i.W(q0VarArr, q0VarArr, i17, i14, i7);
                int[] iArr2 = jVar.f6156b;
                g5.i.V(i17, i14, i7, iArr2, iArr2);
            }
            jVar.f6157c[i14] = new q0<>(kVar);
            jVar.f6156b[i14] = identityHashCode;
            jVar.f6155a++;
        }
    }

    public static final void j() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    public static final <T extends l> T k(T t5, int i7, e eVar) {
        T t6 = null;
        while (t5 != null) {
            int i8 = t5.f6158a;
            if ((i8 != 0 && i8 <= i7 && !eVar.b(i8)) && (t6 == null || t6.f6158a < t5.f6158a)) {
                t6 = t5;
            }
            t5 = (T) t5.f6159b;
        }
        if (t6 != null) {
            return t6;
        }
        return null;
    }

    public static final <T extends l> T l(T t5, k kVar) {
        T t6;
        h.f(t5, "<this>");
        h.f(kVar, "state");
        c d7 = d();
        l<Object, g> d8 = d7.d();
        if (d8 != null) {
            d8.k(kVar);
        }
        T t7 = (T) k(t5, d7.b(), d7.c());
        if (t7 != null) {
            return t7;
        }
        synchronized (f6144b) {
            c d9 = d();
            l b2 = kVar.b();
            h.d(b2, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t6 = (T) k(b2, d9.b(), d9.c());
            if (t6 == null) {
                j();
                throw null;
            }
        }
        return t6;
    }

    public static final void m(int i7) {
        int i8;
        d dVar = e;
        int i9 = ((int[]) dVar.e)[i7];
        dVar.b(i9, dVar.f6129a - 1);
        dVar.f6129a--;
        int[] iArr = (int[]) dVar.f6131c;
        int i10 = iArr[i9];
        int i11 = i9;
        while (i11 > 0) {
            int i12 = ((i11 + 1) >> 1) - 1;
            if (iArr[i12] <= i10) {
                break;
            }
            dVar.b(i12, i11);
            i11 = i12;
        }
        int[] iArr2 = (int[]) dVar.f6131c;
        int i13 = dVar.f6129a >> 1;
        while (i9 < i13) {
            int i14 = (i9 + 1) << 1;
            int i15 = i14 - 1;
            if (i14 < dVar.f6129a && (i8 = iArr2[i14]) < iArr2[i15]) {
                if (i8 >= iArr2[i9]) {
                    break;
                }
                dVar.b(i14, i9);
                i9 = i14;
            } else if (iArr2[i15] >= iArr2[i9]) {
                break;
            } else {
                dVar.b(i15, i9);
                i9 = i15;
            }
        }
        ((int[]) dVar.e)[i7] = dVar.f6130b;
        dVar.f6130b = i7;
    }

    public static final <T> T n(c cVar, l<? super e, ? extends T> lVar) {
        T t5 = (T) lVar.k(f6145c.a(cVar.b()));
        synchronized (f6144b) {
            int i7 = f6146d;
            f6146d = i7 + 1;
            e a7 = f6145c.a(cVar.b());
            f6145c = a7;
            f6150i.set(new a(i7, a7));
            cVar.a();
            f6145c = f6145c.c(i7);
            g gVar = g.f4141a;
        }
        return t5;
    }
}
