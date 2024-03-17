package com.hunantv.imgo.widget.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.hunantv.imgo.widget.indicator.slidebar.ScrollBar;
import j.l.a.c0.k.a;
import j.l.a.t.h;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ScrollIndicatorView extends HorizontalScrollView implements j.l.a.c0.k.a, h {
    private final d a;
    private SFixedIndicatorView b;
    private boolean c;
    private Paint d;
    private Drawable e;
    private int f;
    private int g;
    private Drawable h;
    private a.a i;
    private Runnable j;
    private View k;
    private boolean l;
    private int m;
    private float n;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class SFixedIndicatorView extends FixedIndicatorView {
        private boolean z;

        public SFixedIndicatorView(Context context) {
            super(context);
        }

        private int I(View view, int i, int i2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), -2), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
            return view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }

        public boolean H() {
            return this.z;
        }

        public void J(boolean z) {
            if (this.z != z) {
                this.z = z;
                if (!z) {
                    setSplitMethod(2);
                }
                requestLayout();
                invalidate();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            ScrollIndicatorView scrollIndicatorView;
            int measuredWidth;
            if (this.z && (measuredWidth = (scrollIndicatorView = (ScrollIndicatorView) getParent()).getMeasuredWidth()) != 0) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    int I = I(getChildAt(i5), i, i2);
                    if (i4 < I) {
                        i4 = I;
                    }
                    i3 += I;
                }
                if (i3 > measuredWidth) {
                    scrollIndicatorView.setFillViewport(false);
                    setSplitMethod(2);
                } else if (i4 * childCount > measuredWidth) {
                    scrollIndicatorView.setFillViewport(true);
                    setSplitMethod(1);
                } else {
                    scrollIndicatorView.setFillViewport(true);
                    setSplitMethod(0);
                }
            }
            super.onMeasure(i, i2);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class a implements a.a {
        public a() {
        }

        public void onChange() {
            if (ScrollIndicatorView.this.j != null) {
                ScrollIndicatorView scrollIndicatorView = ScrollIndicatorView.this;
                scrollIndicatorView.removeCallbacks(scrollIndicatorView.j);
            }
            ScrollIndicatorView.this.n = 0.0f;
            ScrollIndicatorView scrollIndicatorView2 = ScrollIndicatorView.this;
            scrollIndicatorView2.c(scrollIndicatorView2.b.getCurrentItem(), false);
            if (!ScrollIndicatorView.this.c || ScrollIndicatorView.this.b.getChildCount() <= 0) {
                return;
            }
            ScrollIndicatorView scrollIndicatorView3 = ScrollIndicatorView.this;
            scrollIndicatorView3.k = scrollIndicatorView3.b.getChildAt(0);
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollIndicatorView.this.smoothScrollTo(this.a.getLeft() - ((ScrollIndicatorView.this.getWidth() - this.a.getWidth()) / 2), 0);
            ScrollIndicatorView.this.j = null;
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ScrollBar.Gravity.values().length];
            a = iArr;
            try {
                iArr[ScrollBar.Gravity.CENTENT_BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ScrollBar.Gravity.CENTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ScrollBar.Gravity.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ScrollBar.Gravity.TOP_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ScrollBar.Gravity.BOTTOM_FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class d implements a.c {
        private a.c a;

        private d() {
        }

        public a.c a() {
            return this.a;
        }

        public void b(a.c cVar) {
            this.a = cVar;
        }

        public void onItemSelected(View view, int i, int i2) {
            if (ScrollIndicatorView.this.g == 0) {
                ScrollIndicatorView.this.l(i);
            }
            a.c cVar = this.a;
            if (cVar != null) {
                cVar.onItemSelected(view, i, i2);
            }
        }

        public /* synthetic */ d(ScrollIndicatorView scrollIndicatorView, a aVar) {
            this();
        }
    }

    public ScrollIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = null;
        this.g = 0;
        this.i = new a();
        this.m = -1;
        SFixedIndicatorView sFixedIndicatorView = new SFixedIndicatorView(context);
        this.b = sFixedIndicatorView;
        addView(sFixedIndicatorView, new FrameLayout.LayoutParams(-2, -1));
        setHorizontalScrollBarEnabled(false);
        setSplitAuto(true);
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setColor(866822826);
        int m = m(3.0f);
        this.f = m;
        this.d.setShadowLayer(m, 0.0f, 0.0f, -16777216);
        setLayerType(1, null);
        SFixedIndicatorView sFixedIndicatorView2 = this.b;
        d dVar = new d(this, null);
        this.a = dVar;
        sFixedIndicatorView2.setOnItemSelectListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        if (i < 0 || i > this.b.getCount() - 1) {
            return;
        }
        View childAt = this.b.getChildAt(i);
        Runnable runnable = this.j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        b bVar = new b(childAt);
        this.j = bVar;
        postDelayed(bVar, 200L);
    }

    private int m(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private void n(Canvas canvas) {
        int height;
        ScrollBar scrollBar = this.b.getScrollBar();
        if (scrollBar == null || this.b.getCurrentItem() != 0) {
            return;
        }
        int save = canvas.save();
        int i = c.a[scrollBar.c().ordinal()];
        if (i != 1 && i != 2) {
            height = (i == 3 || i == 4) ? 0 : getHeight() - scrollBar.b(getHeight());
        } else {
            height = (getHeight() - scrollBar.b(getHeight())) / 2;
        }
        int d2 = scrollBar.d(this.k.getWidth());
        int b2 = scrollBar.b(this.k.getHeight());
        scrollBar.a().measure(d2, b2);
        scrollBar.a().layout(0, 0, d2, b2);
        canvas.translate((this.k.getWidth() - d2) / 2, height);
        canvas.clipRect(0, 0, d2, b2);
        scrollBar.a().draw(canvas);
        canvas.restoreToCount(save);
    }

    public void addAttributeResource(int i, int i2) {
    }

    public void applyDayNight() {
        j.l.a.c0.k.b.b scrollBar = getScrollBar();
        if (scrollBar instanceof h) {
            scrollBar.applyDayNight();
        }
        h onTransitionListener = this.b.getOnTransitionListener();
        if (onTransitionListener instanceof h) {
            onTransitionListener.applyDayNight();
        }
    }

    public void applyGrayMode() {
    }

    public View b(int i) {
        return this.b.b(i);
    }

    public void c(int i, boolean z) {
        int count = this.b.getCount();
        if (count == 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else {
            int i2 = count - 1;
            if (i > i2) {
                i = i2;
            }
        }
        this.m = -1;
        if (this.g == 0) {
            if (z) {
                l(i);
            } else {
                View childAt = this.b.getChildAt(i);
                scrollTo(childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2), 0);
                this.m = i;
            }
        }
        this.b.c(i, z);
    }

    public boolean d() {
        return this.b.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.c) {
            int scrollX = getScrollX();
            if (this.k == null || scrollX <= 0) {
                return;
            }
            int save = canvas.save();
            canvas.translate(scrollX + getPaddingLeft(), getPaddingTop());
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.k.getWidth(), this.k.getHeight());
                this.h.draw(canvas);
            }
            ScrollBar scrollBar = this.b.getScrollBar();
            if (scrollBar != null && scrollBar.c() == ScrollBar.Gravity.CENTENT_BACKGROUND) {
                n(canvas);
            }
            this.k.draw(canvas);
            if (scrollBar != null && scrollBar.c() != ScrollBar.Gravity.CENTENT_BACKGROUND) {
                n(canvas);
            }
            canvas.translate(this.k.getWidth(), 0.0f);
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            Drawable drawable2 = this.e;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, this.f, height);
                this.e.draw(canvas);
            } else {
                canvas.clipRect(0, 0, this.f + m(1.0f), height);
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.c) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            View view = this.k;
            if (view != null && y >= view.getTop() && y <= this.k.getBottom() && x > this.k.getLeft() && x < this.k.getRight()) {
                if (motionEvent.getAction() == 0) {
                    this.l = true;
                } else if (motionEvent.getAction() == 1 && this.l) {
                    this.k.performClick();
                    invalidate(new Rect(0, 0, this.k.getMeasuredWidth(), this.k.getMeasuredHeight()));
                    this.l = false;
                }
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentItem() {
        return this.b.getCurrentItem();
    }

    public a.b getIndicatorAdapter() {
        return this.b.getIndicatorAdapter();
    }

    public a.c getOnItemSelectListener() {
        return this.a.a();
    }

    public a.d getOnTransitionListener() {
        return this.b.getOnTransitionListener();
    }

    public int getPreSelectItem() {
        return this.b.getPreSelectItem();
    }

    public View getPreSelectView() {
        return this.b.getPreSelectView();
    }

    public ScrollBar getScrollBar() {
        return this.b.getScrollBar();
    }

    public boolean o() {
        return this.b.H();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.j;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.j;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int left;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.m;
        if (i5 == -1 || (childAt = this.b.getChildAt(i5)) == null || (left = childAt.getLeft() - ((getMeasuredWidth() - childAt.getMeasuredWidth()) / 2)) < 0) {
            return;
        }
        smoothScrollTo(left, 0);
        this.m = -1;
    }

    public void onPageScrollStateChanged(int i) {
        this.g = i;
        this.b.onPageScrollStateChanged(i);
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.n = f;
        View childAt = this.b.getChildAt(i);
        if (childAt == null) {
            return;
        }
        View childAt2 = this.b.getChildAt(i + 1);
        scrollTo((int) ((childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2)) + (((childAt.getWidth() + (childAt2 == null ? childAt.getWidth() : childAt2.getWidth())) / 2) * f)), 0);
        this.b.onPageScrolled(i, f, i2);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b.getCount() > 0) {
            l(this.b.getCurrentItem());
        }
    }

    public void p(int i, int i2) {
        q(ContextCompat.getDrawable(getContext(), i), i2);
    }

    public void q(Drawable drawable, int i) {
        this.e = drawable;
        this.f = i;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setAdapter(a.b bVar) {
        if (getIndicatorAdapter() != null) {
            getIndicatorAdapter().d(this.i);
        }
        this.b.setAdapter(bVar);
        bVar.c(this.i);
        this.i.onChange();
    }

    public void setCurrentItem(int i) {
        c(i, true);
    }

    public void setCurrentItemWithCallBack(int i) {
        c(i, true);
        this.b.v(i);
    }

    public void setItemClickable(boolean z) {
        this.b.setItemClickable(z);
    }

    public void setOnItemSelectListener(a.c cVar) {
        this.a.b(cVar);
    }

    public void setOnTransitionListener(a.d dVar) {
        this.b.setOnTransitionListener(dVar);
    }

    public void setPinnedTabBg(Drawable drawable) {
        this.h = drawable;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setPinnedTabBgColor(int i) {
        setPinnedTabBg(new ColorDrawable(i));
    }

    public void setPinnedTabBgId(int i) {
        setPinnedTabBg(ContextCompat.getDrawable(getContext(), i));
    }

    public void setPinnedTabView(boolean z) {
        this.c = z;
        if (z && this.b.getChildCount() > 0) {
            this.k = this.b.getChildAt(0);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setScrollBar(ScrollBar scrollBar) {
        this.b.setScrollBar(scrollBar);
    }

    public void setSplitAuto(boolean z) {
        setFillViewport(z);
        this.b.J(z);
    }
}
