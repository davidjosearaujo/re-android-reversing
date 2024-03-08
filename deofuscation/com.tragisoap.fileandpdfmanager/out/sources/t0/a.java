package t0;

import androidx.activity.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f5998b = {18, 20, 17, 15};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f5999c = {65535, 262143, 32767, 8191};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f6000d = {32767, 8191, 65535, 262143};

    /* renamed from: a  reason: collision with root package name */
    public final long f6001a;

    /* renamed from: t0.a$a  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0104a {
        public static int a(int i7) {
            if (i7 < 8191) {
                return 13;
            }
            if (i7 < 32767) {
                return 15;
            }
            if (i7 < 65535) {
                return 16;
            }
            if (i7 < 262143) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i7 + " in Constraints");
        }
    }

    public /* synthetic */ a(long j7) {
        this.f6001a = j7;
    }

    public static final int a(long j7) {
        int i7 = (int) (3 & j7);
        int i8 = ((int) (j7 >> (f5998b[i7] + 31))) & f6000d[i7];
        return i8 == 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i8 - 1;
    }

    public static final int b(long j7) {
        int i7 = ((int) (j7 >> 33)) & f5999c[(int) (3 & j7)];
        return i7 == 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i7 - 1;
    }

    public static final int c(long j7) {
        int i7 = (int) (3 & j7);
        return ((int) (j7 >> f5998b[i7])) & f6000d[i7];
    }

    public static final int d(long j7) {
        return ((int) (j7 >> 2)) & f5999c[(int) (3 & j7)];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f6001a == ((a) obj).f6001a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6001a);
    }

    public final String toString() {
        long j7 = this.f6001a;
        int b2 = b(j7);
        String str = "Infinity";
        String valueOf = b2 == Integer.MAX_VALUE ? str : String.valueOf(b2);
        int a7 = a(j7);
        if (a7 != Integer.MAX_VALUE) {
            str = String.valueOf(a7);
        }
        StringBuilder d7 = h.d("Constraints(minWidth = ");
        d7.append(d(j7));
        d7.append(", maxWidth = ");
        d7.append(valueOf);
        d7.append(", minHeight = ");
        d7.append(c(j7));
        d7.append(", maxHeight = ");
        d7.append(str);
        d7.append(')');
        return d7.toString();
    }
}
