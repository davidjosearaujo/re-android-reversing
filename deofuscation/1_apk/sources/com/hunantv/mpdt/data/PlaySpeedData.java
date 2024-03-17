package com.hunantv.mpdt.data;

import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.net.RequestParams;
import j.l.a.b0.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlaySpeedData extends CommonData {
    public static final int ISFF_FORWARD = 2;
    public static final int ISFF_REVERSE = 1;
    public static final int PS_CLICK = 1;
    public static final int PS_TOUCH = 2;
    public static final int VALUE_0_25 = 0;
    public static final int VALUE_0_5 = 1;
    public static final int VALUE_1_25 = 2;
    public static final int VALUE_1_5 = 3;
    public static final int VALUE_2_0 = 4;
    private static final long serialVersionUID = 2920105572027642009L;
    private String act = "quicken";
    private int ap;
    private int bdid;
    private int bsid;
    private int cf;
    private String cid;
    private int cpn;
    private int ct;
    private int def;
    private int et;
    private int fs;
    private int idx;
    private int isff;
    private int istry;
    private int pay;
    private int plid;
    private int ps;
    private int pt;
    private String purl;
    private String suuid;
    private int td;
    private String url;
    private int value;
    private int vid;
    private int vts;

    public void buildData() {
    }

    public String getAct() {
        return this.act;
    }

    public int getAp() {
        return this.ap;
    }

    public int getBdid() {
        return this.bdid;
    }

    public int getBsid() {
        return this.bsid;
    }

    public int getCf() {
        return this.cf;
    }

    public String getCid() {
        return this.cid;
    }

    public int getCpn() {
        return this.cpn;
    }

    public int getCt() {
        return this.ct;
    }

    public int getDef() {
        return this.def;
    }

    public int getEt() {
        return this.et;
    }

    public int getFs() {
        return this.fs;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getIsff() {
        return this.isff;
    }

    public int getIstry() {
        return this.istry;
    }

    public int getPay() {
        return this.pay;
    }

    public int getPlid() {
        return this.plid;
    }

    public int getPs() {
        return this.ps;
    }

    public int getPt() {
        return this.pt;
    }

    public String getPurl() {
        return this.purl;
    }

    public RequestParams getRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(CrashHianalyticsData.TIME, this.time);
        requestParams.put("guid", this.guid);
        requestParams.put("did", this.did);
        requestParams.put("oaid", e.U());
        requestParams.put("uuid", this.uuid);
        requestParams.put("isdebug", this.isdebug);
        requestParams.put("aver", this.aver);
        requestParams.put("patver", this.patver);
        requestParams.put("ch", this.ch);
        requestParams.put("act", this.act);
        requestParams.put("idx", this.idx);
        requestParams.put("ps", this.ps);
        requestParams.put(SDKConstants.PARAM_VALUE, this.value);
        requestParams.put(UserDataStore.CITY, this.ct);
        requestParams.put("et", this.et);
        requestParams.put("td", this.td);
        requestParams.put("suuid", this.suuid);
        requestParams.put("url", this.url);
        requestParams.put("vid", this.vid);
        requestParams.put("bdid", this.bdid);
        requestParams.put("plid", this.plid);
        requestParams.put("bsid", this.bsid);
        requestParams.put("cid", this.cid);
        requestParams.put("cpn", this.cpn);
        requestParams.put("purl", this.purl);
        requestParams.put("ap", this.ap);
        requestParams.put("pt", this.pt);
        requestParams.put("pay", this.pay);
        requestParams.put("def", this.def);
        requestParams.put("istry", this.istry);
        requestParams.put("fs", this.fs);
        requestParams.put("cf", this.cf);
        requestParams.put("vts", this.vts);
        requestParams.put("abroad", this.abroad);
        requestParams.put("isff", this.isff);
        requestParams.put("bid", "2.5.3");
        return requestParams;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public int getTd() {
        return this.td;
    }

    public String getUrl() {
        return this.url;
    }

    public int getValue() {
        return this.value;
    }

    public int getVid() {
        return this.vid;
    }

    public int getVts() {
        return this.vts;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAp(int i) {
        this.ap = i;
    }

    public void setBdid(int i) {
        this.bdid = i;
    }

    public void setBsid(int i) {
        this.bsid = i;
    }

    public void setCf(int i) {
        this.cf = i;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCpn(int i) {
        this.cpn = i;
    }

    public void setCt(int i) {
        this.ct = i;
    }

    public void setDef(int i) {
        this.def = i;
    }

    public void setEt(int i) {
        this.et = i;
    }

    public void setFs(int i) {
        this.fs = i;
    }

    public void setIdx(int i) {
        this.idx = i;
    }

    public void setIsff(int i) {
        this.isff = i;
    }

    public void setIstry(int i) {
        this.istry = i;
    }

    public void setPay(int i) {
        this.pay = i;
    }

    public void setPlid(int i) {
        this.plid = i;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setPt(int i) {
        this.pt = i;
    }

    public void setPurl(String str) {
        this.purl = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setTd(int i) {
        this.td = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVts(int i) {
        this.vts = i;
    }
}
