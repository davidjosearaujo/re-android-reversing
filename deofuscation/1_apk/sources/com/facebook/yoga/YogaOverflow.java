package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaOverflow {
    VISIBLE(0),
    HIDDEN(1),
    SCROLL(2);
    
    private final int mIntValue;

    YogaOverflow(int i) {
        this.mIntValue = i;
    }

    public static YogaOverflow fromInt(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return SCROLL;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i);
            }
            return HIDDEN;
        }
        return VISIBLE;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
