package com.rajat.pdfviewer;

import a6.x;
import com.rajat.pdfviewer.b;
import f5.g;
import i5.d;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import k5.e;
import k5.i;
import q5.p;
import r5.h;
import r5.q;
import r5.r;
@e(c = "com.rajat.pdfviewer.PdfDownloader$download$2", f = "PdfDownloader.kt", l = {83, 89, 93}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class c extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public File f3474j;

    /* renamed from: k  reason: collision with root package name */
    public Closeable f3475k;

    /* renamed from: l  reason: collision with root package name */
    public b f3476l;
    public BufferedInputStream m;

    /* renamed from: n  reason: collision with root package name */
    public Closeable f3477n;

    /* renamed from: o  reason: collision with root package name */
    public FileOutputStream f3478o;

    /* renamed from: p  reason: collision with root package name */
    public byte[] f3479p;

    /* renamed from: q  reason: collision with root package name */
    public r f3480q;

    /* renamed from: r  reason: collision with root package name */
    public q f3481r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public int f3482t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ b f3483u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ String f3484v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ String f3485w;

    @e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$1$1$2", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends i implements p<x, d<? super g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f3486j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ r f3487k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ int f3488l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, r rVar, int i7, d<? super a> dVar) {
            super(2, dVar);
            this.f3486j = bVar;
            this.f3487k = rVar;
            this.f3488l = i7;
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super g> dVar) {
            return ((a) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            return new a(this.f3486j, this.f3487k, this.f3488l, dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            this.f3486j.f3473d.c(this.f3487k.f5926f, (long) this.f3488l);
            return g.f4141a;
        }
    }

    @e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$2", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class b extends i implements p<x, d<? super g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f3489j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ File f3490k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b bVar, File file, d<? super b> dVar) {
            super(2, dVar);
            this.f3489j = bVar;
            this.f3490k = file;
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super g> dVar) {
            return ((b) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            return new b(this.f3489j, this.f3490k, dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            b.a aVar2 = this.f3489j.f3473d;
            String absolutePath = this.f3490k.getAbsolutePath();
            h.e(absolutePath, "getAbsolutePath(...)");
            aVar2.d(absolutePath);
            return g.f4141a;
        }
    }

    @e(c = "com.rajat.pdfviewer.PdfDownloader$download$2$3", f = "PdfDownloader.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.rajat.pdfviewer.c$c  reason: collision with other inner class name */
    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class C0040c extends i implements p<x, d<? super g>, Object> {

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f3491j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ Exception f3492k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0040c(b bVar, Exception exc, d<? super C0040c> dVar) {
            super(2, dVar);
            this.f3491j = bVar;
            this.f3492k = exc;
        }

        @Override // q5.p
        public final Object i(x xVar, d<? super g> dVar) {
            return ((C0040c) p(xVar, dVar)).s(g.f4141a);
        }

        @Override // k5.a
        public final d<g> p(Object obj, d<?> dVar) {
            return new C0040c(this.f3491j, this.f3492k, dVar);
        }

        @Override // k5.a
        public final Object s(Object obj) {
            j5.a aVar = j5.a.f4591f;
            f5.e.b(obj);
            this.f3491j.f3473d.b(this.f3492k);
            return g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, String str, String str2, d<? super c> dVar) {
        super(2, dVar);
        this.f3483u = bVar;
        this.f3484v = str;
        this.f3485w = str2;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((c) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new c(this.f3483u, this.f3484v, this.f3485w, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8 A[Catch: all -> 0x003d, TryCatch #4 {all -> 0x013d, blocks: (B:20:0x00a5, B:32:0x0107, B:12:0x0037, B:22:0x00ac, B:23:0x00bf, B:25:0x00c8, B:30:0x0104), top: B:51:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #4 {all -> 0x013d, blocks: (B:20:0x00a5, B:32:0x0107, B:12:0x0037, B:22:0x00ac, B:23:0x00bf, B:25:0x00c8, B:30:0x0104), top: B:51:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0170 A[RETURN] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.io.Closeable] */
    /* JADX WARN: Unknown variable types count: 2 */
    @Override // k5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rajat.pdfviewer.c.s(java.lang.Object):java.lang.Object");
    }
}
