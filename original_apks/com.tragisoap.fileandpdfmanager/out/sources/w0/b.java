package w0;

import java.util.ArrayList;
import w0.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class b implements d.a {

    /* renamed from: d */
    public a f6336d;

    /* renamed from: a */
    public f f6333a = null;

    /* renamed from: b */
    public float f6334b = 0.0f;

    /* renamed from: c */
    public ArrayList<f> f6335c = new ArrayList<>();
    public boolean e = false;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        float a(int i7);

        void b(f fVar, float f7);

        int c();

        void clear();

        void d(f fVar, float f7, boolean z6);

        float e(f fVar);

        boolean f(f fVar);

        f g(int i7);

        float h(f fVar, boolean z6);

        void i(float f7);

        void j();

        float k(b bVar, boolean z6);
    }

    public b() {
    }

    public b(c cVar) {
        this.f6336d = new a(this, cVar);
    }

    @Override // w0.d.a
    public f a(boolean[] zArr) {
        return f(zArr, null);
    }

    public final void b(d dVar, int i7) {
        this.f6336d.b(dVar.k(i7), 1.0f);
        this.f6336d.b(dVar.k(i7), -1.0f);
    }

    public final void c(f fVar, f fVar2, f fVar3, int i7) {
        boolean z6 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z6 = true;
            }
            this.f6334b = (float) i7;
        }
        if (!z6) {
            this.f6336d.b(fVar, -1.0f);
            this.f6336d.b(fVar2, 1.0f);
            this.f6336d.b(fVar3, 1.0f);
            return;
        }
        this.f6336d.b(fVar, 1.0f);
        this.f6336d.b(fVar2, -1.0f);
        this.f6336d.b(fVar3, -1.0f);
    }

    public final void d(f fVar, f fVar2, f fVar3, int i7) {
        boolean z6 = false;
        if (i7 != 0) {
            if (i7 < 0) {
                i7 *= -1;
                z6 = true;
            }
            this.f6334b = (float) i7;
        }
        if (!z6) {
            this.f6336d.b(fVar, -1.0f);
            this.f6336d.b(fVar2, 1.0f);
            this.f6336d.b(fVar3, -1.0f);
            return;
        }
        this.f6336d.b(fVar, 1.0f);
        this.f6336d.b(fVar2, -1.0f);
        this.f6336d.b(fVar3, 1.0f);
    }

    public boolean e() {
        return this.f6333a == null && this.f6334b == 0.0f && this.f6336d.c() == 0;
    }

    public final f f(boolean[] zArr, f fVar) {
        int i7;
        int c7 = this.f6336d.c();
        f fVar2 = null;
        float f7 = 0.0f;
        for (int i8 = 0; i8 < c7; i8++) {
            float a7 = this.f6336d.a(i8);
            if (a7 < 0.0f) {
                f g2 = this.f6336d.g(i8);
                if ((zArr == null || !zArr[g2.f6363g]) && g2 != fVar && (((i7 = g2.f6369n) == 3 || i7 == 4) && a7 < f7)) {
                    f7 = a7;
                    fVar2 = g2;
                }
            }
        }
        return fVar2;
    }

    public final void g(f fVar) {
        f fVar2 = this.f6333a;
        if (fVar2 != null) {
            this.f6336d.b(fVar2, -1.0f);
            this.f6333a.f6364h = -1;
            this.f6333a = null;
        }
        float h7 = this.f6336d.h(fVar, true) * -1.0f;
        this.f6333a = fVar;
        if (h7 != 1.0f) {
            this.f6334b /= h7;
            this.f6336d.i(h7);
        }
    }

    public final void h(d dVar, f fVar, boolean z6) {
        if (fVar != null && fVar.f6367k) {
            float e = this.f6336d.e(fVar);
            this.f6334b = (fVar.f6366j * e) + this.f6334b;
            this.f6336d.h(fVar, z6);
            if (z6) {
                fVar.b(this);
            }
            if (this.f6336d.c() == 0) {
                this.e = true;
                dVar.f6343a = true;
            }
        }
    }

    public void i(d dVar, b bVar, boolean z6) {
        float k6 = this.f6336d.k(bVar, z6);
        this.f6334b = (bVar.f6334b * k6) + this.f6334b;
        if (z6) {
            bVar.f6333a.b(this);
        }
        if (this.f6333a != null && this.f6336d.c() == 0) {
            this.e = true;
            dVar.f6343a = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            w0.f r0 = r10.f6333a
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "0"
            goto L_0x0016
        L_0x0007:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            w0.f r1 = r10.f6333a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0016:
            java.lang.String r1 = " = "
            java.lang.String r0 = androidx.fragment.app.s0.h(r0, r1)
            float r1 = r10.f6334b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0034
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            float r1 = r10.f6334b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L_0x0035
        L_0x0034:
            r1 = r3
        L_0x0035:
            w0.b$a r5 = r10.f6336d
            int r5 = r5.c()
        L_0x003b:
            if (r3 >= r5) goto L_0x009f
            w0.b$a r6 = r10.f6336d
            w0.f r6 = r6.g(r3)
            if (r6 != 0) goto L_0x0046
            goto L_0x009c
        L_0x0046:
            w0.b$a r7 = r10.f6336d
            float r7 = r7.a(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0051
            goto L_0x009c
        L_0x0051:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0064
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x007e
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            java.lang.String r1 = "- "
            goto L_0x0076
        L_0x0064:
            java.lang.StringBuilder r0 = androidx.activity.h.d(r0)
            if (r8 <= 0) goto L_0x0074
            java.lang.String r1 = " + "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x007e
        L_0x0074:
            java.lang.String r1 = " - "
        L_0x0076:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            float r7 = r7 * r9
        L_0x007e:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x008a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0097
        L_0x008a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        L_0x0097:
            java.lang.String r0 = androidx.activity.h.c(r1, r0, r6)
            r1 = r4
        L_0x009c:
            int r3 = r3 + 1
            goto L_0x003b
        L_0x009f:
            if (r1 != 0) goto L_0x00a7
            java.lang.String r10 = "0.0"
            java.lang.String r0 = androidx.fragment.app.s0.h(r0, r10)
        L_0x00a7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.b.toString():java.lang.String");
    }
}
