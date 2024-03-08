package y2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
import s2.d;
import s2.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6632a = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends e {
        @Override // s2.e, s2.d
        public final void e(Bitmap bitmap) {
        }
    }

    /* JADX WARN: Finally extract failed */
    public static d a(d dVar, Drawable drawable, int i7, int i8) {
        StringBuilder sb;
        String str;
        Drawable current = drawable.getCurrent();
        boolean z6 = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i7 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i8 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i7 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i8 = current.getIntrinsicHeight();
                    }
                    Lock lock = v.f6663b;
                    lock.lock();
                    Bitmap d7 = dVar.d(i7, i8, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(d7);
                        current.setBounds(0, 0, i7, i8);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = d7;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb = new StringBuilder();
                    sb.append("Unable to draw ");
                    sb.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height";
                    sb.append(str);
                    Log.w("DrawableToBitmap", sb.toString());
                }
                z6 = true;
            } else {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    sb = new StringBuilder();
                    sb.append("Unable to draw ");
                    sb.append(current);
                    str = " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width";
                    sb.append(str);
                    Log.w("DrawableToBitmap", sb.toString());
                }
                z6 = true;
            }
        }
        if (!z6) {
            dVar = f6632a;
        }
        return d.d(bitmap, dVar);
    }
}
