package c3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p2.j;
import r2.v;

/* loaded from: classes.dex */
public final class i implements j<InputStream, c> {

    /* renamed from: a */
    public final List<ImageHeaderParser> f2561a;

    /* renamed from: b */
    public final j<ByteBuffer, c> f2562b;

    /* renamed from: c */
    public final s2.b f2563c;

    public i(List list, a aVar, s2.b bVar) {
        this.f2561a = list;
        this.f2562b = aVar;
        this.f2563c = bVar;
    }

    @Override // p2.j
    public final boolean a(InputStream inputStream, p2.h hVar) {
        InputStream inputStream2 = inputStream;
        if (!((Boolean) hVar.c(h.f2560b)).booleanValue()) {
            if (com.bumptech.glide.load.a.c(this.f2563c, inputStream2, this.f2561a) == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
        }
        return false;
    }

    @Override // p2.j
    public final v<c> b(InputStream inputStream, int i7, int i8, p2.h hVar) {
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
