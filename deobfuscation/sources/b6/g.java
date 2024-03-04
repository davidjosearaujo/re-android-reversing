package b6;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import f5.d;
import r5.h;

/* loaded from: classes.dex */
public final class g {
    private static volatile Choreographer choreographer;

    static {
        Object a7;
        try {
            a7 = new e(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            a7 = f5.e.a(th);
        }
        if (a7 instanceof d.a) {
            a7 = null;
        }
        f fVar = (f) a7;
    }

    public static final Handler a(Looper looper) {
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        h.d(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }
}
