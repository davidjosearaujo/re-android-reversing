package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.b0.u;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LiveHeartbeatData implements JsonInterface {
    private static final long serialVersionUID = 7893345860521822983L;
    private String abroad;
    public String act;
    public String activeid;
    public int ap;
    private String aver;
    public String bid;
    public long cflow;
    private String ch;
    public int cpn;
    public int ct;
    public int def;
    private String did;
    public int et;
    public String fpid;
    public String fpn;
    public String fr;
    private String gps;
    public int ht;
    public int idx;
    public int isad;
    public int lid;
    public String liveid;
    private int net;
    public String ntime;
    private String oaid;
    public String paid;
    private String patver;
    public int pay;
    public long pflow;
    public String plid;
    public int pt;
    public String rch;
    public String rdc;
    public String sid;
    private String src;
    public String suuid;
    private String sver;
    private String svid;
    public int td;
    public long tflow;
    private String uuid;
    private int uvip;
    public String vid;
    private String time = l.p(System.currentTimeMillis());
    private String mf = e.P();
    private String mod = e.Q();
    public String pver = "";

    public LiveHeartbeatData() {
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
        setBid("2.1.1.1");
        setUvip(b.c().e() ? 1 : 0);
        setAbroad(j.l.a.k.b.b());
        setSrc(e.g0());
        setNtime(Long.toString(System.currentTimeMillis()));
        setPaid(a.a().E);
        this.rdc = a.a().d();
        this.rch = a.a().c();
    }

    public String getAbroad() {
        return this.abroad;
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

    public int getLid() {
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

    public String getPaid() {
        return this.paid;
    }

    public String getPatver() {
        return this.patver;
    }

    public int getPay() {
        return this.pay;
    }

    public int getPt() {
        return this.pt;
    }

    public String getPver() {
        return this.pver;
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

    public void setCt(int i) {
        this.ct = i;
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

    public void setLid(int i) {
        this.lid = i;
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

    public void setPaid(String str) {
        this.paid = str;
    }

    public void setPatver(String str) {
        this.patver = str;
    }

    public void setPay(int i) {
        this.pay = i;
    }

    public void setPt(int i) {
        this.pt = i;
    }

    public void setPver(String str) {
        this.pver = str;
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
