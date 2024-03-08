package k5;

import i5.d;
import i5.e;
import i5.f;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c extends a {

    /* renamed from: g */
    public final f f4819g;

    /* renamed from: h */
    public transient d<Object> f4820h;

    public c(d<Object> dVar) {
        this(dVar, dVar != null ? dVar.a() : null);
    }

    public c(d<Object> dVar, f fVar) {
        super(dVar);
        this.f4819g = fVar;
    }

    @Override // i5.d
    public f a() {
        f fVar = this.f4819g;
        h.c(fVar);
        return fVar;
    }

    @Override // k5.a
    public void t() {
        d<?> dVar = this.f4820h;
        if (!(dVar == null || dVar == this)) {
            f a7 = a();
            int i7 = e.f4485c;
            f.b e = a7.e(e.a.f4486f);
            h.c(e);
            ((e) e).f(dVar);
        }
        this.f4820h = b.f4818f;
    }
}
