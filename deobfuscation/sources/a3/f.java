package a3;

import android.graphics.drawable.Drawable;
import p2.h;
import p2.j;
import r2.v;

/* loaded from: classes.dex */
public final class f implements j<Drawable, Drawable> {
    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(Drawable drawable, h hVar) {
        return true;
    }

    @Override // p2.j
    public final v<Drawable> b(Drawable drawable, int i7, int i8, h hVar) {
        Drawable drawable2 = drawable;
        if (drawable2 != null) {
            return new d(drawable2);
        }
        return null;
    }
}
