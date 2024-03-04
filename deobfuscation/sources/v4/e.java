package v4;

import a6.h0;
import a6.x;
import a6.y;
import android.graphics.Bitmap;
import java.util.LinkedList;
import q5.p;
import q5.q;

@k5.e(c = "com.rajat.pdfviewer.PdfRendererCore$prefetchPages$1$1", f = "PdfRendererCore.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class e extends k5.i implements p {

    /* renamed from: j */
    public final /* synthetic */ int f6291j;

    /* renamed from: k */
    public final /* synthetic */ int f6292k;

    /* renamed from: l */
    public final /* synthetic */ d f6293l;
    public final /* synthetic */ int m;

    /* loaded from: classes.dex */
    public static final class a extends r5.i implements q {

        /* renamed from: g */
        public final /* synthetic */ d f6294g;

        /* renamed from: h */
        public final /* synthetic */ int f6295h;

        /* renamed from: i */
        public final /* synthetic */ Bitmap f6296i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i7, Bitmap bitmap) {
            super(3);
            this.f6294g = dVar;
            this.f6295h = i7;
            this.f6296i = bitmap;
        }

        public final Object f(Object obj, Object obj2, Object obj3) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            ((Number) obj2).intValue();
            Bitmap bitmap = (Bitmap) obj3;
            if (booleanValue) {
                d dVar = this.f6294g;
                int i7 = this.f6295h;
                if (bitmap == null) {
                    bitmap = this.f6296i;
                }
                dVar.getClass();
                a0.e.u(y.a(h0.f298b), null, 0, new f(dVar, i7, bitmap, null), 3);
            } else {
                LinkedList<Bitmap> linkedList = x4.a.f6469a;
                x4.a.b(this.f6296i);
            }
            return f5.g.f4141a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i7, int i8, d dVar, int i9, i5.d dVar2) {
        super(2, dVar2);
        this.f6291j = i7;
        this.f6292k = i8;
        this.f6293l = dVar;
        this.m = i9;
    }

    public final Object i(Object obj, Object obj2) {
        return ((e) p((x) obj, (i5.d) obj2)).s(f5.g.f4141a);
    }

    public final i5.d p(Object obj, i5.d dVar) {
        return new e(this.f6291j, this.f6292k, this.f6293l, this.m, dVar);
    }

    public final Object s(Object obj) {
        Kotlin_1.a aVar = Kotlin_1.a.f4591f;
        f5.e.b(obj);
        LinkedList<Bitmap> linkedList = x4.a.f6469a;
        Bitmap a7 = x4.a.a(this.f6291j, this.f6292k);
        d dVar = this.f6293l;
        int i7 = this.m;
        dVar.a(i7, a7, new a(dVar, i7, a7));
        return f5.g.f4141a;
    }
}
