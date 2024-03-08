package y2;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;
import p2.f;
import s2.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class h extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f6609b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f.f5564a);

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6609b);
    }

    @Override // y2.e
    public final Bitmap c(d dVar, Bitmap bitmap, int i7, int i8) {
        float f7;
        float f8;
        Paint paint = v.f6662a;
        if (bitmap.getWidth() == i7 && bitmap.getHeight() == i8) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f9 = 0.0f;
        if (bitmap.getWidth() * i8 > bitmap.getHeight() * i7) {
            f8 = ((float) i8) / ((float) bitmap.getHeight());
            f9 = (((float) i7) - (((float) bitmap.getWidth()) * f8)) * 0.5f;
            f7 = 0.0f;
        } else {
            f8 = ((float) i7) / ((float) bitmap.getWidth());
            f7 = (((float) i8) - (((float) bitmap.getHeight()) * f8)) * 0.5f;
        }
        matrix.setScale(f8, f8);
        matrix.postTranslate((float) ((int) (f9 + 0.5f)), (float) ((int) (f7 + 0.5f)));
        Bitmap d7 = dVar.d(i7, i8, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        d7.setHasAlpha(bitmap.hasAlpha());
        v.a(bitmap, d7, matrix);
        return d7;
    }

    @Override // p2.f
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // p2.f
    public final int hashCode() {
        return -599754482;
    }
}
