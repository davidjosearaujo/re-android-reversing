package p1;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class e0 {
    public static int a(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    public static boolean b(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    public static void c(ViewGroup viewGroup, boolean z6) {
        viewGroup.setTransitionGroup(z6);
    }
}
