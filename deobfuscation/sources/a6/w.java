package a6;

import a6.v;

/* loaded from: classes.dex */
public final class w {
    public static final void a(i5.f fVar, Throwable th) {
        try {
            v vVar = (v) fVar.e(v.a.f342f);
            if (vVar != null) {
                vVar.z(fVar, th);
            } else {
                q2.a.z(fVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                q2.a.c(runtimeException, th);
                th = runtimeException;
            }
            q2.a.z(fVar, th);
        }
    }
}
