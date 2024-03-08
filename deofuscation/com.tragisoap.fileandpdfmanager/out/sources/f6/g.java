package f6;

import a6.c0;
import a6.d0;
import a6.h;
import a6.u;
import a6.w;
import g6.l;
import i5.f;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g extends u implements d0 {
    public static final AtomicIntegerFieldUpdater m = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers");

    /* renamed from: h  reason: collision with root package name */
    public final u f4152h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4153i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ d0 f4154j;

    /* renamed from: k  reason: collision with root package name */
    public final j<Runnable> f4155k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f4156l;
    private volatile int runningWorkers;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public Runnable f4157f;

        public a(Runnable runnable) {
            this.f4157f = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i7 = 0;
            while (true) {
                try {
                    this.f4157f.run();
                } catch (Throwable th) {
                    w.a(i5.g.f4488f, th);
                }
                Runnable W = g.this.W();
                if (W != null) {
                    this.f4157f = W;
                    i7++;
                    if (i7 >= 16 && g.this.f4152h.V()) {
                        g gVar = g.this;
                        gVar.f4152h.U(gVar, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public g(l lVar, int i7) {
        this.f4152h = lVar;
        this.f4153i = i7;
        d0 d0Var = lVar instanceof d0 ? (d0) lVar : null;
        this.f4154j = d0Var == null ? c0.f287a : d0Var;
        this.f4155k = new j<>();
        this.f4156l = new Object();
    }

    @Override // a6.d0
    public final void J(long j7, h hVar) {
        this.f4154j.J(j7, hVar);
    }

    @Override // a6.u
    public final void U(f fVar, Runnable runnable) {
        boolean z6;
        Runnable W;
        this.f4155k.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m;
        if (atomicIntegerFieldUpdater.get(this) < this.f4153i) {
            synchronized (this.f4156l) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f4153i) {
                    z6 = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z6 = true;
                }
            }
            if (z6 && (W = W()) != null) {
                this.f4152h.U(this, new a(W));
            }
        }
    }

    public final Runnable W() {
        while (true) {
            Runnable d7 = this.f4155k.d();
            if (d7 != null) {
                return d7;
            }
            synchronized (this.f4156l) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f4155k.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
