package com.hunantv.mpdt.data;

import android.text.TextUtils;
import com.hunantv.imgo.net.RequestParams;
import j.l.a.b0.e;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;
import java.net.URLEncoder;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class NewPvData extends NewCommonData {
    private static final long serialVersionUID = -9178559810693314504L;
    public String abt;
    public int auto;
    public String bdid;
    public String bsid;
    public String cntp;
    public String cpid;
    public String ctl;
    public String datano;
    public String did;
    public String fcv;
    public String fpa;
    public String fpid;
    public String fpt;
    public int fsf;
    public String ftl;
    public String idfa;
    private boolean isVodPlay = true;
    public int isfull;
    public String lastp;
    public String lob;
    public String logtype;
    public String oaid;
    public int plid;
    public String pt;
    public String refmdid;
    public String skw;
    public String spid;
    public String stid;

    public NewPvData() {
        if (!a.a().D) {
            a.a().D = true;
            a.a().E = UUID.randomUUID().toString();
        }
        this.stid = a.a().a;
        this.spid = b.c().b();
        this.did = e.x();
        this.oaid = e.U();
    }

    @Override // com.hunantv.mpdt.data.NewCommonData
    public RequestParams createBaseRequestParams() {
        RequestParams createBaseRequestParams = super.createBaseRequestParams();
        createBaseRequestParams.put("logtype", "pv");
        createBaseRequestParams.put("cntp", this.cntp);
        createBaseRequestParams.put("lastp", a.a().j);
        String lob = getLob();
        this.lob = lob;
        createBaseRequestParams.put("lob", TextUtils.isEmpty(lob) ? "" : URLEncoder.encode(this.lob));
        return createBaseRequestParams;
    }

    public String getAbt() {
        return this.abt;
    }

    public int getAuto() {
        return this.auto;
    }

    public String getBdid() {
        return this.bdid;
    }

    public String getBsid() {
        return this.bsid;
    }

    public String getCntp() {
        return this.cntp;
    }

    public String getCpid() {
        return this.cpid;
    }

    public String getCtl() {
        return this.ctl;
    }

    public String getDatano() {
        return this.datano;
    }

    public String getFcv() {
        return this.fcv;
    }

    public String getFpa() {
        return this.fpa;
    }

    public String getFpid() {
        return this.fpid;
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

    public String getIdfa() {
        return this.idfa;
    }

    public int getIsfull() {
        return this.isfull;
    }

    public String getLob() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("cpid=" + this.cpid);
        stringBuffer.append("&fpid=" + this.fpid);
        stringBuffer.append("&fcv=" + this.fcv);
        stringBuffer.append("&bdid=" + this.bdid);
        stringBuffer.append("&bsid=" + this.bsid);
        stringBuffer.append("&ftl=" + this.ftl);
        stringBuffer.append("&ctl=" + this.ctl);
        stringBuffer.append("&pt=" + this.pt);
        stringBuffer.append("&fpt=" + this.fpt);
        stringBuffer.append("&fpa=" + this.fpa);
        stringBuffer.append("&plid=" + this.plid);
        stringBuffer.append("&refmdid=" + this.refmdid);
        stringBuffer.append("&skw=" + this.skw);
        stringBuffer.append("&idfa=" + this.idfa);
        stringBuffer.append("&datano=" + this.datano);
        stringBuffer.append("&abt=" + this.abt);
        stringBuffer.append("&stid=" + this.stid);
        stringBuffer.append("&spid=" + this.spid);
        stringBuffer.append("&fsf=" + this.fsf);
        stringBuffer.append("&isfull=" + this.isfull);
        stringBuffer.append("&auto=" + this.auto);
        stringBuffer.append("&did=" + this.did);
        stringBuffer.append("&oaid=" + this.oaid);
        stringBuffer.append("&patver=" + e.G0());
        return stringBuffer.toString();
    }

    public int getPlid() {
        return this.plid;
    }

    public String getPt() {
        return this.pt;
    }

    public String getRefmdid() {
        return this.refmdid;
    }

    public String getSkw() {
        return this.skw;
    }

    public String getSpid() {
        return this.spid;
    }

    public String getStid() {
        return this.stid;
    }

    public void setAbt(String str) {
        this.abt = str;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public void setBdid(String str) {
        this.bdid = str;
    }

    public void setBsid(String str) {
        this.bsid = str;
    }

    public void setCntp(String str) {
        this.cntp = str;
    }

    public void setCpid(String str) {
        this.cpid = str;
    }

    public void setCtl(String str) {
        this.ctl = str;
    }

    public void setDatano(String str) {
        this.datano = str;
    }

    public void setFcv(String str) {
        this.fcv = str;
    }

    public void setFpa(String str) {
        this.fpa = str;
    }

    public void setFpid(String str) {
        this.fpid = str;
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

    public void setIdfa(String str) {
        this.idfa = str;
    }

    public void setIsfull(int i) {
        this.isfull = i;
    }

    public void setPlid(int i) {
        this.plid = i;
    }

    public void setPt(String str) {
        this.pt = str;
    }

    public void setRefmdid(String str) {
        this.refmdid = str;
    }

    public void setSkw(String str) {
        this.skw = str;
    }

    public void setSpid(String str) {
        this.spid = str;
    }

    public void setStid(String str) {
        this.stid = str;
    }

    public void setVodPlay(boolean z) {
        this.isVodPlay = z;
    }
}
