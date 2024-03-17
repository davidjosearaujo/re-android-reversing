package com.hunantv.oversea.me.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class CollectUpdateInfoEntity extends JsonEntity {
    private static final long serialVersionUID = -9157417905164226150L;
    public Data data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Data implements JsonInterface {
        private static final long serialVersionUID = 3980481436962514565L;
        public String info;
        public int type;
    }
}
