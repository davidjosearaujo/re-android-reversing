package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class g implements p2.j<ByteBuffer, Bitmap> {

    /* renamed from: a */
    public final c f6608a = new c();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, p2.h hVar) {
        return true;
    }

    @Override // p2.j
    public final r2.v<Bitmap> b(ByteBuffer byteBuffer, int i7, int i8, p2.h hVar) {
        return this.f6608a.b(ImageDecoder.createSource(byteBuffer), i7, i8, hVar);
    }
}
