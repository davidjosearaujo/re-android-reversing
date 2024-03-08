package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import d4.n;
import d4.s;
import j1.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k4.i;
import k4.m;
import l0.z;
import p1.k0;
import p1.y;
import t1.k;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, m {

    /* renamed from: w */
    public static final int[] f2901w = {16842911};

    /* renamed from: x */
    public static final int[] f2902x = {16842912};

    /* renamed from: i */
    public final s3.a f2903i;

    /* renamed from: k */
    public b f2905k;

    /* renamed from: l */
    public PorterDuff.Mode f2906l;
    public ColorStateList m;

    /* renamed from: n */
    public Drawable f2907n;

    /* renamed from: o */
    public String f2908o;

    /* renamed from: p */
    public int f2909p;

    /* renamed from: q */
    public int f2910q;

    /* renamed from: r */
    public int f2911r;
    public int s;

    /* renamed from: v */
    public int f2914v;

    /* renamed from: j */
    public final LinkedHashSet<a> f2904j = new LinkedHashSet<>();

    /* renamed from: t */
    public boolean f2912t = false;

    /* renamed from: u */
    public boolean f2913u = false;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface a {
        void a();
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface b {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class c extends w1.a {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: h */
        public boolean f2915h;

        /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i7) {
                return new c[i7];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            this.f2915h = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // w1.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i7) {
            parcel.writeParcelable(this.f6374f, i7);
            parcel.writeInt(this.f2915h ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(q4.a.a(context, attributeSet, 2130903796, 2131887100), attributeSet, 2130903796);
        boolean z6 = false;
        Context context2 = getContext();
        TypedArray d7 = n.d(context2, attributeSet, z.f4925k, 2130903796, 2131887100, new int[0]);
        this.s = d7.getDimensionPixelSize(12, 0);
        this.f2906l = s.b(d7.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.m = g4.c.a(getContext(), d7, 14);
        this.f2907n = g4.c.c(getContext(), d7, 10);
        this.f2914v = d7.getInteger(11, 1);
        this.f2909p = d7.getDimensionPixelSize(13, 0);
        s3.a aVar = new s3.a(this, new i(i.b(context2, attributeSet, 2130903796, 2131887100)));
        this.f2903i = aVar;
        aVar.f5970c = d7.getDimensionPixelOffset(1, 0);
        aVar.f5971d = d7.getDimensionPixelOffset(2, 0);
        aVar.e = d7.getDimensionPixelOffset(3, 0);
        aVar.f5972f = d7.getDimensionPixelOffset(4, 0);
        if (d7.hasValue(8)) {
            int dimensionPixelSize = d7.getDimensionPixelSize(8, -1);
            aVar.f5973g = dimensionPixelSize;
            i iVar = aVar.f5969b;
            float f7 = (float) dimensionPixelSize;
            iVar.getClass();
            i.a aVar2 = new i.a(iVar);
            aVar2.e(f7);
            aVar2.f(f7);
            aVar2.d(f7);
            aVar2.c(f7);
            aVar.c(new i(aVar2));
            aVar.f5981p = true;
        }
        aVar.f5974h = d7.getDimensionPixelSize(20, 0);
        aVar.f5975i = s.b(d7.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        aVar.f5976j = g4.c.a(getContext(), d7, 6);
        aVar.f5977k = g4.c.a(getContext(), d7, 19);
        aVar.f5978l = g4.c.a(getContext(), d7, 16);
        aVar.f5982q = d7.getBoolean(5, false);
        aVar.f5984t = d7.getDimensionPixelSize(9, 0);
        aVar.f5983r = d7.getBoolean(21, true);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        int f8 = y.e.f(this);
        int paddingTop = getPaddingTop();
        int e = y.e.e(this);
        int paddingBottom = getPaddingBottom();
        if (d7.hasValue(0)) {
            aVar.f5980o = true;
            setSupportBackgroundTintList(aVar.f5976j);
            setSupportBackgroundTintMode(aVar.f5975i);
        } else {
            aVar.e();
        }
        y.e.k(this, f8 + aVar.f5970c, paddingTop + aVar.e, e + aVar.f5971d, paddingBottom + aVar.f5972f);
        d7.recycle();
        setCompoundDrawablePadding(this.s);
        c(this.f2907n != null ? true : z6);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f7 = 0.0f;
        for (int i7 = 0; i7 < lineCount; i7++) {
            f7 = Math.max(f7, getLayout().getLineWidth(i7));
        }
        return (int) Math.ceil((double) f7);
    }

    public final boolean a() {
        s3.a aVar = this.f2903i;
        return aVar != null && !aVar.f5980o;
    }

    public final void b() {
        int i7 = this.f2914v;
        boolean z6 = false;
        if (i7 == 1 || i7 == 2) {
            k.e(this, this.f2907n, null, null, null);
            return;
        }
        if (i7 == 3 || i7 == 4) {
            k.e(this, null, null, this.f2907n, null);
            return;
        }
        if (i7 == 16 || i7 == 32) {
            z6 = true;
        }
        if (z6) {
            k.e(this, null, this.f2907n, null, null);
        }
    }

    public final void c(boolean z6) {
        Drawable drawable = this.f2907n;
        boolean z7 = true;
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f2907n = mutate;
            a.b.h(mutate, this.m);
            PorterDuff.Mode mode = this.f2906l;
            if (mode != null) {
                a.b.i(this.f2907n, mode);
            }
            int i7 = this.f2909p;
            if (i7 == 0) {
                i7 = this.f2907n.getIntrinsicWidth();
            }
            int i8 = this.f2909p;
            if (i8 == 0) {
                i8 = this.f2907n.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2907n;
            int i9 = this.f2910q;
            int i10 = this.f2911r;
            drawable2.setBounds(i9, i10, i7 + i9, i8 + i10);
            this.f2907n.setVisible(true, z6);
        }
        if (z6) {
            b();
            return;
        }
        Drawable[] a7 = k.a(this);
        Drawable drawable3 = a7[0];
        Drawable drawable4 = a7[1];
        Drawable drawable5 = a7[2];
        int i11 = this.f2914v;
        if (!(i11 == 1 || i11 == 2) || drawable3 == this.f2907n) {
            if (!(i11 == 3 || i11 == 4) || drawable5 == this.f2907n) {
                if (!(i11 == 16 || i11 == 32) || drawable4 == this.f2907n) {
                    z7 = false;
                }
            }
        }
        if (z7) {
            b();
        }
    }

    public final void d(int i7, int i8) {
        if (this.f2907n != null && getLayout() != null) {
            int i9 = this.f2914v;
            boolean z6 = true;
            if (!(i9 == 1 || i9 == 2)) {
                if (!(i9 == 3 || i9 == 4)) {
                    if (!(i9 == 16 || i9 == 32)) {
                        z6 = false;
                    }
                    if (z6) {
                        this.f2910q = 0;
                        if (i9 == 16) {
                            this.f2911r = 0;
                            c(false);
                            return;
                        }
                        int i10 = this.f2909p;
                        if (i10 == 0) {
                            i10 = this.f2907n.getIntrinsicHeight();
                        }
                        int max = Math.max(0, (((((i8 - getTextHeight()) - getPaddingTop()) - i10) - this.s) - getPaddingBottom()) / 2);
                        if (this.f2911r != max) {
                            this.f2911r = max;
                            c(false);
                        }
                        return;
                    }
                    return;
                }
            }
            this.f2911r = 0;
            Layout.Alignment actualTextAlignment = getActualTextAlignment();
            int i11 = this.f2914v;
            if (i11 == 1 || i11 == 3 || ((i11 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i11 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                this.f2910q = 0;
                c(false);
                return;
            }
            int i12 = this.f2909p;
            if (i12 == 0) {
                i12 = this.f2907n.getIntrinsicWidth();
            }
            int textLayoutWidth = i7 - getTextLayoutWidth();
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            int e = (((textLayoutWidth - y.e.e(this)) - i12) - this.s) - y.e.f(this);
            if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
                e /= 2;
            }
            boolean z7 = y.e.d(this) == 1;
            if (this.f2914v != 4) {
                z6 = false;
            }
            if (z7 != z6) {
                e = -e;
            }
            if (this.f2910q != e) {
                this.f2910q = e;
                c(false);
            }
        }
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f2908o)) {
            return this.f2908o;
        }
        s3.a aVar = this.f2903i;
        return (aVar != null && aVar.f5982q ? CompoundButton.class : Button.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f2903i.f5973g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2907n;
    }

    public int getIconGravity() {
        return this.f2914v;
    }

    public int getIconPadding() {
        return this.s;
    }

    public int getIconSize() {
        return this.f2909p;
    }

    public ColorStateList getIconTint() {
        return this.m;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2906l;
    }

    public int getInsetBottom() {
        return this.f2903i.f5972f;
    }

    public int getInsetTop() {
        return this.f2903i.e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f2903i.f5978l;
        }
        return null;
    }

    public i getShapeAppearanceModel() {
        if (a()) {
            return this.f2903i.f5969b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f2903i.f5977k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f2903i.f5974h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f2903i.f5976j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f2903i.f5975i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2912t;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            q2.a.L(this, this.f2903i.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i7) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i7 + 2);
        s3.a aVar = this.f2903i;
        if (aVar != null && aVar.f5982q) {
            View.mergeDrawableStates(onCreateDrawableState, f2901w);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f2902x);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        s3.a aVar = this.f2903i;
        accessibilityNodeInfo.setCheckable(aVar != null && aVar.f5982q);
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        super.onLayout(z6, i7, i8, i9, i10);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f6374f);
        setChecked(cVar.f2915h);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f2915h = this.f2912t;
        return cVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        super.onTextChanged(charSequence, i7, i8, i9);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f2903i.f5983r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f2907n != null) {
            if (this.f2907n.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f2908o = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.b(false) != null) {
                aVar.b(false).setTint(i7);
                return;
            }
            return;
        }
        super.setBackgroundColor(i7);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (a()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                s3.a aVar = this.f2903i;
                aVar.f5980o = true;
                aVar.f5968a.setSupportBackgroundTintList(aVar.f5976j);
                aVar.f5968a.setSupportBackgroundTintMode(aVar.f5975i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i7) {
        setBackgroundDrawable(i7 != 0 ? g.a.a(getContext(), i7) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z6) {
        if (a()) {
            this.f2903i.f5982q = z6;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z6) {
        s3.a aVar = this.f2903i;
        if ((aVar != null && aVar.f5982q) && isEnabled() && this.f2912t != z6) {
            this.f2912t = z6;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
                boolean z7 = this.f2912t;
                if (!materialButtonToggleGroup.f2922k) {
                    materialButtonToggleGroup.b(getId(), z7);
                }
            }
            if (!this.f2913u) {
                this.f2913u = true;
                Iterator<a> it = this.f2904j.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                this.f2913u = false;
            }
        }
    }

    public void setCornerRadius(int i7) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (!aVar.f5981p || aVar.f5973g != i7) {
                aVar.f5973g = i7;
                aVar.f5981p = true;
                i iVar = aVar.f5969b;
                float f7 = (float) i7;
                iVar.getClass();
                i.a aVar2 = new i.a(iVar);
                aVar2.e(f7);
                aVar2.f(f7);
                aVar2.d(f7);
                aVar2.c(f7);
                aVar.c(new i(aVar2));
            }
        }
    }

    public void setCornerRadiusResource(int i7) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i7));
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        if (a()) {
            this.f2903i.b(false).j(f7);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f2907n != drawable) {
            this.f2907n = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i7) {
        if (this.f2914v != i7) {
            this.f2914v = i7;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i7) {
        if (this.s != i7) {
            this.s = i7;
            setCompoundDrawablePadding(i7);
        }
    }

    public void setIconResource(int i7) {
        setIcon(i7 != 0 ? g.a.a(getContext(), i7) : null);
    }

    public void setIconSize(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f2909p != i7) {
            this.f2909p = i7;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2906l != mode) {
            this.f2906l = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i7) {
        setIconTint(g1.a.c(getContext(), i7));
    }

    public void setInsetBottom(int i7) {
        s3.a aVar = this.f2903i;
        aVar.d(aVar.e, i7);
    }

    public void setInsetTop(int i7) {
        s3.a aVar = this.f2903i;
        aVar.d(i7, aVar.f5972f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f2905k = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z6) {
        b bVar = this.f2905k;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z6);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.f5978l != colorStateList) {
                aVar.f5978l = colorStateList;
                if (aVar.f5968a.getBackground() instanceof RippleDrawable) {
                    RippleDrawable rippleDrawable = (RippleDrawable) aVar.f5968a.getBackground();
                    if (colorStateList == null) {
                        colorStateList = ColorStateList.valueOf(0);
                    }
                    rippleDrawable.setColor(colorStateList);
                }
            }
        }
    }

    public void setRippleColorResource(int i7) {
        if (a()) {
            setRippleColor(g1.a.c(getContext(), i7));
        }
    }

    @Override // k4.m
    public void setShapeAppearanceModel(i iVar) {
        if (a()) {
            this.f2903i.c(iVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z6) {
        if (a()) {
            s3.a aVar = this.f2903i;
            aVar.f5979n = z6;
            aVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.f5977k != colorStateList) {
                aVar.f5977k = colorStateList;
                aVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i7) {
        if (a()) {
            setStrokeColor(g1.a.c(getContext(), i7));
        }
    }

    public void setStrokeWidth(int i7) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.f5974h != i7) {
                aVar.f5974h = i7;
                aVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i7) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i7));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.f5976j != colorStateList) {
                aVar.f5976j = colorStateList;
                if (aVar.b(false) != null) {
                    a.b.h(aVar.b(false), aVar.f5976j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (a()) {
            s3.a aVar = this.f2903i;
            if (aVar.f5975i != mode) {
                aVar.f5975i = mode;
                if (aVar.b(false) != null && aVar.f5975i != null) {
                    a.b.i(aVar.b(false), aVar.f5975i);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.view.View
    public void setTextAlignment(int i7) {
        super.setTextAlignment(i7);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z6) {
        this.f2903i.f5983r = z6;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2912t);
    }
}
