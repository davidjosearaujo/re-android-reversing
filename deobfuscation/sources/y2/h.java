package y2;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class h extends e {

    /* renamed from: b */
    public static final byte[] f6609b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(p2.f.f5564a);

    @Override // p2.f
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(f6609b);
    }

    @Override // y2.e
    public final Bitmap c(s2.d dVar, Bitmap bitmap, int i7, int i8) {
        float width;
        float height;
        Paint paint = v.f6662a;
        if (bitmap.getWidth() == i7 && bitmap.getHeight() == i8) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f7 = 0.0f;
        if (bitmap.getWidth() * i8 > bitmap.getHeight() * i7) {
            width = i8 / bitmap.getHeight();
            f7 = (i7 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i7 / bitmap.getWidth();
            height = (i8 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f7 + 0.5f), (int) (height + 0.5f));
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
