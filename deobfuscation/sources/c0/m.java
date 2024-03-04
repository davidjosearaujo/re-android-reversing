package c0;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.rajat.pdfviewer.PdfViewerActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements i, q1.d, androidx.activity.result.b {

    /* renamed from: a */
    public final /* synthetic */ Object f2487a;

    public /* synthetic */ m(Object obj) {
        this.f2487a = obj;
    }

    @Override // androidx.activity.result.b
    public final void a(Object obj) {
        Intent intent;
        Uri data;
        PdfViewerActivity pdfViewerActivity = (PdfViewerActivity) this.f2487a;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        boolean z6 = PdfViewerActivity.U;
        r5.h.f(pdfViewerActivity, "this$0");
        if (aVar.f439f != -1 || (intent = aVar.f440g) == null || (data = intent.getData()) == null) {
            return;
        }
        OutputStream openOutputStream = pdfViewerActivity.getContentResolver().openOutputStream(data);
        if (openOutputStream != null) {
            try {
                String str = pdfViewerActivity.R;
                if (str != null) {
                    FileInputStream fileInputStream = new FileInputStream(new File(str));
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        openOutputStream.write(bArr, 0, read);
                    }
                }
                q2.a.l(openOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    q2.a.l(openOutputStream, th);
                    throw th2;
                }
            }
        }
        String str2 = pdfViewerActivity.F;
        if (str2 != null) {
            Toast.makeText(pdfViewerActivity, str2, 0).show();
        } else {
            r5.h.k("file_saved_successfully");
            throw null;
        }
    }

    @Override // c0.i
    public final double b(double d7) {
        r rVar = (r) this.f2487a;
        r5.h.f(rVar, "this$0");
        return rVar.m.b(w5.d.V(d7, rVar.e, rVar.f2496f));
    }
}
