package k5;

/* loaded from: classes.dex */
public abstract class g extends a {
    public g(i5.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.a() == i5.g.f4488f)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // i5.d
    public final i5.f a() {
        return i5.g.f4488f;
    }
}
