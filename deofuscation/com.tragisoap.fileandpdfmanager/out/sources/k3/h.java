package k3;

import android.os.SystemClock;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final double f4701a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f4702b = 0;

    public static double a(long j7) {
        return ((double) (SystemClock.elapsedRealtimeNanos() - j7)) * f4701a;
    }
}
