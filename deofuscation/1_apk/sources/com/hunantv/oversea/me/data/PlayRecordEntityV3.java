package com.hunantv.oversea.me.data;

import android.text.TextUtils;
import com.hunantv.imgo.entity.JsonEntity;
import com.mgtv.json.JsonInterface;
import java.util.List;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class PlayRecordEntityV3 extends JsonEntity implements JsonInterface {
    private static final long serialVersionUID = -8637335759134194512L;
    public DataEntity data;
    public String seqId;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class CategoryListEntity implements JsonInterface {
        private static final long serialVersionUID = -3558563744852986860L;
        public long gt;
        public int lt;
        public String name;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class DataEntity implements JsonInterface {
        private static final long serialVersionUID = -1897033950279925908L;
        public List<CategoryListEntity> categoryList;
        public int hasNext;
        public int isFilter;
        public long lastRecondTime;
        public List<PlayListEntity> playList;
        public int sync;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class PlayListEntity implements JsonInterface {
        private static final long serialVersionUID = 2829136426342436795L;
        public int contentType;
        public int duration;
        public int from;
        public String fstlvlName;
        public int isEnd;
        public int nextVid;
        public String online;
        public String pImage;
        public String pName;
        public int pType;
        public int pid;
        public long playId;
        public int point;
        public String serialno;
        public int showMode;
        public String totalNumber;
        public String updateInfo;
        public long updateTime;
        public String vImage;
        public String vName;
        public int vid;
        public int videoType;
        public int watchTime;

        public boolean isWatchOnlyOTT() {
            return !TextUtils.isEmpty(this.online) && this.online.length() > 1 && "0".equals(this.online.substring(0, 1));
        }
    }
}
