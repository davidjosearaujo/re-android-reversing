package c3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p2.h;
import p2.j;
import r2.v;
import s2.b;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i implements j<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ImageHeaderParser> f2561a;

    /* renamed from: b  reason: collision with root package name */
    public final j<ByteBuffer, c> f2562b;

    /* renamed from: c  reason: collision with root package name */
    public final b f2563c;

    public i(List list, a aVar, b bVar) {
        this.f2561a = list;
        this.f2562b = aVar;
        this.f2563c = bVar;
    }

    @Override // p2.j
    public final boolean a(InputStream inputStream, h hVar) {
        InputStream inputStream2 = inputStream;
        if (!((Boolean) hVar.c(h.f2560b)).booleanValue()) {
            if (a.c(this.f2563c, inputStream2, this.f2561a) == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    @Override // p2.j
    public final v<c> b(InputStream inputStream, int i7, int i8, h hVar) {
        byte[] bArr;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f2562b.b(ByteBuffer.wrap(bArr), i7, i8, hVar);
    }
}
