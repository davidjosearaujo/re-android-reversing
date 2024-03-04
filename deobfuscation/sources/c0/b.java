package c0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static final long f2462a;

    /* renamed from: b */
    public static final long f2463b;

    /* renamed from: c */
    public static final long f2464c;

    /* renamed from: d */
    public static final long f2465d;
    public static final /* synthetic */ int e = 0;

    static {
        long j5 = 3;
        long j7 = j5 << 32;
        f2462a = (0 & 4294967295L) | j7;
        f2463b = (1 & 4294967295L) | j7;
        f2464c = j7 | (2 & 4294967295L);
        f2465d = (j5 & 4294967295L) | (4 << 32);
    }

    public static final boolean a(long j5, long j7) {
        return j5 == j7;
    }
}
