package k3;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a */
    public static final double f4701a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: b */
    public static final /* synthetic */ int f4702b = 0;

    public static double a(long j5) {
        return (SystemClock.elapsedRealtimeNanos() - j5) * f4701a;
    }
}
