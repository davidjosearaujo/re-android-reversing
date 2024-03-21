package com.google.android.gms.common.util;

import android.content.Context;
import b.a.a.a.e.p0;
/* loaded from: /home/remnux/decompressedMalicious.dex */
public final class b {
    private static short[] $ = {914, 926, 924, 991, 918, 926, 926, 918, 925, 916, 991, 912, 927, 917, 899, 926, 920, 917, 991, 918, 924, 898};

    private static String $(int i, int i2, int i3) {
        char[] cArr = new char[i2 - i];
        for (int i4 = 0; i4 < i2 - i; i4++) {
            cArr[i4] = (char) ($[i + i4] ^ i3);
        }
        return new String(cArr);
    }

    public static boolean a(Context context, String str) {
        $(0, 22, 1009).equals(str);
        return (p0.b(context).a(str, 0).flags & 2097152) != 0;
    }
}
