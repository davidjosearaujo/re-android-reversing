package com.hunantv.mpdt.data;

import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.f0;
import j.l.a.b0.l;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CommonData implements JsonInterface {
    private static final long serialVersionUID = -5593787598395089849L;
    public String abroad;
    public String agemod;
    public String aver;
    public String ch;
    public String did;
    private String gaid;
    private String gch;
    public String guid;
    public int net;
    public String ntime;
    public String oaid;
    public int p2p;
    public String paid;
    public String patver;
    public String rch;
    public String rdc;
    public String rpa;
    public String runsid;
    public String sid;
    public String src;
    public String sver;
    public String syslang;
    public String uuid;
    public int uvip;
    public String time = l.p(System.currentTimeMillis());
    public int isdebug = 0;
    public String mf = e.P();
    public String mod = e.Q();

    public CommonData() {
        setTime(l.p(System.currentTimeMillis()));
        setGuid(e.A());
        setDid(e.x());
        setUuid(e.v0());
        setSid(PVSourceEvent.i());
        setNet(b0.b());
        setIsdebug(j.l.a.k.e.W ? 1 : 0);
        setMf(e.P());
        setMod(e.Q());
        setSver(e.Z());
        setAver(e.D0());
        setPatchver(e.G0());
        setCh(e.n());
        setOaid(e.U());
        setUvip(b.c().e() ? 1 : 0);
        setAbroad(j.l.a.k.b.b());
        setP2p(j.l.a.k.e.H ? 1 : 0);
        setRunsid(a.a().g);
        setSrc(e.g0());
        setNtime("" + System.currentTimeMillis());
        setPaid(a.a().E);
        setRdc(a.a().d());
        setRch(a.a().c());
        setRpa(a.a().N);
        setAgemod(String.valueOf(AgeDataModel.b().a().ordinal()));
        setGaid(e.C());
        setGch(f0.m("google_install_from_source"));
        setSyslang(j.l.a.k.b.c());
    }

    public RequestParams createBaseRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(CrashHianalyticsData.TIME, this.time);
        requestParams.put("uuid", this.uuid);
        requestParams.put("ch", this.ch);
        requestParams.put("did", this.did);
        requestParams.put("mod", this.mod);
        requestParams.put("mf", this.mf);
        requestParams.put("aver", this.aver);
        requestParams.put("patver", this.patver);
        requestParams.put("sver", this.sver);
        requestParams.put("oaid", this.oaid);
        requestParams.put("rdc", this.rdc);
        requestParams.put("rch", this.rch);
        requestParams.put("uvip", this.uvip);
        requestParams.put("guid", this.guid);
        requestParams.put("sid", this.sid);
        requestParams.put(com.alipay.sdk.app.statistic.b.k, this.net);
        requestParams.put("isdebug", this.isdebug);
        requestParams.put("uvip", this.uvip);
        requestParams.put("abroad", this.abroad);
        requestParams.put("runsid", this.runsid);
        requestParams.put("p2p", this.p2p);
        requestParams.put("src", this.src);
        if (TextUtils.isEmpty(a.a().E)) {
            a.a().E = UUID.randomUUID().toString();
        }
        requestParams.put("paid", a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        requestParams.put("rdc", this.rdc);
        requestParams.put("rch", this.rch);
        requestParams.put("rpa", this.rpa);
        requestParams.put("agemod", this.agemod);
        requestParams.put("gch", this.gch);
        requestParams.put("gaid", this.gaid);
        requestParams.put("syslang", this.syslang);
        return requestParams;
    }

    public String getAbroad() {
        return this.abroad;
    }

    public String getAgemod() {
        return this.agemod;
    }

    public String getAver() {
        return this.aver;
    }

    public String getCh() {
        return this.ch;
    }

    public String getDid() {
        return this.did;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getGch() {
        return this.gch;
    }

    public String getGuid() {
        return this.guid;
    }

    public int getIsdebug() {
        return this.isdebug;
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

    public String getPatchver() {
        return this.patver;
    }

    public String getRch() {
        return this.rch;
    }

    public String getRdc() {
        return this.rdc;
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

    public String getSrc() {
        return this.src;
    }

    public String getSver() {
        return this.sver;
    }

    public String getSyslang() {
        return this.syslang;
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

    public void setAgemod(String str) {
        this.agemod = str;
    }

    public void setAver(String str) {
        this.aver = str;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setGaid(String str) {
        this.gaid = str;
    }

    public void setGch(String str) {
        this.gch = str;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setIsdebug(int i) {
        this.isdebug = i;
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

    public void setPatchver(String str) {
        this.patver = str;
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

    public void setSrc(String str) {
        this.src = str;
    }

    public void setSver(String str) {
        this.sver = str;
    }

    public void setSyslang(String str) {
        this.syslang = str;
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
