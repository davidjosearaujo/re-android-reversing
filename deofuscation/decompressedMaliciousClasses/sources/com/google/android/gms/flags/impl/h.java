package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import b.a.a.a.e.t0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class h extends a<String> {
    private static short[] $ = {6117, 6095, 6082, 6084, 6019, 6101, 6082, 6095, 6102, 6086, 6019, 6093, 6092, 6103, 6019, 6082, 6101, 6082, 6090, 6095, 6082, 6081, 6095, 6086, 6031, 6019, 6097, 6086, 6103, 6102, 6097, 6093, 6090, 6093, 6084, 6019, 6087, 6086, 6085, 6082, 6102, 6095, 6103, 6041, 6019, 8921, 8947, 8958, 8952, 8923, 8958, 8939, 8958, 8906, 8939, 8950, 8947, 8940};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) t0.a(new i(sharedPreferences, str, str2));
        } catch (Exception e) {
            String $2 = $(0, 45, 6051);
            String valueOf = String.valueOf(e.getMessage());
            Log.w($(45, 58, 8863), valueOf.length() != 0 ? $2.concat(valueOf) : new String($2));
            return str2;
        }
    }
}
