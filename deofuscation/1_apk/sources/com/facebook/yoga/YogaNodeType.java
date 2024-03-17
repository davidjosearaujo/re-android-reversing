package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaNodeType {
    DEFAULT(0),
    TEXT(1);
    
    private final int mIntValue;

    YogaNodeType(int i) {
        this.mIntValue = i;
    }

    public static YogaNodeType fromInt(int i) {
        if (i != 0) {
            if (i == 1) {
                return TEXT;
            }
            throw new IllegalArgumentException("Unknown enum value: " + i);
        }
        return DEFAULT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
