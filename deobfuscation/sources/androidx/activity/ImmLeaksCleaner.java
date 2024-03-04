package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.l {

    /* renamed from: f */
    public static int f382f;

    public ImmLeaksCleaner() {
        throw null;
    }

    @Override // androidx.lifecycle.l
    public final void c(androidx.lifecycle.n nVar, g.a aVar) {
        if (aVar != g.a.ON_DESTROY) {
            return;
        }
        if (f382f == 0) {
            try {
                f382f = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f382f = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f382f == 1) {
            throw null;
        }
    }
}
