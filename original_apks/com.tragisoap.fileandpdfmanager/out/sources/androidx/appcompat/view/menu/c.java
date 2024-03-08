package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ b.d f560f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MenuItem f561g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ f f562h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b.c f563i;

    public c(b.c cVar, b.d dVar, h hVar, f fVar) {
        this.f563i = cVar;
        this.f560f = dVar;
        this.f561g = hVar;
        this.f562h = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.d dVar = this.f560f;
        if (dVar != null) {
            b.this.F = true;
            dVar.f558b.c(false);
            b.this.F = false;
        }
        if (this.f561g.isEnabled() && this.f561g.hasSubMenu()) {
            this.f562h.q(this.f561g, null, 4);
        }
    }
}
