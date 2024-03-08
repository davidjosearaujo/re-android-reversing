package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import d4.d;
import d4.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k4.i;
import k4.m;
import l0.z;
import n3.g;
import o.h;
import p1.k0;
import p1.y;
import q3.b;
import q3.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class FloatingActionButton extends t implements b4.a, m, CoordinatorLayout.b {

    /* renamed from: g */
    public ColorStateList f3147g;

    /* renamed from: h */
    public PorterDuff.Mode f3148h;

    /* renamed from: i */
    public ColorStateList f3149i;

    /* renamed from: j */
    public PorterDuff.Mode f3150j;

    /* renamed from: k */
    public ColorStateList f3151k;

    /* renamed from: l */
    public int f3152l;
    public int m;

    /* renamed from: n */
    public int f3153n;

    /* renamed from: o */
    public boolean f3154o;

    /* renamed from: p */
    public c4.b f3155p;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: f */
        public Rect f3156f;

        /* renamed from: g */
        public boolean f3157g;

        public BaseBehavior() {
            this.f3157g = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z.f4922h);
            this.f3157g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean e(View view) {
            ((FloatingActionButton) view).getLeft();
            throw null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void g(CoordinatorLayout.f fVar) {
            if (fVar.f1448h == 0) {
                fVar.f1448h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                x(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1442a instanceof BottomSheetBehavior : false) {
                    y(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i7) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList e = coordinatorLayout.e(floatingActionButton);
            int size = e.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view2 = (View) e.get(i8);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1442a instanceof BottomSheetBehavior : false) && y(view2, floatingActionButton)) {
                        break;
                    }
                } else if (x(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.q(floatingActionButton, i7);
            return true;
        }

        public final boolean w(View view, FloatingActionButton floatingActionButton) {
            return this.f3157g && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f1446f == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!w(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f3156f == null) {
                this.f3156f = new Rect();
            }
            Rect rect = this.f3156f;
            d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.g(null, false);
                return true;
            }
            floatingActionButton.k(null, false);
            return true;
        }

        public final boolean y(View view, FloatingActionButton floatingActionButton) {
            if (!w(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.g(null, false);
                return true;
            }
            floatingActionButton.k(null, false);
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b() {
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements j4.b {
        public b() {
            FloatingActionButton.this = r1;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c<T extends FloatingActionButton> implements d.f {
        public c(FloatingActionButton floatingActionButton) {
        }

        @Override // com.google.android.material.floatingactionbutton.d.f
        public final void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.d.f
        public final void b() {
            throw null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            ((c) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }
    }

    private d getImpl() {
        if (this.f3155p == null) {
            this.f3155p = new c4.b(this, new b());
        }
        return this.f3155p;
    }

    @Override // b4.a
    public final boolean a() {
        throw null;
    }

    public final void c() {
        d impl = getImpl();
        if (impl.f3183o == null) {
            impl.f3183o = new ArrayList<>();
        }
        impl.f3183o.add(null);
    }

    public final void d(e eVar) {
        d impl = getImpl();
        if (impl.f3182n == null) {
            impl.f3182n = new ArrayList<>();
        }
        impl.f3182n.add(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public final void e() {
        d impl = getImpl();
        c cVar = new c(this);
        if (impl.f3184p == null) {
            impl.f3184p = new ArrayList<>();
        }
        impl.f3184p.add(cVar);
    }

    public final int f(int i7) {
        int i8 = this.m;
        if (i8 != 0) {
            return i8;
        }
        Resources resources = getResources();
        if (i7 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? f(1) : f(0);
        }
        return resources.getDimensionPixelSize(i7 != 1 ? 2131099764 : 2131099763);
    }

    public final void g(q3.b bVar, boolean z6) {
        d impl = getImpl();
        a aVar = bVar == null ? null : new a(this, bVar);
        int visibility = impl.f3185q.getVisibility();
        int i7 = impl.m;
        boolean z7 = true;
        if (!(visibility != 0 ? i7 != 2 : i7 == 1)) {
            Animator animator = impl.f3176g;
            if (animator != null) {
                animator.cancel();
            }
            FloatingActionButton floatingActionButton = impl.f3185q;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (!y.g.c(floatingActionButton) || impl.f3185q.isInEditMode()) {
                z7 = false;
            }
            if (z7) {
                g gVar = impl.f3178i;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, d.A, d.B);
                b2.addListener(new b(impl, z6, aVar));
                ArrayList<Animator.AnimatorListener> arrayList = impl.f3183o;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b2.addListener(it.next());
                    }
                }
                b2.start();
                return;
            }
            impl.f3185q.b(z6 ? 8 : 4, z6);
            if (aVar != null) {
                aVar.f3159a.a(aVar.f3160b);
            }
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f3147g;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f3148h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f3175f;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.m;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public g getHideMotionSpec() {
        return getImpl().f3178i;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f3151k;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f3151k;
    }

    public i getShapeAppearanceModel() {
        i iVar = getImpl().f3171a;
        iVar.getClass();
        return iVar;
    }

    public g getShowMotionSpec() {
        return getImpl().f3177h;
    }

    public int getSize() {
        return this.f3152l;
    }

    public int getSizeDimension() {
        return f(this.f3152l);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f3149i;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f3150j;
    }

    public boolean getUseCompatPadding() {
        return this.f3154o;
    }

    public final boolean h() {
        d impl = getImpl();
        int visibility = impl.f3185q.getVisibility();
        int i7 = impl.m;
        if (visibility == 0) {
            if (i7 != 1) {
                return false;
            }
        } else if (i7 == 2) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        d impl = getImpl();
        int visibility = impl.f3185q.getVisibility();
        int i7 = impl.m;
        if (visibility != 0) {
            if (i7 != 2) {
                return false;
            }
        } else if (i7 == 1) {
            return false;
        }
        return true;
    }

    public final void j() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f3149i;
            if (colorStateList == null) {
                drawable.clearColorFilter();
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f3150j;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(j.c(colorForState, mode));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public final void k(b.a aVar, boolean z6) {
        d impl = getImpl();
        a aVar2 = aVar == null ? null : new a(this, aVar);
        int visibility = impl.f3185q.getVisibility();
        int i7 = impl.m;
        boolean z7 = true;
        if (!(visibility == 0 ? i7 != 1 : i7 == 2)) {
            Animator animator = impl.f3176g;
            if (animator != null) {
                animator.cancel();
            }
            boolean z8 = impl.f3177h == null;
            FloatingActionButton floatingActionButton = impl.f3185q;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            if (!y.g.c(floatingActionButton) || impl.f3185q.isInEditMode()) {
                z7 = false;
            }
            if (z7) {
                if (impl.f3185q.getVisibility() != 0) {
                    float f7 = 0.0f;
                    impl.f3185q.setAlpha(0.0f);
                    impl.f3185q.setScaleY(z8 ? 0.4f : 0.0f);
                    impl.f3185q.setScaleX(z8 ? 0.4f : 0.0f);
                    if (z8) {
                        f7 = 0.4f;
                    }
                    impl.f3180k = f7;
                    Matrix matrix = impl.f3189v;
                    impl.a(f7, matrix);
                    impl.f3185q.setImageMatrix(matrix);
                }
                g gVar = impl.f3177h;
                AnimatorSet b2 = gVar != null ? impl.b(gVar, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, d.f3169y, d.f3170z);
                b2.addListener(new c(impl, z6, aVar2));
                ArrayList<Animator.AnimatorListener> arrayList = impl.f3182n;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        b2.addListener(it.next());
                    }
                }
                b2.start();
                return;
            }
            impl.f3185q.b(0, z6);
            impl.f3185q.setAlpha(1.0f);
            impl.f3185q.setScaleY(1.0f);
            impl.f3185q.setScaleX(1.0f);
            impl.f3180k = 1.0f;
            Matrix matrix2 = impl.f3189v;
            impl.a(1.0f, matrix2);
            impl.f3185q.setImageMatrix(matrix2);
            if (aVar2 != null) {
                aVar2.f3159a.b();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        impl.getClass();
        if (!(impl instanceof c4.b)) {
            ViewTreeObserver viewTreeObserver = impl.f3185q.getViewTreeObserver();
            if (impl.f3190w == null) {
                impl.f3190w = new c4.a(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.f3190w);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f3185q.getViewTreeObserver();
        c4.a aVar = impl.f3190w;
        if (aVar != null) {
            viewTreeObserver.removeOnPreDrawListener(aVar);
            impl.f3190w = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i7, int i8) {
        int sizeDimension = (getSizeDimension() - this.f3153n) / 2;
        getImpl().n();
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n4.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n4.a aVar = (n4.a) parcelable;
        super.onRestoreInstanceState(aVar.f6374f);
        aVar.f5178h.getOrDefault("expandableWidgetHelper", null).getClass();
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        new h();
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3147g != colorStateList) {
            this.f3147g = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3148h != mode) {
            this.f3148h = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f7) {
        d impl = getImpl();
        if (impl.f3174d != f7) {
            impl.f3174d = f7;
            impl.j(f7, impl.e, impl.f3175f);
        }
    }

    public void setCompatElevationResource(int i7) {
        setCompatElevation(getResources().getDimension(i7));
    }

    public void setCompatHoveredFocusedTranslationZ(float f7) {
        d impl = getImpl();
        if (impl.e != f7) {
            impl.e = f7;
            impl.j(impl.f3174d, f7, impl.f3175f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i7) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i7));
    }

    public void setCompatPressedTranslationZ(float f7) {
        d impl = getImpl();
        if (impl.f3175f != f7) {
            impl.f3175f = f7;
            impl.j(impl.f3174d, impl.e, f7);
        }
    }

    public void setCompatPressedTranslationZResource(int i7) {
        setCompatPressedTranslationZ(getResources().getDimension(i7));
    }

    public void setCustomSize(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i7 != this.m) {
            this.m = i7;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z6) {
        if (z6 != getImpl().f3172b) {
            getImpl().f3172b = z6;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i7) {
        throw null;
    }

    public void setHideMotionSpec(g gVar) {
        getImpl().f3178i = gVar;
    }

    public void setHideMotionSpecResource(int i7) {
        setHideMotionSpec(g.a(getContext(), i7));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            float f7 = impl.f3180k;
            impl.f3180k = f7;
            Matrix matrix = impl.f3189v;
            impl.a(f7, matrix);
            impl.f3185q.setImageMatrix(matrix);
            if (this.f3149i != null) {
                j();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        throw null;
    }

    public void setMaxImageSize(int i7) {
        this.f3153n = i7;
        d impl = getImpl();
        if (impl.f3181l != i7) {
            impl.f3181l = i7;
            float f7 = impl.f3180k;
            impl.f3180k = f7;
            Matrix matrix = impl.f3189v;
            impl.a(f7, matrix);
            impl.f3185q.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i7) {
        setRippleColor(ColorStateList.valueOf(i7));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f3151k != colorStateList) {
            this.f3151k = colorStateList;
            getImpl().l();
        }
    }

    @Override // android.view.View
    public void setScaleX(float f7) {
        super.setScaleX(f7);
        ArrayList<d.f> arrayList = getImpl().f3184p;
        if (arrayList != null) {
            Iterator<d.f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    @Override // android.view.View
    public void setScaleY(float f7) {
        super.setScaleY(f7);
        ArrayList<d.f> arrayList = getImpl().f3184p;
        if (arrayList != null) {
            Iterator<d.f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void setShadowPaddingEnabled(boolean z6) {
        d impl = getImpl();
        impl.f3173c = z6;
        impl.n();
        throw null;
    }

    @Override // k4.m
    public void setShapeAppearanceModel(i iVar) {
        getImpl().f3171a = iVar;
    }

    public void setShowMotionSpec(g gVar) {
        getImpl().f3177h = gVar;
    }

    public void setShowMotionSpecResource(int i7) {
        setShowMotionSpec(g.a(getContext(), i7));
    }

    public void setSize(int i7) {
        this.m = 0;
        if (i7 != this.f3152l) {
            this.f3152l = i7;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3149i != colorStateList) {
            this.f3149i = colorStateList;
            j();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3150j != mode) {
            this.f3150j = mode;
            j();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f7) {
        super.setTranslationX(f7);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationY(float f7) {
        super.setTranslationY(f7);
        getImpl().k();
    }

    @Override // android.view.View
    public void setTranslationZ(float f7) {
        super.setTranslationZ(f7);
        getImpl().k();
    }

    public void setUseCompatPadding(boolean z6) {
        if (this.f3154o != z6) {
            this.f3154o = z6;
            getImpl().h();
        }
    }

    @Override // d4.t, android.widget.ImageView, android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
    }
}
