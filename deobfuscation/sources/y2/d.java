package y2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes.dex */
public final class d implements r2.v, r2.s {

    /* renamed from: f */
    public final /* synthetic */ int f6603f = 1;

    /* renamed from: g */
    public final Object f6604g;

    /* renamed from: h */
    public final Object f6605h;

    public d(Resources resources, r2.v vVar) {
        q2.a.i(resources);
        this.f6604g = resources;
        q2.a.i(vVar);
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
                r2.v vVar = (r2.v) this.f6605h;
                if (vVar instanceof r2.s) {
                    ((r2.s) vVar).a();
                    return;
                }
                return;
        }
    }

    @Override // r2.v
    public final int b() {
        switch (this.f6603f) {
            case 0:
                return k3.l.c((Bitmap) this.f6604g);
            default:
                return ((r2.v) this.f6605h).b();
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
                return new BitmapDrawable((Resources) this.f6604g, (Bitmap) ((r2.v) this.f6605h).get());
        }
    }

    @Override // r2.v
    public final void recycle() {
        switch (this.f6603f) {
            case 0:
                ((s2.d) this.f6605h).e((Bitmap) this.f6604g);
                return;
            default:
                ((r2.v) this.f6605h).recycle();
                return;
        }
    }

    public d(Bitmap bitmap, s2.d dVar) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        this.f6604g = bitmap;
        if (dVar == null) {
            throw new NullPointerException("BitmapPool must not be null");
        }
        this.f6605h = dVar;
    }
}
