package k5;

/* loaded from: classes.dex */
public final class b implements i5.d<Object> {

    /* renamed from: f */
    public static final b f4818f = new b();

    @Override // i5.d
    public final i5.f a() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // i5.d
    public final void o(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
