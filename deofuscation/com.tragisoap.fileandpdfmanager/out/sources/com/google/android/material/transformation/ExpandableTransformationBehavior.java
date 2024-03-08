package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import r4.a;
@Deprecated
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
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
        AnimatorSet x6 = x(view, view2, z6, z8);
        this.f3381g = x6;
        x6.addListener(new a(this));
        this.f3381g.start();
        if (!z7) {
            this.f3381g.end();
        }
    }

    public abstract AnimatorSet x(View view, View view2, boolean z6, boolean z7);
}
