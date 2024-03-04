package f6;

import a6.a0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class i {

    /* renamed from: f */
    public static final AtomicReferenceFieldUpdater f4159f = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");

    /* renamed from: g */
    public static final AtomicReferenceFieldUpdater f4160g = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");

    /* renamed from: h */
    public static final AtomicReferenceFieldUpdater f4161h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* loaded from: classes.dex */
    public static abstract class a extends f6.a<i> {

        /* renamed from: b */
        public final i f4162b;

        /* renamed from: c */
        public i f4163c;

        public a(i iVar) {
            this.f4162b = iVar;
        }

        @Override // f6.a
        public final void b(i iVar, Object obj) {
            i iVar2 = iVar;
            boolean z6 = true;
            boolean z7 = obj == null;
            i iVar3 = z7 ? this.f4162b : this.f4163c;
            if (iVar3 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i.f4159f;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(iVar2, this, iVar3)) {
                        if (atomicReferenceFieldUpdater.get(iVar2) != this) {
                            z6 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z6 && z7) {
                    i iVar4 = this.f4162b;
                    i iVar5 = this.f4163c;
                    r5.h.c(iVar5);
                    iVar4.l(iVar5);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:205:0x0046, code lost:
        r5 = ((f6.p) r5).f4176a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x004e, code lost:
        if (r4.compareAndSet(r3, r2, r5) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0050, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0056, code lost:
        if (r4.get(r3) == r2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0058, code lost:
        if (r6 != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final f6.i h() {
        /*
            r10 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f6.i.f4160g
            java.lang.Object r0 = r0.get(r10)
            f6.i r0 = (f6.i) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f6.i.f4159f
            java.lang.Object r5 = r4.get(r2)
            r6 = 0
            r7 = 1
            if (r5 != r10) goto L2c
            if (r0 != r2) goto L18
            return r2
        L18:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = f6.i.f4160g
        L1a:
            boolean r1 = r8.compareAndSet(r10, r0, r2)
            if (r1 == 0) goto L22
            r6 = r7
            goto L28
        L22:
            java.lang.Object r1 = r8.get(r10)
            if (r1 == r0) goto L1a
        L28:
            if (r6 != 0) goto L2b
            goto L0
        L2b:
            return r2
        L2c:
            boolean r8 = r10.p()
            if (r8 == 0) goto L33
            return r1
        L33:
            if (r5 != 0) goto L36
            return r2
        L36:
            boolean r8 = r5 instanceof f6.o
            if (r8 == 0) goto L40
            f6.o r5 = (f6.o) r5
            r5.a(r2)
            goto L0
        L40:
            boolean r8 = r5 instanceof f6.p
            if (r8 == 0) goto L66
            if (r3 == 0) goto L5d
            f6.p r5 = (f6.p) r5
            f6.i r5 = r5.f4176a
        L4a:
            boolean r8 = r4.compareAndSet(r3, r2, r5)
            if (r8 == 0) goto L52
            r6 = r7
            goto L58
        L52:
            java.lang.Object r8 = r4.get(r3)
            if (r8 == r2) goto L4a
        L58:
            if (r6 != 0) goto L5b
            goto L0
        L5b:
            r2 = r3
            goto La
        L5d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f6.i.f4160g
            java.lang.Object r2 = r4.get(r2)
            f6.i r2 = (f6.i) r2
            goto Lb
        L66:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            r5.h.d(r5, r3)
            r3 = r5
            f6.i r3 = (f6.i) r3
            r9 = r3
            r3 = r2
            r2 = r9
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.i.h():f6.i");
    }

    public final void l(i iVar) {
        boolean z6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4160g;
        do {
            i iVar2 = (i) atomicReferenceFieldUpdater.get(iVar);
            if (m() == iVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4160g;
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(iVar, iVar2, this)) {
                        if (atomicReferenceFieldUpdater2.get(iVar) != iVar2) {
                            z6 = false;
                            continue;
                            break;
                        }
                    } else {
                        z6 = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z6);
        if (p()) {
            iVar.h();
        }
    }

    public final Object m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4159f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof o)) {
                return obj;
            }
            ((o) obj).a(this);
        }
    }

    public final i n() {
        i iVar;
        Object m = m();
        p pVar = m instanceof p ? (p) m : null;
        if (pVar == null || (iVar = pVar.f4176a) == null) {
            r5.h.d(m, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (i) m;
        }
        return iVar;
    }

    public final i o() {
        i h7 = h();
        if (h7 == null) {
            h7 = (i) f4160g.get(this);
            while (h7.p()) {
                h7 = (i) f4160g.get(h7);
            }
        }
        return h7;
    }

    public boolean p() {
        return m() instanceof p;
    }

    public String toString() {
        return new r5.n(this) { // from class: f6.i.b
        } + '@' + a0.c(this);
    }
}
