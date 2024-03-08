package l0;

import a0.b;
import java.util.LinkedHashMap;
import r5.h;
import t0.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class u extends t {

    /* renamed from: h  reason: collision with root package name */
    public final w f4882h;

    public u(w wVar) {
        h.f(wVar, "coordinator");
        this.f4882h = wVar;
        long j7 = f.f6007a;
        new b(this);
        new LinkedHashMap();
    }

    @Override // t0.c
    public final float getDensity() {
        return this.f4882h.getDensity();
    }
}
