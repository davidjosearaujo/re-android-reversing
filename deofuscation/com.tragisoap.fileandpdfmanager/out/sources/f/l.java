package f;

import android.view.View;
import java.util.WeakHashMap;
import l0.z;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends z {
    public final /* synthetic */ h L;

    public l(h hVar) {
        this.L = hVar;
    }

    @Override // p1.l0
    public final void a() {
        this.L.A.setAlpha(1.0f);
        this.L.D.d(null);
        this.L.D = null;
    }

    @Override // l0.z, p1.l0
    public final void c() {
        this.L.A.setVisibility(0);
        if (this.L.A.getParent() instanceof View) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.h.c((View) this.L.A.getParent());
        }
    }
}
