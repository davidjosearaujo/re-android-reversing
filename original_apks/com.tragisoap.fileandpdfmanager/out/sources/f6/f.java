package f6;

import a0.b;
import a6.a0;
import a6.g0;
import a6.k1;
import a6.l0;
import a6.o;
import a6.p;
import a6.u;
import androidx.activity.h;
import f5.g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k5.c;
import k5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f<T> extends g0<T> implements d, i5.d<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: i */
    public final u f4148i;

    /* renamed from: j */
    public final i5.d<T> f4149j;

    /* renamed from: k */
    public Object f4150k = b.A;

    /* renamed from: l */
    public final Object f4151l = v.b(a());

    public f(u uVar, c cVar) {
        super(-1);
        this.f4148i = uVar;
        this.f4149j = cVar;
    }

    @Override // i5.d
    public final i5.f a() {
        return this.f4149j.a();
    }

    @Override // a6.g0
    public final void d(Object obj, CancellationException cancellationException) {
        if (obj instanceof p) {
            ((p) obj).f327b.k(cancellationException);
        }
    }

    @Override // a6.g0
    public final i5.d<T> e() {
        return this;
    }

    @Override // k5.d
    public final d g() {
        i5.d<T> dVar = this.f4149j;
        if (dVar instanceof d) {
            return (d) dVar;
        }
        return null;
    }

    @Override // a6.g0
    public final Object k() {
        Object obj = this.f4150k;
        this.f4150k = b.A;
        return obj;
    }

    @Override // i5.d
    public final void o(Object obj) {
        i5.f a7 = this.f4149j.a();
        Throwable a8 = f5.d.a(obj);
        Object oVar = a8 == null ? obj : new o(a8, false);
        if (this.f4148i.V()) {
            this.f4150k = oVar;
            this.f291h = 0;
            this.f4148i.U(a7, this);
            return;
        }
        l0 a9 = k1.a();
        if (a9.Z()) {
            this.f4150k = oVar;
            this.f291h = 0;
            a9.X(this);
            return;
        }
        a9.Y(true);
        try {
            i5.f a10 = a();
            Object c7 = v.c(a10, this.f4151l);
            this.f4149j.o(obj);
            g gVar = g.f4141a;
            v.a(a10, c7);
            do {
            } while (a9.b0());
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder d7 = h.d("DispatchedContinuation[");
        d7.append(this.f4148i);
        d7.append(", ");
        d7.append(a0.e(this.f4149j));
        d7.append(']');
        return d7.toString();
    }
}
