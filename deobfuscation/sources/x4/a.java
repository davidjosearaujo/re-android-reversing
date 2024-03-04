package x4;

import android.graphics.Bitmap;
import f5.g;
import java.util.Iterator;
import java.util.LinkedList;
import r5.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final LinkedList<Bitmap> f6469a = new LinkedList<>();

    public static Bitmap a(int i7, int i8) {
        LinkedList<Bitmap> linkedList = f6469a;
        synchronized (linkedList) {
            Iterator<Bitmap> it = linkedList.iterator();
            h.e(it, "iterator(...)");
            while (it.hasNext()) {
                Bitmap next = it.next();
                h.e(next, "next(...)");
                Bitmap bitmap = next;
                if (!bitmap.isRecycled() && bitmap.getWidth() == i7 && bitmap.getHeight() == i8) {
                    it.remove();
                    return bitmap;
                }
            }
            g gVar = g.f4141a;
            Bitmap createBitmap = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
            h.e(createBitmap, "createBitmap(...)");
            return createBitmap;
        }
    }

    public static void b(Bitmap bitmap) {
        h.f(bitmap, "bitmap");
        if (bitmap.isRecycled()) {
            return;
        }
        LinkedList<Bitmap> linkedList = f6469a;
        synchronized (linkedList) {
            if (linkedList.size() < 10) {
                linkedList.add(bitmap);
            } else {
                bitmap.recycle();
                g gVar = g.f4141a;
            }
        }
    }
}
