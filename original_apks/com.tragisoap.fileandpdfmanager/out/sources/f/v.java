package f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class v {

    /* renamed from: d  reason: collision with root package name */
    public static v f4033d;

    /* renamed from: a  reason: collision with root package name */
    public long f4034a;

    /* renamed from: b  reason: collision with root package name */
    public long f4035b;

    /* renamed from: c  reason: collision with root package name */
    public int f4036c;

    public final void a(long j7, double d7, double d8) {
        float f7 = ((float) (j7 - 946728000000L)) / 8.64E7f;
        float f8 = (0.01720197f * f7) + 6.24006f;
        double d9 = (double) f8;
        double sin = (Math.sin((double) (f8 * 3.0f)) * 5.236000106378924E-6d) + (Math.sin((double) (2.0f * f8)) * 3.4906598739326E-4d) + (Math.sin(d9) * 0.03341960161924362d) + d9 + 1.796593063d + 3.141592653589793d;
        double d10 = (-d8) / 360.0d;
        double sin2 = (Math.sin(2.0d * sin) * -0.0069d) + (Math.sin(d9) * 0.0053d) + ((double) (((float) Math.round(((double) (f7 - 9.0E-4f)) - d10)) + 9.0E-4f)) + d10;
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d11 = 0.01745329238474369d * d7;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d11))) / (Math.cos(asin) * Math.cos(d11));
        if (sin3 >= 1.0d) {
            this.f4036c = 1;
        } else if (sin3 <= -1.0d) {
            this.f4036c = 0;
        } else {
            double acos = (double) ((float) (Math.acos(sin3) / 6.283185307179586d));
            this.f4034a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f4035b = round;
            if (round >= j7 || this.f4034a <= j7) {
                this.f4036c = 1;
                return;
            } else {
                this.f4036c = 0;
                return;
            }
        }
        this.f4034a = -1;
        this.f4035b = -1;
    }
}
