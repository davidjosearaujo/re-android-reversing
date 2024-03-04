package a6;

/* loaded from: classes.dex */
public final class k1 {

    /* renamed from: a */
    public static final ThreadLocal<l0> f304a = new ThreadLocal<>();

    public static l0 a() {
        ThreadLocal<l0> threadLocal = f304a;
        l0 l0Var = threadLocal.get();
        if (l0Var == null) {
            d dVar = new d(Thread.currentThread());
            threadLocal.set(dVar);
            return dVar;
        }
        return l0Var;
    }
}
