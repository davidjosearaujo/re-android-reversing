package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p1.k;
import p1.k0;
import p1.l;
import p1.n;
import p1.o;
import p1.y;
import q1.f;
import q1.h;
import t1.d;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class NestedScrollView extends FrameLayout implements n, k {
    public static final float F = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final a G = new a();
    public static final int[] H = {16843130};
    public int A;
    public d B;
    public final o C;
    public final l D;
    public float E;

    /* renamed from: f */
    public final float f1481f;

    /* renamed from: g */
    public long f1482g;

    /* renamed from: i */
    public OverScroller f1484i;

    /* renamed from: j */
    public EdgeEffect f1485j;

    /* renamed from: k */
    public EdgeEffect f1486k;

    /* renamed from: l */
    public int f1487l;

    /* renamed from: q */
    public VelocityTracker f1491q;

    /* renamed from: r */
    public boolean f1492r;

    /* renamed from: t */
    public int f1493t;

    /* renamed from: u */
    public int f1494u;

    /* renamed from: v */
    public int f1495v;

    /* renamed from: z */
    public int f1499z;

    /* renamed from: h */
    public final Rect f1483h = new Rect();
    public boolean m = true;

    /* renamed from: n */
    public boolean f1488n = false;

    /* renamed from: o */
    public View f1489o = null;

    /* renamed from: p */
    public boolean f1490p = false;
    public boolean s = true;

    /* renamed from: w */
    public int f1496w = -1;

    /* renamed from: x */
    public final int[] f1497x = new int[2];

    /* renamed from: y */
    public final int[] f1498y = new int[2];

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class a extends p1.a {
        @Override // p1.a
        public final void c(View view, AccessibilityEvent accessibilityEvent) {
            super.c(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            h.c(accessibilityEvent, nestedScrollView.getScrollX());
            h.d(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // p1.a
        public final void d(View view, f fVar) {
            int scrollRange;
            this.f5466a.onInitializeAccessibilityNodeInfo(view, fVar.f5624a);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            fVar.h(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                fVar.f5624a.setScrollable(true);
                if (nestedScrollView.getScrollY() > 0) {
                    fVar.b(f.a.f5628g);
                    fVar.b(f.a.f5632k);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    fVar.b(f.a.f5627f);
                    fVar.b(f.a.f5633l);
                }
            }
        }

        @Override // p1.a
        public final boolean g(View view, int i7, Bundle bundle) {
            if (super.g(view, i7, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i7 != 4096) {
                if (i7 == 8192 || i7 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.v(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), true);
                    return true;
                } else if (i7 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.v(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), true);
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class b {
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface c {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: f */
        public int f1500f;

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
            this.f1500f = parcel.readInt();
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public final String toString() {
            StringBuilder d7 = androidx.activity.h.d("HorizontalScrollView.SavedState{");
            d7.append(Integer.toHexString(System.identityHashCode(this)));
            d7.append(" scrollPosition=");
            d7.append(this.f1500f);
            d7.append("}");
            return d7.toString();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public final void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeInt(this.f1500f);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130903916);
        int i7 = Build.VERSION.SDK_INT;
        this.f1485j = i7 >= 31 ? d.b.a(context, attributeSet) : new EdgeEffect(context);
        this.f1486k = i7 >= 31 ? d.b.a(context, attributeSet) : new EdgeEffect(context);
        this.f1481f = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1484i = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1493t = viewConfiguration.getScaledTouchSlop();
        this.f1494u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1495v = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H, 2130903916, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.C = new o();
        this.D = new l(this);
        setNestedScrollingEnabled(true);
        y.i(this, G);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.E == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.E = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.E;
    }

    public static boolean h(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && h((View) parent, view2);
    }

    @Override // p1.m
    public final void a(View view, View view2, int i7, int i8) {
        o oVar = this.C;
        if (i8 == 1) {
            oVar.f5501b = i7;
        } else {
            oVar.f5500a = i7;
        }
        w(2, i8);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7) {
        if (getChildCount() <= 0) {
            super.addView(view, i7);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i7, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final boolean b(int i7) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i7);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !k(findNextFocus, maxScrollAmount, getHeight())) {
            if (i7 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i7 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i7 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            t(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.f1483h);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1483h);
            t(c(this.f1483h), 0, 1, true);
            findNextFocus.requestFocus(i7);
        }
        if (findFocus != null && findFocus.isFocused() && (!k(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final int c(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i8 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i7 - verticalFadingEdgeLength : i7;
        int i9 = rect.bottom;
        if (i9 > i8 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i8) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i7);
        } else if (rect.top >= scrollY || i9 >= i8) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i8 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public final void computeScroll() {
        EdgeEffect edgeEffect;
        int i7;
        EdgeEffect edgeEffect2;
        if (!this.f1484i.isFinished()) {
            this.f1484i.computeScrollOffset();
            int currY = this.f1484i.getCurrY();
            int i8 = currY - this.A;
            int height = getHeight();
            if (i8 > 0 && t1.d.a(this.f1485j) != 0.0f) {
                i7 = Math.round(t1.d.b(this.f1485j, (((float) (-i8)) * 4.0f) / ((float) height), 0.5f) * (((float) (-height)) / 4.0f));
                if (i7 != i8) {
                    edgeEffect2 = this.f1485j;
                    edgeEffect2.finish();
                }
                i8 -= i7;
            } else if (i8 < 0 && t1.d.a(this.f1486k) != 0.0f) {
                float f7 = (float) height;
                i7 = Math.round(t1.d.b(this.f1486k, (((float) i8) * 4.0f) / f7, 0.5f) * (f7 / 4.0f));
                if (i7 != i8) {
                    edgeEffect2 = this.f1486k;
                    edgeEffect2.finish();
                }
                i8 -= i7;
            }
            this.A = currY;
            int[] iArr = this.f1498y;
            boolean z6 = false;
            iArr[1] = 0;
            this.D.c(0, i8, 1, iArr, null);
            int i9 = i8 - this.f1498y[1];
            int scrollRange = getScrollRange();
            if (i9 != 0) {
                int scrollY = getScrollY();
                q(i9, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i10 = i9 - scrollY2;
                int[] iArr2 = this.f1498y;
                iArr2[1] = 0;
                this.D.e(0, scrollY2, 0, i10, this.f1497x, 1, iArr2);
                i9 = i10 - this.f1498y[1];
            }
            if (i9 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z6 = true;
                }
                if (z6) {
                    if (i9 < 0) {
                        if (this.f1485j.isFinished()) {
                            edgeEffect = this.f1485j;
                            edgeEffect.onAbsorb((int) this.f1484i.getCurrVelocity());
                        }
                    } else if (this.f1486k.isFinished()) {
                        edgeEffect = this.f1486k;
                        edgeEffect.onAbsorb((int) this.f1484i.getCurrVelocity());
                    }
                }
                this.f1484i.abortAnimation();
                y(1);
            }
            if (!this.f1484i.isFinished()) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.k(this);
                return;
            }
            y(1);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public final void d() {
        this.f1496w = -1;
        this.f1490p = false;
        VelocityTracker velocityTracker = this.f1491q;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1491q = null;
        }
        y(0);
        this.f1485j.onRelease();
        this.f1486k.onRelease();
    }

    @Override // android.view.View, android.view.ViewGroup
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || e(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f7, float f8, boolean z6) {
        return this.D.a(f7, f8, z6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f7, float f8) {
        return this.D.b(f7, f8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i7, int i8, int[] iArr, int[] iArr2) {
        return this.D.c(i7, i8, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i7, int i8, int i9, int i10, int[] iArr) {
        return this.D.e(i7, i8, i9, i10, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i7;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i8 = 0;
        if (!this.f1485j.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i7 = getPaddingLeft() + 0;
            } else {
                i7 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate((float) i7, (float) min);
            this.f1485j.setSize(width, height);
            if (this.f1485j.draw(canvas)) {
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.k(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f1486k.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (b.a(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i8 = 0 + getPaddingLeft();
            }
            if (b.a(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i8 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            this.f1486k.setSize(width2, height2);
            if (this.f1486k.draw(canvas)) {
                WeakHashMap<View, k0> weakHashMap2 = y.f5540a;
                y.d.k(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.view.KeyEvent r6) {
        /*
            r5 = this;
            android.graphics.Rect r0 = r5.f1483h
            r0.setEmpty()
            int r0 = r5.getChildCount()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0033
            android.view.View r0 = r5.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r0 = r0.getHeight()
            int r4 = r3.topMargin
            int r0 = r0 + r4
            int r3 = r3.bottomMargin
            int r0 = r0 + r3
            int r3 = r5.getHeight()
            int r4 = r5.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r5.getPaddingBottom()
            int r3 = r3 - r4
            if (r0 <= r3) goto L_0x0033
            r0 = r1
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            r3 = 130(0x82, float:1.82E-43)
            if (r0 != 0) goto L_0x0062
            boolean r0 = r5.isFocused()
            if (r0 == 0) goto L_0x0061
            int r6 = r6.getKeyCode()
            r0 = 4
            if (r6 == r0) goto L_0x0061
            android.view.View r6 = r5.findFocus()
            if (r6 != r5) goto L_0x004c
            r6 = 0
        L_0x004c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r6 = r0.findNextFocus(r5, r6, r3)
            if (r6 == 0) goto L_0x005f
            if (r6 == r5) goto L_0x005f
            boolean r5 = r6.requestFocus(r3)
            if (r5 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r2
        L_0x0060:
            return r1
        L_0x0061:
            return r2
        L_0x0062:
            int r0 = r6.getAction()
            if (r0 != 0) goto L_0x00b9
            int r0 = r6.getKeyCode()
            r1 = 19
            r4 = 33
            if (r0 == r1) goto L_0x00aa
            r1 = 20
            if (r0 == r1) goto L_0x009a
            r1 = 62
            if (r0 == r1) goto L_0x008f
            r6 = 92
            if (r0 == r6) goto L_0x00b0
            r6 = 93
            if (r0 == r6) goto L_0x00a0
            r6 = 122(0x7a, float:1.71E-43)
            if (r0 == r6) goto L_0x008b
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L_0x0096
            goto L_0x00b9
        L_0x008b:
            r5.r(r4)
            goto L_0x00b9
        L_0x008f:
            boolean r6 = r6.isShiftPressed()
            if (r6 == 0) goto L_0x0096
            r3 = r4
        L_0x0096:
            r5.r(r3)
            goto L_0x00b9
        L_0x009a:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto L_0x00a5
        L_0x00a0:
            boolean r2 = r5.g(r3)
            goto L_0x00b9
        L_0x00a5:
            boolean r2 = r5.b(r3)
            goto L_0x00b9
        L_0x00aa:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto L_0x00b5
        L_0x00b0:
            boolean r2 = r5.g(r4)
            goto L_0x00b9
        L_0x00b5:
            boolean r2 = r5.b(r4)
        L_0x00b9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.e(android.view.KeyEvent):boolean");
    }

    public final void f(int i7) {
        if (getChildCount() > 0) {
            this.f1484i.fling(getScrollX(), getScrollY(), 0, i7, 0, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, 0);
            w(2, 1);
            this.A = getScrollY();
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.d.k(this);
        }
    }

    public final boolean g(int i7) {
        int childCount;
        boolean z6 = i7 == 130;
        int height = getHeight();
        Rect rect = this.f1483h;
        rect.top = 0;
        rect.bottom = height;
        if (z6 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f1483h.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.f1483h;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f1483h;
        return s(i7, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        o oVar = this.C;
        return oVar.f5501b | oVar.f5500a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.D.f(0) != null;
    }

    @Override // p1.m
    public final void i(View view, int i7) {
        o oVar = this.C;
        if (i7 == 1) {
            oVar.f5501b = 0;
        } else {
            oVar.f5500a = 0;
        }
        y(i7);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.D.f5499d;
    }

    @Override // p1.m
    public final void j(View view, int i7, int i8, int[] iArr, int i9) {
        this.D.c(i7, i8, i9, iArr, null);
    }

    public final boolean k(View view, int i7, int i8) {
        view.getDrawingRect(this.f1483h);
        offsetDescendantRectToMyCoords(view, this.f1483h);
        return this.f1483h.bottom + i7 >= getScrollY() && this.f1483h.top - i7 <= getScrollY() + i8;
    }

    public final void l(int i7, int i8, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i7);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.D.d(scrollY2, i7 - scrollY2, i8, iArr);
    }

    @Override // p1.n
    public final void m(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        l(i10, i11, iArr);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i7, int i8) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i7, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i8, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // p1.m
    public final void n(View view, int i7, int i8, int i9, int i10, int i11) {
        l(i10, i11, null);
    }

    @Override // p1.m
    public final boolean o(View view, View view2, int i7, int i8) {
        return (i7 & 2) != 0;
    }

    @Override // android.view.View, android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1488n = false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i7;
        float f7;
        boolean z6 = false;
        if (motionEvent.getAction() == 8 && !this.f1490p) {
            if ((motionEvent.getSource() & 2) == 2) {
                f7 = motionEvent.getAxisValue(9);
                i7 = (int) motionEvent.getX();
            } else {
                if ((motionEvent.getSource() & 4194304) == 4194304) {
                    f7 = motionEvent.getAxisValue(26);
                    i7 = getWidth() / 2;
                } else {
                    i7 = 0;
                    f7 = 0.0f;
                }
            }
            if (f7 != 0.0f) {
                int verticalScrollFactorCompat = (int) (f7 * getVerticalScrollFactorCompat());
                if ((motionEvent.getSource() & 8194) == 8194) {
                    z6 = true;
                }
                t(-verticalScrollFactorCompat, i7, 1, z6);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0107  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int i11;
        super.onLayout(z6, i7, i8, i9, i10);
        int i12 = 0;
        this.m = false;
        View view = this.f1489o;
        if (view != null && h(view, this)) {
            View view2 = this.f1489o;
            view2.getDrawingRect(this.f1483h);
            offsetDescendantRectToMyCoords(view2, this.f1483h);
            int c7 = c(this.f1483h);
            if (c7 != 0) {
                scrollBy(0, c7);
            }
        }
        this.f1489o = null;
        if (!this.f1488n) {
            if (this.B != null) {
                scrollTo(getScrollX(), this.B.f1500f);
                this.B = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i11 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i11 = 0;
            }
            int paddingTop = ((i10 - i8) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i11 && scrollY >= 0) {
                i12 = paddingTop + scrollY > i11 ? i11 - paddingTop : scrollY;
            }
            if (i12 != scrollY) {
                scrollTo(getScrollX(), i12);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1488n = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f1492r && View.MeasureSpec.getMode(i8) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i7, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final boolean onNestedFling(View view, float f7, float f8, boolean z6) {
        if (z6) {
            return false;
        }
        dispatchNestedFling(0.0f, f8, true);
        f((int) f8);
        return true;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final boolean onNestedPreFling(View view, float f7, float f8) {
        return dispatchNestedPreFling(f7, f8);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
        j(view, i7, i8, iArr, 0);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        l(i10, 0, null);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void onNestedScrollAccepted(View view, View view2, int i7) {
        a(view, view2, i7, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i7, int i8, boolean z6, boolean z7) {
        super.scrollTo(i7, i8);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i7, Rect rect) {
        if (i7 == 2) {
            i7 = 130;
        } else if (i7 == 1) {
            i7 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        View findNextFocus = rect == null ? instance.findNextFocus(this, null, i7) : instance.findNextFocusFromRect(this, rect, i7);
        if (findNextFocus != null && !(!k(findNextFocus, 0, getHeight()))) {
            return findNextFocus.requestFocus(i7, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.B = dVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f1500f = getScrollY();
        return dVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i7, int i8, int i9, int i10) {
        super.onScrollChanged(i7, i8, i9, i10);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i7, int i8, int i9, int i10) {
        super.onSizeChanged(i7, i8, i9, i10);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && k(findFocus, 0, i10)) {
            findFocus.getDrawingRect(this.f1483h);
            offsetDescendantRectToMyCoords(findFocus, this.f1483h);
            int c7 = c(this.f1483h);
            if (c7 == 0) {
                return;
            }
            if (this.s) {
                v(0, c7, false);
            } else {
                scrollBy(0, c7);
            }
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final boolean onStartNestedScroll(View view, View view2, int i7) {
        return o(view, view2, i7, 0);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
        if (r13.f1484i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x01b6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b4, code lost:
        if (r13.f1484i.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L_0x01b6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b6, code lost:
        r14 = p1.y.f5540a;
        p1.y.d.k(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0190  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1496w) {
            int i7 = actionIndex == 0 ? 1 : 0;
            this.f1487l = (int) motionEvent.getY(i7);
            this.f1496w = motionEvent.getPointerId(i7);
            VelocityTracker velocityTracker = this.f1491q;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            int r0 = r9.getOverScrollMode()
            r9.computeHorizontalScrollRange()
            r9.computeHorizontalScrollExtent()
            r9.computeVerticalScrollRange()
            r9.computeVerticalScrollExtent()
            r1 = 1
            r0 = 0
            int r11 = r11 + r0
            int r12 = r12 + r10
            int r13 = r13 + r0
            if (r11 <= 0) goto L_0x001a
        L_0x0017:
            r11 = r0
            r10 = r1
            goto L_0x001e
        L_0x001a:
            if (r11 >= 0) goto L_0x001d
            goto L_0x0017
        L_0x001d:
            r10 = r0
        L_0x001e:
            if (r12 <= r13) goto L_0x0023
            r12 = r13
        L_0x0021:
            r13 = r1
            goto L_0x0028
        L_0x0023:
            if (r12 >= 0) goto L_0x0027
            r12 = r0
            goto L_0x0021
        L_0x0027:
            r13 = r0
        L_0x0028:
            if (r13 == 0) goto L_0x0045
            p1.l r2 = r9.D
            android.view.ViewParent r2 = r2.f(r1)
            if (r2 == 0) goto L_0x0034
            r2 = r1
            goto L_0x0035
        L_0x0034:
            r2 = r0
        L_0x0035:
            if (r2 != 0) goto L_0x0045
            android.widget.OverScroller r2 = r9.f1484i
            r5 = 0
            r6 = 0
            r7 = 0
            int r8 = r9.getScrollRange()
            r3 = r11
            r4 = r12
            r2.springBack(r3, r4, r5, r6, r7, r8)
        L_0x0045:
            r9.onOverScrolled(r11, r12, r10, r13)
            if (r10 != 0) goto L_0x004e
            if (r13 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = r0
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.q(int, int, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r0.top < 0) goto L_0x004d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = 130(0x82, float:1.82E-43)
            if (r5 != r2) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r1
        L_0x0009:
            int r3 = r4.getHeight()
            if (r2 == 0) goto L_0x003e
            android.graphics.Rect r1 = r4.f1483h
            int r2 = r4.getScrollY()
            int r2 = r2 + r3
            r1.top = r2
            int r1 = r4.getChildCount()
            if (r1 <= 0) goto L_0x004f
            int r1 = r1 - r0
            android.view.View r0 = r4.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            int r0 = r0.getBottom()
            int r1 = r1.bottomMargin
            int r0 = r0 + r1
            int r1 = r4.getPaddingBottom()
            int r1 = r1 + r0
            android.graphics.Rect r0 = r4.f1483h
            int r2 = r0.top
            int r2 = r2 + r3
            if (r2 <= r1) goto L_0x004f
            int r1 = r1 - r3
            goto L_0x004d
        L_0x003e:
            android.graphics.Rect r0 = r4.f1483h
            int r2 = r4.getScrollY()
            int r2 = r2 - r3
            r0.top = r2
            android.graphics.Rect r0 = r4.f1483h
            int r2 = r0.top
            if (r2 >= 0) goto L_0x004f
        L_0x004d:
            r0.top = r1
        L_0x004f:
            android.graphics.Rect r0 = r4.f1483h
            int r1 = r0.top
            int r3 = r3 + r1
            r0.bottom = r3
            r4.s(r5, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.r(int):void");
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void requestChildFocus(View view, View view2) {
        if (!this.m) {
            view2.getDrawingRect(this.f1483h);
            offsetDescendantRectToMyCoords(view2, this.f1483h);
            int c7 = c(this.f1483h);
            if (c7 != 0) {
                scrollBy(0, c7);
            }
        } else {
            this.f1489o = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z6) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int c7 = c(rect);
        boolean z7 = c7 != 0;
        if (z7) {
            if (z6) {
                scrollBy(0, c7);
            } else {
                v(0, c7, false);
            }
        }
        return z7;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
        VelocityTracker velocityTracker;
        if (z6 && (velocityTracker = this.f1491q) != null) {
            velocityTracker.recycle();
            this.f1491q = null;
        }
        super.requestDisallowInterceptTouchEvent(z6);
    }

    @Override // android.view.ViewParent, android.view.View
    public final void requestLayout() {
        this.m = true;
        super.requestLayout();
    }

    public final boolean s(int i7, int i8, int i9) {
        boolean z6;
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = height + scrollY;
        boolean z7 = i7 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z8 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view2 = focusables.get(i11);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i8 < bottom && top < i9) {
                boolean z9 = i8 < top && bottom < i9;
                if (view == null) {
                    view = view2;
                    z8 = z9;
                } else {
                    boolean z10 = (z7 && top < view.getTop()) || (!z7 && bottom > view.getBottom());
                    if (z8) {
                        if (z9) {
                            if (!z10) {
                            }
                            view = view2;
                        }
                    } else if (z9) {
                        view = view2;
                        z8 = true;
                    } else {
                        if (!z10) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i8 < scrollY || i9 > i10) {
            t(z7 ? i8 - scrollY : i9 - i10, 0, 1, true);
            z6 = true;
        } else {
            z6 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i7);
        }
        return z6;
    }

    @Override // android.view.View
    public final void scrollTo(int i7, int i8) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i7 < 0) {
                i7 = 0;
            } else if (width + i7 > width2) {
                i7 = width2 - width;
            }
            if (height >= height2 || i8 < 0) {
                i8 = 0;
            } else if (height + i8 > height2) {
                i8 = height2 - height;
            }
            if (i7 != getScrollX() || i8 != getScrollY()) {
                super.scrollTo(i7, i8);
            }
        }
    }

    public void setFillViewport(boolean z6) {
        if (z6 != this.f1492r) {
            this.f1492r = z6;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z6) {
        l lVar = this.D;
        if (lVar.f5499d) {
            View view = lVar.f5498c;
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.i.z(view);
        }
        lVar.f5499d = z6;
    }

    public void setOnScrollChangeListener(c cVar) {
    }

    public void setSmoothScrollingEnabled(boolean z6) {
        this.s = z6;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i7) {
        return w(i7, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        y(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int t(int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.t(int, int, int, boolean):int");
    }

    public final boolean u(EdgeEffect edgeEffect, int i7) {
        if (i7 > 0) {
            return true;
        }
        float a7 = t1.d.a(edgeEffect) * ((float) getHeight());
        double log = Math.log((double) ((((float) Math.abs(-i7)) * 0.35f) / (this.f1481f * 0.015f)));
        double d7 = (double) F;
        return ((float) (Math.exp((d7 / (d7 - 1.0d)) * log) * ((double) (this.f1481f * 0.015f)))) < a7;
    }

    public final void v(int i7, int i8, boolean z6) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1482g > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f1484i;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i8 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, 250);
                if (z6) {
                    w(2, 1);
                } else {
                    y(1);
                }
                this.A = getScrollY();
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.d.k(this);
            } else {
                if (!this.f1484i.isFinished()) {
                    this.f1484i.abortAnimation();
                    y(1);
                }
                scrollBy(i7, i8);
            }
            this.f1482g = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final boolean w(int i7, int i8) {
        return this.D.g(i7, i8);
    }

    public final boolean x(MotionEvent motionEvent) {
        boolean z6;
        if (t1.d.a(this.f1485j) != 0.0f) {
            t1.d.b(this.f1485j, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z6 = true;
        } else {
            z6 = false;
        }
        if (t1.d.a(this.f1486k) == 0.0f) {
            return z6;
        }
        t1.d.b(this.f1486k, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    public final void y(int i7) {
        this.D.h(i7);
    }
}
