package y2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;
import p2.h;
import p2.j;
import r2.v;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g implements j<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final c f6608a = new c();

    @Override // p2.j
    public final /* bridge */ /* synthetic */ boolean a(ByteBuffer byteBuffer, h hVar) {
        return true;
    }

    @Override // p2.j
    public final v<Bitmap> b(ByteBuffer byteBuffer, int i7, int i8, h hVar) {
        return this.f6608a.b(ImageDecoder.createSource(byteBuffer), i7, i8, hVar);
    }
}
