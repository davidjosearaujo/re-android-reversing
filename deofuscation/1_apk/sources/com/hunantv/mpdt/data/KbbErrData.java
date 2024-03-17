package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.c.x.t0.a;
import j.v.j.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class KbbErrData implements JsonInterface {
    private static final long serialVersionUID = -2428070516121625456L;
    private int bdid;
    private String c;
    private int plid;
    private int pt;
    private int vid;
    private String act = "er";
    private String did = e.x();
    private String oaid = e.U();
    private String mod = e.Q();
    private String mf = e.P();
    private String aver = e.C0();
    private String patver = e.G0();
    private String sver = e.Z();
    private String ch = e.n();
    private int net = b0.b();
    private String suuid = a.a().f;
    private String time = l.p(System.currentTimeMillis());
    private String src = e.g0();

    public String getAct() {
        return this.act;
    }

    public String getAver() {
        return this.aver;
    }

    public int getBdid() {
        return this.bdid;
    }

    public String getC() {
        return this.c;
    }

    public String getCh() {
        return this.ch;
    }

    public String getDid() {
        return this.did;
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

    public int getPlid() {
        return this.plid;
    }

    public int getPt() {
        return this.pt;
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

    public int getVid() {
        return this.vid;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAver(String str) {
        this.aver = str;
    }

    public void setBdid(int i) {
        this.bdid = i;
    }

    public void setC(String str) {
        this.c = str;
    }

    public void setCh(String str) {
        this.ch = str;
    }

    public void setDid(String str) {
        this.did = str;
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

    public void setPlid(int i) {
        this.plid = i;
    }

    public void setPt(int i) {
        this.pt = i;
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

    public void setVid(int i) {
        this.vid = i;
    }

    public String toString() {
        return b.F(this, KbbErrData.class);
    }
}
