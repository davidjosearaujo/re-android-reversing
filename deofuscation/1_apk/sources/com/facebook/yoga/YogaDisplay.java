package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaDisplay {
    FLEX(0),
    NONE(1);
    
    private final int mIntValue;

    YogaDisplay(int i) {
        this.mIntValue = i;
    }

    public static YogaDisplay fromInt(int i) {
        if (i != 0) {
            if (i == 1) {
                return NONE;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return FLEX;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
