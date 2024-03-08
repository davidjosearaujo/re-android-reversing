package androidx.compose.ui.platform;

import android.view.MotionEvent;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f1241a = new w();

    public final boolean a(MotionEvent motionEvent, int i7) {
        h.f(motionEvent, "event");
        float rawX = motionEvent.getRawX(i7);
        if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
            float rawY = motionEvent.getRawY(i7);
            if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                return true;
            }
        }
        return false;
    }
}
