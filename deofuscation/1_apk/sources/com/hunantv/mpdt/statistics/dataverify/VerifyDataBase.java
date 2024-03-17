package com.hunantv.mpdt.statistics.dataverify;

import android.text.TextUtils;
import com.hunantv.imgo.global.AgeDataModel;
import com.hunantv.imgo.net.RequestParams;
import com.hunantv.mpdt.statistics.bigdata.PVSourceEvent;
import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;
import j.l.a.b0.j0;
import j.l.c.x.p0.b;
import j.l.c.x.t0.a;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class VerifyDataBase implements JsonInterface {
    private String abroad;
    private int agemod;
    private String androidid;
    private String app_version;
    private String browser;
    private String browser_version;
    private String carrier;
    private String channel;
    private String device_id;
    private int is_login;
    private int is_vip;
    private String lib;
    private String lib_version;
    private String manufacturer;
    private String model;
    private String network_type;
    private String oaid;
    private String os;
    private String os_version;
    private int p2p;
    private String rch;
    private String screen_height;
    private String screen_width;
    private String sid;
    private String time;
    private String ua;
    private String uuid;

    public VerifyDataBase() {
        setDevice_id(e.x());
        setUuid(e.v0());
        setIs_vip(b.c().e() ? 1 : 0);
        setIs_login(!TextUtils.isEmpty(this.uuid) ? 1 : 0);
        setTime("" + System.currentTimeMillis());
        setRch(a.a().c());
        setApp_version(e.D0());
        setLib("Android");
        setLib_version("1.0.0");
        setManufacturer(e.P());
        setModel(e.Q());
        setOs("Android");
        setOs_version(e.Y());
        setScreen_height(String.valueOf(j0.k(j.l.a.a.a())));
        setScreen_width(String.valueOf(j0.n(j.l.a.a.a())));
        setNetwork_type(b0.c());
        setChannel(e.n());
        setCarrier(e.S());
        setAndroidid(e.d());
        setOaid(e.U());
        setSid(PVSourceEvent.i());
        setUa(e.u0());
        setAbroad(j.l.a.k.b.b());
        setAgemod(AgeDataModel.b().a().ordinal());
        setP2p(j.l.a.k.e.H ? 1 : 0);
    }

    public RequestParams generateRequestParams() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("$device_id", isNull(this.device_id));
        requestParams.put("$uuid", isNull(this.uuid));
        requestParams.put("$is_vip", this.is_vip);
        requestParams.put("$is_login", this.is_login);
        requestParams.put("$time", isNull(this.time));
        requestParams.put("$rch", isNull(this.rch));
        requestParams.put("$app_version", isNull(this.app_version));
        requestParams.put("$lib", isNull(this.lib));
        requestParams.put("$lib_version", isNull(this.lib_version));
        requestParams.put("$manufacturer", isNull(this.manufacturer));
        requestParams.put("$model", isNull(this.model));
        requestParams.put("$os", isNull(this.os));
        requestParams.put("$os_version", isNull(this.os_version));
        requestParams.put("$screen_height", isNull(this.screen_height));
        requestParams.put("$screen_width", isNull(this.screen_width));
        requestParams.put("$network_type", isNull(this.network_type));
        requestParams.put("$channel", isNull(this.channel));
        requestParams.put("$carrier", isNull(this.carrier));
        requestParams.put("androidid", isNull(this.androidid));
        requestParams.put("oaid", isNull(this.oaid));
        requestParams.put("sid", isNull(this.sid));
        requestParams.put("$ua", isNull(this.ua));
        requestParams.put("abroad", isNull(this.abroad));
        requestParams.put("agemod", this.agemod);
        requestParams.put("p2p", this.p2p);
        return requestParams;
    }

    public String getAbroad() {
        return this.abroad;
    }

    public int getAgemod() {
        return this.agemod;
    }

    public String getAndroidid() {
        return this.androidid;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getBrowser_version() {
        return this.browser_version;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public int getIs_login() {
        return this.is_login;
    }

    public int getIs_vip() {
        return this.is_vip;
    }

    public String getLib() {
        return this.lib;
    }

    public String getLib_version() {
        return this.lib_version;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getNetwork_type() {
        return this.network_type;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOs() {
        return this.os;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public int getP2p() {
        return this.p2p;
    }

    public String getRch() {
        return this.rch;
    }

    public String getScreen_height() {
        return this.screen_height;
    }

    public String getScreen_width() {
        return this.screen_width;
    }

    public String getSid() {
        return this.sid;
    }

    public String getTime() {
        return this.time;
    }

    public String getUa() {
        return this.ua;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String isNull(String str) {
        return str == null ? "" : str;
    }

    public void setAbroad(String str) {
        this.abroad = str;
    }

    public void setAgemod(int i) {
        this.agemod = i;
    }

    public void setAndroidid(String str) {
        this.androidid = str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setBrowser(String str) {
        this.browser = str;
    }

    public void setBrowser_version(String str) {
        this.browser_version = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setDevice_id(String str) {
        this.device_id = str;
    }

    public void setIs_login(int i) {
        this.is_login = i;
    }

    public void setIs_vip(int i) {
        this.is_vip = i;
    }

    public void setLib(String str) {
        this.lib = str;
    }

    public void setLib_version(String str) {
        this.lib_version = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNetwork_type(String str) {
        this.network_type = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setOs_version(String str) {
        this.os_version = str;
    }

    public void setP2p(int i) {
        this.p2p = i;
    }

    public void setRch(String str) {
        this.rch = str;
    }

    public void setScreen_height(String str) {
        this.screen_height = str;
    }

    public void setScreen_width(String str) {
        this.screen_width = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUa(String str) {
        this.ua = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
