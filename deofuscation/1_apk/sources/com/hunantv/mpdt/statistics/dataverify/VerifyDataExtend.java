package com.hunantv.mpdt.statistics.dataverify;

import com.hunantv.imgo.net.RequestParams;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VerifyDataExtend extends VerifyDataBase {
    private static final String DEFAULT_EVENT_TYPE = "track";
    private String acp;
    private int auto_play;
    private String bdid;
    private String bsid;
    private String cntp;
    private String cpid;
    private String cpt;
    private String ctl;
    private String definition;
    private String event_name;
    private String event_type = DEFAULT_EVENT_TYPE;
    private String fpid;
    private String fpt;
    private String ftl;
    private int is_third;
    private String isad;
    private String isdrm;
    private String isfull;
    private String istry;
    private String lastp;
    private String pay_play;
    private String plid;
    private String project;
    private String pt;
    private String sbs;
    private String suuid;
    private String vid;

    public RequestParams generatePvRequestParams() {
        RequestParams generateRequestParams = super.generateRequestParams();
        generateRequestParams.put("$event_type", isNull(this.event_type));
        generateRequestParams.put("$event_name", isNull(this.event_name));
        generateRequestParams.put("$project", isNull(this.project));
        generateRequestParams.put("vid", isNull(this.vid));
        generateRequestParams.put("plid", isNull(this.plid));
        generateRequestParams.put("bdid", isNull(this.bdid));
        generateRequestParams.put("bsid", isNull(this.bsid));
        generateRequestParams.put("cntp", isNull(this.cntp));
        generateRequestParams.put("lastp", isNull(this.lastp));
        generateRequestParams.put("cpid", isNull(this.cpid));
        generateRequestParams.put("fpid", isNull(this.fpid));
        generateRequestParams.put("ftl", isNull(this.ftl));
        generateRequestParams.put("ctl", isNull(this.ctl));
        generateRequestParams.put("isfull", isNull(this.isfull));
        generateRequestParams.put("is_third", String.valueOf(this.is_third));
        return generateRequestParams;
    }

    @Override // com.hunantv.mpdt.statistics.dataverify.VerifyDataBase
    public RequestParams generateRequestParams() {
        RequestParams generateRequestParams = super.generateRequestParams();
        generateRequestParams.put("$event_type", isNull(this.event_type));
        generateRequestParams.put("$event_name", isNull(this.event_name));
        generateRequestParams.put("$project", isNull(this.project));
        generateRequestParams.put("auto_play", String.valueOf(this.auto_play));
        generateRequestParams.put("suuid", isNull(this.suuid));
        generateRequestParams.put("vid", isNull(this.vid));
        generateRequestParams.put("plid", isNull(this.plid));
        generateRequestParams.put("pt", isNull(this.pt));
        generateRequestParams.put("cpt", isNull(this.cpt));
        generateRequestParams.put("fpt", isNull(this.fpt));
        generateRequestParams.put("bdid", isNull(this.bdid));
        generateRequestParams.put("bsid", isNull(this.bsid));
        generateRequestParams.put("isad", isNull(this.isad));
        generateRequestParams.put("definition", isNull(this.definition));
        generateRequestParams.put("pay_play", isNull(this.pay_play));
        generateRequestParams.put("sbs", isNull(this.sbs));
        generateRequestParams.put("isdrm", isNull(this.isdrm));
        generateRequestParams.put("acp", isNull(this.acp));
        generateRequestParams.put("istry", isNull(this.istry));
        generateRequestParams.put("ftl", isNull(this.ftl));
        generateRequestParams.put("ctl", isNull(this.ctl));
        generateRequestParams.put("isfull", isNull(this.isfull));
        generateRequestParams.put("cntp", isNull(this.cntp));
        generateRequestParams.put("lastp", isNull(this.lastp));
        generateRequestParams.put("cpid", isNull(this.cpid));
        generateRequestParams.put("fpid", isNull(this.fpid));
        generateRequestParams.put("is_third", String.valueOf(this.is_third));
        return generateRequestParams;
    }

    public String getAcp() {
        return this.acp;
    }

    public int getAuto_play() {
        return this.auto_play;
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

    public String getCpt() {
        return this.cpt;
    }

    public String getCtl() {
        return this.ctl;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getEvent_name() {
        return this.event_name;
    }

    public String getEvent_type() {
        return this.event_type;
    }

    public String getFpid() {
        return this.fpid;
    }

    public String getFpt() {
        return this.fpt;
    }

    public String getFtl() {
        return this.ftl;
    }

    public int getIs_third() {
        return this.is_third;
    }

    public String getIsad() {
        return this.isad;
    }

    public String getIsdrm() {
        return this.isdrm;
    }

    public String getIsfull() {
        return this.isfull;
    }

    public String getIstry() {
        return this.istry;
    }

    public String getLastp() {
        return this.lastp;
    }

    public String getPay_play() {
        return this.pay_play;
    }

    public String getPlid() {
        return this.plid;
    }

    public String getProject() {
        return this.project;
    }

    public String getPt() {
        return this.pt;
    }

    public String getSbs() {
        return this.sbs;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public String getVid() {
        return this.vid;
    }

    public void setAcp(String str) {
        this.acp = str;
    }

    public void setAuto_play(int i) {
        this.auto_play = i;
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

    public void setCpt(String str) {
        this.cpt = str;
    }

    public void setCtl(String str) {
        this.ctl = str;
    }

    public void setDefinition(String str) {
        this.definition = str;
    }

    public void setEvent_name(String str) {
        this.event_name = str;
    }

    public void setEvent_type(String str) {
        this.event_type = str;
    }

    public void setFpid(String str) {
        this.fpid = str;
    }

    public void setFpt(String str) {
        this.fpt = str;
    }

    public void setFtl(String str) {
        this.ftl = str;
    }

    public void setIs_third(int i) {
        this.is_third = i;
    }

    public void setIsad(String str) {
        this.isad = str;
    }

    public void setIsdrm(String str) {
        this.isdrm = str;
    }

    public void setIsfull(String str) {
        this.isfull = str;
    }

    public void setIstry(String str) {
        this.istry = str;
    }

    public void setLastp(String str) {
        this.lastp = str;
    }

    public void setPay_play(String str) {
        this.pay_play = str;
    }

    public void setPlid(String str) {
        this.plid = str;
    }

    public void setProject(String str) {
        this.project = str;
    }

    public void setPt(String str) {
        this.pt = str;
    }

    public void setSbs(String str) {
        this.sbs = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }
}
