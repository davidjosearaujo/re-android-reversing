package v4;

import android.content.DialogInterface;
import com.rajat.pdfviewer.PdfViewerActivity;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class l implements DialogInterface.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f6318f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PdfViewerActivity f6319g;

    public /* synthetic */ l(PdfViewerActivity pdfViewerActivity, int i7) {
        this.f6318f = i7;
        this.f6319g = pdfViewerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i7) {
        switch (this.f6318f) {
            case 0:
                PdfViewerActivity pdfViewerActivity = this.f6319g;
                boolean z6 = PdfViewerActivity.U;
                h.f(pdfViewerActivity, "this$0");
                pdfViewerActivity.runOnUiThread(new m(pdfViewerActivity, 0));
                return;
            default:
                PdfViewerActivity pdfViewerActivity2 = this.f6319g;
                boolean z7 = PdfViewerActivity.U;
                h.f(pdfViewerActivity2, "this$0");
                h.f(dialogInterface, "dialog");
                pdfViewerActivity2.S.p("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
        }
    }
}
