package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class YogaViewLayoutFactory implements LayoutInflater.Factory {
    private static YogaViewLayoutFactory sYogaViewLayoutFactory;

    public static YogaViewLayoutFactory getInstance() {
        if (sYogaViewLayoutFactory == null) {
            sYogaViewLayoutFactory = new YogaViewLayoutFactory();
        }
        return sYogaViewLayoutFactory;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (YogaLayout.class.getSimpleName().equals(str)) {
            return new YogaLayout(context, attributeSet);
        }
        if (VirtualYogaLayout.class.getSimpleName().equals(str)) {
            return new VirtualYogaLayout(context, attributeSet);
        }
        return null;
    }
}
