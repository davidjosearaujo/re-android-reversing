package c0;

import a0.e;
import r5.h;
import w5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j extends c {
    public j() {
        super("Generic L*a*b*", b.f2464c, 15);
    }

    @Override // c0.c
    public final float[] a(float[] fArr) {
        float f7 = fArr[0];
        float[] fArr2 = e.f54u;
        float f8 = f7 / fArr2[0];
        float f9 = fArr[1] / fArr2[1];
        float f10 = fArr[2] / fArr2[2];
        float pow = f8 > 0.008856452f ? (float) Math.pow((double) f8, (double) 0.33333334f) : (f8 * 7.787037f) + 0.13793103f;
        float pow2 = f9 > 0.008856452f ? (float) Math.pow((double) f9, (double) 0.33333334f) : (f9 * 7.787037f) + 0.13793103f;
        float pow3 = f10 > 0.008856452f ? (float) Math.pow((double) f10, (double) 0.33333334f) : (f10 * 7.787037f) + 0.13793103f;
        fArr[0] = d.W((116.0f * pow2) - 16.0f, 0.0f, 100.0f);
        fArr[1] = d.W((pow - pow2) * 500.0f, -128.0f, 128.0f);
        fArr[2] = d.W((pow2 - pow3) * 200.0f, -128.0f, 128.0f);
        return fArr;
    }

    @Override // c0.c
    public final float b(int i7) {
        return i7 == 0 ? 100.0f : 128.0f;
    }

    @Override // c0.c
    public final float c(int i7) {
        return i7 == 0 ? 0.0f : -128.0f;
    }

    @Override // c0.c
    public final long e(float f7, float f8, float f9) {
        float W = (d.W(f7, 0.0f, 100.0f) + 16.0f) / 116.0f;
        float W2 = (d.W(f7, -128.0f, 128.0f) * 0.002f) + W;
        float f10 = W2 > 0.20689656f ? W2 * W2 * W2 : (W2 - 0.13793103f) * 0.12841855f;
        float f11 = W > 0.20689656f ? W * W * W : (W - 0.13793103f) * 0.12841855f;
        float[] fArr = e.f54u;
        return (((long) Float.floatToIntBits(f11 * fArr[1])) & 4294967295L) | (((long) Float.floatToIntBits(f10 * fArr[0])) << 32);
    }

    @Override // c0.c
    public final float[] f(float[] fArr) {
        fArr[0] = d.W(fArr[0], 0.0f, 100.0f);
        fArr[1] = d.W(fArr[1], -128.0f, 128.0f);
        float W = d.W(fArr[2], -128.0f, 128.0f);
        fArr[2] = W;
        float f7 = (fArr[0] + 16.0f) / 116.0f;
        float f8 = (fArr[1] * 0.002f) + f7;
        float f9 = f7 - (W * 0.005f);
        float f10 = f8 > 0.20689656f ? f8 * f8 * f8 : (f8 - 0.13793103f) * 0.12841855f;
        float f11 = f7 > 0.20689656f ? f7 * f7 * f7 : (f7 - 0.13793103f) * 0.12841855f;
        float f12 = f9 > 0.20689656f ? f9 * f9 * f9 : (f9 - 0.13793103f) * 0.12841855f;
        float[] fArr2 = e.f54u;
        fArr[0] = f10 * fArr2[0];
        fArr[1] = f11 * fArr2[1];
        fArr[2] = f12 * fArr2[2];
        return fArr;
    }

    @Override // c0.c
    public final float g(float f7, float f8, float f9) {
        float W = ((d.W(f7, 0.0f, 100.0f) + 16.0f) / 116.0f) - (d.W(f9, -128.0f, 128.0f) * 0.005f);
        return (W > 0.20689656f ? W * W * W : 0.12841855f * (W - 0.13793103f)) * e.f54u[2];
    }

    @Override // c0.c
    public final long h(float f7, float f8, float f9, float f10, c cVar) {
        h.f(cVar, "colorSpace");
        float[] fArr = e.f54u;
        float f11 = f7 / fArr[0];
        float f12 = f8 / fArr[1];
        float f13 = f9 / fArr[2];
        float pow = f11 > 0.008856452f ? (float) Math.pow((double) f11, (double) 0.33333334f) : (f11 * 7.787037f) + 0.13793103f;
        float pow2 = f12 > 0.008856452f ? (float) Math.pow((double) f12, (double) 0.33333334f) : (f12 * 7.787037f) + 0.13793103f;
        return e.a(d.W((116.0f * pow2) - 16.0f, 0.0f, 100.0f), d.W((pow - pow2) * 500.0f, -128.0f, 128.0f), d.W((pow2 - (f13 > 0.008856452f ? (float) Math.pow((double) f13, (double) 0.33333334f) : (f13 * 7.787037f) + 0.13793103f)) * 200.0f, -128.0f, 128.0f), f10, cVar);
    }
}
