package e6;

import i5.d;
import i5.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s<T> implements d<T>, k5.d {

    /* renamed from: f  reason: collision with root package name */
    public final d<T> f3916f;

    /* renamed from: g  reason: collision with root package name */
    public final f f3917g;

    /* JADX WARN: Multi-variable type inference failed */
    public s(d<? super T> dVar, f fVar) {
        this.f3916f = dVar;
        this.f3917g = fVar;
    }

    @Override // i5.d
    public final f a() {
        return this.f3917g;
    }

    @Override // k5.d
    public final k5.d g() {
        d<T> dVar = this.f3916f;
        if (dVar instanceof k5.d) {
            return (k5.d) dVar;
        }
        return null;
    }

    @Override // i5.d
    public final void o(Object obj) {
        this.f3916f.o(obj);
    }
}
