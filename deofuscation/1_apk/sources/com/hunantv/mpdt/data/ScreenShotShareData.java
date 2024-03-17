package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.v.j.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ScreenShotShareData implements JsonInterface {
    private static final long serialVersionUID = -8073626831332456446L;
    public String sc;
    public String sf;

    public ScreenShotShareData(String str, String str2) {
        this.sc = str;
        this.sf = str2;
    }

    public String toString() {
        return b.F(this, ScreenShotClickData.class);
    }
}
