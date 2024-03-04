package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class l extends ViewGroup {

    /* renamed from: f */
    public final HashMap<u0.a, l0.o> f1189f;

    /* renamed from: g */
    public final HashMap<l0.o, u0.a> f1190g;

    public l(Context context) {
        super(context);
        setClipChildren(false);
        this.f1189f = new HashMap<>();
        this.f1190g = new HashMap<>();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final HashMap<u0.a, l0.o> getHolderToLayoutNode() {
        return this.f1189f;
    }

    public final HashMap<l0.o, u0.a> getLayoutNodeToHolder() {
        return this.f1190g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final /* bridge */ /* synthetic */ ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public final void onDescendantInvalidated(View view, View view2) {
        r5.h.f(view, "child");
        r5.h.f(view2, "target");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        Set<u0.a> keySet = this.f1189f.keySet();
        r5.h.e(keySet, "holderToLayoutNode.keys");
        for (u0.a aVar : keySet) {
            aVar.layout(aVar.getLeft(), aVar.getTop(), aVar.getRight(), aVar.getBottom());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        if (!(View.MeasureSpec.getMode(i7) == 1073741824)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(View.MeasureSpec.getMode(i8) == 1073741824)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i7), View.MeasureSpec.getSize(i8));
        Set<u0.a> keySet = this.f1189f.keySet();
        r5.h.e(keySet, "holderToLayoutNode.keys");
        for (u0.a aVar : keySet) {
            aVar.measure(0, 0);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public final void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            l0.o oVar = this.f1189f.get(childAt);
            if (childAt.isLayoutRequested() && oVar != null) {
                l0.o.l(oVar, false, 3);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
