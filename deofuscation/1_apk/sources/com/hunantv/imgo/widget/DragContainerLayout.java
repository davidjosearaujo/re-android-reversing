package com.hunantv.imgo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.customview.widget.ViewDragHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.hunantv.imgo.nightmode.view.SkinnableRelativeLayout;
import com.hunantv.mpdt.data.EventClickData;
import j.l.a.b0.j0;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DragContainerLayout extends SkinnableRelativeLayout {
    private ViewDragHelper a;
    private View b;
    private Context c;
    private boolean d;
    private boolean e;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public class b extends ViewDragHelper.Callback {
        private b() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int paddingLeft = DragContainerLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), (DragContainerLayout.this.getWidth() - view.getWidth()) - paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            int paddingTop = DragContainerLayout.this.getPaddingTop();
            return Math.min(Math.max(i, paddingTop), (DragContainerLayout.this.getHeight() - view.getHeight()) - paddingTop);
        }

        public int getViewHorizontalDragRange(View view) {
            if (DragContainerLayout.this.b != null && DragContainerLayout.this.b == view) {
                return DragContainerLayout.this.b.getWidth();
            }
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            if (DragContainerLayout.this.b != null && DragContainerLayout.this.b == view) {
                return DragContainerLayout.this.b.getHeight();
            }
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
            DragContainerLayout.this.a.captureChildView(DragContainerLayout.this.b, i2);
        }

        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            DragContainerLayout.this.requestLayout();
        }

        public void onViewReleased(View view, float f, float f2) {
            DragContainerLayout.this.d = false;
            int paddingLeft = DragContainerLayout.this.getPaddingLeft();
            int width = (DragContainerLayout.this.getWidth() - view.getWidth()) - paddingLeft;
            if (view.getLeft() > (DragContainerLayout.this.getWidth() - view.getWidth()) / 2) {
                paddingLeft = width;
            }
            DragContainerLayout.this.a.settleCapturedViewAt(paddingLeft, view.getTop());
            DragContainerLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            if (view == DragContainerLayout.this.b) {
                DragContainerLayout.this.d = true;
                return true;
            }
            return false;
        }
    }

    public DragContainerLayout(Context context) {
        super(context);
        u0(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u0(Context context) {
        this.c = context;
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, new b());
        this.a = create;
        create.setEdgeTrackingEnabled(4);
    }

    private int v0() {
        Context context = this.c;
        if (context == null) {
            return 0;
        }
        int i = context.getResources().getDisplayMetrics().heightPixels;
        if (i != 854) {
            if (i != 960) {
                if (i != 1280) {
                    if (i != 2560) {
                        return i != 2960 ? 0 : 320;
                    }
                    return 325;
                }
                return Opcodes.INVOKEINTERFACE;
            }
            return EventClickData.u.s1;
        }
        return 128;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void computeScroll() {
        if (this.a.continueSettling(true)) {
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.e) {
            int k = j0.k(this.c);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            View view = this.b;
            int i5 = layoutParams.bottomMargin;
            view.layout((i3 - view.getMeasuredWidth()) - layoutParams.rightMargin, (k - this.b.getMeasuredHeight()) - i5, i3 - layoutParams.rightMargin, k - i5);
            this.e = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.widget.RelativeLayout*/.onMeasure(i, i2);
        this.b = getChildAt(0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.processTouchEvent(motionEvent);
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r0() {
        this.e = true;
        requestLayout();
    }

    /* renamed from: t0 */
    public RelativeLayout.LayoutParams generateDefaultLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super/*android.widget.RelativeLayout*/.generateLayoutParams(layoutParams);
    }

    public DragContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u0(context);
    }

    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new RelativeLayout.LayoutParams(this.c, attributeSet);
    }

    public DragContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u0(context);
    }
}
