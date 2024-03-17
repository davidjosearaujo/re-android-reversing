package com.hunantv.oversea.channel.dynamic.render.entity;

import com.mgtv.json.JsonInterface;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DynamicLiveEventEntity implements JsonInterface {
    public List<Data> items;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class Data implements JsonInterface {
        public String activityId;
        public String ctid;
        public String date;
        public String id;
        public boolean isSubscribed;
        public String jumpUrl;
        public String name;
        public int solt;
        public String subName;
        public String time;
    }
}
