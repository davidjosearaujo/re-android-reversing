package f5;

import f5.d;
import r5.h;

/* loaded from: classes.dex */
public final class e {
    public static final d.a a(Throwable th) {
        h.f(th, "exception");
        return new d.a(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof d.a) {
            throw ((d.a) obj).f4137f;
        }
    }
}
