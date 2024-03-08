package h1;

import a0.b;
import android.graphics.Color;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final float f4333a;

    /* renamed from: b  reason: collision with root package name */
    public final float f4334b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4335c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4336d;
    public final float e;

    /* renamed from: f  reason: collision with root package name */
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
        j jVar = j.f4364k;
        float o6 = b.o(Color.red(i7));
        float o7 = b.o(Color.green(i7));
        float o8 = b.o(Color.blue(i7));
        float[][] fArr = b.F;
        float[] fArr2 = fArr[0];
        float f7 = (fArr2[2] * o8) + (fArr2[1] * o7) + (fArr2[0] * o6);
        float[] fArr3 = fArr[1];
        float f8 = (fArr3[2] * o8) + (fArr3[1] * o7) + (fArr3[0] * o6);
        float[] fArr4 = fArr[2];
        float f9 = (o8 * fArr4[2]) + (o7 * fArr4[1]) + (o6 * fArr4[0]);
        float[][] fArr5 = b.C;
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
        float pow = (float) Math.pow(((double) (Math.abs(f15) * jVar.f4371h)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (Math.abs(f16) * jVar.f4371h)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (Math.abs(f17) * jVar.f4371h)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f15) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f16) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f17) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d7 = (double) signum3;
        float f18 = ((float) (((((double) signum2) * -12.0d) + (((double) signum) * 11.0d)) + d7)) / 11.0f;
        float f19 = ((float) (((double) (signum + signum2)) - (d7 * 2.0d))) / 9.0f;
        float f20 = signum2 * 20.0f;
        float f21 = ((21.0f * signum3) + ((signum * 20.0f) + f20)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f19, (double) f18)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f22 * jVar.f4366b) / jVar.f4365a), (double) (jVar.f4368d * jVar.f4373j))) * 100.0f;
        Math.sqrt((double) (pow4 / 100.0f));
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) jVar.f4369f), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) (((double) atan2) < 20.14d ? 360.0f + atan2 : atan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.e) * jVar.f4367c) * ((float) Math.sqrt((double) ((f19 * f19) + (f18 * f18))))) / (f21 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        Math.sqrt((double) ((pow5 * jVar.f4368d) / (jVar.f4365a + 4.0f)));
        float f24 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((jVar.f4372i * sqrt * 0.0228f) + 1.0f))) * 43.85965f;
        double d8 = (double) f23;
        return new a(atan2, sqrt, pow4, f24, ((float) Math.cos(d8)) * log, log * ((float) Math.sin(d8)));
    }

    public static a b(float f7, float f8, float f9) {
        j jVar = j.f4364k;
        float f10 = jVar.f4368d;
        double d7 = ((double) f7) / 100.0d;
        Math.sqrt(d7);
        Math.sqrt((double) (((f8 / ((float) Math.sqrt(d7))) * jVar.f4368d) / (jVar.f4365a + 4.0f)));
        float f11 = (1.7f * f7) / ((0.007f * f7) + 1.0f);
        float log = ((float) Math.log((((double) (jVar.f4372i * f8)) * 0.0228d) + 1.0d)) * 43.85965f;
        double d8 = (double) ((3.1415927f * f9) / 180.0f);
        return new a(f9, f8, f7, f11, log * ((float) Math.cos(d8)), log * ((float) Math.sin(d8)));
    }

    public final int c(j jVar) {
        float f7;
        float f8 = this.f4334b;
        if (((double) f8) != 0.0d) {
            double d7 = (double) this.f4335c;
            if (d7 != 0.0d) {
                f7 = f8 / ((float) Math.sqrt(d7 / 100.0d));
                float pow = (float) Math.pow(((double) f7) / Math.pow(1.64d - Math.pow(0.29d, (double) jVar.f4369f), 0.73d), 1.1111111111111112d);
                double d8 = (double) ((this.f4333a * 3.1415927f) / 180.0f);
                float pow2 = jVar.f4365a * ((float) Math.pow(((double) this.f4335c) / 100.0d, (1.0d / ((double) jVar.f4368d)) / ((double) jVar.f4373j)));
                float cos = ((float) (Math.cos(2.0d + d8) + 3.8d)) * 0.25f * 3846.1538f * jVar.e * jVar.f4367c;
                float f9 = pow2 / jVar.f4366b;
                float sin = (float) Math.sin(d8);
                float cos2 = (float) Math.cos(d8);
                float f10 = 11.0f * pow * cos2;
                float f11 = (((0.305f + f9) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (f10 + (cos * 23.0f)));
                float f12 = cos2 * f11;
                float f13 = f11 * sin;
                float f14 = f9 * 460.0f;
                float f15 = ((288.0f * f13) + ((451.0f * f12) + f14)) / 1403.0f;
                float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
                float f17 = ((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15))));
                float signum = (100.0f / jVar.f4371h) * Math.signum(f15) * ((float) Math.pow((double) max, 2.380952380952381d));
                float signum2 = (100.0f / jVar.f4371h) * Math.signum(f16) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
                float signum3 = (100.0f / jVar.f4371h) * Math.signum(f17) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
                float[] fArr = jVar.f4370g;
                float f18 = signum / fArr[0];
                float f19 = signum2 / fArr[1];
                float f20 = signum3 / fArr[2];
                float[][] fArr2 = b.D;
                float[] fArr3 = fArr2[0];
                float f21 = fArr3[1] * f19;
                float f22 = (fArr3[2] * f20) + f21 + (fArr3[0] * f18);
                float[] fArr4 = fArr2[1];
                float f23 = fArr4[1] * f19;
                float f24 = fArr4[2] * f20;
                float[] fArr5 = fArr2[2];
                float f25 = f18 * fArr5[0];
                return i1.a.a((double) f22, (double) (f24 + f23 + (fArr4[0] * f18)), (double) ((f20 * fArr5[2]) + (f19 * fArr5[1]) + f25));
            }
        }
        f7 = 0.0f;
        float pow3 = (float) Math.pow(((double) f7) / Math.pow(1.64d - Math.pow(0.29d, (double) jVar.f4369f), 0.73d), 1.1111111111111112d);
        double d82 = (double) ((this.f4333a * 3.1415927f) / 180.0f);
        float pow22 = jVar.f4365a * ((float) Math.pow(((double) this.f4335c) / 100.0d, (1.0d / ((double) jVar.f4368d)) / ((double) jVar.f4373j)));
        float cos3 = ((float) (Math.cos(2.0d + d82) + 3.8d)) * 0.25f * 3846.1538f * jVar.e * jVar.f4367c;
        float f92 = pow22 / jVar.f4366b;
        float sin2 = (float) Math.sin(d82);
        float cos22 = (float) Math.cos(d82);
        float f102 = 11.0f * pow3 * cos22;
        float f112 = (((0.305f + f92) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (f102 + (cos3 * 23.0f)));
        float f122 = cos22 * f112;
        float f132 = f112 * sin2;
        float f142 = f92 * 460.0f;
        float f152 = ((288.0f * f132) + ((451.0f * f122) + f142)) / 1403.0f;
        float f162 = ((f142 - (891.0f * f122)) - (261.0f * f132)) / 1403.0f;
        float f172 = ((f142 - (f122 * 220.0f)) - (f132 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (((double) Math.abs(f152)) * 27.13d) / (400.0d - ((double) Math.abs(f152))));
        float signum4 = (100.0f / jVar.f4371h) * Math.signum(f152) * ((float) Math.pow((double) max2, 2.380952380952381d));
        float signum22 = (100.0f / jVar.f4371h) * Math.signum(f162) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f162)) * 27.13d) / (400.0d - ((double) Math.abs(f162))))), 2.380952380952381d));
        float signum32 = (100.0f / jVar.f4371h) * Math.signum(f172) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f172)) * 27.13d) / (400.0d - ((double) Math.abs(f172))))), 2.380952380952381d));
        float[] fArr6 = jVar.f4370g;
        float f182 = signum4 / fArr6[0];
        float f192 = signum22 / fArr6[1];
        float f202 = signum32 / fArr6[2];
        float[][] fArr22 = b.D;
        float[] fArr32 = fArr22[0];
        float f212 = fArr32[1] * f192;
        float f222 = (fArr32[2] * f202) + f212 + (fArr32[0] * f182);
        float[] fArr42 = fArr22[1];
        float f232 = fArr42[1] * f192;
        float f242 = fArr42[2] * f202;
        float[] fArr52 = fArr22[2];
        float f252 = f182 * fArr52[0];
        return i1.a.a((double) f222, (double) (f242 + f232 + (fArr42[0] * f182)), (double) ((f202 * fArr52[2]) + (f192 * fArr52[1]) + f252));
    }
}
