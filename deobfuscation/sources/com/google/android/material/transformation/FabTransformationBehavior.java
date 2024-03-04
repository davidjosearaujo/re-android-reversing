package com.google.android.material.transformation;

import a0.e;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.s0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import n3.g;
import n3.h;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: h */
    public final Rect f3382h;

    /* renamed from: i */
    public final RectF f3383i;

    /* renamed from: j */
    public final RectF f3384j;

    /* renamed from: k */
    public final int[] f3385k;

    /* renamed from: l */
    public float f3386l;
    public float m;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ boolean f3387a;

        /* renamed from: b */
        public final /* synthetic */ View f3388b;

        /* renamed from: c */
        public final /* synthetic */ View f3389c;

        public a(boolean z6, View view, View view2) {
            this.f3387a = z6;
            this.f3388b = view;
            this.f3389c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f3387a) {
                return;
            }
            this.f3388b.setVisibility(4);
            this.f3389c.setAlpha(1.0f);
            this.f3389c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            if (this.f3387a) {
                this.f3388b.setVisibility(0);
                this.f3389c.setAlpha(0.0f);
                this.f3389c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public g f3390a;

        /* renamed from: b */
        public e f3391b;
    }

    public FabTransformationBehavior() {
        this.f3382h = new Rect();
        this.f3383i = new RectF();
        this.f3384j = new RectF();
        this.f3385k = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3382h = new Rect();
        this.f3383i = new RectF();
        this.f3384j = new RectF();
        this.f3385k = new int[2];
    }

    public static float B(b bVar, h hVar, float f7) {
        long j5 = hVar.f5174a;
        long j7 = hVar.f5175b;
        h c7 = bVar.f3390a.c("expansion");
        float interpolation = hVar.b().getInterpolation(((float) (((c7.f5174a + c7.f5175b) + 17) - j5)) / ((float) j7));
        LinearInterpolator linearInterpolator = n3.a.f5161a;
        return s0.f(0.0f, f7, interpolation, f7);
    }

    public static Pair y(float f7, float f8, boolean z6, b bVar) {
        h c7;
        g gVar;
        String str;
        int i7;
        if (f7 == 0.0f || f8 == 0.0f) {
            c7 = bVar.f3390a.c("translationXLinear");
            gVar = bVar.f3390a;
            str = "translationYLinear";
        } else if ((!z6 || f8 >= 0.0f) && (z6 || i7 <= 0)) {
            c7 = bVar.f3390a.c("translationXCurveDownwards");
            gVar = bVar.f3390a;
            str = "translationYCurveDownwards";
        } else {
            c7 = bVar.f3390a.c("translationXCurveUpwards");
            gVar = bVar.f3390a;
            str = "translationYCurveUpwards";
        }
        return new Pair(c7, gVar.c(str));
    }

    public final float A(View view, View view2, e eVar) {
        RectF rectF = this.f3383i;
        RectF rectF2 = this.f3384j;
        C(view, rectF);
        rectF.offset(this.f3386l, this.m);
        C(view2, rectF2);
        eVar.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void C(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f3385k;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract b D(Context context, boolean z6);

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean f(View view, View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void g(CoordinatorLayout.f fVar) {
        if (fVar.f1448h == 0) {
            fVar.f1448h = 80;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:435:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x03f4 A[LOOP:0: B:517:0x03f2->B:518:0x03f4, LOOP_END] */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.AnimatorSet x(android.view.View r27, android.view.View r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 1039
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.x(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public final float z(View view, View view2, e eVar) {
        RectF rectF = this.f3383i;
        RectF rectF2 = this.f3384j;
        C(view, rectF);
        rectF.offset(this.f3386l, this.m);
        C(view2, rectF2);
        eVar.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }
}
