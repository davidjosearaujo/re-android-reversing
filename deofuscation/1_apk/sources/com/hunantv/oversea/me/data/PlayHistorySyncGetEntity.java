package com.hunantv.oversea.me.data;

import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class PlayHistorySyncGetEntity extends JsonEntity {
    public static final int SYNC_OFF = 0;
    public static final int SYNC_ON = 1;
    private static final long serialVersionUID = 7151900536388158226L;
    public DataEntity data;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class DataEntity implements JsonInterface {
        private static final long serialVersionUID = 7914938741707219978L;
        public int sync;

        public boolean isSyncOn() {
            return 1 == this.sync;
        }
    }
}
