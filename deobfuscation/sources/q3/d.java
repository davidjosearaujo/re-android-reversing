package q3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f5661a;

    /* renamed from: b */
    public final /* synthetic */ ActionMenuView f5662b;

    /* renamed from: c */
    public final /* synthetic */ int f5663c;

    /* renamed from: d */
    public final /* synthetic */ boolean f5664d;
    public final /* synthetic */ BottomAppBar e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i7, boolean z6) {
        this.e = bottomAppBar;
        this.f5662b = actionMenuView;
        this.f5663c = i7;
        this.f5664d = z6;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f5661a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f5661a) {
            return;
        }
        BottomAppBar bottomAppBar = this.e;
        int i7 = bottomAppBar.f2828l0;
        boolean z6 = i7 != 0;
        if (i7 != 0) {
            bottomAppBar.f2828l0 = 0;
            bottomAppBar.getMenu().clear();
            bottomAppBar.k(i7);
        }
        this.e.B(this.f5662b, this.f5663c, this.f5664d, z6);
    }
}
