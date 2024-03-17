package com.hunantv.mpdt.data;

import com.mgtv.json.JsonInterface;
import j.v.j.b;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class ScreenShotClickData implements JsonInterface {
    private static final long serialVersionUID = -919607520455933673L;
    public String bdid;
    public String bsid;
    public String cid;
    public String plid;
    public String vid;

    public String toString() {
        return b.F(this, ScreenShotClickData.class);
    }
}
