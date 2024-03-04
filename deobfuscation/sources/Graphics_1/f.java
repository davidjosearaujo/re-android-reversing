package Graphics_1;

import a0.e;

/* renamed from: b0.f */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    public static final long f2340a = e.c(4278190080L);

    /* renamed from: b */
    public static final long f2341b;

    /* renamed from: c */
    public static final long f2342c;

    /* renamed from: d */
    public static final /* synthetic */ int f2343d = 0;

    static {
        e.c(4282664004L);
        e.c(4287137928L);
        e.c(4291611852L);
        e.c(4294967295L);
        f2341b = e.c(4294901760L);
        e.c(4278255360L);
        f2342c = e.c(4278190335L);
        e.c(4294967040L);
        e.c(4278255615L);
        e.c(4294902015L);
        e.a(0.0f, 0.0f, 0.0f, 0.0f, c0.f.f2473d);
    }

    public static final float a(long j7) {
        float I;
        float f7;
        if ((63 & j7) == 0) {
            I = (float) e.I((j7 >>> 56) & 255);
            f7 = 255.0f;
        } else {
            I = (float) e.I((j7 >>> 6) & 1023);
            f7 = 1023.0f;
        }
        return I / f7;
    }

    public static final float b(long j7) {
        return (63 & j7) == 0 ? ((float) e.I((j7 >>> 32) & 255)) / 255.0f : MathOperations.math_2((short) ((j7 >>> 16) & 65535));
    }

    public static final float c(long j7) {
        return (63 & j7) == 0 ? ((float) e.I((j7 >>> 40) & 255)) / 255.0f : MathOperations.math_2((short) ((j7 >>> 32) & 65535));
    }

    public static final float d(long j7) {
        int i7 = ((63 & j7) > 0L ? 1 : ((63 & j7) == 0L ? 0 : -1));
        long j8 = j7 >>> 48;
        return i7 == 0 ? ((float) e.I(j8 & 255)) / 255.0f : MathOperations.math_2((short) (j8 & 65535));
    }
}
