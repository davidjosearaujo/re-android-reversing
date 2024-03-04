package t0;

import androidx.activity.h;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b */
    public static final int[] f5998b = {18, 20, 17, 15};

    /* renamed from: c */
    public static final int[] f5999c = {65535, 262143, 32767, 8191};

    /* renamed from: d */
    public static final int[] f6000d = {32767, 8191, 65535, 262143};

    /* renamed from: a */
    public final long f6001a;

    /* renamed from: t0.a$a */
    /* loaded from: classes.dex */
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

    public static final int a(long j5) {
        int i7 = (int) (3 & j5);
        int i8 = ((int) (j5 >> (f5998b[i7] + 31))) & f6000d[i7];
        return i8 == 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i8 - 1;
    }

    public static final int b(long j5) {
        int i7 = ((int) (j5 >> 33)) & f5999c[(int) (3 & j5)];
        return i7 == 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i7 - 1;
    }

    public static final int c(long j5) {
        int i7 = (int) (3 & j5);
        return ((int) (j5 >> f5998b[i7])) & f6000d[i7];
    }

    public static final int d(long j5) {
        return ((int) (j5 >> 2)) & f5999c[(int) (3 & j5)];
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f6001a == ((a) obj).f6001a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6001a);
    }

    public final String toString() {
        long j5 = this.f6001a;
        int b2 = b(j5);
        String valueOf = b2 == Integer.MAX_VALUE ? "Infinity" : String.valueOf(b2);
        int a7 = a(j5);
        String valueOf2 = a7 != Integer.MAX_VALUE ? String.valueOf(a7) : "Infinity";
        StringBuilder d7 = h.d("Constraints(minWidth = ");
        d7.append(d(j5));
        d7.append(", maxWidth = ");
        d7.append(valueOf);
        d7.append(", minHeight = ");
        d7.append(c(j5));
        d7.append(", maxHeight = ");
        d7.append(valueOf2);
        d7.append(')');
        return d7.toString();
    }
}
