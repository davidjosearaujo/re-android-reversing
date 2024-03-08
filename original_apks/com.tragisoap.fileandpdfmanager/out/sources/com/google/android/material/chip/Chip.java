package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.result.c;
import androidx.appcompat.widget.f;
import com.google.android.material.chip.a;
import d4.h;
import d4.l;
import g4.d;
import j1.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k4.i;
import k4.m;
import linc.com.amplituda.ErrorCode;
import n3.g;
import p1.k0;
import p1.y;
import q1.f;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class Chip extends f implements a.AbstractC0033a, m {
    public static final Rect B = new Rect();
    public static final int[] C = {16842913};
    public static final int[] D = {16842911};

    /* renamed from: j */
    public a f2991j;

    /* renamed from: k */
    public InsetDrawable f2992k;

    /* renamed from: l */
    public RippleDrawable f2993l;
    public View.OnClickListener m;

    /* renamed from: n */
    public CompoundButton.OnCheckedChangeListener f2994n;

    /* renamed from: o */
    public boolean f2995o;

    /* renamed from: p */
    public boolean f2996p;

    /* renamed from: q */
    public boolean f2997q;

    /* renamed from: r */
    public boolean f2998r;
    public boolean s;

    /* renamed from: t */
    public int f2999t;

    /* renamed from: u */
    public int f3000u;

    /* renamed from: v */
    public CharSequence f3001v;

    /* renamed from: w */
    public final b f3002w;

    /* renamed from: x */
    public boolean f3003x;

    /* renamed from: y */
    public final Rect f3004y = new Rect();

    /* renamed from: z */
    public final RectF f3005z = new RectF();
    public final a A = new a();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends c {
        public a() {
            Chip.this = r1;
        }

        @Override // androidx.activity.result.c
        public final void l(int i7) {
        }

        @Override // androidx.activity.result.c
        public final void m(Typeface typeface, boolean z6) {
            Chip chip = Chip.this;
            a aVar = chip.f2991j;
            chip.setText(aVar.K0 ? aVar.L : chip.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b extends x1.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Chip chip) {
            super(chip);
            Chip.this = r1;
        }

        @Override // x1.a
        public final void l(ArrayList arrayList) {
            boolean z6 = false;
            arrayList.add(0);
            Chip chip = Chip.this;
            Rect rect = Chip.B;
            if (chip.d()) {
                Chip chip2 = Chip.this;
                a aVar = chip2.f2991j;
                if (aVar != null && aVar.R) {
                    z6 = true;
                }
                if (z6 && chip2.m != null) {
                    arrayList.add(1);
                }
            }
        }

        @Override // x1.a
        public final void o(int i7, q1.f fVar) {
            CharSequence charSequence = "";
            if (i7 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    closeIconContentDescription = context.getString(2131820665, objArr).trim();
                }
                fVar.k(closeIconContentDescription);
                fVar.f5624a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                fVar.b(f.a.e);
                fVar.f5624a.setEnabled(Chip.this.isEnabled());
                return;
            }
            fVar.k(charSequence);
            fVar.f5624a.setBoundsInParent(Chip.B);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0287  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r18, android.util.AttributeSet r19) {
        /*
            Method dump skipped, instructions count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private RectF getCloseIconTouchBounds() {
        this.f3005z.setEmpty();
        if (d() && this.m != null) {
            a aVar = this.f2991j;
            RectF rectF = this.f3005z;
            Rect bounds = aVar.getBounds();
            rectF.setEmpty();
            if (aVar.U()) {
                float f7 = aVar.f3018k0 + aVar.f3017j0 + aVar.V + aVar.f3016i0 + aVar.f3015h0;
                if (a.c.a(aVar) == 0) {
                    float f8 = (float) bounds.right;
                    rectF.right = f8;
                    rectF.left = f8 - f7;
                } else {
                    float f9 = (float) bounds.left;
                    rectF.left = f9;
                    rectF.right = f9 + f7;
                }
                rectF.top = (float) bounds.top;
                rectF.bottom = (float) bounds.bottom;
            }
        }
        return this.f3005z;
    }

    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f3004y.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f3004y;
    }

    private d getTextAppearance() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3025r0.f3628f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z6) {
        if (this.f2997q != z6) {
            this.f2997q = z6;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z6) {
        if (this.f2996p != z6) {
            this.f2996p = z6;
            refreshDrawableState();
        }
    }

    @Override // com.google.android.material.chip.a.AbstractC0033a
    public final void a() {
        c(this.f3000u);
        requestLayout();
        invalidateOutline();
    }

    public final void c(int i7) {
        this.f3000u = i7;
        int i8 = 0;
        if (!this.s) {
            InsetDrawable insetDrawable = this.f2992k;
            if (insetDrawable == null) {
                f();
            } else if (insetDrawable != null) {
                this.f2992k = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                f();
            }
        } else {
            int max = Math.max(0, i7 - ((int) this.f2991j.G));
            int max2 = Math.max(0, i7 - this.f2991j.getIntrinsicWidth());
            if (max2 > 0 || max > 0) {
                int i9 = max2 > 0 ? max2 / 2 : 0;
                if (max > 0) {
                    i8 = max / 2;
                }
                if (this.f2992k != null) {
                    Rect rect = new Rect();
                    this.f2992k.getPadding(rect);
                    if (rect.top == i8 && rect.bottom == i8 && rect.left == i9 && rect.right == i9) {
                        f();
                        return;
                    }
                }
                if (getMinHeight() != i7) {
                    setMinHeight(i7);
                }
                if (getMinWidth() != i7) {
                    setMinWidth(i7);
                }
                this.f2992k = new InsetDrawable((Drawable) this.f2991j, i9, i8, i9, i8);
                f();
                return;
            }
            InsetDrawable insetDrawable2 = this.f2992k;
            if (insetDrawable2 == null) {
                f();
            } else if (insetDrawable2 != null) {
                this.f2992k = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                f();
            }
        }
    }

    public final boolean d() {
        a aVar = this.f2991j;
        if (aVar != null) {
            Drawable drawable = aVar.S;
            if (drawable == null) {
                drawable = null;
            } else if (drawable instanceof j1.b) {
                drawable = ((j1.b) drawable).b();
            }
            if (drawable != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x0072;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f3003x
            if (r0 != 0) goto L_0x0009
            boolean r9 = super.dispatchHoverEvent(r10)
            return r9
        L_0x0009:
            com.google.android.material.chip.Chip$b r0 = r9.f3002w
            android.view.accessibility.AccessibilityManager r1 = r0.f6432h
            boolean r1 = r1.isEnabled()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0074
            android.view.accessibility.AccessibilityManager r1 = r0.f6432h
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L_0x001e
            goto L_0x0074
        L_0x001e:
            int r1 = r10.getAction()
            r4 = 7
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 256(0x100, float:3.59E-43)
            r7 = 128(0x80, float:1.794E-43)
            if (r1 == r4) goto L_0x0044
            r4 = 9
            if (r1 == r4) goto L_0x0044
            r4 = 10
            if (r1 == r4) goto L_0x0034
            goto L_0x0074
        L_0x0034:
            int r1 = r0.m
            if (r1 == r5) goto L_0x0074
            if (r1 != r5) goto L_0x003b
            goto L_0x0072
        L_0x003b:
            r0.m = r5
            r0.q(r5, r7)
            r0.q(r1, r6)
            goto L_0x0072
        L_0x0044:
            float r1 = r10.getX()
            float r4 = r10.getY()
            com.google.android.material.chip.Chip r8 = com.google.android.material.chip.Chip.this
            boolean r8 = r8.d()
            if (r8 == 0) goto L_0x0062
            com.google.android.material.chip.Chip r8 = com.google.android.material.chip.Chip.this
            android.graphics.RectF r8 = r8.getCloseIconTouchBounds()
            boolean r1 = r8.contains(r1, r4)
            if (r1 == 0) goto L_0x0062
            r1 = r2
            goto L_0x0063
        L_0x0062:
            r1 = r3
        L_0x0063:
            int r4 = r0.m
            if (r4 != r1) goto L_0x0068
            goto L_0x0070
        L_0x0068:
            r0.m = r1
            r0.q(r1, r7)
            r0.q(r4, r6)
        L_0x0070:
            if (r1 == r5) goto L_0x0074
        L_0x0072:
            r0 = r2
            goto L_0x0075
        L_0x0074:
            r0 = r3
        L_0x0075:
            if (r0 != 0) goto L_0x007f
            boolean r9 = super.dispatchHoverEvent(r10)
            if (r9 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r2 = r3
        L_0x007f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f3003x) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b bVar = this.f3002w;
        bVar.getClass();
        boolean z6 = false;
        int i7 = 0;
        z6 = false;
        z6 = false;
        z6 = false;
        z6 = false;
        z6 = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i8 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case ErrorCode.FILE_OPEN_IO_CODE /* 20 */:
                        case ErrorCode.FILE_NOT_FOUND_IO_CODE /* 21 */:
                        case ErrorCode.INVALID_RAW_RESOURCE_IO_CODE /* 22 */:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i8 = 33;
                                } else if (keyCode == 21) {
                                    i8 = 17;
                                } else if (keyCode != 22) {
                                    i8 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                z6 = false;
                                while (i7 < repeatCount && bVar.m(i8, null)) {
                                    i7++;
                                    z6 = true;
                                }
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i9 = bVar.f6436l;
                    if (i9 != Integer.MIN_VALUE) {
                        if (i9 == 0) {
                            Chip.this.performClick();
                        } else if (i9 == 1) {
                            Chip chip = Chip.this;
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.m;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.f3003x) {
                                chip.f3002w.q(1, 1);
                            }
                        }
                    }
                    z6 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z6 = bVar.m(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z6 = bVar.m(1, null);
            }
        }
        if (!z6 || this.f3002w.f6436l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // androidx.appcompat.widget.f, android.widget.TextView, android.widget.CompoundButton, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r5 = this;
            super.drawableStateChanged()
            com.google.android.material.chip.a r0 = r5.f2991j
            r1 = 0
            if (r0 == 0) goto L_0x0085
            android.graphics.drawable.Drawable r0 = r0.S
            boolean r0 = com.google.android.material.chip.a.u(r0)
            if (r0 == 0) goto L_0x0085
            com.google.android.material.chip.a r0 = r5.f2991j
            boolean r2 = r5.isEnabled()
            boolean r3 = r5.f2998r
            if (r3 == 0) goto L_0x001c
            int r2 = r2 + 1
        L_0x001c:
            boolean r3 = r5.f2997q
            if (r3 == 0) goto L_0x0022
            int r2 = r2 + 1
        L_0x0022:
            boolean r3 = r5.f2996p
            if (r3 == 0) goto L_0x0028
            int r2 = r2 + 1
        L_0x0028:
            boolean r3 = r5.isChecked()
            if (r3 == 0) goto L_0x0030
            int r2 = r2 + 1
        L_0x0030:
            int[] r2 = new int[r2]
            boolean r3 = r5.isEnabled()
            if (r3 == 0) goto L_0x003f
            r3 = 16842910(0x101009e, float:2.3694E-38)
            r2[r1] = r3
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = r1
        L_0x0040:
            boolean r4 = r5.f2998r
            if (r4 == 0) goto L_0x004b
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            r2[r3] = r4
            int r3 = r3 + 1
        L_0x004b:
            boolean r4 = r5.f2997q
            if (r4 == 0) goto L_0x0056
            r4 = 16843623(0x1010367, float:2.3696E-38)
            r2[r3] = r4
            int r3 = r3 + 1
        L_0x0056:
            boolean r4 = r5.f2996p
            if (r4 == 0) goto L_0x0061
            r4 = 16842919(0x10100a7, float:2.3694026E-38)
            r2[r3] = r4
            int r3 = r3 + 1
        L_0x0061:
            boolean r4 = r5.isChecked()
            if (r4 == 0) goto L_0x006c
            r4 = 16842913(0x10100a1, float:2.369401E-38)
            r2[r3] = r4
        L_0x006c:
            int[] r3 = r0.F0
            boolean r3 = java.util.Arrays.equals(r3, r2)
            if (r3 != 0) goto L_0x0085
            r0.F0 = r2
            boolean r3 = r0.U()
            if (r3 == 0) goto L_0x0085
            int[] r1 = r0.getState()
            boolean r0 = r0.w(r1, r2)
            r1 = r0
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r5.invalidate()
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.drawableStateChanged():void");
    }

    public final void e() {
        boolean z6 = true;
        if (d()) {
            a aVar = this.f2991j;
            if ((aVar != null && aVar.R) && this.m != null) {
                y.i(this, this.f3002w);
                this.f3003x = z6;
            }
        }
        y.i(this, null);
        z6 = false;
        this.f3003x = z6;
    }

    public final void f() {
        ColorStateList colorStateList = this.f2991j.K;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2993l = new RippleDrawable(colorStateList, getBackgroundDrawable(), null);
        a aVar = this.f2991j;
        if (aVar.G0) {
            aVar.G0 = false;
            aVar.H0 = null;
            aVar.onStateChange(aVar.getState());
        }
        RippleDrawable rippleDrawable = this.f2993l;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(this, rippleDrawable);
        g();
    }

    public final void g() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f2991j) != null) {
            int r6 = (int) (aVar.r() + aVar.f3018k0 + aVar.f3015h0);
            a aVar2 = this.f2991j;
            int q6 = (int) (aVar2.q() + aVar2.f3011d0 + aVar2.f3014g0);
            if (this.f2992k != null) {
                Rect rect = new Rect();
                this.f2992k.getPadding(rect);
                q6 += rect.left;
                r6 += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.e.k(this, q6, paddingTop, r6, paddingBottom);
        }
    }

    @Override // android.widget.CheckBox, android.widget.TextView, android.widget.CompoundButton, android.widget.Button, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f3001v)) {
            return this.f3001v;
        }
        a aVar = this.f2991j;
        if (!(aVar != null && aVar.X)) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        if (!(parent instanceof v3.c)) {
            return "android.widget.Button";
        }
        ((v3.c) parent).getClass();
        throw null;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2992k;
        return insetDrawable == null ? this.f2991j : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.Z;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3008a0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.F;
        }
        return null;
    }

    public float getChipCornerRadius() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return Math.max(0.0f, aVar.s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2991j;
    }

    public float getChipEndPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3018k0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        a aVar = this.f2991j;
        if (aVar == null || (drawable = aVar.N) == null) {
            return null;
        }
        if (drawable instanceof j1.b) {
            drawable = ((j1.b) drawable).b();
        }
        return drawable;
    }

    public float getChipIconSize() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.P;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.O;
        }
        return null;
    }

    public float getChipMinHeight() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.G;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3011d0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.I;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.J;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        a aVar = this.f2991j;
        if (aVar == null || (drawable = aVar.S) == null) {
            return null;
        }
        if (drawable instanceof j1.b) {
            drawable = ((j1.b) drawable).b();
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.W;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3017j0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.V;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3016i0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.U;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.J0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f3003x) {
            b bVar = this.f3002w;
            if (bVar.f6436l == 1 || bVar.f6435k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public g getHideMotionSpec() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3010c0;
        }
        return null;
    }

    public float getIconEndPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3013f0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3012e0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.K;
        }
        return null;
    }

    public i getShapeAppearanceModel() {
        return this.f2991j.f4720f.f4740a;
    }

    public g getShowMotionSpec() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3009b0;
        }
        return null;
    }

    public float getTextEndPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3015h0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        a aVar = this.f2991j;
        if (aVar != null) {
            return aVar.f3014g0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        a aVar = this.f2991j;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.A);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q2.a.L(this, this.f2991j);
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public final int[] onCreateDrawableState(int i7) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i7 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, C);
        }
        a aVar = this.f2991j;
        if (aVar != null && aVar.X) {
            View.mergeDrawableStates(onCreateDrawableState, D);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z6, int i7, Rect rect) {
        super.onFocusChanged(z6, i7, rect);
        if (this.f3003x) {
            b bVar = this.f3002w;
            int i8 = bVar.f6436l;
            if (i8 != Integer.MIN_VALUE) {
                bVar.j(i8);
            }
            if (z6) {
                bVar.m(i7, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                z6 = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        z6 = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(z6);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i7;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        a aVar = this.f2991j;
        accessibilityNodeInfo.setCheckable(aVar != null && aVar.X);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof v3.c) {
            v3.c cVar = (v3.c) getParent();
            int i8 = -1;
            if (cVar.f3601h) {
                i7 = 0;
                for (int i9 = 0; i9 < cVar.getChildCount(); i9++) {
                    View childAt = cVar.getChildAt(i9);
                    if (childAt instanceof Chip) {
                        if (!(cVar.getChildAt(i9).getVisibility() == 0)) {
                            continue;
                        } else if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
            }
            i7 = -1;
            Object tag = getTag(2131296754);
            if (tag instanceof Integer) {
                i8 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) f.g.a(i8, 1, i7, 1, isChecked()).f5638a);
        }
    }

    @Override // android.widget.TextView, android.widget.Button, android.view.View
    @TargetApi(ErrorCode.INVALID_AUDIO_URL_IO_CODE)
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i7) {
        return (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) ? super.onResolvePointerIcon(motionEvent, i7) : PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public final void onRtlPropertiesChanged(int i7) {
        super.onRtlPropertiesChanged(i7);
        if (this.f2999t != i7) {
            this.f2999t = i7;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L_0x0050;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0049
            if (r0 == r2) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0044
            goto L_0x0050
        L_0x0021:
            boolean r0 = r5.f2996p
            if (r0 == 0) goto L_0x0050
            if (r1 != 0) goto L_0x004e
            r5.setCloseIconPressed(r3)
            goto L_0x004e
        L_0x002b:
            boolean r0 = r5.f2996p
            if (r0 == 0) goto L_0x0044
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.m
            if (r0 == 0) goto L_0x0039
            r0.onClick(r5)
        L_0x0039:
            boolean r0 = r5.f3003x
            if (r0 == 0) goto L_0x0042
            com.google.android.material.chip.Chip$b r0 = r5.f3002w
            r0.q(r2, r2)
        L_0x0042:
            r0 = r2
            goto L_0x0045
        L_0x0044:
            r0 = r3
        L_0x0045:
            r5.setCloseIconPressed(r3)
            goto L_0x0051
        L_0x0049:
            if (r1 == 0) goto L_0x0050
            r5.setCloseIconPressed(r2)
        L_0x004e:
            r0 = r2
            goto L_0x0051
        L_0x0050:
            r0 = r3
        L_0x0051:
            if (r0 != 0) goto L_0x005b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = r3
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f3001v = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2993l) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i7) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2993l) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i7) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z6) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.x(z6);
        }
    }

    public void setCheckableResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.x(aVar.f3019l0.getResources().getBoolean(i7));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z6) {
        a aVar = this.f2991j;
        if (aVar == null) {
            this.f2995o = z6;
        } else if (aVar.X) {
            super.setChecked(z6);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z6) {
        setCheckedIconVisible(z6);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i7) {
        setCheckedIconVisible(i7);
    }

    public void setCheckedIconResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.y(g.a.a(aVar.f3019l0, i7));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.z(g1.a.c(aVar.f3019l0, i7));
        }
    }

    public void setCheckedIconVisible(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.A(aVar.f3019l0.getResources().getBoolean(i7));
        }
    }

    public void setCheckedIconVisible(boolean z6) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.A(z6);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.F != colorStateList) {
            aVar.F = colorStateList;
            aVar.onStateChange(aVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i7) {
        ColorStateList c7;
        a aVar = this.f2991j;
        if (aVar != null && aVar.F != (c7 = g1.a.c(aVar.f3019l0, i7))) {
            aVar.F = c7;
            aVar.onStateChange(aVar.getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.B(f7);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.B(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setChipDrawable(a aVar) {
        a aVar2 = this.f2991j;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.I0 = new WeakReference<>(null);
            }
            this.f2991j = aVar;
            aVar.K0 = false;
            aVar.I0 = new WeakReference<>(this);
            c(this.f3000u);
        }
    }

    public void setChipEndPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.f3018k0 != f7) {
            aVar.f3018k0 = f7;
            aVar.invalidateSelf();
            aVar.v();
        }
    }

    public void setChipEndPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            float dimension = aVar.f3019l0.getResources().getDimension(i7);
            if (aVar.f3018k0 != dimension) {
                aVar.f3018k0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z6) {
        setChipIconVisible(z6);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i7) {
        setChipIconVisible(i7);
    }

    public void setChipIconResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.C(g.a.a(aVar.f3019l0, i7));
        }
    }

    public void setChipIconSize(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.D(f7);
        }
    }

    public void setChipIconSizeResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.D(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.E(g1.a.c(aVar.f3019l0, i7));
        }
    }

    public void setChipIconVisible(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.F(aVar.f3019l0.getResources().getBoolean(i7));
        }
    }

    public void setChipIconVisible(boolean z6) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.F(z6);
        }
    }

    public void setChipMinHeight(float f7) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.G != f7) {
            aVar.G = f7;
            aVar.invalidateSelf();
            aVar.v();
        }
    }

    public void setChipMinHeightResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            float dimension = aVar.f3019l0.getResources().getDimension(i7);
            if (aVar.G != dimension) {
                aVar.G = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipStartPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.f3011d0 != f7) {
            aVar.f3011d0 = f7;
            aVar.invalidateSelf();
            aVar.v();
        }
    }

    public void setChipStartPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            float dimension = aVar.f3019l0.getResources().getDimension(i7);
            if (aVar.f3011d0 != dimension) {
                aVar.f3011d0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.G(g1.a.c(aVar.f3019l0, i7));
        }
    }

    public void setChipStrokeWidth(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.H(f7);
        }
    }

    public void setChipStrokeWidthResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.H(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i7) {
        setText(getResources().getString(i7));
    }

    public void setCloseIcon(Drawable drawable) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.I(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.W != charSequence) {
            n1.a c7 = n1.a.c();
            aVar.W = c7.d(charSequence, c7.f5113c);
            aVar.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z6) {
        setCloseIconVisible(z6);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i7) {
        setCloseIconVisible(i7);
    }

    public void setCloseIconEndPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.J(f7);
        }
    }

    public void setCloseIconEndPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.J(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setCloseIconResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.I(g.a.a(aVar.f3019l0, i7));
        }
        e();
    }

    public void setCloseIconSize(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.K(f7);
        }
    }

    public void setCloseIconSizeResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.K(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setCloseIconStartPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.L(f7);
        }
    }

    public void setCloseIconStartPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.L(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.M(g1.a.c(aVar.f3019l0, i7));
        }
    }

    public void setCloseIconVisible(int i7) {
        setCloseIconVisible(getResources().getBoolean(i7));
    }

    public void setCloseIconVisible(boolean z6) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.N(z6);
        }
        e();
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // androidx.appcompat.widget.f, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i9 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i7, i8, i9, i10);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i7, int i8, int i9, int i10) {
        if (i7 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i9 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i7, i8, i9, i10);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f7) {
        super.setElevation(f7);
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.j(f7);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2991j != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                a aVar = this.f2991j;
                if (aVar != null) {
                    aVar.J0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z6) {
        this.s = z6;
        c(this.f3000u);
    }

    @Override // android.widget.TextView
    public void setGravity(int i7) {
        if (i7 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i7);
        }
    }

    public void setHideMotionSpec(g gVar) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.f3010c0 = gVar;
        }
    }

    public void setHideMotionSpecResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.f3010c0 = g.a(aVar.f3019l0, i7);
        }
    }

    public void setIconEndPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.O(f7);
        }
    }

    public void setIconEndPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.O(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setIconStartPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.P(f7);
        }
    }

    public void setIconStartPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.P(aVar.f3019l0.getResources().getDimension(i7));
        }
    }

    public void setInternalOnCheckedChangeListener(h<Chip> hVar) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i7) {
        if (this.f2991j != null) {
            super.setLayoutDirection(i7);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i7) {
        if (i7 <= 1) {
            super.setLines(i7);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i7) {
        if (i7 <= 1) {
            super.setMaxLines(i7);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i7) {
        super.setMaxWidth(i7);
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.L0 = i7;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i7) {
        if (i7 <= 1) {
            super.setMinLines(i7);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2994n = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.Q(colorStateList);
        }
        if (!this.f2991j.G0) {
            f();
        }
    }

    public void setRippleColorResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.Q(g1.a.c(aVar.f3019l0, i7));
            if (!this.f2991j.G0) {
                f();
            }
        }
    }

    @Override // k4.m
    public void setShapeAppearanceModel(i iVar) {
        this.f2991j.setShapeAppearanceModel(iVar);
    }

    public void setShowMotionSpec(g gVar) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.f3009b0 = gVar;
        }
    }

    public void setShowMotionSpecResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.f3009b0 = g.a(aVar.f3019l0, i7);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z6) {
        if (z6) {
            super.setSingleLine(z6);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        a aVar = this.f2991j;
        if (aVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(aVar.K0 ? null : charSequence, bufferType);
            a aVar2 = this.f2991j;
            if (aVar2 != null && !TextUtils.equals(aVar2.L, charSequence)) {
                aVar2.L = charSequence;
                aVar2.f3025r0.f3627d = true;
                aVar2.invalidateSelf();
                aVar2.v();
            }
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i7) {
        super.setTextAppearance(i7);
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.R(new d(aVar.f3019l0, i7));
        }
        h();
    }

    public void setTextAppearance(d dVar) {
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.R(dVar);
        }
        h();
    }

    public void setTextAppearanceResource(int i7) {
        setTextAppearance(getContext(), i7);
    }

    public void setTextEndPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.f3015h0 != f7) {
            aVar.f3015h0 = f7;
            aVar.invalidateSelf();
            aVar.v();
        }
    }

    public void setTextEndPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            float dimension = aVar.f3019l0.getResources().getDimension(i7);
            if (aVar.f3015h0 != dimension) {
                aVar.f3015h0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i7, float f7) {
        super.setTextSize(i7, f7);
        a aVar = this.f2991j;
        if (aVar != null) {
            float applyDimension = TypedValue.applyDimension(i7, f7, getResources().getDisplayMetrics());
            l lVar = aVar.f3025r0;
            d dVar = lVar.f3628f;
            if (dVar != null) {
                dVar.f4258k = applyDimension;
                lVar.f3624a.setTextSize(applyDimension);
                aVar.a();
            }
        }
        h();
    }

    public void setTextStartPadding(float f7) {
        a aVar = this.f2991j;
        if (aVar != null && aVar.f3014g0 != f7) {
            aVar.f3014g0 = f7;
            aVar.invalidateSelf();
            aVar.v();
        }
    }

    public void setTextStartPaddingResource(int i7) {
        a aVar = this.f2991j;
        if (aVar != null) {
            float dimension = aVar.f3019l0.getResources().getDimension(i7);
            if (aVar.f3014g0 != dimension) {
                aVar.f3014g0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i7) {
        super.setTextAppearance(context, i7);
        a aVar = this.f2991j;
        if (aVar != null) {
            aVar.R(new d(aVar.f3019l0, i7));
        }
        h();
    }
}