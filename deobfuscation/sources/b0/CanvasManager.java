package b0;

import android.graphics.Canvas;
import android.graphics.Rect;

/* renamed from: b0.a */
/* loaded from: classes.dex */
public final class CanvasManager implements CanvasOperations {

    /* renamed from: a */
    public Canvas canvas = CanvasBase.canvas;

    public CanvasManager() {
        new Rect();
        new Rect();
    }

    @Override // b0.CanvasOperations
    /* renamed from: b */
    public final void translate(float dx, float dy) {
        this.canvas.translate(dx, dy);
    }

    @Override // b0.CanvasOperations
    /* renamed from: c */
    public final void restore() {
        this.canvas.restore();
    }

    @Override // b0.CanvasOperations
    /* renamed from: d */
    public final void drawRect(float left, float top, float right, float bottom, PaintBase paintBase) {
        r5.h.f(paintBase, "paint");
        this.canvas.drawRect(left, top, right, bottom, paintBase.paint);
    }

    @Override // b0.CanvasOperations
    /* renamed from: e */
    public final void save() {
        this.canvas.save();
    }

    @Override // b0.CanvasOperations
    public final void f() {
        Canvas canvas = this.canvas;
        r5.h.f(canvas, "canvas");
        CanvasZToggler.ztoggler.toggleZ(canvas, false);
    }

    @Override // b0.CanvasOperations
    public final void g() {
        Canvas canvas = this.canvas;
        r5.h.f(canvas, "canvas");
        CanvasZToggler.ztoggler.toggleZ(canvas, true);
    }
}
