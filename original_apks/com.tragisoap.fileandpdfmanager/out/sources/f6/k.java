package f6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k<E> {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4165f = AtomicLongFieldUpdater.newUpdater(k.class, "_state");

    /* renamed from: g  reason: collision with root package name */
    public static final d f4166g = new d(4, "REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with root package name */
    public final int f4167a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4168b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4169c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReferenceArray f4170d;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4171a;

        public a(int i7) {
            this.f4171a = i7;
        }
    }

    public k(int i7, boolean z6) {
        this.f4167a = i7;
        this.f4168b = z6;
        int i8 = i7 - 1;
        this.f4169c = i8;
        this.f4170d = new AtomicReferenceArray(i7);
        boolean z7 = false;
        if (i8 <= 1073741823) {
            if (!((i7 & i8) == 0 ? true : z7)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r17) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = f6.k.f4165f
        L_0x0006:
            long r2 = r8.get(r6)
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r9 = 0
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x001d
            r4 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r2 = r2 & r4
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x001c
            r1 = 2
        L_0x001c:
            return r1
        L_0x001d:
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r11 = 0
            long r4 = r4 >> r11
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r12 = 30
            long r4 = r4 >> r12
            int r13 = (int) r4
            int r14 = r6.f4169c
            int r4 = r13 + 2
            r4 = r4 & r14
            r5 = r0 & r14
            if (r4 != r5) goto L_0x0038
            return r1
        L_0x0038:
            boolean r4 = r6.f4168b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L_0x0057
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r6.f4170d
            r15 = r13 & r14
            java.lang.Object r4 = r4.get(r15)
            if (r4 == 0) goto L_0x0057
            int r2 = r6.f4167a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L_0x0056
            int r13 = r13 - r0
            r0 = r13 & r5
            int r2 = r2 >> 1
            if (r0 <= r2) goto L_0x0006
        L_0x0056:
            return r1
        L_0x0057:
            int r0 = r13 + 1
            r0 = r0 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f6.k.f4165f
            r4 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r4 = r4 & r2
            long r9 = (long) r0
            long r9 = r9 << r12
            long r4 = r4 | r9
            r0 = r1
            r1 = r16
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0006
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r6.f4170d
            r1 = r13 & r14
            r0.set(r1, r7)
        L_0x0075:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f6.k.f4165f
            long r0 = r0.get(r6)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a8
            f6.k r0 = r6.c()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.f4170d
            int r4 = r0.f4169c
            r4 = r4 & r13
            java.lang.Object r1 = r1.get(r4)
            boolean r4 = r1 instanceof f6.k.a
            if (r4 == 0) goto L_0x00a4
            f6.k$a r1 = (f6.k.a) r1
            int r1 = r1.f4171a
            if (r1 != r13) goto L_0x00a4
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.f4170d
            int r4 = r0.f4169c
            r4 = r4 & r13
            r1.set(r4, r7)
            goto L_0x00a5
        L_0x00a4:
            r0 = 0
        L_0x00a5:
            r6 = r0
            if (r6 != 0) goto L_0x0075
        L_0x00a8:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.k.a(java.lang.Object):int");
    }

    public final boolean b() {
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4165f;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j7) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, j7 | 2305843009213693952L));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k<E> c() {
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4165f;
        while (true) {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 1152921504606846976L) == 0) {
                long j8 = j7 | 1152921504606846976L;
                if (atomicLongFieldUpdater.compareAndSet(this, j7, j8)) {
                    j7 = j8;
                    break;
                }
            } else {
                break;
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        while (true) {
            k<E> kVar = (k) atomicReferenceFieldUpdater.get(this);
            if (kVar != null) {
                return kVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
            k kVar2 = new k(this.f4167a * 2, this.f4168b);
            int i7 = (int) ((1073741823 & j7) >> 0);
            int i8 = (int) ((1152921503533105152L & j7) >> 30);
            while (true) {
                int i9 = this.f4169c;
                int i10 = i7 & i9;
                if (i10 == (i9 & i8)) {
                    break;
                }
                Object obj = this.f4170d.get(i10);
                if (obj == null) {
                    obj = new a(i7);
                }
                kVar2.f4170d.set(kVar2.f4169c & i7, obj);
                i7++;
            }
            f4165f.set(kVar2, -1152921504606846977L & j7);
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, kVar2) && atomicReferenceFieldUpdater2.get(this) == null) {
            }
        }
    }

    public final Object d() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4165f;
        while (true) {
            long j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 1152921504606846976L) != 0) {
                return f4166g;
            }
            int i7 = (int) ((j7 & 1073741823) >> 0);
            int i8 = this.f4169c;
            int i9 = ((int) ((1152921503533105152L & j7) >> 30)) & i8;
            int i10 = i8 & i7;
            if (i9 == i10) {
                return null;
            }
            Object obj = this.f4170d.get(i10);
            if (obj == null) {
                if (this.f4168b) {
                    return null;
                }
            } else if (obj instanceof a) {
                return null;
            } else {
                long j8 = ((long) ((i7 + 1) & 1073741823)) << 0;
                if (f4165f.compareAndSet(this, j7, j8 | (j7 & -1073741824))) {
                    this.f4170d.set(this.f4169c & i7, null);
                    return obj;
                } else if (this.f4168b) {
                    k<E> kVar = this;
                    do {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f4165f;
                        while (true) {
                            long j9 = atomicLongFieldUpdater2.get(kVar);
                            int i11 = (int) ((j9 & 1073741823) >> 0);
                            if ((j9 & 1152921504606846976L) == 0) {
                                if (f4165f.compareAndSet(kVar, j9, j8 | (j9 & -1073741824))) {
                                    kVar.f4170d.set(kVar.f4169c & i11, null);
                                    kVar = null;
                                    continue;
                                    break;
                                }
                            } else {
                                kVar = kVar.c();
                                continue;
                                break;
                            }
                        }
                    } while (kVar != null);
                    return obj;
                }
            }
        }
    }
}
