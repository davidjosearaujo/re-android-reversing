package i1;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final ThreadLocal<double[]> f4461a = new ThreadLocal<>();

    public static int a(double d7, double d8, double d9) {
        double d10 = (((-0.4986d) * d9) + (((-1.5372d) * d8) + (3.2406d * d7))) / 100.0d;
        double d11 = ((0.0415d * d9) + ((1.8758d * d8) + ((-0.9689d) * d7))) / 100.0d;
        double d12 = ((1.057d * d9) + (((-0.204d) * d8) + (0.0557d * d7))) / 100.0d;
        double pow = d10 > 0.0031308d ? (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d : d10 * 12.92d;
        double pow2 = d11 > 0.0031308d ? (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d : d11 * 12.92d;
        double pow3 = d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d;
        int round = (int) Math.round(pow * 255.0d);
        int min = round < 0 ? 0 : Math.min(round, 255);
        int round2 = (int) Math.round(pow2 * 255.0d);
        int min2 = round2 < 0 ? 0 : Math.min(round2, 255);
        int round3 = (int) Math.round(pow3 * 255.0d);
        return Color.rgb(min, min2, round3 >= 0 ? Math.min(round3, 255) : 0);
    }

    public static int b(int i7, int i8) {
        int i9;
        int i10;
        int alpha = Color.alpha(i8);
        int alpha2 = Color.alpha(i7);
        int i11 = 255 - alpha2;
        int i12 = 255 - (((255 - alpha) * i11) / 255);
        int red = Color.red(i7);
        int red2 = Color.red(i8);
        int i13 = 0;
        if (i12 == 0) {
            i9 = 0;
        } else {
            i9 = (((red2 * alpha) * i11) + ((red * 255) * alpha2)) / (i12 * 255);
        }
        int green = Color.green(i7);
        int green2 = Color.green(i8);
        if (i12 == 0) {
            i10 = 0;
        } else {
            i10 = (((green2 * alpha) * i11) + ((green * 255) * alpha2)) / (i12 * 255);
        }
        int blue = Color.blue(i7);
        int blue2 = Color.blue(i8);
        if (i12 != 0) {
            i13 = (((blue2 * alpha) * i11) + ((blue * 255) * alpha2)) / (i12 * 255);
        }
        return Color.argb(i12, i9, i10, i13);
    }

    public static int c(int i7, int i8) {
        if (i8 < 0 || i8 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i7 & 16777215) | (i8 << 24);
    }
}
