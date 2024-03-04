package f6;

import a6.a0;
import a6.g0;
import a6.k1;
import a6.l0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class f<T> extends g0<T> implements k5.d, i5.d<T> {
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: i */
    public final a6.u f4148i;

    /* renamed from: j */
    public final i5.d<T> f4149j;

    /* renamed from: k */
    public Object f4150k;

    /* renamed from: l */
    public final Object f4151l;

    public f(a6.u uVar, k5.c cVar) {
        super(-1);
        this.f4148i = uVar;
        this.f4149j = cVar;
        this.f4150k = a0.b.A;
        this.f4151l = v.b(a());
    }

    @Override // i5.d
    public final i5.f a() {
        return this.f4149j.a();
    }

    @Override // a6.g0
    public final void d(Object obj, CancellationException cancellationException) {
        if (obj instanceof a6.p) {
            ((a6.p) obj).f327b.k(cancellationException);
        }
    }

    @Override // a6.g0
    public final i5.d<T> e() {
        return this;
    }

    @Override // k5.d
    public final k5.d g() {
        i5.d<T> dVar = this.f4149j;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    @Override // a6.g0
    public final Object k() {
        Object obj = this.f4150k;
        this.f4150k = a0.b.A;
        return obj;
    }

    @Override // i5.d
    public final void o(Object obj) {
        i5.f a7 = this.f4149j.a();
        Throwable a8 = f5.d.a(obj);
        Object oVar = a8 == null ? obj : new a6.o(a8, false);
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
            f5.g gVar = f5.g.f4141a;
            v.a(a10, c7);
            do {
            } while (a9.b0());
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        StringBuilder d7 = androidx.activity.h.d("DispatchedContinuation[");
        d7.append(this.f4148i);
        d7.append(", ");
        d7.append(a0.e(this.f4149j));
        d7.append(']');
        return d7.toString();
    }
}
