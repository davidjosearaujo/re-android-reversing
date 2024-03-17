package com.hunantv.mpdt.data;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.b0.u;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;
import j.v.e.a.e.n.j;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NewCommonData implements JsonInterface {
    private static final long serialVersionUID = -4360535689571513997L;
    public String abroad;
    private String agemod;
    public String bdsv;
    public String ch;
    public String did;
    public String gps;
    public int net;
    private String ntime;
    public String oaid;
    public int p2p;
    private String paid;
    private String patver;
    public String rch;
    public String rdc;
    public String runsid;
    public String sessionid;
    public String src;
    public String sver;
    public String uuid;
    public int uvip;
    public String ver;
    public String time = l.p(System.currentTimeMillis());
    public String mf = e.P();
    public String model = e.Q();

    public NewCommonData() {
        setTime(l.p(System.currentTimeMillis()));
        setDid(e.x());
        setOaid(e.U());
        setUuid(e.v0());
        setSid(PVSourceEvent.i());
        setNet(b0.b());
        setMf(e.P());
        setModel(e.Q());
        setSver(e.Z());
        setAver(e.D0());
        setPatver(e.G0());
        setGps(u.e().f());
        setCh(e.n());
        setUvip(b.c().e() ? 1 : 0);
        setAbroad(j.l.a.k.b.b());
        setP2p(j.l.a.k.e.H ? 1 : 0);
        setRunsid(PVSourceEvent.g());
        setSrc(e.g0());
        setAgemod(String.valueOf(AgeDataModel.b().a().ordinal()));
        setRdc(a.a().d());
        setRch(a.a().c());
    }

    public RequestParams createBaseRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(CrashHianalyticsData.TIME, this.time);
        requestParams.put("uuid", this.uuid);
        requestParams.put("ch", this.ch);
        requestParams.put("bdsv", j.c());
        requestParams.put("did", this.did);
        requestParams.put("oaid", this.oaid);
        requestParams.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.model);
        requestParams.put("mf", this.mf);
        requestParams.put("ver", this.ver);
        requestParams.put("patver", this.patver);
        requestParams.put("sver", this.sver);
        requestParams.put("rdc", this.rdc);
        requestParams.put("rch", this.rch);
        requestParams.put("uvip", this.uvip);
        requestParams.put("sessionid", this.sessionid);
        requestParams.put(com.alipay.sdk.app.statistic.b.k, this.net);
        requestParams.put("uvip", this.uvip);
        requestParams.put("abroad", this.abroad);
        requestParams.put("runsid", this.runsid);
        requestParams.put("p2p", this.p2p);
        requestParams.put("src", this.src);
        requestParams.put("paid", a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        requestParams.put("agemod", this.agemod);
        requestParams.put("oaid", e.U());
        return requestParams;
    }

    public String getAbroad() {
        return this.abroad;
    }

    public String getAgemod() {
        return this.agemod;
    }

    public String getAver() {
        return this.ver;
    }

    public String getCh() {
        return this.ch;
    }

    public String getDid() {
        return this.did;
    }

    public String getGps() {
        return this.gps;
    }

    public String getMf() {
        return this.mf;
    }

    public String getModel() {
        return this.model;
    }

    public int getNet() {
        return this.net;
    }

    public String getNtime() {
        return this.ntime;
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

    public String getRch() {
        return this.rch;
    }

    public String getRdc() {
        return this.rdc;
    }

    public String getRunsid() {
        return this.runsid;
    }

    public String getSid() {
        return this.sessionid;
    }

    public String getSrc() {
        return this.src;
    }

    public String getSver() {
        return this.sver;
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
        this.ver = str;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setGps(String str) {
        this.gps = str;
    }

    public void setMf(String str) {
        this.mf = str;
    }

    public void setModel(String str) {
        this.model = str;
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

    public void setRch(String str) {
        this.rch = str;
    }

    public void setRdc(String str) {
        this.rdc = str;
    }

    public void setRunsid(String str) {
        this.runsid = str;
    }

    public void setSid(String str) {
        this.sessionid = str;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setSver(String str) {
        this.sver = str;
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
