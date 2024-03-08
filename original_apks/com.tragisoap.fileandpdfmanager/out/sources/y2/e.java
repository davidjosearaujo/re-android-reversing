package y2;

import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.g;
import p2.l;
import r2.v;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class e implements l<Bitmap> {
    @Override // p2.l
    public final v b(g gVar, v vVar, int i7, int i8) {
        if (k3.l.i(i7, i8)) {
            d dVar = b.b(gVar).f2623f;
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
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i7 + " or height: " + i8 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(d dVar, Bitmap bitmap, int i7, int i8);
}
