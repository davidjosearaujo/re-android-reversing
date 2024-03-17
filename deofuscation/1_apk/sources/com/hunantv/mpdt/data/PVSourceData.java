package com.hunantv.mpdt.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.b0.u;
import j.l.c.x.p0.b;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PVSourceData implements JsonInterface {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
    private static final long serialVersionUID = -1923998455205149711L;
    private String abroad;
    private String abt;
    private String act;
    public String agemod;
    private int auto;
    private String av;
    private String bdid;
    private String bsid;
    private String ch;
    private String cma;
    private String ctl;
    private String datano;
    private String did;
    private String fpa;
    private String fpt;
    private int fsf;
    private String ftl;
    private String gps;
    private String guid;
    private int isfull;
    private String lob;
    private int nt;
    private String ntime;
    private String oaid;
    private String paid;
    private String patver;
    private String pt;
    private String rch;
    private String rdc;
    private String refmdid;
    private String rpa;
    private String sid;
    private String skw;
    public String sobody;
    private String spid;
    private String src;
    private String stid;
    private String sv;
    private String uuid;
    private int uvip;
    private String t = l.n(System.currentTimeMillis());
    private int tst = 0;
    private String mf = e.P();
    private String md = e.Q();
    private String fpn = "";
    private String fpid = "";
    private String cpn = "";
    private String cpid = "'";
    private String cid = "";
    private String plid = "";
    private String runsid = "";
    private String idfa = "";

    public PVSourceData() {
    }

    private String isNull(String str) {
        return str == null ? "" : str;
    }

    public String getAbroad() {
        return this.abroad;
    }

    public String getAbt() {
        return this.abt;
    }

    public String getAct() {
        return this.act;
    }

    public String getAgemod() {
        return this.agemod;
    }

    public int getAuto() {
        return this.auto;
    }

    public String getAv() {
        return this.av;
    }

    public String getBdid() {
        return this.bdid;
    }

    public String getBsid() {
        return this.bsid;
    }

    public String getCh() {
        return this.ch;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCma() {
        return this.cma;
    }

    public String getCpid() {
        return this.cpid;
    }

    public String getCpn() {
        return this.cpn;
    }

    public String getCtl() {
        return this.ctl;
    }

    public String getDataNo() {
        return this.datano;
    }

    public String getDid() {
        return this.did;
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

    public String getFpt() {
        return this.fpt;
    }

    public int getFsf() {
        return this.fsf;
    }

    public String getFtl() {
        return this.ftl;
    }

    public String getGps() {
        return this.gps;
    }

    public String getGuid() {
        return this.guid;
    }

    public int getIsfull() {
        return this.isfull;
    }

    public String getLob() {
        return this.lob;
    }

    public String getMd() {
        return this.md;
    }

    public String getMf() {
        return this.mf;
    }

    public String getModuleid() {
        return this.refmdid;
    }

    public int getNt() {
        return this.nt;
    }

    public String getNtime() {
        return this.ntime;
    }

    public String getPaid() {
        return this.paid;
    }

    public String getPatver() {
        return this.patver;
    }

    public String getPlid() {
        return this.plid;
    }

    public String getPt() {
        return this.pt;
    }

    public String getRch() {
        return this.rch;
    }

    public String getRdc() {
        return this.rdc;
    }

    public RequestParams getRequestParams(Context context) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("t", isNull(this.t));
        requestParams.put("guid", isNull(this.guid));
        requestParams.put("did", isNull(this.did));
        requestParams.put("uuid", isNull(this.uuid));
        requestParams.put("nt", this.nt);
        requestParams.put("tst", j.l.a.k.e.W ? 1 : 0);
        requestParams.put("mf", isNull(this.mf));
        requestParams.put("md", isNull(this.md));
        requestParams.put(a.q, isNull(this.sv));
        requestParams.put(a.t, isNull(this.av));
        requestParams.put("patver", isNull(this.patver));
        requestParams.put("ch", isNull(this.ch));
        requestParams.put("act", isNull(this.act));
        requestParams.put("sid", isNull(this.sid));
        requestParams.put("fpn", isNull(this.fpn));
        requestParams.put("fpid", isNull(this.fpid));
        requestParams.put("cpn", isNull(this.cpn));
        requestParams.put("cpid", isNull(this.cpid));
        requestParams.put("cid", isNull(this.cid));
        requestParams.put("plid", isNull(this.plid));
        requestParams.put("fpa", this.fpa);
        requestParams.put("cma", this.cma);
        requestParams.put("ftl", this.ftl);
        requestParams.put("ctl", this.ctl);
        requestParams.put("fpt", this.fpt);
        requestParams.put("pt", this.pt);
        requestParams.put("bdid", this.bdid);
        requestParams.put("bsid", this.bsid);
        requestParams.put("runsid", this.runsid);
        requestParams.put("idfa", this.idfa);
        requestParams.put("uvip", this.uvip);
        requestParams.put("stid", isNull(this.stid));
        requestParams.put("abroad", this.abroad);
        requestParams.put("spid", isNull(this.spid));
        requestParams.put("rdc", isNull(this.rdc));
        requestParams.put("rch", isNull(this.rch));
        requestParams.put("datano", isNull(this.datano));
        requestParams.put("refmdid", isNull(this.refmdid));
        requestParams.put("isfull", this.isfull);
        requestParams.put("src", this.src);
        requestParams.put("skw", this.skw);
        requestParams.put("auto", this.auto);
        requestParams.put("fsf", this.fsf);
        requestParams.put("abt", this.abt);
        requestParams.put("oaid", this.oaid);
        requestParams.put("paid", j.l.c.x.t0.a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        requestParams.put("rpa", isNull(this.rpa));
        requestParams.put("agemod", this.agemod);
        if (!TextUtils.isEmpty(this.sobody)) {
            requestParams.put("sobody", this.sobody);
        }
        if (!TextUtils.isEmpty(this.lob)) {
            requestParams.put("lob", this.lob);
        }
        return requestParams;
    }

    public String getRpa() {
        return this.rpa;
    }

    public String getRunsid() {
        return this.runsid;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSkw() {
        return this.skw;
    }

    public String getSpid() {
        return this.spid;
    }

    public String getSrc() {
        return this.src;
    }

    public String getStid() {
        return this.stid;
    }

    public String getSv() {
        return this.sv;
    }

    public String getT() {
        return this.t;
    }

    public int getTst() {
        return this.tst;
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

    public void setAbt(String str) {
        this.abt = str;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAgemod(String str) {
        this.agemod = str;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public void setAv(String str) {
        this.av = str;
    }

    public void setBdid(String str) {
        this.bdid = str;
    }

    public void setBsid(String str) {
        this.bsid = str;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCma(String str) {
        this.cma = str;
    }

    public void setCpid(String str) {
        this.cpid = str;
    }

    public void setCpn(String str) {
        this.cpn = str;
    }

    public void setCtl(String str) {
        this.ctl = str;
    }

    public void setDataNo(String str) {
        this.datano = str;
    }

    public void setDid(String str) {
        this.did = str;
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

    public void setFpt(String str) {
        this.fpt = str;
    }

    public void setFsf(int i) {
        this.fsf = i;
    }

    public void setFtl(String str) {
        this.ftl = str;
    }

    public void setGps(String str) {
        this.gps = str;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setIsfull(int i) {
        this.isfull = i;
    }

    public void setLob(String str) {
        this.lob = str;
    }

    public void setMd(String str) {
        this.md = this.md;
    }

    public void setMf(String str) {
        this.mf = str;
    }

    public void setModuleid(String str) {
        this.refmdid = str;
    }

    public void setNt(int i) {
        this.nt = i;
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

    public void setPlid(String str) {
        this.plid = str;
    }

    public void setPt(String str) {
        this.pt = str;
    }

    public void setRch(String str) {
        this.rch = str;
    }

    public void setRdc(String str) {
        this.rdc = str;
    }

    public void setRpa(String str) {
        this.rpa = str;
    }

    public void setRunsid(String str) {
        this.runsid = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSkw(String str) {
        this.skw = str;
    }

    public void setSpid(String str) {
        this.spid = str;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setStid(String str) {
        this.stid = str;
    }

    public void setSv(String str) {
        this.sv = str;
    }

    public void setT(String str) {
        this.t = str;
    }

    public void setTst(int i) {
        this.tst = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setUvip(int i) {
        this.uvip = i;
    }

    public PVSourceData(Context context) {
        if (!j.l.c.x.t0.a.a().D) {
            j.l.c.x.t0.a.a().E = UUID.randomUUID().toString();
        }
        j.l.c.x.t0.a.a().D = false;
        setAct("pvs");
        setGuid(e.A());
        setDid(e.x());
        setOaid(e.U());
        setNt(b0.b());
        setSv(e.Z());
        setAv(e.D0());
        setPatver(e.G0());
        setGps(u.e().f());
        setCh(e.n());
        setUuid(e.v0());
        setMf(e.P());
        setMd(e.Q());
        setT(l.i(dateFormat));
        setTst(j.l.a.k.e.W ? 1 : 0);
        setUvip(b.c().e() ? 1 : 0);
        setStid(j.l.c.x.t0.a.a().a);
        setAbroad(j.l.a.k.b.b());
        setSpid(b.c().b());
        setRdc(j.l.c.x.t0.a.a().d());
        setRch(j.l.c.x.t0.a.a().c());
        setSrc(e.g0());
        setRpa(j.l.c.x.t0.a.a().N);
        setAgemod(String.valueOf(AgeDataModel.b().a().ordinal()));
    }
}
