package m0;

import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {
    public static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j7) {
        return contentCaptureSession.newAutofillId(autofillId, j7);
    }

    public static ViewStructure b(ContentCaptureSession contentCaptureSession, View view) {
        return contentCaptureSession.newViewStructure(view);
    }

    public static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j7) {
        return contentCaptureSession.newVirtualViewStructure(autofillId, j7);
    }

    public static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
        contentCaptureSession.notifyViewAppeared(viewStructure);
    }

    public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
        contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
    }

    public static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
        contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
    }
}
