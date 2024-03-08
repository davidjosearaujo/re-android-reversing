package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
final class ImmLeaksCleaner implements l {

    /* renamed from: f  reason: collision with root package name */
    public static int f382f;

    public ImmLeaksCleaner() {
        throw null;
    }

    @Override // androidx.lifecycle.l
    public final void c(n nVar, g.a aVar) {
        if (aVar == g.a.ON_DESTROY) {
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
}
