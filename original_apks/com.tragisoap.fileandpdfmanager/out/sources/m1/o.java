package m1;

import android.os.Handler;
import java.util.concurrent.Callable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public Callable<T> f5075f;

    /* renamed from: g  reason: collision with root package name */
    public o1.a<T> f5076g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f5077h;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ o1.a f5078f;

        /* renamed from: g  reason: collision with root package name */
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
