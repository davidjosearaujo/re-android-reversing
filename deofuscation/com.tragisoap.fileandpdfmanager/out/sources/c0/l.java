package c0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.rajat.pdfviewer.PdfViewerActivity;
import r5.h;
import s1.b;
import w5.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final /* synthetic */ class l implements i, b, androidx.activity.result.b {

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
        h.f(pdfViewerActivity, "this$0");
        if (booleanValue) {
            pdfViewerActivity.z();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(pdfViewerActivity);
        String str = pdfViewerActivity.I;
        if (str != null) {
            AlertDialog.Builder title = builder.setTitle(str);
            String str2 = pdfViewerActivity.H;
            if (str2 != null) {
                AlertDialog.Builder message = title.setMessage(str2);
                String str3 = pdfViewerActivity.L;
                if (str3 != null) {
                    AlertDialog.Builder positiveButton = message.setPositiveButton(str3, new v4.l(pdfViewerActivity, 1));
                    String str4 = pdfViewerActivity.M;
                    if (str4 != null) {
                        positiveButton.setNegativeButton(str4, (DialogInterface.OnClickListener) null).show();
                    } else {
                        h.k("pdf_viewer_cancel");
                        throw null;
                    }
                } else {
                    h.k("pdf_viewer_grant");
                    throw null;
                }
            } else {
                h.k("permission_required");
                throw null;
            }
        } else {
            h.k("permission_required_title");
            throw null;
        }
    }

    @Override // c0.i
    public final double b(double d7) {
        r rVar = (r) this.f2486a;
        h.f(rVar, "this$0");
        return d.V(rVar.f2501k.b(d7), (double) rVar.e, (double) rVar.f2496f);
    }
}
