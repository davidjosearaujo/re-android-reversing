package r2;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import r2.q;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public final boolean f5726a;

    /* renamed from: b */
    public final HashMap f5727b;

    /* renamed from: c */
    public final ReferenceQueue<q<?>> f5728c;

    /* renamed from: d */
    public q.a f5729d;

    /* loaded from: classes.dex */
    public static final class a extends WeakReference<q<?>> {

        /* renamed from: a */
        public final p2.f f5730a;

        /* renamed from: b */
        public final boolean f5731b;

        /* renamed from: c */
        public v<?> f5732c;

        public a(p2.f fVar, q<?> qVar, ReferenceQueue<? super q<?>> referenceQueue, boolean z6) {
            super(qVar, referenceQueue);
            v<?> vVar;
            q2.a.i(fVar);
            this.f5730a = fVar;
            if (qVar.f5853f && z6) {
                vVar = qVar.f5855h;
                q2.a.i(vVar);
            } else {
                vVar = null;
            }
            this.f5732c = vVar;
            this.f5731b = qVar.f5853f;
        }
    }

    public c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new r2.a());
        this.f5727b = new HashMap();
        this.f5728c = new ReferenceQueue<>();
        this.f5726a = false;
        newSingleThreadExecutor.execute(new b(this));
    }

    public final synchronized void a(p2.f fVar, q<?> qVar) {
        a aVar = (a) this.f5727b.put(fVar, new a(fVar, qVar, this.f5728c, this.f5726a));
        if (aVar != null) {
            aVar.f5732c = null;
            aVar.clear();
        }
    }

    public final void b(a aVar) {
        v<?> vVar;
        synchronized (this) {
            this.f5727b.remove(aVar.f5730a);
            if (aVar.f5731b && (vVar = aVar.f5732c) != null) {
                this.f5729d.a(aVar.f5730a, new q<>(vVar, true, false, aVar.f5730a, this.f5729d));
            }
        }
    }
}
