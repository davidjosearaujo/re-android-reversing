package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* renamed from: g */
    public AnimatorSet f3381g;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void w(View view, View view2, boolean z6, boolean z7) {
        AnimatorSet animatorSet = this.f3381g;
        boolean z8 = animatorSet != null;
        if (z8) {
            animatorSet.cancel();
        }
        AnimatorSet x3 = x(view, view2, z6, z8);
        this.f3381g = x3;
        x3.addListener(new r4.a(this));
        this.f3381g.start();
        if (z7) {
            return;
        }
        this.f3381g.end();
    }

    public abstract AnimatorSet x(View view, View view2, boolean z6, boolean z7);
}
