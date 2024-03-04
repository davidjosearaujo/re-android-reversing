package com.rajat.pdfviewer;

import a6.x;
import f5.g;
import k5.i;
import linc.com.amplituda.ErrorCode;
import q5.p;

@k5.e(c = "com.rajat.pdfviewer.PdfDownloader$1", f = "PdfDownloader.kt", l = {ErrorCode.CODEC_NOT_FOUND_PROC_CODE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class a extends i implements p {

    /* renamed from: j */
    public int f3468j;

    /* renamed from: k */
    public final /* synthetic */ b f3469k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, i5.d dVar) {
        super(2, dVar);
        this.f3469k = bVar;
    }

    public final Object i(Object obj, Object obj2) {
        return ((a) p((x) obj, (i5.d) obj2)).s(g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new a(this.f3469k, dVar);
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        int i7 = this.f3468j;
        if (i7 == 0) {
            f5.e.b(obj);
            b bVar = this.f3469k;
            String str = bVar.f3472c;
            this.f3468j = 1;
            if (b.a(bVar, str, this) == aVar) {
                return aVar;
            }
        } else if (i7 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            f5.e.b(obj);
        }
        return g.f4141a;
    }
}
