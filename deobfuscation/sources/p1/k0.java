package p1;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a */
    public final WeakReference<View> f5495a;

    /* loaded from: classes.dex */
    public static class a {
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    public k0(View view) {
        this.f5495a = new WeakReference<>(view);
    }

    public final void a(float f7) {
        View view = this.f5495a.get();
        if (view != null) {
            view.animate().alpha(f7);
        }
    }

    public final void b() {
        View view = this.f5495a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j5) {
        View view = this.f5495a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
    }

    public final void d(l0 l0Var) {
        View view = this.f5495a.get();
        if (view != null) {
            if (l0Var != null) {
                view.animate().setListener(new j0(l0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f7) {
        View view = this.f5495a.get();
        if (view != null) {
            view.animate().translationY(f7);
        }
    }
}
