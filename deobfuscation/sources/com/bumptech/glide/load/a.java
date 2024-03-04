package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import s2.b;
import y2.t;

/* loaded from: classes.dex */
public final class a {
    public static int a(b bVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new t(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            try {
                int b2 = ((ImageHeaderParser) list.get(i7)).b(inputStream, bVar);
                if (b2 != -1) {
                    return b2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            try {
                ImageHeaderParser.ImageType a7 = list.get(i7).a(byteBuffer);
                k3.a.c(byteBuffer);
                if (a7 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return a7;
                }
            } catch (Throwable th) {
                k3.a.c(byteBuffer);
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType c(b bVar, InputStream inputStream, List list) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new t(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            try {
                ImageHeaderParser.ImageType d7 = ((ImageHeaderParser) list.get(i7)).d(inputStream);
                inputStream.reset();
                if (d7 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return d7;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
