package c0;

import java.util.Arrays;

/* loaded from: classes.dex */
public class h {
    public static final g e;

    /* renamed from: f */
    public static final h f2475f;

    /* renamed from: a */
    public final c f2476a;

    /* renamed from: b */
    public final c f2477b;

    /* renamed from: c */
    public final c f2478c;

    /* renamed from: d */
    public final float[] f2479d;

    /* loaded from: classes.dex */
    public static final class a {
    }

    /* loaded from: classes.dex */
    public static final class b extends h {

        /* renamed from: g */
        public final r f2480g;

        /* renamed from: h */
        public final r f2481h;

        /* renamed from: i */
        public final float[] f2482i;

        public b(r rVar, r rVar2, int i7) {
            super(rVar, rVar2, rVar, rVar2, null);
            float[] e;
            this.f2480g = rVar;
            this.f2481h = rVar2;
            if (d.c(rVar.f2495d, rVar2.f2495d)) {
                e = d.e(rVar2.f2500j, rVar.f2499i);
            } else {
                float[] fArr = rVar.f2499i;
                float[] fArr2 = rVar2.f2500j;
                float[] a7 = rVar.f2495d.a();
                float[] a8 = rVar2.f2495d.a();
                t tVar = rVar.f2495d;
                t tVar2 = a0.e.f52r;
                if (!d.c(tVar, tVar2)) {
                    float[] fArr3 = c0.a.f2460b.f2461a;
                    float[] copyOf = Arrays.copyOf(a0.e.f54u, 3);
                    r5.h.e(copyOf, "copyOf(this, size)");
                    fArr = d.e(d.b(fArr3, a7, copyOf), rVar.f2499i);
                }
                if (!d.c(rVar2.f2495d, tVar2)) {
                    float[] fArr4 = c0.a.f2460b.f2461a;
                    float[] copyOf2 = Arrays.copyOf(a0.e.f54u, 3);
                    r5.h.e(copyOf2, "copyOf(this, size)");
                    fArr2 = d.d(d.e(d.b(fArr4, a8, copyOf2), rVar2.f2499i));
                }
                e = d.e(fArr2, i7 == 3 ? d.f(new float[]{a7[0] / a8[0], a7[1] / a8[1], a7[2] / a8[2]}, fArr) : fArr);
            }
            this.f2482i = e;
        }

        @Override // c0.h
        public final long a(float f7, float f8, float f9, float f10) {
            float b2 = (float) this.f2480g.f2503n.b(f7);
            float b7 = (float) this.f2480g.f2503n.b(f8);
            float b8 = (float) this.f2480g.f2503n.b(f9);
            return a0.e.a((float) this.f2481h.f2502l.b(d.h(this.f2482i, b2, b7, b8)), (float) this.f2481h.f2502l.b(d.i(this.f2482i, b2, b7, b8)), (float) this.f2481h.f2502l.b(d.j(this.f2482i, b2, b7, b8)), f10, this.f2481h);
        }
    }

    static {
        new a();
        r rVar = f.f2472c;
        r5.h.f(rVar, "source");
        e = new g(rVar);
        k kVar = f.e;
        new h(rVar, kVar, 0);
        f2475f = new h(kVar, rVar, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(c0.c r11, c0.c r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "source"
            r5.h.f(r11, r0)
            java.lang.String r0 = "destination"
            r5.h.f(r12, r0)
            long r0 = r11.f2467b
            long r2 = c0.b.f2462a
            boolean r0 = c0.b.a(r0, r2)
            if (r0 == 0) goto L1a
            c0.c r0 = c0.d.a(r11)
            r7 = r0
            goto L1b
        L1a:
            r7 = r11
        L1b:
            long r0 = r12.f2467b
            boolean r0 = c0.b.a(r0, r2)
            if (r0 == 0) goto L29
            c0.c r0 = c0.d.a(r12)
            r8 = r0
            goto L2a
        L29:
            r8 = r12
        L2a:
            r0 = 3
            r1 = 1
            r4 = 0
            if (r13 != r0) goto L31
            r13 = r1
            goto L32
        L31:
            r13 = r4
        L32:
            if (r13 != 0) goto L35
            goto L4b
        L35:
            long r5 = r11.f2467b
            boolean r13 = c0.b.a(r5, r2)
            long r5 = r12.f2467b
            boolean r2 = c0.b.a(r5, r2)
            if (r13 == 0) goto L46
            if (r2 == 0) goto L46
            goto L4b
        L46:
            if (r13 != 0) goto L4e
            if (r2 == 0) goto L4b
            goto L4e
        L4b:
            r13 = 0
            r9 = r13
            goto L84
        L4e:
            if (r13 == 0) goto L52
            r3 = r11
            goto L53
        L52:
            r3 = r12
        L53:
            c0.r r3 = (c0.r) r3
            if (r13 == 0) goto L5e
            c0.t r13 = r3.f2495d
            float[] r13 = r13.a()
            goto L60
        L5e:
            float[] r13 = a0.e.f54u
        L60:
            if (r2 == 0) goto L69
            c0.t r2 = r3.f2495d
            float[] r2 = r2.a()
            goto L6b
        L69:
            float[] r2 = a0.e.f54u
        L6b:
            float[] r0 = new float[r0]
            r3 = r13[r4]
            r5 = r2[r4]
            float r3 = r3 / r5
            r0[r4] = r3
            r3 = r13[r1]
            r4 = r2[r1]
            float r3 = r3 / r4
            r0[r1] = r3
            r1 = 2
            r13 = r13[r1]
            r2 = r2[r1]
            float r13 = r13 / r2
            r0[r1] = r13
            r9 = r0
        L84:
            r4 = r10
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.h.<init>(c0.c, c0.c, int):void");
    }

    public long a(float f7, float f8, float f9, float f10) {
        long e7 = this.f2477b.e(f7, f8, f9);
        float intBitsToFloat = Float.intBitsToFloat((int) (e7 >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (e7 & 4294967295L));
        float g2 = this.f2477b.g(f7, f8, f9);
        float[] fArr = this.f2479d;
        if (fArr != null) {
            intBitsToFloat *= fArr[0];
            intBitsToFloat2 *= fArr[1];
            g2 *= fArr[2];
        }
        float f11 = intBitsToFloat2;
        float f12 = intBitsToFloat;
        return this.f2478c.h(f12, f11, g2, f10, this.f2476a);
    }

    public h(c cVar, c cVar2, c cVar3, c cVar4, float[] fArr) {
        r5.h.f(cVar, "source");
        r5.h.f(cVar2, "destination");
        this.f2476a = cVar2;
        this.f2477b = cVar3;
        this.f2478c = cVar4;
        this.f2479d = fArr;
    }
}
