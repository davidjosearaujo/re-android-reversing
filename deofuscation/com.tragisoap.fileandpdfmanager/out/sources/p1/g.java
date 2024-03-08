package p1;

import android.view.ViewGroup;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class g {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.resolveLayoutDirection(i7);
    }

    public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.setLayoutDirection(i7);
    }

    public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.setMarginEnd(i7);
    }

    public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.setMarginStart(i7);
    }
}
