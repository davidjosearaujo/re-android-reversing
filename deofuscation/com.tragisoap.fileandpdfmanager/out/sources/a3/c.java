package a3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import q2.a;
import r2.s;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public abstract class c<T extends Drawable> implements v<T>, s {

    /* renamed from: f  reason: collision with root package name */
    public final T f125f;

    public c(T t5) {
        a.i(t5);
        this.f125f = t5;
    }

    @Override // r2.s
    public void a() {
        Bitmap bitmap;
        T t5 = this.f125f;
        if (t5 instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) t5).getBitmap();
        } else if (t5 instanceof c3.c) {
            bitmap = ((c3.c) t5).f2527f.f2536a.f2548l;
        } else {
            return;
        }
        bitmap.prepareToDraw();
    }

    @Override // r2.v
    public final Object get() {
        Drawable.ConstantState constantState = this.f125f.getConstantState();
        return constantState == null ? this.f125f : constantState.newDrawable();
    }
}
