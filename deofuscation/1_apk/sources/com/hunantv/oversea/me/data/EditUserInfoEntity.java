package com.hunantv.oversea.me.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class EditUserInfoEntity extends JsonEntity {
    private static final long serialVersionUID = -9154523800028390331L;
    public DataBean data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements JsonInterface {
        private static final long serialVersionUID = -5806687461095918356L;
        public String l;
        public String m;
        public String operation;
        public String s;
        public String xl;
    }
}
