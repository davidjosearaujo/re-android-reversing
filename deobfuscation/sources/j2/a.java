package j2;

import android.annotation.SuppressLint;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static long f4573a;

    /* renamed from: b */
    public static Method f4574b;

    @SuppressLint({"NewApi"})
    public static boolean a() {
        try {
            if (f4574b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f4574b == null) {
                f4573a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f4574b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f4574b.invoke(null, Long.valueOf(f4573a))).booleanValue();
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
                return false;
            }
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
