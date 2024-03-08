package androidx.activity;

import android.window.BackEvent;
import r5.h;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f402a = new a();

    public final BackEvent a(float f7, float f8, float f9, int i7) {
        return new BackEvent(f7, f8, f9, i7);
    }

    public final float b(BackEvent backEvent) {
        h.f(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        h.f(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        h.f(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        h.f(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
