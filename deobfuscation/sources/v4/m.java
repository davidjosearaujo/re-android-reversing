package v4;

import com.rajat.pdfviewer.PdfViewerActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f6320f;

    /* renamed from: g */
    public final /* synthetic */ PdfViewerActivity f6321g;

    public /* synthetic */ m(PdfViewerActivity pdfViewerActivity, int i7) {
        this.f6320f = i7;
        this.f6321g = pdfViewerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6320f) {
            case 0:
                PdfViewerActivity.v(this.f6321g);
                return;
            default:
                PdfViewerActivity pdfViewerActivity = this.f6321g;
                r5.h.f(pdfViewerActivity, "this$0");
                PdfViewerActivity.w(pdfViewerActivity, true);
                return;
        }
    }
}
