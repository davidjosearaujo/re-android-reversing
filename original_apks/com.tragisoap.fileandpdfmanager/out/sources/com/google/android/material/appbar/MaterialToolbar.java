package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import d4.n;
import d4.o;
import j1.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import k4.f;
import l0.z;
import p1.k0;
import p1.y;
import q4.a;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: h0  reason: collision with root package name */
    public static final ImageView.ScaleType[] f2781h0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: c0  reason: collision with root package name */
    public Integer f2782c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f2783d0;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f2784e0;

    /* renamed from: f0  reason: collision with root package name */
    public ImageView.ScaleType f2785f0;

    /* renamed from: g0  reason: collision with root package name */
    public Boolean f2786g0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 2130904272, 2131887200), attributeSet, 0);
        Context context2 = getContext();
        TypedArray d7 = n.d(context2, attributeSet, z.f4932t, 2130904272, 2131887200, new int[0]);
        if (d7.hasValue(2)) {
            setNavigationIconTint(d7.getColor(2, -1));
        }
        this.f2783d0 = d7.getBoolean(4, false);
        this.f2784e0 = d7.getBoolean(3, false);
        int i7 = d7.getInt(1, -1);
        if (i7 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f2781h0;
            if (i7 < scaleTypeArr.length) {
                this.f2785f0 = scaleTypeArr[i7];
            }
        }
        if (d7.hasValue(0)) {
            this.f2786g0 = Boolean.valueOf(d7.getBoolean(0, false));
        }
        d7.recycle();
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : z3.a.a(background);
        if (valueOf != null) {
            f fVar = new f();
            fVar.k(valueOf);
            fVar.i(context2);
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            fVar.j(y.i.i(this));
            y.d.q(this, fVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f2785f0;
    }

    public Integer getNavigationIconTint() {
        return this.f2782c0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void k(int i7) {
        Menu menu = getMenu();
        boolean z6 = menu instanceof androidx.appcompat.view.menu.f;
        if (z6) {
            ((androidx.appcompat.view.menu.f) menu).w();
        }
        super.k(i7);
        if (z6) {
            ((androidx.appcompat.view.menu.f) menu).v();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof f) {
            q2.a.L(this, (f) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z6, i7, i8, i9, i10);
        int i11 = 0;
        ImageView imageView2 = null;
        if (this.f2783d0 || this.f2784e0) {
            ArrayList b2 = o.b(this, getTitle());
            TextView textView = b2.isEmpty() ? null : (TextView) Collections.min(b2, o.f3632a);
            ArrayList b7 = o.b(this, getSubtitle());
            TextView textView2 = b7.isEmpty() ? null : (TextView) Collections.max(b7, o.f3632a);
            if (!(textView == null && textView2 == null)) {
                int measuredWidth = getMeasuredWidth();
                int i12 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i13 = 0; i13 < getChildCount(); i13++) {
                    View childAt = getChildAt(i13);
                    if (!(childAt.getVisibility() == 8 || childAt == textView || childAt == textView2)) {
                        if (childAt.getRight() < i12 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i12 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f2783d0 && textView != null) {
                    t(textView, pair);
                }
                if (this.f2784e0 && textView2 != null) {
                    t(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i11 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i11);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i11++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f2786g0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f2785f0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        Drawable background = getBackground();
        if (background instanceof f) {
            ((f) background).j(f7);
        }
    }

    public void setLogoAdjustViewBounds(boolean z6) {
        Boolean bool = this.f2786g0;
        if (bool == null || bool.booleanValue() != z6) {
            this.f2786g0 = Boolean.valueOf(z6);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f2785f0 != scaleType) {
            this.f2785f0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (!(drawable == null || this.f2782c0 == null)) {
            drawable = drawable.mutate();
            a.b.g(drawable, this.f2782c0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i7) {
        this.f2782c0 = Integer.valueOf(i7);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z6) {
        if (this.f2784e0 != z6) {
            this.f2784e0 = z6;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z6) {
        if (this.f2783d0 != z6) {
            this.f2783d0 = z6;
            requestLayout();
        }
    }

    public final void t(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i7 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i8 = measuredWidth2 + i7;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i7, 0), Math.max(i8 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i7 += max;
            i8 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i8 - i7, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i7, textView.getTop(), i8, textView.getBottom());
    }
}
