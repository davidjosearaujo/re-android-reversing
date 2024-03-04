package m1;

import android.os.Handler;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class o<T> implements Runnable {

    /* renamed from: f */
    public Callable<T> f5075f;

    /* renamed from: g */
    public o1.a<T> f5076g;

    /* renamed from: h */
    public Handler f5077h;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ o1.a f5078f;

        /* renamed from: g */
        public final /* synthetic */ Object f5079g;

        public a(o1.a aVar, Object obj) {
            this.f5078f = aVar;
            this.f5079g = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            this.f5078f.accept(this.f5079g);
        }
    }

    public o(Handler handler, i iVar, j jVar) {
        this.f5075f = iVar;
        this.f5076g = jVar;
        this.f5077h = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T t5;
        try {
            t5 = this.f5075f.call();
        } catch (Exception unused) {
            t5 = null;
        }
        this.f5077h.post(new a(this.f5076g, t5));
    }
}
