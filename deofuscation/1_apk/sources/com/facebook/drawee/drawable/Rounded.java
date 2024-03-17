package com.facebook.drawee.drawable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int i, float f);

    void setCircle(boolean z);

    void setPadding(float f);

    void setRadii(float[] fArr);

    void setRadius(float f);

    void setScaleDownInsideBorders(boolean z);
}
