package com.hunantv.mpdt.data;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ApplicationData extends CommonData {
    private static final long serialVersionUID = 8234562004801584043L;
    private String act;
    private String bid;
    private int desc;
    private String type;

    public ApplicationData() {
        setBid("2.2.1");
    }

    public String getAct() {
        return this.act;
    }

    public String getBid() {
        return this.bid;
    }

    public int getDesc() {
        return this.desc;
    }

    public String getType() {
        return this.type;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setDesc(int i) {
        this.desc = i;
    }

    public void setType(String str) {
        this.type = str;
    }
}
