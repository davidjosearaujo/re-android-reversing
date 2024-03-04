package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class s implements p2.j<InputStream, Bitmap> {

    /* renamed from: a */
    public final c f6651a = new c();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(InputStream inputStream, p2.h hVar) {
        return true;
    }

    @Override // p2.j
    public final r2.v<Bitmap> b(InputStream inputStream, int i7, int i8, p2.h hVar) {
        return this.f6651a.b(ImageDecoder.createSource(k3.a.b(inputStream)), i7, i8, hVar);
    }
}
