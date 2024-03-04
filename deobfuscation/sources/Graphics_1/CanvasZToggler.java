package Graphics_1;

import android.graphics.Canvas;
import r5.h;

/* renamed from: b0.e */
/* loaded from: classes.dex */
public final class CanvasZToggler {

    /* renamed from: a */
    public static final CanvasZToggler ztoggler = new CanvasZToggler();

    /* renamed from: a */
    public final void toggleZ(Canvas canvas, boolean enabled) {
        h.f(canvas, "canvas");
        if (enabled) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
