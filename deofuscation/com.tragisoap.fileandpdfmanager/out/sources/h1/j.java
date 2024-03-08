package h1;

import a0.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class j {

    /* renamed from: k  reason: collision with root package name */
    public static final j f4364k;

    /* renamed from: a  reason: collision with root package name */
    public final float f4365a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4366b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4367c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4368d;
    public final float e;

    /* renamed from: f  reason: collision with root package name */
    public final float f4369f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f4370g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4371h;

    /* renamed from: i  reason: collision with root package name */
    public final float f4372i;

    /* renamed from: j  reason: collision with root package name */
    public final float f4373j;

    static {
        float[] fArr = b.E;
        float F = (float) ((((double) b.F()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.C;
        float f7 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f8 = fArr[1];
        float f9 = fArr3[1] * f8;
        float f10 = fArr[2];
        float f11 = (fArr3[2] * f10) + f9 + (fArr3[0] * f7);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[2] * f10) + (fArr4[1] * f8) + (fArr4[0] * f7);
        float[] fArr5 = fArr2[2];
        float f13 = (f10 * fArr5[2]) + (f8 * fArr5[1]) + (f7 * fArr5[0]);
        float f14 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float exp = (1.0f - (((float) Math.exp((double) (((-F) - 42.0f) / 92.0f))) * 0.2777778f)) * 1.0f;
        double d7 = (double) exp;
        if (d7 > 1.0d) {
            exp = 1.0f;
        } else if (d7 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * F) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (0.1f * f17 * f17 * ((float) Math.cbrt(((double) F) * 5.0d))) + (f16 * F);
        float F2 = b.F() / fArr[1];
        double d8 = (double) F2;
        float sqrt = ((float) Math.sqrt(d8)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d8, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f13)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f11)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f12)) / 100.0d, 0.42d), pow2};
        float f18 = fArr7[0];
        float f19 = fArr7[1];
        f4364k = new j(F2, ((((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f) + (((f18 * 400.0f) / (f18 + 27.13f)) * 2.0f) + ((f19 * 400.0f) / (f19 + 27.13f))) * pow, pow, pow, f14, 1.0f, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public j(float f7, float f8, float f9, float f10, float f11, float f12, float[] fArr, float f13, float f14, float f15) {
        this.f4369f = f7;
        this.f4365a = f8;
        this.f4366b = f9;
        this.f4367c = f10;
        this.f4368d = f11;
        this.e = f12;
        this.f4370g = fArr;
        this.f4371h = f13;
        this.f4372i = f14;
        this.f4373j = f15;
    }
}
