package a6;

import a0.b;
import f5.c;
import f5.g;
import f6.r;
import f6.v;
import i5.d;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n1<T> extends r<T> {

    /* renamed from: j */
    public final ThreadLocal<c<f, Object>> f322j;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n1(i5.d r3, i5.f r4) {
        /*
            r2 = this;
            a6.o1 r0 = a6.o1.f325f
            i5.f$b r1 = r4.e(r0)
            if (r1 != 0) goto L_0x000d
            i5.f r0 = r4.s(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r4
        L_0x000e:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f322j = r0
            i5.f r3 = r3.a()
            i5.e$a r0 = i5.e.a.f4486f
            i5.f$b r3 = r3.e(r0)
            boolean r3 = r3 instanceof a6.u
            if (r3 != 0) goto L_0x0031
            r3 = 0
            java.lang.Object r3 = f6.v.c(r4, r3)
            f6.v.a(r4, r3)
            r2.n0(r4, r3)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n1.<init>(i5.d, i5.f):void");
    }

    @Override // f6.r, a6.a
    public final void i0(Object obj) {
        if (this.threadLocalIsSet) {
            c<f, Object> cVar = this.f322j.get();
            if (cVar != null) {
                v.a(cVar.f4135f, cVar.f4136g);
            }
            this.f322j.remove();
        }
        Object u6 = b.u(obj);
        d<T> dVar = this.f4177i;
        f a7 = dVar.a();
        n1<?> n1Var = null;
        Object c7 = v.c(a7, null);
        if (c7 != v.f4182a) {
            n1Var = s.b(dVar, a7, c7);
        }
        try {
            this.f4177i.o(u6);
            g gVar = g.f4141a;
        } finally {
            if (n1Var == null || n1Var.m0()) {
                v.a(a7, c7);
            }
        }
    }

    public final boolean m0() {
        boolean z6 = true;
        if (!this.threadLocalIsSet || this.f322j.get() != null) {
            z6 = false;
        }
        this.f322j.remove();
        return !z6;
    }

    public final void n0(f fVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f322j.set(new c<>(fVar, obj));
    }
}
