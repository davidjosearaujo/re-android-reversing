package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p1.y;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a */
    public static Method f908a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f908a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f908a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean a(View view) {
        WeakHashMap<View, p1.k0> weakHashMap = p1.y.f5540a;
        return y.e.d(view) == 1;
    }
}
