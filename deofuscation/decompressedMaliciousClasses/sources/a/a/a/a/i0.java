package a.a.a.a;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: /home/remnux/decompressedMalicious.dex */
class i0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f30a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f31b;
    private final Runnable c;

    private i0(View view, Runnable runnable) {
        this.f30a = view;
        this.f31b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static i0 a(View view, Runnable runnable) {
        i0 i0Var = new i0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(i0Var);
        view.addOnAttachStateChangeListener(i0Var);
        return i0Var;
    }

    public void b() {
        (this.f31b.isAlive() ? this.f31b : this.f30a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f30a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f31b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
