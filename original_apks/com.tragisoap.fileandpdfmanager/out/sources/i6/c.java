package i6;

import java.io.IOException;
import java.io.InterruptedIOException;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class c extends w {

    /* renamed from: h  reason: collision with root package name */
    public static c f4493h;
    public boolean e;

    /* renamed from: f  reason: collision with root package name */
    public c f4494f;

    /* renamed from: g  reason: collision with root package name */
    public long f4495g;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    c h7 = c.h();
                    if (h7 != null) {
                        h7.n();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static c h() {
        synchronized (c.class) {
            c cVar = f4493h.f4494f;
            if (cVar == null) {
                c.class.wait();
            } else {
                long nanoTime = cVar.f4495g - System.nanoTime();
                if (nanoTime > 0) {
                    long j7 = nanoTime / 1000000;
                    c.class.wait(j7, (int) (nanoTime - (1000000 * j7)));
                } else {
                    f4493h.f4494f = cVar.f4494f;
                    cVar.f4494f = null;
                    return cVar;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0065 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {, blocks: (B:10:0x0017, B:12:0x001b, B:13:0x002a, B:16:0x0032, B:18:0x003e, B:20:0x0044, B:21:0x004a, B:22:0x004f, B:24:0x0053, B:28:0x005d, B:30:0x0065, B:33:0x006a, B:34:0x006f), top: B:39:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            r9 = this;
            boolean r0 = r9.e
            if (r0 != 0) goto L_0x0073
            long r0 = r9.f4540c
            boolean r2 = r9.f4538a
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0011
            if (r2 != 0) goto L_0x0011
            return
        L_0x0011:
            r4 = 1
            r9.e = r4
            java.lang.Class<i6.c> r4 = i6.c.class
            monitor-enter(r4)
            i6.c r5 = i6.c.f4493h     // Catch: all -> 0x0070
            if (r5 != 0) goto L_0x002a
            i6.c r5 = new i6.c     // Catch: all -> 0x0070
            r5.<init>()     // Catch: all -> 0x0070
            i6.c.f4493h = r5     // Catch: all -> 0x0070
            i6.c$a r5 = new i6.c$a     // Catch: all -> 0x0070
            r5.<init>()     // Catch: all -> 0x0070
            r5.start()     // Catch: all -> 0x0070
        L_0x002a:
            long r5 = java.lang.System.nanoTime()     // Catch: all -> 0x0070
            if (r3 == 0) goto L_0x003c
            if (r2 == 0) goto L_0x003c
            long r2 = r9.c()     // Catch: all -> 0x0070
            long r2 = r2 - r5
            long r0 = java.lang.Math.min(r0, r2)     // Catch: all -> 0x0070
            goto L_0x003e
        L_0x003c:
            if (r3 == 0) goto L_0x0042
        L_0x003e:
            long r0 = r0 + r5
            r9.f4495g = r0     // Catch: all -> 0x0070
            goto L_0x004a
        L_0x0042:
            if (r2 == 0) goto L_0x006a
            long r0 = r9.c()     // Catch: all -> 0x0070
            r9.f4495g = r0     // Catch: all -> 0x0070
        L_0x004a:
            long r0 = r9.f4495g     // Catch: all -> 0x0070
            long r0 = r0 - r5
            i6.c r2 = i6.c.f4493h     // Catch: all -> 0x0070
        L_0x004f:
            i6.c r3 = r2.f4494f     // Catch: all -> 0x0070
            if (r3 == 0) goto L_0x005d
            long r7 = r3.f4495g     // Catch: all -> 0x0070
            long r7 = r7 - r5
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r3
            goto L_0x004f
        L_0x005d:
            r9.f4494f = r3     // Catch: all -> 0x0070
            r2.f4494f = r9     // Catch: all -> 0x0070
            i6.c r9 = i6.c.f4493h     // Catch: all -> 0x0070
            if (r2 != r9) goto L_0x0068
            r4.notify()     // Catch: all -> 0x0070
        L_0x0068:
            monitor-exit(r4)
            return
        L_0x006a:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch: all -> 0x0070
            r9.<init>()     // Catch: all -> 0x0070
            throw r9     // Catch: all -> 0x0070
        L_0x0070:
            r9 = move-exception
            monitor-exit(r4)
            throw r9
        L_0x0073:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unbalanced enter/exit"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.c.i():void");
    }

    public final IOException j(IOException iOException) {
        return !l() ? iOException : m(iOException);
    }

    public final void k(boolean z6) {
        if (l() && z6) {
            throw m(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        r2.f4494f = r4.f4494f;
        r4.f4494f = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l() {
        /*
            r4 = this;
            boolean r0 = r4.e
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r4.e = r1
            java.lang.Class<i6.c> r0 = i6.c.class
            monitor-enter(r0)
            i6.c r2 = i6.c.f4493h     // Catch: all -> 0x0020
        L_0x000d:
            if (r2 == 0) goto L_0x001d
            i6.c r3 = r2.f4494f     // Catch: all -> 0x0020
            if (r3 != r4) goto L_0x001b
            i6.c r3 = r4.f4494f     // Catch: all -> 0x0020
            r2.f4494f = r3     // Catch: all -> 0x0020
            r2 = 0
            r4.f4494f = r2     // Catch: all -> 0x0020
            goto L_0x001e
        L_0x001b:
            r2 = r3
            goto L_0x000d
        L_0x001d:
            r1 = 1
        L_0x001e:
            monitor-exit(r0)
            return r1
        L_0x0020:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.c.l():boolean");
    }

    public IOException m(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void n() {
    }
}
