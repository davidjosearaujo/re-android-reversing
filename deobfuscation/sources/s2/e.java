package s2;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class e implements d {
    @Override // s2.d
    public final void a(int i7) {
    }

    @Override // s2.d
    public final void b() {
    }

    @Override // s2.d
    public final Bitmap c(int i7, int i8, Bitmap.Config config) {
        return Bitmap.createBitmap(i7, i8, config);
    }

    @Override // s2.d
    public final Bitmap d(int i7, int i8, Bitmap.Config config) {
        return Bitmap.createBitmap(i7, i8, config);
    }

    @Override // s2.d
    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }
}
