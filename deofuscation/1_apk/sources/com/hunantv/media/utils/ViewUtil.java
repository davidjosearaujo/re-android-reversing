package com.hunantv.media.utils;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ViewUtil {
    public static void addView(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        if (isViewExsit(viewGroup, view)) {
            removeView(viewGroup, view);
        }
        viewGroup.addView(view);
    }

    public static void addView(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null || view == null) {
            return;
        }
        if (isViewExsit(viewGroup, view)) {
            removeView(viewGroup, view);
        }
        viewGroup.addView(view, layoutParams);
    }

    public static boolean hasChild(ViewGroup viewGroup) {
        return viewGroup != null && viewGroup.getChildCount() > 0;
    }

    public static boolean isViewExsit(ViewGroup viewGroup, View view) {
        return (viewGroup == null || view == null || viewGroup.indexOfChild(view) < 0) ? false : true;
    }

    public static void removeView(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        viewGroup.removeView(view);
    }
}
