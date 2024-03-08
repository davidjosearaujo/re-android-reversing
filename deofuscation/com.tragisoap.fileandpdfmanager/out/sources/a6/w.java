package a6;

import a6.v;
import i5.f;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w {
    public static final void a(f fVar, Throwable th) {
        try {
            v vVar = (v) fVar.e(v.a.f342f);
            if (vVar != null) {
                vVar.z(fVar, th);
            } else {
                a.z(fVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a.c(runtimeException, th);
                th = runtimeException;
            }
            a.z(fVar, th);
        }
    }
}
