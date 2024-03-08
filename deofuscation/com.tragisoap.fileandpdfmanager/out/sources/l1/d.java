package l1;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4940a;

    /* renamed from: b  reason: collision with root package name */
    public a f4941b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4942c;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        void onCancel();
    }

    public final void a() {
        synchronized (this) {
            try {
                if (!this.f4940a) {
                    this.f4940a = true;
                    this.f4942c = true;
                    a aVar = this.f4941b;
                    if (aVar != null) {
                        try {
                            aVar.onCancel();
                        } catch (Throwable th) {
                            synchronized (this) {
                                try {
                                    this.f4942c = false;
                                    notifyAll();
                                    throw th;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        try {
                            this.f4942c = false;
                            notifyAll();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
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
            if (this.f4941b != aVar) {
                this.f4941b = aVar;
                if (this.f4940a) {
                    aVar.onCancel();
                }
            }
        }
    }
}
