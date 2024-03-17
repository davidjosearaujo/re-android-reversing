package com.hunantv.mpdt.data;

import android.text.TextUtils;
import j.l.a.b0.e;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VodAPlayData extends CommonData {
    private static final long serialVersionUID = 4647207532311717671L;
    private String abt;
    private int acp;
    private String act;
    private int ap;
    private String bdid;
    private String bid;
    private String bsid;
    private String colid;
    private String cpn;
    private int ct;
    private String datano;
    private int def;
    private int et;
    private String fpa;
    private String fpid;
    private String fpn;
    private int isad;
    private int isdrm;
    private int istry;
    private String lid;
    private String lob;
    public String maid;
    private String mdid;
    private int pay;
    private int pt;
    private String ra;
    private String ref;
    private String refmdid;
    private String sobody;
    public String svid;
    private int td;
    private String tid;
    private String tk;
    private String vid;
    private int idx = 0;
    private String suuid = "";
    private String url = "";
    private String plid = "";
    private String cid = "";
    private String cdnip = "";
    private String idfa = "";

    public VodAPlayData() {
    }

    public String getAbt() {
        return this.abt;
    }

    public int getAcp() {
        return this.acp;
    }

    public String getAct() {
        return this.act;
    }

    public int getAp() {
        return this.ap;
    }

    public String getBdid() {
        return this.bdid;
    }

    public String getBid() {
        return this.bid;
    }

    public String getBsid() {
        return this.bsid;
    }

    public String getCdnip() {
        return this.cdnip;
    }

    public String getCid() {
        return this.cid;
    }

    public String getColid() {
        return this.colid;
    }

    public String getCpn() {
        return this.cpn;
    }

    public int getCt() {
        return this.ct;
    }

    public String getDatano() {
        return this.datano;
    }

    public int getDef() {
        return this.def;
    }

    public int getEt() {
        return this.et;
    }

    public String getFpa() {
        return this.fpa;
    }

    public String getFpid() {
        return this.fpid;
    }

    public String getFpn() {
        return this.fpn;
    }

    public String getIdfa() {
        return this.idfa;
    }

    public int getIdx() {
        return this.idx;
    }

    public int getIsad() {
        return this.isad;
    }

    public int getIsdrm() {
        return this.isdrm;
    }

    public int getIstry() {
        return this.istry;
    }

    public String getLid() {
        return this.lid;
    }

    public String getLob() {
        return this.lob;
    }

    public String getMdid() {
        return this.mdid;
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

    public String getRa() {
        return this.ra;
    }

    public String getRef() {
        return this.ref;
    }

    public String getRefmdid() {
        return this.refmdid;
    }

    public String getSobody() {
        return this.sobody;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public String getSvid() {
        return this.svid;
    }

    public int getTd() {
        return this.td;
    }

    public String getTid() {
        return this.tid;
    }

    public String getTk() {
        return this.tk;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVid() {
        return this.vid;
    }

    public void setAbt(String str) {
        this.abt = str;
    }

    public void setAcp(int i) {
        this.acp = i;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAp(int i) {
        this.ap = i;
    }

    public void setBdid(String str) {
        this.bdid = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setBsid(String str) {
        this.bsid = str;
    }

    public void setCdnip(String str) {
        this.cdnip = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setColid(String str) {
        this.colid = str;
    }

    public void setCpn(String str) {
        this.cpn = str;
    }

    public void setCt(int i) {
        this.ct = i;
    }

    public void setDatano(String str) {
        this.datano = str;
        if (TextUtils.isEmpty(str)) {
            this.datano = "";
        }
    }

    public void setDef(int i) {
        this.def = i;
    }

    public void setEt(int i) {
        this.et = i;
    }

    public void setFpa(String str) {
        this.fpa = str;
    }

    public void setFpid(String str) {
        this.fpid = str;
    }

    public void setFpn(String str) {
        this.fpn = str;
    }

    public void setIdfa(String str) {
        this.idfa = str;
    }

    public void setIdx(int i) {
        this.idx = i;
    }

    public void setIsad(int i) {
        this.isad = i;
    }

    public void setIsdrm(int i) {
        this.isdrm = i;
    }

    public void setIstry(int i) {
        this.istry = i;
    }

    public void setLid(String str) {
        this.lid = str;
    }

    public void setLob(String str) {
        this.lob = str;
    }

    public void setMdid(String str) {
        this.mdid = str;
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

    public void setRa(String str) {
        this.ra = str;
    }

    public void setRef(String str) {
        this.ref = str;
    }

    public void setRefmdid(String str) {
        this.refmdid = str;
        if (TextUtils.isEmpty(str)) {
            this.refmdid = "";
        }
    }

    public void setSobody(String str) {
        this.sobody = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setSvid(String str) {
        this.svid = str;
    }

    public void setTd(int i) {
        this.td = i;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setTk(String str) {
        this.tk = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public VodAPlayData(boolean z) {
        setSuuid(a.a().f);
        setRef("");
        setBid("2.1.1");
        setP2p(z ? 1 : 0);
        setDatano("");
        setRefmdid("");
        setPatchver(e.G0());
    }
}
