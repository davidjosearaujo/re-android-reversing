package p1;

import android.view.Window;
import android.view.WindowInsetsController;
import o.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final a f5528a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final WindowInsetsController f5529a;

        /* renamed from: b  reason: collision with root package name */
        public final u f5530b;

        /* renamed from: c  reason: collision with root package name */
        public Window f5531c;

        public a(WindowInsetsController windowInsetsController, u uVar) {
            new h();
            this.f5529a = windowInsetsController;
            this.f5530b = uVar;
        }

        public final boolean a() {
            return (this.f5529a.getSystemBarsAppearance() & 8) != 0;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
    }

    @Deprecated
    public q0(WindowInsetsController windowInsetsController) {
        this.f5528a = new a(windowInsetsController, new u(windowInsetsController));
    }
}
