package com.hunantv.oversea.channel.dynamic.style.xml;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MixedDynamicStyleResponse extends JsonEntity implements JsonInterface {
    public List<DSLEntity> data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DSLEntity implements JsonInterface {
        public String dslXml;
        public String formatType;
        public String layoutID;
        public String ver;
    }
}
