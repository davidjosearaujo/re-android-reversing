package p1;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final b f5536a;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final View f5537a;

        public a(View view) {
            this.f5537a = view;
        }

        public void a() {
            View view = this.f5537a;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.f5537a.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new t(view));
                }
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends a {

        /* renamed from: b  reason: collision with root package name */
        public View f5538b;

        /* renamed from: c  reason: collision with root package name */
        public WindowInsetsController f5539c;

        public b(View view) {
            super(view);
            this.f5538b = view;
        }

        public b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f5539c = windowInsetsController;
        }

        @Override // p1.u.a
        public final void a() {
            View view = this.f5538b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = null;
            WindowInsetsController windowInsetsController2 = this.f5539c;
            if (windowInsetsController2 != null) {
                windowInsetsController = windowInsetsController2;
            } else {
                View view2 = this.f5538b;
                if (view2 != null) {
                    windowInsetsController = view2.getWindowInsetsController();
                }
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.a();
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c {
    }

    public u(View view) {
        this.f5536a = new b(view);
    }

    @Deprecated
    public u(WindowInsetsController windowInsetsController) {
        this.f5536a = new b(windowInsetsController);
    }
}
