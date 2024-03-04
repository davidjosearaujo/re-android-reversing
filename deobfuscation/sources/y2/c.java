package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;

/* loaded from: classes.dex */
public final class c implements p2.j<ImageDecoder.Source, Bitmap> {

    /* renamed from: a */
    public final s2.e f6602a = new s2.e();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(ImageDecoder.Source source, p2.h hVar) {
        return true;
    }

    @Override // p2.j
    /* renamed from: c */
    public final d b(ImageDecoder.Source source, int i7, int i8, p2.h hVar) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new x2.a(i7, i8, hVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder d7 = androidx.activity.h.d("Decoded [");
            d7.append(decodeBitmap.getWidth());
            d7.append("x");
            d7.append(decodeBitmap.getHeight());
            d7.append("] for [");
            d7.append(i7);
            d7.append("x");
            d7.append(i8);
            d7.append("]");
            Log.v("BitmapImageDecoder", d7.toString());
        }
        return new d(decodeBitmap, this.f6602a);
    }
}
