package com.google.android.material.transformation;

import a0.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.WeakHashMap;
import n3.g;
import p1.k0;
import p1.y;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: n */
    public HashMap f3396n;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final FabTransformationBehavior.b D(Context context, boolean z6) {
        int i7 = z6 ? 2130837537 : 2130837536;
        FabTransformationBehavior.b bVar = new FabTransformationBehavior.b();
        bVar.f3390a = g.a(context, i7);
        bVar.f3391b = new e();
        return bVar;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void w(View view, View view2, boolean z6, boolean z7) {
        int intValue;
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z6) {
                this.f3396n = new HashMap(childCount);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                boolean z8 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f1442a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z8) {
                    HashMap hashMap = this.f3396n;
                    if (z6) {
                        hashMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    } else {
                        intValue = (hashMap != null && hashMap.containsKey(childAt)) ? ((Integer) this.f3396n.get(childAt)).intValue() : 4;
                    }
                    WeakHashMap<View, k0> weakHashMap = y.f5540a;
                    y.d.s(childAt, intValue);
                }
            }
            if (!z6) {
                this.f3396n = null;
            }
        }
        super.w(view, view2, z6, z7);
    }
}
