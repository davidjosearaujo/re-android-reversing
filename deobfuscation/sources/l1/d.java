package l1;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public boolean f4940a;

    /* renamed from: b */
    public a f4941b;

    /* renamed from: c */
    public boolean f4942c;

    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    public final void a() {
        synchronized (this) {
            if (this.f4940a) {
                return;
            }
            this.f4940a = true;
            this.f4942c = true;
            a aVar = this.f4941b;
            if (aVar != null) {
                try {
                    aVar.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f4942c = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.f4942c = false;
                notifyAll();
            }
        }
    }

    public final void b(a aVar) {
        synchronized (this) {
            while (this.f4942c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f4941b == aVar) {
                return;
            }
            this.f4941b = aVar;
            if (this.f4940a) {
                aVar.onCancel();
            }
        }
    }
}
