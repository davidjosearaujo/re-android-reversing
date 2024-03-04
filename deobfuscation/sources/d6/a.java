package d6;

/* loaded from: classes.dex */
public abstract class a<T> implements c {

    @k5.e(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: d6.a$a */
    /* loaded from: classes.dex */
    public static final class C0045a extends k5.c {

        /* renamed from: i */
        public e6.o f3649i;

        /* renamed from: j */
        public /* synthetic */ Object f3650j;

        /* renamed from: l */
        public int f3652l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0045a(i5.d dVar) {
            super(dVar);
            a.this = r1;
        }

        public final Object s(Object obj) {
            this.f3650j = obj;
            this.f3652l |= Integer.MIN_VALUE;
            return a.this.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(d6.d r5, i5.d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof d6.a.C0045a
            if (r0 == 0) goto L13
            r0 = r6
            d6.a$a r0 = (d6.a.C0045a) r0
            int r1 = r0.f3652l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3652l = r1
            goto L18
        L13:
            d6.a$a r0 = new d6.a$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3650j
            j5.a r1 = Kotlin_1.a.f4591f
            int r2 = r0.f3652l
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            e6.o r4 = r0.f3649i
            f5.e.b(r6)     // Catch: java.lang.Throwable -> L29
            goto L55
        L29:
            r5 = move-exception
            goto L5e
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            f5.e.b(r6)
            e6.o r6 = new e6.o
            i5.f r2 = r0.f4819g
            r5.h.c(r2)
            r6.<init>(r5, r2)
            r0.f3649i = r6     // Catch: java.lang.Throwable -> L5b
            r0.f3652l = r3     // Catch: java.lang.Throwable -> L5b
            d6.s r4 = (d6.s) r4     // Catch: java.lang.Throwable -> L5b
            q5.p<d6.d<? super T>, i5.d<? super f5.g>, java.lang.Object> r4 = r4.f3732f     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r4 = r4.i(r6, r0)     // Catch: java.lang.Throwable -> L5b
            if (r4 != r1) goto L4f
            goto L51
        L4f:
            f5.g r4 = f5.g.f4141a     // Catch: java.lang.Throwable -> L5b
        L51:
            if (r4 != r1) goto L54
            return r1
        L54:
            r4 = r6
        L55:
            r4.t()
            f5.g r4 = f5.g.f4141a
            return r4
        L5b:
            r4 = move-exception
            r5 = r4
            r4 = r6
        L5e:
            r4.t()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.a.a(d6.d, i5.d):java.lang.Object");
    }
}
