package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import d4.o;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;

/* loaded from: classes.dex */
public final class SearchBar extends Toolbar {

    /* renamed from: c0 */
    public Drawable f3213c0;

    /* renamed from: d0 */
    public int f3214d0;

    /* renamed from: e0 */
    public boolean f3215e0;

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: l */
        public boolean f3216l;

        public ScrollingViewBehavior() {
            this.f3216l = false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3216l = false;
        }

        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            super.h(coordinatorLayout, view, view2);
            if (!this.f3216l && (view2 instanceof AppBarLayout)) {
                this.f3216l = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setTargetElevation(0.0f);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Kotlin_2.a {
        public static final Parcelable.Creator CREATOR = new C0037a();

        /* renamed from: h */
        public String f3217h;

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3217h = parcel.readString();
        }

        public a(Toolbar.i iVar) {
            super(iVar);
        }

        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeString(this.f3217h);
        }

        /* renamed from: com.google.android.material.search.SearchBar$a$a */
        /* loaded from: classes.dex */
        public class C0037a implements Parcelable.ClassLoaderCreator {
            public final Object createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            public final Object[] newArray(int i7) {
                return new a[i7];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }
        }
    }

    private void setNavigationIconDecorative(boolean z6) {
        ImageButton a7 = o.a(this);
        if (a7 == null) {
            return;
        }
        a7.setClickable(!z6);
        a7.setFocusable(!z6);
        Drawable background = a7.getBackground();
        if (background != null) {
            this.f3213c0 = background;
        }
        a7.setBackgroundDrawable(z6 ? null : this.f3213c0);
    }

    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
    }

    public View getCenterView() {
        return null;
    }

    public float getCompatElevation() {
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        return y.i.i(this);
    }

    public float getCornerSize() {
        throw null;
    }

    public int getDefaultMarginVerticalResource() {
        return 2131100120;
    }

    public int getDefaultNavigationIconResource() {
        return 2131165365;
    }

    public CharSequence getHint() {
        throw null;
    }

    public int getMenuResId() {
        return this.f3214d0;
    }

    public int getStrokeColor() {
        throw null;
    }

    public float getStrokeWidth() {
        throw null;
    }

    public CharSequence getText() {
        throw null;
    }

    public TextView getTextView() {
        return null;
    }

    public final void k(int i7) {
        Menu menu = getMenu();
        boolean z6 = menu instanceof f;
        if (z6) {
            ((f) menu).w();
        }
        super.k(i7);
        this.f3214d0 = i7;
        if (z6) {
            ((f) menu).v();
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q2.a.L(this, null);
        throw null;
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        accessibilityNodeInfo.setHintText(getHint());
        accessibilityNodeInfo.setShowingHintText(isEmpty);
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
    }

    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f6374f);
        setText(aVar.f3217h);
    }

    public final Parcelable onSaveInstanceState() {
        a aVar = new a((Toolbar.i) super.onSaveInstanceState());
        CharSequence text = getText();
        aVar.f3217h = text == null ? null : text.toString();
        return aVar;
    }

    public void setCenterView(View view) {
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z6) {
        this.f3215e0 = z6;
        if (getLayoutParams() instanceof AppBarLayout.c) {
            AppBarLayout.c cVar = (AppBarLayout.c) getLayoutParams();
            if (this.f3215e0) {
                if (cVar.f2778a == 0) {
                    cVar.f2778a = 53;
                }
            } else if (cVar.f2778a == 53) {
                cVar.f2778a = 0;
            }
        }
    }

    public void setElevation(float f7) {
        super.setElevation(f7);
    }

    public void setHint(int i7) {
        throw null;
    }

    public void setHint(CharSequence charSequence) {
        throw null;
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(drawable);
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z6) {
        throw null;
    }

    public void setStrokeColor(int i7) {
        if (getStrokeColor() == i7) {
            return;
        }
        ColorStateList.valueOf(i7);
        throw null;
    }

    public void setStrokeWidth(float f7) {
        if (getStrokeWidth() != f7) {
            throw null;
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(int i7) {
        throw null;
    }

    public void setText(CharSequence charSequence) {
        throw null;
    }

    public void setTitle(CharSequence charSequence) {
    }
}
