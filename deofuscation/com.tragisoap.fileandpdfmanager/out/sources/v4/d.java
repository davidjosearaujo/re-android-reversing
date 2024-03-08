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
import f5.g;
import f6.m;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import k5.e;
import k5.i;
import linc.com.amplituda.ErrorCode;
import q5.p;
import q5.q;
import r5.h;
@TargetApi(ErrorCode.FILE_NOT_FOUND_IO_CODE)
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d {

    /* renamed from: a */
    public final Context f6274a;

    /* renamed from: b */
    public PdfRenderer f6275b;

    /* renamed from: c */
    public final a f6276c = new a(((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8);

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends LruCache<Integer, Bitmap> {
        public a(int i7) {
            super(i7);
        }

        @Override // android.util.LruCache
        public final int sizeOf(Integer num, Bitmap bitmap) {
            num.intValue();
            Bitmap bitmap2 = bitmap;
            h.f(bitmap2, "bitmap");
            return bitmap2.getByteCount() / 1024;
        }
    }

    @e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements p<x, i5.d<? super g>, Object> {

        /* renamed from: j */
        public final /* synthetic */ q<Boolean, Integer, Bitmap, g> f6277j;

        /* renamed from: k */
        public final /* synthetic */ int f6278k;

        /* renamed from: l */
        public final /* synthetic */ Bitmap f6279l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(q<? super Boolean, ? super Integer, ? super Bitmap, g> qVar, int i7, Bitmap bitmap, i5.d<? super b> dVar) {
            super(2, dVar);
            this.f6277j = qVar;
            this.f6278k = i7;
            this.f6279l = bitmap;
        }

        @Override // q5.p
        public final Object i(x xVar, i5.d<? super g> dVar) {
            return ((b) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final i5.d<g> p(Object obj, i5.d<?> dVar) {
            return new b(this.f6277j, this.f6278k, this.f6279l, dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            q<Boolean, Integer, Bitmap, g> qVar = this.f6277j;
            if (qVar != null) {
                qVar.f(Boolean.TRUE, new Integer(this.f6278k), this.f6279l);
            }
            return g.f4141a;
        }
    }

    @e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class c extends i implements p<x, i5.d<? super g>, Object> {

        /* renamed from: k */
        public final /* synthetic */ int f6281k;

        /* renamed from: l */
        public final /* synthetic */ Bitmap f6282l;
        public final /* synthetic */ q<Boolean, Integer, Bitmap, g> m;

        @e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class a extends i implements p<x, i5.d<? super g>, Object> {

            /* renamed from: j */
            public final /* synthetic */ d f6283j;

            /* renamed from: k */
            public final /* synthetic */ int f6284k;

            /* renamed from: l */
            public final /* synthetic */ Bitmap f6285l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i7, Bitmap bitmap, i5.d<? super a> dVar2) {
                super(2, dVar2);
                this.f6283j = dVar;
                this.f6284k = i7;
                this.f6285l = bitmap;
            }

            @Override // q5.p
            public final Object i(x xVar, i5.d<? super g> dVar) {
                return ((a) p(xVar, dVar)).s(g.f4141a);
            }

            @Override // k5.a
            public final i5.d<g> p(Object obj, i5.d<?> dVar) {
                return new a(this.f6283j, this.f6284k, this.f6285l, dVar);
            }

            @Override // k5.a
            public final Object s(Object obj) {
                j5.a aVar = j5.a.f4591f;
                f5.e.b(obj);
                d dVar = this.f6283j;
                int i7 = this.f6284k;
                Bitmap bitmap = this.f6285l;
                dVar.getClass();
                a0.e.u(y.a(h0.f298b), null, 0, new f(dVar, i7, bitmap, null), 3);
                return g.f4141a;
            }
        }

        @e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$2", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class b extends i implements p<x, i5.d<? super g>, Object> {

            /* renamed from: j */
            public final /* synthetic */ q<Boolean, Integer, Bitmap, g> f6286j;

            /* renamed from: k */
            public final /* synthetic */ int f6287k;

            /* renamed from: l */
            public final /* synthetic */ Bitmap f6288l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(q<? super Boolean, ? super Integer, ? super Bitmap, g> qVar, int i7, Bitmap bitmap, i5.d<? super b> dVar) {
                super(2, dVar);
                this.f6286j = qVar;
                this.f6287k = i7;
                this.f6288l = bitmap;
            }

            @Override // q5.p
            public final Object i(x xVar, i5.d<? super g> dVar) {
                return ((b) p(xVar, dVar)).s(g.f4141a);
            }

            @Override // k5.a
            public final i5.d<g> p(Object obj, i5.d<?> dVar) {
                return new b(this.f6286j, this.f6287k, this.f6288l, dVar);
            }

            @Override // k5.a
            public final Object s(Object obj) {
                j5.a aVar = j5.a.f4591f;
                f5.e.b(obj);
                q<Boolean, Integer, Bitmap, g> qVar = this.f6286j;
                if (qVar != null) {
                    qVar.f(Boolean.TRUE, new Integer(this.f6287k), this.f6288l);
                }
                return g.f4141a;
            }
        }

        @e(c = "com.rajat.pdfviewer.PdfRendererCore$renderPage$2$1$1$3", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
        /* renamed from: v4.d$c$c */
        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public static final class C0124c extends i implements p<x, i5.d<? super g>, Object> {

            /* renamed from: j */
            public final /* synthetic */ q<Boolean, Integer, Bitmap, g> f6289j;

            /* renamed from: k */
            public final /* synthetic */ int f6290k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0124c(q<? super Boolean, ? super Integer, ? super Bitmap, g> qVar, int i7, i5.d<? super C0124c> dVar) {
                super(2, dVar);
                this.f6289j = qVar;
                this.f6290k = i7;
            }

            @Override // q5.p
            public final Object i(x xVar, i5.d<? super g> dVar) {
                return ((C0124c) p(xVar, dVar)).s(g.f4141a);
            }

            @Override // k5.a
            public final i5.d<g> p(Object obj, i5.d<?> dVar) {
                return new C0124c(this.f6289j, this.f6290k, dVar);
            }

            @Override // k5.a
            public final Object s(Object obj) {
                j5.a aVar = j5.a.f4591f;
                f5.e.b(obj);
                q<Boolean, Integer, Bitmap, g> qVar = this.f6289j;
                if (qVar != null) {
                    qVar.f(Boolean.FALSE, new Integer(this.f6290k), null);
                }
                return g.f4141a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(int i7, Bitmap bitmap, q<? super Boolean, ? super Integer, ? super Bitmap, g> qVar, i5.d<? super c> dVar) {
            super(2, dVar);
            d.this = r1;
            this.f6281k = i7;
            this.f6282l = bitmap;
            this.m = qVar;
        }

        @Override // q5.p
        public final Object i(x xVar, i5.d<? super g> dVar) {
            return ((c) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final i5.d<g> p(Object obj, i5.d<?> dVar) {
            return new c(this.f6281k, this.f6282l, this.m, dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            PdfRenderer.Page openPage;
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            d dVar = d.this;
            int i7 = this.f6281k;
            Bitmap bitmap = this.f6282l;
            q<Boolean, Integer, Bitmap, g> qVar = this.m;
            synchronized (dVar) {
                PdfRenderer pdfRenderer = dVar.f6275b;
                if (!(pdfRenderer == null || (openPage = pdfRenderer.openPage(i7)) == null)) {
                    try {
                        bitmap.eraseColor(-1);
                        openPage.render(bitmap, null, null, 1);
                        if (dVar.f6276c.get(Integer.valueOf(i7)) == null) {
                            dVar.f6276c.put(Integer.valueOf(i7), bitmap);
                        }
                        a0.e.u(y.a(h0.f298b), null, 0, new a(dVar, i7, bitmap, null), 3);
                        a0.e.u(y.a(m.f4172a), null, 0, new b(qVar, i7, bitmap, null), 3);
                    } catch (Exception unused) {
                        g6.c cVar = h0.f297a;
                        a0.e.u(y.a(m.f4172a), null, 0, new C0124c(qVar, i7, null), 3);
                    }
                    g gVar = g.f4141a;
                    openPage.close();
                }
            }
            return g.f4141a;
        }
    }

    public d(Context context, File file) {
        this.f6274a = context;
        String path = file.getPath();
        h.e(path, "getPath(...)");
        path = "";
        try {
            path = !Files.exists(Paths.get(path, new String[0]), new LinkOption[0]) ? path : path;
        } catch (Exception unused) {
        }
        this.f6275b = new PdfRenderer(ParcelFileDescriptor.open(new File(path), 268435456));
        File file2 = new File(this.f6274a.getCacheDir(), "___pdf___cache___");
        if (file2.exists()) {
            p5.c.O(file2);
        }
        file2.mkdirs();
    }

    public final void a(int i7, Bitmap bitmap, q<? super Boolean, ? super Integer, ? super Bitmap, g> qVar) {
        PdfRenderer pdfRenderer = this.f6275b;
        if (i7 >= (pdfRenderer != null ? pdfRenderer.getPageCount() : 0)) {
            qVar.f(Boolean.FALSE, Integer.valueOf(i7), null);
            return;
        }
        Bitmap bitmap2 = this.f6276c.get(Integer.valueOf(i7));
        if (bitmap2 == null) {
            File file = new File(new File(this.f6274a.getCacheDir(), "___pdf___cache___"), String.valueOf(i7));
            if (!file.exists()) {
                bitmap2 = null;
            } else {
                bitmap2 = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (bitmap2 != null && this.f6276c.get(Integer.valueOf(i7)) == null) {
                    this.f6276c.put(Integer.valueOf(i7), bitmap2);
                }
            }
        }
        if (bitmap2 != null) {
            g6.c cVar = h0.f297a;
            a0.e.u(y.a(m.f4172a), null, 0, new b(qVar, i7, bitmap2, null), 3);
            return;
        }
        a0.e.u(y.a(h0.f298b), null, 0, new c(i7, bitmap, qVar, null), 3);
    }
}
