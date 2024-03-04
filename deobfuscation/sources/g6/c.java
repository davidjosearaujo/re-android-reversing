package g6;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: i */
    public static final c f4312i = new c();

    public c() {
        super(k.f4321c, k.f4322d, k.e, k.f4319a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // a6.u
    public final String toString() {
        return "Dispatchers.Default";
    }
}
