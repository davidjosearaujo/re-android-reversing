package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VodPfcFantuanValue implements JsonInterface {
    public static final String PROGAME_FANTUAN_MAIN_PAGE = "1";
    public static final String STAR_FANTUAN_MAIN_PAGE = "2";
    private static final long serialVersionUID = -6950092689792870741L;
    private String fantuanid;
    private String ftype;
    private int istag;

    public VodPfcFantuanValue(String str) {
        this.ftype = "1";
        this.fantuanid = str;
    }

    public String getFantuanid() {
        return this.fantuanid;
    }

    public String getFtype() {
        return this.ftype;
    }

    public int getIstag() {
        return this.istag;
    }

    public void setFantuanid(String str) {
        this.fantuanid = str;
    }

    public void setFtype(String str) {
        this.ftype = str;
    }

    public void setIstag(int i) {
        this.istag = i;
    }

    public VodPfcFantuanValue(String str, String str2) {
        this.ftype = str;
        this.fantuanid = str2;
    }

    public VodPfcFantuanValue(String str, String str2, int i) {
        this.ftype = str;
        this.fantuanid = str2;
        this.istag = i;
    }
}
