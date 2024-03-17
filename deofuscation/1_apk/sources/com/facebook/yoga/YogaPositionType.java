package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaPositionType {
    RELATIVE(0),
    ABSOLUTE(1);
    
    private final int mIntValue;

    YogaPositionType(int i) {
        this.mIntValue = i;
    }

    public static YogaPositionType fromInt(int i) {
        if (i != 0) {
            if (i == 1) {
                return ABSOLUTE;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return RELATIVE;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
