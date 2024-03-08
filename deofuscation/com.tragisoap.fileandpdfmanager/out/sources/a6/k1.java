package a6;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class k1 {

    /* renamed from: a */
    public static final ThreadLocal<l0> f304a = new ThreadLocal<>();

    public static l0 a() {
        ThreadLocal<l0> threadLocal = f304a;
        l0 l0Var = threadLocal.get();
        if (l0Var != null) {
            return l0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}
