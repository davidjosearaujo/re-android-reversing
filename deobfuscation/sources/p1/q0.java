package p1;

import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a */
    public final a f5528a;

    /* loaded from: classes.dex */
    public static class a extends b {

        /* renamed from: a */
        public final WindowInsetsController f5529a;

        /* renamed from: b */
        public final u f5530b;

        /* renamed from: c */
        public Window f5531c;

        public a(WindowInsetsController windowInsetsController, u uVar) {
            new o.h();
            this.f5529a = windowInsetsController;
            this.f5530b = uVar;
        }

        public final boolean a() {
            return (this.f5529a.getSystemBarsAppearance() & 8) != 0;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
    }

    @Deprecated
    public q0(WindowInsetsController windowInsetsController) {
        this.f5528a = new a(windowInsetsController, new u(windowInsetsController));
    }
}
