package g6;

import f6.u;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public static final String f4319a;

    /* renamed from: b */
    public static final long f4320b;

    /* renamed from: c */
    public static final int f4321c;

    /* renamed from: d */
    public static final int f4322d;
    public static final long e;

    /* renamed from: f */
    public static e f4323f;

    /* renamed from: g */
    public static final i f4324g;

    /* renamed from: h */
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
        f4320b = q2.a.Q("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i8 = u.f4181a;
        if (i8 < 2) {
            i8 = 2;
        }
        f4321c = q2.a.R("kotlinx.coroutines.scheduler.core.pool.size", i8, 1, 0, 8);
        f4322d = q2.a.R("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        e = TimeUnit.SECONDS.toNanos(q2.a.Q("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f4323f = e.f4313f;
        f4324g = new i(0);
        f4325h = new i(1);
    }
}
