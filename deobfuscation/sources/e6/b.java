package e6;

import e6.c;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class b<S extends c<?>> {

    /* renamed from: f */
    public S[] f3870f;

    /* renamed from: g */
    public int f3871g;

    /* renamed from: h */
    public int f3872h;

    /* renamed from: i */
    public t f3873i;

    public final S d() {
        S s;
        t tVar;
        synchronized (this) {
            S[] sArr = this.f3870f;
            if (sArr == null) {
                sArr = (S[]) f();
                this.f3870f = sArr;
            } else if (this.f3871g >= sArr.length) {
                Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                r5.h.e(copyOf, "copyOf(this, newSize)");
                this.f3870f = (S[]) ((c[]) copyOf);
                sArr = (S[]) ((c[]) copyOf);
            }
            int i7 = this.f3872h;
            do {
                s = sArr[i7];
                if (s == null) {
                    s = e();
                    sArr[i7] = s;
                }
                i7++;
                if (i7 >= sArr.length) {
                    i7 = 0;
                }
                r5.h.d(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s.a(this));
            this.f3872h = i7;
            this.f3871g++;
            tVar = this.f3873i;
        }
        if (tVar != null) {
            synchronized (tVar) {
                Object[] objArr = tVar.m;
                r5.h.c(objArr);
                tVar.l(Integer.valueOf(((Number) objArr[((int) ((tVar.f3736n + ((int) ((tVar.q() + tVar.f3738p) - tVar.f3736n))) - 1)) & (objArr.length - 1)]).intValue() + 1));
            }
        }
        return s;
    }

    public abstract S e();

    public abstract c[] f();

    public final void g(S s) {
        t tVar;
        int i7;
        i5.d[] b2;
        Object[] objArr;
        synchronized (this) {
            int i8 = this.f3871g - 1;
            this.f3871g = i8;
            tVar = this.f3873i;
            if (i8 == 0) {
                this.f3872h = 0;
            }
            r5.h.d(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            b2 = s.b(this);
        }
        for (i5.d dVar : b2) {
            if (dVar != null) {
                dVar.o(f5.g.f4141a);
            }
        }
        if (tVar != null) {
            synchronized (tVar) {
                r5.h.c(tVar.m);
                tVar.l(Integer.valueOf(((Number) objArr[((int) ((tVar.f3736n + ((int) ((tVar.q() + tVar.f3738p) - tVar.f3736n))) - 1)) & (objArr.length - 1)]).intValue() - 1));
            }
        }
    }

    public final t n() {
        t tVar;
        synchronized (this) {
            tVar = this.f3873i;
            if (tVar == null) {
                tVar = new t(this.f3871g);
                this.f3873i = tVar;
            }
        }
        return tVar;
    }
}