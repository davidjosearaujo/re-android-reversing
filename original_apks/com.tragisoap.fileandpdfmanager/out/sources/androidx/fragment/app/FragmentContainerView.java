package androidx.fragment.app;

import a0.e;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p1.k0;
import p1.p0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<View> f1567f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<View> f1568g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1569h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1570i = true;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f50p);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
            }
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.f1568g;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.f1567f == null) {
                this.f1567f = new ArrayList<>();
            }
            this.f1567f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(2131296489);
        if ((tag instanceof n ? (n) tag : null) != null) {
            super.addView(view, i7, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i7, ViewGroup.LayoutParams layoutParams, boolean z6) {
        Object tag = view.getTag(2131296489);
        if ((tag instanceof n ? (n) tag : null) != null) {
            return super.addViewInLayout(view, i7, layoutParams, z6);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.View, android.view.ViewGroup
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        p0 h7 = p0.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1569h;
        if (onApplyWindowInsetsListener != null) {
            h7 = p0.h(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            WindowInsets g2 = h7.g();
            if (g2 != null) {
                WindowInsets b2 = y.h.b(this, g2);
                if (!b2.equals(g2)) {
                    h7 = p0.h(this, b2);
                }
            }
        }
        if (!h7.f5510a.m()) {
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                WindowInsets g7 = h7.g();
                if (g7 != null) {
                    WindowInsets a7 = y.h.a(childAt, g7);
                    if (!a7.equals(g7)) {
                        p0.h(childAt, a7);
                    }
                }
            }
        }
        return windowInsets;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void dispatchDraw(Canvas canvas) {
        if (this.f1570i && this.f1567f != null) {
            for (int i7 = 0; i7 < this.f1567f.size(); i7++) {
                super.drawChild(canvas, this.f1567f.get(i7), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j7) {
        ArrayList<View> arrayList;
        if (!this.f1570i || (arrayList = this.f1567f) == null || arrayList.size() <= 0 || !this.f1567f.contains(view)) {
            return super.drawChild(canvas, view, j7);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f1568g;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f1567f;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1570i = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z6) {
        if (z6) {
            a(view);
        }
        super.removeDetachedView(view, z6);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i7) {
        a(getChildAt(i7));
        super.removeViewAt(i7);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            a(getChildAt(i9));
        }
        super.removeViews(i7, i8);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i7, int i8) {
        for (int i9 = i7; i9 < i7 + i8; i9++) {
            a(getChildAt(i9));
        }
        super.removeViewsInLayout(i7, i8);
    }

    public void setDrawDisappearingViewsLast(boolean z6) {
        this.f1570i = z6;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1569h = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1568g == null) {
                this.f1568g = new ArrayList<>();
            }
            this.f1568g.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, x xVar) {
        super(context, attributeSet);
        View view;
        Activity activity;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f50p);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        n E = xVar.E(id);
        if (classAttribute != null && E == null) {
            if (id <= 0) {
                String h7 = string != null ? s0.h(" with tag ", string) : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + h7);
            }
            t H = xVar.H();
            context.getClassLoader();
            n a7 = H.a(classAttribute);
            a7.H = true;
            u<?> uVar = a7.f1716x;
            if (uVar == null) {
                activity = null;
            } else {
                activity = uVar.f1764f;
            }
            if (activity != null) {
                a7.H = true;
            }
            a aVar = new a(xVar);
            aVar.f1636o = true;
            a7.I = this;
            aVar.e(getId(), a7, string, 1);
            if (!aVar.f1629g) {
                aVar.f1571p.A(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = xVar.f1775c.f().iterator();
        while (it.hasNext()) {
            d0 d0Var = (d0) it.next();
            n nVar = d0Var.f1613c;
            if (nVar.B == getId() && (view = nVar.J) != null && view.getParent() == null) {
                nVar.I = this;
                d0Var.b();
            }
        }
    }
}
