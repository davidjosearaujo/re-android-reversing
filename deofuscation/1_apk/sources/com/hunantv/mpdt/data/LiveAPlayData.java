package com.hunantv.mpdt.data;

import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.b0.u;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LiveAPlayData implements JsonInterface {
    private static final long serialVersionUID = 1354655551136939656L;
    private String abroad;
    private int acp;
    private String act;
    private String activeid;
    private int ap;
    private String aver;
    private String bid;
    private String ch;
    public int cpn;
    private int ct;
    private String datano;
    private int def;
    private String did;
    private int et;
    private String fpid;
    private String fpn;
    public String fr;
    private String gps;
    public int ht;
    public int isad;
    private String liveid;
    private int net;
    public String ntime;
    private String oaid;
    private int p2p;
    public String paid;
    private String patver;
    private int pay;
    private String plid;
    private int pt;
    private String pver;
    private String ra;
    private String rch;
    private String rdc;
    private String refmdid;
    private String runsid;
    private String sid;
    private String src;
    private String suuid;
    private String sver;
    private String svid;
    private int td;
    private String uuid;
    private int uvip;
    public String vid;
    private String time = l.p(System.currentTimeMillis());
    private String mf = e.P();
    private String mod = e.Q();
    private int idx = 0;
    private String lid = "";

    public LiveAPlayData() {
        setTime(l.p(System.currentTimeMillis()));
        setDid(e.x());
        setNet(b0.b());
        setMf(e.P());
        setMod(e.Q());
        setSver(e.Z());
        setAver(e.C0());
        setPatver(e.G0());
        setGps(u.e().f());
        setOaid(e.U());
        setUuid(e.v0());
        setCh(e.n());
        setSuuid(UUID.randomUUID().toString());
        setSid(PVSourceEvent.i());
        setUvip(b.c().e() ? 1 : 0);
        setAbroad(j.l.a.k.b.b());
        setSrc(e.g0());
        setNtime(Long.toString(System.currentTimeMillis()));
        setPaid(a.a().E);
        setRdc(a.a().d());
        setRch(a.a().c());
    }

    public String getAbroad() {
        return this.abroad;
    }

    public int getAcp() {
        return this.acp;
    }

    public String getAct() {
        return this.act;
    }

    public String getActiveid() {
        return this.activeid;
    }

    public int getAp() {
        return this.ap;
    }

    public String getAver() {
        return this.aver;
    }

    public String getBid() {
        return this.bid;
    }

    public String getCh() {
        return this.ch;
    }

    public int getCt() {
        return this.ct;
    }

    public String getDataNo() {
        return this.datano;
    }

    public String getDatano() {
        return this.datano;
    }

    public int getDef() {
        return this.def;
    }

    public String getDid() {
        return this.did;
    }

    public int getEt() {
        return this.et;
    }

    public String getFpid() {
        return this.fpid;
    }

    public String getFpn() {
        return this.fpn;
    }

    public String getGps() {
        return this.gps;
    }

    public int getIdx() {
        return this.idx;
    }

    public String getLid() {
        return this.lid;
    }

    public String getLiveid() {
        return this.liveid;
    }

    public String getMf() {
        return this.mf;
    }

    public String getMod() {
        return this.mod;
    }

    public int getNet() {
        return this.net;
    }

    public String getNtime() {
        return this.ntime;
    }

    public String getOaid() {
        return this.oaid;
    }

    public int getP2p() {
        return this.p2p;
    }

    public String getPaid() {
        return this.paid;
    }

    public String getPatver() {
        return this.patver;
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

    public String getPver() {
        return this.pver;
    }

    public String getRa() {
        return this.ra;
    }

    public String getRch() {
        return this.rch;
    }

    public String getRdc() {
        return this.rdc;
    }

    public String getRefmdid() {
        return this.refmdid;
    }

    public String getRunsid() {
        return this.runsid;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSrc() {
        return this.src;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public String getSver() {
        return this.sver;
    }

    public String getSvid() {
        return this.svid;
    }

    public int getTd() {
        return this.td;
    }

    public String getTime() {
        return this.time;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getUvip() {
        return this.uvip;
    }

    public void setAbroad(String str) {
        this.abroad = str;
    }

    public void setAcp(int i) {
        this.acp = i;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setActiveid(String str) {
        this.activeid = str;
    }

    public void setAp(int i) {
        this.ap = i;
    }

    public void setAver(String str) {
        this.aver = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public void setCpn(int i) {
        this.cpn = i;
    }

    public void setCt(int i) {
        this.ct = i;
    }

    public void setDataNo(String str) {
        this.datano = str;
    }

    public void setDatano(String str) {
        this.datano = str;
    }

    public void setDef(int i) {
        this.def = i;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setEt(int i) {
        this.et = i;
    }

    public void setFpid(String str) {
        this.fpid = str;
    }

    public void setFpn(String str) {
        this.fpn = str;
    }

    public void setGps(String str) {
        this.gps = str;
    }

    public void setIdx(int i) {
        this.idx = i;
    }

    public void setLid(String str) {
        this.lid = str;
    }

    public void setLiveid(String str) {
        this.liveid = str;
    }

    public void setMf(String str) {
        this.mf = str;
    }

    public void setMod(String str) {
        this.mod = str;
    }

    public void setNet(int i) {
        this.net = i;
    }

    public void setNtime(String str) {
        this.ntime = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setP2p(int i) {
        this.p2p = i;
    }

    public void setPaid(String str) {
        this.paid = str;
    }

    public void setPatver(String str) {
        this.patver = str;
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

    public void setPver(String str) {
        this.pver = str;
    }

    public void setRa(String str) {
        this.ra = str;
    }

    public void setRch(String str) {
        this.rch = str;
    }

    public void setRdc(String str) {
        this.rdc = str;
    }

    public void setRefmdid(String str) {
        this.refmdid = str;
    }

    public void setRunsid(String str) {
        this.runsid = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setSver(String str) {
        this.sver = str;
    }

    public void setSvid(String str) {
        this.svid = str;
    }

    public void setTd(int i) {
        this.td = i;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setUvip(int i) {
        this.uvip = i;
    }
}
