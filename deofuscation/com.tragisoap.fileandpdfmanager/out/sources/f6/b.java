package f6;

import f6.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class b<N extends b<N>> {

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4143f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next");

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4144g = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public b(N n6) {
        this._prev = n6;
    }

    public final void a() {
        f4144g.lazySet(this, null);
    }

    public final N b() {
        Object obj = f4143f.get(this);
        if (obj == a0.b.f25z) {
            return null;
        }
        return (N) ((b) obj);
    }

    public abstract boolean c();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [f6.b] */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r8 = this;
            f6.b r0 = r8.b()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r0 = r1
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f6.b.f4144g
            java.lang.Object r0 = r0.get(r8)
            f6.b r0 = (f6.b) r0
        L_0x0016:
            if (r0 == 0) goto L_0x0027
            boolean r3 = r0.c()
            if (r3 == 0) goto L_0x0027
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f6.b.f4144g
            java.lang.Object r0 = r3.get(r0)
            f6.b r0 = (f6.b) r0
            goto L_0x0016
        L_0x0027:
            f6.b r3 = r8.b()
            r5.h.c(r3)
        L_0x002e:
            boolean r4 = r3.c()
            if (r4 == 0) goto L_0x003d
            f6.b r4 = r3.b()
            if (r4 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = r4
            goto L_0x002e
        L_0x003d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f6.b.f4144g
        L_0x003f:
            java.lang.Object r5 = r4.get(r3)
            r6 = r5
            f6.b r6 = (f6.b) r6
            if (r6 != 0) goto L_0x004a
            r6 = 0
            goto L_0x004b
        L_0x004a:
            r6 = r0
        L_0x004b:
            boolean r7 = r4.compareAndSet(r3, r5, r6)
            if (r7 == 0) goto L_0x0053
            r5 = r1
            goto L_0x005a
        L_0x0053:
            java.lang.Object r7 = r4.get(r3)
            if (r7 == r5) goto L_0x004b
            r5 = r2
        L_0x005a:
            if (r5 == 0) goto L_0x003f
            if (r0 == 0) goto L_0x0063
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f6.b.f4143f
            r4.set(r0, r3)
        L_0x0063:
            boolean r4 = r3.c()
            if (r4 == 0) goto L_0x0074
            f6.b r3 = r3.b()
            if (r3 != 0) goto L_0x0071
            r3 = r1
            goto L_0x0072
        L_0x0071:
            r3 = r2
        L_0x0072:
            if (r3 == 0) goto L_0x000e
        L_0x0074:
            if (r0 == 0) goto L_0x007c
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x000e
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.b.d():void");
    }
}
