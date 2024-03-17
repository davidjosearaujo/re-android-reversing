package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import java.io.IOException;
import java.net.URL;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ChannelData implements JsonInterface {
    public static final int IS_BACKUP_DATA = 1;
    public static final int IS_NOT_BACKUP_DATA = 0;
    public static final int IS_NOT_TRY = 1;
    public static final int IS_TRY = 0;
    public static final String MSG_FAIL = "数据解析失败";
    public static final String MSG_NULL = "";
    public static final String MSG_SUCCESS = "打开成功";
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final String SERVICE_CODE_NULL = "";
    public static final String SERVICE_CODE_SUCCESS = "200";
    public static final String SERVICE_NOT_PARAMS = "10005";
    public static final String SERVICE_SYS_EXCEPTION = "10001";
    public static final String bid = "2.15.15";
    private static final long serialVersionUID = -2712064453524567338L;
    public String domain;
    public int httpcode;
    public int isBackup;
    public int isTry;
    public String msg;
    public int resultcode;
    public String servicecode;
    public String vclassId;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final String a = "livepmm";
        public static final String b = "pmm";
    }

    public ChannelData() {
    }

    private String getHost(String str) {
        if (str == null) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getDomain() {
        return this.domain;
    }

    public int getHttpcode() {
        return this.httpcode;
    }

    public int getIsBackup() {
        return this.isBackup;
    }

    public int getIsTry() {
        return this.isTry;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResultcode() {
        return this.resultcode;
    }

    public String getServicecode() {
        return this.servicecode;
    }

    public String getVclassId() {
        return this.vclassId;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setHttpcode(int i) {
        this.httpcode = i;
    }

    public void setIsBackup(int i) {
        this.isBackup = i;
    }

    public void setIsTry(int i) {
        this.isTry = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResultcode(int i) {
        this.resultcode = i;
    }

    public void setServicecode(String str) {
        this.servicecode = str;
    }

    public void setVclassId(String str) {
        this.vclassId = str;
    }

    public ChannelData(int i, String str, int i2, String str2, int i3, String str3, String str4, int i4) {
        this.httpcode = i;
        this.servicecode = str;
        this.resultcode = i2;
        this.msg = str2;
        this.isTry = i3;
        this.domain = getHost(str3);
        this.vclassId = str4;
        this.isBackup = i4;
    }
}
