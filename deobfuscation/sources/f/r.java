package f;

import android.graphics.Typeface;
import com.rajat.pdfviewer.PdfViewerActivity;
import e5.p;
import f.s;
import h1.f;
import java.util.HashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f4012f;

    /* renamed from: g */
    public final /* synthetic */ Object f4013g;

    /* renamed from: h */
    public final /* synthetic */ Object f4014h;

    public /* synthetic */ r(Object obj, int i7, Object obj2) {
        this.f4012f = i7;
        this.f4013g = obj;
        this.f4014h = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4012f) {
            case 0:
                s.a aVar = (s.a) this.f4013g;
                Runnable runnable = (Runnable) this.f4014h;
                aVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    aVar.a();
                }
            case 1:
                ((f.e) this.f4013g).d((Typeface) this.f4014h);
                return;
            case 2:
                PdfViewerActivity pdfViewerActivity = (PdfViewerActivity) this.f4013g;
                String str = (String) this.f4014h;
                r5.h.f(pdfViewerActivity, "this$0");
                r5.h.f(str, "$absolutePath");
                PdfViewerActivity.w(pdfViewerActivity, false);
                pdfViewerActivity.R = str;
                return;
            default:
                p.a aVar2 = (p.a) this.f4013g;
                com.bumptech.glide.b.d(e5.p.this.f3846d).n((String) ((HashMap) this.f4014h).get("col2Path")).u(aVar2.B);
                return;
        }
    }
}
