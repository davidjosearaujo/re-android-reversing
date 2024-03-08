package androidx.appcompat.widget;

import a0.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.activity.h;
import java.util.WeakHashMap;
import p1.k0;
import p1.y;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class l0 extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public boolean f965f;

    /* renamed from: g  reason: collision with root package name */
    public int f966g;

    /* renamed from: h  reason: collision with root package name */
    public int f967h;

    /* renamed from: i  reason: collision with root package name */
    public int f968i;

    /* renamed from: j  reason: collision with root package name */
    public int f969j;

    /* renamed from: k  reason: collision with root package name */
    public int f970k;

    /* renamed from: l  reason: collision with root package name */
    public float f971l;
    public boolean m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f972n;

    /* renamed from: o  reason: collision with root package name */
    public int[] f973o;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f974p;

    /* renamed from: q  reason: collision with root package name */
    public int f975q;

    /* renamed from: r  reason: collision with root package name */
    public int f976r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public int f977t;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(int i7, int i8) {
            super(i7, i8);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public l0(Context context) {
        this(context, null);
    }

    public l0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l0(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        int resourceId;
        this.f965f = true;
        this.f966g = -1;
        this.f967h = 0;
        this.f969j = 8388659;
        int[] iArr = e.J;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i7, 0);
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.m.d(this, context, iArr, attributeSet, obtainStyledAttributes, i7, 0);
        int i8 = obtainStyledAttributes.getInt(1, -1);
        if (i8 >= 0) {
            setOrientation(i8);
        }
        int i9 = obtainStyledAttributes.getInt(0, -1);
        if (i9 >= 0) {
            setGravity(i9);
        }
        boolean z6 = obtainStyledAttributes.getBoolean(2, true);
        if (!z6) {
            setBaselineAligned(z6);
        }
        this.f971l = obtainStyledAttributes.getFloat(4, -1.0f);
        this.f966g = obtainStyledAttributes.getInt(3, -1);
        this.m = obtainStyledAttributes.getBoolean(7, false);
        setDividerDrawable((!obtainStyledAttributes.hasValue(5) || (resourceId = obtainStyledAttributes.getResourceId(5, 0)) == 0) ? obtainStyledAttributes.getDrawable(5) : g.a.a(context, resourceId));
        this.s = obtainStyledAttributes.getInt(8, 0);
        this.f977t = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final void d(Canvas canvas, int i7) {
        this.f974p.setBounds(getPaddingLeft() + this.f977t, i7, (getWidth() - getPaddingRight()) - this.f977t, this.f976r + i7);
        this.f974p.draw(canvas);
    }

    public final void e(Canvas canvas, int i7) {
        this.f974p.setBounds(i7, getPaddingTop() + this.f977t, this.f975q + i7, (getHeight() - getPaddingBottom()) - this.f977t);
        this.f974p.draw(canvas);
    }

    /* renamed from: f */
    public a generateDefaultLayoutParams() {
        int i7 = this.f968i;
        if (i7 == 0) {
            return new a(-2, -2);
        }
        if (i7 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: g */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i7;
        if (this.f966g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i8 = this.f966g;
        if (childCount > i8) {
            View childAt = getChildAt(i8);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i9 = this.f967h;
                if (this.f968i == 1 && (i7 = this.f969j & 112) != 48) {
                    if (i7 == 16) {
                        i9 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f970k) / 2;
                    } else if (i7 == 80) {
                        i9 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f970k;
                    }
                }
                return i9 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.f966g == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f966g;
    }

    public Drawable getDividerDrawable() {
        return this.f974p;
    }

    public int getDividerPadding() {
        return this.f977t;
    }

    public int getDividerWidth() {
        return this.f975q;
    }

    public int getGravity() {
        return this.f969j;
    }

    public int getOrientation() {
        return this.f968i;
    }

    public int getShowDividers() {
        return this.s;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f971l;
    }

    /* renamed from: h */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public final boolean i(int i7) {
        if (i7 == 0) {
            return (this.s & 1) != 0;
        }
        if (i7 == getChildCount()) {
            return (this.s & 4) != 0;
        }
        if ((this.s & 2) == 0) {
            return false;
        }
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            if (getChildAt(i8).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i7;
        int i8;
        int i9;
        if (this.f974p != null) {
            int i10 = 0;
            if (this.f968i == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i10 < virtualChildCount) {
                    View childAt = getChildAt(i10);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !i(i10))) {
                        d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.f976r);
                    }
                    i10++;
                }
                if (i(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f976r : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a7 = g1.a(this);
            while (i10 < virtualChildCount2) {
                View childAt3 = getChildAt(i10);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !i(i10))) {
                    a aVar = (a) childAt3.getLayoutParams();
                    e(canvas, a7 ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f975q);
                }
                i10++;
            }
            if (i(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    a aVar2 = (a) childAt4.getLayoutParams();
                    if (a7) {
                        i9 = childAt4.getLeft();
                        i8 = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                        i7 = (i9 - i8) - this.f975q;
                        e(canvas, i7);
                    }
                    i7 = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                    e(canvas, i7);
                } else if (a7) {
                    i7 = getPaddingLeft();
                    e(canvas, i7);
                } else {
                    i9 = getWidth();
                    i8 = getPaddingRight();
                    i7 = (i9 - i8) - this.f975q;
                    e(canvas, i7);
                }
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a7  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r26, int r27, int r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x02a8, code lost:
        if (r14 < 0) goto L_0x02aa;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0849  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:420:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r38, int r39) {
        /*
            Method dump skipped, instructions count: 2222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z6) {
        this.f965f = z6;
    }

    public void setBaselineAlignedChildIndex(int i7) {
        if (i7 < 0 || i7 >= getChildCount()) {
            StringBuilder d7 = h.d("base aligned child index out of range (0, ");
            d7.append(getChildCount());
            d7.append(")");
            throw new IllegalArgumentException(d7.toString());
        }
        this.f966g = i7;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f974p) {
            this.f974p = drawable;
            boolean z6 = false;
            if (drawable != null) {
                this.f975q = drawable.getIntrinsicWidth();
                this.f976r = drawable.getIntrinsicHeight();
            } else {
                this.f975q = 0;
                this.f976r = 0;
            }
            if (drawable == null) {
                z6 = true;
            }
            setWillNotDraw(z6);
            requestLayout();
        }
    }

    public void setDividerPadding(int i7) {
        this.f977t = i7;
    }

    public void setGravity(int i7) {
        if (this.f969j != i7) {
            if ((8388615 & i7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            this.f969j = i7;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i7) {
        int i8 = i7 & 8388615;
        int i9 = this.f969j;
        if ((8388615 & i9) != i8) {
            this.f969j = i8 | (-8388616 & i9);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z6) {
        this.m = z6;
    }

    public void setOrientation(int i7) {
        if (this.f968i != i7) {
            this.f968i = i7;
            requestLayout();
        }
    }

    public void setShowDividers(int i7) {
        if (i7 != this.s) {
            requestLayout();
        }
        this.s = i7;
    }

    public void setVerticalGravity(int i7) {
        int i8 = i7 & 112;
        int i9 = this.f969j;
        if ((i9 & 112) != i8) {
            this.f969j = i8 | (i9 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f7) {
        this.f971l = Math.max(0.0f, f7);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
