package o1;

/* loaded from: classes.dex */
public final class f<T> extends e<T> {

    /* renamed from: c */
    public final Object f5273c;

    public f(int i7) {
        super(i7);
        this.f5273c = new Object();
    }

    @Override // o1.e, o1.d
    public final boolean a(T t5) {
        boolean a7;
        synchronized (this.f5273c) {
            a7 = super.a(t5);
        }
        return a7;
    }

    @Override // o1.e, o1.d
    public final T b() {
        T t5;
        synchronized (this.f5273c) {
            t5 = (T) super.b();
        }
        return t5;
    }
}
