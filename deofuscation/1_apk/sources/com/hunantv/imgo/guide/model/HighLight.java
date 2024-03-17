package com.hunantv.imgo.guide.model;

import android.graphics.RectF;
import android.view.View;
import androidx.annotation.Nullable;
import j.l.a.l.e.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface HighLight {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum Shape {
        CIRCLE,
        RECTANGLE,
        OVAL,
        ROUND_RECTANGLE
    }

    RectF a(View view);

    @Nullable
    b b();

    int c();

    Shape d();

    float getRadius();
}
