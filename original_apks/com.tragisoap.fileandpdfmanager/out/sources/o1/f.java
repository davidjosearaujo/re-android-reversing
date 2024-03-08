package o1;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class f<T> extends e<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f5273c = new Object();

    public f(int i7) {
        super(i7);
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
