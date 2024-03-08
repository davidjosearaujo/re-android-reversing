package y2;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b;
import com.bumptech.glide.g;
import java.security.MessageDigest;
import p2.l;
import r2.v;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class n implements l<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final l<Bitmap> f6633b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6634c;

    public n(l<Bitmap> lVar, boolean z6) {
        this.f6633b = lVar;
        this.f6634c = z6;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        this.f6633b.a(messageDigest);
    }

    @Override // p2.l
    public final v b(g gVar, v vVar, int i7, int i8) {
        d dVar = b.b(gVar).f2623f;
        Drawable drawable = (Drawable) vVar.get();
        d a7 = m.a(dVar, drawable, i7, i8);
        if (a7 != null) {
            v b2 = this.f6633b.b(gVar, a7, i7, i8);
            if (!b2.equals(a7)) {
                return new d(gVar.getResources(), b2);
            }
            b2.recycle();
            return vVar;
        } else if (!this.f6634c) {
            return vVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
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
