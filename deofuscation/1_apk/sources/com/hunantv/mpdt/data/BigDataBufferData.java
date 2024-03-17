package com.hunantv.mpdt.data;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.hunantv.imgo.net.RequestParams;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class BigDataBufferData extends CommonData {
    private static final long serialVersionUID = 2759284958750031422L;
    private String act;
    private int bdid;
    private int bftype;
    private int bsid;
    private int cf;
    private int cpn;
    private int ct;
    private int def;
    private int idx;
    private int istry;
    private int pay;
    private int pt;
    private String suuid;
    private int td;
    private int vid;
    private int vts;
    private String cid = "";
    private String plid = "";
    private int ap = 1;

    public BigDataBufferData(String str, String str2) {
        setAct("buffer");
        setSuuid(a.a().f);
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

    public int getBftype() {
        return this.bftype;
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

    public RequestParams getRequestParams(Context context) {
        RequestParams createBaseRequestParams = createBaseRequestParams();
        createBaseRequestParams.put("pay", this.pay);
        createBaseRequestParams.put("def", this.def);
        createBaseRequestParams.put("act", this.act);
        createBaseRequestParams.put("vid", this.vid);
        createBaseRequestParams.put("plid", this.plid);
        createBaseRequestParams.put(UserDataStore.CITY, this.ct);
        createBaseRequestParams.put("cid", this.cid);
        createBaseRequestParams.put("idx", this.idx);
        createBaseRequestParams.put("istry", this.istry);
        createBaseRequestParams.put("pt", this.pt);
        createBaseRequestParams.put("cf", this.cf);
        createBaseRequestParams.put("vts", this.vts);
        createBaseRequestParams.put("bdid", this.bdid);
        createBaseRequestParams.put("ap", this.ap);
        createBaseRequestParams.put("td", this.td);
        createBaseRequestParams.put("bftype", this.bftype);
        createBaseRequestParams.put("suuid", this.suuid);
        createBaseRequestParams.put("bsid", this.bsid);
        createBaseRequestParams.put("cpn", this.cpn);
        return createBaseRequestParams;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public int getTd() {
        return this.td;
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

    public void setBftype(int i) {
        this.bftype = i;
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

    public void setTd(int i) {
        this.td = i;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVts(int i) {
        this.vts = i;
    }
}
