package g6;

import a6.o0;
import a6.u;
import f6.g;
import i5.f;
import java.util.concurrent.Executor;
import q2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b extends o0 implements Executor {

    /* renamed from: h */
    public static final b f4310h = new b();

    /* renamed from: i */
    public static final u f4311i;

    static {
        l lVar = l.f4326h;
        int i7 = f6.u.f4181a;
        if (64 >= i7) {
            i7 = 64;
        }
        int R = a.R("kotlinx.coroutines.io.parallelism", i7, 0, 0, 12);
        lVar.getClass();
        a.j(R);
        u uVar = lVar;
        if (R < k.f4322d) {
            a.j(R);
            uVar = new g(lVar, R);
        }
        f4311i = uVar;
    }

    @Override // a6.u
    public final void U(f fVar, Runnable runnable) {
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
