package com.rajat.pdfviewer;

import a6.x;
import com.rajat.pdfviewer.b;
import f5.g;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import k5.i;
import q5.p;
import r5.h;
import r5.q;
import r5.r;

@k5.e(c = "com.rajat.pdfviewer.PdfDownloader$download$2", f = "PdfDownloader.kt", l = {83, 89, 93}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class c extends i implements p {

    /* renamed from: j */
    public File f3474j;

    /* renamed from: k */
    public Closeable f3475k;

    /* renamed from: l */
    public com.rajat.pdfviewer.b f3476l;
    public BufferedInputStream m;

    /* renamed from: n */
    public Closeable f3477n;

    /* renamed from: o */
    public FileOutputStream f3478o;

    /* renamed from: p */
    public byte[] f3479p;

    /* renamed from: q */
    public r f3480q;

    /* renamed from: r */
    public q f3481r;
    public int s;

    /* renamed from: t */
    public int f3482t;

    /* renamed from: u */
    public final /* synthetic */ com.rajat.pdfviewer.b f3483u;

    /* renamed from: v */
    public final /* synthetic */ String f3484v;

    /* renamed from: w */
    public final /* synthetic */ String f3485w;

    @k5.e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$1$1$2", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class a extends i implements p {

        /* renamed from: j */
        public final /* synthetic */ com.rajat.pdfviewer.b f3486j;

        /* renamed from: k */
        public final /* synthetic */ r f3487k;

        /* renamed from: l */
        public final /* synthetic */ int f3488l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.rajat.pdfviewer.b bVar, r rVar, int i7, i5.d dVar) {
            super(2, dVar);
            this.f3486j = bVar;
            this.f3487k = rVar;
            this.f3488l = i7;
        }

        public final Object i(Object obj, Object obj2) {
            return ((a) p((x) obj, (i5.d) obj2)).s(g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new a(this.f3486j, this.f3487k, this.f3488l, dVar);
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            this.f3486j.f3473d.c(this.f3487k.f5926f, this.f3488l);
            return g.f4141a;
        }
    }

    @k5.e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$2", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class b extends i implements p {

        /* renamed from: j */
        public final /* synthetic */ com.rajat.pdfviewer.b f3489j;

        /* renamed from: k */
        public final /* synthetic */ File f3490k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.rajat.pdfviewer.b bVar, File file, i5.d dVar) {
            super(2, dVar);
            this.f3489j = bVar;
            this.f3490k = file;
        }

        public final Object i(Object obj, Object obj2) {
            return ((b) p((x) obj, (i5.d) obj2)).s(g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new b(this.f3489j, this.f3490k, dVar);
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            b.a aVar2 = this.f3489j.f3473d;
            String absolutePath = this.f3490k.getAbsolutePath();
            h.e(absolutePath, "getAbsolutePath(...)");
            aVar2.d(absolutePath);
            return g.f4141a;
        }
    }

    @k5.e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$3", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.rajat.pdfviewer.c$c */
    /* loaded from: classes.dex */
    public static final class C0040c extends i implements p {

        /* renamed from: j */
        public final /* synthetic */ com.rajat.pdfviewer.b f3491j;

        /* renamed from: k */
        public final /* synthetic */ Exception f3492k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0040c(com.rajat.pdfviewer.b bVar, Exception exc, i5.d dVar) {
            super(2, dVar);
            this.f3491j = bVar;
            this.f3492k = exc;
        }

        public final Object i(Object obj, Object obj2) {
            return ((C0040c) p((x) obj, (i5.d) obj2)).s(g.f4141a);
        }

        public final i5.d p(Object obj, i5.d dVar) {
            return new C0040c(this.f3491j, this.f3492k, dVar);
        }

        public final Object s(Object obj) {
            Kotlin_1.a aVar = Kotlin_1.a.f4591f;
            f5.e.b(obj);
            this.f3491j.f3473d.b(this.f3492k);
            return g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.rajat.pdfviewer.b bVar, String str, String str2, i5.d dVar) {
        super(2, dVar);
        this.f3483u = bVar;
        this.f3484v = str;
        this.f3485w = str2;
    }

    public final Object i(Object obj, Object obj2) {
        return ((c) p((x) obj, (i5.d) obj2)).s(g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new c(this.f3483u, this.f3484v, this.f3485w, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0104 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #4 {all -> 0x013d, blocks: (B:102:0x0107, B:90:0x00a5, B:80:0x0037, B:93:0x00bf, B:95:0x00c8, B:100:0x0104, B:92:0x00ac), top: B:127:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0170 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c8 A[Catch: all -> 0x003d, TryCatch #4 {all -> 0x013d, blocks: (B:102:0x0107, B:90:0x00a5, B:80:0x0037, B:93:0x00bf, B:95:0x00c8, B:100:0x0104, B:92:0x00ac), top: B:127:0x0009 }] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0100 -> B:99:0x0101). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rajat.pdfviewer.c.s(java.lang.Object):java.lang.Object");
    }
}
