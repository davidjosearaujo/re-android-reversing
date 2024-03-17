package com.hunantv.oversea.me.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import j.l.c.k.e.j;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class MessageGetListNoticeEntity extends JsonEntity implements j {
    private static final long serialVersionUID = -6598753132450280997L;
    public DataEntity data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class DataEntity implements JsonInterface {
        private static final long serialVersionUID = 2753174992097391530L;
        public List<MessageEntity> messageList;
        public int page;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static final class MessageEntity implements JsonInterface {
            private static final long serialVersionUID = 3761978572178296818L;
            public String content;
            public String img;
            public String link;
            public int linkType;
            public int messageId;
            public byte readStatus;
            public long sendTime;
            public int source;
            public String title;
        }
    }

    public int getPage() {
        DataEntity dataEntity = this.data;
        if (dataEntity == null) {
            return 0;
        }
        return dataEntity.page;
    }

    public boolean isEmpty() {
        DataEntity dataEntity = this.data;
        return dataEntity == null || j.l.a.b0.j.a(dataEntity.messageList);
    }
}
