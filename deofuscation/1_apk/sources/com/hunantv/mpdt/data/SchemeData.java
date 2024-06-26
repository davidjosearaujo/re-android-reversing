package com.hunantv.mpdt.data;

import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class SchemeData extends CommonData {
    private static final long serialVersionUID = -6811636268577269772L;
    private String act;
    private String bid;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;

    public SchemeData() {
        setUuid(UUID.randomUUID().toString());
    }

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

    public String getExt3() {
        return this.ext3;
    }

    public String getExt4() {
        return this.ext4;
    }

    public String getExt5() {
        return this.ext5;
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

    public void setExt3(String str) {
        this.ext3 = str;
    }

    public void setExt4(String str) {
        this.ext4 = str;
    }

    public void setExt5(String str) {
        this.ext5 = str;
    }

    public String toString() {
        return "SchemeData{act='" + this.act + "', bid='" + this.bid + "', ext1='" + this.ext1 + "', ext2='" + this.ext2 + "', ext3='" + this.ext3 + "', ext4='" + this.ext4 + "', ext5='" + this.ext5 + "'}";
    }
}
