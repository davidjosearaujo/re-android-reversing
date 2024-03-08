package androidx.appcompat.widget;

import a0.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: f */
    public boolean f660f;

    /* renamed from: g */
    public t0 f661g;

    /* renamed from: h */
    public View f662h;

    /* renamed from: i */
    public View f663i;

    /* renamed from: j */
    public Drawable f664j;

    /* renamed from: k */
    public Drawable f665k;

    /* renamed from: l */
    public Drawable f666l;
    public boolean m;

    /* renamed from: n */
    public boolean f667n;

    /* renamed from: o */
    public int f668o;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.d.q(this, bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f56w);
        boolean z6 = false;
        this.f664j = obtainStyledAttributes.getDrawable(0);
        this.f665k = obtainStyledAttributes.getDrawable(2);
        this.f668o = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == 2131296800) {
            this.m = true;
            this.f666l = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.m ? this.f664j == null && this.f665k == null : this.f666l == null) {
            z6 = true;
        }
        setWillNotDraw(z6);
    }

    public static int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f664j;
        if (drawable != null && drawable.isStateful()) {
            this.f664j.setState(getDrawableState());
        }
        Drawable drawable2 = this.f665k;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f665k.setState(getDrawableState());
        }
        Drawable drawable3 = this.f666l;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f666l.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f661g;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f664j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f665k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f666l;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f662h = findViewById(2131296309);
        this.f663i = findViewById(2131296317);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f660f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        Drawable drawable;
        int i11;
        int i12;
        Drawable drawable2;
        View view;
        int i13;
        super.onLayout(z6, i7, i8, i9, i10);
        t0 t0Var = this.f661g;
        boolean z7 = true;
        z7 = false;
        boolean z8 = (t0Var == null || t0Var.getVisibility() == 8) ? false : true;
        if (!(t0Var == null || t0Var.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i14 = ((FrameLayout.LayoutParams) t0Var.getLayoutParams()).bottomMargin;
            t0Var.layout(i7, (measuredHeight - t0Var.getMeasuredHeight()) - i14, i9, measuredHeight - i14);
        }
        if (this.m) {
            Drawable drawable3 = this.f666l;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        } else {
            if (this.f664j != null) {
                if (this.f662h.getVisibility() == 0) {
                    drawable2 = this.f664j;
                    i12 = this.f662h.getLeft();
                    i11 = this.f662h.getTop();
                    i13 = this.f662h.getRight();
                    view = this.f662h;
                } else {
                    View view2 = this.f663i;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f664j.setBounds(0, 0, 0, 0);
                        z7 = true;
                    } else {
                        drawable2 = this.f664j;
                        i12 = this.f663i.getLeft();
                        i11 = this.f663i.getTop();
                        i13 = this.f663i.getRight();
                        view = this.f663i;
                    }
                }
                drawable2.setBounds(i12, i11, i13, view.getBottom());
                z7 = true;
            }
            this.f667n = z8;
            if (z8 && (drawable = this.f665k) != null) {
                drawable.setBounds(t0Var.getLeft(), t0Var.getTop(), t0Var.getRight(), t0Var.getBottom());
            }
        }
        if (z7) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.view.View r0 = r6.f662h
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L_0x001c
            int r0 = android.view.View.MeasureSpec.getMode(r8)
            if (r0 != r1) goto L_0x001c
            int r0 = r6.f668o
            if (r0 < 0) goto L_0x001c
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            int r8 = java.lang.Math.min(r0, r8)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
        L_0x001c:
            super.onMeasure(r7, r8)
            android.view.View r7 = r6.f662h
            if (r7 != 0) goto L_0x0024
            return
        L_0x0024:
            int r7 = android.view.View.MeasureSpec.getMode(r8)
            androidx.appcompat.widget.t0 r0 = r6.f661g
            if (r0 == 0) goto L_0x0089
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x0089
            r0 = 1073741824(0x40000000, float:2.0)
            if (r7 == r0) goto L_0x0089
            android.view.View r0 = r6.f662h
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x004d
            int r5 = r0.getVisibility()
            if (r5 == r2) goto L_0x004d
            int r0 = r0.getMeasuredHeight()
            if (r0 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r0 = r4
            goto L_0x004e
        L_0x004d:
            r0 = r3
        L_0x004e:
            if (r0 != 0) goto L_0x0053
            android.view.View r0 = r6.f662h
            goto L_0x0069
        L_0x0053:
            android.view.View r0 = r6.f663i
            if (r0 == 0) goto L_0x0065
            int r5 = r0.getVisibility()
            if (r5 == r2) goto L_0x0065
            int r0 = r0.getMeasuredHeight()
            if (r0 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r3 = r4
        L_0x0065:
            if (r3 != 0) goto L_0x006d
            android.view.View r0 = r6.f663i
        L_0x0069:
            int r4 = a(r0)
        L_0x006d:
            if (r7 != r1) goto L_0x0074
            int r7 = android.view.View.MeasureSpec.getSize(r8)
            goto L_0x0077
        L_0x0074:
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x0077:
            int r8 = r6.getMeasuredWidth()
            androidx.appcompat.widget.t0 r0 = r6.f661g
            int r0 = a(r0)
            int r0 = r0 + r4
            int r7 = java.lang.Math.min(r0, r7)
            r6.setMeasuredDimension(r8, r7)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f664j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f664j);
        }
        this.f664j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f662h;
            if (view != null) {
                this.f664j.setBounds(view.getLeft(), this.f662h.getTop(), this.f662h.getRight(), this.f662h.getBottom());
            }
        }
        boolean z6 = true;
        z6 = false;
        if (!this.m ? !(this.f664j == null && this.f665k == null) : this.f666l != null) {
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f666l;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f666l);
        }
        this.f666l = drawable;
        boolean z6 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.m && (drawable2 = this.f666l) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        z6 = true;
        if (!this.m ? this.f664j == null && this.f665k == null : this.f666l == null) {
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f665k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f665k);
        }
        this.f665k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f667n && (drawable2 = this.f665k) != null) {
                drawable2.setBounds(this.f661g.getLeft(), this.f661g.getTop(), this.f661g.getRight(), this.f661g.getBottom());
            }
        }
        boolean z6 = true;
        z6 = false;
        if (!this.m ? !(this.f664j == null && this.f665k == null) : this.f666l != null) {
        }
        setWillNotDraw(z6);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(t0 t0Var) {
        t0 t0Var2 = this.f661g;
        if (t0Var2 != null) {
            removeView(t0Var2);
        }
        this.f661g = t0Var;
        if (t0Var != null) {
            addView(t0Var);
            ViewGroup.LayoutParams layoutParams = t0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            t0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z6) {
        this.f660f = z6;
        setDescendantFocusability(z6 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        boolean z6 = i7 == 0;
        Drawable drawable = this.f664j;
        if (drawable != null) {
            drawable.setVisible(z6, false);
        }
        Drawable drawable2 = this.f665k;
        if (drawable2 != null) {
            drawable2.setVisible(z6, false);
        }
        Drawable drawable3 = this.f666l;
        if (drawable3 != null) {
            drawable3.setVisible(z6, false);
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i7) {
        if (i7 != 0) {
            return super.startActionModeForChild(view, callback, i7);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f664j && !this.m) || (drawable == this.f665k && this.f667n) || ((drawable == this.f666l && this.m) || super.verifyDrawable(drawable));
    }
}