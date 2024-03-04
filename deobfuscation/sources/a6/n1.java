package a6;

/* loaded from: classes.dex */
public final class n1<T> extends f6.r<T> {

    /* renamed from: j */
    public final ThreadLocal<f5.c<i5.f, Object>> f322j;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n1(i5.d r3, i5.f r4) {
        /*
            r2 = this;
            a6.o1 r0 = a6.o1.f325f
            i5.f$b r1 = r4.e(r0)
            if (r1 != 0) goto Ld
            i5.f r0 = r4.s(r0)
            goto Le
        Ld:
            r0 = r4
        Le:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f322j = r0
            i5.f r3 = r3.a()
            i5.e$a r0 = i5.e.a.f4486f
            i5.f$b r3 = r3.e(r0)
            boolean r3 = r3 instanceof a6.u
            if (r3 != 0) goto L31
            r3 = 0
            java.lang.Object r3 = f6.v.c(r4, r3)
            f6.v.a(r4, r3)
            r2.n0(r4, r3)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n1.<init>(i5.d, i5.f):void");
    }

    @Override // f6.r, a6.a
    public final void i0(Object obj) {
        if (this.threadLocalIsSet) {
            f5.c<i5.f, Object> cVar = this.f322j.get();
            if (cVar != null) {
                f6.v.a(cVar.f4135f, cVar.f4136g);
            }
            this.f322j.remove();
        }
        Object u6 = a0.b.u(obj);
        i5.d<T> dVar = this.f4177i;
        i5.f a7 = dVar.a();
        Object c7 = f6.v.c(a7, null);
        n1<?> b2 = c7 != f6.v.f4182a ? s.b(dVar, a7, c7) : null;
        try {
            this.f4177i.o(u6);
            f5.g gVar = f5.g.f4141a;
        } finally {
            if (b2 == null || b2.m0()) {
                f6.v.a(a7, c7);
            }
        }
    }

    public final boolean m0() {
        boolean z6 = this.threadLocalIsSet && this.f322j.get() == null;
        this.f322j.remove();
        return !z6;
    }

    public final void n0(i5.f fVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f322j.set(new f5.c<>(fVar, obj));
    }
}
