package r2;

import r2.c;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class b implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ c f5725f;

    public b(c cVar) {
        this.f5725f = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.f5725f;
        cVar.getClass();
        while (true) {
            try {
                cVar.b((c.a) cVar.f5728c.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}