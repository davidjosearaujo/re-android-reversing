package b.a.a.a.g;

import java.util.concurrent.Executor;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f<TResult> implements h<TResult> {

    /* renamed from: a */
    private final Executor f205a;

    /* renamed from: b */
    private final Object f206b = new Object();
    private a<TResult> c;

    public f(Executor executor, a<TResult> aVar) {
        this.f205a = executor;
        this.c = aVar;
    }

    @Override // b.a.a.a.g.h
    public final void a(c<TResult> cVar) {
        synchronized (this.f206b) {
            if (this.c != null) {
                this.f205a.execute(new g(this, cVar));
            }
        }
    }
}
