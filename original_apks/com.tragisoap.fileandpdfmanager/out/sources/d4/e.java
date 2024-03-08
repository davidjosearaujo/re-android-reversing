package d4;

import android.view.View;
import android.view.Window;
import p1.q0;
import p1.u;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class e {
    public static void a(Window window, boolean z6) {
        q0.a aVar = new q0.a(window.getInsetsController(), new u(window.getDecorView()));
        aVar.f5531c = window;
        if (z6) {
            Window window2 = aVar.f5531c;
            if (window2 != null) {
                View decorView = window2.getDecorView();
                decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
            }
            aVar.f5529a.setSystemBarsAppearance(8, 8);
            return;
        }
        Window window3 = aVar.f5531c;
        if (window3 != null) {
            View decorView2 = window3.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & -8193);
        }
        aVar.f5529a.setSystemBarsAppearance(0, 8);
    }
}
