package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import b.a.a.a.e.t0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b extends a<Boolean> {
    private static short[] $ = {1533, 1495, 1498, 1500, 1435, 1485, 1498, 1495, 1486, 1502, 1435, 1493, 1492, 1487, 1435, 1498, 1485, 1498, 1490, 1495, 1498, 1497, 1495, 1502, 1431, 1435, 1481, 1502, 1487, 1486, 1481, 1493, 1490, 1493, 1500, 1435, 1503, 1502, 1501, 1498, 1486, 1495, 1487, 1409, 1435, 4790, 4764, 4753, 4759, 4788, 4753, 4740, 4753, 4773, 4740, 4761, 4764, 4739};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) t0.a(new c(sharedPreferences, str, bool));
        } catch (Exception e) {
            String $2 = $(0, 45, 1467);
            String valueOf = String.valueOf(e.getMessage());
            Log.w($(45, 58, 4848), valueOf.length() != 0 ? $2.concat(valueOf) : new String($2));
            return bool;
        }
    }
}
