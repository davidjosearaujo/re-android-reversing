package a0;

import androidx.activity.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a */
    public static final long f0a = b.a(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);

    /* renamed from: b */
    public static final long f1b = b.a(Float.NaN, Float.NaN);

    /* renamed from: c */
    public static final /* synthetic */ int f2c = 0;

    static {
        b.a(0.0f, 0.0f);
    }

    public static final boolean a(long j7, long j8) {
        return j7 == j8;
    }

    public static final float b(long j7) {
        if (j7 != f1b) {
            return Float.intBitsToFloat((int) (j7 >> 32));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    public static final float c(long j7) {
        if (j7 != f1b) {
            return Float.intBitsToFloat((int) (j7 & 4294967295L));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    public static String d(long j7) {
        if (!(j7 != f1b)) {
            return "Offset.Unspecified";
        }
        StringBuilder d7 = h.d("Offset(");
        d7.append(e.H(b(j7)));
        d7.append(", ");
        d7.append(e.H(c(j7)));
        d7.append(')');
        return d7.toString();
    }
}
