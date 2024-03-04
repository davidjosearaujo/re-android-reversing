package f;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: d */
    public static v f4033d;

    /* renamed from: a */
    public long f4034a;

    /* renamed from: b */
    public long f4035b;

    /* renamed from: c */
    public int f4036c;

    public final void a(long j5, double d7, double d8) {
        float f7;
        float f8;
        double d9;
        double d10 = (0.01720197f * (((float) (j5 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(f8 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * f8) * 3.4906598739326E-4d) + (Math.sin(d10) * 0.03341960161924362d) + d10 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d10) * 0.0053d) + ((float) Math.round((f7 - 9.0E-4f) - d9)) + 9.0E-4f + ((-d8) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d11 = 0.01745329238474369d * d7;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d11))) / (Math.cos(asin) * Math.cos(d11));
        if (sin3 >= 1.0d) {
            this.f4036c = 1;
        } else if (sin3 > -1.0d) {
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f4034a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f4035b = round;
            if (round >= j5 || this.f4034a <= j5) {
                this.f4036c = 1;
                return;
            } else {
                this.f4036c = 0;
                return;
            }
        } else {
            this.f4036c = 0;
        }
        this.f4034a = -1L;
        this.f4035b = -1L;
    }
}
