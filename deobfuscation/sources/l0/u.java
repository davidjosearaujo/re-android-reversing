package l0;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class u extends t {

    /* renamed from: h */
    public final w f4882h;

    public u(w wVar) {
        r5.h.f(wVar, "coordinator");
        this.f4882h = wVar;
        long j5 = t0.f.f6007a;
        new a0.b(this);
        new LinkedHashMap();
    }

    @Override // t0.c
    public final float getDensity() {
        return this.f4882h.getDensity();
    }
}
