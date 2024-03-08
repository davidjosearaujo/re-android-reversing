package f5;

import a0.e;
import java.io.Serializable;
import q5.a;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f<T> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public a<? extends T> f4138f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Object f4139g = e.Z;

    /* renamed from: h  reason: collision with root package name */
    public final Object f4140h = this;

    public f(a aVar) {
        this.f4138f = aVar;
    }

    public final T a() {
        T t5;
        T t6 = (T) this.f4139g;
        e eVar = e.Z;
        if (t6 != eVar) {
            return t6;
        }
        synchronized (this.f4140h) {
            t5 = (T) this.f4139g;
            if (t5 == eVar) {
                a<? extends T> aVar = this.f4138f;
                h.c(aVar);
                t5 = (T) aVar.d();
                this.f4139g = t5;
                this.f4138f = null;
            }
        }
        return t5;
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.f4139g != e.Z ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
