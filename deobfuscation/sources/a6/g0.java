package a6;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class g0<T> extends g6.g {

    /* renamed from: h */
    public int f291h;

    public g0(int i7) {
        this.f291h = i7;
    }

    public void d(Object obj, CancellationException cancellationException) {
    }

    public abstract i5.d<T> e();

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
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            q2.a.c(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        r5.h.c(th);
        w.a(e().a(), new z("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    /* JADX WARN: Code restructure failed: missing block: B:188:0x003e, code lost:
        r6 = (a6.u0) r6.e(a6.u0.b.f341f);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r12 = this;
            g6.h r0 = r12.f4316g
            i5.d r1 = r12.e()     // Catch: java.lang.Throwable -> L98
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            r5.h.d(r1, r2)     // Catch: java.lang.Throwable -> L98
            f6.f r1 = (f6.f) r1     // Catch: java.lang.Throwable -> L98
            i5.d<T> r2 = r1.f4149j     // Catch: java.lang.Throwable -> L98
            java.lang.Object r1 = r1.f4151l     // Catch: java.lang.Throwable -> L98
            i5.f r3 = r2.a()     // Catch: java.lang.Throwable -> L98
            java.lang.Object r1 = f6.v.c(r3, r1)     // Catch: java.lang.Throwable -> L98
            q.d r4 = f6.v.f4182a     // Catch: java.lang.Throwable -> L98
            r5 = 0
            if (r1 == r4) goto L23
            a6.n1 r4 = a6.s.b(r2, r3, r1)     // Catch: java.lang.Throwable -> L98
            goto L24
        L23:
            r4 = r5
        L24:
            i5.f r6 = r2.a()     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r7 = r12.k()     // Catch: java.lang.Throwable -> L5c
            java.lang.Throwable r8 = r12.f(r7)     // Catch: java.lang.Throwable -> L5c
            if (r8 != 0) goto L47
            int r9 = r12.f291h     // Catch: java.lang.Throwable -> L5c
            r10 = 1
            if (r9 == r10) goto L3c
            r11 = 2
            if (r9 != r11) goto L3b
            goto L3c
        L3b:
            r10 = 0
        L3c:
            if (r10 == 0) goto L47
            a6.u0$b r9 = a6.u0.b.f341f     // Catch: java.lang.Throwable -> L5c
            i5.f$b r6 = r6.e(r9)     // Catch: java.lang.Throwable -> L5c
            a6.u0 r6 = (a6.u0) r6     // Catch: java.lang.Throwable -> L5c
            goto L48
        L47:
            r6 = r5
        L48:
            if (r6 == 0) goto L5e
            boolean r9 = r6.b()     // Catch: java.lang.Throwable -> L5c
            if (r9 != 0) goto L5e
            java.util.concurrent.CancellationException r6 = r6.G()     // Catch: java.lang.Throwable -> L5c
            r12.d(r7, r6)     // Catch: java.lang.Throwable -> L5c
            f5.d$a r6 = f5.e.a(r6)     // Catch: java.lang.Throwable -> L5c
            goto L69
        L5c:
            r2 = move-exception
            goto L8c
        L5e:
            if (r8 == 0) goto L65
            f5.d$a r6 = f5.e.a(r8)     // Catch: java.lang.Throwable -> L5c
            goto L69
        L65:
            java.lang.Object r6 = r12.i(r7)     // Catch: java.lang.Throwable -> L5c
        L69:
            r2.o(r6)     // Catch: java.lang.Throwable -> L5c
            f5.g r2 = f5.g.f4141a     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L76
            boolean r2 = r4.m0()     // Catch: java.lang.Throwable -> L98
            if (r2 == 0) goto L79
        L76:
            f6.v.a(r3, r1)     // Catch: java.lang.Throwable -> L98
        L79:
            r0.a()     // Catch: java.lang.Throwable -> L7f
            f5.g r0 = f5.g.f4141a     // Catch: java.lang.Throwable -> L7f
            goto L84
        L7f:
            r0 = move-exception
            f5.d$a r0 = f5.e.a(r0)
        L84:
            java.lang.Throwable r0 = f5.d.a(r0)
            r12.j(r5, r0)
            goto Lab
        L8c:
            if (r4 == 0) goto L94
            boolean r4 = r4.m0()     // Catch: java.lang.Throwable -> L98
            if (r4 == 0) goto L97
        L94:
            f6.v.a(r3, r1)     // Catch: java.lang.Throwable -> L98
        L97:
            throw r2     // Catch: java.lang.Throwable -> L98
        L98:
            r1 = move-exception
            r0.a()     // Catch: java.lang.Throwable -> L9f
            f5.g r0 = f5.g.f4141a     // Catch: java.lang.Throwable -> L9f
            goto La4
        L9f:
            r0 = move-exception
            f5.d$a r0 = f5.e.a(r0)
        La4:
            java.lang.Throwable r0 = f5.d.a(r0)
            r12.j(r1, r0)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.g0.run():void");
    }
}
