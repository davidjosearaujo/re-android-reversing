package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.activity.h;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.f;
import d4.n;
import d4.s;
import h1.f;
import j1.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import l0.z;
import l2.d;
import l2.e;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class MaterialCheckBox extends f {
    public static final int[] D = {2130904101};
    public static final int[] E = {2130904100};
    public static final int[][] F = {new int[]{16842910, 2130904100}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    @SuppressLint({"DiscouragedApi"})
    public static final int G = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public CompoundButton.OnCheckedChangeListener A;
    public final l2.d B;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f2976l;
    public boolean m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2977n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2978o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f2979p;

    /* renamed from: q  reason: collision with root package name */
    public Drawable f2980q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f2981r;
    public boolean s;

    /* renamed from: u  reason: collision with root package name */
    public ColorStateList f2983u;

    /* renamed from: v  reason: collision with root package name */
    public PorterDuff.Mode f2984v;

    /* renamed from: w  reason: collision with root package name */
    public int f2985w;

    /* renamed from: x  reason: collision with root package name */
    public int[] f2986x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2987y;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f2988z;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashSet<c> f2974j = new LinkedHashSet<>();

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashSet<b> f2975k = new LinkedHashSet<>();
    public final a C = new a();

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f2982t = getSuperButtonTintList();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends l2.c {
        public a() {
        }

        @Override // l2.c
        public final void a(Drawable drawable) {
            ColorStateList colorStateList = MaterialCheckBox.this.f2982t;
            if (colorStateList != null) {
                a.b.h(drawable, colorStateList);
            }
        }

        @Override // l2.c
        public final void b(Drawable drawable) {
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.f2982t;
            if (colorStateList != null) {
                a.b.g(drawable, colorStateList.getColorForState(materialCheckBox.f2986x, colorStateList.getDefaultColor()));
            }
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: f  reason: collision with root package name */
        public int f2990f;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public final d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final d[] newArray(int i7) {
                return new d[i7];
            }
        }

        public d(Parcel parcel) {
            super(parcel);
            this.f2990f = ((Integer) parcel.readValue(d.class.getClassLoader())).intValue();
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public final String toString() {
            StringBuilder d7 = h.d("MaterialCheckBox.SavedState{");
            d7.append(Integer.toHexString(System.identityHashCode(this)));
            d7.append(" CheckedState=");
            int i7 = this.f2990f;
            return h.c(d7, i7 != 1 ? i7 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public final void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeValue(Integer.valueOf(this.f2990f));
        }
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 2130903219, 2131887124), attributeSet, 2130903219);
        Context context2 = getContext();
        l2.d dVar = new l2.d(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal<TypedValue> threadLocal = h1.f.f4353a;
        Drawable a7 = f.a.a(resources, 2131165396, theme);
        dVar.f4966f = a7;
        a7.setCallback(dVar.f4958k);
        new d.c(dVar.f4966f.getConstantState());
        this.B = dVar;
        Context context3 = getContext();
        this.f2980q = t1.c.a(this);
        setSupportButtonTintList(null);
        int[] iArr = z.f4928o;
        n.a(context3, attributeSet, 2130903219, 2131887124);
        n.b(context3, attributeSet, iArr, 2130903219, 2131887124, new int[0]);
        a1 a1Var = new a1(context3, context3.obtainStyledAttributes(attributeSet, iArr, 2130903219, 2131887124));
        this.f2981r = a1Var.e(2);
        if (this.f2980q != null && g4.b.b(context3, 2130903639, false)) {
            if (a1Var.i(0, 0) == G && a1Var.i(1, 0) == 0) {
                super.setButtonDrawable((Drawable) null);
                this.f2980q = g.a.a(context3, 2131165395);
                this.s = true;
                if (this.f2981r == null) {
                    this.f2981r = g.a.a(context3, 2131165397);
                }
            }
        }
        this.f2983u = g4.c.b(context3, a1Var, 3);
        this.f2984v = s.b(a1Var.h(4, -1), PorterDuff.Mode.SRC_IN);
        this.m = a1Var.a(10, false);
        this.f2977n = a1Var.a(6, true);
        this.f2978o = a1Var.a(9, false);
        this.f2979p = a1Var.k(8);
        if (a1Var.l(7)) {
            setCheckedState(a1Var.h(7, 0));
        }
        a1Var.n();
        b();
    }

    private String getButtonStateDescription() {
        int i7 = this.f2985w;
        return getResources().getString(i7 == 1 ? 2131820662 : i7 == 0 ? 2131820664 : 2131820663);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2976l == null) {
            int[][] iArr = F;
            int v6 = q2.a.v(this, 2130903289);
            int v7 = q2.a.v(this, 2130903292);
            int v8 = q2.a.v(this, 2130903330);
            int v9 = q2.a.v(this, 2130903308);
            this.f2976l = new ColorStateList(iArr, new int[]{q2.a.F(v8, v7, 1.0f), q2.a.F(v8, v6, 1.0f), q2.a.F(v8, v9, 0.54f), q2.a.F(v8, v9, 0.38f), q2.a.F(v8, v9, 0.38f)});
        }
        return this.f2976l;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f2982t;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void b() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        l2.d dVar;
        e eVar;
        Drawable drawable = this.f2980q;
        ColorStateList colorStateList3 = this.f2982t;
        PorterDuff.Mode b2 = t1.b.b(this);
        if (drawable == null) {
            drawable = null;
        } else if (colorStateList3 != null) {
            drawable = drawable.mutate();
            if (b2 != null) {
                a.b.i(drawable, b2);
            }
        }
        this.f2980q = drawable;
        Drawable drawable2 = this.f2981r;
        ColorStateList colorStateList4 = this.f2983u;
        PorterDuff.Mode mode = this.f2984v;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (colorStateList4 != null) {
            drawable2 = drawable2.mutate();
            if (mode != null) {
                a.b.i(drawable2, mode);
            }
        }
        this.f2981r = drawable2;
        if (this.s) {
            l2.d dVar2 = this.B;
            if (dVar2 != null) {
                a aVar = this.C;
                Drawable drawable3 = dVar2.f4966f;
                if (drawable3 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable3;
                    if (aVar.f4953a == null) {
                        aVar.f4953a = new l2.b(aVar);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar.f4953a);
                }
                ArrayList<l2.c> arrayList = dVar2.f4957j;
                if (!(arrayList == null || aVar == null)) {
                    arrayList.remove(aVar);
                    if (dVar2.f4957j.size() == 0 && (eVar = dVar2.f4956i) != null) {
                        dVar2.f4954g.f4961b.removeListener(eVar);
                        dVar2.f4956i = null;
                    }
                }
                l2.d dVar3 = this.B;
                a aVar2 = this.C;
                Drawable drawable4 = dVar3.f4966f;
                if (drawable4 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable4;
                    if (aVar2.f4953a == null) {
                        aVar2.f4953a = new l2.b(aVar2);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar2.f4953a);
                } else if (aVar2 != null) {
                    if (dVar3.f4957j == null) {
                        dVar3.f4957j = new ArrayList<>();
                    }
                    if (!dVar3.f4957j.contains(aVar2)) {
                        dVar3.f4957j.add(aVar2);
                        if (dVar3.f4956i == null) {
                            dVar3.f4956i = new e(dVar3);
                        }
                        dVar3.f4954g.f4961b.addListener(dVar3.f4956i);
                    }
                }
            }
            Drawable drawable5 = this.f2980q;
            if ((drawable5 instanceof AnimatedStateListDrawable) && (dVar = this.B) != null) {
                ((AnimatedStateListDrawable) drawable5).addTransition(2131296385, 2131296894, dVar, false);
                ((AnimatedStateListDrawable) this.f2980q).addTransition(2131296562, 2131296894, this.B, false);
            }
        }
        Drawable drawable6 = this.f2980q;
        if (!(drawable6 == null || (colorStateList2 = this.f2982t) == null)) {
            a.b.h(drawable6, colorStateList2);
        }
        Drawable drawable7 = this.f2981r;
        if (!(drawable7 == null || (colorStateList = this.f2983u) == null)) {
            a.b.h(drawable7, colorStateList);
        }
        Drawable drawable8 = this.f2980q;
        Drawable drawable9 = this.f2981r;
        if (drawable8 == null) {
            drawable8 = drawable9;
        } else if (drawable9 != null) {
            int intrinsicWidth = drawable9.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable8.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable9.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable8.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable8.getIntrinsicWidth() || intrinsicHeight > drawable8.getIntrinsicHeight()) {
                float f7 = ((float) intrinsicWidth) / ((float) intrinsicHeight);
                if (f7 >= ((float) drawable8.getIntrinsicWidth()) / ((float) drawable8.getIntrinsicHeight())) {
                    intrinsicWidth = drawable8.getIntrinsicWidth();
                    intrinsicHeight = (int) (((float) intrinsicWidth) / f7);
                } else {
                    intrinsicHeight = drawable8.getIntrinsicHeight();
                    intrinsicWidth = (int) (f7 * ((float) intrinsicHeight));
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable8, drawable9});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable8 = layerDrawable;
        }
        super.setButtonDrawable(drawable8);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f2980q;
    }

    public Drawable getButtonIconDrawable() {
        return this.f2981r;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f2983u;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f2984v;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f2982t;
    }

    public int getCheckedState() {
        return this.f2985w;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f2979p;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f2985w == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m && this.f2982t == null && this.f2983u == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public final int[] onCreateDrawableState(int i7) {
        int[] copyOf;
        int[] onCreateDrawableState = super.onCreateDrawableState(i7 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, D);
        }
        if (this.f2978o) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        int i8 = 0;
        while (true) {
            if (i8 >= onCreateDrawableState.length) {
                copyOf = Arrays.copyOf(onCreateDrawableState, onCreateDrawableState.length + 1);
                copyOf[onCreateDrawableState.length] = 16842912;
                break;
            }
            int i9 = onCreateDrawableState[i8];
            if (i9 == 16842912) {
                copyOf = onCreateDrawableState;
                break;
            } else if (i9 == 0) {
                copyOf = (int[]) onCreateDrawableState.clone();
                copyOf[i8] = 16842912;
                break;
            } else {
                i8++;
            }
        }
        this.f2986x = copyOf;
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable a7;
        if (!this.f2977n || !TextUtils.isEmpty(getText()) || (a7 = t1.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - a7.getIntrinsicWidth()) / 2) * (s.a(this) ? -1 : 1);
        int save = canvas.save();
        canvas.translate((float) width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(save);
        if (getBackground() != null) {
            Rect bounds = a7.getBounds();
            a.b.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f2978o) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f2979p));
        }
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        setCheckedState(dVar.f2990f);
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public final Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f2990f = getCheckedState();
        return dVar;
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(int i7) {
        setButtonDrawable(g.a.a(getContext(), i7));
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.f2980q = drawable;
        this.s = false;
        b();
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f2981r = drawable;
        b();
    }

    public void setButtonIconDrawableResource(int i7) {
        setButtonIconDrawable(g.a.a(getContext(), i7));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f2983u != colorStateList) {
            this.f2983u = colorStateList;
            b();
        }
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f2984v != mode) {
            this.f2984v = mode;
            b();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f2982t != colorStateList) {
            this.f2982t = colorStateList;
            b();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        b();
    }

    public void setCenterIfNoTextEnabled(boolean z6) {
        this.f2977n = z6;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z6) {
        setCheckedState(z6 ? 1 : 0);
    }

    public void setCheckedState(int i7) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f2985w != i7) {
            this.f2985w = i7;
            super.setChecked(i7 == 1);
            refreshDrawableState();
            if (this.f2988z == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (!this.f2987y) {
                this.f2987y = true;
                LinkedHashSet<b> linkedHashSet = this.f2975k;
                if (linkedHashSet != null) {
                    Iterator<b> it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                }
                if (!(this.f2985w == 2 || (onCheckedChangeListener = this.A) == null)) {
                    onCheckedChangeListener.onCheckedChanged(this, isChecked());
                }
                AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
                if (autofillManager != null) {
                    autofillManager.notifyValueChanged(this);
                }
                this.f2987y = false;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z6) {
        super.setEnabled(z6);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f2979p = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i7) {
        setErrorAccessibilityLabel(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void setErrorShown(boolean z6) {
        if (this.f2978o != z6) {
            this.f2978o = z6;
            refreshDrawableState();
            Iterator<c> it = this.f2974j.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.A = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f2988z = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else if (charSequence == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z6) {
        this.m = z6;
        t1.b.c(this, z6 ? getMaterialThemeColorsTintList() : null);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }
}
