package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class LiveSwitchData extends CommonData implements JsonInterface {
    private static final long serialVersionUID = 5103583463782138465L;
    public String act;
    private String activeid;
    public int ap;
    public int ct;
    public int def;
    public int et;
    public String fpid;
    public String fpn;
    public int idx;
    public String lid;
    public String liveid;
    public int pay;
    public String prelid;
    public String preliveid;
    public int pt;
    public String sessionid;
    public String sid;
    private String src = e.g0();
    public String suuid;
    public int td;
    private int uvip;

    public String getAct() {
        return this.act;
    }

    public String getActiveid() {
        return this.activeid;
    }

    public int getAp() {
        return this.ap;
    }

    public int getCt() {
        return this.ct;
    }

    public int getDef() {
        return this.def;
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

    public int getIdx() {
        return this.idx;
    }

    public String getLid() {
        return this.lid;
    }

    public String getLiveid() {
        return this.liveid;
    }

    public int getPay() {
        return this.pay;
    }

    public String getPrelid() {
        return this.prelid;
    }

    public String getPreliveid() {
        return this.preliveid;
    }

    public int getPt() {
        return this.pt;
    }

    public String getSessionid() {
        return this.sessionid;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public String getSid() {
        return this.sid;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public String getSrc() {
        return this.src;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public int getTd() {
        return this.td;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public int getUvip() {
        return this.uvip;
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

    public void setCt(int i) {
        this.ct = i;
    }

    public void setDef(int i) {
        this.def = i;
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

    public void setIdx(int i) {
        this.idx = i;
    }

    public void setLid(String str) {
        this.lid = str;
    }

    public void setLiveid(String str) {
        this.liveid = str;
    }

    public void setPay(int i) {
        this.pay = i;
    }

    public void setPrelid(String str) {
        this.prelid = str;
    }

    public void setPreliveid(String str) {
        this.preliveid = str;
    }

    public void setPt(int i) {
        this.pt = i;
    }

    public void setSessionid(String str) {
        this.sessionid = str;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public void setSid(String str) {
        this.sid = str;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public void setSrc(String str) {
        this.src = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setTd(int i) {
        this.td = i;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public void setUvip(int i) {
        this.uvip = i;
    }
}
