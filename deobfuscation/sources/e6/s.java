package e6;

/* loaded from: classes.dex */
public final class s<T> implements i5.d<T>, k5.d {

    /* renamed from: f */
    public final i5.d<T> f3916f;

    /* renamed from: g */
    public final i5.f f3917g;

    /* JADX WARN: Multi-variable type inference failed */
    public s(i5.d<? super T> dVar, i5.f fVar) {
        this.f3916f = dVar;
        this.f3917g = fVar;
    }

    @Override // i5.d
    public final i5.f a() {
        return this.f3917g;
    }

    @Override // k5.d
    public final k5.d g() {
        i5.d<T> dVar = this.f3916f;
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
