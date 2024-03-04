package c0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.rajat.pdfviewer.PdfViewerActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements i, s1.b, androidx.activity.result.b {

    /* renamed from: a */
    public final /* synthetic */ Object f2486a;

    public /* synthetic */ l(Object obj) {
        this.f2486a = obj;
    }

    @Override // androidx.activity.result.b
    public final void a(Object obj) {
        PdfViewerActivity pdfViewerActivity = (PdfViewerActivity) this.f2486a;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        boolean z6 = PdfViewerActivity.U;
        r5.h.f(pdfViewerActivity, "this$0");
        if (booleanValue) {
            pdfViewerActivity.z();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(pdfViewerActivity);
        String str = pdfViewerActivity.I;
        if (str == null) {
            r5.h.k("permission_required_title");
            throw null;
        }
        AlertDialog.Builder title = builder.setTitle(str);
        String str2 = pdfViewerActivity.H;
        if (str2 == null) {
            r5.h.k("permission_required");
            throw null;
        }
        AlertDialog.Builder message = title.setMessage(str2);
        String str3 = pdfViewerActivity.L;
        if (str3 == null) {
            r5.h.k("pdf_viewer_grant");
            throw null;
        }
        AlertDialog.Builder positiveButton = message.setPositiveButton(str3, new v4.l(pdfViewerActivity, 1));
        String str4 = pdfViewerActivity.M;
        if (str4 != null) {
            positiveButton.setNegativeButton(str4, (DialogInterface.OnClickListener) null).show();
        } else {
            r5.h.k("pdf_viewer_cancel");
            throw null;
        }
    }

    @Override // c0.i
    public final double b(double d7) {
        r rVar = (r) this.f2486a;
        r5.h.f(rVar, "this$0");
        return w5.d.V(rVar.f2501k.b(d7), rVar.e, rVar.f2496f);
    }
}
