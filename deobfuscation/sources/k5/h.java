package k5;

import r5.t;
import r5.u;

/* loaded from: classes.dex */
public abstract class h extends g implements r5.e<Object> {

    /* renamed from: g */
    public final int f4826g;

    public h(i5.d dVar) {
        super(dVar);
        this.f4826g = 2;
    }

    @Override // r5.e
    public final int e() {
        return this.f4826g;
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
