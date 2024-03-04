package p;

/* loaded from: classes.dex */
public class k0 implements v.k, u, v.g<Float> {

    /* renamed from: f */
    public a f5437f;

    /* loaded from: classes.dex */
    public static final class a extends v.l {

        /* renamed from: c */
        public float f5438c;

        public a(float f7) {
            this.f5438c = f7;
        }

        @Override // v.l
        public final void a(v.l lVar) {
            r5.h.f(lVar, "value");
            this.f5438c = ((a) lVar).f5438c;
        }

        @Override // v.l
        public final v.l b() {
            return new a(this.f5438c);
        }
    }

    public k0(float f7) {
        this.f5437f = new a(f7);
    }

    @Override // v.k
    public final v.l b() {
        return this.f5437f;
    }

    @Override // p.u
    public final void j(float f7) {
        v.c d7;
        a aVar = (a) v.f.c(this.f5437f);
        if (aVar.f5438c == f7) {
            return;
        }
        a aVar2 = this.f5437f;
        synchronized (v.f.f6144b) {
            d7 = v.f.d();
            ((a) v.f.g(aVar2, this, d7, aVar)).f5438c = f7;
            f5.g gVar = f5.g.f4141a;
        }
        v.f.f(d7, this);
    }

    @Override // v.k
    public final void m(v.l lVar) {
        this.f5437f = (a) lVar;
    }

    @Override // p.u
    public final float n() {
        return ((a) v.f.l(this.f5437f, this)).f5438c;
    }

    @Override // v.g
    public final m0<Float> q() {
        return p0.f5447a;
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("MutableFloatState(value=");
        d7.append(((a) v.f.c(this.f5437f)).f5438c);
        d7.append(")@");
        d7.append(hashCode());
        return d7.toString();
    }
}
