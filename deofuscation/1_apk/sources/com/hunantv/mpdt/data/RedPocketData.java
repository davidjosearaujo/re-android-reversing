package com.hunantv.mpdt.data;

import androidx.annotation.NonNull;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RedPocketData implements JsonInterface {
    private static final long serialVersionUID = 7840795890986708539L;
    public String act;
    public String aver;
    public String did;
    public String entrance;
    public String oaid;
    private String patver;
    public String st;
    public String sver;
    public String uuid;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final String a = "1";
        public static final String b = "2";
        public static final String c = "3";
        public static final String d = "4";
        public static final String e = "5";
        public static final String f = "6";
        public static final String g = "7";
    }

    public RedPocketData() {
        setUuid(e.v0());
        setSver(e.Z());
        setAver(e.C0());
        setPatver(e.G0());
        setDid(e.x());
        setOaid(e.U());
        setSt(String.valueOf(System.currentTimeMillis()));
    }

    @NonNull
    public RequestParams createRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("uuid", this.uuid);
        requestParams.put("sver", this.sver);
        requestParams.put("aver", this.aver);
        requestParams.put("patver", this.patver);
        requestParams.put("did", this.did);
        requestParams.put("oaid", this.oaid);
        requestParams.put("entrance", this.entrance);
        requestParams.put("act", this.act);
        requestParams.put("st", this.st);
        requestParams.put("rdc", j.l.c.x.t0.a.a().d());
        requestParams.put("rch", j.l.c.x.t0.a.a().c());
        return requestParams;
    }

    public String getAct() {
        return this.act;
    }

    public String getAver() {
        return this.aver;
    }

    public String getDid() {
        return this.did;
    }

    public String getEntrance() {
        return this.entrance;
    }

    public String getPatver() {
        return this.patver;
    }

    public String getSt() {
        return this.st;
    }

    public String getSver() {
        return this.sver;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAver(String str) {
        this.aver = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setEntrance(String str) {
        this.entrance = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setPatver(String str) {
        this.patver = str;
    }

    public void setSt(String str) {
        this.st = str;
    }

    public void setSver(String str) {
        this.sver = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public RedPocketData(String str, String str2) {
        this();
        this.act = str;
        this.entrance = str2;
    }
}
