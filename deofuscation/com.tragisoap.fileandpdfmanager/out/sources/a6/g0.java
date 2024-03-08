package a6;

import g6.g;
import i5.d;
import java.util.concurrent.CancellationException;
import q2.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class g0<T> extends g {

    /* renamed from: h */
    public int f291h;

    public g0(int i7) {
        this.f291h = i7;
    }

    public void d(Object obj, CancellationException cancellationException) {
    }

    public abstract d<T> e();

    public Throwable f(Object obj) {
        o oVar = obj instanceof o ? (o) obj : null;
        if (oVar != null) {
            return oVar.f324a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T i(Object obj) {
        return obj;
    }

    public final void j(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.c(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            h.c(th);
            w.a(e().a(), new z("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }

    public abstract Object k();

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = (a6.u0) r6.e(a6.u0.b.f341f);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r12 = this;
            g6.h r0 = r12.f4316g
            i5.d r1 = r12.e()     // Catch: all -> 0x0098
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            r5.h.d(r1, r2)     // Catch: all -> 0x0098
            f6.f r1 = (f6.f) r1     // Catch: all -> 0x0098
            i5.d<T> r2 = r1.f4149j     // Catch: all -> 0x0098
            java.lang.Object r1 = r1.f4151l     // Catch: all -> 0x0098
            i5.f r3 = r2.a()     // Catch: all -> 0x0098
            java.lang.Object r1 = f6.v.c(r3, r1)     // Catch: all -> 0x0098
            q.d r4 = f6.v.f4182a     // Catch: all -> 0x0098
            r5 = 0
            if (r1 == r4) goto L_0x0023
            a6.n1 r4 = a6.s.b(r2, r3, r1)     // Catch: all -> 0x0098
            goto L_0x0024
        L_0x0023:
            r4 = r5
        L_0x0024:
            i5.f r6 = r2.a()     // Catch: all -> 0x005c
            java.lang.Object r7 = r12.k()     // Catch: all -> 0x005c
            java.lang.Throwable r8 = r12.f(r7)     // Catch: all -> 0x005c
            if (r8 != 0) goto L_0x0047
            int r9 = r12.f291h     // Catch: all -> 0x005c
            r10 = 1
            if (r9 == r10) goto L_0x003c
            r11 = 2
            if (r9 != r11) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r10 = 0
        L_0x003c:
            if (r10 == 0) goto L_0x0047
            a6.u0$b r9 = a6.u0.b.f341f     // Catch: all -> 0x005c
            i5.f$b r6 = r6.e(r9)     // Catch: all -> 0x005c
            a6.u0 r6 = (a6.u0) r6     // Catch: all -> 0x005c
            goto L_0x0048
        L_0x0047:
            r6 = r5
        L_0x0048:
            if (r6 == 0) goto L_0x005e
            boolean r9 = r6.b()     // Catch: all -> 0x005c
            if (r9 != 0) goto L_0x005e
            java.util.concurrent.CancellationException r6 = r6.G()     // Catch: all -> 0x005c
            r12.d(r7, r6)     // Catch: all -> 0x005c
            f5.d$a r6 = f5.e.a(r6)     // Catch: all -> 0x005c
            goto L_0x0069
        L_0x005c:
            r2 = move-exception
            goto L_0x008c
        L_0x005e:
            if (r8 == 0) goto L_0x0065
            f5.d$a r6 = f5.e.a(r8)     // Catch: all -> 0x005c
            goto L_0x0069
        L_0x0065:
            java.lang.Object r6 = r12.i(r7)     // Catch: all -> 0x005c
        L_0x0069:
            r2.o(r6)     // Catch: all -> 0x005c
            f5.g r2 = f5.g.f4141a     // Catch: all -> 0x005c
            if (r4 == 0) goto L_0x0076
            boolean r2 = r4.m0()     // Catch: all -> 0x0098
            if (r2 == 0) goto L_0x0079
        L_0x0076:
            f6.v.a(r3, r1)     // Catch: all -> 0x0098
        L_0x0079:
            r0.a()     // Catch: all -> 0x007f
            f5.g r0 = f5.g.f4141a     // Catch: all -> 0x007f
            goto L_0x0084
        L_0x007f:
            r0 = move-exception
            f5.d$a r0 = f5.e.a(r0)
        L_0x0084:
            java.lang.Throwable r0 = f5.d.a(r0)
            r12.j(r5, r0)
            goto L_0x00ab
        L_0x008c:
            if (r4 == 0) goto L_0x0094
            boolean r4 = r4.m0()     // Catch: all -> 0x0098
            if (r4 == 0) goto L_0x0097
        L_0x0094:
            f6.v.a(r3, r1)     // Catch: all -> 0x0098
        L_0x0097:
            throw r2     // Catch: all -> 0x0098
        L_0x0098:
            r1 = move-exception
            r0.a()     // Catch: all -> 0x009f
            f5.g r0 = f5.g.f4141a     // Catch: all -> 0x009f
            goto L_0x00a4
        L_0x009f:
            r0 = move-exception
            f5.d$a r0 = f5.e.a(r0)
        L_0x00a4:
            java.lang.Throwable r0 = f5.d.a(r0)
            r12.j(r1, r0)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.g0.run():void");
    }
}
