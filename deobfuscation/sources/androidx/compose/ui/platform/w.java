package androidx.compose.ui.platform;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a */
    public static final w f1241a = new w();

    public final boolean a(MotionEvent motionEvent, int i7) {
        r5.h.f(motionEvent, "event");
        float rawX = motionEvent.getRawX(i7);
        if ((Float.isInfinite(rawX) || Float.isNaN(rawX)) ? false : true) {
            float rawY = motionEvent.getRawY(i7);
            if ((Float.isInfinite(rawY) || Float.isNaN(rawY)) ? false : true) {
                return true;
            }
        }
        return false;
    }
}
