package c0;

import a0.e;
import c0.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {
    public static c a(c cVar) {
        t tVar = e.f52r;
        a.C0028a aVar = a.f2460b;
        h.f(cVar, "<this>");
        if (!b.a(cVar.f2467b, b.f2462a)) {
            return cVar;
        }
        r rVar = (r) cVar;
        if (c(rVar.f2495d, tVar)) {
            return cVar;
        }
        return new r(rVar.f2466a, rVar.f2498h, tVar, e(b(aVar.f2461a, rVar.f2495d.a(), tVar.a()), rVar.f2499i), rVar.f2501k, rVar.m, rVar.e, rVar.f2496f, rVar.f2497g, -1);
    }

    public static final float[] b(float[] fArr, float[] fArr2, float[] fArr3) {
        h.f(fArr, "matrix");
        g(fArr, fArr2);
        g(fArr, fArr3);
        return e(d(fArr), f(new float[]{fArr3[0] / fArr2[0], fArr3[1] / fArr2[1], fArr3[2] / fArr2[2]}, fArr));
    }

    public static final boolean c(t tVar, t tVar2) {
        h.f(tVar, "a");
        h.f(tVar2, "b");
        if (tVar == tVar2) {
            return true;
        }
        return Math.abs(tVar.f2511a - tVar2.f2511a) < 0.001f && Math.abs(tVar.f2512b - tVar2.f2512b) < 0.001f;
    }

    public static final float[] d(float[] fArr) {
        h.f(fArr, "m");
        float f7 = fArr[0];
        float f8 = fArr[3];
        float f9 = fArr[6];
        float f10 = fArr[1];
        float f11 = fArr[4];
        float f12 = fArr[7];
        float f13 = fArr[2];
        float f14 = fArr[5];
        float f15 = fArr[8];
        float f16 = (f11 * f15) - (f12 * f14);
        float f17 = (f12 * f13) - (f10 * f15);
        float f18 = (f10 * f14) - (f11 * f13);
        float f19 = (f9 * f18) + (f8 * f17) + (f7 * f16);
        float[] fArr2 = new float[fArr.length];
        fArr2[0] = f16 / f19;
        fArr2[1] = f17 / f19;
        fArr2[2] = f18 / f19;
        fArr2[3] = ((f9 * f14) - (f8 * f15)) / f19;
        fArr2[4] = ((f15 * f7) - (f9 * f13)) / f19;
        fArr2[5] = ((f13 * f8) - (f14 * f7)) / f19;
        fArr2[6] = ((f8 * f12) - (f9 * f11)) / f19;
        fArr2[7] = ((f9 * f10) - (f12 * f7)) / f19;
        fArr2[8] = ((f7 * f11) - (f8 * f10)) / f19;
        return fArr2;
    }

    public static final float[] e(float[] fArr, float[] fArr2) {
        h.f(fArr, "lhs");
        h.f(fArr2, "rhs");
        float f7 = fArr[3];
        float f8 = fArr2[1];
        float f9 = f7 * f8;
        float f10 = fArr[6];
        float f11 = fArr2[2];
        float f12 = f10 * f11;
        float f13 = fArr[1];
        float f14 = fArr2[0];
        float f15 = fArr[4];
        float f16 = f8 * f15;
        float f17 = fArr[7];
        float f18 = f17 * f11;
        float f19 = fArr[5];
        float f20 = fArr2[1] * f19;
        float f21 = fArr[8];
        float f22 = f11 * f21;
        float f23 = fArr[0];
        float f24 = fArr2[4];
        float f25 = (f7 * f24) + (fArr2[3] * f23);
        float f26 = fArr2[5];
        float f27 = fArr[1];
        float f28 = fArr2[3];
        float f29 = f15 * f24;
        float f30 = fArr[2];
        float f31 = f19 * fArr2[4];
        float f32 = f23 * fArr2[6];
        float f33 = fArr[3];
        float f34 = fArr2[7];
        float f35 = (f33 * f34) + f32;
        float f36 = fArr2[8];
        float f37 = fArr2[6];
        return new float[]{f12 + f9 + (fArr[0] * fArr2[0]), f18 + f16 + (f13 * f14), f22 + f20 + (fArr[2] * f14), (f10 * f26) + f25, (f17 * f26) + f29 + (f27 * f28), (f26 * f21) + f31 + (f28 * f30), (f10 * f36) + f35, (f17 * f36) + (fArr[4] * f34) + (f27 * f37), (f21 * f36) + (fArr[5] * fArr2[7]) + (f30 * f37)};
    }

    public static final float[] f(float[] fArr, float[] fArr2) {
        h.f(fArr2, "rhs");
        float f7 = fArr[0];
        float f8 = fArr[1];
        float f9 = fArr[2];
        return new float[]{fArr[0] * fArr2[0], fArr[1] * fArr2[1], fArr[2] * fArr2[2], fArr2[3] * f7, fArr2[4] * f8, fArr2[5] * f9, f7 * fArr2[6], f8 * fArr2[7], f9 * fArr2[8]};
    }

    public static final void g(float[] fArr, float[] fArr2) {
        h.f(fArr, "lhs");
        float f7 = fArr2[0];
        float f8 = fArr2[1];
        float f9 = fArr2[2];
        fArr2[0] = (fArr[6] * f9) + (fArr[3] * f8) + (fArr[0] * f7);
        fArr2[1] = (fArr[7] * f9) + (fArr[4] * f8) + (fArr[1] * f7);
        float f10 = fArr[2] * f7;
        fArr2[2] = (fArr[8] * f9) + (fArr[5] * f8) + f10;
    }

    public static final float h(float[] fArr, float f7, float f8, float f9) {
        h.f(fArr, "lhs");
        float f10 = fArr[0] * f7;
        return (fArr[6] * f9) + (fArr[3] * f8) + f10;
    }

    public static final float i(float[] fArr, float f7, float f8, float f9) {
        h.f(fArr, "lhs");
        float f10 = fArr[1] * f7;
        return (fArr[7] * f9) + (fArr[4] * f8) + f10;
    }

    public static final float j(float[] fArr, float f7, float f8, float f9) {
        h.f(fArr, "lhs");
        float f10 = fArr[2] * f7;
        return (fArr[8] * f9) + (fArr[5] * f8) + f10;
    }
}
