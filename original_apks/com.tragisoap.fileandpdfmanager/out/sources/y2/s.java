package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.InputStream;
import k3.a;
import p2.h;
import p2.j;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class s implements j<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final c f6651a = new c();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(InputStream inputStream, h hVar) {
        return true;
    }

    @Override // p2.j
    public final v<Bitmap> b(InputStream inputStream, int i7, int i8, h hVar) {
        return this.f6651a.b(ImageDecoder.createSource(a.b(inputStream)), i7, i8, hVar);
    }
}
