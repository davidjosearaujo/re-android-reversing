package q3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5661a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f5662b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5663c;

    /* renamed from: d  reason: collision with root package name */
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
        if (!this.f5661a) {
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
}
