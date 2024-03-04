package p1;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class s implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: f */
    public final View f5532f;

    /* renamed from: g */
    public ViewTreeObserver f5533g;

    /* renamed from: h */
    public final Runnable f5534h;

    public s(View view, Runnable runnable) {
        this.f5532f = view;
        this.f5533g = view.getViewTreeObserver();
        this.f5534h = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        s sVar = new s(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(sVar);
        view.addOnAttachStateChangeListener(sVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        (this.f5533g.isAlive() ? this.f5533g : this.f5532f.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f5532f.removeOnAttachStateChangeListener(this);
        this.f5534h.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f5533g = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        (this.f5533g.isAlive() ? this.f5533g : this.f5532f.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f5532f.removeOnAttachStateChangeListener(this);
    }
}