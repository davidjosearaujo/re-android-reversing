package cn.com.custommma.mobile.tracking.viewability.origin.sniffer;

import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public enum AbilityVideoProgress {
    TRACK1_4("25"),
    TRACK2_4("50"),
    TRACK3_4(PVSourceEvent.e0),
    TRACK4_4("100");
    
    private String value;

    AbilityVideoProgress(String str) {
        this.value = "";
        this.value = str;
    }

    public String value() {
        return this.value;
    }
}
