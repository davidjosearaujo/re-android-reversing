package f5;

import java.io.Serializable;
import r5.h;

/* loaded from: classes.dex */
public final class f<T> implements Serializable {

    /* renamed from: f */
    public q5.a<? extends T> f4138f;

    /* renamed from: g */
    public volatile Object f4139g = a0.e.Z;

    /* renamed from: h */
    public final Object f4140h = this;

    public f(q5.a aVar) {
        this.f4138f = aVar;
    }

    public final T a() {
        T t5;
        T t6 = (T) this.f4139g;
        a0.e eVar = a0.e.Z;
        if (t6 != eVar) {
            return t6;
        }
        synchronized (this.f4140h) {
            t5 = (T) this.f4139g;
            if (t5 == eVar) {
                q5.a<? extends T> aVar = this.f4138f;
                h.c(aVar);
                t5 = aVar.d();
                this.f4139g = t5;
                this.f4138f = null;
            }
        }
        return t5;
    }

    public final String toString() {
        return this.f4139g != a0.e.Z ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
