package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import linc.com.amplituda.ErrorCode;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a */
    public static AtomicReference<d0> f3065a = new AtomicReference<>();

    public static long a(long j5) {
        Calendar e = e(null);
        e.setTimeInMillis(j5);
        return c(e).getTimeInMillis();
    }

    @TargetApi(ErrorCode.INVALID_AUDIO_URL_IO_CODE)
    public static DateFormat b(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    public static Calendar c(Calendar calendar) {
        Calendar e = e(calendar);
        Calendar e7 = e(null);
        e7.set(e.get(1), e.get(2), e.get(5));
        return e7;
    }

    public static Calendar d() {
        d0 d0Var = f3065a.get();
        if (d0Var == null) {
            d0Var = d0.f3061c;
        }
        java.util.TimeZone timeZone = d0Var.f3063b;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l6 = d0Var.f3062a;
        if (l6 != null) {
            calendar.setTimeInMillis(l6.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return calendar;
    }

    public static Calendar e(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
