package com.hunantv.mpdt.statistics.flow;

import java.io.Serializable;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class FlowReportConfig implements Serializable {
    private static final long serialVersionUID = -8068609108543510190L;
    public String provider;
    public String sdkver;

    public FlowReportConfig(String str, String str2) {
        this.provider = str;
        this.sdkver = str2;
    }
}
