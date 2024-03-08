package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import p2.h;
import p2.j;
import s2.e;
import x2.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c implements j<ImageDecoder.Source, Bitmap> {

    /* renamed from: a */
    public final e f6602a = new e();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(ImageDecoder.Source source, h hVar) {
        return true;
    }

    /* renamed from: c */
    public final d b(ImageDecoder.Source source, int i7, int i8, h hVar) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new a(i7, i8, hVar));
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
