package v4;

import android.widget.TextView;
import com.rajat.pdfviewer.PdfRendererView;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6300f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PdfRendererView f6301g;

    public /* synthetic */ h(PdfRendererView pdfRendererView, int i7) {
        this.f6300f = i7;
        this.f6301g = pdfRendererView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6300f) {
            case 0:
                PdfRendererView pdfRendererView = this.f6301g;
                int i7 = PdfRendererView.f3452t;
                r5.h.f(pdfRendererView, "this$0");
                if (pdfRendererView.f3464r != -1) {
                    pdfRendererView.getRecyclerView().g0(pdfRendererView.f3464r);
                    pdfRendererView.f3464r = -1;
                    return;
                }
                return;
            default:
                PdfRendererView pdfRendererView2 = this.f6301g;
                r5.h.f(pdfRendererView2, "this$0");
                TextView textView = pdfRendererView2.f3454g;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                } else {
                    r5.h.k("pageNo");
                    throw null;
                }
        }
    }
}
