package a0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final long f30a = e.d(Float.NaN, Float.NaN);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f31b = 0;

    static {
        e.d(0.0f, 0.0f);
    }

    public static final float a(long j7) {
        if (j7 != f30a) {
            return Float.intBitsToFloat((int) (j7 & 4294967295L));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    public static final float b(long j7) {
        if (j7 != f30a) {
            return Float.intBitsToFloat((int) (j7 >> 32));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }
}
