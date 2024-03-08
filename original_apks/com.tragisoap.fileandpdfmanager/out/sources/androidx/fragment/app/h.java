package androidx.fragment.app;

import androidx.fragment.app.q0;
import o.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ q0.b f1649f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ q0.b f1650g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1651h;

    public h(q0.b bVar, q0.b bVar2, boolean z6, b bVar3) {
        this.f1649f = bVar;
        this.f1650g = bVar2;
        this.f1651h = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g0.a(this.f1649f.f1750c, this.f1650g.f1750c, this.f1651h);
    }
}
