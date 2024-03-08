package v;

import f5.g;
import java.util.ArrayList;
import java.util.List;
import q5.l;
import r5.h;
import r5.i;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends b {

    /* renamed from: v.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0114a extends i implements l<Object, g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List<l<Object, g>> f6121g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0114a(ArrayList arrayList) {
            super(1);
            this.f6121g = arrayList;
        }

        @Override // q5.l
        public final g k(Object obj) {
            h.f(obj, "state");
            List<l<Object, g>> list = this.f6121g;
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                list.get(i7).k(obj);
            }
            return g.f4141a;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(int r6, v.e r7) {
        /*
            r5 = this;
            java.lang.Object r0 = v.f.f6144b
            monitor-enter(r0)
            java.util.ArrayList r1 = v.f.f6149h     // Catch: all -> 0x0033
            boolean r2 = r1.isEmpty()     // Catch: all -> 0x0033
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L_0x0013
            java.util.ArrayList r1 = g5.n.c0(r1)     // Catch: all -> 0x0033
            goto L_0x0014
        L_0x0013:
            r1 = r4
        L_0x0014:
            if (r1 == 0) goto L_0x002d
            int r2 = r1.size()     // Catch: all -> 0x0033
            if (r2 != r3) goto L_0x0022
            r2 = 0
            java.lang.Object r2 = r1.get(r2)     // Catch: all -> 0x0033
            goto L_0x0023
        L_0x0022:
            r2 = r4
        L_0x0023:
            q5.l r2 = (q5.l) r2     // Catch: all -> 0x0033
            if (r2 != 0) goto L_0x002e
            v.a$a r2 = new v.a$a     // Catch: all -> 0x0033
            r2.<init>(r1)     // Catch: all -> 0x0033
            goto L_0x002e
        L_0x002d:
            r2 = r4
        L_0x002e:
            monitor-exit(r0)
            r5.<init>(r6, r7, r4, r2)
            return
        L_0x0033:
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
            g gVar = g.f4141a;
        }
    }
}
