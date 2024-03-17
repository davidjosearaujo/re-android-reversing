package com.hunantv.imgo.global;

import j.l.a.b0.f0;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AgeDataModel {
    private static AgeDataModel b = null;
    public static final String c = "imgo_age_mode_state";
    private AGE_MODE_STATE a = AGE_MODE_STATE.values()[f0.h(c, 0)];

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public enum AGE_MODE_STATE {
        AGE_MODE_DEFAULT(0),
        AGE_MODE_TEENY(1),
        AGE_MODE_KID(2);
        
        public int mode;

        AGE_MODE_STATE(int i) {
            this.mode = i;
        }
    }

    private AgeDataModel() {
    }

    public static AgeDataModel b() {
        if (b == null) {
            b = new AgeDataModel();
        }
        return b;
    }

    public AGE_MODE_STATE a() {
        return this.a;
    }

    public boolean c() {
        return this.a == AGE_MODE_STATE.AGE_MODE_DEFAULT;
    }

    public boolean d() {
        return this.a != AGE_MODE_STATE.AGE_MODE_DEFAULT;
    }

    public void e(AGE_MODE_STATE age_mode_state) {
        f0.s(c, age_mode_state.ordinal());
        this.a = age_mode_state;
    }
}
