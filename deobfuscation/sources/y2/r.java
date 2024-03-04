package y2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.List;
import k3.a;

/* loaded from: classes.dex */
public interface r {

    /* loaded from: classes.dex */
    public static final class a implements r {

        /* renamed from: a */
        public final ByteBuffer f6642a;

        /* renamed from: b */
        public final List<ImageHeaderParser> f6643b;

        /* renamed from: c */
        public final s2.b f6644c;

        public a(s2.b bVar, ByteBuffer byteBuffer, List list) {
            this.f6642a = byteBuffer;
            this.f6643b = list;
            this.f6644c = bVar;
        }

        @Override // y2.r
        public final Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(new a.C0074a(k3.a.c(this.f6642a)), null, options);
        }

        @Override // y2.r
        public final void b() {
        }

        @Override // y2.r
        public final int c() {
            List<ImageHeaderParser> list = this.f6643b;
            ByteBuffer c7 = k3.a.c(this.f6642a);
            s2.b bVar = this.f6644c;
            if (c7 == null) {
                return -1;
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                try {
                    int c8 = list.get(i7).c(c7, bVar);
                    if (c8 != -1) {
                        return c8;
                    }
                } finally {
                    k3.a.c(c7);
                }
            }
            return -1;
        }

        @Override // y2.r
        public final ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.b(this.f6643b, k3.a.c(this.f6642a));
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements r {

        /* renamed from: a */
        public final com.bumptech.glide.load.data.k f6645a;

        /* renamed from: b */
        public final s2.b f6646b;

        /* renamed from: c */
        public final List<ImageHeaderParser> f6647c;

        public b(s2.b bVar, k3.j jVar, List list) {
            q2.a.i(bVar);
            this.f6646b = bVar;
            q2.a.i(list);
            this.f6647c = list;
            this.f6645a = new com.bumptech.glide.load.data.k(jVar, bVar);
        }

        @Override // y2.r
        public final Bitmap a(BitmapFactory.Options options) {
            com.bumptech.glide.load.data.k kVar = this.f6645a;
            kVar.f2683a.reset();
            return BitmapFactory.decodeStream(kVar.f2683a, null, options);
        }

        @Override // y2.r
        public final void b() {
            t tVar = this.f6645a.f2683a;
            synchronized (tVar) {
                tVar.f6654h = tVar.f6652f.length;
            }
        }

        @Override // y2.r
        public final int c() {
            List<ImageHeaderParser> list = this.f6647c;
            com.bumptech.glide.load.data.k kVar = this.f6645a;
            kVar.f2683a.reset();
            return com.bumptech.glide.load.a.a(this.f6646b, kVar.f2683a, list);
        }

        @Override // y2.r
        public final ImageHeaderParser.ImageType d() {
            List<ImageHeaderParser> list = this.f6647c;
            com.bumptech.glide.load.data.k kVar = this.f6645a;
            kVar.f2683a.reset();
            return com.bumptech.glide.load.a.c(this.f6646b, kVar.f2683a, list);
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements r {

        /* renamed from: a */
        public final s2.b f6648a;

        /* renamed from: b */
        public final List<ImageHeaderParser> f6649b;

        /* renamed from: c */
        public final ParcelFileDescriptorRewinder f6650c;

        public c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, s2.b bVar) {
            q2.a.i(bVar);
            this.f6648a = bVar;
            q2.a.i(list);
            this.f6649b = list;
            this.f6650c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // y2.r
        public final Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f6650c.a().getFileDescriptor(), null, options);
        }

        @Override // y2.r
        public final void b() {
        }

        @Override // y2.r
        public final int c() {
            t tVar;
            List<ImageHeaderParser> list = this.f6649b;
            ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = this.f6650c;
            s2.b bVar = this.f6648a;
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                ImageHeaderParser imageHeaderParser = list.get(i7);
                try {
                    tVar = new t(new FileInputStream(parcelFileDescriptorRewinder.a().getFileDescriptor()), bVar);
                } catch (Throwable th) {
                    th = th;
                    tVar = null;
                }
                try {
                    int b2 = imageHeaderParser.b(tVar, bVar);
                    tVar.d();
                    parcelFileDescriptorRewinder.a();
                    if (b2 != -1) {
                        return b2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (tVar != null) {
                        tVar.d();
                    }
                    parcelFileDescriptorRewinder.a();
                    throw th;
                }
            }
            return -1;
        }

        @Override // y2.r
        public final ImageHeaderParser.ImageType d() {
            t tVar;
            List<ImageHeaderParser> list = this.f6649b;
            ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = this.f6650c;
            s2.b bVar = this.f6648a;
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                ImageHeaderParser imageHeaderParser = list.get(i7);
                try {
                    tVar = new t(new FileInputStream(parcelFileDescriptorRewinder.a().getFileDescriptor()), bVar);
                } catch (Throwable th) {
                    th = th;
                    tVar = null;
                }
                try {
                    ImageHeaderParser.ImageType d7 = imageHeaderParser.d(tVar);
                    tVar.d();
                    parcelFileDescriptorRewinder.a();
                    if (d7 != ImageHeaderParser.ImageType.UNKNOWN) {
                        return d7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (tVar != null) {
                        tVar.d();
                    }
                    parcelFileDescriptorRewinder.a();
                    throw th;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void b();

    int c();

    ImageHeaderParser.ImageType d();
}
