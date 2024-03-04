package c6;

import c6.i;

/* loaded from: classes.dex */
public final class m<E> extends b<E> {

    /* renamed from: q */
    public final a f2620q;

    /* JADX WARN: Code restructure failed: missing block: B:158:0x00ab, code lost:
        if (r2 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public m(int r4, c6.a r5, q5.l<? super E, f5.g> r6) {
        /*
            r3 = this;
            r3.<init>(r4, r6)
            r3.f2620q = r5
            c6.a r3 = c6.a.SUSPEND
            r6 = 0
            r0 = 1
            if (r5 == r3) goto Ld
            r3 = r0
            goto Le
        Ld:
            r3 = r6
        Le:
            if (r3 != 0) goto Ld3
            java.lang.String r3 = "This implementation does not support suspension for senders, use "
            java.lang.StringBuilder r3 = androidx.activity.h.d(r3)
            java.lang.Class<c6.b> r4 = c6.b.class
            r5.d r4 = r5.t.a(r4)
            java.lang.Class<?> r4 = r4.f5919a
            java.lang.String r5 = "jClass"
            r5.h.f(r4, r5)
            boolean r5 = r4.isAnonymousClass()
            java.lang.String r1 = "Array"
            r2 = 0
            if (r5 != 0) goto Lc2
            boolean r5 = r4.isLocalClass()
            if (r5 == 0) goto L89
            java.lang.String r1 = r4.getSimpleName()
            java.lang.reflect.Method r5 = r4.getEnclosingMethod()
            r2 = 36
            if (r5 != 0) goto L71
            java.lang.reflect.Constructor r4 = r4.getEnclosingConstructor()
            if (r4 != 0) goto L5d
            r4 = 6
            int r4 = z5.i.b0(r1, r2, r6, r4)
            r5 = -1
            if (r4 != r5) goto L4e
            goto Lc3
        L4e:
            int r4 = r4 + r0
            int r5 = r1.length()
            java.lang.String r1 = r1.substring(r4, r5)
            java.lang.String r4 = "substring(...)"
            r5.h.e(r1, r4)
            goto Lc3
        L5d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.getName()
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            goto L84
        L71:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L84:
            java.lang.String r1 = z5.i.d0(r1, r4)
            goto Lc3
        L89:
            boolean r5 = r4.isArray()
            if (r5 == 0) goto Lae
            java.lang.Class r4 = r4.getComponentType()
            boolean r5 = r4.isPrimitive()
            if (r5 == 0) goto Lab
            java.util.LinkedHashMap r5 = r5.d.f5918c
            java.lang.String r4 = r4.getName()
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto Lab
            java.lang.String r2 = androidx.fragment.app.s0.h(r4, r1)
        Lab:
            if (r2 != 0) goto Lc2
            goto Lc3
        Lae:
            java.util.LinkedHashMap r5 = r5.d.f5918c
            java.lang.String r6 = r4.getName()
            java.lang.Object r5 = r5.get(r6)
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto Lc3
            java.lang.String r1 = r4.getSimpleName()
            goto Lc3
        Lc2:
            r1 = r2
        Lc3:
            java.lang.String r4 = " instead"
            java.lang.String r3 = androidx.activity.h.c(r3, r1, r4)
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        Ld3:
            if (r4 < r0) goto Ld6
            r6 = r0
        Ld6:
            if (r6 == 0) goto Ld9
            return
        Ld9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Buffered channel capacity must be at least 1, but "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = " was specified"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.m.<init>(int, c6.a, q5.l):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:291:0x00ec, code lost:
        return f5.g.f4141a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D(E r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.m.D(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // c6.b
    public final boolean s() {
        return this.f2620q == a.DROP_OLDEST;
    }

    @Override // c6.b, c6.r
    public final Object t(E e) {
        return D(e, false);
    }

    @Override // c6.b, c6.r
    public final Object u(E e, i5.d<? super f5.g> dVar) {
        f5.b h7;
        Object D = D(e, true);
        boolean z6 = D instanceof i.a;
        if (z6) {
            if (z6) {
                i.a aVar = (i.a) D;
            }
            q5.l lVar = this.f2590g;
            if (lVar == null || (h7 = a0.b.h(lVar, e, null)) == null) {
                throw o();
            }
            q2.a.c(h7, o());
            throw h7;
        }
        return f5.g.f4141a;
    }
}
