package com.hunantv.imgo.vod;

import com.mgtv.json.JsonInterface;
import j.l.a.b0.b0;
import j.l.a.b0.e;

@Deprecated
/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ImgoBaseStatisticsData implements JsonInterface {
    public static final String DT_DEVICE = "device";
    public static final String DT_ERROR = "error";
    public static final String DT_LIVE = "live";
    public static final String DT_ONLINE = "online";
    public static final String DT_VOD = "vod";
    private static final long serialVersionUID = -3074089716018137866L;
    private String apk_version;
    private String data_type;
    private String network;
    private String os;
    private String platform;
    private String state;
    private String system_version;
    private String user_account;
    private int user_id;
    private String manufacturers = "android";
    private String did = e.x();
    private String model = e.Q();

    public ImgoBaseStatisticsData() {
        String str;
        if (j.l.a.k.e.H) {
            str = "imgoTV_aPhone_" + e.B0() + ".1";
        } else {
            str = "imgoTV_aPhone_" + e.B0();
        }
        this.apk_version = str;
        this.system_version = e.Y();
        this.network = b0.c();
        this.user_account = e.y0();
        this.user_id = e.x0();
        this.platform = "mobile";
        this.os = "android";
        this.state = "0";
    }

    public String getApk_version() {
        return this.apk_version;
    }

    public String getData_type() {
        return this.data_type;
    }

    public String getDid() {
        return this.did;
    }

    public String getManufacturers() {
        return this.manufacturers;
    }

    public String getModel() {
        return this.model;
    }

    public String getNetwork() {
        return this.network;
    }

    public String getOs() {
        return this.os;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getState() {
        return this.state;
    }

    public String getSystem_version() {
        return this.system_version;
    }

    public String getUser_account() {
        return this.user_account;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setApk_version(String str) {
        this.apk_version = str;
    }

    public void setData_type(String str) {
        this.data_type = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setManufacturers(String str) {
        this.manufacturers = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSystem_version(String str) {
        this.system_version = str;
    }

    public void setUser_account(String str) {
        this.user_account = str;
    }

    public void setUser_id(int i) {
        this.user_id = i;
    }
}
