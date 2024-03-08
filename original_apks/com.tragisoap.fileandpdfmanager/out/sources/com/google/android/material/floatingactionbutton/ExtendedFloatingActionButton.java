package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.s0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l0.z;
import n3.g;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: f  reason: collision with root package name */
        public Rect f3144f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f3145g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f3146h;

        public ExtendedFloatingActionButtonBehavior() {
            this.f3145g = false;
            this.f3146h = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4921g);
            this.f3145g = obtainStyledAttributes.getBoolean(0, false);
            this.f3146h = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ boolean e(View view) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void g(CoordinatorLayout.f fVar) {
            if (fVar.f1448h == 0) {
                fVar.f1448h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1442a instanceof BottomSheetBehavior : false) {
                    x(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList e = coordinatorLayout.e(extendedFloatingActionButton);
            int size = e.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view2 = (View) e.get(i8);
                if (view2 instanceof AppBarLayout) {
                    w(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                } else {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1442a instanceof BottomSheetBehavior : false) {
                        x(view2, extendedFloatingActionButton);
                    }
                }
            }
            coordinatorLayout.q(extendedFloatingActionButton, i7);
            return true;
        }

        public final void w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i7 = 1;
            int i8 = 0;
            if ((this.f3145g || this.f3146h) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).f1446f == appBarLayout.getId()) {
                if (this.f3144f == null) {
                    this.f3144f = new Rect();
                }
                Rect rect = this.f3144f;
                d4.d.a(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    if (this.f3146h) {
                        i7 = 2;
                    }
                    ExtendedFloatingActionButton.e(extendedFloatingActionButton, i7);
                    throw null;
                }
                if (this.f3146h) {
                    i8 = 3;
                }
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, i8);
                throw null;
            }
        }

        public final void x(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i7 = 1;
            int i8 = 0;
            if ((this.f3145g || this.f3146h) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).f1446f == view.getId()) {
                if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                    if (this.f3146h) {
                        i7 = 2;
                    }
                    ExtendedFloatingActionButton.e(extendedFloatingActionButton, i7);
                    throw null;
                }
                if (this.f3146h) {
                    i8 = 3;
                }
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, i8);
                throw null;
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends Property<View, Float> {
        public a() {
            super(Float.class, "width");
        }

        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public final void set(View view, Float f7) {
            View view2 = view;
            view2.getLayoutParams().width = f7.intValue();
            view2.requestLayout();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends Property<View, Float> {
        public b() {
            super(Float.class, "height");
        }

        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public final void set(View view, Float f7) {
            View view2 = view;
            view2.getLayoutParams().height = f7.intValue();
            view2.requestLayout();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c extends Property<View, Float> {
        public c() {
            super(Float.class, "paddingStart");
        }

        @Override // android.util.Property
        public final Float get(View view) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            return Float.valueOf((float) y.e.f(view));
        }

        @Override // android.util.Property
        public final void set(View view, Float f7) {
            View view2 = view;
            int intValue = f7.intValue();
            int paddingTop = view2.getPaddingTop();
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.e.k(view2, intValue, paddingTop, y.e.e(view2), view2.getPaddingBottom());
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class d extends Property<View, Float> {
        public d() {
            super(Float.class, "paddingEnd");
        }

        @Override // android.util.Property
        public final Float get(View view) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            return Float.valueOf((float) y.e.e(view));
        }

        @Override // android.util.Property
        public final void set(View view, Float f7) {
            View view2 = view;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.e.k(view2, y.e.f(view2), view2.getPaddingTop(), f7.intValue(), view2.getPaddingBottom());
        }
    }

    static {
        new a();
        new b();
        new c();
        new d();
    }

    public static void e(ExtendedFloatingActionButton extendedFloatingActionButton, int i7) {
        if (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 3) {
            throw null;
        }
        throw new IllegalStateException(s0.g("Unknown strategy type: ", i7));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public g getExtendMotionSpec() {
        throw null;
    }

    public g getHideMotionSpec() {
        throw null;
    }

    public g getShowMotionSpec() {
        throw null;
    }

    public g getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAnimateShowBeforeLayout(boolean z6) {
    }

    public void setExtendMotionSpec(g gVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i7) {
        setExtendMotionSpec(g.a(getContext(), i7));
    }

    public void setExtended(boolean z6) {
        if (z6) {
            throw null;
        }
    }

    public void setHideMotionSpec(g gVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i7) {
        setHideMotionSpec(g.a(getContext(), i7));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i7, int i8, int i9, int i10) {
        super.setPadding(i7, i8, i9, i10);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int i7, int i8, int i9, int i10) {
        super.setPaddingRelative(i7, i8, i9, i10);
    }

    public void setShowMotionSpec(g gVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i7) {
        setShowMotionSpec(g.a(getContext(), i7));
    }

    public void setShrinkMotionSpec(g gVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i7) {
        setShrinkMotionSpec(g.a(getContext(), i7));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i7) {
        super.setTextColor(i7);
        getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }
}
