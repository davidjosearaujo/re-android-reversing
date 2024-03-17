package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class PlayRecordClickData implements JsonInterface {
    public static final int CURRENT = 0;
    public static final int IS_NOT_POINT = 0;
    public static final int IS_POINT = 1;
    public static final int NEXT = 1;
    private static final long serialVersionUID = 2746729192706738346L;
    private String cpn;
    private int evt;
    private int isNext;
    private int isPoint;
    private int pos;
    private int vType;
    private int vid;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class FilerClick implements JsonInterface {
        public static final int OP_CLOSE = 0;
        public static final int OP_OPEN = 1;
        private static final long serialVersionUID = -3854772437861337711L;
        private int op;
        private int evt = 6;
        private String cpn = a.a().i;

        public FilerClick(int i) {
            this.op = i;
        }

        public String getCpn() {
            return this.cpn;
        }

        public int getEvt() {
            return this.evt;
        }

        public int getOp() {
            return this.op;
        }

        public void setCpn(String str) {
            this.cpn = str;
        }

        public void setEvt(int i) {
            this.evt = i;
        }

        public void setOp(int i) {
            this.op = i;
        }
    }

    public PlayRecordClickData() {
        this.evt = 5;
        this.cpn = a.a().i;
    }

    public String getCpn() {
        return this.cpn;
    }

    public int getEvt() {
        return this.evt;
    }

    public int getIsNext() {
        return this.isNext;
    }

    public int getIsPoint() {
        return this.isPoint;
    }

    public int getPos() {
        return this.pos;
    }

    public int getVid() {
        return this.vid;
    }

    public int getvType() {
        return this.vType;
    }

    public void setCpn(String str) {
        this.cpn = str;
    }

    public void setEvt(int i) {
        this.evt = i;
    }

    public void setIsNext(int i) {
        this.isNext = i;
    }

    public void setIsPoint(int i) {
        this.isPoint = i;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setvType(int i) {
        this.vType = i;
    }

    public PlayRecordClickData(int i, int i2, int i3, int i4, int i5) {
        this.evt = 5;
        this.cpn = a.a().i;
        this.pos = i;
        this.vType = i2;
        this.isNext = i3;
        this.vid = i4;
        this.isPoint = i5;
    }

    public PlayRecordClickData(String str, int i, int i2, int i3, int i4, int i5) {
        this.evt = 5;
        this.cpn = str;
        this.evt = 5;
        this.pos = i;
        this.vType = i2;
        this.isNext = i3;
        this.vid = i4;
        this.isPoint = i5;
    }
}
