package com.hunantv.mpdt.data;

import com.facebook.appevents.UserDataStore;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.l;
import java.util.HashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BigDataOfflineBeatData implements JsonInterface {
    public String ap;
    public String bdid;
    public String bsid;
    public String cf;
    public String cpn;
    public String ct;
    public String def;
    public String istry;
    public String pay;
    public String pt;
    public String suuid;
    public String vid;
    public String vts;
    public String time = l.p(System.currentTimeMillis());
    private String act = "oflhb";
    private String bid = "2.3.10";
    public String cid = "";
    public String plid = "";

    public HashMap<String, String> createBaseOfflineRequestParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(CrashHianalyticsData.TIME, this.time);
        hashMap.put("act", this.act);
        hashMap.put("bid", this.bid);
        hashMap.put("pay", this.pay);
        hashMap.put("def", this.def);
        hashMap.put("vid", this.vid);
        hashMap.put("cid", this.cid);
        hashMap.put("plid", this.plid);
        hashMap.put("istry", this.istry);
        hashMap.put("pt", this.pt);
        hashMap.put("cf", this.cf);
        hashMap.put("vts", this.vts);
        hashMap.put("bdid", this.bdid);
        hashMap.put("ap", this.ap);
        hashMap.put("suuid", this.suuid);
        hashMap.put("bsid", this.bsid);
        hashMap.put("cpn", this.cpn);
        hashMap.put(UserDataStore.CITY, this.ct);
        return hashMap;
    }
}
