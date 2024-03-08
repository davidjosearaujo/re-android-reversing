package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.f;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import f.h;
import f.x;
import i.g;
import java.util.WeakHashMap;
import p1.k0;
import p1.m;
import p1.n;
import p1.o;
import p1.p0;
import p1.y;
@SuppressLint({"UnknownNullness"})
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements f0, m, n {
    public static final int[] G = {2130903045, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;

    /* renamed from: f  reason: collision with root package name */
    public int f681f;

    /* renamed from: h  reason: collision with root package name */
    public ContentFrameLayout f683h;

    /* renamed from: i  reason: collision with root package name */
    public ActionBarContainer f684i;

    /* renamed from: j  reason: collision with root package name */
    public g0 f685j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f686k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f687l;
    public boolean m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f688n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f689o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f690p;

    /* renamed from: q  reason: collision with root package name */
    public int f691q;

    /* renamed from: r  reason: collision with root package name */
    public int f692r;

    /* renamed from: v  reason: collision with root package name */
    public p0 f695v;

    /* renamed from: w  reason: collision with root package name */
    public p0 f696w;

    /* renamed from: x  reason: collision with root package name */
    public p0 f697x;

    /* renamed from: y  reason: collision with root package name */
    public p0 f698y;

    /* renamed from: z  reason: collision with root package name */
    public d f699z;

    /* renamed from: g  reason: collision with root package name */
    public int f682g = 0;
    public final Rect s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    public final Rect f693t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    public final Rect f694u = new Rect();
    public final a C = new a();
    public final b D = new b();
    public final c E = new c();
    public final o F = new o();

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f690p = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f690p = false;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f684i.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f684i.animate().translationY((float) (-ActionBarOverlayLayout.this.f684i.getHeight())).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public interface d {
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e() {
            super(-1, -1);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        p0 p0Var = p0.f5509b;
        this.f695v = p0Var;
        this.f696w = p0Var;
        this.f697x = p0Var;
        this.f698y = p0Var;
        r(context);
    }

    public static boolean p(FrameLayout frameLayout, Rect rect, boolean z6) {
        boolean z7;
        int i7;
        e eVar = (e) frameLayout.getLayoutParams();
        int i8 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i9 = rect.left;
        if (i8 != i9) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i9;
            z7 = true;
        } else {
            z7 = false;
        }
        int i10 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i11 = rect.top;
        if (i10 != i11) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i11;
            z7 = true;
        }
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i13 = rect.right;
        if (i12 != i13) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i13;
            z7 = true;
        }
        if (!z6 || ((ViewGroup.MarginLayoutParams) eVar).bottomMargin == (i7 = rect.bottom)) {
            return z7;
        }
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i7;
        return true;
    }

    @Override // p1.m
    public final void a(View view, View view2, int i7, int i8) {
        if (i8 == 0) {
            onNestedScrollAccepted(view, view2, i7);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public final boolean b() {
        s();
        return this.f685j.b();
    }

    @Override // androidx.appcompat.widget.f0
    public final void c() {
        s();
        this.f685j.c();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.f0
    public final boolean d() {
        s();
        return this.f685j.d();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i7;
        super.draw(canvas);
        if (this.f686k != null && !this.f687l) {
            if (this.f684i.getVisibility() == 0) {
                i7 = (int) (this.f684i.getTranslationY() + ((float) this.f684i.getBottom()) + 0.5f);
            } else {
                i7 = 0;
            }
            this.f686k.setBounds(0, i7, getWidth(), this.f686k.getIntrinsicHeight() + i7);
            this.f686k.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public final boolean e() {
        s();
        return this.f685j.e();
    }

    @Override // androidx.appcompat.widget.f0
    public final void f(f fVar, h.c cVar) {
        s();
        this.f685j.f(fVar, cVar);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.f0
    public final boolean g() {
        s();
        return this.f685j.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f684i;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        o oVar = this.F;
        return oVar.f5501b | oVar.f5500a;
    }

    public CharSequence getTitle() {
        s();
        return this.f685j.getTitle();
    }

    @Override // androidx.appcompat.widget.f0
    public final boolean h() {
        s();
        return this.f685j.h();
    }

    @Override // p1.m
    public final void i(View view, int i7) {
        if (i7 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // p1.m
    public final void j(View view, int i7, int i8, int[] iArr, int i9) {
        if (i9 == 0) {
            onNestedPreScroll(view, i7, i8, iArr);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public final void k(int i7) {
        s();
        if (i7 == 2) {
            this.f685j.s();
        } else if (i7 == 5) {
            this.f685j.t();
        } else if (i7 == 109) {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public final void l() {
        s();
        this.f685j.i();
    }

    @Override // p1.n
    public final void m(View view, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        n(view, i7, i8, i9, i10, i11);
    }

    @Override // p1.m
    public final void n(View view, int i7, int i8, int i9, int i10, int i11) {
        if (i11 == 0) {
            onNestedScroll(view, i7, i8, i9, i10);
        }
    }

    @Override // p1.m
    public final boolean o(View view, View view2, int i7, int i8) {
        return i8 == 0 && onStartNestedScroll(view, view2, i7);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        s();
        p0 h7 = p0.h(this, windowInsets);
        boolean p6 = p(this.f684i, new Rect(h7.c(), h7.e(), h7.d(), h7.b()), false);
        Rect rect = this.s;
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.i.b(this, h7, rect);
        Rect rect2 = this.s;
        p0 l6 = h7.f5510a.l(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.f695v = l6;
        p6 = true;
        if (!this.f696w.equals(l6)) {
            this.f696w = this.f695v;
            p6 = true;
        }
        if (!this.f693t.equals(this.s)) {
            this.f693t.set(this.s);
        }
        if (p6) {
            requestLayout();
        }
        return h7.f5510a.a().f5510a.c().f5510a.b().g();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r(getContext());
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        y.h.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i12, i13, measuredWidth + i12, measuredHeight + i13);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        int i9;
        p0 p0Var;
        s();
        measureChildWithMargins(this.f684i, i7, 0, i8, 0);
        e eVar = (e) this.f684i.getLayoutParams();
        int max = Math.max(0, this.f684i.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f684i.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f684i.getMeasuredState());
        WeakHashMap<View, k0> weakHashMap = y.f5540a;
        boolean z6 = (y.d.g(this) & 256) != 0;
        if (z6) {
            i9 = this.f681f;
            if (this.f688n && this.f684i.getTabContainer() != null) {
                i9 += this.f681f;
            }
        } else {
            i9 = this.f684i.getVisibility() != 8 ? this.f684i.getMeasuredHeight() : 0;
        }
        this.f694u.set(this.s);
        p0 p0Var2 = this.f695v;
        this.f697x = p0Var2;
        if (this.m || z6) {
            i1.b b2 = i1.b.b(p0Var2.c(), this.f697x.e() + i9, this.f697x.d(), this.f697x.b() + 0);
            p0.c cVar = new p0.c(this.f697x);
            cVar.f(b2);
            p0Var = cVar.b();
        } else {
            Rect rect = this.f694u;
            rect.top += i9;
            rect.bottom += 0;
            p0Var = p0Var2.f5510a.l(0, i9, 0, 0);
        }
        this.f697x = p0Var;
        p(this.f683h, this.f694u, true);
        if (!this.f698y.equals(this.f697x)) {
            p0 p0Var3 = this.f697x;
            this.f698y = p0Var3;
            ContentFrameLayout contentFrameLayout = this.f683h;
            WindowInsets g2 = p0Var3.g();
            if (g2 != null) {
                WindowInsets a7 = y.h.a(contentFrameLayout, g2);
                if (!a7.equals(g2)) {
                    p0.h(contentFrameLayout, a7);
                }
            }
        }
        measureChildWithMargins(this.f683h, i7, 0, i8, 0);
        e eVar2 = (e) this.f683h.getLayoutParams();
        int max3 = Math.max(max, this.f683h.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f683h.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f683h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i7, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i8, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f7, float f8, boolean z6) {
        boolean z7 = false;
        if (!this.f689o || !z6) {
            return false;
        }
        this.A.fling(0, 0, 0, (int) f8, 0, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (this.A.getFinalY() > this.f684i.getHeight()) {
            z7 = true;
        }
        if (z7) {
            q();
            this.E.run();
        } else {
            q();
            this.D.run();
        }
        this.f690p = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f7, float f8) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i7, int i8, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i7, int i8, int i9, int i10) {
        int i11 = this.f691q + i8;
        this.f691q = i11;
        setActionBarHideOffset(i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i7) {
        x xVar;
        g gVar;
        this.F.f5500a = i7;
        this.f691q = getActionBarHideOffset();
        q();
        d dVar = this.f699z;
        if (dVar != null && (gVar = (xVar = (x) dVar).f4060t) != null) {
            gVar.a();
            xVar.f4060t = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i7) {
        if ((i7 & 2) == 0 || this.f684i.getVisibility() != 0) {
            return false;
        }
        return this.f689o;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (this.f689o && !this.f690p) {
            if (this.f691q <= this.f684i.getHeight()) {
                q();
                postDelayed(this.D, 600);
                return;
            }
            q();
            postDelayed(this.E, 600);
        }
    }

    @Override // android.view.View
    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int i7) {
        super.onWindowSystemUiVisibilityChanged(i7);
        s();
        int i8 = this.f692r ^ i7;
        this.f692r = i7;
        boolean z6 = (i7 & 4) == 0;
        boolean z7 = (i7 & 256) != 0;
        d dVar = this.f699z;
        if (dVar != null) {
            ((x) dVar).f4057p = !z7;
            if (z6 || !z7) {
                x xVar = (x) dVar;
                if (xVar.f4058q) {
                    xVar.f4058q = false;
                    xVar.w(true);
                }
            } else {
                x xVar2 = (x) dVar;
                if (!xVar2.f4058q) {
                    xVar2.f4058q = true;
                    xVar2.w(true);
                }
            }
        }
        if ((i8 & 256) != 0 && this.f699z != null) {
            WeakHashMap<View, k0> weakHashMap = y.f5540a;
            y.h.c(this);
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i7) {
        super.onWindowVisibilityChanged(i7);
        this.f682g = i7;
        d dVar = this.f699z;
        if (dVar != null) {
            ((x) dVar).f4056o = i7;
        }
    }

    public final void q() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void r(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z6 = false;
        this.f681f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f686k = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z6 = true;
        }
        this.f687l = z6;
        this.A = new OverScroller(context);
    }

    public final void s() {
        g0 g0Var;
        if (this.f683h == null) {
            this.f683h = (ContentFrameLayout) findViewById(2131296310);
            this.f684i = (ActionBarContainer) findViewById(2131296311);
            View findViewById = findViewById(2131296309);
            if (findViewById instanceof g0) {
                g0Var = (g0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                g0Var = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder d7 = androidx.activity.h.d("Can't make a decor toolbar out of ");
                d7.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(d7.toString());
            }
            this.f685j = g0Var;
        }
    }

    public void setActionBarHideOffset(int i7) {
        q();
        this.f684i.setTranslationY((float) (-Math.max(0, Math.min(i7, this.f684i.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f699z = dVar;
        if (getWindowToken() != null) {
            ((x) this.f699z).f4056o = this.f682g;
            int i7 = this.f692r;
            if (i7 != 0) {
                onWindowSystemUiVisibilityChanged(i7);
                WeakHashMap<View, k0> weakHashMap = y.f5540a;
                y.h.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z6) {
        this.f688n = z6;
    }

    public void setHideOnContentScrollEnabled(boolean z6) {
        if (z6 != this.f689o) {
            this.f689o = z6;
            if (!z6) {
                q();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i7) {
        s();
        this.f685j.setIcon(i7);
    }

    public void setIcon(Drawable drawable) {
        s();
        this.f685j.setIcon(drawable);
    }

    public void setLogo(int i7) {
        s();
        this.f685j.p(i7);
    }

    public void setOverlayMode(boolean z6) {
        this.m = z6;
        this.f687l = z6 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z6) {
    }

    public void setUiOptions(int i7) {
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowCallback(Window.Callback callback) {
        s();
        this.f685j.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowTitle(CharSequence charSequence) {
        s();
        this.f685j.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
