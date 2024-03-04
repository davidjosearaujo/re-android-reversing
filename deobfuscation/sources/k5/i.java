package k5;

import r5.t;
import r5.u;

/* loaded from: classes.dex */
public abstract class i extends c implements r5.e<Object> {

    /* renamed from: i */
    public final int f4827i;

    public i(int i7, i5.d<Object> dVar) {
        super(dVar);
        this.f4827i = i7;
    }

    @Override // r5.e
    public final int e() {
        return this.f4827i;
    }

    @Override // k5.a
    public final String toString() {
        if (this.f4817f == null) {
            t.f5928a.getClass();
            String a7 = u.a(this);
            r5.h.e(a7, "renderLambdaToString(...)");
            return a7;
        }
        return super.toString();
    }
}
