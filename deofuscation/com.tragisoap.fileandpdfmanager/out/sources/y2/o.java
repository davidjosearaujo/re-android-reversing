package y2;

import a2.a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import k3.a;
import s2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class o implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int b(InputStream inputStream, b bVar) {
        a aVar = new a(inputStream);
        a.c c7 = aVar.c("Orientation");
        int i7 = 1;
        if (c7 != null) {
            try {
                i7 = c7.f(aVar.f95f);
            } catch (NumberFormatException unused) {
            }
        }
        if (i7 == 0) {
            return -1;
        }
        return i7;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final int c(ByteBuffer byteBuffer, b bVar) {
        AtomicReference<byte[]> atomicReference = k3.a.f4685a;
        return b(new a.C0074a(byteBuffer), bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public final ImageHeaderParser.ImageType d(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}