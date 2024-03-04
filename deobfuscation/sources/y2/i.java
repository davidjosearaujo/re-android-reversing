package y2;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: b */
    public static final byte[] f6610b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(p2.f.f5564a);

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6610b);
    }

    @Override // y2.e
    public final Bitmap c(s2.d dVar, Bitmap bitmap, int i7, int i8) {
        Paint paint = v.f6662a;
        if (bitmap.getWidth() > i7 || bitmap.getHeight() > i8) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return v.b(dVar, bitmap, i7, i8);
        } else if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            return bitmap;
        } else {
            return bitmap;
        }
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // p2.f
    public final int hashCode() {
        return -670243078;
    }
}
