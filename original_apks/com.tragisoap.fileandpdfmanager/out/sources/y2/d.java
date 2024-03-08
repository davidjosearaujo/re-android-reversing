package y2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import k3.l;
import q2.a;
import r2.s;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d implements v, s {

    /* renamed from: f */
    public final /* synthetic */ int f6603f = 1;

    /* renamed from: g */
    public final Object f6604g;

    /* renamed from: h */
    public final Object f6605h;

    public d(Resources resources, v vVar) {
        a.i(resources);
        this.f6604g = resources;
        a.i(vVar);
        this.f6605h = vVar;
    }

    public static d d(Bitmap bitmap, s2.d dVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, dVar);
    }

    @Override // r2.s
    public final void a() {
        switch (this.f6603f) {
            case 0:
                ((Bitmap) this.f6604g).prepareToDraw();
                return;
            default:
                v vVar = (v) this.f6605h;
                if (vVar instanceof s) {
                    ((s) vVar).a();
                    return;
                }
                return;
        }
    }

    @Override // r2.v
    public final int b() {
        switch (this.f6603f) {
            case 0:
                return l.c((Bitmap) this.f6604g);
            default:
                return ((v) this.f6605h).b();
        }
    }

    @Override // r2.v
    public final Class c() {
        switch (this.f6603f) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // r2.v
    public final Object get() {
        switch (this.f6603f) {
            case 0:
                return (Bitmap) this.f6604g;
            default:
                return new BitmapDrawable((Resources) this.f6604g, (Bitmap) ((v) this.f6605h).get());
        }
    }

    @Override // r2.v
    public final void recycle() {
        switch (this.f6603f) {
            case 0:
                ((s2.d) this.f6605h).e((Bitmap) this.f6604g);
                return;
            default:
                ((v) this.f6605h).recycle();
                return;
        }
    }

    public d(Bitmap bitmap, s2.d dVar) {
        if (bitmap != null) {
            this.f6604g = bitmap;
            if (dVar != null) {
                this.f6605h = dVar;
                return;
            }
            throw new NullPointerException("BitmapPool must not be null");
        }
        throw new NullPointerException("Bitmap must not be null");
    }
}
