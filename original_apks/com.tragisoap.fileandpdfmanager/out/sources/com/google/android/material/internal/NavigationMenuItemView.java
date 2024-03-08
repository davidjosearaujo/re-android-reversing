package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.l0;
import d4.g;
import h1.f;
import j1.a;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class NavigationMenuItemView extends g implements k.a {
    public static final int[] L = {16842912};
    public int A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final CheckedTextView E;
    public FrameLayout F;
    public h G;
    public ColorStateList H;
    public boolean I;
    public Drawable J;
    public final a K;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends p1.a {
        public a() {
        }

        @Override // p1.a
        public final void d(View view, f fVar) {
            this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
            fVar.f5624a.setCheckable(NavigationMenuItemView.this.C);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, 0);
        this.D = true;
        a aVar = new a();
        this.K = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(2131492912, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(2131099769));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(2131296428);
        this.E = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        y.i(checkedTextView, aVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.F == null) {
                this.F = (FrameLayout) ((ViewStub) findViewById(2131296427)).inflate();
            }
            this.F.removeAllViews();
            this.F.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public final void c(h hVar) {
        l0.a aVar;
        int i7;
        StateListDrawable stateListDrawable;
        this.G = hVar;
        int i8 = hVar.f603a;
        if (i8 > 0) {
            setId(i8);
        }
        setVisibility(hVar.isVisible() ? 0 : 8);
        boolean z6 = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130903290, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(L, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.q(this, stateListDrawable);
        }
        setCheckable(hVar.isCheckable());
        setChecked(hVar.isChecked());
        setEnabled(hVar.isEnabled());
        setTitle(hVar.e);
        setIcon(hVar.getIcon());
        setActionView(hVar.getActionView());
        setContentDescription(hVar.f617q);
        d1.a(this, hVar.f618r);
        h hVar2 = this.G;
        if (!(hVar2.e == null && hVar2.getIcon() == null && this.G.getActionView() != null)) {
            z6 = false;
        }
        if (z6) {
            this.E.setVisibility(8);
            FrameLayout frameLayout = this.F;
            if (frameLayout != null) {
                aVar = (l0.a) frameLayout.getLayoutParams();
                i7 = -1;
            } else {
                return;
            }
        } else {
            this.E.setVisibility(0);
            FrameLayout frameLayout2 = this.F;
            if (frameLayout2 != null) {
                aVar = (l0.a) frameLayout2.getLayoutParams();
                i7 = -2;
            } else {
                return;
            }
        }
        ((LinearLayout.LayoutParams) aVar).width = i7;
        this.F.setLayoutParams(aVar);
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.G;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i7) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i7 + 1);
        h hVar = this.G;
        if (hVar != null && hVar.isCheckable() && this.G.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, L);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z6) {
        refreshDrawableState();
        if (this.C != z6) {
            this.C = z6;
            this.K.h(this.E, 2048);
        }
    }

    public void setChecked(boolean z6) {
        refreshDrawableState();
        this.E.setChecked(z6);
        CheckedTextView checkedTextView = this.E;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (!z6 || !this.D) ? 0 : 1);
    }

    public void setHorizontalPadding(int i7) {
        setPadding(i7, getPaddingTop(), i7, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.I) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                a.b.h(drawable, this.H);
            }
            int i7 = this.A;
            drawable.setBounds(0, 0, i7, i7);
        } else if (this.B) {
            if (this.J == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal<TypedValue> threadLocal = h1.f.f4353a;
                Drawable a7 = f.a.a(resources, 2131165436, theme);
                this.J = a7;
                if (a7 != null) {
                    int i8 = this.A;
                    a7.setBounds(0, 0, i8, i8);
                }
            }
            drawable = this.J;
        }
        t1.k.e(this.E, drawable, null, null, null);
    }

    public void setIconPadding(int i7) {
        this.E.setCompoundDrawablePadding(i7);
    }

    public void setIconSize(int i7) {
        this.A = i7;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.H = colorStateList;
        this.I = colorStateList != null;
        h hVar = this.G;
        if (hVar != null) {
            setIcon(hVar.getIcon());
        }
    }

    public void setMaxLines(int i7) {
        this.E.setMaxLines(i7);
    }

    public void setNeedsEmptyIcon(boolean z6) {
        this.B = z6;
    }

    public void setTextAppearance(int i7) {
        this.E.setTextAppearance(i7);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.E.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.E.setText(charSequence);
    }
}
