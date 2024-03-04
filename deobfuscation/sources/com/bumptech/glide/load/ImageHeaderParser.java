package com.bumptech.glide.load;

import java.io.InputStream;
import java.nio.ByteBuffer;
import s2.b;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);
        

        /* renamed from: f */
        public final boolean f2659f;

        ImageType(boolean z6) {
            this.f2659f = z6;
        }

        public boolean hasAlpha() {
            return this.f2659f;
        }

        public boolean isWebp() {
            int i7 = a.f2660a[ordinal()];
            return i7 == 1 || i7 == 2 || i7 == 3;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f2660a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f2660a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2660a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2660a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    ImageType a(ByteBuffer byteBuffer);

    int b(InputStream inputStream, b bVar);

    int c(ByteBuffer byteBuffer, b bVar);

    ImageType d(InputStream inputStream);
}
