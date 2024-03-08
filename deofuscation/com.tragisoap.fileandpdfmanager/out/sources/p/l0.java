package p;

import r5.h;
import v.c;
import v.f;
import v.g;
import v.k;
import v.l;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class l0<T> implements k, g<T> {

    /* renamed from: f  reason: collision with root package name */
    public final m0<T> f5439f;

    /* renamed from: g  reason: collision with root package name */
    public a<T> f5440g;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a<T> extends l {

        /* renamed from: c  reason: collision with root package name */
        public T f5441c;

        public a(T t5) {
            this.f5441c = t5;
        }

        @Override // v.l
        public final void a(l lVar) {
            h.f(lVar, "value");
            this.f5441c = ((a) lVar).f5441c;
        }

        @Override // v.l
        public final l b() {
            return new a(this.f5441c);
        }
    }

    public l0(T t5, m0<T> m0Var) {
        h.f(m0Var, "policy");
        this.f5439f = m0Var;
        this.f5440g = new a<>(t5);
    }

    @Override // v.k
    public final l b() {
        return this.f5440g;
    }

    @Override // p.v, p.o0
    public final T getValue() {
        return ((a) f.l(this.f5440g, this)).f5441c;
    }

    @Override // v.k
    public final void m(l lVar) {
        this.f5440g = (a) lVar;
    }

    @Override // v.g
    public final m0<T> q() {
        return this.f5439f;
    }

    @Override // p.v
    public final void setValue(T t5) {
        c d7;
        a aVar = (a) f.c(this.f5440g);
        if (!this.f5439f.a(aVar.f5441c, t5)) {
            a<T> aVar2 = this.f5440g;
            synchronized (f.f6144b) {
                d7 = f.d();
                ((a) f.g(aVar2, this, d7, aVar)).f5441c = t5;
                f5.g gVar = f5.g.f4141a;
            }
            f.f(d7, this);
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("MutableState(value=");
        d7.append(((a) f.c(this.f5440g)).f5441c);
        d7.append(")@");
        d7.append(hashCode());
        return d7.toString();
    }
}
