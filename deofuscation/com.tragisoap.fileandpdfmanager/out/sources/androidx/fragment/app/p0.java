package androidx.fragment.app;

import androidx.fragment.app.q0;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class p0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q0.a f1737f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ q0 f1738g;

    public p0(q0 q0Var, q0.a aVar) {
        this.f1738g = q0Var;
        this.f1737f = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1738g.f1744b.remove(this.f1737f);
        this.f1738g.f1745c.remove(this.f1737f);
    }
}
