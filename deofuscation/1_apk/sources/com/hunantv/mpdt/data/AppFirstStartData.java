package com.hunantv.mpdt.data;

import com.hunantv.imgo.net.RequestParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AppFirstStartData extends CommonData {
    private static final long serialVersionUID = -2654206956622976248L;
    private String itime;
    private String sttime;
    private String utime;

    public AppFirstStartData(String str, String str2, String str3) {
        this.itime = str;
        this.utime = str2;
        this.sttime = str3;
    }

    public RequestParams createRequestParams() {
        RequestParams createBaseRequestParams = super.createBaseRequestParams();
        createBaseRequestParams.put("act", "st");
        createBaseRequestParams.put("bid", "3.1.34");
        createBaseRequestParams.put("bdsv", "");
        createBaseRequestParams.put("itime", this.itime);
        createBaseRequestParams.put("utime", this.utime);
        createBaseRequestParams.put("sttime", this.sttime);
        return createBaseRequestParams;
    }
}
