package i6;

import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public class c extends w {

    /* renamed from: h */
    public static c f4493h;
    public boolean e;

    /* renamed from: f */
    public c f4494f;

    /* renamed from: g */
    public long f4495g;

    /* loaded from: classes.dex */
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
                if (nanoTime <= 0) {
                    f4493h.f4494f = cVar.f4494f;
                    cVar.f4494f = null;
                    return cVar;
                }
                long j5 = nanoTime / 1000000;
                c.class.wait(j5, (int) (nanoTime - (1000000 * j5)));
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0065 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {, blocks: (B:139:0x0017, B:141:0x001b, B:142:0x002a, B:145:0x0032, B:147:0x003e, B:150:0x004a, B:151:0x004f, B:153:0x0053, B:157:0x005d, B:159:0x0065, B:149:0x0044, B:162:0x006a, B:163:0x006f), top: B:169:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            r9 = this;
            boolean r0 = r9.e
            if (r0 != 0) goto L73
            long r0 = r9.f4540c
            boolean r2 = r9.f4538a
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L11
            if (r2 != 0) goto L11
            return
        L11:
            r4 = 1
            r9.e = r4
            java.lang.Class<i6.c> r4 = i6.c.class
            monitor-enter(r4)
            i6.c r5 = i6.c.f4493h     // Catch: java.lang.Throwable -> L70
            if (r5 != 0) goto L2a
            i6.c r5 = new i6.c     // Catch: java.lang.Throwable -> L70
            r5.<init>()     // Catch: java.lang.Throwable -> L70
            i6.c.f4493h = r5     // Catch: java.lang.Throwable -> L70
            i6.c$a r5 = new i6.c$a     // Catch: java.lang.Throwable -> L70
            r5.<init>()     // Catch: java.lang.Throwable -> L70
            r5.start()     // Catch: java.lang.Throwable -> L70
        L2a:
            long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L3c
            if (r2 == 0) goto L3c
            long r2 = r9.c()     // Catch: java.lang.Throwable -> L70
            long r2 = r2 - r5
            long r0 = java.lang.Math.min(r0, r2)     // Catch: java.lang.Throwable -> L70
            goto L3e
        L3c:
            if (r3 == 0) goto L42
        L3e:
            long r0 = r0 + r5
            r9.f4495g = r0     // Catch: java.lang.Throwable -> L70
            goto L4a
        L42:
            if (r2 == 0) goto L6a
            long r0 = r9.c()     // Catch: java.lang.Throwable -> L70
            r9.f4495g = r0     // Catch: java.lang.Throwable -> L70
        L4a:
            long r0 = r9.f4495g     // Catch: java.lang.Throwable -> L70
            long r0 = r0 - r5
            i6.c r2 = i6.c.f4493h     // Catch: java.lang.Throwable -> L70
        L4f:
            i6.c r3 = r2.f4494f     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L5d
            long r7 = r3.f4495g     // Catch: java.lang.Throwable -> L70
            long r7 = r7 - r5
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5b
            goto L5d
        L5b:
            r2 = r3
            goto L4f
        L5d:
            r9.f4494f = r3     // Catch: java.lang.Throwable -> L70
            r2.f4494f = r9     // Catch: java.lang.Throwable -> L70
            i6.c r9 = i6.c.f4493h     // Catch: java.lang.Throwable -> L70
            if (r2 != r9) goto L68
            r4.notify()     // Catch: java.lang.Throwable -> L70
        L68:
            monitor-exit(r4)
            return
        L6a:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L70
            r9.<init>()     // Catch: java.lang.Throwable -> L70
            throw r9     // Catch: java.lang.Throwable -> L70
        L70:
            r9 = move-exception
            monitor-exit(r4)
            throw r9
        L73:
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

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0013, code lost:
        r2.f4494f = r4.f4494f;
        r4.f4494f = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean l() {
        /*
            r4 = this;
            boolean r0 = r4.e
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            r4.e = r1
            java.lang.Class<i6.c> r0 = i6.c.class
            monitor-enter(r0)
            i6.c r2 = i6.c.f4493h     // Catch: java.lang.Throwable -> L20
        Ld:
            if (r2 == 0) goto L1d
            i6.c r3 = r2.f4494f     // Catch: java.lang.Throwable -> L20
            if (r3 != r4) goto L1b
            i6.c r3 = r4.f4494f     // Catch: java.lang.Throwable -> L20
            r2.f4494f = r3     // Catch: java.lang.Throwable -> L20
            r2 = 0
            r4.f4494f = r2     // Catch: java.lang.Throwable -> L20
            goto L1e
        L1b:
            r2 = r3
            goto Ld
        L1d:
            r1 = 1
        L1e:
            monitor-exit(r0)
            return r1
        L20:
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
