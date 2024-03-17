package com.hunantv.mpdt.data;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.vod.ImgoErrorStatisticsData;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.v.j.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SystemErrorData implements JsonInterface {
    public static final String SE_BID = "2.13.20";
    private static final long serialVersionUID = 4853347846990031246L;
    public String ed;
    public String act = CrashHianalyticsData.EVENT_ID_CRASH;
    public String ec = ImgoErrorStatisticsData.C_CATCH_EXCEPTION;
    public String et = l.n(System.currentTimeMillis());
    public String bid = SE_BID;
    public String did = e.x();
    public String oaid = e.U();
    public String av = e.C0();
    public String sv = e.Z();
    private String patver = e.G0();

    public SystemErrorData(String str) {
        this.ed = str;
    }

    public String toString() {
        return b.F(this, SystemErrorData.class);
    }
}
