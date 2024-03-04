package g6;

import a6.o0;
import a6.u;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b extends o0 implements Executor {

    /* renamed from: h */
    public static final b f4310h = new b();

    /* renamed from: i */
    public static final u f4311i;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [f6.g] */
    static {
        l lVar = l.f4326h;
        int i7 = f6.u.f4181a;
        if (64 >= i7) {
            i7 = 64;
        }
        int R = q2.a.R("kotlinx.coroutines.io.parallelism", i7, 0, 0, 12);
        lVar.getClass();
        q2.a.j(R);
        if (R < k.f4322d) {
            q2.a.j(R);
            lVar = new f6.g(lVar, R);
        }
        f4311i = lVar;
    }

    @Override // a6.u
    public final void U(i5.f fVar, Runnable runnable) {
        f4311i.U(fVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        U(i5.g.f4488f, runnable);
    }

    @Override // a6.u
    public final String toString() {
        return "Dispatchers.IO";
    }
}
