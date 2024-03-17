package com.hunantv.imgo.log;

import androidx.annotation.Nullable;
import com.hunantv.mpdt.data.EventClickData;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class MLog extends j.l.a.n.m.a {

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a {
        public static final String A = "280";
        public static final String B = "290";
        public static final String C = "300";
        public static final String a = "0";
        public static final String b = "00";
        public static final String c = "10";
        public static final String d = "11";
        public static final String e = "12";
        public static final String f = "20";
        public static final String g = "30";
        public static final String h = "40";
        public static final String i = "50";
        public static final String j = "60";
        public static final String k = "70";
        public static final String l = "80";
        public static final String m = "90";
        public static final String n = "100";
        public static final String o = "110";
        public static final String p = "120";
        private static final String q = "130";
        public static final String r = "140";
        public static final String s = "150";
        public static final String t = "160";
        public static final String u = "170";
        public static final String v = "190";
        public static final String w = "180";
        public static final String x = "250";
        public static final String y = "260";
        public static final String z = "270";

        /* renamed from: com.hunantv.imgo.log.MLog$a$a  reason: collision with other inner class name */
        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class C0045a {
            public static final String a = "[Application启动] 次数(%1$s) 是否首次";
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class b extends a {
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class c extends a {
        private static boolean D = true;

        public static void a(@Nullable String str, @Nullable String str2) {
            if (D) {
                j.l.a.n.m.a.log_e("110", str, str2);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class d {
        public static final String a = "[播放失败]";
        public static final String b = "[视频用户已下载]";
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class e extends a {
        private static boolean D = true;

        /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
        public static class a {
            public static final String a = "=== 无任何离线缓存 ===";
            public static final String b = "[储存空间状态: %1$s / %2$s]";
            public static final String c = "[离线下载列表页-展示] FromVOD(%1$s) TYPE(%2$s) RID(%3$s) VID(%4$s) INDEX(%5$s)";
            public static final String d = "[离线下载列表页-关闭]";
            public static final String e = "[离线下载列表页-添加任务] VID(%1$s) Name(%2$s) Definition(%3$s) Path(%4$s) FileSize(%5$s) MediaType(%6$s) 允许流量下载(%7$s)";
            public static final String f = "[离线下载列表页-删除任务] VID(%1$s) Name(%2$s) Path(%3$s) MediaType(%4$s)";
            public static final String g = "允许非 WIFI 下离线缓存设置 - (%1$s)";
            public static final String h = "[用户状态] 登录(%1$s)";
            public static final String i = "[用户状态] VIP(%1$s) UUID(%2$s) TICKET(%3$s)";
            public static final String j = "[%1$s] Operation(%2$s) VideoId(%3$s) Name(%4$s) MediaType(%5$s) Status(%6$s) Size(%7$s) Speed(%8$s) NetworkType(%9$s) Message(%10$s) Path(%11$s)";
            public static final String k = "[Download-Network-Changed] NetworkType(%1$s)";
            public static final String l = "[Download-Exception] Message(%1$s)";
            public static final String m = "[Download-Uninitialized] DownloadSDK uninitialized: Position(%1$s)";
        }

        public static final boolean a() {
            return D;
        }

        public static void b(@Nullable String str, @Nullable String str2) {
            if (D) {
                j.l.a.n.m.a.log_e("20", str, str2);
            }
        }

        public static void c(@Nullable String str, @Nullable String str2) {
            if (D) {
                j.l.a.n.m.a.log_i("20", str, str2);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class f extends a {
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class g extends a {
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class h extends a {
        private static boolean D = true;

        public static void a(@Nullable String str, @Nullable String str2) {
            if (D) {
                j.l.a.n.m.a.log_i("100", str, str2);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static final class i extends a {
        public static final String D = "[UPDATE] %1$s";
        private static boolean E = true;

        public static void a(String str, String str2) {
            if (E) {
                j.l.a.n.m.a.log_e(EventClickData.i.Z0, str, str2);
            }
        }
    }

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class j extends a {
    }
}
