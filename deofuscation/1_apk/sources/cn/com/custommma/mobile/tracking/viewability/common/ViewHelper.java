package cn.com.custommma.mobile.tracking.viewability.common;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewHelper {
    private static Rect screenRect;

    public static Rect getScreenRect(Context context) {
        DisplayMetrics displayMetrics;
        try {
            if (screenRect == null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                screenRect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenRect;
    }

    public static Rect getViewInWindowRect(View view) {
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static boolean isScreenOn(View view) {
        try {
            PowerManager powerManager = (PowerManager) view.getContext().getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public static boolean isScreenOn(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return ((Boolean) powerManager.getClass().getMethod("isScreenOn", new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
