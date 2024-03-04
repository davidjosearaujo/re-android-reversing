package k3;

/* loaded from: classes.dex */
public final class f implements g<Object> {

    /* renamed from: a */
    public volatile Object f4699a;

    /* renamed from: b */
    public final /* synthetic */ g f4700b;

    public f(g gVar) {
        this.f4700b = gVar;
    }

    @Override // k3.g
    public final Object get() {
        if (this.f4699a == null) {
            synchronized (this) {
                if (this.f4699a == null) {
                    Object obj = this.f4700b.get();
                    q2.a.i(obj);
                    this.f4699a = obj;
                }
            }
        }
        return this.f4699a;
    }
}
