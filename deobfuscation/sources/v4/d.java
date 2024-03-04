package v4;

import a6.h0;
import a6.x;
import a6.y;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import android.util.LruCache;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import linc.com.amplituda.ErrorCode;
import q5.p;
import q5.q;

@TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public final Context f6274a;

    /* renamed from: b */
    public PdfRenderer f6275b;

    /* renamed from: c */
    public final a f6276c = new a(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);

    /* loaded from: classes.dex */
    public static final class a extends LruCache {
        public a(int i7) {
            super(i7);
        }

        public final int sizeOf(Object obj, Object obj2) {
            ((Number) obj).intValue();
            Bitmap bitmap = (Bitmap) obj2;
            r5.h.f(bitmap, "bitmap");
            return bitmap.getByteCount() / 1024;
        }
    }

    @k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends k5.i implements p {

        /* renamed from: j */
        public final /* synthetic */ q f6277j;

        /* renamed from: k */
        public final /* synthetic */ int f6278k;

        /* renamed from: l */
        public final /* synthetic */ Bitmap f6279l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q qVar, int i7, Bitmap bitmap, i5.d dVar) {
            super(2, dVar);
            this.f6277j = qVar;
            this.f6278k = i7;
            this.f6279l = bitmap;
        }

        public final Object i(Object obj, Object obj2) {
            return ((b) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new b(this.f6277j, this.f6278k, this.f6279l, dVar);
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            q qVar = this.f6277j;
            if (qVar != null) {
                qVar.f(Boolean.TRUE, new Integer(this.f6278k), this.f6279l);
            }
            return f5.g.f4141a;
        }
    }

    @k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class c extends k5.i implements p {

        /* renamed from: k */
        public final /* synthetic */ int f6281k;

        /* renamed from: l */
        public final /* synthetic */ Bitmap f6282l;
        public final /* synthetic */ q m;

        @k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class a extends k5.i implements p {

            /* renamed from: j */
            public final /* synthetic */ d f6283j;

            /* renamed from: k */
            public final /* synthetic */ int f6284k;

            /* renamed from: l */
            public final /* synthetic */ Bitmap f6285l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i7, Bitmap bitmap, i5.d dVar2) {
                super(2, dVar2);
                this.f6283j = dVar;
                this.f6284k = i7;
                this.f6285l = bitmap;
            }

            public final Object i(Object obj, Object obj2) {
                return ((a) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
            }

            public final i5.d p(Object obj, i5.d dVar) {
                return new a(this.f6283j, this.f6284k, this.f6285l, dVar);
            }

            public final Object s(Object obj) {
                Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                f5.e.b(obj);
                d dVar = this.f6283j;
                int i7 = this.f6284k;
                Bitmap bitmap = this.f6285l;
                dVar.getClass();
                a0.e.u(y.a(h0.f298b), null, 0, new f(dVar, i7, bitmap, null), 3);
                return f5.g.f4141a;
            }
        }

        @k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$2", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class b extends k5.i implements p {

            /* renamed from: j */
            public final /* synthetic */ q f6286j;

            /* renamed from: k */
            public final /* synthetic */ int f6287k;

            /* renamed from: l */
            public final /* synthetic */ Bitmap f6288l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(q qVar, int i7, Bitmap bitmap, i5.d dVar) {
                super(2, dVar);
                this.f6286j = qVar;
                this.f6287k = i7;
                this.f6288l = bitmap;
            }

            public final Object i(Object obj, Object obj2) {
                return ((b) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
            }

            public final i5.d p(Object obj, i5.d dVar) {
                return new b(this.f6286j, this.f6287k, this.f6288l, dVar);
            }

            public final Object s(Object obj) {
                Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                f5.e.b(obj);
                q qVar = this.f6286j;
                if (qVar != null) {
                    qVar.f(Boolean.TRUE, new Integer(this.f6287k), this.f6288l);
                }
                return f5.g.f4141a;
            }
        }

        @k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$3", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* renamed from: v4.d$c$c */
        /* loaded from: classes.dex */
        public static final class C0124c extends k5.i implements p {

            /* renamed from: j */
            public final /* synthetic */ q f6289j;

            /* renamed from: k */
            public final /* synthetic */ int f6290k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0124c(q qVar, int i7, i5.d dVar) {
                super(2, dVar);
                this.f6289j = qVar;
                this.f6290k = i7;
            }

            public final Object i(Object obj, Object obj2) {
                return ((C0124c) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
            }

            public final i5.d p(Object obj, i5.d dVar) {
                return new C0124c(this.f6289j, this.f6290k, dVar);
            }

            public final Object s(Object obj) {
                Kotlin_1.a aVar = Kotlin_1.a.f4591f;
                f5.e.b(obj);
                q qVar = this.f6289j;
                if (qVar != null) {
                    qVar.f(Boolean.FALSE, new Integer(this.f6290k), null);
                }
                return f5.g.f4141a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i7, Bitmap bitmap, q qVar, i5.d dVar) {
            super(2, dVar);
            d.this = r1;
            this.f6281k = i7;
            this.f6282l = bitmap;
            this.m = qVar;
        }

        public final Object i(Object obj, Object obj2) {
            return ((c) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new c(this.f6281k, this.f6282l, this.m, dVar);
        }

        public final Object s(Object obj) {
            PdfRenderer.Page openPage;
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            d dVar = d.this;
            int i7 = this.f6281k;
            Bitmap bitmap = this.f6282l;
            q qVar = this.m;
            synchronized (dVar) {
                PdfRenderer pdfRenderer = dVar.f6275b;
                if (pdfRenderer != null && (openPage = pdfRenderer.openPage(i7)) != null) {
                    try {
                        bitmap.eraseColor(-1);
                        openPage.render(bitmap, null, null, 1);
                        if (dVar.f6276c.get(Integer.valueOf(i7)) == null) {
                            dVar.f6276c.put(Integer.valueOf(i7), bitmap);
                        }
                        a0.e.u(y.a(h0.f298b), null, 0, new a(dVar, i7, bitmap, null), 3);
                        a0.e.u(y.a(f6.m.f4172a), null, 0, new b(qVar, i7, bitmap, null), 3);
                    } catch (Exception unused) {
                        g6.c cVar = h0.f297a;
                        a0.e.u(y.a(f6.m.f4172a), null, 0, new C0124c(qVar, i7, null), 3);
                    }
                    f5.g gVar = f5.g.f4141a;
                    openPage.close();
                }
            }
            return f5.g.f4141a;
        }
    }

    public d(Context context, File file) {
        this.f6274a = context;
        String path = file.getPath();
        r5.h.e(path, "getPath(...)");
        String str = "";
        try {
            str = Files.exists(Paths.get(path, new String[0]), new LinkOption[0]) ? path : "";
        } catch (Exception unused) {
        }
        this.f6275b = new PdfRenderer(ParcelFileDescriptor.open(new File(str), 268435456));
        File file2 = new File(this.f6274a.getCacheDir(), "___pdf___cache___");
        if (file2.exists()) {
            p5.c.O(file2);
        }
        file2.mkdirs();
    }

    public final void a(int i7, Bitmap bitmap, q qVar) {
        PdfRenderer pdfRenderer = this.f6275b;
        if (i7 >= (pdfRenderer != null ? pdfRenderer.getPageCount() : 0)) {
            qVar.f(Boolean.FALSE, Integer.valueOf(i7), null);
            return;
        }
        Bitmap bitmap2 = (Bitmap) this.f6276c.get(Integer.valueOf(i7));
        if (bitmap2 == null) {
            File file = new File(new File(this.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(i7));
            if (file.exists()) {
                bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (bitmap2 != null && this.f6276c.get(Integer.valueOf(i7)) == null) {
                    this.f6276c.put(Integer.valueOf(i7), bitmap2);
                }
            } else {
                bitmap2 = null;
            }
        }
        if (bitmap2 == null) {
            a0.e.u(y.a(h0.f298b), null, 0, new c(i7, bitmap, qVar, null), 3);
            return;
        }
        g6.c cVar = h0.f297a;
        a0.e.u(y.a(f6.m.f4172a), null, 0, new b(qVar, i7, bitmap2, null), 3);
    }
}
