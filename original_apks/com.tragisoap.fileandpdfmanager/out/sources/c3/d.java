package c3;

import a3.c;
import android.graphics.Bitmap;
import c3.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends c<c> {
    public d(c cVar) {
        super(cVar);
    }

    @Override // a3.c, r2.s
    public final void a() {
        ((c) this.f125f).f2527f.f2536a.f2548l.prepareToDraw();
    }

    @Override // r2.v
    public final int b() {
        f fVar = ((c) this.f125f).f2527f.f2536a;
        return fVar.f2538a.f() + fVar.f2550o;
    }

    @Override // r2.v
    public final Class<c> c() {
        return c.class;
    }

    @Override // r2.v
    public final void recycle() {
        ((c) this.f125f).stop();
        c cVar = (c) this.f125f;
        cVar.f2530i = true;
        f fVar = cVar.f2527f.f2536a;
        fVar.f2540c.clear();
        Bitmap bitmap = fVar.f2548l;
        if (bitmap != null) {
            fVar.e.e(bitmap);
            fVar.f2548l = null;
        }
        fVar.f2542f = false;
        f.a aVar = fVar.f2545i;
        if (aVar != null) {
            fVar.f2541d.l(aVar);
            fVar.f2545i = null;
        }
        f.a aVar2 = fVar.f2547k;
        if (aVar2 != null) {
            fVar.f2541d.l(aVar2);
            fVar.f2547k = null;
        }
        f.a aVar3 = fVar.f2549n;
        if (aVar3 != null) {
            fVar.f2541d.l(aVar3);
            fVar.f2549n = null;
        }
        fVar.f2538a.clear();
        fVar.f2546j = true;
    }
}
