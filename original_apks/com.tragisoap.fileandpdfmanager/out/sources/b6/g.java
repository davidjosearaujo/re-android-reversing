package b6;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import f5.d;
import f5.e;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        try {
            obj = new e(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            obj = e.a(th);
        }
        if (obj instanceof d.a) {
            obj = null;
        }
        f fVar = (f) obj;
    }

    public static final Handler a(Looper looper) {
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        h.d(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }
}
