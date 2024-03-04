package p1;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a */
    public final b f5536a;

    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: a */
        public final View f5537a;

        public a(View view) {
            this.f5537a = view;
        }

        public void a() {
            final View view = this.f5537a;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
            } else {
                view = view.getRootView().findFocus();
            }
            if (view == null) {
                view = this.f5537a.getRootView().findViewById(16908290);
            }
            if (view == null || !view.hasWindowFocus()) {
                return;
            }
            view.post(new Runnable() { // from class: p1.t
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = view;
                    ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {

        /* renamed from: b */
        public View f5538b;

        /* renamed from: c */
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

    /* loaded from: classes.dex */
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
