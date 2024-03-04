package h1;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final float f4333a;

    /* renamed from: b */
    public final float f4334b;

    /* renamed from: c */
    public final float f4335c;

    /* renamed from: d */
    public final float f4336d;
    public final float e;

    /* renamed from: f */
    public final float f4337f;

    public a(float f7, float f8, float f9, float f10, float f11, float f12) {
        this.f4333a = f7;
        this.f4334b = f8;
        this.f4335c = f9;
        this.f4336d = f10;
        this.e = f11;
        this.f4337f = f12;
    }

    public static a a(int i7) {
        float pow;
        j jVar = j.f4364k;
        float o6 = a0.b.o(Color.red(i7));
        float o7 = a0.b.o(Color.green(i7));
        float o8 = a0.b.o(Color.blue(i7));
        float[][] fArr = a0.b.F;
        float[] fArr2 = fArr[0];
        float f7 = (fArr2[2] * o8) + (fArr2[1] * o7) + (fArr2[0] * o6);
        float[] fArr3 = fArr[1];
        float f8 = (fArr3[2] * o8) + (fArr3[1] * o7) + (fArr3[0] * o6);
        float[] fArr4 = fArr[2];
        float f9 = (o8 * fArr4[2]) + (o7 * fArr4[1]) + (o6 * fArr4[0]);
        float[][] fArr5 = a0.b.C;
        float[] fArr6 = fArr5[0];
        float f10 = (fArr6[2] * f9) + (fArr6[1] * f8) + (fArr6[0] * f7);
        float[] fArr7 = fArr5[1];
        float f11 = fArr7[1] * f8;
        float f12 = fArr7[2] * f9;
        float[] fArr8 = fArr5[2];
        float f13 = f7 * fArr8[0];
        float f14 = f9 * fArr8[2];
        float[] fArr9 = jVar.f4370g;
        float f15 = fArr9[0] * f10;
        float f16 = fArr9[1] * (f12 + f11 + (fArr7[0] * f7));
        float f17 = fArr9[2] * (f14 + (f8 * fArr8[1]) + f13);
        float pow2 = (float) Math.pow((Math.abs(f15) * jVar.f4371h) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f16) * jVar.f4371h) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((Math.abs(f17) * jVar.f4371h) / 100.0d, 0.42d);
        float signum = ((Math.signum(f15) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f16) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f17) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d7 = signum3;
        float f18 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d7)) / 11.0f;
        float f19 = ((float) ((signum + signum2) - (d7 * 2.0d))) / 9.0f;
        float f20 = signum2 * 20.0f;
        float f21 = ((21.0f * signum3) + ((signum * 20.0f) + f20)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f19, f18)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = atan2;
        float f24 = (3.1415927f * f23) / 180.0f;
        float pow5 = ((float) Math.pow((f22 * jVar.f4366b) / jVar.f4365a, jVar.f4368d * jVar.f4373j)) * 100.0f;
        Math.sqrt(pow5 / 100.0f);
        float sqrt = ((float) Math.sqrt(pow5 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, jVar.f4369f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f23) < 20.14d ? 360.0f + f23 : f23) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.e) * jVar.f4367c) * ((float) Math.sqrt((f19 * f19) + (f18 * f18)))) / (f21 + 0.305f), 0.9d));
        Math.sqrt((pow * jVar.f4368d) / (jVar.f4365a + 4.0f));
        float f25 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((jVar.f4372i * sqrt * 0.0228f) + 1.0f)) * 43.85965f;
        double d8 = f24;
        return new a(f23, sqrt, pow5, f25, ((float) Math.cos(d8)) * log, log * ((float) Math.sin(d8)));
    }

    public static a b(float f7, float f8, float f9) {
        j jVar;
        double d7;
        float f10 = j.f4364k.f4368d;
        Math.sqrt(f7 / 100.0d);
        Math.sqrt(((f8 / ((float) Math.sqrt(d7))) * jVar.f4368d) / (jVar.f4365a + 4.0f));
        float f11 = (1.7f * f7) / ((0.007f * f7) + 1.0f);
        float log = ((float) Math.log((jVar.f4372i * f8 * 0.0228d) + 1.0d)) * 43.85965f;
        double d8 = (3.1415927f * f9) / 180.0f;
        return new a(f9, f8, f7, f11, log * ((float) Math.cos(d8)), log * ((float) Math.sin(d8)));
    }

    public final int c(j jVar) {
        float f7;
        float[] fArr;
        float f8 = this.f4334b;
        if (f8 != 0.0d) {
            double d7 = this.f4335c;
            if (d7 != 0.0d) {
                f7 = f8 / ((float) Math.sqrt(d7 / 100.0d));
                float pow = (float) Math.pow(f7 / Math.pow(1.64d - Math.pow(0.29d, jVar.f4369f), 0.73d), 1.1111111111111112d);
                double d8 = (this.f4333a * 3.1415927f) / 180.0f;
                float pow2 = jVar.f4365a * ((float) Math.pow(this.f4335c / 100.0d, (1.0d / jVar.f4368d) / jVar.f4373j));
                float cos = ((float) (Math.cos(2.0d + d8) + 3.8d)) * 0.25f * 3846.1538f * jVar.e * jVar.f4367c;
                float f9 = pow2 / jVar.f4366b;
                float sin = (float) Math.sin(d8);
                float cos2 = (float) Math.cos(d8);
                float f10 = (((0.305f + f9) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (cos * 23.0f)));
                float f11 = cos2 * f10;
                float f12 = f10 * sin;
                float f13 = f9 * 460.0f;
                float f14 = ((288.0f * f12) + ((451.0f * f11) + f13)) / 1403.0f;
                float f15 = ((f13 - (891.0f * f11)) - (261.0f * f12)) / 1403.0f;
                float f16 = ((f13 - (f11 * 220.0f)) - (f12 * 6300.0f)) / 1403.0f;
                float signum = (100.0f / jVar.f4371h) * Math.signum(f14) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
                float signum2 = (100.0f / jVar.f4371h) * Math.signum(f15) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
                float signum3 = (100.0f / jVar.f4371h) * Math.signum(f16) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f16) * 27.13d) / (400.0d - Math.abs(f16))), 2.380952380952381d));
                float[] fArr2 = jVar.f4370g;
                float f17 = signum / fArr2[0];
                float f18 = signum2 / fArr2[1];
                float f19 = signum3 / fArr2[2];
                float[][] fArr3 = a0.b.D;
                float[] fArr4 = fArr3[0];
                float f20 = (fArr4[2] * f19) + (fArr4[1] * f18) + (fArr4[0] * f17);
                float[] fArr5 = fArr3[1];
                float f21 = fArr5[1] * f18;
                float f22 = fArr5[2] * f19;
                float f23 = f17 * fArr3[2][0];
                return i1.a.a(f20, f22 + f21 + (fArr5[0] * f17), (f19 * fArr[2]) + (f18 * fArr[1]) + f23);
            }
        }
        f7 = 0.0f;
        float pow3 = (float) Math.pow(f7 / Math.pow(1.64d - Math.pow(0.29d, jVar.f4369f), 0.73d), 1.1111111111111112d);
        double d82 = (this.f4333a * 3.1415927f) / 180.0f;
        float pow22 = jVar.f4365a * ((float) Math.pow(this.f4335c / 100.0d, (1.0d / jVar.f4368d) / jVar.f4373j));
        float cos3 = ((float) (Math.cos(2.0d + d82) + 3.8d)) * 0.25f * 3846.1538f * jVar.e * jVar.f4367c;
        float f92 = pow22 / jVar.f4366b;
        float sin2 = (float) Math.sin(d82);
        float cos22 = (float) Math.cos(d82);
        float f102 = (((0.305f + f92) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (((11.0f * pow3) * cos22) + (cos3 * 23.0f)));
        float f112 = cos22 * f102;
        float f122 = f102 * sin2;
        float f132 = f92 * 460.0f;
        float f142 = ((288.0f * f122) + ((451.0f * f112) + f132)) / 1403.0f;
        float f152 = ((f132 - (891.0f * f112)) - (261.0f * f122)) / 1403.0f;
        float f162 = ((f132 - (f112 * 220.0f)) - (f122 * 6300.0f)) / 1403.0f;
        float signum4 = (100.0f / jVar.f4371h) * Math.signum(f142) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f142) * 27.13d) / (400.0d - Math.abs(f142))), 2.380952380952381d));
        float signum22 = (100.0f / jVar.f4371h) * Math.signum(f152) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f152) * 27.13d) / (400.0d - Math.abs(f152))), 2.380952380952381d));
        float signum32 = (100.0f / jVar.f4371h) * Math.signum(f162) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f162) * 27.13d) / (400.0d - Math.abs(f162))), 2.380952380952381d));
        float[] fArr22 = jVar.f4370g;
        float f172 = signum4 / fArr22[0];
        float f182 = signum22 / fArr22[1];
        float f192 = signum32 / fArr22[2];
        float[][] fArr32 = a0.b.D;
        float[] fArr42 = fArr32[0];
        float f202 = (fArr42[2] * f192) + (fArr42[1] * f182) + (fArr42[0] * f172);
        float[] fArr52 = fArr32[1];
        float f212 = fArr52[1] * f182;
        float f222 = fArr52[2] * f192;
        float f232 = f172 * fArr32[2][0];
        return i1.a.a(f202, f222 + f212 + (fArr52[0] * f172), (f192 * fArr[2]) + (f182 * fArr[1]) + f232);
    }
}
