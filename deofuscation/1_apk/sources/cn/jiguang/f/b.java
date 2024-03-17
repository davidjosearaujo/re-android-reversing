package cn.jiguang.f;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static final Object b = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> c = new ConcurrentHashMap<>();
    public static String a = "yyyyMMdd_HHmm";

    /* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
    public static class a extends ThreadLocal<SimpleDateFormat> {
        private String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.a, Locale.ENGLISH);
        }
    }

    public static String a() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = c.get(str);
        if (threadLocal == null) {
            synchronized (b) {
                threadLocal = c.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static boolean a(Date date, int i) {
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date.getTime());
        calendar.roll(6, -i);
        return calendar.after(calendar2);
    }

    public static String b() {
        return a(a).format(new Date());
    }

    public static Date b(String str) {
        try {
            return a(a).parse(str);
        } catch (ParseException e) {
            cn.jiguang.ar.c.c("DateUtil", "parse filename datetime error - " + str, e);
            return null;
        }
    }
}
