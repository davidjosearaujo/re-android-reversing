package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.a.k.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class KbbData implements JsonInterface {
    private static final long serialVersionUID = -2804339945845044709L;
    private int abroad;
    private String act;
    private String aver;
    private String ch;
    private String did;
    private String idx;
    private String mf;
    private String mod;
    private int net;
    private String oaid;
    private String patver;
    private String src;
    private String suuid;
    private String sver;
    private String time;

    public KbbData(String str, String str2) {
        this.idx = str;
        this.suuid = str2;
        this.act = "cp1";
        this.did = e.x();
        this.oaid = e.U();
        this.mod = e.Q();
        this.mf = e.P();
        this.aver = e.D0();
        this.patver = e.G0();
        this.sver = e.Z();
        this.ch = e.n();
        this.net = b0.b();
        this.time = l.p(System.currentTimeMillis());
        this.src = e.g0();
        this.abroad = b.a();
    }

    public int getAbroad() {
        return this.abroad;
    }

    public String getAct() {
        return this.act;
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

    public String getIdx() {
        return this.idx;
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

    public void setAbroad(int i) {
        this.abroad = i;
    }

    public void setAct(String str) {
        this.act = str;
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

    public void setIdx(String str) {
        this.idx = str;
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

    public String toString() {
        return j.v.j.b.F(this, KbbData.class);
    }

    public KbbData(String str, String str2, String str3) {
        this.idx = str;
        this.suuid = str2;
        this.act = str3;
        this.did = e.x();
        this.oaid = e.U();
        this.mod = e.Q();
        this.mf = e.P();
        this.aver = e.D0();
        this.patver = e.G0();
        this.sver = e.Z();
        this.ch = e.n();
        this.net = b0.b();
        this.time = l.p(System.currentTimeMillis());
        this.src = e.g0();
        this.abroad = b.a();
    }
}
