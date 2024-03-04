package l0;

import Graphics_1.CanvasOperations;
import Graphics_1.PaintBase;
import android.graphics.Paint;
import x.a;

/* loaded from: classes.dex */
public final class m extends w {

    /* renamed from: n */
    public static final PaintBase f4856n;

    static {
        PaintBase paintBase = new PaintBase();
        long j5 = Graphics_1.f.f2342c;
        Paint paint = paintBase.paint;
        r5.h.f(paint, "$this$setNativeColor");
        paint.setColor(a0.e.F(j5));
        Paint paint2 = paintBase.paint;
        r5.h.f(paint2, "<this>");
        paint2.setStrokeWidth(1.0f);
        Paint paint3 = paintBase.paint;
        r5.h.f(paint3, "$this$setNativeStyle");
        paint3.setStyle(Paint.Style.STROKE);
        f4856n = paintBase;
    }

    public final a.b q() {
        throw null;
    }

    public final void z(CanvasOperations canvasOperations) {
        r5.h.f(canvasOperations, "canvas");
        r5.h.c(null);
        throw null;
    }
}
