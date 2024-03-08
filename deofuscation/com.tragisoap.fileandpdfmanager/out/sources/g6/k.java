package g6;

import f6.u;
import java.util.concurrent.TimeUnit;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4319a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f4320b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4321c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4322d;
    public static final long e;

    /* renamed from: f  reason: collision with root package name */
    public static e f4323f;

    /* renamed from: g  reason: collision with root package name */
    public static final i f4324g;

    /* renamed from: h  reason: collision with root package name */
    public static final i f4325h;

    static {
        String str;
        int i7 = u.f4181a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f4319a = str;
        f4320b = a.Q("kotlinx.coroutines.scheduler.resolution.ns", 100000, 1, Long.MAX_VALUE);
        int i8 = u.f4181a;
        if (i8 < 2) {
            i8 = 2;
        }
        f4321c = a.R("kotlinx.coroutines.scheduler.core.pool.size", i8, 1, 0, 8);
        f4322d = a.R("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        e = TimeUnit.SECONDS.toNanos(a.Q("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 1, Long.MAX_VALUE));
        f4323f = e.f4313f;
        f4324g = new i(0);
        f4325h = new i(1);
    }
}
