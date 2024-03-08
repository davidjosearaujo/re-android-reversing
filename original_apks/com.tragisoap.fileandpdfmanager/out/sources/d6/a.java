package d6;

import e6.o;
import i5.d;
import k5.c;
import k5.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class a<T> implements c<T> {

    @e(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: d6.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0045a extends c {

        /* renamed from: i  reason: collision with root package name */
        public o f3649i;

        /* renamed from: j  reason: collision with root package name */
        public /* synthetic */ Object f3650j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a<T> f3651k;

        /* renamed from: l  reason: collision with root package name */
        public int f3652l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0045a(a<T> aVar, d<? super C0045a> dVar) {
            super(dVar);
            this.f3651k = aVar;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            this.f3650j = obj;
            this.f3652l |= Integer.MIN_VALUE;
            return this.f3651k.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    @Override // d6.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(d6.d<? super T> r5, i5.d<? super f5.g> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof d6.a.C0045a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            d6.a$a r0 = (d6.a.C0045a) r0
            int r1 = r0.f3652l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f3652l = r1
            goto L_0x0018
        L_0x0013:
            d6.a$a r0 = new d6.a$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f3650j
            j5.a r1 = j5.a.f4591f
            int r2 = r0.f3652l
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            e6.o r4 = r0.f3649i
            f5.e.b(r6)     // Catch: all -> 0x0029
            goto L_0x0055
        L_0x0029:
            r5 = move-exception
            goto L_0x005e
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            f5.e.b(r6)
            e6.o r6 = new e6.o
            i5.f r2 = r0.f4819g
            r5.h.c(r2)
            r6.<init>(r5, r2)
            r0.f3649i = r6     // Catch: all -> 0x005b
            r0.f3652l = r3     // Catch: all -> 0x005b
            d6.s r4 = (d6.s) r4     // Catch: all -> 0x005b
            q5.p<d6.d<? super T>, i5.d<? super f5.g>, java.lang.Object> r4 = r4.f3732f     // Catch: all -> 0x005b
            java.lang.Object r4 = r4.i(r6, r0)     // Catch: all -> 0x005b
            if (r4 != r1) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            f5.g r4 = f5.g.f4141a     // Catch: all -> 0x005b
        L_0x0051:
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r4 = r6
        L_0x0055:
            r4.t()
            f5.g r4 = f5.g.f4141a
            return r4
        L_0x005b:
            r4 = move-exception
            r5 = r4
            r4 = r6
        L_0x005e:
            r4.t()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.a.a(d6.d, i5.d):java.lang.Object");
    }
}
