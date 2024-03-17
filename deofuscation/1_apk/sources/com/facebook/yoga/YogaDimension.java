package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaDimension {
    WIDTH(0),
    HEIGHT(1);
    
    private final int mIntValue;

    YogaDimension(int i) {
        this.mIntValue = i;
    }

    public static YogaDimension fromInt(int i) {
        if (i != 0) {
            if (i == 1) {
                return HEIGHT;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return WIDTH;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
