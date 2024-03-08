package d3;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import p2.h;
import r2.v;
import z2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a implements b<Bitmap, byte[]> {

    /* renamed from: f  reason: collision with root package name */
    public final Bitmap.CompressFormat f3560f = Bitmap.CompressFormat.JPEG;

    /* renamed from: g  reason: collision with root package name */
    public final int f3561g = 100;

    @Override // d3.b
    public final v<byte[]> b(v<Bitmap> vVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f3560f, this.f3561g, byteArrayOutputStream);
        vVar.recycle();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
