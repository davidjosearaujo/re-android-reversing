package com.rajat.pdfviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.recyclerview.widget.RecyclerView;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class PinchZoomRecyclerView extends RecyclerView {
    public ScaleGestureDetector N0;
    public GestureDetector O0;
    public float S0;
    public float T0;
    public float U0;
    public float V0;
    public float W0;
    public float X0;
    public int M0 = -1;
    public float P0 = 1.0f;
    public boolean Q0 = true;
    public float R0 = 3.0f;

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            h.f(motionEvent, "e");
            PinchZoomRecyclerView pinchZoomRecyclerView = PinchZoomRecyclerView.this;
            if (!pinchZoomRecyclerView.Q0) {
                return true;
            }
            float f7 = 0.0f;
            if (pinchZoomRecyclerView.P0 > 1.0f) {
                pinchZoomRecyclerView.P0 = 1.0f;
                pinchZoomRecyclerView.W0 = 0.0f;
                pinchZoomRecyclerView.X0 = 0.0f;
            } else {
                pinchZoomRecyclerView.P0 = pinchZoomRecyclerView.R0;
                float x6 = motionEvent.getX();
                PinchZoomRecyclerView pinchZoomRecyclerView2 = PinchZoomRecyclerView.this;
                pinchZoomRecyclerView.W0 = -((pinchZoomRecyclerView2.R0 - 1.0f) * x6);
                float y6 = motionEvent.getY();
                PinchZoomRecyclerView pinchZoomRecyclerView3 = PinchZoomRecyclerView.this;
                pinchZoomRecyclerView2.X0 = -((pinchZoomRecyclerView3.R0 - 1.0f) * y6);
                float width = pinchZoomRecyclerView3.S0 - (((float) pinchZoomRecyclerView3.getWidth()) * pinchZoomRecyclerView3.P0);
                float height = pinchZoomRecyclerView3.T0 - (((float) pinchZoomRecyclerView3.getHeight()) * pinchZoomRecyclerView3.P0);
                float f8 = pinchZoomRecyclerView3.W0;
                if (f8 > 0.0f) {
                    f8 = 0.0f;
                }
                if (width < f8) {
                    width = f8;
                }
                pinchZoomRecyclerView3.W0 = width;
                float f9 = pinchZoomRecyclerView3.X0;
                if (f9 <= 0.0f) {
                    f7 = f9;
                }
                if (height < f7) {
                    height = f7;
                }
                pinchZoomRecyclerView3.X0 = height;
            }
            PinchZoomRecyclerView.this.invalidate();
            return true;
        }
    }

    /* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
    public final class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            h.f(scaleGestureDetector, "detector");
            float scaleFactor = scaleGestureDetector.getScaleFactor() * PinchZoomRecyclerView.this.P0;
            if (scaleFactor > 3.0f) {
                scaleFactor = 3.0f;
            }
            if (1.0f >= scaleFactor) {
                scaleFactor = 1.0f;
            }
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            PinchZoomRecyclerView pinchZoomRecyclerView = PinchZoomRecyclerView.this;
            float f7 = pinchZoomRecyclerView.P0;
            if (!(scaleFactor == f7)) {
                float f8 = pinchZoomRecyclerView.W0;
                float f9 = ((float) 1) - (scaleFactor / f7);
                pinchZoomRecyclerView.W0 = f8 - ((focusX - f8) * f9);
                float f10 = pinchZoomRecyclerView.X0;
                pinchZoomRecyclerView.X0 = f10 - ((focusY - f10) * f9);
                pinchZoomRecyclerView.P0 = scaleFactor;
                float f11 = pinchZoomRecyclerView.S0;
                PinchZoomRecyclerView pinchZoomRecyclerView2 = PinchZoomRecyclerView.this;
                float width = f11 - (((float) pinchZoomRecyclerView.getWidth()) * pinchZoomRecyclerView2.P0);
                float f12 = pinchZoomRecyclerView2.W0;
                float f13 = 0.0f;
                if (f12 > 0.0f) {
                    f12 = 0.0f;
                }
                if (width < f12) {
                    width = f12;
                }
                pinchZoomRecyclerView.W0 = width;
                float f14 = pinchZoomRecyclerView2.T0;
                PinchZoomRecyclerView pinchZoomRecyclerView3 = PinchZoomRecyclerView.this;
                float height = f14 - (((float) pinchZoomRecyclerView2.getHeight()) * pinchZoomRecyclerView3.P0);
                float f15 = pinchZoomRecyclerView3.X0;
                if (f15 <= 0.0f) {
                    f13 = f15;
                }
                if (height < f13) {
                    height = f13;
                }
                pinchZoomRecyclerView2.X0 = height;
                pinchZoomRecyclerView3.invalidate();
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchZoomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.f(context, "context");
        if (!isInEditMode()) {
            this.N0 = new ScaleGestureDetector(getContext(), new b());
            this.O0 = new GestureDetector(getContext(), new a());
        }
        if (!isInEditMode()) {
            this.N0 = new ScaleGestureDetector(context, new b());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        h.f(canvas, "canvas");
        canvas.save();
        canvas.translate(this.W0, this.X0);
        float f7 = this.P0;
        canvas.scale(f7, f7);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onDraw(Canvas canvas) {
        h.f(canvas, "canvas");
        canvas.save();
        canvas.translate(this.W0, this.X0);
        float f7 = this.P0;
        canvas.scale(f7, f7);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h.f(motionEvent, "ev");
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        this.S0 = (float) getMeasuredWidth();
        this.T0 = (float) getMeasuredHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i7;
        h.f(motionEvent, "ev");
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        GestureDetector gestureDetector = this.O0;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        ScaleGestureDetector scaleGestureDetector = this.N0;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.M0);
                    float x6 = motionEvent.getX(findPointerIndex);
                    float y6 = motionEvent.getY(findPointerIndex);
                    if (this.P0 > 1.0f) {
                        this.W0 += x6 - this.U0;
                        this.X0 += y6 - this.V0;
                        float width = this.S0 - (((float) getWidth()) * this.P0);
                        float f7 = this.W0;
                        float f8 = 0.0f;
                        if (f7 > 0.0f) {
                            f7 = 0.0f;
                        }
                        if (width < f7) {
                            width = f7;
                        }
                        this.W0 = width;
                        float height = this.T0 - (((float) getHeight()) * this.P0);
                        float f9 = this.X0;
                        if (f9 <= 0.0f) {
                            f8 = f9;
                        }
                        if (height < f8) {
                            height = f8;
                        }
                        this.X0 = height;
                    }
                    this.U0 = x6;
                    this.V0 = y6;
                    invalidate();
                } else if (action != 3) {
                    if (action == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.M0) {
                            int i8 = actionIndex == 0 ? 1 : 0;
                            this.U0 = motionEvent.getX(i8);
                            this.V0 = motionEvent.getY(i8);
                            i7 = motionEvent.getPointerId(i8);
                        }
                    }
                }
                return !onTouchEvent || this.P0 > 1.0f;
            }
            i7 = -1;
        } else {
            this.U0 = motionEvent.getX();
            this.V0 = motionEvent.getY();
            i7 = motionEvent.getPointerId(0);
        }
        this.M0 = i7;
        if (!onTouchEvent) {
        }
    }
}
