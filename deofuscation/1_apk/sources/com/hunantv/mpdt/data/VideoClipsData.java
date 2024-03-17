package com.hunantv.mpdt.data;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.data.EventClickData;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;
import j.l.a.b0.l;
import j.l.c.x.t0.a;
import java.util.UUID;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VideoClipsData implements JsonInterface {
    private static final long serialVersionUID = -6676006722877792666L;
    private String action;
    private String did;
    private String ntime;
    private String oaid;
    private String paid;
    private String patver;

    /* renamed from: pls  reason: collision with root package name */
    private int f0pls;
    private String suuid;
    private long td;
    private String time;
    private String tk;
    private String ud;
    private String uuid;
    private String vtime;
    private String vid = "";
    private String sid = "";
    private String ap = "";
    private String cpn = "";
    private String ver = "";
    private String pf = "android";
    private String src = "mgtv";
    private String to = "";
    private String st = "";
    private String u = "";
    private String mf = "";
    private String mod = "";
    private String stype = "";
    private String cross = "0";

    private String isNull(String str) {
        return str == null ? "" : str;
    }

    public void ShortVideoData(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.action = str;
        this.did = e.x();
        this.oaid = e.U();
        this.time = l.p(System.currentTimeMillis());
        this.vid = str2;
        this.sid = str3;
        this.ap = str4;
        this.cpn = str5;
        this.ver = e.C0();
        this.patver = e.G0();
        this.to = str6;
        this.st = str7;
    }

    public String getCross() {
        return this.cross;
    }

    public RequestParams getRequestParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.did = e.x();
        this.oaid = e.U();
        this.time = l.p(System.currentTimeMillis());
        this.ver = e.C0();
        this.patver = e.G0();
        this.uuid = e.v0();
        this.suuid = a.a().f;
        RequestParams requestParams = new RequestParams();
        requestParams.put("action", isNull(str));
        requestParams.put("uuid", isNull(this.uuid));
        requestParams.put("did", isNull(this.did));
        requestParams.put("oaid", isNull(this.oaid));
        requestParams.put(CrashHianalyticsData.TIME, isNull(this.time));
        requestParams.put("vid", isNull(str2));
        requestParams.put("sid", isNull(str3));
        requestParams.put("ap", isNull(str4));
        requestParams.put("cpn", isNull(str5));
        requestParams.put("ver", isNull(this.ver));
        requestParams.put("patver", isNull(this.patver));
        requestParams.put("pf", isNull(this.pf));
        String g0 = e.g0();
        this.src = g0;
        requestParams.put("src", TextUtils.isEmpty(g0) ? EventClickData.a.a0 : this.src);
        requestParams.put("to", isNull(str6));
        if (!TextUtils.isEmpty(str7)) {
            for (String str9 : str7.split("&")) {
                String[] split = str9.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length > 1) {
                    requestParams.put(split[0], split[1]);
                }
            }
        }
        requestParams.put("u", isNull(str8));
        requestParams.put("mf", e.P());
        requestParams.put("mod", e.Q());
        requestParams.put("stype", isNull(this.stype));
        requestParams.put("cross", isNull(this.cross));
        requestParams.put("ud", isNull(this.ud));
        requestParams.put("vtime", isNull(this.vtime));
        requestParams.put("tk", isNull(this.tk));
        requestParams.put("suuid", isNull(this.suuid));
        if (TextUtils.equals(str, "playend")) {
            requestParams.put("pls", this.f0pls);
        }
        if (TextUtils.equals(str, "play")) {
            requestParams.put("td", this.td);
        }
        if (TextUtils.isEmpty(a.a().E)) {
            a.a().E = UUID.randomUUID().toString();
        }
        requestParams.put("paid", a.a().E);
        requestParams.put("ntime", System.currentTimeMillis());
        return requestParams;
    }

    public String getSt() {
        return this.st;
    }

    public String getSuuid() {
        return this.suuid;
    }

    public String getTk() {
        return this.tk;
    }

    public String getUd() {
        return this.ud;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVtime() {
        return this.vtime;
    }

    public void setCross(String str) {
        this.cross = str;
    }

    public void setPls(int i) {
        this.f0pls = i;
    }

    public void setStype(String str) {
        this.stype = str;
    }

    public void setSuuid(String str) {
        this.suuid = str;
    }

    public void setTd(long j) {
        this.td = j;
    }

    public void setTk(String str) {
        this.tk = str;
    }

    public void setUd(String str) {
        this.ud = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVtime(String str) {
        this.vtime = str;
    }
}
