package p;

import r5.h;
import v.c;
import v.f;
import v.g;
import v.k;
import v.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class k0 implements k, u, g<Float> {

    /* renamed from: f  reason: collision with root package name */
    public a f5437f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends l {

        /* renamed from: c  reason: collision with root package name */
        public float f5438c;

        public a(float f7) {
            this.f5438c = f7;
        }

        @Override // v.l
        public final void a(l lVar) {
            h.f(lVar, "value");
            this.f5438c = ((a) lVar).f5438c;
        }

        @Override // v.l
        public final l b() {
            return new a(this.f5438c);
        }
    }

    public k0(float f7) {
        this.f5437f = new a(f7);
    }

    @Override // v.k
    public final l b() {
        return this.f5437f;
    }

    @Override // p.u
    public final void j(float f7) {
        c d7;
        a aVar = (a) f.c(this.f5437f);
        if (!(aVar.f5438c == f7)) {
            a aVar2 = this.f5437f;
            synchronized (f.f6144b) {
                d7 = f.d();
                ((a) f.g(aVar2, this, d7, aVar)).f5438c = f7;
                f5.g gVar = f5.g.f4141a;
            }
            f.f(d7, this);
        }
    }

    @Override // v.k
    public final void m(l lVar) {
        this.f5437f = (a) lVar;
    }

    @Override // p.u
    public final float n() {
        return ((a) f.l(this.f5437f, this)).f5438c;
    }

    @Override // v.g
    public final m0<Float> q() {
        return p0.f5447a;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("MutableFloatState(value=");
        d7.append(((a) f.c(this.f5437f)).f5438c);
        d7.append(")@");
        d7.append(hashCode());
        return d7.toString();
    }
}
