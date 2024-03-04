package b5;

import java.io.IOException;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a */
    public final y4.a f2445a;

    /* renamed from: b */
    public final y4.h f2446b;

    /* renamed from: c */
    public o f2447c;

    /* renamed from: d */
    public c5.a f2448d;
    public boolean e;

    /* renamed from: f */
    public i f2449f;

    public p(y4.h hVar, y4.a aVar) {
        this.f2446b = hVar;
        this.f2445a = aVar;
    }

    public final void a(IOException iOException) {
        synchronized (this.f2446b) {
            o oVar = this.f2447c;
            if (oVar != null) {
                c5.a aVar = this.f2448d;
                if (aVar.f2571g == 0) {
                    oVar.a(aVar.f2566a, iOException);
                } else {
                    this.f2447c = null;
                }
            }
        }
        b(true, false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:204:0x007b A[Catch: all -> 0x0009, TryCatch #0 {all -> 0x0009, blocks: (B:171:0x0006, B:176:0x000f, B:177:0x0011, B:180:0x0017, B:181:0x0019, B:183:0x001d, B:185:0x0021, B:187:0x0025, B:189:0x002f, B:191:0x003d, B:193:0x0048, B:194:0x004a, B:196:0x0052, B:198:0x006a, B:201:0x006f, B:204:0x007b, B:206:0x007f, B:202:0x0074, B:207:0x0083, B:208:0x0086, B:209:0x008b, B:210:0x008c), top: B:216:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            y4.h r0 = r5.f2446b
            monitor-enter(r0)
            r1 = 0
            if (r8 == 0) goto Lc
            r5.f2449f = r1     // Catch: java.lang.Throwable -> L9
            goto Lc
        L9:
            r5 = move-exception
            goto L95
        Lc:
            r8 = 1
            if (r7 == 0) goto L11
            r5.e = r8     // Catch: java.lang.Throwable -> L9
        L11:
            c5.a r7 = r5.f2448d     // Catch: java.lang.Throwable -> L9
            if (r7 == 0) goto L8c
            if (r6 == 0) goto L19
            r7.f2575k = r8     // Catch: java.lang.Throwable -> L9
        L19:
            b5.i r6 = r5.f2449f     // Catch: java.lang.Throwable -> L9
            if (r6 != 0) goto L8c
            boolean r6 = r5.e     // Catch: java.lang.Throwable -> L9
            if (r6 != 0) goto L25
            boolean r6 = r7.f2575k     // Catch: java.lang.Throwable -> L9
            if (r6 == 0) goto L8c
        L25:
            java.util.ArrayList r6 = r7.f2574j     // Catch: java.lang.Throwable -> L9
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L9
            r2 = 0
            r3 = r2
        L2d:
            if (r3 >= r6) goto L86
            java.util.ArrayList r4 = r7.f2574j     // Catch: java.lang.Throwable -> L9
            java.lang.Object r4 = r4.get(r3)     // Catch: java.lang.Throwable -> L9
            java.lang.ref.Reference r4 = (java.lang.ref.Reference) r4     // Catch: java.lang.Throwable -> L9
            java.lang.Object r4 = r4.get()     // Catch: java.lang.Throwable -> L9
            if (r4 != r5) goto L83
            java.util.ArrayList r6 = r7.f2574j     // Catch: java.lang.Throwable -> L9
            r6.remove(r3)     // Catch: java.lang.Throwable -> L9
            c5.a r6 = r5.f2448d     // Catch: java.lang.Throwable -> L9
            int r7 = r6.f2571g     // Catch: java.lang.Throwable -> L9
            if (r7 <= 0) goto L4a
            r5.f2447c = r1     // Catch: java.lang.Throwable -> L9
        L4a:
            java.util.ArrayList r6 = r6.f2574j     // Catch: java.lang.Throwable -> L9
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> L9
            if (r6 == 0) goto L7e
            c5.a r6 = r5.f2448d     // Catch: java.lang.Throwable -> L9
            long r3 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L9
            r6.f2576l = r3     // Catch: java.lang.Throwable -> L9
            y4.p$a r6 = z4.b.f6935b     // Catch: java.lang.Throwable -> L9
            y4.h r7 = r5.f2446b     // Catch: java.lang.Throwable -> L9
            c5.a r3 = r5.f2448d     // Catch: java.lang.Throwable -> L9
            r6.getClass()     // Catch: java.lang.Throwable -> L9
            r7.getClass()     // Catch: java.lang.Throwable -> L9
            boolean r6 = r3.f2575k     // Catch: java.lang.Throwable -> L9
            if (r6 != 0) goto L74
            int r6 = r7.f6725b     // Catch: java.lang.Throwable -> L9
            if (r6 != 0) goto L6f
            goto L74
        L6f:
            r7.notifyAll()     // Catch: java.lang.Throwable -> L9
            r8 = r2
            goto L79
        L74:
            java.util.ArrayDeque r6 = r7.e     // Catch: java.lang.Throwable -> L9
            r6.remove(r3)     // Catch: java.lang.Throwable -> L9
        L79:
            if (r8 == 0) goto L7e
            c5.a r6 = r5.f2448d     // Catch: java.lang.Throwable -> L9
            goto L7f
        L7e:
            r6 = r1
        L7f:
            r5.f2448d = r1     // Catch: java.lang.Throwable -> L9
            r1 = r6
            goto L8c
        L83:
            int r3 = r3 + 1
            goto L2d
        L86:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L9
            r5.<init>()     // Catch: java.lang.Throwable -> L9
            throw r5     // Catch: java.lang.Throwable -> L9
        L8c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            if (r1 == 0) goto L94
            java.net.Socket r5 = r1.f2568c
            z4.h.c(r5)
        L94:
            return
        L95:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.p.b(boolean, boolean, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:81|82)|(7:87|88|89|90|91|93|94)|129|88|89|90|91|93|94|79) */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x00e8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x00f1, code lost:
        z4.h.c(r2.f2568c);
        z4.h.c(r2.f2567b);
        r2.f2568c = null;
        r2.f2567b = null;
        r2.f2572h = null;
        r2.f2573i = null;
        r2.f2569d = null;
        r2.e = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0107, code lost:
        if (r9 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0109, code lost:
        r9 = new b5.n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x010f, code lost:
        r13 = r9.f2437f;
        r14 = b5.n.f2436g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x0113, code lost:
        if (r14 != null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0115, code lost:
        r14.invoke(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x011c, code lost:
        r9.f2437f = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x011e, code lost:
        if (r20 != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x0120, code lost:
        r5.f6933d = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x0124, code lost:
        if (r5.f6932c != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x014a, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x014c, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x014d, code lost:
        if (r0 != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0151, code lost:
        throw r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:647:0x01c2 A[LOOP:0: B:525:0x0002->B:647:0x01c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:691:0x01c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c5.a c(int r17, int r18, int r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.p.c(int, int, int, boolean, boolean):c5.a");
    }

    public final void d(i iVar) {
        synchronized (this.f2446b) {
            if (iVar != null) {
                if (iVar == this.f2449f) {
                }
            }
            throw new IllegalStateException("expected " + this.f2449f + " but was " + iVar);
        }
        b(false, false, true);
    }

    public final String toString() {
        return this.f2445a.toString();
    }
}
