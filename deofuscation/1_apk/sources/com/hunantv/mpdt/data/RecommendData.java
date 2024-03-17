package com.hunantv.mpdt.data;

import com.alipay.sdk.app.statistic.b;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.hunantv.imgo.net.RequestParams;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.l;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class RecommendData extends CommonData {
    private static final long serialVersionUID = 3450024209514042272L;
    private String act;
    private int auto;
    private final String bid = "2.2.0";
    private int cid;
    private String hitid;
    private int pos;
    private String rcdata;
    private int rctype;
    private int region;
    private String reqid;
    private String src;
    private String ver;
    private String videoid;

    public String getAct() {
        return this.act;
    }

    public int getAuto() {
        return this.auto;
    }

    public String getBid() {
        return "2.2.0";
    }

    public int getCid() {
        return this.cid;
    }

    public String getHitid() {
        return this.hitid;
    }

    public int getPos() {
        return this.pos;
    }

    public String getRcdata() {
        return this.rcdata;
    }

    public int getRctype() {
        return this.rctype;
    }

    public int getRegion() {
        return this.region;
    }

    public String getReqid() {
        return this.reqid;
    }

    public RequestParams getRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put(CrashHianalyticsData.TIME, l.i(new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA)));
        requestParams.put("uuid", e.v0());
        requestParams.put("guid", e.A());
        requestParams.put("did", e.x());
        requestParams.put("oaid", e.U());
        requestParams.put(b.k, b0.b());
        requestParams.put("isdebug", j.l.a.k.e.W ? 1 : 0);
        requestParams.put("mf", e.P());
        requestParams.put("mod", e.Q());
        requestParams.put("sver", this.sver);
        requestParams.put("aver", this.aver);
        requestParams.put("patver", this.patver);
        requestParams.put("ch", e.n());
        requestParams.put("bid", "2.2.0");
        requestParams.put("abroad", this.abroad);
        requestParams.put("src", e.g0());
        return requestParams;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public String getSrc() {
        return this.src;
    }

    public String getVer() {
        return this.ver;
    }

    public String getVideoid() {
        return this.videoid;
    }

    public void setAct(String str) {
        this.act = str;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public void setCid(int i) {
        this.cid = i;
    }

    public void setHitid(String str) {
        this.hitid = str;
    }

    public void setPos(int i) {
        this.pos = i;
    }

    public void setRcdata(String str) {
        this.rcdata = str;
    }

    public void setRctype(int i) {
        this.rctype = i;
    }

    public void setRegion(int i) {
        this.region = i;
    }

    public void setReqid(String str) {
        this.reqid = str;
    }

    @Override // com.hunantv.mpdt.data.CommonData
    public void setSrc(String str) {
        this.src = str;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public void setVideoid(String str) {
        this.videoid = str;
    }
}
