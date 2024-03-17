package cn.jpush.android.ac;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class b {
    private static final Object a = new Object();
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> b = new ConcurrentHashMap<>();

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

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = b.get(str);
        if (threadLocal == null) {
            synchronized (a) {
                threadLocal = b.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    b.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static boolean a(long j, long j2) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            Long valueOf = Long.valueOf(j);
            Long valueOf2 = Long.valueOf(j2);
            String format = simpleDateFormat.format(valueOf);
            String format2 = simpleDateFormat2.format(valueOf2);
            Date parse = simpleDateFormat.parse(format);
            Date parse2 = simpleDateFormat2.parse(format2);
            calendar.setTime(parse);
            calendar2.setTime(parse2);
            if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1)) {
                return calendar.get(6) == calendar2.get(6);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return a("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}
