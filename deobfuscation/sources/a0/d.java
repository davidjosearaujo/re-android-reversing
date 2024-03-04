package a0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static final long f30a;

    /* renamed from: b */
    public static final /* synthetic */ int f31b = 0;

    static {
        e.d(0.0f, 0.0f);
        f30a = e.d(Float.NaN, Float.NaN);
    }

    public static final float a(long j5) {
        if (j5 != f30a) {
            return Float.intBitsToFloat((int) (j5 & 4294967295L));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    public static final float b(long j5) {
        if (j5 != f30a) {
            return Float.intBitsToFloat((int) (j5 >> 32));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }
}
