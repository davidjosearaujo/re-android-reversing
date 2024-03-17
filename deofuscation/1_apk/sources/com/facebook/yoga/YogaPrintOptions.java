package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum YogaPrintOptions {
    LAYOUT(1),
    STYLE(2),
    CHILDREN(4);
    
    private final int mIntValue;

    YogaPrintOptions(int i) {
        this.mIntValue = i;
    }

    public static YogaPrintOptions fromInt(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i == 4) {
                    return CHILDREN;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i);
            }
            return STYLE;
        }
        return LAYOUT;
    }

    public int intValue() {
        return this.mIntValue;
    }
}
