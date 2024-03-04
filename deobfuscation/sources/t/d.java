package t;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public final int f5994a;

    /* renamed from: b */
    public final long[] f5995b;

    /* renamed from: c */
    public final Object[] f5996c;

    public d(int i7, long[] jArr, Object[] objArr) {
        this.f5994a = i7;
        this.f5995b = jArr;
        this.f5996c = objArr;
    }

    public final int a(long j5) {
        int i7 = this.f5994a - 1;
        if (i7 != -1) {
            int i8 = 0;
            if (i7 == 0) {
                long j7 = this.f5995b[0];
                if (j7 == j5) {
                    return 0;
                }
                return j7 > j5 ? -2 : -1;
            }
            while (i8 <= i7) {
                int i9 = (i8 + i7) >>> 1;
                int i10 = ((this.f5995b[i9] - j5) > 0L ? 1 : ((this.f5995b[i9] - j5) == 0L ? 0 : -1));
                if (i10 < 0) {
                    i8 = i9 + 1;
                } else if (i10 <= 0) {
                    return i9;
                } else {
                    i7 = i9 - 1;
                }
            }
            return -(i8 + 1);
        }
        return -1;
    }
}
