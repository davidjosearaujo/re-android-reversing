package com.hunantv.mpdt.data;

import com.hunantv.mpdt.data.EventClickData;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.b0.u;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class HPPlayRecordData implements JsonInterface {
    private static final long serialVersionUID = -2490606270553274233L;
    private String value;
    private String fpa = PVSourceEvent.C3;
    private String act = EventClickData.a.x;
    private String time = l.p(System.currentTimeMillis());
    private String guid = "";
    private String did = e.x();
    private String suuid = a.a().f;
    private String uuid = e.v0();
    private String sid = PVSourceEvent.i();
    private int net = b0.b();
    private int isdebug = j.l.a.k.e.W ? 1 : 0;
    private String mf = e.P();
    private String mod = e.Q();
    private String sver = e.Z();
    private String aver = e.C0();
    private String patver = e.G0();
    private String gps = u.e().f();
    private String ch = e.n();
    private String oaid = e.U();
    private int uvip = b.c().e() ? 1 : 0;
    private String rdc = a.a().d();
    private String rch = a.a().c();
    private int abroad = j.l.a.k.b.a();
    private String src = e.g0();

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class HPValue implements JsonInterface {
        private static final long serialVersionUID = -1884056697590291559L;
        public int cpn = 1;
        public int evt;
        public int pid;
        public int vid;

        public HPValue(int i, int i2, int i3) {
            this.evt = i;
            this.vid = i2;
            this.pid = i3;
        }
    }

    public int getAbroad() {
        return this.abroad;
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

    public String getFpa() {
        return this.fpa;
    }

    public String getGps() {
        return this.gps;
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

    public String getOaid() {
        return this.oaid;
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

    public String getTime() {
        return this.time;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getUvip() {
        return this.uvip;
    }

    public String getValue() {
        return this.value;
    }

    public void setAbroad(int i) {
        this.abroad = i;
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

    public void setFpa(String str) {
        this.fpa = str;
    }

    public void setGps(String str) {
        this.gps = str;
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

    public void setOaid(String str) {
        this.oaid = str;
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

    public void setTime(String str) {
        this.time = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setUvip(int i) {
        this.uvip = i;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return j.v.j.b.F(this, HPPlayRecordData.class);
    }
}
