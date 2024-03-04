package y2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class n implements p2.l<Drawable> {

    /* renamed from: b */
    public final p2.l<Bitmap> f6633b;

    /* renamed from: c */
    public final boolean f6634c;

    public n(p2.l<Bitmap> lVar, boolean z6) {
        this.f6633b = lVar;
        this.f6634c = z6;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        this.f6633b.a(messageDigest);
    }

    @Override // p2.l
    public final r2.v b(com.bumptech.glide.g gVar, r2.v vVar, int i7, int i8) {
        s2.d dVar = com.bumptech.glide.b.b(gVar).f2623f;
        Drawable drawable = (Drawable) vVar.get();
        d a7 = m.a(dVar, drawable, i7, i8);
        if (a7 != null) {
            r2.v b2 = this.f6633b.b(gVar, a7, i7, i8);
            if (b2.equals(a7)) {
                b2.recycle();
                return vVar;
            }
            return new d(gVar.getResources(), b2);
        } else if (this.f6634c) {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        } else {
            return vVar;
        }
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return this.f6633b.equals(((n) obj).f6633b);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return this.f6633b.hashCode();
    }
}
