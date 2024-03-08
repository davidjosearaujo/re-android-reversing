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
import l0.o;
import r5.h;
import u0.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class l extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<a, o> f1189f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<o, a> f1190g = new HashMap<>();

    public l(Context context) {
        super(context);
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final HashMap<a, o> getHolderToLayoutNode() {
        return this.f1189f;
    }

    public final HashMap<o, a> getLayoutNodeToHolder() {
        return this.f1190g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final /* bridge */ /* synthetic */ ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public final void onDescendantInvalidated(View view, View view2) {
        h.f(view, "child");
        h.f(view2, "target");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        Set<a> keySet = this.f1189f.keySet();
        h.e(keySet, "holderToLayoutNode.keys");
        for (a aVar : keySet) {
            aVar.layout(aVar.getLeft(), aVar.getTop(), aVar.getRight(), aVar.getBottom());
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        boolean z6 = true;
        if (View.MeasureSpec.getMode(i7) == 1073741824) {
            if (View.MeasureSpec.getMode(i8) != 1073741824) {
                z6 = false;
            }
            if (z6) {
                setMeasuredDimension(View.MeasureSpec.getSize(i7), View.MeasureSpec.getSize(i8));
                Set<a> keySet = this.f1189f.keySet();
                h.e(keySet, "holderToLayoutNode.keys");
                for (a aVar : keySet) {
                    aVar.measure(0, 0);
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // android.view.ViewParent, android.view.View
    @SuppressLint({"MissingSuperCall"})
    public final void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            o oVar = this.f1189f.get(childAt);
            if (childAt.isLayoutRequested() && oVar != null) {
                o.l(oVar, false, 3);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
