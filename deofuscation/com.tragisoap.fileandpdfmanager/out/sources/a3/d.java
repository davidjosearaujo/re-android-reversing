package a3;

import android.graphics.drawable.Drawable;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends c<Drawable> {
    public d(Drawable drawable) {
        super(drawable);
    }

    @Override // r2.v
    public final int b() {
        return Math.max(1, this.f125f.getIntrinsicHeight() * this.f125f.getIntrinsicWidth() * 4);
    }

    @Override // r2.v
    public final Class<Drawable> c() {
        return this.f125f.getClass();
    }

    @Override // r2.v
    public final void recycle() {
    }
}
