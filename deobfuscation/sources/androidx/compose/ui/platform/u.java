package androidx.compose.ui.platform;

import Graphics_1.CanvasBase;
import Graphics_1.CanvasManager;
import Graphics_1.CanvasOperations;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class u extends ViewGroup {

    /* renamed from: f */
    public boolean f1239f;

    public final void a(CanvasOperations canvasOperations, View view, long j7) {
        r5.h.f(canvasOperations, "canvas");
        r5.h.f(view, "view");
        Canvas canvas = CanvasBase.canvas;
        super.drawChild(((CanvasManager) canvasOperations).canvas, view, j7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z6;
        r5.h.f(canvas, "canvas");
        int childCount = super.getChildCount();
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                z6 = false;
                break;
            }
            View childAt = getChildAt(i7);
            r5.h.d(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
            if (((d0) childAt).f1144f) {
                z6 = true;
                break;
            }
            i7++;
        }
        if (z6) {
            this.f1239f = true;
            try {
                super.dispatchDraw(canvas);
            } finally {
                this.f1239f = false;
            }
        }
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        if (this.f1239f) {
            return super.getChildCount();
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i7, int i8, int i9, int i10) {
    }

    @Override // android.view.View
    public final void onMeasure(int i7, int i8) {
        setMeasuredDimension(0, 0);
    }
}
