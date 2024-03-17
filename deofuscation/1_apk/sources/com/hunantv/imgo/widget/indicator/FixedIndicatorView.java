package com.hunantv.imgo.widget.indicator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.hunantv.imgo.nightmode.view.SkinnableLinearLayout;
import com.hunantv.imgo.widget.indicator.slidebar.ScrollBar;
import j.l.a.c0.k.a;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FixedIndicatorView extends SkinnableLinearLayout implements j.l.a.c0.k.a {
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;
    private a.b a;
    private a.c b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private List<ViewGroup> h;
    private a.a i;
    private View.OnClickListener j;
    private ScrollBar k;
    private d l;
    private Bitmap m;
    private Matrix n;
    private Canvas o;
    private int[] p;
    private int q;
    private int r;
    private float s;
    private a.d t;
    private View u;
    private LinearLayout.LayoutParams v;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements a.a {
        public a() {
        }

        public void onChange() {
            View view;
            if (!FixedIndicatorView.this.l.d()) {
                FixedIndicatorView.this.l.stop();
            }
            int tabCountInLayout = FixedIndicatorView.this.getTabCountInLayout();
            int a = FixedIndicatorView.this.a.a();
            FixedIndicatorView.this.h.clear();
            for (int i = 0; i < tabCountInLayout && i < a; i++) {
                FixedIndicatorView.this.h.add((ViewGroup) FixedIndicatorView.this.x(i));
            }
            FixedIndicatorView.this.removeAllViews();
            int size = FixedIndicatorView.this.h.size();
            int i2 = 0;
            while (i2 < a) {
                LinearLayout linearLayout = new LinearLayout(FixedIndicatorView.this.getContext());
                if (i2 < size) {
                    View childAt = ((ViewGroup) FixedIndicatorView.this.h.get(i2)).getChildAt(0);
                    ((ViewGroup) FixedIndicatorView.this.h.get(i2)).removeView(childAt);
                    view = FixedIndicatorView.this.a.getView(i2, childAt, linearLayout);
                } else {
                    view = FixedIndicatorView.this.a.getView(i2, (View) null, linearLayout);
                }
                if (FixedIndicatorView.this.t != null) {
                    FixedIndicatorView.this.t.a(view, i2, i2 == FixedIndicatorView.this.c ? 1.0f : 0.0f);
                }
                linearLayout.addView(view);
                linearLayout.setOnClickListener(FixedIndicatorView.this.j);
                linearLayout.setTag(Integer.valueOf(i2));
                FixedIndicatorView.this.addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
                i2++;
            }
            if (FixedIndicatorView.this.u != null) {
                FixedIndicatorView fixedIndicatorView = FixedIndicatorView.this;
                fixedIndicatorView.F(fixedIndicatorView.u, FixedIndicatorView.this.v);
            }
            FixedIndicatorView.this.g = -1;
            FixedIndicatorView fixedIndicatorView2 = FixedIndicatorView.this;
            fixedIndicatorView2.c(fixedIndicatorView2.c, false);
            FixedIndicatorView.this.B();
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FixedIndicatorView.this.f) {
                int intValue = ((Integer) view.getTag()).intValue();
                ViewGroup viewGroup = (ViewGroup) view;
                FixedIndicatorView.this.setCurrentItem(intValue);
                if (FixedIndicatorView.this.b != null) {
                    FixedIndicatorView.this.b.onItemSelected(viewGroup.getChildAt(0), intValue, FixedIndicatorView.this.g);
                }
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollBar.Gravity.values().length];
            a = iArr;
            try {
                iArr[ScrollBar.Gravity.BOTTOM_FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollBar.Gravity.TOP_FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT_BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ScrollBar.Gravity.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements Runnable {
        private int a = 20;
        private Scroller b;
        private final Interpolator c;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public class a implements Interpolator {
            public a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }

        public d() {
            a aVar = new a();
            this.c = aVar;
            this.b = new Scroller(FixedIndicatorView.this.getContext(), aVar);
        }

        public boolean a() {
            return this.b.computeScrollOffset();
        }

        public int b() {
            return this.b.getCurrX();
        }

        public boolean d() {
            return this.b.isFinished();
        }

        public void e(int i, int i2, int i3) {
            this.b.startScroll(i, 0, i2 - i, 0, i3);
            ViewCompat.postInvalidateOnAnimation(FixedIndicatorView.this);
            FixedIndicatorView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewCompat.postInvalidateOnAnimation(FixedIndicatorView.this);
            if (this.b.isFinished()) {
                return;
            }
            FixedIndicatorView.this.postDelayed(this, this.a);
        }

        public void stop() {
            if (this.b.isFinished()) {
                this.b.abortAnimation();
            }
            FixedIndicatorView.this.removeCallbacks(this);
        }
    }

    public FixedIndicatorView(Context context) {
        super(context);
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = -1;
        this.h = new LinkedList();
        this.i = new a();
        this.j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }

    private int A(int i, float f, boolean z) {
        View x2;
        ScrollBar scrollBar = this.k;
        if (scrollBar == null) {
            return 0;
        }
        View a2 = scrollBar.a();
        if (a2.isLayoutRequested() || z) {
            View x3 = x(i);
            int i2 = i + 1;
            if (i2 < this.a.a()) {
                x2 = x(i2);
            } else {
                x2 = x(0);
            }
            if (x3 != null) {
                int width = (int) ((x3.getWidth() * (1.0f - f)) + (x2 == null ? 0.0f : x2.getWidth() * f));
                int d2 = this.k.d(width);
                int b2 = this.k.b(getHeight());
                a2.measure(d2, b2);
                a2.layout(0, 0, d2, b2);
                return width;
            }
        }
        return this.k.a().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        int tabCountInLayout = getTabCountInLayout();
        int i = this.d;
        int i2 = 0;
        if (i == 0) {
            for (int i3 = 0; i3 < tabCountInLayout; i3++) {
                View x2 = x(i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) x2.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                x2.setLayoutParams(layoutParams);
            }
        } else if (i == 1) {
            while (i2 < tabCountInLayout) {
                View x3 = x(i2);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) x3.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.weight = 1.0f;
                x3.setLayoutParams(layoutParams2);
                i2++;
            }
        } else if (i == 2) {
            while (i2 < tabCountInLayout) {
                View x4 = x(i2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) x4.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.weight = 0.0f;
                x4.setLayoutParams(layoutParams3);
                i2++;
            }
        }
    }

    private void C(int i, float f, int i2) {
        int[] iArr;
        View b2;
        if (i < 0 || i > getCount() - 1) {
            return;
        }
        ScrollBar scrollBar = this.k;
        if (scrollBar != null) {
            scrollBar.onPageScrolled(i, f, i2);
        }
        if (this.t != null) {
            for (int i3 : this.p) {
                if (i3 != i && i3 != i + 1 && (b2 = b(i3)) != null) {
                    this.t.a(b2, i3, 0.0f);
                }
            }
            int[] iArr2 = this.p;
            iArr2[0] = i;
            int i4 = i + 1;
            iArr2[1] = i4;
            View b3 = b(this.g);
            if (b3 != null) {
                this.t.a(b3, this.g, 0.0f);
            }
            View b4 = b(i);
            if (b4 != null) {
                this.t.a(b4, i, 1.0f - f);
            }
            View b5 = b(i4);
            if (b5 != null) {
                this.t.a(b5, i4, f);
            }
        }
    }

    private void G(int i) {
        a.b bVar = this.a;
        if (bVar == null) {
            return;
        }
        int a2 = bVar.a();
        int i2 = 0;
        while (i2 < a2) {
            View y2 = y(i2);
            if (y2 != null) {
                y2.setSelected(i == i2);
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTabCountInLayout() {
        if (this.u != null) {
            return getChildCount() - 1;
        }
        return getChildCount();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hunantv.imgo.widget.indicator.FixedIndicatorView.w(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x(int i) {
        if (this.u != null && i >= (getChildCount() - 1) / 2) {
            i++;
        }
        return getChildAt(i);
    }

    private View y(int i) {
        return ((ViewGroup) x(i)).getChildAt(0);
    }

    private void z() {
        this.l = new d();
    }

    public void D() {
        View view = this.u;
        if (view != null) {
            removeView(view);
            this.u = null;
        }
        this.v = null;
    }

    public void E(View view, int i, int i2) {
        this.u = view;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i2);
        layoutParams.gravity = 16;
        F(view, layoutParams);
    }

    public void F(View view, ViewGroup.LayoutParams layoutParams) {
        LinearLayout.LayoutParams generateLayoutParams;
        D();
        if (layoutParams == null) {
            generateLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        } else {
            generateLayoutParams = generateLayoutParams(layoutParams);
        }
        this.v = generateLayoutParams;
        this.u = view;
        addView(view, getChildCount() / 2, generateLayoutParams);
    }

    public View b(int i) {
        if (i < 0 || i > this.a.a() - 1) {
            return null;
        }
        return y(i);
    }

    public void c(int i, boolean z) {
        int i2;
        int left;
        int left2;
        int count = getCount();
        if (count == 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else {
            int i3 = count - 1;
            if (i > i3) {
                i = i3;
            }
        }
        int i4 = this.c;
        this.g = i4;
        this.c = i;
        if (i != i4) {
            if (!this.l.d()) {
                this.l.stop();
            }
            if (this.e == 0) {
                G(i);
                if (z && getWidth() != 0 && (i2 = this.g) >= 0 && i2 < getTabCountInLayout()) {
                    this.l.e(x(this.g).getLeft(), x(i).getLeft(), Math.min((int) (((Math.abs(left2 - left) / x(i).getWidth()) + 1.0f) * 100.0f), 600));
                    return;
                }
                C(i, 0.0f, 0);
            } else if (this.t == null) {
                G(i);
            }
        }
    }

    public boolean d() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ScrollBar scrollBar = this.k;
        if (scrollBar != null && scrollBar.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            w(canvas);
        }
        super.dispatchDraw(canvas);
        ScrollBar scrollBar2 = this.k;
        if (scrollBar2 == null || scrollBar2.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
            return;
        }
        w(canvas);
    }

    public View getCenterView() {
        return this.u;
    }

    public int getCount() {
        a.b bVar = this.a;
        if (bVar == null) {
            return 0;
        }
        return bVar.a();
    }

    public int getCurrentItem() {
        return this.c;
    }

    public a.b getIndicatorAdapter() {
        return this.a;
    }

    public a.c getOnItemSelectListener() {
        return this.b;
    }

    public a.d getOnTransitionListener() {
        return this.t;
    }

    public int getPreSelectItem() {
        return this.g;
    }

    public View getPreSelectView() {
        return y(this.g);
    }

    public ScrollBar getScrollBar() {
        return this.k;
    }

    public int getSplitMethod() {
        return this.d;
    }

    @Override // android.view.ViewGroup
    public void measureChildren(int i, int i2) {
        super.measureChildren(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.stop();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            this.u = childAt;
            this.v = (LinearLayout.LayoutParams) childAt.getLayoutParams();
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.e = i;
        if (i == 0) {
            G(this.c);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.q = i;
        this.s = f;
        this.r = i2;
        if (this.k != null) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            C(i, f, i2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        A(this.c, 1.0f, true);
    }

    public void setAdapter(a.b bVar) {
        a.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.d(this.i);
        }
        this.a = bVar;
        bVar.c(this.i);
        bVar.b();
    }

    public void setCenterView(View view) {
        F(view, view.getLayoutParams());
    }

    public void setCurrentItem(int i) {
        c(i, true);
    }

    public void setItemClickable(boolean z) {
        this.f = z;
    }

    public void setOnItemSelectListener(a.c cVar) {
        this.b = cVar;
    }

    public void setOnTransitionListener(a.d dVar) {
        this.t = dVar;
        G(this.c);
        if (this.a != null) {
            int i = 0;
            while (i < this.a.a()) {
                View b2 = b(i);
                if (b2 != null) {
                    dVar.a(b2, i, this.c == i ? 1.0f : 0.0f);
                }
                i++;
            }
        }
    }

    public void setScrollBar(ScrollBar scrollBar) {
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        ScrollBar scrollBar2 = this.k;
        if (scrollBar2 != null) {
            int i = c.a[scrollBar2.c().ordinal()];
            if (i == 1) {
                paddingBottom -= scrollBar.b(getHeight());
            } else if (i == 2) {
                paddingTop -= scrollBar.b(getHeight());
            }
        }
        this.k = scrollBar;
        int i2 = c.a[scrollBar.c().ordinal()];
        if (i2 == 1) {
            paddingBottom += scrollBar.b(getHeight());
        } else if (i2 == 2) {
            paddingTop += scrollBar.b(getHeight());
        }
        setPadding(getPaddingLeft(), paddingTop, getPaddingRight(), paddingBottom);
    }

    public void setSplitMethod(int i) {
        this.d = i;
        B();
    }

    public void v(int i) {
        a.c cVar = this.b;
        if (cVar != null) {
            cVar.onItemSelected(b(i), i, this.g);
        }
    }

    @SuppressLint({"NewApi"})
    public FixedIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = -1;
        this.h = new LinkedList();
        this.i = new a();
        this.j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }

    public FixedIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = -1;
        this.h = new LinkedList();
        this.i = new a();
        this.j = new b();
        this.n = new Matrix();
        this.o = new Canvas();
        this.p = new int[]{-1, -1};
        z();
    }
}
