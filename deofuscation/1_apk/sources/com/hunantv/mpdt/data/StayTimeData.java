package com.hunantv.mpdt.data;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.hunantv.imgo.net.RequestParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class StayTimeData extends CommonData {
    private static final long serialVersionUID = 4563823960107756448L;
    private String cntp;
    private String cpid;
    private String fpid;
    private String lastp;
    public String lob;
    public long sptime;

    public StayTimeData(String str, String str2, String str3, String str4, long j, String str5) {
        this.cntp = str;
        this.cpid = str2;
        this.lastp = str3;
        this.fpid = str4;
        this.sptime = j;
        this.lob = str5;
    }

    public RequestParams createRequestParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("logtype", "stay");
        createBaseRequestParams.put("cntp", this.cntp);
        String str = this.cpid;
        if (str == null) {
            str = "";
        }
        createBaseRequestParams.put("cpid", str);
        String str2 = this.lastp;
        if (str2 == null) {
            str2 = "";
        }
        createBaseRequestParams.put("lastp", str2);
        String str3 = this.fpid;
        if (str3 == null) {
            str3 = "";
        }
        createBaseRequestParams.put("fpid", str3);
        createBaseRequestParams.put("sptime", this.sptime);
        String str4 = this.lob;
        createBaseRequestParams.put("lob", str4 != null ? str4 : "");
        createBaseRequestParams.put("sessionid", getSid());
        createBaseRequestParams.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, getMod());
        createBaseRequestParams.put("ver", getAver());
        createBaseRequestParams.put("patver", getPatchver());
        return createBaseRequestParams;
    }
}
