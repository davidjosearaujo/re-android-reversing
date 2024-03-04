package f2;

import android.content.Context;
import android.os.Looper;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.masoudss.lib.WaveformSeekBar;
import com.rajat.pdfviewer.PdfViewerActivity;
import e5.p;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import r5.h;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: f */
    public final /* synthetic */ int f4103f;

    /* renamed from: g */
    public final /* synthetic */ Object f4104g;

    /* renamed from: h */
    public final /* synthetic */ Object f4105h;

    public /* synthetic */ c(Object obj, int i7, Object obj2) {
        this.f4103f = i7;
        this.f4104g = obj;
        this.f4105h = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4103f) {
            case 0:
                ((ProfileInstallerInitializer) this.f4104g).getClass();
                ProfileInstallerInitializer.b.a(Looper.getMainLooper()).postDelayed(new androidx.activity.d(8, (Context) this.f4105h), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
            case 1:
                PdfViewerActivity pdfViewerActivity = (PdfViewerActivity) this.f4104g;
                Throwable th = (Throwable) this.f4105h;
                h.f(pdfViewerActivity, "this$0");
                h.f(th, "$error");
                PdfViewerActivity.w(pdfViewerActivity, false);
                pdfViewerActivity.y(th.toString());
                return;
            case 2:
                List<HashMap<String, String>> list = e5.g.f3796i;
                ((e5.g) this.f4104g).i((WaveformSeekBar) this.f4105h);
                return;
            default:
                p.a aVar = (p.a) this.f4104g;
                com.bumptech.glide.b.d(p.this.f3846d).n((String) ((HashMap) this.f4105h).get("col1Path")).u(aVar.A);
                return;
        }
    }
}
