package com.hunantv.mpdt.data;

import androidx.annotation.NonNull;
import cn.com.custommma.mobile.tracking.viewability.webjs.DeviceMessage;
import com.hunantv.imgo.net.RequestParams;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.e;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class AnswerData implements JsonInterface {
    public static final String ANSWER_PK_ROOM_TYPE = "2";
    public static final String ANSWER_PK_SHARE_HTYPE = "8";
    public static final String ANSWER_RANK_ROOM_TYPE = "0";
    public static final String ANSWER_ROOM_HTYPE = "3";
    public static final String ANSWER_TOPIC_TYPE = "3";
    public static final String ANSWER_WELFWARE_ROOM_TYPE = "1";
    private static final long serialVersionUID = -7127002802608448700L;
    public String aver;
    public String did;
    public String entrance;
    public String htype;
    public String oaid;
    private String patver;
    public String rtype;
    public String sver;
    public String ticket;
    private String ts;
    public String uuid;

    public AnswerData() {
        this.htype = "3";
        setDid(e.x());
        setOaid(e.U());
        setSver(e.Z());
        setAver(e.C0());
        setPatchver(e.G0());
        setTicket(e.t0());
        setUuid(e.v0());
    }

    @NonNull
    public RequestParams createRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("did", this.did);
        requestParams.put("oaid", this.oaid);
        requestParams.put("sver", this.sver);
        requestParams.put("aver", this.aver);
        requestParams.put("patver", this.patver);
        requestParams.put("ticket", this.ticket);
        requestParams.put("uuid", this.uuid);
        requestParams.put(DeviceMessage.JSON_TS, System.currentTimeMillis());
        requestParams.put("entrance", this.entrance);
        requestParams.put("htype", this.htype);
        requestParams.put("rtype", this.rtype);
        return requestParams;
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

    public String getHtype() {
        return this.htype;
    }

    public String getPatchver() {
        return this.patver;
    }

    public String getRtype() {
        return this.rtype;
    }

    public String getSver() {
        return this.sver;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getUuid() {
        return this.uuid;
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

    public void setHtype(String str) {
        this.htype = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setPatchver(String str) {
        this.patver = str;
    }

    public void setRtype(String str) {
        this.rtype = str;
    }

    public void setSver(String str) {
        this.sver = str;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public AnswerData(String str) {
        this.htype = "3";
        this.entrance = str;
    }

    public AnswerData(String str, String str2, String str3) {
        this.htype = "3";
        this.entrance = str;
        this.htype = str2;
        this.rtype = str3;
    }
}
