package k5;

import i5.d;
import r5.e;
import r5.h;
import r5.t;
import r5.u;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class i extends c implements e<Object> {

    /* renamed from: i  reason: collision with root package name */
    public final int f4827i;

    public i(int i7, d<Object> dVar) {
        super(dVar);
        this.f4827i = i7;
    }

    @Override // r5.e
    public final int e() {
        return this.f4827i;
    }

    @Override // k5.a, java.lang.Object
    public final String toString() {
        if (this.f4817f != null) {
            return super.toString();
        }
        t.f5928a.getClass();
        String a7 = u.a(this);
        h.e(a7, "renderLambdaToString(...)");
        return a7;
    }
}
