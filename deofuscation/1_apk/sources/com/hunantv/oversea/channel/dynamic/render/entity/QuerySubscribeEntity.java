package com.hunantv.oversea.channel.dynamic.render.entity;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import java.io.Serializable;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class QuerySubscribeEntity extends JsonEntity implements Serializable, JsonInterface {
    private static final long serialVersionUID = -7469131588992641646L;
    public List<DataBean> data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements JsonInterface {
        private static final long serialVersionUID = -4321082091260755337L;
        public String aid;
        public String type;
    }
}
