package com.hunantv.mpdt.data;

import androidx.annotation.Nullable;
import com.mgtv.json.JsonInterface;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public final class FeedValue implements JsonInterface {
    private static final long serialVersionUID = -3289293396372917101L;
    public String aid;
    public int cpn;
    public int evt;
    public String fid;
    public int rn;
    public int tid;
    public int typ;

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class b {
        public static final int a = 1;
        public static final int b = 2;
    }

    public FeedValue(int i, int i2, String str, String str2, int i3, int i4, int i5) {
        this.cpn = i;
        this.evt = i2;
        this.fid = str;
        this.aid = str2;
        this.typ = i3;
        this.tid = i4;
        this.rn = i5;
    }

    @Nullable
    public String getFID() {
        return this.fid;
    }
}
