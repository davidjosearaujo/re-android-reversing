package v;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: v.a$a */
    /* loaded from: classes.dex */
    public static final class C0114a extends r5.i implements q5.l<Object, f5.g> {

        /* renamed from: g */
        public final /* synthetic */ List<q5.l<Object, f5.g>> f6121g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0114a(ArrayList arrayList) {
            super(1);
            this.f6121g = arrayList;
        }

        @Override // q5.l
        public final f5.g k(Object obj) {
            r5.h.f(obj, "state");
            List<q5.l<Object, f5.g>> list = this.f6121g;
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                list.get(i7).k(obj);
            }
            return f5.g.f4141a;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r6, v.e r7) {
        /*
            r5 = this;
            java.lang.Object r0 = v.f.f6144b
            monitor-enter(r0)
            java.util.ArrayList r1 = v.f.f6149h     // Catch: java.lang.Throwable -> L33
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L33
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L13
            java.util.ArrayList r1 = g5.n.c0(r1)     // Catch: java.lang.Throwable -> L33
            goto L14
        L13:
            r1 = r4
        L14:
            if (r1 == 0) goto L2d
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L33
            if (r2 != r3) goto L22
            r2 = 0
            java.lang.Object r2 = r1.get(r2)     // Catch: java.lang.Throwable -> L33
            goto L23
        L22:
            r2 = r4
        L23:
            q5.l r2 = (q5.l) r2     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L2e
            v.a$a r2 = new v.a$a     // Catch: java.lang.Throwable -> L33
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L33
            goto L2e
        L2d:
            r2 = r4
        L2e:
            monitor-exit(r0)
            r5.<init>(r6, r7, r4, r2)
            return
        L33:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v.a.<init>(int, v.e):void");
    }

    @Override // v.c
    public final void a() {
        synchronized (f.f6144b) {
            int i7 = this.f6128c;
            if (i7 >= 0) {
                f.m(i7);
                this.f6128c = -1;
            }
            f5.g gVar = f5.g.f4141a;
        }
    }
}
