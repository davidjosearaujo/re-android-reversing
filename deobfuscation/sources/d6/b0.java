package d6;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes.dex */
public final class b0 implements y {

    /* renamed from: a */
    public final long f3670a;

    /* renamed from: b */
    public final long f3671b;

    @k5.e(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, SubsamplingScaleImageView.ORIENTATION_180, 182, 183, 185}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends k5.i implements q5.q {

        /* renamed from: j */
        public int f3672j;

        /* renamed from: k */
        public /* synthetic */ d f3673k;

        /* renamed from: l */
        public /* synthetic */ int f3674l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i5.d dVar) {
            super(3, dVar);
            b0.this = r1;
        }

        public final Object f(Object obj, Object obj2, Object obj3) {
            int intValue = ((Number) obj2).intValue();
            a aVar = new a((i5.d) obj3);
            aVar.f3673k = (d) obj;
            aVar.f3674l = intValue;
            return aVar.s(f5.g.f4141a);
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x007d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x008b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object s(java.lang.Object r10) {
            /*
                r9 = this;
                j5.a r0 = Kotlin_1.a.f4591f
                int r1 = r9.f3672j
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L34
                if (r1 == r6) goto L30
                if (r1 == r5) goto L2a
                if (r1 == r4) goto L24
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                goto L30
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1e:
                d6.d r1 = r9.f3673k
                f5.e.b(r10)
                goto L7e
            L24:
                d6.d r1 = r9.f3673k
                f5.e.b(r10)
                goto L6f
            L2a:
                d6.d r1 = r9.f3673k
                f5.e.b(r10)
                goto L58
            L30:
                f5.e.b(r10)
                goto L8c
            L34:
                f5.e.b(r10)
                d6.d r10 = r9.f3673k
                int r1 = r9.f3674l
                if (r1 <= 0) goto L48
                d6.x r1 = d6.x.START
                r9.f3672j = r6
                java.lang.Object r9 = r10.m(r1, r9)
                if (r9 != r0) goto L8c
                return r0
            L48:
                d6.b0 r1 = d6.b0.this
                long r6 = r1.f3670a
                r9.f3673k = r10
                r9.f3672j = r5
                java.lang.Object r1 = a6.e0.a(r6, r9)
                if (r1 != r0) goto L57
                return r0
            L57:
                r1 = r10
            L58:
                d6.b0 r10 = d6.b0.this
                long r5 = r10.f3671b
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L7e
                d6.x r10 = d6.x.STOP
                r9.f3673k = r1
                r9.f3672j = r4
                java.lang.Object r10 = r1.m(r10, r9)
                if (r10 != r0) goto L6f
                return r0
            L6f:
                d6.b0 r10 = d6.b0.this
                long r4 = r10.f3671b
                r9.f3673k = r1
                r9.f3672j = r3
                java.lang.Object r10 = a6.e0.a(r4, r9)
                if (r10 != r0) goto L7e
                return r0
            L7e:
                d6.x r10 = d6.x.STOP_AND_RESET_REPLAY_CACHE
                r3 = 0
                r9.f3673k = r3
                r9.f3672j = r2
                java.lang.Object r9 = r1.m(r10, r9)
                if (r9 != r0) goto L8c
                return r0
            L8c:
                f5.g r9 = f5.g.f4141a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: d6.b0.a.s(java.lang.Object):java.lang.Object");
        }
    }

    @k5.e(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends k5.i implements q5.p {

        /* renamed from: j */
        public /* synthetic */ Object f3675j;

        public b(i5.d dVar) {
            super(2, dVar);
        }

        public final Object i(Object obj, Object obj2) {
            return ((b) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            b bVar = new b(dVar);
            bVar.f3675j = obj;
            return bVar;
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            return Boolean.valueOf(((x) this.f3675j) != x.START);
        }
    }

    public b0(long j5, long j7) {
        this.f3670a = j5;
        this.f3671b = j7;
        if (!(j5 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j5 + " ms) cannot be negative").toString());
        }
        if (j7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j7 + " ms) cannot be negative").toString());
    }

    public final c a(c0 c0Var) {
        a aVar = new a(null);
        int i7 = l.f3710a;
        return q2.a.q(new i(new e6.j(aVar, c0Var, i5.g.f4488f, -2, c6.a.SUSPEND), new b(null)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            if (this.f3670a == b0Var.f3670a && this.f3671b == b0Var.f3671b) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public final int hashCode() {
        return Long.hashCode(this.f3671b) + (Long.hashCode(this.f3670a) * 31);
    }

    public final String toString() {
        h5.a aVar = new h5.a(2);
        if (this.f3670a > 0) {
            StringBuilder d7 = androidx.activity.h.d("stopTimeout=");
            d7.append(this.f3670a);
            d7.append("ms");
            aVar.add(d7.toString());
        }
        if (this.f3671b < Long.MAX_VALUE) {
            StringBuilder d8 = androidx.activity.h.d("replayExpiration=");
            d8.append(this.f3671b);
            d8.append("ms");
            aVar.add(d8.toString());
        }
        if (aVar.f4396j == null) {
            aVar.g();
            aVar.f4395i = true;
            if (aVar.f4394h <= 0) {
                aVar = h5.a.f4391l;
            }
            StringBuilder d9 = androidx.activity.h.d("SharingStarted.WhileSubscribed(");
            d9.append(g5.n.Z(aVar, null, null, null, null, 63));
            d9.append(')');
            return d9.toString();
        }
        throw new IllegalStateException();
    }
}
