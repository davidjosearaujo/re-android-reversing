package com.rajat.pdfviewer;

import a6.x;
import f5.g;
import i5.d;
import k5.e;
import k5.i;
import linc.com.amplituda.ErrorCode;
import q5.p;
@e(c = "com.rajat.pdfviewer.PdfDownloader$1", f = "PdfDownloader.kt", l = {ErrorCode.CODEC_NOT_FOUND_PROC_CODE}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public int f3468j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ b f3469k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, d<? super a> dVar) {
        super(2, dVar);
        this.f3469k = bVar;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((a) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new a(this.f3469k, dVar);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        j5.a aVar = j5.a.f4591f;
        int i7 = this.f3468j;
        if (i7 == 0) {
            f5.e.b(obj);
            b bVar = this.f3469k;
            String str = bVar.f3472c;
            this.f3468j = 1;
            if (b.a(bVar, str, this) == aVar) {
                return aVar;
            }
        } else if (i7 == 1) {
            f5.e.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return g.f4141a;
    }
}
