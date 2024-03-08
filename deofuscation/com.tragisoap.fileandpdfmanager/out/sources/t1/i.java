package t1;

import android.widget.PopupWindow;
/* loaded from: /home/remnux/original_apks/com.tragisoap.fileandpdfmanager/classes.dex */
public final class i {
    public static boolean a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void c(PopupWindow popupWindow, boolean z6) {
        popupWindow.setOverlapAnchor(z6);
    }

    public static void d(PopupWindow popupWindow, int i7) {
        popupWindow.setWindowLayoutType(i7);
    }
}
