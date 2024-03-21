package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import b.a.a.a.e.t0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class d extends a<Integer> {
    private static short[] $ = {9348, 9390, 9379, 9381, 9442, 9396, 9379, 9390, 9399, 9383, 9442, 9388, 9389, 9398, 9442, 9379, 9396, 9379, 9387, 9390, 9379, 9376, 9390, 9383, 9454, 9442, 9392, 9383, 9398, 9399, 9392, 9388, 9387, 9388, 9381, 9442, 9382, 9383, 9380, 9379, 9399, 9390, 9398, 9464, 9442, 5033, 4995, 5006, 5000, 5035, 5006, 5019, 5006, 5050, 5019, 4998, 4995, 5020};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) t0.a(new e(sharedPreferences, str, num));
        } catch (Exception e) {
            String $2 = $(0, 45, 9410);
            String valueOf = String.valueOf(e.getMessage());
            Log.w($(45, 58, 5103), valueOf.length() != 0 ? $2.concat(valueOf) : new String($2));
            return num;
        }
    }
}
