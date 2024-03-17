package cn.com.custommma.mobile.tracking.util;

import java.util.Calendar;

/* loaded from: /home/davidjosearaujo/Documents/mc/first-year/second-semester/RE/P/re-android-reversing/deofuscation/1_apk/classes.dex */
public class DateUtil {
    public static int getTimesMonthmorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(5, calendar.getActualMinimum(5));
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getTimesMonthnight() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 24);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getTimesWeekmorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(7, 2);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getTimesWeeknight() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(7, 2);
        return (int) ((calendar.getTime().getTime() + 604800000) / 1000);
    }

    public static int getTimesmorning() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getTimesnight() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 24);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static boolean isBetweenOneDay(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long time = calendar.getTime().getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(calendar2.get(1), calendar2.get(2), calendar2.get(5), 0, 0, 0);
        calendar2.set(11, 23);
        calendar2.set(12, 59);
        calendar2.set(13, 59);
        return j >= time && j < calendar2.getTime().getTime();
    }
}
