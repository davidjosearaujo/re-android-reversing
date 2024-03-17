package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayCommentkData implements JsonInterface {
    public static final int EVT_BROWSER = 1;
    public static final int EVT_BROWSER_COMMENT = 4;
    public static final int EVT_CLICK_COMMENT = 3;
    public static final int EVT_LIKE = 2;
    public static final int FLOOT_TOP_CHILD_COMMENT = 1;
    public static final int FLOOT_TOP_COMMENT = 0;
    private static final long serialVersionUID = 6851903652999605130L;
    private long cid;
    private int evt;
    private int floor;
    private String lab;
    private long pid;
    private int rn;
    private String vid;

    public PlayCommentkData() {
        this.evt = 0;
    }

    public long getCid() {
        return this.cid;
    }

    public int getEvt() {
        return this.evt;
    }

    public int getFloor() {
        return this.floor;
    }

    public String getLab() {
        return this.lab;
    }

    public long getPid() {
        return this.pid;
    }

    public int getRn() {
        return this.rn;
    }

    public String getVid() {
        return this.vid;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public void setEvt(int i) {
        this.evt = i;
    }

    public void setFloor(int i) {
        this.floor = i;
    }

    public void setLab(String str) {
        this.lab = str;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public PlayCommentkData(String str, int i, long j, long j2, String str2, int i2, int i3) {
        this.evt = 0;
        this.vid = str;
        this.evt = i;
        this.cid = j;
        this.pid = j2;
        this.lab = str2;
        this.floor = i2;
        this.rn = i3;
    }
}
