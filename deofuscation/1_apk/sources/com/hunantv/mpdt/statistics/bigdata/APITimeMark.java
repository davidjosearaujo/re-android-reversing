package com.hunantv.mpdt.statistics.bigdata;

import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class APITimeMark implements JsonInterface {
    private static final long serialVersionUID = -6218147585336219659L;
    private long addtime;
    private String url;
    private long usetime;

    public long getAddtime() {
        return this.addtime;
    }

    public String getUrl() {
        return this.url;
    }

    public long getUsetime() {
        return this.usetime;
    }

    public void setAddtime(long j) {
        this.addtime = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUsetime(long j) {
        this.usetime = j;
    }
}
