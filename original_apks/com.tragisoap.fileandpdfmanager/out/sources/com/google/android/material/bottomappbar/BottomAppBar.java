package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d4.s;
import e4.j;
import j1.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q3.c;
import q3.d;
import q3.e;
import q3.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: o0 */
    public static final /* synthetic */ int f2818o0 = 0;

    /* renamed from: c0 */
    public Integer f2819c0;

    /* renamed from: d0 */
    public Animator f2820d0;

    /* renamed from: e0 */
    public Animator f2821e0;

    /* renamed from: f0 */
    public int f2822f0;

    /* renamed from: g0 */
    public int f2823g0;

    /* renamed from: h0 */
    public int f2824h0;

    /* renamed from: i0 */
    public int f2825i0;

    /* renamed from: j0 */
    public int f2826j0;

    /* renamed from: k0 */
    public boolean f2827k0;

    /* renamed from: l0 */
    public int f2828l0;

    /* renamed from: m0 */
    public boolean f2829m0;

    /* renamed from: n0 */
    public Behavior f2830n0;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: p */
        public WeakReference<BottomAppBar> f2832p;

        /* renamed from: q */
        public int f2833q;

        /* renamed from: r */
        public final a f2834r = new a();

        /* renamed from: o */
        public final Rect f2831o = new Rect();

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
                Behavior.this = r1;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                BottomAppBar bottomAppBar = Behavior.this.f2832p.get();
                if (bottomAppBar == null || (!(view instanceof FloatingActionButton) && !(view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (!(view instanceof FloatingActionButton)) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                    if (Behavior.this.f2833q == 0) {
                        if (bottomAppBar.f2824h0 == 1) {
                            ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(2131100240) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                        if (s.a(view)) {
                            ((ViewGroup.MarginLayoutParams) fVar).leftMargin += 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) fVar).rightMargin += 0;
                        }
                    }
                    int i15 = BottomAppBar.f2818o0;
                    bottomAppBar.A();
                    throw null;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Behavior.this.f2831o.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                throw null;
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f2832p = new WeakReference<>(bottomAppBar);
            int i8 = BottomAppBar.f2818o0;
            View w6 = bottomAppBar.w();
            if (w6 != null) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                if (!y.g.c(w6)) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) w6.getLayoutParams();
                    fVar.f1445d = 17;
                    int i9 = bottomAppBar.f2824h0;
                    if (i9 == 1) {
                        fVar.f1445d = 49;
                    }
                    if (i9 == 0) {
                        fVar.f1445d |= 80;
                    }
                    this.f2833q = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) w6.getLayoutParams())).bottomMargin;
                    if (w6 instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) w6;
                        if (floatingActionButton.getShowMotionSpec() == null) {
                            floatingActionButton.setShowMotionSpecResource(2130837535);
                        }
                        if (floatingActionButton.getHideMotionSpec() == null) {
                            floatingActionButton.setHideMotionSpecResource(2130837534);
                        }
                        floatingActionButton.c();
                        floatingActionButton.d(new e(bottomAppBar));
                        floatingActionButton.e();
                    }
                    w6.addOnLayoutChangeListener(this.f2834r);
                    bottomAppBar.A();
                    throw null;
                }
            }
            coordinatorLayout.q(bottomAppBar, i7);
            super.l(coordinatorLayout, bottomAppBar, i7);
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i7, int i8) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            return bottomAppBar.getHideOnScroll() && super.t(coordinatorLayout, bottomAppBar, view2, view3, i7, i8);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a implements Runnable {

        /* renamed from: f */
        public final /* synthetic */ ActionMenuView f2836f;

        /* renamed from: g */
        public final /* synthetic */ int f2837g;

        /* renamed from: h */
        public final /* synthetic */ boolean f2838h;

        public a(ActionMenuView actionMenuView, int i7, boolean z6) {
            BottomAppBar.this = r1;
            this.f2836f = actionMenuView;
            this.f2837g = i7;
            this.f2838h = z6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionMenuView actionMenuView = this.f2836f;
            actionMenuView.setTranslationX((float) BottomAppBar.this.x(actionMenuView, this.f2837g, this.f2838h));
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b extends w1.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: h */
        public int f2840h;

        /* renamed from: i */
        public boolean f2841i;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<b> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new b[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2840h = parcel.readInt();
            this.f2841i = parcel.readInt() != 0;
        }

        public b(Toolbar.i iVar) {
            super(iVar);
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f2840h);
            parcel.writeInt(this.f2841i ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public int getBottomInset() {
        return 0;
    }

    private int getFabAlignmentAnimationDuration() {
        return j.c(getContext(), 2130903868, 300);
    }

    private float getFabTranslationX() {
        return y(this.f2822f0);
    }

    private float getFabTranslationY() {
        if (this.f2824h0 == 1) {
            return -getTopEdgeTreatment().f5668h;
        }
        View w6 = w();
        int i7 = 0;
        if (w6 != null) {
            i7 = (-((getMeasuredHeight() + getBottomInset()) - w6.getMeasuredHeight())) / 2;
        }
        return (float) i7;
    }

    public int getLeftInset() {
        return 0;
    }

    public int getRightInset() {
        return 0;
    }

    private f getTopEdgeTreatment() {
        throw null;
    }

    public final void A() {
        f topEdgeTreatment = getTopEdgeTreatment();
        getFabTranslationX();
        topEdgeTreatment.getClass();
        if (this.f2829m0) {
            z();
        }
        throw null;
    }

    public final void B(ActionMenuView actionMenuView, int i7, boolean z6, boolean z7) {
        a aVar = new a(actionMenuView, i7, z6);
        if (z7) {
            actionMenuView.post(aVar);
        } else {
            aVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f2830n0 == null) {
            this.f2830n0 = new Behavior();
        }
        return this.f2830n0;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().f5668h;
    }

    public int getFabAlignmentMode() {
        return this.f2822f0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f2825i0;
    }

    public int getFabAnchorMode() {
        return this.f2824h0;
    }

    public int getFabAnimationMode() {
        return this.f2823g0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f5667g;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f5666f;
    }

    public boolean getHideOnScroll() {
        return this.f2827k0;
    }

    public int getMenuAlignmentMode() {
        return this.f2826j0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q2.a.L(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        if (z6) {
            Animator animator = this.f2821e0;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f2820d0;
            if (animator2 != null) {
                animator2.cancel();
            }
            A();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f2821e0 == null) {
            actionMenuView.setAlpha(1.0f);
            if (!z()) {
                B(actionMenuView, 0, false, false);
            } else {
                B(actionMenuView, this.f2822f0, this.f2829m0, false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f6374f);
        this.f2822f0 = bVar.f2840h;
        this.f2829m0 = bVar.f2841i;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b((Toolbar.i) super.onSaveInstanceState());
        bVar.f2840h = this.f2822f0;
        bVar.f2841i = this.f2829m0;
        return bVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        a.b.h(null, colorStateList);
    }

    public void setCradleVerticalOffset(float f7) {
        if (f7 != getCradleVerticalOffset()) {
            f topEdgeTreatment = getTopEdgeTreatment();
            if (f7 >= 0.0f) {
                topEdgeTreatment.f5668h = f7;
                throw null;
            } else {
                topEdgeTreatment.getClass();
                throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        throw null;
    }

    public void setFabAlignmentMode(int i7) {
        int i8;
        this.f2828l0 = 0;
        boolean z6 = this.f2829m0;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        if (!y.g.c(this)) {
            int i9 = this.f2828l0;
            if (i9 != 0) {
                this.f2828l0 = 0;
                getMenu().clear();
                k(i9);
            }
        } else {
            Animator animator = this.f2821e0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!z()) {
                z6 = false;
                i8 = 0;
            } else {
                i8 = i7;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                float fabAlignmentAnimationDuration = (float) getFabAlignmentAnimationDuration();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                ofFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
                if (Math.abs(actionMenuView.getTranslationX() - ((float) x(actionMenuView, i8, z6))) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                    ofFloat2.addListener(new d(this, actionMenuView, i8, z6));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.f2821e0 = animatorSet2;
            animatorSet2.addListener(new c(this));
            this.f2821e0.start();
        }
        if (this.f2822f0 != i7 && y.g.c(this)) {
            Animator animator2 = this.f2820d0;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            FloatingActionButton floatingActionButton = null;
            if (this.f2823g0 == 1) {
                View w6 = w();
                if (w6 instanceof FloatingActionButton) {
                    floatingActionButton = (FloatingActionButton) w6;
                }
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, "translationX", y(i7));
                ofFloat3.setDuration((long) getFabAlignmentAnimationDuration());
                arrayList2.add(ofFloat3);
            } else {
                View w7 = w();
                if (w7 instanceof FloatingActionButton) {
                    floatingActionButton = (FloatingActionButton) w7;
                }
                if (floatingActionButton != null && !floatingActionButton.h()) {
                    floatingActionButton.g(new q3.b(this, i7), true);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            animatorSet3.setInterpolator(j.d(getContext(), 2130903884, n3.a.f5161a));
            this.f2820d0 = animatorSet3;
            animatorSet3.addListener(new q3.a(this));
            this.f2820d0.start();
        }
        this.f2822f0 = i7;
    }

    public void setFabAlignmentModeEndMargin(int i7) {
        if (this.f2825i0 != i7) {
            this.f2825i0 = i7;
            A();
            throw null;
        }
    }

    public void setFabAnchorMode(int i7) {
        this.f2824h0 = i7;
        A();
        throw null;
    }

    public void setFabAnimationMode(int i7) {
        this.f2823g0 = i7;
    }

    public void setFabCornerSize(float f7) {
        if (f7 != getTopEdgeTreatment().f5669i) {
            getTopEdgeTreatment().f5669i = f7;
            throw null;
        }
    }

    public void setFabCradleMargin(float f7) {
        if (f7 != getFabCradleMargin()) {
            getTopEdgeTreatment().f5667g = f7;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f7) {
        if (f7 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f5666f = f7;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z6) {
        this.f2827k0 = z6;
    }

    public void setMenuAlignmentMode(int i7) {
        if (this.f2826j0 != i7) {
            this.f2826j0 = i7;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                B(actionMenuView, this.f2822f0, z(), false);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.f2819c0 == null)) {
            drawable = drawable.mutate();
            a.b.g(drawable, this.f2819c0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i7) {
        this.f2819c0 = Integer.valueOf(i7);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View w() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r3.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            w0.c r2 = r0.f1424g
            java.lang.Object r2 = r2.f6338b
            o.h r2 = (o.h) r2
            java.lang.Object r3 = r2.getOrDefault(r3, r1)
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList r2 = r0.f1426i
            r2.clear()
            if (r3 == 0) goto L_0x0028
            java.util.ArrayList r2 = r0.f1426i
            r2.addAll(r3)
        L_0x0028:
            java.util.ArrayList r3 = r0.f1426i
            java.util.Iterator r3 = r3.iterator()
        L_0x002e:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r3.next()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r0 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r2 != 0) goto L_0x0042
            boolean r2 = r0 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r2 == 0) goto L_0x002e
        L_0x0042:
            return r0
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.w():android.view.View");
    }

    public final int x(ActionMenuView actionMenuView, int i7, boolean z6) {
        int i8;
        if (!(this.f2826j0 == 1 || (i7 == 1 && z6))) {
            return 0;
        }
        boolean a7 = s.a(this);
        int measuredWidth = a7 ? getMeasuredWidth() : 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).f3924a & 8388615) == 8388611) {
                measuredWidth = a7 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = a7 ? actionMenuView.getRight() : actionMenuView.getLeft();
        if (getNavigationIcon() == null) {
            i8 = getResources().getDimensionPixelOffset(2131099852);
            if (!a7) {
                i8 = -i8;
            }
        } else {
            i8 = 0;
        }
        return measuredWidth - ((right + 0) + i8);
    }

    public final float y(int i7) {
        boolean a7 = s.a(this);
        int i8 = 1;
        if (i7 != 1) {
            return 0.0f;
        }
        View w6 = w();
        int i9 = 0;
        if (!(this.f2825i0 == -1 || w6 == null)) {
            i9 = 0 + (w6.getMeasuredWidth() / 2) + this.f2825i0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - i9;
        if (a7) {
            i8 = -1;
        }
        return (float) (measuredWidth * i8);
    }

    public final boolean z() {
        View w6 = w();
        FloatingActionButton floatingActionButton = w6 instanceof FloatingActionButton ? (FloatingActionButton) w6 : null;
        return floatingActionButton != null && floatingActionButton.i();
    }
}
