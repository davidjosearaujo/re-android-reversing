package v4;

import a6.h0;
import a6.x;
import a6.y;
import android.graphics.Bitmap;
import f5.g;
import i5.d;
import java.util.LinkedList;
import k5.i;
import q5.p;
import q5.q;
@k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$prefetchPages$1$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e extends i implements p<x, d<? super g>, Object> {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6291j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6292k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ d f6293l;
    public final /* synthetic */ int m;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static final class a extends r5.i implements q<Boolean, Integer, Bitmap, g> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f6294g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6295h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Bitmap f6296i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i7, Bitmap bitmap) {
            super(3);
            this.f6294g = dVar;
            this.f6295h = i7;
            this.f6296i = bitmap;
        }

        @Override // q5.q
        public final g f(Boolean bool, Integer num, Bitmap bitmap) {
            boolean booleanValue = bool.booleanValue();
            num.intValue();
            Bitmap bitmap2 = bitmap;
            if (booleanValue) {
                d dVar = this.f6294g;
                int i7 = this.f6295h;
                if (bitmap2 == null) {
                    bitmap2 = this.f6296i;
                }
                dVar.getClass();
                a0.e.u(y.a(h0.f298b), null, 0, new f(dVar, i7, bitmap2, null), 3);
            } else {
                LinkedList<Bitmap> linkedList = x4.a.f6469a;
                x4.a.b(this.f6296i);
            }
            return g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i7, int i8, d dVar, int i9, d<? super e> dVar2) {
        super(2, dVar2);
        this.f6291j = i7;
        this.f6292k = i8;
        this.f6293l = dVar;
        this.m = i9;
    }

    @Override // q5.p
    public final Object i(x xVar, d<? super g> dVar) {
        return ((e) p(xVar, dVar)).s(g.f4141a);
    }

    @Override // k5.a
    public final d<g> p(Object obj, d<?> dVar) {
        return new e(this.f6291j, this.f6292k, this.f6293l, this.m, dVar);
    }

    @Override // k5.a
    public final Object s(Object obj) {
        j5.a aVar = j5.a.f4591f;
        f5.e.b(obj);
        LinkedList<Bitmap> linkedList = x4.a.f6469a;
        Bitmap a7 = x4.a.a(this.f6291j, this.f6292k);
        d dVar = this.f6293l;
        int i7 = this.m;
        dVar.a(i7, a7, new a(dVar, i7, a7));
        return g.f4141a;
    }
}
