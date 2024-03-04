package r5;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class i<R> implements e<R>, Serializable {

    /* renamed from: f */
    public final int f5921f;

    public i(int i7) {
        this.f5921f = i7;
    }

    @Override // r5.e
    public final int e() {
        return this.f5921f;
    }

    public final String toString() {
        t.f5928a.getClass();
        String a7 = u.a(this);
        h.e(a7, "renderLambdaToString(...)");
        return a7;
    }
}
