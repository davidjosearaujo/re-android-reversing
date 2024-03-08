package d6;

import i5.d;
import k5.c;
import k5.e;
import q5.p;
import r5.s;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m implements d<Object> {

    /* renamed from: f */
    public final /* synthetic */ p f3711f;

    /* renamed from: g */
    public final /* synthetic */ s f3712g;

    @e(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", l = {142}, m = "emit")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends c {

        /* renamed from: i */
        public m f3713i;

        /* renamed from: j */
        public /* synthetic */ Object f3714j;

        /* renamed from: k */
        public int f3715k;
        public Object m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(dVar);
            m.this = r1;
        }

        @Override // k5.a
        public final Object s(Object obj) {
            this.f3714j = obj;
            this.f3715k |= Integer.MIN_VALUE;
            return m.this.m(null, this);
        }
    }

    public m(p pVar, s sVar) {
        this.f3711f = pVar;
        this.f3712g = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    @Override // d6.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.Object r5, i5.d<? super f5.g> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof d6.m.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            d6.m$a r0 = (d6.m.a) r0
            int r1 = r0.f3715k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f3715k = r1
            goto L_0x0018
        L_0x0013:
            d6.m$a r0 = new d6.m$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f3714j
            j5.a r1 = j5.a.f4591f
            int r2 = r0.f3715k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r5 = r0.m
            d6.m r4 = r0.f3713i
            f5.e.b(r6)
            goto L_0x0045
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            f5.e.b(r6)
            q5.p r6 = r4.f3711f
            r0.f3713i = r4
            r0.m = r5
            r0.f3715k = r3
            java.lang.Object r6 = r6.i(r5, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0052
            r5.s r6 = r4.f3712g
            r6.f5927f = r5
            r3 = 0
        L_0x0052:
            if (r3 == 0) goto L_0x0057
            f5.g r4 = f5.g.f4141a
            return r4
        L_0x0057:
            e6.a r5 = new e6.a
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.m.m(java.lang.Object, i5.d):java.lang.Object");
    }
}
