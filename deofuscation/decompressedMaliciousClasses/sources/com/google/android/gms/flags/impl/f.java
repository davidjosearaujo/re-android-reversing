package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import b.a.a.a.e.t0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class f extends a<Long> {
    private static short[] $ = {2724, 2702, 2691, 2693, 2754, 2708, 2691, 2702, 2711, 2695, 2754, 2700, 2701, 2710, 2754, 2691, 2708, 2691, 2699, 2702, 2691, 2688, 2702, 2695, 2766, 2754, 2704, 2695, 2710, 2711, 2704, 2700, 2699, 2700, 2693, 2754, 2694, 2695, 2692, 2691, 2711, 2702, 2710, 2776, 2754, 48, 26, 23, 17, 50, 23, 2, 23, 35, 2, 31, 26, 5};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Long a(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) t0.a(new g(sharedPreferences, str, l));
        } catch (Exception e) {
            String $2 = $(0, 45, 2786);
            String valueOf = String.valueOf(e.getMessage());
            Log.w($(45, 58, 118), valueOf.length() != 0 ? $2.concat(valueOf) : new String($2));
            return l;
        }
    }
}
