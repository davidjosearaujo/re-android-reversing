package com.hunantv.mpdt.data;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PayData extends CommonData {
    private static final long serialVersionUID = -2144077470820689678L;
    private String ext1;
    private String ext2;
    private String bid = "2.1.11";
    private String act = "pay";

    public String getAct() {
        return this.act;
    }

    public String getBid() {
        return this.bid;
    }

    public String getExt1() {
        return this.ext1;
    }

    public String getExt2() {
        return this.ext2;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setBid(String str) {
        this.bid = str;
    }

    public void setExt1(String str) {
        this.ext1 = str;
    }

    public void setExt2(String str) {
        this.ext2 = str;
    }
}
