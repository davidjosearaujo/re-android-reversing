package c3;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p2.l;
import r2.v;

/* loaded from: classes.dex */
public final class e implements l<c> {

    /* renamed from: b */
    public final l<Bitmap> f2537b;

    public e(l<Bitmap> lVar) {
        q2.a.i(lVar);
        this.f2537b = lVar;
    }

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        this.f2537b.a(messageDigest);
    }

    @Override // p2.l
    public final v b(com.bumptech.glide.g gVar, v vVar, int i7, int i8) {
        c cVar = (c) vVar.get();
        y2.d dVar = new y2.d(cVar.f2527f.f2536a.f2548l, com.bumptech.glide.b.b(gVar).f2623f);
        v b2 = this.f2537b.b(gVar, dVar, i7, i8);
        if (!dVar.equals(b2)) {
            dVar.recycle();
        }
        l<Bitmap> lVar = this.f2537b;
        cVar.f2527f.f2536a.c(lVar, (Bitmap) b2.get());
        return vVar;
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f2537b.equals(((e) obj).f2537b);
        }
        return false;
    }

    @Override // p2.f
    public final int hashCode() {
        return this.f2537b.hashCode();
    }
}
