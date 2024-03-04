package a3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import k3.l;
import p2.h;
import p2.j;
import r2.v;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public final List<ImageHeaderParser> f119a;

    /* renamed from: b */
    public final s2.b f120b;

    /* renamed from: a3.a$a */
    /* loaded from: classes.dex */
    public static final class C0003a implements v<Drawable> {

        /* renamed from: f */
        public final AnimatedImageDrawable f121f;

        public C0003a(AnimatedImageDrawable animatedImageDrawable) {
            this.f121f = animatedImageDrawable;
        }

        @Override // r2.v
        public final int b() {
            return l.d(Bitmap.Config.ARGB_8888) * this.f121f.getIntrinsicHeight() * this.f121f.getIntrinsicWidth() * 2;
        }

        @Override // r2.v
        public final Class<Drawable> c() {
            return Drawable.class;
        }

        @Override // r2.v
        public final Drawable get() {
            return this.f121f;
        }

        @Override // r2.v
        public final void recycle() {
            this.f121f.stop();
            this.f121f.clearAnimationCallbacks();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements j<ByteBuffer, Drawable> {

        /* renamed from: a */
        public final a f122a;

        public b(a aVar) {
            this.f122a = aVar;
        }

        @Override // p2.j
        public final boolean a(ByteBuffer byteBuffer, h hVar) {
            return com.bumptech.glide.load.a.b(this.f122a.f119a, byteBuffer) == ImageHeaderParser.ImageType.ANIMATED_WEBP;
        }

        @Override // p2.j
        public final v<Drawable> b(ByteBuffer byteBuffer, int i7, int i8, h hVar) {
            ImageDecoder.Source createSource = ImageDecoder.createSource(byteBuffer);
            this.f122a.getClass();
            return a.a(createSource, i7, i8, hVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements j<InputStream, Drawable> {

        /* renamed from: a */
        public final a f123a;

        public c(a aVar) {
            this.f123a = aVar;
        }

        @Override // p2.j
        public final boolean a(InputStream inputStream, h hVar) {
            a aVar = this.f123a;
            return com.bumptech.glide.load.a.c(aVar.f120b, inputStream, aVar.f119a) == ImageHeaderParser.ImageType.ANIMATED_WEBP;
        }

        @Override // p2.j
        public final v<Drawable> b(InputStream inputStream, int i7, int i8, h hVar) {
            ImageDecoder.Source createSource = ImageDecoder.createSource(k3.a.b(inputStream));
            this.f123a.getClass();
            return a.a(createSource, i7, i8, hVar);
        }
    }

    public a(List<ImageHeaderParser> list, s2.b bVar) {
        this.f119a = list;
        this.f120b = bVar;
    }

    public static C0003a a(ImageDecoder.Source source, int i7, int i8, h hVar) {
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new x2.a(i7, i8, hVar));
        if (decodeDrawable instanceof AnimatedImageDrawable) {
            return new C0003a((AnimatedImageDrawable) decodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + decodeDrawable);
    }
}
