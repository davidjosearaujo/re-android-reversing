package b5;

import java.io.IOException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class n extends Exception {

    /* renamed from: g */
    public static final Method f2436g;

    /* renamed from: f */
    public IOException f2437f;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            method = null;
        }
        f2436g = method;
    }

    public n(IOException iOException) {
        super(iOException);
        this.f2437f = iOException;
    }
}
