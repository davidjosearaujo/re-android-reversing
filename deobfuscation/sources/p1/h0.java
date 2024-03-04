package p1;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class h0 {
    public static boolean a(ViewParent viewParent, View view, float f7, float f8, boolean z6) {
        return viewParent.onNestedFling(view, f7, f8, z6);
    }

    public static boolean b(ViewParent viewParent, View view, float f7, float f8) {
        return viewParent.onNestedPreFling(view, f7, f8);
    }

    public static void c(ViewParent viewParent, View view, int i7, int i8, int[] iArr) {
        viewParent.onNestedPreScroll(view, i7, i8, iArr);
    }

    public static void d(ViewParent viewParent, View view, int i7, int i8, int i9, int i10) {
        viewParent.onNestedScroll(view, i7, i8, i9, i10);
    }

    public static void e(ViewParent viewParent, View view, View view2, int i7) {
        viewParent.onNestedScrollAccepted(view, view2, i7);
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i7) {
        return viewParent.onStartNestedScroll(view, view2, i7);
    }

    public static void g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
