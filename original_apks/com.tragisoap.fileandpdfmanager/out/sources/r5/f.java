package r5;

import androidx.activity.h;
import x5.a;
import x5.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class f extends b implements e, c {

    /* renamed from: l  reason: collision with root package name */
    public final int f5920l;
    public final int m;

    public f(int i7, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.f5920l = i7;
        this.m = i8 >> 1;
    }

    @Override // r5.b
    public final a a() {
        t.f5928a.getClass();
        return this;
    }

    @Override // r5.e
    public final int e() {
        return this.f5920l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [x5.a] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // java.lang.Object
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof r5.f
            r2 = 0
            if (r1 == 0) goto L_0x0046
            r5.f r5 = (r5.f) r5
            java.lang.String r1 = r4.f5913i
            java.lang.String r3 = r5.f5913i
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = r4.f5914j
            java.lang.String r3 = r5.f5914j
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0044
            int r1 = r4.m
            int r3 = r5.m
            if (r1 != r3) goto L_0x0044
            int r1 = r4.f5920l
            int r3 = r5.f5920l
            if (r1 != r3) goto L_0x0044
            java.lang.Object r1 = r4.f5911g
            java.lang.Object r3 = r5.f5911g
            boolean r1 = r5.h.a(r1, r3)
            if (r1 == 0) goto L_0x0044
            r5.c r4 = r4.b()
            r5.c r5 = r5.b()
            boolean r4 = r5.h.a(r4, r5)
            if (r4 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r0 = r2
        L_0x0045:
            return r0
        L_0x0046:
            boolean r0 = r5 instanceof x5.c
            if (r0 == 0) goto L_0x005a
            x5.a r0 = r4.f5910f
            if (r0 != 0) goto L_0x0054
            r4.a()
            r4.f5910f = r4
            goto L_0x0055
        L_0x0054:
            r4 = r0
        L_0x0055:
            boolean r4 = r5.equals(r4)
            return r4
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.f.equals(java.lang.Object):boolean");
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.f5914j.hashCode() + ((this.f5913i.hashCode() + (b() == null ? 0 : b().hashCode() * 31)) * 31);
    }

    @Override // java.lang.Object
    public final String toString() {
        a aVar = this.f5910f;
        if (aVar == null) {
            a();
            this.f5910f = this;
            aVar = this;
        }
        return aVar != this ? aVar.toString() : "<init>".equals(this.f5913i) ? "constructor (Kotlin reflection is not available)" : h.c(h.d("function "), this.f5913i, " (Kotlin reflection is not available)");
    }
}
