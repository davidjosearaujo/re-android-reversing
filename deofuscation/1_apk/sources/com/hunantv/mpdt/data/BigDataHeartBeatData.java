package com.hunantv.mpdt.data;

import com.hunantv.imgo.net.RequestParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BigDataHeartBeatData extends CommonData {
    private static final long serialVersionUID = -3647116693246074572L;
    private String act;
    private int ap;
    private int bdid;
    private int cf;
    private int ct;
    private int def;
    private int ht;
    private int idx;
    private int istry;
    private int pay;
    private int pt;
    private String suuid;
    private int vid;
    private int vts;
    private String cid = "";
    private String plid = "";

    public BigDataHeartBeatData(String str, String str2) {
        setAct("hb");
        setCh(str);
        setUuid(str2);
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

    public int getCf() {
        return this.cf;
    }

    public String getCid() {
        return this.cid;
    }

    public int getCt() {
        return this.ct;
    }

    public int getDef() {
        return this.def;
    }

    public int getHt() {
        return this.ht;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getIstry() {
        return this.istry;
    }

    public int getPay() {
        return this.pay;
    }

    public String getPlid() {
        return this.plid;
    }

    public int getPt() {
        return this.pt;
    }

    public RequestParams getRequestParams() {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("act", this.act);
        return createBaseRequestParams;
    }

    public String getSuuid() {
        return this.suuid;
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

    public void setCf(int i) {
        this.cf = i;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCt(int i) {
        this.ct = i;
    }

    public void setDef(int i) {
        this.def = i;
    }

    public void setHt(int i) {
        this.ht = i;
    }

    public void setIdx(int i) {
        this.idx = i;
    }

    public void setIstry(int i) {
        this.istry = i;
    }

    public void setPay(int i) {
        this.pay = i;
    }

    public void setPlid(String str) {
        this.plid = str;
    }

    public void setPt(int i) {
        this.pt = i;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVts(int i) {
        this.vts = i;
    }
}
