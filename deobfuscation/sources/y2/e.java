package y2;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class e implements p2.l<Bitmap> {
    @Override // p2.l
    public final r2.v b(com.bumptech.glide.g gVar, r2.v vVar, int i7, int i8) {
        if (!k3.l.i(i7, i8)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i7 + " or height: " + i8 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        s2.d dVar = com.bumptech.glide.b.b(gVar).f2623f;
        Bitmap bitmap = (Bitmap) vVar.get();
        if (i7 == Integer.MIN_VALUE) {
            i7 = bitmap.getWidth();
        }
        if (i8 == Integer.MIN_VALUE) {
            i8 = bitmap.getHeight();
        }
        Bitmap c7 = c(dVar, bitmap, i7, i8);
        return bitmap.equals(c7) ? vVar : d.d(c7, dVar);
    }

    public abstract Bitmap c(s2.d dVar, Bitmap bitmap, int i7, int i8);
}
