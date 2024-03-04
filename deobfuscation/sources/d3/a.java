package d3;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import p2.h;
import r2.v;

/* loaded from: classes.dex */
public final class a implements b<Bitmap, byte[]> {

    /* renamed from: f */
    public final Bitmap.CompressFormat f3560f = Bitmap.CompressFormat.JPEG;

    /* renamed from: g */
    public final int f3561g = 100;

    @Override // d3.b
    public final v<byte[]> b(v<Bitmap> vVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f3560f, this.f3561g, byteArrayOutputStream);
        vVar.recycle();
        return new z2.b(byteArrayOutputStream.toByteArray());
    }
}
