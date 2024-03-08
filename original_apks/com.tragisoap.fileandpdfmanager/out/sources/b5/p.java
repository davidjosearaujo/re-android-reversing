package b5;

import java.io.IOException;
import y4.a;
import y4.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p {

    /* renamed from: a */
    public final a f2445a;

    /* renamed from: b */
    public final h f2446b;

    /* renamed from: c */
    public o f2447c;

    /* renamed from: d */
    public c5.a f2448d;
    public boolean e;

    /* renamed from: f */
    public i f2449f;

    public p(h hVar, a aVar) {
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

    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[Catch: all -> 0x0009, TryCatch #0 {all -> 0x0009, blocks: (B:6:0x0006, B:11:0x000f, B:12:0x0011, B:15:0x0017, B:16:0x0019, B:18:0x001d, B:20:0x0021, B:22:0x0025, B:24:0x002f, B:26:0x003d, B:28:0x0048, B:29:0x004a, B:31:0x0052, B:33:0x006a, B:36:0x006f, B:37:0x0074, B:39:0x007b, B:41:0x007f, B:42:0x0083, B:43:0x0086, B:44:0x008b, B:45:0x008c), top: B:51:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            y4.h r0 = r5.f2446b
            monitor-enter(r0)
            r1 = 0
            if (r8 == 0) goto L_0x000c
            r5.f2449f = r1     // Catch: all -> 0x0009
            goto L_0x000c
        L_0x0009:
            r5 = move-exception
            goto L_0x0095
        L_0x000c:
            r8 = 1
            if (r7 == 0) goto L_0x0011
            r5.e = r8     // Catch: all -> 0x0009
        L_0x0011:
            c5.a r7 = r5.f2448d     // Catch: all -> 0x0009
            if (r7 == 0) goto L_0x008c
            if (r6 == 0) goto L_0x0019
            r7.f2575k = r8     // Catch: all -> 0x0009
        L_0x0019:
            b5.i r6 = r5.f2449f     // Catch: all -> 0x0009
            if (r6 != 0) goto L_0x008c
            boolean r6 = r5.e     // Catch: all -> 0x0009
            if (r6 != 0) goto L_0x0025
            boolean r6 = r7.f2575k     // Catch: all -> 0x0009
            if (r6 == 0) goto L_0x008c
        L_0x0025:
            java.util.ArrayList r6 = r7.f2574j     // Catch: all -> 0x0009
            int r6 = r6.size()     // Catch: all -> 0x0009
            r2 = 0
            r3 = r2
        L_0x002d:
            if (r3 >= r6) goto L_0x0086
            java.util.ArrayList r4 = r7.f2574j     // Catch: all -> 0x0009
            java.lang.Object r4 = r4.get(r3)     // Catch: all -> 0x0009
            java.lang.ref.Reference r4 = (java.lang.ref.Reference) r4     // Catch: all -> 0x0009
            java.lang.Object r4 = r4.get()     // Catch: all -> 0x0009
            if (r4 != r5) goto L_0x0083
            java.util.ArrayList r6 = r7.f2574j     // Catch: all -> 0x0009
            r6.remove(r3)     // Catch: all -> 0x0009
            c5.a r6 = r5.f2448d     // Catch: all -> 0x0009
            int r7 = r6.f2571g     // Catch: all -> 0x0009
            if (r7 <= 0) goto L_0x004a
            r5.f2447c = r1     // Catch: all -> 0x0009
        L_0x004a:
            java.util.ArrayList r6 = r6.f2574j     // Catch: all -> 0x0009
            boolean r6 = r6.isEmpty()     // Catch: all -> 0x0009
            if (r6 == 0) goto L_0x007e
            c5.a r6 = r5.f2448d     // Catch: all -> 0x0009
            long r3 = java.lang.System.nanoTime()     // Catch: all -> 0x0009
            r6.f2576l = r3     // Catch: all -> 0x0009
            y4.p$a r6 = z4.b.f6935b     // Catch: all -> 0x0009
            y4.h r7 = r5.f2446b     // Catch: all -> 0x0009
            c5.a r3 = r5.f2448d     // Catch: all -> 0x0009
            r6.getClass()     // Catch: all -> 0x0009
            r7.getClass()     // Catch: all -> 0x0009
            boolean r6 = r3.f2575k     // Catch: all -> 0x0009
            if (r6 != 0) goto L_0x0074
            int r6 = r7.f6725b     // Catch: all -> 0x0009
            if (r6 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            r7.notifyAll()     // Catch: all -> 0x0009
            r8 = r2
            goto L_0x0079
        L_0x0074:
            java.util.ArrayDeque r6 = r7.e     // Catch: all -> 0x0009
            r6.remove(r3)     // Catch: all -> 0x0009
        L_0x0079:
            if (r8 == 0) goto L_0x007e
            c5.a r6 = r5.f2448d     // Catch: all -> 0x0009
            goto L_0x007f
        L_0x007e:
            r6 = r1
        L_0x007f:
            r5.f2448d = r1     // Catch: all -> 0x0009
            r1 = r6
            goto L_0x008c
        L_0x0083:
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0086:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: all -> 0x0009
            r5.<init>()     // Catch: all -> 0x0009
            throw r5     // Catch: all -> 0x0009
        L_0x008c:
            monitor-exit(r0)     // Catch: all -> 0x0009
            if (r1 == 0) goto L_0x0094
            java.net.Socket r5 = r1.f2568c
            z4.h.c(r5)
        L_0x0094:
            return
        L_0x0095:
            monitor-exit(r0)     // Catch: all -> 0x0009
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.p.b(boolean, boolean, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:131|41|(7:46|48|49|135|50|156|155)|47|48|49|135|50|156|155|39) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e8, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
        z4.h.c(r2.f2568c);
        z4.h.c(r2.f2567b);
        r2.f2568c = null;
        r2.f2567b = null;
        r2.f2572h = null;
        r2.f2573i = null;
        r2.f2569d = null;
        r2.e = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0107, code lost:
        if (r9 == null) goto L_0x0109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0109, code lost:
        r9 = new b5.n(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010f, code lost:
        r13 = r9.f2437f;
        r14 = b5.n.f2436g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0113, code lost:
        if (r14 != null) goto L_0x0115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
        r14.invoke(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x011c, code lost:
        r9.f2437f = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011e, code lost:
        if (r20 != false) goto L_0x0120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0120, code lost:
        r5.f6933d = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0124, code lost:
        if (r5.f6932c != false) goto L_0x0127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014a, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014c, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014d, code lost:
        if (r0 != false) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0151, code lost:
        throw r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c2 A[LOOP:0: B:3:0x0002->B:110:0x01c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c5.a c(int r17, int r18, int r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
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
