package com.hunantv.oversea.me.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MessagePollEntity extends JsonEntity implements JsonInterface {
    private static final long serialVersionUID = 8092437439473384025L;
    public DataBean data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class DataBean implements JsonInterface {
        private static final long serialVersionUID = 3512738816942239933L;
        public int interval;
        public List<MessageType> messageList;
        public int total;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class MessageType implements JsonInterface {
            private static final long serialVersionUID = -1443096509772492845L;
            public String messageType;
            public int unread;
        }
    }
}
