package com.google.android.material.carousel;

/* loaded from: classes.dex */
public final class a {
    public static float a(float f7, float f8, int i7) {
        return (Math.max(0, i7 - 1) * f8) + f7;
    }

    public static float b(float f7, float f8, int i7) {
        return i7 > 0 ? (f8 / 2.0f) + f7 : f7;
    }

    public static float c(float f7, float f8, float f9, int i7) {
        return i7 > 0 ? (f9 / 2.0f) + f8 : f7;
    }
}
